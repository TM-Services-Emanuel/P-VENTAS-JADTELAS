package Controladores;

import Componentes.ConexionBD;
import Componentes.Login;
import Componentes.Mensajes;
import Componentes.Redondeo;
import Datos.*;
import IU.*;
import Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;

public class controlFactura {

    static Cliente cl;
    static Articulo art;
    static DetalleFactura dfa;
    static ArregloFactura array = new ArregloFactura();
    static String UsuarioL = "";
    public static MariaDbConnection con;
    public static MariaDbStatement st;
    public static ResultSet rss;

    public static void prepararBD() {
        try {
            con = (MariaDbConnection) new ConexionBD().getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                st = (MariaDbStatement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void selecArticulo()//Seleccionar Artículo
    {
        int x = dlgBuscarArticuloVenta.tbDetalle.getSelectedRow();
        String cod = dlgBuscarArticuloVenta.tbDetalle.getValueAt(x, 0).toString();
        art = GestionarArticulos.busArticulo(cod);
        dlgVentas.txtCodArticulo.setText(String.valueOf(art.getCodArticulo()));
        dlgVentas.txtArt.setText(art.getDescripcion());
        dlgVentas.txtCant.setText("1");

        DecimalFormat df = new DecimalFormat("#,###");
        String PP = String.valueOf(art.getPrecioPublico());
        String DES = String.valueOf(art.getDescuento());
        dlgVentas.lbPublic.setText("Precio Público: Gs." + (df.format(Integer.parseInt(PP.trim().replace(".", "").replace(",", "")))) + " | Descuento de: " + DES + "%");

        String PV = String.valueOf(art.getPrecioVenta());
        String PVM = String.valueOf(art.getPM());
        int MC = art.getCM();
        String May;
        if (art.getVM().equals("N")) {
            //May="NO";
            dlgVentas.lbPVenta.setText("Pr. Unit: Gs." + (df.format(Integer.parseInt(PV.trim().replace(".", "").replace(",", "")))));
        } else {
            May = "SI";
            dlgVentas.lbPVenta.setText("Pr. Unit: Gs." + (df.format(Integer.parseInt(PV.trim().replace(".", "").replace(",", "")))) + " | A partir de " + MC +" (Mts/Unids): Gs." + (df.format(Integer.parseInt(PVM.trim().replace(".", "").replace(",", "")))));
        }
    }

    public static void selectCliente()//Seleccionar Cliente
    {
        int x = dlgBuscarCliente.tbDetalle.getSelectedRow();
        String cod = dlgBuscarCliente.tbDetalle.getValueAt(x, 0).toString();
        cl = GestionarCliente.busCliente(cod);
        dlgVentas.txtCodCliente.setText(String.valueOf(cl.getCodCliente()));
        dlgVentas.txtRuc.setText((cl.getRuc()));
        dlgVentas.txtRazonS.setText(cl.getRazonSocial());
        dlgVentas.lbCred.setText(cl.getCredito());
        if (dlgVentas.lbCred.getText().equals("SI")) {
            dlgVentas.rCredito.setEnabled(true);
            dlgVentas.txthabilitado.setText("SI");
            int lineaCredito = cl.getLimCuenta();
            sumarCuentas(cod, lineaCredito);
        } else {
            dlgVentas.rContado.setSelected(true);
            //dlgVentas.rCredito.setSelected(false);
            dlgVentas.rCredito.setEnabled(false);
            dlgVentas.txthabilitado.setText("NO");
            dlgVentas.txtdisponible.setText("0");
            dlgVentas.txtdisponibleL.setText("0");
        }

    }

    public static void selectClienteInicio(String cod)//Seleccionar Cliente
    {
        //int x = dlgBuscarCliente.tbDetalle.getSelectedRow();
        //String cod = dlgBuscarCliente.tbDetalle.getValueAt(x, 0).toString();
        cl = GestionarCliente.busCliente(cod);
        dlgVentas.txtCodCliente.setText(String.valueOf(cl.getCodCliente()));
        dlgVentas.txtRuc.setText((cl.getRuc()));
        dlgVentas.txtRazonS.setText(cl.getRazonSocial());
        dlgVentas.lbCred.setText(cl.getCredito());
        if (dlgVentas.lbCred.getText().equals("SI")) {
            dlgVentas.rCredito.setEnabled(true);
            dlgVentas.txthabilitado.setText("SI");
            int lineaCredito = cl.getLimCuenta();
            sumarCuentas(cod, lineaCredito);
        } else {
            //dlgVentas.rContado.setSelected(true);
            //dlgVentas.rCredito.setSelected(false);
            dlgVentas.rCredito.setEnabled(false);
            dlgVentas.txthabilitado.setText("NO");
            dlgVentas.txtdisponible.setText("0");
            dlgVentas.txtdisponibleL.setText("0");
        }

    }

    public static void sumarCuentas(String cod, int limite) {
        prepararBD();
        String sql = "SELECT SUM(fac_totalfinal) FROM factura WHERE clientes_cli_codigo=" + cod + " AND estado='PENDIENTE' AND fac_indicador='S'";
        try {
            rss = st.executeQuery(sql);
            rss.first();
            int deuda;
            if (rss.getString(1) == null) {
                deuda = 0;
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtdisponibleL.setText(String.valueOf(limite - deuda));
                dlgVentas.txtdisponible.setText(df.format(Integer.valueOf(String.valueOf(limite - deuda).trim().replace(".", "").replace(",", ""))));
            } else {
                deuda = Integer.parseInt(rss.getString(1));
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtdisponibleL.setText(String.valueOf(limite - deuda));
                dlgVentas.txtdisponible.setText(df.format(Integer.valueOf(String.valueOf(limite - deuda).trim().replace(".", "").replace(",", ""))));
            }
            rss.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            Mensajes.error("Error calculando disponibilidad de crédito del clinte: " + e.getMessage());
        }
    }

    public static int getExcetas() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 7)));
        }
        return Redondeo.redondearI(total);
    }

    public static int get5() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 9)));
        }
        return Redondeo.redondearI(total / 21);
    }

    public static int get10() {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.valueOf(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 11)));
        }
        return Redondeo.redondearI(total / 11);
    }

    public static int getTotal()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            total += Integer.parseInt(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 14)));
        }
        return /*Redondeo.redondearD*/ (total);
    }

    public static int getDescuento()//Calcula el total de la venta
    {
        int descuento = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            descuento += Integer.parseInt(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 15)));
        }
        return /*Redondeo.redondearD*/ (descuento);
    }

    public static int getNeto()//Calcula el total de la venta
    {
        int neto = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgVentas.tbDetalle.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            neto += Integer.parseInt(String.valueOf(dlgVentas.tbDetalle.getModel().getValueAt(i, 17)));
        }
        return /*Redondeo.redondearD*/ (neto);
    }

    /*public static double getDescuento()//Calcula el descuenti global
    {
        double desc = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgFactura.jTable1.getModel();
        int fila = tb.getRowCount();
        desc = (getTotal() / 100) * cl.getDesc();
        return Redondeo.redondear(desc);
    }*/

 /*public static void insertar(String cant, String cod, String descripcion, String precio, String total, String sa, JTable tabla)//Insertar en jtable
    {
        Object[] fila = {cant, cod, descripcion, precio, total, sa};
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        tb.addRow(fila);
    }*/
 /*    public static void insertarTicket(String desc, String cant, String prec, String total, JTextArea detalle) {
        //Object[] fila = {cod, codB, cant, desc, cant, prec, total};
        //DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        //tb.addRow(fila);
        detalle.setText(desc+"\n "+cant+"        "+prec+"        "+total+"\n");
    }*/
    public static void insertar(String cod, String codB, String desc, String cant, String prec, String total, int iva, String descuento, String porcDesc, String neto, String ppub, JTable tabla) {
        String fila[] = new String[19];
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        fila[0] = cod;
        fila[1] = codB;
        fila[2] = desc;
        fila[3] = cant;
        fila[4] = cant;
        fila[5] = prec;
        fila[6] = prec;
        switch (iva) {
            case 10 -> {
                fila[7] = "0";
                fila[8] = "0";
                fila[9] = "0";
                fila[10] = "0";
                fila[11] = total;
                fila[12] = total;
            }
            case 5 -> {
                fila[7] = "0";
                fila[8] = "0";
                fila[9] = total;
                fila[10] = total;
                fila[11] = "0";
                fila[12] = "0";
            }
            default -> {
                fila[7] = total;
                fila[8] = total;
                fila[9] = "0";
                fila[10] = "0";
                fila[11] = "0";
                fila[11] = "0";
            }
        }
        fila[13] = total;
        fila[14] = total;
        fila[15] = descuento;
        fila[16] = porcDesc;
        fila[17] = neto;
        fila[18] = ppub;
        tb.addRow(fila);
    }

    /*  public static double actStock() {
        int cant = Integer.parseInt(dlgVentas.txtCant.getText());
        return art.getStock() - cant;
    }*/
    public static void addTabla(JTable tabla) {
        try {
            //int f = dlgBuscarArticuloVenta.tbDetalle.getSelectedRow();
            int codA = art.getCodArticulo();
            String codB = art.getCodBarra();
            String desc = art.getDescripcion();
            float cant = Float.parseFloat(dlgVentas.txtCant.getText());
            int cantM = art.getCM();
            int precioMin = art.getPrecioVenta();
            int precioMay = art.getPM();
            String VM = art.getVM();
            int mont;
            int prec;
            if (VM.equals("S")) {
                if (cant < cantM) {
                    prec = precioMin;
                    mont = (int) (cant * prec);
                } else {
                    prec = precioMay;
                    mont = (int) (cant * prec);
                }
            } else {
                prec = precioMin;
                mont = (int) (cant * prec);
            }
            int descuento;
            int neto;
            int porcDesc = art.getDescuento();
            if (art.getPrecioPublico() == 0) {
                descuento = 0;
            } else {
                descuento = (int) ((art.getPrecioPublico() - art.getPrecioVenta()) * cant);
            }
            if (art.getPrecioPublico() == 0) {
                neto = 0;
            } else {
                neto = (int) (art.getPrecioPublico() * cant);
            }
            int iva = art.getIVA();
            int ppub = art.getPrecioPublico();
            DetalleFactura dfac = new DetalleFactura(codA);
            if (array.busca(dfac.getCodArticulo()) != -1) {
                Mensajes.error("Articulo ya fue agregado");
            } else {
                array.agregar(dfac);
                insertar(String.valueOf(codA), codB, desc, String.valueOf(cant), String.valueOf(prec), String.valueOf(mont), iva, String.valueOf(descuento), String.valueOf(porcDesc), String.valueOf(neto), String.valueOf(ppub), tabla);
                String total = String.valueOf(getTotal());
                String exentas = String.valueOf(getExcetas());
                String iva5 = String.valueOf(get5());
                String iva10 = String.valueOf(get10());
                String descuent = String.valueOf(getDescuento());
                String net = String.valueOf(getNeto());
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtExentaL.setText(exentas);
                dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txt5L.setText(iva5);
                dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
                dlgVentas.txt10L.setText(iva10);
                dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
                dlgVentas.txtTotalL.setText(total);
                dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
                dlgVentas.txtDescuentoL.setText(descuent);
                dlgVentas.txtDescuento.setText(df.format(Integer.valueOf(descuent.trim().replace(".", "").replace(",", ""))));
                dlgVentas.txtNetoL.setText(net);
                dlgVentas.txtNeto.setText(df.format(Integer.valueOf(net.replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
            Mensajes.error("ERROR AL AGREGAR ARTICULO: " + e.getMessage().toUpperCase());
        }
    }

    /*   public static void addTabla(JTable tabla)//Metodo para agregar lineas al detalle
    {
        try {
            int codA = art.getCodArticulo();
            String descrip = art.getDescripcion();
            int cant = Integer.parseInt(dlgVentas.txtCant.getText());
            double prec = art.getPrecioVenta();
            double monto = Redondeo.redondearD(prec * cant);
            double sa = actStock();

            DetalleFactura df = new DetalleFactura(codA, cant, prec, monto);

            if (array.busca(df.getCodArticulo()) != -1)//Busca que el articulo no se repita
            {
                Mensajes.error("Articulo ya fue Agregado");
            } else {
                if (dlgFactura.txtCant.getText().compareTo("0") != 0)//Valida la cantidad ingresada
                {
                    if (cant < art.getStock() || cant > art.getStock())//Valida que cantidad no exceda stock
                    {
                        array.agregar(df);
                        insertar(String.valueOf(cant), String.valueOf(codA), descrip, String.valueOf(prec), String.valueOf(monto), String.valueOf(sa), tabla);
                        double total = getTotal();
                        dlgFactura.txtNeto.setText(String.valueOf(getTotal()));
                        //dlgFactura.txtDescCalculado.setText(String.valueOf(getDescuento()));
                        //dlgFactura.txtTotal.setText(String.valueOf(Redondeo.redondear(total - getDescuento())));
                    } else {
                        Mensajes.error("No tiene stock Suficiente");
                    }
                } else {
                    Mensajes.informacion("Ingrese una Cantidad");
                }
            }
        } catch (Exception e) {
            Mensajes.informacion("Eliga al menos un Articulo");
        }
    }*/
    public static void consLinea()//Buscar linea en ArrayList
    {
        int fila = dlgVentas.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgVentas.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p == -1) {
            Mensajes.informacion("Articulo no existe");
        } else {
            dfa = array.getFila(p);
            int codA = dfa.getCodArticulo();
        }
    }

    public static void delRenglon(JTable tabla)//Quita un renglon del detalle
    {
        consLinea();
        int fila = dlgVentas.tbDetalle.getSelectedRow();
        int cod = Integer.parseInt(dlgVentas.tbDetalle.getValueAt(fila, 0).toString());
        int p = array.busca(cod);
        if (p != -1) {
            int res = Mensajes.confirmar("Desea quitar esta linea");
            if (res == 0) {
                array.eliminar(p);
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                tb.removeRow(fila);
                String total = String.valueOf(Redondeo.redondearI(getTotal()));
                DecimalFormat df = new DecimalFormat("#,###");
                dlgVentas.txtTotalL.setText(String.valueOf(total));
                dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.trim().replace(".", "").replace(",", ""))));
            }
        }
    }

    /*    public static void finalizar(JTable tabla)//Evento que se dispara al presionar el boton aceptar
    {
        int fila = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgFactura.jTable1.getModel();
        int renglones = tb.getRowCount();
        for (int i = 0; i < renglones; i++) {
            fila++;
        }
        if (fila <= 0) {
            Mensajes.error("No ha ingresado artículo");
        } else {
            dlgFinFactura ff = new dlgFinFactura(null, false);
            ff.setLocationRelativeTo(null);
            double total = Redondeo.redondearD((getTotal() - actDescuento()));
            dlgFinFactura.txtTotal.setText(String.valueOf(total));
            dlgFinFactura.lblTotal.setText(String.valueOf(total));
            dlgFinFactura.lblEfectivo.setText(String.valueOf(total));
            dlgFinFactura.lblVuelto.setText(String.valueOf(actDescuento()));
            dlgFinFactura.txtAbono.requestFocus();
            ff.setVisible(true);
            dlgFinFactura.txtAbono.selectAll();
        }
    }*/
    public static int calCulos()//Metodo que realiza los calculos finales de la venta
    {
        int total = Integer.parseInt(dlgVentas.txtTotalL.getText());
        int abono = Integer.parseInt(dlgVentas.txtAbonoL.getText());
        int vuelto = abono - total;
        return /*Redondeo.redondearI*/ (vuelto);
    }

    public static void actCantidad()//Actualiza la cantidad del articulo seleccionado
    {
        try {
            int fila = dlgVentas.tbDetalle.getSelectedRow();
            int prec = Integer.parseInt(dlgVentas.tbDetalle.getValueAt(fila, 6).toString());
            double ca = Double.parseDouble(dlgVentas.tbDetalle.getValueAt(fila, 4).toString());
            String cant = String.valueOf(Mensajes.ingresarNumerosV( ca));
            String monto = String.valueOf(prec*Double.parseDouble(cant));

            int descuento;
            int neto;
            if (art.getPrecioPublico() == 0) {
                descuento = 0;
            } else {
                descuento = (art.getPrecioPublico() - art.getPrecioVenta()) * Integer.parseInt(cant);
            }
            if (art.getPrecioPublico() == 0) {
                neto = 0;
            } else {
                neto = (art.getPrecioPublico() * Integer.parseInt(cant));
            }
            int iva = art.getIVA();
            dlgVentas.tbDetalle.setValueAt(cant, fila, 3);
            dlgVentas.tbDetalle.setValueAt(cant, fila, 4);
            switch (iva) {
                case 10 -> {
                    dlgVentas.tbDetalle.setValueAt(monto, fila, 11);
                    dlgVentas.tbDetalle.setValueAt(monto, fila, 12);
                }
                case 5 -> {
                    dlgVentas.tbDetalle.setValueAt(monto, fila, 9);
                    dlgVentas.tbDetalle.setValueAt(monto, fila, 10);
                }
                default -> {
                    dlgVentas.tbDetalle.setValueAt(monto, fila, 7);
                    dlgVentas.tbDetalle.setValueAt(monto, fila, 8);
                }
            }
            dlgVentas.tbDetalle.setValueAt(monto, fila, 13);
            dlgVentas.tbDetalle.setValueAt(monto, fila, 14);
            dlgVentas.tbDetalle.setValueAt(descuento, fila, 15);
            dlgVentas.tbDetalle.setValueAt(neto, fila, 17);
            String total = String.valueOf(getTotal());
            String exentas = String.valueOf(getExcetas());
            String iva5 = String.valueOf(get5());
            String iva10 = String.valueOf(get10());
            String descuent = String.valueOf(getDescuento());
            String net = String.valueOf(getNeto());
            DecimalFormat df = new DecimalFormat("#,###");
            dlgVentas.txtExentaL.setText(exentas);
            dlgVentas.txtExenta.setText(df.format(Integer.valueOf(exentas.trim().replace(".", "").replace(",", ""))));
            dlgVentas.txt5L.setText(iva5);
            dlgVentas.txt5.setText(df.format(Integer.valueOf(iva5.replace(".", "").replace(",", ""))));
            dlgVentas.txt10L.setText(iva10);
            dlgVentas.txt10.setText(df.format(Integer.valueOf(iva10.replace(".", "").replace(",", ""))));
            dlgVentas.txtTotalL.setText(total);
            dlgVentas.txtTotal.setText(df.format(Integer.valueOf(total.replace(".", "").replace(",", ""))));
            dlgVentas.txtDescuentoL.setText(descuent);
            dlgVentas.txtDescuento.setText(df.format(Integer.valueOf(descuent.trim().replace(".", "").replace(",", ""))));
            dlgVentas.txtNetoL.setText(net);
            dlgVentas.txtNeto.setText(df.format(Integer.valueOf(net.replace(".", "").replace(",", ""))));
        } catch (Exception e) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        }
    }

    /*public static void actPrecio()//Actualiza la cantidad del articulo seleccionado
    {
        try {
            int fila = dlgFactura.jTable1.getSelectedRow();
            int cant = Integer.parseInt(dlgFactura.jTable1.getValueAt(fila, 0).toString());
            double pre = Mensajes.ingresarDecimales();
            double monto = pre * cant;
            dlgFactura.jTable1.setValueAt(pre, fila, 3);
            dlgFactura.jTable1.setValueAt(monto, fila, 4);
            double total = Redondeo.redondearD(getTotal());
            dlgFactura.txtNeto.setText(String.valueOf(total));
            //dlgFactura.txtDescCalculado.setText(String.valueOf(getDescuento()));
           // dlgFactura.txtTotal.setText(String.valueOf(Redondeo.redondear(total - getDescuento())));
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }*/

 /*public static double actDescuento()//Actualiza el descuento global
    {
        double desc = Double.parseDouble(dlgFactura.txtDescuento.getText());
        DefaultTableModel tb = (DefaultTableModel) dlgFactura.jTable1.getModel();
        int fila = tb.getRowCount();
        double descAct = ((getTotal() / 100) * desc);
        double total = getTotal();
        dlgFactura.txtTotal.setText(String.valueOf(Redondeo.redondearD(total - descAct)));
        return Redondeo.redondearD(descAct);
    }*/
    public static void canCelar()//Cancelar la venta y vaciar ArrayList
    {
        array.vaciar();
    }

    /*    public static String addFactura()//Registra la nueva factura
    {
        String msg;
        int codFacfura = Integer.parseInt(dlgFactura.txtCodFactura.getText());
        int codCliente = Integer.parseInt(dlgFactura.txtCodCliente.getText());
        int codVendedor = Integer.parseInt(dlgFactura.lblVendedor.getText());
        double descuento = Double.parseDouble(dlgFactura.txtDescCalculado.getText());
        String tipoPago = dlgFactura.cbPrecio.getSelectedItem().toString();
        String fecha = dlgFactura.dcFecha.getText();
        String fechaF = Fecha.formatoFecha(fecha);
        double neto = Double.parseDouble(dlgFactura.txtNeto.getText());
        double total = Double.parseDouble(dlgFactura.txtTotal.getText());

        Factura f = new Factura(codFacfura, codCliente, codVendedor, descuento, tipoPago, fechaF, neto, total);

        array.vaciar();

        msg = GestionarFactura.addFactura(f);

        if (msg == null) {
            Mensajes.informacion("Venta Realizada");
        } else {
            Mensajes.error(msg);
        }
        return msg;

    }*/

 /*   public static String addDetalleFactura()//Registra las lineas de la factura
    {
        String msg = null;
        int fila = dlgFactura.jTable1.getRowCount();
        for (int i = 0; i < fila; i++) {
            int codFactu = Integer.parseInt(dlgFactura.txtCodFactura.getText());
            int codArt = Integer.parseInt(dlgFactura.jTable1.getValueAt(i, 1).toString());
            int cant = Integer.parseInt(dlgFactura.jTable1.getValueAt(i, 0).toString());
            int pre = Integer.parseInt(dlgFactura.jTable1.getValueAt(i, 3).toString());
            int monto = Integer.parseInt(dlgFactura.jTable1.getValueAt(i, 4).toString());

            dfa = new DetalleFactura(codFactu, codArt, cant, pre, monto);

            msg = GestionarFactura.addDetalleFactura(dfa);
        }
        if (msg == null) {
            Mensajes.informacion("Detalle Registrado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/
    public static String anularFactura()//Metodo para anular facturas
    {
        String msg;
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
        String usuario = UsuarioL = Login.getUsuarioLogueado();
        msg = GestionarFactura.actFactura(cod, usuario);
        if (msg == null) {
            Mensajes.informacion("Venta Anulada");
            controlFactura.actStockEliminarFactura();
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    public static String actStockEliminarFactura() {
        String msg = null;
        int f = dlgConsultarFacturas.tblDetalle.getRowCount();
        for (int i = 0; i < f; i++) {
            int coda = Integer.parseInt(dlgConsultarFacturas.tblDetalle.getValueAt(i, 1).toString());
            float stt = Float.parseFloat(dlgConsultarFacturas.tblDetalle.getValueAt(i, 0).toString());
            Articulo a = new Articulo(coda, stt);
            msg = GestionarArticulos.actStockMAS(a);
        }
        if (msg == null) {
            Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }

    /*    public static String actStocks() {
        String msg = null;
        int f = dlgFactura.jTable1.getRowCount();
        for (int i = 0; i < f; i++) {
            int coA = Integer.parseInt(dlgFactura.jTable1.getValueAt(i, 1).toString());
            int st = Integer.valueOf(dlgFactura.jTable1.getValueAt(i, 5).toString());
            Articulo a = new Articulo(coA, st);
            msg = GestionarArticulos.actStock(a);
        }
        if (msg == null) {
            Mensajes.informacion("Stock Actualizado");
        } else {
            Mensajes.error(msg);
        }
        return msg;
    }*/
    public static void listFacturas(JTable tabla, String desde)//Lista las facturas realizadas
    {
        List lista = null;
        lista = GestionarFactura.listFacturas(desde);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCredito(JTable tabla, String cliente)//Lista las facturas realizadas
    {
        List lista = null;
        lista = GestionarFactura.listFacturasCredito(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendiente(JTable tabla, String cliente)//Lista las facturas realizadas
    {
        List lista = null;
        lista = GestionarFactura.listFacturasCreditoPendiente(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoActivo(JTable tabla, String cliente)//Lista las facturas realizadas
    {
        List lista = null;
        lista = GestionarFactura.listFacturasCreditoActivo(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturasCreditoPendienteActivo(JTable tabla, String cliente)//Lista las facturas realizadas
    {
        List lista = null;
        lista = GestionarFactura.listFacturasCreditoPendienteActivo(cliente);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            fila[6].toString();
            fila[7].toString();
            fila[8].toString();
            fila[9].toString();
            fila[10].toString();
            //fila[10].toString();
            if (fila[11].toString().equals("S")) {
                fila[11] = "ACTIVO";
            } else {
                fila[11] = "ANULADO";
            }
            tb.addRow(fila);
        }
    }

    public static void listFacturas2(JTable tabla)//Lista las facturas realizadas
    {
        List lista;
        lista = GestionarFactura.lisFacturas2();
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            fila[0].toString();
            fila[1].toString();
            fila[2].toString();
            fila[3].toString();
            fila[4].toString();
            tb.addRow(fila);
        }
    }

//    public static void listFacturasAnuladas(JTable tabla)//Lista las facturas realizadas
//    {
//        List lista;
//        lista = GestionarFactura.listFacturasAnuladas();
//        for (int i = 1; i < lista.size(); i++) {
//            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
//            Object[] fila = (Object[]) lista.get(i);
//            fila[0].toString();
//            fila[1].toString();
//            fila[2].toString();
//            fila[3].toString();
//            fila[4].toString();
//            tb.addRow(fila);
//        }
//    }    
    public static void listDetalle(JTable tabla)//Lista el detalle de la factura seleccionada
    {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 0).toString();
        String fecha = dlgConsultarFacturas.tblFactura.getValueAt(x, 2).toString();
        String des = dlgConsultarFacturas.tblFactura.getValueAt(x, 4).toString();
        String total = dlgConsultarFacturas.tblFactura.getValueAt(x, 5).toString();
        List lista = null;
        lista = GestionarFactura.listDetalles(cod);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }

    public static void ListClientes()//Mostrar informacion del cliente
    {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 4).toString();
        Cliente c = GestionarCliente.busCliente(cod);
        dlgConsultarFacturas.txtCodCliente.setText(String.valueOf(c.getCodCliente()));
        dlgConsultarFacturas.txtRazonSocial.setText(c.getRazonSocial());
        dlgConsultarFacturas.txtRuc.setText(c.getRuc());
        //dlgConsultarFacturas.txtDireccion.setText(c.getDireccion());
        //dlgConsultarFacturas.txtDesc.setText(String.valueOf(c.getDesc()));
    }

    public static void selecVendedor()//Seleccionar Vendedor
    {
        int x = dlgConsultarFacturas.tblFactura.getSelectedRow();
        String cod = dlgConsultarFacturas.tblFactura.getValueAt(x, 10).toString();
        Vendedor ven = GestionarVendedor.busVendedor(cod);
        dlgConsultarFacturas.txtVendedor.setText(ven.getNombreV());
    }

    public static void fillCliente(JTable tabla, String nom) {
        List lista;
        lista = GestionarFactura.fillCliente(nom);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
            Object[] fila = (Object[]) lista.get(i);
            tb.addRow(fila);
        }
    }
    
    public static int getTotalFacturado()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarFacturas.tblFactura.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            if(dlgConsultarFacturas.tblFactura.getModel().getValueAt(i, 11).equals("")){
                total += Integer.parseInt(String.valueOf(dlgConsultarFacturas.tblFactura.getModel().getValueAt(i, 9)).replace(".", "").replace(",", ""));
            }            
        }
        return /*Redondeo.redondearD*/ (total);
    }
    
    public static int getTotalFacturadoAnulado()//Calcula el total de la venta
    {
        int total = 0;
        DefaultTableModel tb = (DefaultTableModel) dlgConsultarFacturas.tblFactura.getModel();
        int fila = tb.getRowCount();
        for (int i = 0; i < fila; i++) {
            if(dlgConsultarFacturas.tblFactura.getModel().getValueAt(i, 11).equals("ANULADO")){
                total += Integer.parseInt(String.valueOf(dlgConsultarFacturas.tblFactura.getModel().getValueAt(i, 9)).replace(".", "").replace(",", ""));
            }            
        }
        return /*Redondeo.redondearD*/ (total);
    }

}
