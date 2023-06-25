package IU;

import Componentes.ConexionBD;
import Componentes.DecimalFormatRenderer;
import Componentes.Fecha;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.RenderDecimal;
import Componentes.RenderDecimal2;
import Componentes.Reporte;
import Componentes.Software;
import Componentes.generarCodigos;
import Componentes.validarCampos;
import Componentes.PrinterService;
import Controladores.CabecerasTablas;
import Controladores.controlFactura;
import Datos.GestionarArticulos;
import Datos.GestionarFactura;
import Datos.GestionarVendedor;
import java.awt.event.KeyEvent;
import Modelo.Articulo;
import Modelo.Vendedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;

public final class dlgVentas extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();

    public static MariaDbConnection con;
    public static MariaDbStatement stTransaccion;
    //public static MariaDbStatement st;
    //public static ResultSet rss;
    public static int PrecioVenta;
    public static double costoiva;
    public static double descuento;
    public static String UsuarioL = "";
    public Reporte jasper;
    static String emp;
    static String dir;
    static String cel;

    public dlgVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        //prepararBD();
        jasper= new Reporte();
        cabe.ventas(tbDetalle);
        Cancelar();
        pintarCondicion();
        Invisible();
        Rendes();
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Venta de artículos");
        }else{
            this.setTitle(Software.getSoftware()+" - Venta de artículos");
        }
    }

    public void Cancelar() {
        limpiarCampos();
        //dcFecha.setEnabled(false);
        btnProveedor.setEnabled(false);
        rContado.setEnabled(false);
        rContado.setSelected(true);
        rCredito.setEnabled(false);
        btnBuscarArticulo.setEnabled(false);
        txtCant.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnNuevo.requestFocus();
        itemNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        itemCancelar.setEnabled(false);
        itemBuscarA.setEnabled(false);
        itemBuscarC.setEnabled(false);
        itemQuitar.setEnabled(false);
        btnSalir.setEnabled(true);
        cant();
    }

    public void Rendes() {
        //dlgVentas.tbDetalle.getColumnModel().getColumn(3).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(5).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(7).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(9).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(11).setCellRenderer(new DecimalFormatRenderer());
        dlgVentas.tbDetalle.getColumnModel().getColumn(13).setCellRenderer(new RenderDecimal());
        dlgVentas.tbDetalle.getColumnModel().getColumn(16).setCellRenderer(new RenderDecimal2());
        dlgVentas.tbDetalle.getColumnModel().getColumn(18).setCellRenderer(new RenderDecimal2());
    }

    public void Invisible() {
        btnAdd.setVisible(false);
        btnRestar.setVisible(false);
        lbCond.setVisible(false);
        txtTotalL.setVisible(false);
        lbCred.setVisible(false);
        txtExentaL.setVisible(false);
        txt5L.setVisible(false);
        txt10L.setVisible(false);
        txtNetoL.setVisible(false);
        txtDescuentoL.setVisible(false);
        txtCodArticulo.setVisible(false);
        txtCodCliente.setVisible(false);
        btnModCantidad.setVisible(false);
        txtdisponibleL.setVisible(false);
        lbPublic.setVisible(false);
        panelD.setVisible(false);
    }

    public static void prepararBD() {
        try {
            con = (MariaDbConnection) new ConexionBD().getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                stTransaccion = (MariaDbStatement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cant() {
        int total = tbDetalle.getRowCount();
        etiCant.setText("ITEM A FACTURAR: " + String.valueOf(total));
    }

    private void pintarCondicion() {
        if (rContado.isSelected()) {
            rContado.setFont(new java.awt.Font("Tahoma", 1, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 51));
            rCredito.setFont(new java.awt.Font("Tahoma", 0, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 0));
            lbCond.setText("CONTADO");
        } else {
            rContado.setFont(new java.awt.Font("Tahoma", 0, 11));
            rContado.setForeground(new java.awt.Color(0, 0, 0));
            rCredito.setFont(new java.awt.Font("Tahoma", 1, 11));
            rCredito.setForeground(new java.awt.Color(0, 0, 51));
            lbCond.setText("CREDITO");
        }
    }

    private void limpiarCampos() {
        txtCod.setText("");
        txtCodFactura.setText("");
        txtFecha.setText("");
        txtCodFactura.setText("");
        txtCodCliente.setText("");
        txtRuc.setText("");
        txtRazonS.setText("");
        rContado.isSelected();
        txtTotalL.setText("0");
        txtTotal.setText("0");
        txtArt.setText("");
        txtCant.setText("");
        txtExenta.setText("0");
        txtExentaL.setText("0");
        txt5L.setText("0");
        txt5.setText("0");
        txt10L.setText("0");
        txt10.setText("0");
        txtNetoL.setText("0");
        txtNeto.setText("0");
        txtDescuentoL.setText("0");
        txtDescuento.setText("0");
        lbCond.setText("");
        lbPVenta.setText("");
        lbPublic.setText("");
        txtCaja.setText("");
        txtTC.setText("");
        rContado.setSelected(true);
        CabecerasTablas.limpiarTablas(tbDetalle);
        cabe.ventas(tbDetalle);
        controlFactura.canCelar();
        txtCodVendedor.setText("");
        lbEmpleado.setText("");
        txthabilitado.setText("");
        txtdisponible.setText("");
    }

    public static void habilitarCANTCOSTO() {
        if (txtArt.getText().isEmpty()) {
            txtCant.setEnabled(false);
        } else {
            txtCant.setEnabled(true);
        }
    }
   /* public static void imprimirTicketO() {

        try {

            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();

            e.setNumber(20.30);
            //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            int filas = tbDetalle.getRowCount();
            int tamaño = filas+40;
            printer.setOutSize(tamaño, 80);

            //Imprimir = 1ra linea de la columa de 1 a 32
            printer.printTextWrap(0, 1, 3, 40, "========================================");
            printer.printTextWrap(1, 1, 32, 80, "FARMAMILI"); //NOMBRE EMPRESA
            printer.printTextWrap(3, 1, 28, 80, "de Alfonso Avalos Gimenez."); //PROPIETARIO
            printer.printTextWrap(4, 1, 16, 80, "Jose M. A. Godoy c/ Las Residentas - (0971) 799 004"); //DIRECCION
            printer.printTextWrap(5, 1, 3, 80, "_____________________________________________________________________________");
            printer.printTextWrap(6, 1, 3, 80, "FECHA: " + Fecha.fechaCorrecta() + " " + Fecha.darHora()); //FECHA Y HORA
            printer.printTextWrap(6, 1, 65, 80, lbCond.getText()); //CONDICION DE VENTA
            printer.printTextWrap(7, 1, 3, 80, "TICKET N°: " + txtCodFactura.getText()); //FACTURA O PEDIDO
            printer.printTextWrap(7, 1, 65, 80, "CAJA N°: " + txtCaja.getText()); //CAJA
            printer.printTextWrap(8, 1, 3, 80, "VENDEDOR: " + lbEmpleado.getText()); //VENDEDOR
            printer.printTextWrap(9, 1, 3, 80, "CLIENTE: " + txtRuc.getText() + " / " + txtRazonS.getText());//RUC Y RS
            printer.printTextWrap(10, 1, 3, 80, "_____________________________________________________________________________");
            printer.printTextWrap(11, 1, 3, 80, "DESCRIPCION                            CANT  P.PUBL  %DESC  P.UNIT   TOTAL");
            printer.printTextWrap(12, 1, 0, 80, " ");

            for (int i = 0; i < filas; i++) {
                int p = 13 + i; //Fila
                DecimalFormat formateador = new DecimalFormat("#,###");
                String DES = printer.alinharADireita(10, tbDetalle.getValueAt(i, 2).toString());
                String Cant = tbDetalle.getValueAt(i, 3).toString();
                String Ppublic = tbDetalle.getValueAt(i, 17).toString();
                String Desc = tbDetalle.getValueAt(i, 16).toString();
                String Punit = tbDetalle.getValueAt(i, 5).toString();
                String Mont = tbDetalle.getValueAt(i, 13).toString();
                printer.printTextWrap(p, 1, 3, 40, DES);
                printer.printTextWrap(p, 1, 43, 46, formateador.format(Integer.parseInt(Cant.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 48, 57, formateador.format(Integer.parseInt(Ppublic.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 58, 62, formateador.format(Integer.parseInt(Desc.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 64, 71, formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 72, 80, formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))));

            }

            printer.printTextWrap(filas + 17, 1, 3, 80, "-----------------------------------------------------------------------------");

            DecimalFormat formateador = new DecimalFormat("#,###");
            String tot = printer.alinharADireita(10, formateador.format(Integer.parseInt(txtTotalL.getText().replace(".", "").replace(",", ""))));
            printer.printTextWrap(filas + 18, 1, 3, 20, "TOTAL A PAGAR:");
            printer.printTextWrap(filas + 18, 1, 67, 80, (tot));
            printer.printTextWrap(filas + 19, 1, 3, 80, "-----------------------------------------------------------------------------");
            String efe = printer.alinharADireita(10, txtAbono.getText());
            printer.printTextWrap(filas + 20, 1, 3, 80, "EFECTIVO : ");
            printer.printTextWrap(filas + 20, 1, 20, 80, efe);

            String cam = printer.alinharADireita(10, txtVuelto.getText());
            printer.printTextWrap(filas + 21, 1, 3, 80, "VUELTO   : ");
            printer.printTextWrap(filas + 21, 1, 20, 80, cam);

            printer.printTextWrap(filas + 22, 1, 3, 80, "=============================================================================");
            printer.printTextWrap(filas + 23, 1, 27, 80, "!GRACIAS POR SU PREFERENCIA!");
            printer.printTextWrap(filas + 26, 1, 12, 80, "E-FARM - v1.2.1 - Software Integral de Gestión Farmacéutica");
            printer.printTextWrap(filas + 27, 1, 3, 80, "=============================================================================");

            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            //printer.toFile("C:\\tmp\\impresion.txt");
            printer.toFile("impresion.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("impresion.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            if (inputStream == null) {
                return;
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(document, attributeSet);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.err.println("No existen impresoras instaladas");
            }

            inputStream.close();
            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir " + e);
        }
    }
*/
    
    // ticketera mtu matricial
    /*public static void imprimirTicket() {

        try {
            try {
                String sql = "select em_razonsocial, em_direccion, em_celular from empresa where em_indicador='S'";
                st = (MariaDbStatement) con.createStatement();
                rss = st.executeQuery(sql);
                try{
                    rss.first();
                    emp=rss.getString(1);
                    dir=rss.getString(2);
                    cel=rss.getString(3);
                } catch (SQLException e) {
                }
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();

            e.setNumber(1);
            //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
            int filas = tbDetalle.getRowCount();
            int tamaño = filas+15;
            printer.setOutSize(tamaño, 80);

            //Imprimir = 1ra linea de la columa de 1 a 32
            //printer.printTextWrap(0, 1, 15, 24, "FARMAMILI"); //NOMBRE EMPRESA
            switch (emp.length()) {
                case 1 -> printer.printTextWrap(0, 1, 20, 40, emp); //NOMBRE EMPRESA
                case 2 -> printer.printTextWrap(0, 1, 19, 40, emp); //NOMBRE EMPRESA
                case 3 -> printer.printTextWrap(0, 1, 19, 40, emp); //NOMBRE EMPRESA
                case 4 -> printer.printTextWrap(0, 1, 18, 40, emp); //NOMBRE EMPRESA
                case 5 -> printer.printTextWrap(0, 1, 18, 40, emp); //NOMBRE EMPRESA
                case 6 -> printer.printTextWrap(0, 1, 17, 40, emp); //NOMBRE EMPRESA
                case 7 -> printer.printTextWrap(0, 1, 17, 40, emp); //NOMBRE EMPRESA
                case 8 -> printer.printTextWrap(0, 1, 16, 40, emp); //NOMBRE EMPRESA
                case 9 -> printer.printTextWrap(0, 1, 16, 40, emp); //NOMBRE EMPRESA
                case 10 -> printer.printTextWrap(0, 1, 15, 40, emp); //NOMBRE EMPRESA
                case 11 -> printer.printTextWrap(0, 1, 15, 40, emp); //NOMBRE EMPRESA
                case 12 -> printer.printTextWrap(0, 1, 14, 40, emp); //NOMBRE EMPRESA
                case 13 -> printer.printTextWrap(0, 1, 14, 40, emp); //NOMBRE EMPRESA
                case 14 -> printer.printTextWrap(0, 1, 13, 40, emp); //NOMBRE EMPRESA
                case 15 -> printer.printTextWrap(0, 1, 13, 40, emp); //NOMBRE EMPRESA
                case 16 -> printer.printTextWrap(0, 1, 12, 40, emp); //NOMBRE EMPRESA
                case 17 -> printer.printTextWrap(0, 1, 12, 40, emp); //NOMBRE EMPRESA
                case 18 -> printer.printTextWrap(0, 1, 11, 40, emp); //NOMBRE EMPRESA
                case 19 -> printer.printTextWrap(0, 1, 11, 40, emp); //NOMBRE EMPRESA
                case 20 -> printer.printTextWrap(0, 1, 10, 40, emp); //NOMBRE EMPRESA
                case 21 -> printer.printTextWrap(0, 1, 10, 40, emp); //NOMBRE EMPRESA
                case 22 -> printer.printTextWrap(0, 1, 9, 40, emp); //NOMBRE EMPRESA
                case 23 -> printer.printTextWrap(0, 1, 9, 40, emp); //NOMBRE EMPRESA
                case 24 -> printer.printTextWrap(0, 1, 8, 40, emp); //NOMBRE EMPRESA
                case 25 -> printer.printTextWrap(0, 1, 8, 40, emp); //NOMBRE EMPRESA
                case 26 -> printer.printTextWrap(0, 1, 7, 40, emp); //NOMBRE EMPRESA
                case 27 -> printer.printTextWrap(0, 1, 7, 40, emp); //NOMBRE EMPRESA
                case 28 -> printer.printTextWrap(0, 1, 6, 40, emp); //NOMBRE EMPRESA
                case 29 -> printer.printTextWrap(0, 1, 6, 40, emp); //NOMBRE EMPRESA
                case 30 -> printer.printTextWrap(0, 1, 5, 40, emp); //NOMBRE EMPRESA
                case 31 -> printer.printTextWrap(0, 1, 5, 40, emp); //NOMBRE EMPRESA
                case 32 -> printer.printTextWrap(0, 1, 4, 40, emp); //NOMBRE EMPRESA
                case 33 -> printer.printTextWrap(0, 1, 4, 40, emp); //NOMBRE EMPRESA
                case 34 -> printer.printTextWrap(0, 1, 3, 40, emp); //NOMBRE EMPRESA
                case 35 -> printer.printTextWrap(0, 1, 3, 40, emp); //NOMBRE EMPRESA
                case 36 -> printer.printTextWrap(0, 1, 2, 40, emp); //NOMBRE EMPRESA
                case 37 -> printer.printTextWrap(0, 1, 2, 40, emp); //NOMBRE EMPRESA
                case 38 -> printer.printTextWrap(0, 1, 1, 40, emp); //NOMBRE EMPRESA
                case 39 -> printer.printTextWrap(0, 1, 1, 40, emp); //NOMBRE EMPRESA
            }
            //printer.printTextWrap(0, 1, 15, 40, emp); //NOMBRE EMPRESA
            printer.printTextWrap(0, 1, 41, 80, "_______________________________________"); //PROPIETARIO
            //printer.printTextWrap(1, 1, 3, 37, "Jose M. A. Godoy c/ Las Residentas"); //DIRECCION
            switch (dir.length()) {
                case 1 -> printer.printTextWrap(1, 1, 20, 40, dir); //NOMBRE EMPRESA
                case 2 -> printer.printTextWrap(1, 1, 19, 40, dir); //NOMBRE EMPRESA
                case 3 -> printer.printTextWrap(1, 1, 19, 40, dir); //NOMBRE EMPRESA
                case 4 -> printer.printTextWrap(1, 1, 18, 40, dir); //NOMBRE EMPRESA
                case 5 -> printer.printTextWrap(1, 1, 18, 40, dir); //NOMBRE EMPRESA
                case 6 -> printer.printTextWrap(1, 1, 17, 40, dir); //NOMBRE EMPRESA
                case 7 -> printer.printTextWrap(1, 1, 17, 40, dir); //NOMBRE EMPRESA
                case 8 -> printer.printTextWrap(1, 1, 16, 40, dir); //NOMBRE EMPRESA
                case 9 -> printer.printTextWrap(1, 1, 16, 40, dir); //NOMBRE EMPRESA
                case 10 -> printer.printTextWrap(1, 1, 15, 40, dir); //NOMBRE EMPRESA
                case 11 -> printer.printTextWrap(1, 1, 15, 40, dir); //NOMBRE EMPRESA
                case 12 -> printer.printTextWrap(1, 1, 14, 40, dir); //NOMBRE EMPRESA
                case 13 -> printer.printTextWrap(1, 1, 14, 40, dir); //NOMBRE EMPRESA
                case 14 -> printer.printTextWrap(1, 1, 13, 40, dir); //NOMBRE EMPRESA
                case 15 -> printer.printTextWrap(1, 1, 13, 40, dir); //NOMBRE EMPRESA
                case 16 -> printer.printTextWrap(1, 1, 12, 40, dir); //NOMBRE EMPRESA
                case 17 -> printer.printTextWrap(1, 1, 12, 40, dir); //NOMBRE EMPRESA
                case 18 -> printer.printTextWrap(1, 1, 11, 40, dir); //NOMBRE EMPRESA
                case 19 -> printer.printTextWrap(1, 1, 11, 40, dir); //NOMBRE EMPRESA
                case 20 -> printer.printTextWrap(1, 1, 10, 40, dir); //NOMBRE EMPRESA
                case 21 -> printer.printTextWrap(1, 1, 10, 40, dir); //NOMBRE EMPRESA
                case 22 -> printer.printTextWrap(1, 1, 9, 40, dir); //NOMBRE EMPRESA
                case 23 -> printer.printTextWrap(1, 1, 9, 40, dir); //NOMBRE EMPRESA
                case 24 -> printer.printTextWrap(1, 1, 8, 40, dir); //NOMBRE EMPRESA
                case 25 -> printer.printTextWrap(1, 1, 8, 40, dir); //NOMBRE EMPRESA
                case 26 -> printer.printTextWrap(1, 1, 7, 40, dir); //NOMBRE EMPRESA
                case 27 -> printer.printTextWrap(1, 1, 7, 40, dir); //NOMBRE EMPRESA
                case 28 -> printer.printTextWrap(1, 1, 6, 40, dir); //NOMBRE EMPRESA
                case 29 -> printer.printTextWrap(1, 1, 6, 40, dir); //NOMBRE EMPRESA
                case 30 -> printer.printTextWrap(1, 1, 5, 40, dir); //NOMBRE EMPRESA
                case 31 -> printer.printTextWrap(1, 1, 5, 40, dir); //NOMBRE EMPRESA
                case 32 -> printer.printTextWrap(1, 1, 4, 40, dir); //NOMBRE EMPRESA
                case 33 -> printer.printTextWrap(1, 1, 4, 40, dir); //NOMBRE EMPRESA
                case 34 -> printer.printTextWrap(1, 1, 3, 40, dir); //NOMBRE EMPRESA
                case 35 -> printer.printTextWrap(1, 1, 3, 40, dir); //NOMBRE EMPRESA
                case 36 -> printer.printTextWrap(1, 1, 2, 40, dir); //NOMBRE EMPRESA
                case 37 -> printer.printTextWrap(1, 1, 2, 40, dir); //NOMBRE EMPRESA
                case 38 -> printer.printTextWrap(1, 1, 1, 40, dir); //NOMBRE EMPRESA
                case 39 -> printer.printTextWrap(1, 1, 1, 40, dir); //NOMBRE EMPRESA
            }
            //printer.printTextWrap(1, 1, 3, 37, dir); //DIRECCION
            //printer.printTextWrap(1, 1, 43, 73, "Cel:(0981) 700 414"); //DIRECCION
            printer.printTextWrap(1, 1, 43, 73, "Cel:"+cel); //DIRECCION
            printer.printTextWrap(2, 1, 1, 40, "________________________________________");
            printer.printTextWrap(2, 1, 41, 67, "FECHA: " + txtFecha.getText() + " " + Fecha.darHora()); //FECHA Y HORA
            printer.printTextWrap(2, 1, 71, 78, lbCond.getText()); //CONDICION DE VENTA
            printer.printTextWrap(3, 1, 1, 24, "TICKET N: " +txtTC.getText()+""+txtCodFactura.getText()); //FACTURA O PEDIDO
            printer.printTextWrap(3, 1, 26, 37, "CAJA N: " + txtCaja.getText()); //CAJA
            printer.printTextWrap(3, 1, 41, 80, "VENDEDOR: " + lbEmpleado.getText()); //VENDEDOR
            printer.printTextWrap(4, 1, 1, 40, "CLIENTE: " + txtRazonS.getText());//RUC Y RS
            printer.printTextWrap(4, 1, 41, 80, "R.U.C.: " + txtRuc.getText());//RUC Y RS
            printer.printTextWrap(5, 1, 1, 40, "________________________________________");
            printer.printTextWrap(5, 1, 41, 79, "CANT   P.PUBL  %DESC  P.UNIT    TOTAL");
            for (int i = 0; i < filas; i++) {
                int p = 6 + i; //Fila
                DecimalFormat formateador = new DecimalFormat("#,###");
                String DES = printer.alinharADireita(10, tbDetalle.getValueAt(i, 2).toString());
                //String DES = tbDetalle.getValueAt(i, 2).toString();
                String Cant = tbDetalle.getValueAt(i, 3).toString();
                int pp = (int) (Integer.parseInt(tbDetalle.getValueAt(i, 17).toString())/Float.parseFloat(tbDetalle.getValueAt(i, 3).toString()));
                String Ppublic = String.valueOf(pp);
                String Desc = tbDetalle.getValueAt(i, 16).toString();
                String Punit = tbDetalle.getValueAt(i, 5).toString();
                String Mont = tbDetalle.getValueAt(i, 13).toString();
                printer.printTextWrap(p, 1, 1, 40, DES);
                printer.printTextWrap(p, 1, 41, 45, formateador.format(Integer.parseInt(Cant.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 48, 54, formateador.format(Integer.parseInt(Ppublic.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 56, 61, formateador.format(Integer.parseInt(Desc.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 63, 69, formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))));
                printer.printTextWrap(p, 1, 72, 79, formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))));
            }
            printer.printTextWrap(filas+6, 1, 1, 40, "---------------------------------------");

            DecimalFormat formateador = new DecimalFormat("#,###");
            String tot = printer.alinharADireita(10, formateador.format(Integer.parseInt(txtTotalL.getText().replace(".", "").replace(",", ""))));
            printer.printTextWrap(filas + 6, 1, 41, 55, "TOTAL A PAGAR:");
            printer.printTextWrap(filas + 6, 1, 66, 79, (tot));
            printer.printTextWrap(filas + 7, 1, 1, 40, "---------------------------------------");
            String efe = printer.alinharADireita(10, txtAbono.getText());
            printer.printTextWrap(filas + 7, 1, 41, 52, "EFECTIVO : ");
            printer.printTextWrap(filas + 7, 1, 55, 80, efe);

            String cam = printer.alinharADireita(10, txtVuelto.getText());
            printer.printTextWrap(filas + 8, 1, 1, 12, "VUELTO   : ");
            printer.printTextWrap(filas + 8, 1, 15, 40, cam);

            printer.printTextWrap(filas + 8, 1, 41, 80, "=======================================");
            printer.printTextWrap(filas + 9, 1, 6, 34, "GRACIAS POR SU PREFERENCIA!!");
            printer.printTextWrap(filas + 9, 1, 52, 66, "SISTEMA E-FARM");
            printer.printTextWrap(filas + 10, 1, 1, 40, "=======================================");

            ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
            //printer.toFile("C:\\tmp\\impresion.txt");
            printer.toFile("impresion.txt");
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream("impresion.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar ticket: "+ex.getMessage());
            }
            if (inputStream == null) {
                return;
            }

            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(document, attributeSet);
                    byte[] cutP = new byte[] { 0x1d, 'V', 1 };
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.err.println("No existen impresoras instaladas");
            }

            inputStream.close();
            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir " + e);
        }
    }*/
    
    
   public static void imprimirTicket() {
        //Impresora termica
        PrinterService printerService = new PrinterService();
		
	System.out.println(printerService.getPrinters());
        int filas = tbDetalle.getRowCount();
        DecimalFormat formateador = new DecimalFormat("#,###");
        String tot = formateador.format(Integer.parseInt(txtTotalL.getText().replace(".", "").replace(",", "")));
        
        
        String Ticket="                TICKET DE VENTA\n";
        Ticket+="-----------------------------------------------\n";
        Ticket+="FECHA: " + txtFecha.getText().trim()+ " " + Fecha.darHora()+"\n";
        Ticket+="VENDEDOR/A: " + lbEmpleado.getText().trim()+"\n";
        Ticket+="-----------------------------------------------\n";
        for(int i = 0; i < filas; i++) {
            String Punit = tbDetalle.getValueAt(i, 5).toString().trim();
            String Mont = tbDetalle.getValueAt(i, 13).toString().trim();
            String Descripcion=tbDetalle.getValueAt(i, 2).toString().trim();
            Ticket += String.format("%1$1s" ,(i+1)+"- "+ Descripcion+"\n");
            //Ticket += String.format("%1$11s %2$15s %3$19s" ,"CANT: "+tbDetalle.getValueAt(i, 3).toString(), "PRECIO: "+formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))), "SUBTOTAL: "+formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))))+ "\n";
            Ticket += String.format("%1$-11s %2$-15s %3$-19s" ,"CANT: "+tbDetalle.getValueAt(i, 3).toString(), "PRECIO: "+formateador.format(Integer.parseInt(Punit.replace(".", "").replace(",", ""))), "SUBTOTAL: "+formateador.format(Integer.parseInt(Mont.replace(".", "").replace(",", ""))))+ "\n";
                    }
        Ticket+="-----------------------------------------------\n";
        Ticket+=String.format("%1$6s %2$32s", "TOTAL A PAGAR:",tot)+"\n";
        Ticket+="-----------------------------------------------\n";
        Ticket+="          GRACIAS POR SU PREFERENCIA!\n";
        Ticket+="\n\n\n\n\n\n";

        printerService.printString(Ticket);
	//print some stuff
 
	// cut that paper!
	byte[] cutP = new byte[] { 0x1d, 'V', 1 };
 
	printerService.printBytes(cutP);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dlgFinFactura = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtAbono = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtVuelto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbNeto = new javax.swing.JLabel();
        lbDescuento = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtAbonoL = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVerBoleta = new javax.swing.JButton();
        btnModificarV = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCodVendedor = new javax.swing.JTextField();
        lbEmpleado = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuEmergente = new javax.swing.JPopupMenu();
        itemCantidad = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodFactura = new javax.swing.JTextField();
        txtTC = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txtRazonS = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        btnProveedor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtdisponible = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txthabilitado = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        rContado = new javax.swing.JRadioButton();
        rCredito = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtArt = new javax.swing.JTextField();
        txtCant = new javax.swing.JTextField();
        btnBuscarArticulo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        etiCant = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtExenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        txt10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNetoL = new javax.swing.JTextField();
        txtDescuentoL = new javax.swing.JTextField();
        txtCodArticulo = new javax.swing.JTextField();
        txtExentaL = new javax.swing.JTextField();
        txt5L = new javax.swing.JTextField();
        txt10L = new javax.swing.JTextField();
        lbPublic = new javax.swing.JTextField();
        lbPVenta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();
        lbCred = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        panelD = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        txtNeto = new javax.swing.JTextField();
        lbNETO = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtTotalL = new javax.swing.JTextField();
        btnModCantidad = new javax.swing.JButton();
        txtCodCliente = new javax.swing.JTextField();
        txtdisponibleL = new javax.swing.JTextField();
        lbCond = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemCancelar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemBuscarC = new javax.swing.JMenuItem();
        itemBuscarA = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemQuitar = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        dlgFinFactura.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dlgFinFactura.setResizable(false);
        dlgFinFactura.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgFinFacturaWindowOpened(evt);
            }
        });
        dlgFinFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dlgFinFacturaKeyPressed(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VUELTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel11.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("EFECTIVO");

        txtAbono.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtAbono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAbono.setText("0");
        txtAbono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAbonoMouseClicked(evt);
            }
        });
        txtAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAbonoActionPerformed(evt);
            }
        });
        txtAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbonoKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("VUELTO");

        txtVuelto.setEditable(false);
        txtVuelto.setBackground(new java.awt.Color(255, 255, 255));
        txtVuelto.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtVuelto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVuelto.setText("0");
        txtVuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtAbono))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(42, 42, 42))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("RESUMEN DE VENTA:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("TOTAL S/ DESC.");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("AHORRO");

        lbNeto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNeto.setForeground(new java.awt.Color(51, 51, 255));
        lbNeto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNeto.setText("0");

        lbDescuento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDescuento.setForeground(new java.awt.Color(102, 204, 0));
        lbDescuento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescuento.setText("0");

        jPanel13.setBackground(new java.awt.Color(0, 102, 102));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel18.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("VENTA TOTAL");

        lblTotal.setFont(new java.awt.Font("Digital-7 Mono", 1, 30)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbNeto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbDescuento))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("EFECTIVO", jPanel10);

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/accept.png"))); // NOI18N
        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.setEnabled(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVerBoleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/printer30.png"))); // NOI18N
        btnVerBoleta.setText("VER TICKET");
        btnVerBoleta.setEnabled(false);
        btnVerBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerBoletaActionPerformed(evt);
            }
        });

        btnModificarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit30.png"))); // NOI18N
        btnModificarV.setText("MODIFICAR");
        btnModificarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel9.setText("ID Vendedor");

        txtCodVendedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodVendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodVendedorActionPerformed(evt);
            }
        });
        txtCodVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodVendedorKeyPressed(evt);
            }
        });

        lbEmpleado.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        lbEmpleado.setForeground(new java.awt.Color(0, 102, 102));
        lbEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnModificarV, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnVerBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAbonoL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCodVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtCodVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerBoleta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAbonoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("EFECTIVO");

        jMenuBar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jMenu2.setText("Opciones");
        jMenu2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save15.png"))); // NOI18N
        jMenuItem1.setText("Confirmar Venta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit15.png"))); // NOI18N
        jMenuItem2.setText("Modificar Venta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar2.add(jMenu2);

        dlgFinFactura.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout dlgFinFacturaLayout = new javax.swing.GroupLayout(dlgFinFactura.getContentPane());
        dlgFinFactura.getContentPane().setLayout(dlgFinFacturaLayout);
        dlgFinFacturaLayout.setHorizontalGroup(
            dlgFinFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgFinFacturaLayout.setVerticalGroup(
            dlgFinFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgFinFacturaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        itemCantidad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        itemCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Modify.png"))); // NOI18N
        itemCantidad.setText("Modificar Cantidad");
        itemCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCantidadActionPerformed(evt);
            }
        });
        menuEmergente.add(itemCantidad);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setText("Operación N°");

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel4.setText("Fecha");

        jLabel19.setText("Mov. Caja N°");

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtCaja.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setText("Comprob.  N°: ");

        txtCodFactura.setEditable(false);
        txtCodFactura.setBackground(new java.awt.Color(255, 255, 255));
        txtCodFactura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCodFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodFacturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodFacturaKeyTyped(evt);
            }
        });

        txtTC.setEditable(false);
        txtTC.setBackground(new java.awt.Color(255, 255, 255));
        txtTC.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTC.setText("000-000-");
        txtTC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTCActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtRazonS.setEditable(false);
        txtRazonS.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRazonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });

        txtRuc.setEditable(false);
        txtRuc.setBackground(new java.awt.Color(255, 255, 255));
        txtRuc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(0, 0, 51));
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search15.png"))); // NOI18N
        btnProveedor.setText("F3-Clientes");
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jLabel3.setText("Línea de crédito disponible:");

        txtdisponible.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtdisponible.setForeground(new java.awt.Color(255, 0, 0));
        txtdisponible.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Crédito habilitado:");

        txthabilitado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txthabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        txtFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rContado);
        rContado.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rContado.setSelected(true);
        rContado.setText("CONTADO");
        rContado.setOpaque(false);
        rContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rContadoActionPerformed(evt);
            }
        });
        jPanel12.add(rContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 14));

        buttonGroup1.add(rCredito);
        rCredito.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        rCredito.setText("CREDITO");
        rCredito.setEnabled(false);
        rCredito.setOpaque(false);
        rCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCreditoActionPerformed(evt);
            }
        });
        jPanel12.add(rCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 13));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 640, -1));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnNuevo.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document30.png"))); // NOI18N
        btnNuevo.setText("Nuevo-F1");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMaximumSize(new java.awt.Dimension(85, 57));
        btnNuevo.setMinimumSize(new java.awt.Dimension(85, 57));
        btnNuevo.setPreferredSize(new java.awt.Dimension(90, 60));
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save30.png"))); // NOI18N
        btnGuardar.setText("Guardar-F6");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setMaximumSize(new java.awt.Dimension(71, 57));
        btnGuardar.setMinimumSize(new java.awt.Dimension(71, 57));
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel30.png"))); // NOI18N
        btnCancelar.setText("Cancel-Esc");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMaximumSize(new java.awt.Dimension(75, 57));
        btnCancelar.setMinimumSize(new java.awt.Dimension(75, 57));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar);

        btnSalir.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setText("Salir-Alt+F4");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, 61));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtArt.setEditable(false);
        txtArt.setBackground(new java.awt.Color(255, 255, 255));
        txtArt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtArt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArtActionPerformed(evt);
            }
        });
        txtArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArtKeyReleased(evt);
            }
        });

        txtCant.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantKeyPressed(evt);
            }
        });

        btnBuscarArticulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarArticulo.setForeground(new java.awt.Color(0, 0, 51));
        btnBuscarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnBuscarArticulo.setText("F9-Agregar");
        btnBuscarArticulo.setActionCommand("F9 - Buscar Artículo");
        btnBuscarArticulo.setBorderPainted(false);
        btnBuscarArticulo.setContentAreaFilled(false);
        btnBuscarArticulo.setFocusable(false);
        btnBuscarArticulo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnBuscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticuloActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CANT.");

        etiCant.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        etiCant.setText("Artículos registrados:");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        tbDetalle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setRowHeight(20);
        tbDetalle.setShowGrid(true);
        tbDetalle.setShowVerticalLines(false);
        tbDetalle.getTableHeader().setResizingAllowed(false);
        tbDetalle.getTableHeader().setReorderingAllowed(false);
        tbDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetalleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 9)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EXCENTAS");

        txtExenta.setEditable(false);
        txtExenta.setBackground(new java.awt.Color(255, 255, 255));
        txtExenta.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtExenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExenta.setText("0");

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 9)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IVA 5%");

        txt5.setEditable(false);
        txt5.setBackground(new java.awt.Color(255, 255, 255));
        txt5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txt5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5.setText("0");

        txt10.setEditable(false);
        txt10.setBackground(new java.awt.Color(255, 255, 255));
        txt10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txt10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10.setText("0");

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 9)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("IVA 10%");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt5)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        txtNetoL.setEditable(false);
        txtNetoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNetoL.setText("0");

        txtDescuentoL.setEditable(false);
        txtDescuentoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuentoL.setText("0");

        txtCodArticulo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N

        txtExentaL.setEditable(false);
        txtExentaL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExentaL.setText("0");

        txt5L.setEditable(false);
        txt5L.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt5L.setText("0");

        txt10L.setEditable(false);
        txt10L.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt10L.setText("0");

        lbPublic.setEditable(false);
        lbPublic.setBackground(new java.awt.Color(0, 102, 102));
        lbPublic.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbPublic.setForeground(new java.awt.Color(255, 255, 255));
        lbPublic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbPublic.setBorder(null);

        lbPVenta.setEditable(false);
        lbPVenta.setBackground(new java.awt.Color(0, 102, 102));
        lbPVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPVenta.setForeground(new java.awt.Color(255, 255, 255));
        lbPVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbPVenta.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(etiCant, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                .addGap(307, 307, 307))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNetoL, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescuentoL, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtExentaL, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt5L, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt10L, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarArticulo)
                            .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCant)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbPVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                            .addComponent(lbPublic))))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8)
                    .addComponent(btnBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPublic))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(etiCant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuentoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNetoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt10L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt5L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExentaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 228, -1, 340));

        jPanel3.setLayout(new java.awt.GridLayout(1, 4));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(916, 489, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Create.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 31, -1, -1));

        btnRestar.setText("R");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(869, 155, -1, 25));

        lbCred.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        lbCred.setText("jLabel12");
        getContentPane().add(lbCred, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 11, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TOTAL VENTA");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(51, 51, 51));
        txtTotal.setFont(new java.awt.Font("Digital-7 Mono", 1, 32)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTotal.setText("0");
        txtTotal.setBorder(null);
        txtTotal.setOpaque(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(61, 61, 61))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 3, 339, 65));

        panelD.setBackground(new java.awt.Color(255, 255, 255));
        panelD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setText("TOTAL AHORRO:");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(255, 255, 204));
        txtDescuento.setFont(new java.awt.Font("Digital-7 Mono", 1, 18)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(0, 0, 102));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuento.setText("0");

        txtNeto.setEditable(false);
        txtNeto.setBackground(new java.awt.Color(255, 255, 204));
        txtNeto.setFont(new java.awt.Font("Digital-7 Mono", 1, 18)); // NOI18N
        txtNeto.setForeground(new java.awt.Color(0, 102, 0));
        txtNeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNeto.setText("0");
        txtNeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNetoActionPerformed(evt);
            }
        });

        lbNETO.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbNETO.setText("TOTAL VENTA SIN DESCUENTO:");

        javax.swing.GroupLayout panelDLayout = new javax.swing.GroupLayout(panelD);
        panelD.setLayout(panelDLayout);
        panelDLayout.setHorizontalGroup(
            panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNETO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(txtNeto))
                .addGap(10, 10, 10))
        );
        panelDLayout.setVerticalGroup(
            panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNETO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDLayout.createSequentialGroup()
                        .addComponent(txtNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(39, 39, 39))
        );

        getContentPane().add(panelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 77, 260, 70));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 70));

        txtTotalL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotalL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalL.setText("0");
        jPanel6.add(txtTotalL, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 76, -1));

        btnModCantidad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 9)); // NOI18N
        btnModCantidad.setForeground(new java.awt.Color(204, 0, 0));
        btnModCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit15.png"))); // NOI18N
        btnModCantidad.setText("EDIT. CANT");
        btnModCantidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModCantidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModCantidadActionPerformed(evt);
            }
        });
        jPanel6.add(btnModCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 45, 25));

        txtCodCliente.setEditable(false);
        txtCodCliente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        txtCodCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(txtCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 40, -1));
        jPanel6.add(txtdisponibleL, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 83, -1));

        lbCond.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbCond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 81, 20));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 925, 580));

        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(itemNuevo);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemGuardar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save15.png"))); // NOI18N
        itemGuardar.setText("Guardar Nuevo");
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(itemGuardar);

        itemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemCancelar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel15.png"))); // NOI18N
        itemCancelar.setText("Cancelar");
        itemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCancelarActionPerformed(evt);
            }
        });
        jMenu1.add(itemCancelar);
        jMenu1.add(jSeparator1);

        itemBuscarC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itemBuscarC.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemBuscarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search20.png"))); // NOI18N
        itemBuscarC.setText("Cambiar Cliente");
        itemBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarCActionPerformed(evt);
            }
        });
        jMenu1.add(itemBuscarC);

        itemBuscarA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        itemBuscarA.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemBuscarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search20.png"))); // NOI18N
        itemBuscarA.setText("Buscar Artículo");
        itemBuscarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarAActionPerformed(evt);
            }
        });
        jMenu1.add(itemBuscarA);
        jMenu1.add(jSeparator4);

        itemQuitar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemQuitar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vcsremoved_93492 - copia.png"))); // NOI18N
        itemQuitar.setText("Quitar Artículo");
        itemQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuitarActionPerformed(evt);
            }
        });
        jMenu1.add(itemQuitar);
        jMenu1.add(jSeparator5);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(itemSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            controlFactura.canCelar();
            this.dispose();
        }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        controlFactura.addTabla(tbDetalle);
        cant();
        txtCodArticulo.setText("");
        txtArt.setText("");
        txtCant.setText("");
        lbPVenta.setText("");
        lbPublic.setText("");
        btnBuscarArticulo.requestFocus();
        habilitarCANTCOSTO();
        btnBuscarArticuloActionPerformed(null);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        // TODO add your handling code here:
        try {
            controlFactura.delRenglon(tbDetalle);
            cant();
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_btnRestarActionPerformed

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtCant);
        Articulo Ar = GestionarArticulos.busArticulo((txtCodArticulo.getText()));
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtCant.getText().isEmpty()) {
                txtCant.selectAll();
            } else if (txtCant.getText().equals("0")) {
                txtCant.selectAll();
            } else if (txtCant.getText().equals("0.0")) {
                txtCant.selectAll();
            }else if (Float.parseFloat(txtCant.getText()) > Ar.getStock()) {
                Mensajes.error("Cantidad supera el Stock actual");
                txtCant.requestFocus();
                txtCant.setText(String.valueOf(Ar.getStock()));
                txtCant.selectAll();
            } else {
                btnAdd.doClick();
            }
        }
    }//GEN-LAST:event_txtCantKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        
        Rendes();
        String cod = GestionarFactura.getCodigo();
        txtCod.setText(cod);
        txtCodFactura.setText(cod);
        try {
            String FechaI = String.valueOf(Fecha.fechaCorrecta());
            txtCaja.setText(generarCodigos.ObtenerCodigo("SELECT ca_id from caja WHERE ca_fechainicio='" + FechaI + "' and ca_indicador='S'"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Cliente Cl = GestionarCliente.busCliente("1");
        controlFactura.selectClienteInicio("1");
        //txtCodCliente.setText(String.valueOf(Cl.getCodCliente()));
        //txtRuc.setText(String.valueOf(Cl.getRuc()));
        //txtRazonS.setText(" " + String.valueOf(Cl.getRazonSocial()));
        //lbCred.setText(Cl.getCredito());
        rContado.setSelected(true);
        txtTC.setText("000-000-");
        if (lbCred.getText().equals("SI")) {
            rCredito.setEnabled(true);
        } else {
            rCredito.setEnabled(false);
        }
        pintarCondicion();
        txtFecha.setText(Fecha.fechaCorrecta());
        //txtFecha.setText(String.valueOf(now().getDayOfMonth()+"-"+now().getMonthValue()+"-"+now().getYear()));
        btnProveedor.setEnabled(true);
        rContado.setEnabled(true);
        btnBuscarArticulo.setEnabled(true);
        txtCant.setEnabled(true);
        btnNuevo.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        itemGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        itemBuscarA.setEnabled(true);
        itemBuscarC.setEnabled(true);
        itemQuitar.setEnabled(true);
        btnSalir.setEnabled(false);
        btnBuscarArticulo.doClick();
        habilitarCANTCOSTO();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getRowCount() <= 0) {
            Mensajes.error("El detalle de la compra esta vacia");
            btnBuscarArticulo.doClick();
        } else {
            if (lbCond.getText().equals("CONTADO")) {
                DecimalFormat df = new DecimalFormat("#,###");
                if (dlgVentas.txtTotalL.getText().trim().length() >= 1) {
                    dlgVentas.lblTotal.setText(df.format(Integer.valueOf(dlgVentas.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
                }
                if (dlgVentas.txtNetoL.getText().trim().length() >= 1) {
                    dlgVentas.lbNeto.setText(df.format(Integer.valueOf(dlgVentas.txtNetoL.getText().trim().replace(".", "").replace(",", ""))));
                }
                if (dlgVentas.txtDescuentoL.getText().trim().length() >= 1) {
                    dlgVentas.lbDescuento.setText(df.format(Integer.valueOf(dlgVentas.txtDescuentoL.getText().trim().replace(".", "").replace(",", ""))));
                }
                dlgFinFactura.setSize(325, 440);
                dlgFinFactura.setLocationRelativeTo(this);
                dlgFinFactura.setModal(true);
                dlgFinFactura.setTitle("Finalizar Venta");
                dlgFinFactura.setVisible(true);
                btnConfirmar.requestFocus();
            } else {
                if (Integer.parseInt(txtTotalL.getText()) <= Integer.parseInt(txtdisponibleL.getText())) {
                    DecimalFormat df = new DecimalFormat("#,###");
                    if (dlgVentas.txtTotalL.getText().trim().length() >= 1) {
                        dlgVentas.lblTotal.setText(df.format(Integer.valueOf(dlgVentas.txtTotalL.getText().trim().replace(".", "").replace(",", ""))));
                    }
                    if (dlgVentas.txtNetoL.getText().trim().length() >= 1) {
                        dlgVentas.lbNeto.setText(df.format(Integer.valueOf(dlgVentas.txtNetoL.getText().trim().replace(".", "").replace(",", ""))));
                    }
                    if (dlgVentas.txtDescuentoL.getText().trim().length() >= 1) {
                        dlgVentas.lbDescuento.setText(df.format(Integer.valueOf(dlgVentas.txtDescuentoL.getText().trim().replace(".", "").replace(",", ""))));
                    }
                    dlgFinFactura.setSize(325, 440);
                    dlgFinFactura.setLocationRelativeTo(this);
                    dlgFinFactura.setModal(true);
                    dlgFinFactura.setTitle("Finalizar Venta");
                    dlgFinFactura.setVisible(true);
                    btnConfirmar.requestFocus();
                } else {
                    Mensajes.informacion("Línea de crédito insuficiente");
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            limpiarCampos();
            //dcFecha.setEnabled(false);
            btnProveedor.setEnabled(false);
            rContado.setEnabled(false);
            rContado.setSelected(true);
            rCredito.setEnabled(false);
            btnBuscarArticulo.setEnabled(false);
            txtCant.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnNuevo.requestFocus();
            itemNuevo.setEnabled(true);
            btnGuardar.setEnabled(false);
            itemGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            itemCancelar.setEnabled(false);
            itemBuscarA.setEnabled(false);
            itemBuscarC.setEnabled(false);
            itemQuitar.setEnabled(false);
            btnSalir.setEnabled(true);
            cant();
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarCliente bcliente = new dlgBuscarCliente(null, true);
            bcliente.setLocationRelativeTo(null);
            bcliente.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }

    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnBuscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticuloActionPerformed
        // TODO add your handling code here:
        try {
            dlgBuscarArticuloVenta baf = new dlgBuscarArticuloVenta(null, true);
            baf.setLocationRelativeTo(null);
            //baf.setLocation(228, 270);
            baf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }

    }//GEN-LAST:event_btnBuscarArticuloActionPerformed

    private void rContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rContadoActionPerformed
        // TODO add your handling code here:
        txtTC.setText("000-000-");
        pintarCondicion();
    }//GEN-LAST:event_rContadoActionPerformed

    private void rCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCreditoActionPerformed
        // TODO add your handling code here:
        txtTC.setText("001-001-");
        pintarCondicion();
    }//GEN-LAST:event_rCreditoActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        btnNuevoActionPerformed(null);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // TODO add your handling code here:
        btnGuardarActionPerformed(null);
    }//GEN-LAST:event_itemGuardarActionPerformed

    private void itemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCancelarActionPerformed
        // TODO add your handling code here:
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_itemCancelarActionPerformed

    private void itemBuscarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarAActionPerformed
        // TODO add your handling code here:
        btnBuscarArticulo.doClick();
    }//GEN-LAST:event_itemBuscarAActionPerformed

    private void itemQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuitarActionPerformed
        // TODO add your handling code here:S
        btnRestar.doClick();
    }//GEN-LAST:event_itemQuitarActionPerformed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCantActionPerformed

    private void txtArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtArtActionPerformed

    private void txtArtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtArtKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtCodFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFacturaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodFacturaKeyPressed

    private void txtCodFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFacturaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        int limite = 15;
        if (txtCodFactura.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodFacturaKeyTyped

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void txtNetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNetoActionPerformed

    private void txtAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtAbono.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtAbono.setText(df.format(Integer.valueOf(txtAbono.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtAbono.setText("0");
                txtAbono.selectAll();

            }
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }
        try {
            if (txtAbono.getText().trim().length() >= 1) {
                DecimalFormat dff = new DecimalFormat("#0");
                txtAbonoL.setText(dff.format(Integer.valueOf(txtAbono.getText().trim().replace(".", "").replace(",", ""))));

            } else {
                txtAbonoL.setText("0");

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtAbonoKeyReleased

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        String cod = GestionarFactura.getCodigo();
        txtCod.setText(cod);
        String TC = txtTC.getText();
        txtCodFactura.setText(cod);
        String cond=lbCond.getText();
        String est;
        if(cond.equals("CONTADO")){
            est="ABONADO";
        }else{
            est="PENDIENTE";
        }
        UsuarioL = Login.getUsuarioLogueado();
        try {
            int resp = JOptionPane.showConfirmDialog(dlgFinFactura, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    prepararBD();
                    con.setAutoCommit(false);
                    String sql = "insert into factura values(" + txtCod.getText() + "," + txtCodVendedor.getText() + "," + txtCodCliente.getText() + "," + txtCaja.getText() + ",'" + TC + txtCodFactura.getText() + "','" + lbCond.getText() + "','"
                            + Fecha.fechaCorrecta() + "','" + Fecha.darHora() + "'," + txtTotalL.getText() + "," + txtExentaL.getText() + "," + txt5L.getText() + "," + txt10L.getText() + ",'S','" + UsuarioL + "','"+est+"')";
                    stTransaccion.executeUpdate(sql);
                    int fila = tbDetalle.getRowCount();
                    for (int j = 0; j < fila; j++) {
                        String filas[] = {tbDetalle.getValueAt(j, 0).toString(), tbDetalle.getValueAt(j, 4).toString(), tbDetalle.getValueAt(j, 6).toString(), tbDetalle.getValueAt(j, 14).toString(), tbDetalle.getValueAt(j, 2).toString()};
                        sql = "insert into detalle_factura values(" + txtCod.getText() + "," + filas[0] + "," + filas[1] + "," + filas[2] + "," + filas[3] + ")";
                        String sql2 = "UPDATE articulo SET art_stock=(art_stock-"+filas[1]+ ") WHERE  art_codigo=" + filas[0];
                        stTransaccion.executeUpdate(sql);
                        stTransaccion.executeUpdate(sql2);
                    }
                    con.commit();
                    stTransaccion.close();
                    con.close();
                    Mensajes.informacion("VENTA REALIZADA!");
                    dlgFinFactura.dispose();
                    if(cond.equals("CONTADO")){
                        imprimirTicket();
                        CabecerasTablas.limpiarTablas(tbDetalle);
                        cabe.compras(tbDetalle);
                        controlFactura.canCelar();
                        Cancelar();
                        txtAbono.setText("0");
                        txtVuelto.setText("0");
                        cant();
                    }else{
                        imprimirTicket();
                        CabecerasTablas.limpiarTablas(tbDetalle);
                        cabe.compras(tbDetalle);
                        controlFactura.canCelar();
                        Cancelar();
                        txtAbono.setText("0");
                        txtVuelto.setText("0");
                        cant();
                        //jasper.BoletaCredito("\\Reports\\ventas\\venta_credito.jasper", "cod", Integer.parseInt(cod));
                    }
                    //CabecerasTablas.limpiarTablas(tbDetalle);
                    //cabe.compras(tbDetalle);
                    //controlFactura.canCelar();  
                } catch (SQLException e) {
                    try {
                        con.rollback();
                        stTransaccion.close();
                        con.close();
                        Mensajes.error("TRANSACCION FALLIDA. LOS DATOS NO FUERON GUARDADOS EN LA BD." + e.getMessage());
                        controlFactura.canCelar();
                        dlgFinFactura.dispose();
                    } catch (SQLException se) {
                        Mensajes.error(se.getMessage());
                    }
                }
                //Cancelar();
                //txtAbono.setText("0");
                //txtVuelto.setText("0");
                //cant();
            }
        } catch (Exception ee) {
            System.out.println(ee.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVerBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerBoletaActionPerformed
        // TODO add your handling code here:
        //llamarReporteFactura();
    }//GEN-LAST:event_btnVerBoletaActionPerformed

    private void btnModificarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVActionPerformed
        // TODO add your handling code here:
        dlgFinFactura.dispose();
        txtCodVendedor.setText("");
        lbEmpleado.setText("");
        txtAbono.setText("0");
        txtVuelto.setText("0");
    }//GEN-LAST:event_btnModificarVActionPerformed

    private void txtAbonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAbonoMouseClicked
        // TODO add your handling code here:
        //txtAbono.selectAll();
    }//GEN-LAST:event_txtAbonoMouseClicked

    private void dlgFinFacturaWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgFinFacturaWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_dlgFinFacturaWindowOpened

    private void dlgFinFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dlgFinFacturaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgFinFacturaKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        btnConfirmar.doClick();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtCodVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVendedorActionPerformed
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtCodVendedor.getText()) <= 0) {
                Mensajes.error("CODIGO EQUIVOCADO O NO POSEE PERFIL PARA VENTA");
                btnConfirmar.setEnabled(false);
                txtCodVendedor.requestFocus();
                txtCodVendedor.selectAll();
            } else {
                try {
                    Vendedor vn = GestionarVendedor.busVendedorFactura(txtCodVendedor.getText());
                    lbEmpleado.setText(vn.getNombreV());
                    btnConfirmar.setEnabled(true);
                    txtAbono.requestFocus();
                    txtAbono.selectAll();
                } catch (Exception e) {
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtCodVendedorActionPerformed

    private void txtCodVendedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodVendedorKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCodVendedor);
    }//GEN-LAST:event_txtCodVendedorKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        btnModificarV.doClick();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAbonoActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtAbonoL.getText()) == 0) {
            btnConfirmar.doClick();
        } else {
            try {
                int calculos = controlFactura.calCulos();
                //txtVuelto.setText(String.valueOf(calculos));
                DecimalFormat df = new DecimalFormat("#,###");
                txtVuelto.setText(df.format(Integer.parseInt(String.valueOf(calculos).trim().replace(".", "").replace(",", ""))));
                txtVuelto.requestFocus();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtAbonoActionPerformed

    private void txtVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVueltoActionPerformed
        // TODO add your handling code here:
        btnConfirmar.doClick();
    }//GEN-LAST:event_txtVueltoActionPerformed

    private void itemBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemBuscarCActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void txtTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTCActionPerformed

    private void btnModCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModCantidadActionPerformed
        // TODO add your handling code here:
        if (tbDetalle.getSelectedRowCount() != 0) {
            try {
                controlFactura.actCantidad();
            } catch (Exception e) {
            }
        }
        
        
    }//GEN-LAST:event_btnModCantidadActionPerformed

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MousePressed

    private void tbDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDetalleMousePressed

    private void tbDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMouseClicked
        // TODO add your handling code here:
    /*    if(evt.getButton() == 1){
            if(evt.getClickCount() == 2){
                menuEmergente.show(tbDetalle, evt.getX(), evt.getY());
            }
            
        }*/
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void itemCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCantidadActionPerformed
        // TODO add your handling code here:
        btnModCantidadActionPerformed(null);
    }//GEN-LAST:event_itemCantidadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgVentas dialog = new dlgVentas(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    public static javax.swing.JButton btnBuscarArticulo;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnConfirmar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModCantidad;
    private javax.swing.JButton btnModificarV;
    public static javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnRestar;
    public static javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerBoleta;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JDialog dlgFinFactura;
    public static javax.swing.JLabel etiCant;
    private javax.swing.JMenuItem itemBuscarA;
    private javax.swing.JMenuItem itemBuscarC;
    private javax.swing.JMenuItem itemCancelar;
    private javax.swing.JMenuItem itemCantidad;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemQuitar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lbCond;
    public static javax.swing.JLabel lbCred;
    public static javax.swing.JLabel lbDescuento;
    public static javax.swing.JLabel lbEmpleado;
    private javax.swing.JLabel lbNETO;
    public static javax.swing.JLabel lbNeto;
    public static javax.swing.JTextField lbPVenta;
    public static javax.swing.JTextField lbPublic;
    public static javax.swing.JLabel lblTotal;
    private javax.swing.JPopupMenu menuEmergente;
    private javax.swing.JPanel panelD;
    public static javax.swing.JRadioButton rContado;
    public static javax.swing.JRadioButton rCredito;
    public static javax.swing.JTable tbDetalle;
    public static javax.swing.JTextField txt10;
    public static javax.swing.JTextField txt10L;
    public static javax.swing.JTextField txt5;
    public static javax.swing.JTextField txt5L;
    public static javax.swing.JTextField txtAbono;
    public static javax.swing.JTextField txtAbonoL;
    public static javax.swing.JTextField txtArt;
    public static javax.swing.JTextField txtCaja;
    public static javax.swing.JTextField txtCant;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtCodArticulo;
    public static javax.swing.JTextField txtCodCliente;
    public static javax.swing.JTextField txtCodFactura;
    public static javax.swing.JTextField txtCodVendedor;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDescuentoL;
    public static javax.swing.JTextField txtExenta;
    public static javax.swing.JTextField txtExentaL;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtNeto;
    public static javax.swing.JTextField txtNetoL;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTC;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtTotalL;
    public static javax.swing.JTextField txtVuelto;
    public static javax.swing.JTextField txtdisponible;
    public static javax.swing.JTextField txtdisponibleL;
    public static javax.swing.JTextField txthabilitado;
    // End of variables declaration//GEN-END:variables

}
