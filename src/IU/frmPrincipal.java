package IU;

import Componentes.ConexionBD;
import Componentes.Fecha;
import Componentes.Reporte;
import Componentes.Mensajes;
import Componentes.Reloj;
import Componentes.Software;
import Componentes.generarCodigos;
import Componentes.traerIP;
import Controladores.ControlLogeo;
import Datos.GestionarImagen;
import Modelo.Imagen;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;

public final class frmPrincipal extends javax.swing.JFrame {

    public MariaDbStatement sentencia;
    public MariaDbConnection con;
    private ResultSet rs;

    public frmPrincipal() {
        initComponents();
        this.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
        try { 
            lbIp.setText("DIRECCIÓN IP : "+traerIP.getIP());
        } catch (Exception e) {
        }
        titulo();
        //prepararBD();
        Iniciar();
        cargarIcono();
        cargarTapiz();
        informacionGral();
        mnNCProveedor.setVisible(false);
        mnPagoProveedor.setVisible(false);
        mnNCVenta.setVisible(false);
        mnGNCVenta.setVisible(false);
        lbversion.setText("Todos los derechos reservados TM•SERVICES © "+Software.getVersion());
    }
    
    void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Ventana principal");
        }else{
            this.setTitle("Ventana principal del sistema "+Software.getSoftware()+" - "+Software.getDescripcion());
        }
        if(Software.getVersion().equals("null")){
            lbversion.setText("Todos los derechos reservados TM•SERVICES © ");
        }else{
            lbversion.setText("Todos los derechos reservados TM•SERVICES © "+Software.getVersion());
        }
    }

    private void Iniciar() {
        Reloj hilo = new Reloj(lblFecha);
        hilo.start();
    }

    void ubicacion() {
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(ancho, alto);
        setLocationRelativeTo(null);
    }

    void cargarTapiz() {
        try {
            Imagen imagen = GestionarImagen.fondoPrincipal();
            String nombre = "/Recursos/" + imagen.getImgFondo();
            ((JPanelConFondo) panelFondo).setImagen(nombre);
        } catch (Exception e) {
            Mensajes.informacion("Error al cargar Fondo del Sistema.");
        }
    }

    void prepararBD() {
        try {
            con = (MariaDbConnection) new ConexionBD().getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                sentencia = (MariaDbStatement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void informacionGral() {
        try {
            prepararBD();
            rs = sentencia.executeQuery("select * from v_sucursal where em_visualizar='SI' and em_indicador='S'");
            rs.first();
            try {
                if (rs.getRow() != 0) {
                    //txtCod.setText(rs.getString(1));
                    lbSucursal.setText(rs.getString(2));
                    lbEmpresa.setText(rs.getString(3));
                    lbRUC.setText(rs.getString(8));
                } else {
                    System.out.println("No se puede cargar Información Gral.");
                    frmPrincipal.lbEmpresa.setText("NOMBRE EMPRESA");
                    frmPrincipal.lbSucursal.setText("NOMBRE SUCURSAL");
                    lbRUC.setText("RUC EMPRESA");
                }
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
            rs.close();
            sentencia.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelFondo = new JPanelConFondo();
        pnlPanelAccDirectos = new javax.swing.JPanel();
        btnArticulos = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnGC = new javax.swing.JButton();
        btnGV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        lbIp = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel13 = new javax.swing.JLabel();
        lbversion = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbEmpresa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSucursal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbRUC = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rSButtonIconUno1 = new RSMaterialComponent.RSButtonIconUno();
        mbBarraMenu = new javax.swing.JMenuBar();
        mnSistema = new javax.swing.JMenu();
        itemFondo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem52 = new javax.swing.JMenuItem();
        mnCalc = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnCerrarSistema = new javax.swing.JMenuItem();
        mnConfiguracion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        mnMantenimiento = new javax.swing.JMenu();
        mnInformacion = new javax.swing.JMenu();
        itemEmpresa = new javax.swing.JMenuItem();
        itemSucursal = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        itemFamilia = new javax.swing.JMenuItem();
        itemLaboratorio = new javax.swing.JMenuItem();
        itemCiudades = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        mnEmpleados = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnComision = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnProveedores = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        mnClientes = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        mnSeguridad = new javax.swing.JMenu();
        smModUsuarios = new javax.swing.JMenuItem();
        smModUsuariosD = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        itemExportar = new javax.swing.JMenuItem();
        itemImportar = new javax.swing.JMenuItem();
        divisor4 = new javax.swing.JMenu();
        mnCaja = new javax.swing.JMenu();
        mnIniciarCaja = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        mnCierredeCaja = new javax.swing.JMenuItem();
        divisor5 = new javax.swing.JMenu();
        mnAyuda1 = new javax.swing.JMenu();
        mnIngresosVarios = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        mnGastosVarios = new javax.swing.JMenuItem();
        divisor6 = new javax.swing.JMenu();
        mnArticulos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnCompras = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        mnNCProveedor = new javax.swing.JMenuItem();
        mnPagoProveedor = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnGC = new javax.swing.JMenuItem();
        mnVentas = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        mnNCVenta = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnGV = new javax.swing.JMenuItem();
        mnGVE = new javax.swing.JMenuItem();
        mnGNCVenta = new javax.swing.JMenuItem();
        mnGPE = new javax.swing.JMenuItem();
        mnReportes = new javax.swing.JMenu();
        rpVentas = new javax.swing.JMenu();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        rpCompras = new javax.swing.JMenu();
        rpDevoluciones = new javax.swing.JMenu();
        rpPresupuestos = new javax.swing.JMenu();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        rpArticulos = new javax.swing.JMenu();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        rpClientes = new javax.swing.JMenu();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        rpProveedores = new javax.swing.JMenu();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        rpVendedores = new javax.swing.JMenu();
        jMenuItem54 = new javax.swing.JMenuItem();
        mnAyuda = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelImage1.setBackground(new java.awt.Color(255, 255, 255));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/0-102-102.png"))); // NOI18N
        panelImage1.setPreferredSize(new java.awt.Dimension(690, 418));

        pnlPanelAccDirectos.setBackground(new java.awt.Color(255, 255, 255));
        pnlPanelAccDirectos.setOpaque(false);
        pnlPanelAccDirectos.setLayout(new java.awt.GridLayout(1, 0));

        btnArticulos.setBackground(new java.awt.Color(210, 229, 235));
        btnArticulos.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnArticulos.setForeground(new java.awt.Color(0, 102, 102));
        btnArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildorax45.png"))); // NOI18N
        btnArticulos.setText("Gestionar Productos - F1");
        btnArticulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnArticulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosActionPerformed(evt);
            }
        });
        pnlPanelAccDirectos.add(btnArticulos);

        btnProveedores.setBackground(new java.awt.Color(210, 229, 235));
        btnProveedores.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(0, 102, 102));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/proveedores40.png"))); // NOI18N
        btnProveedores.setText("Gestionar proveedores - F2");
        btnProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });
        pnlPanelAccDirectos.add(btnProveedores);

        btnClientes.setBackground(new java.awt.Color(210, 229, 235));
        btnClientes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(0, 102, 102));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cliente40.png"))); // NOI18N
        btnClientes.setText("Gestionar clientes - F3");
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        pnlPanelAccDirectos.add(btnClientes);

        btnCompras.setBackground(new java.awt.Color(210, 229, 235));
        btnCompras.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(0, 102, 102));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/comprax40.png"))); // NOI18N
        btnCompras.setText("Registrar compras - F4");
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });
        pnlPanelAccDirectos.add(btnCompras);

        btnVentas.setBackground(new java.awt.Color(210, 229, 235));
        btnVentas.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(0, 102, 102));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ventax40.png"))); // NOI18N
        btnVentas.setText("Realizar ventas - F5");
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        pnlPanelAccDirectos.add(btnVentas);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnGC.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnGC.setForeground(new java.awt.Color(0, 102, 102));
        btnGC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/settings-icon_x40.png"))); // NOI18N
        btnGC.setText("Gest. compras registradas");
        btnGC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGCActionPerformed(evt);
            }
        });
        jPanel3.add(btnGC);

        btnGV.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnGV.setForeground(new java.awt.Color(0, 102, 102));
        btnGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/settings-icon_x40.png"))); // NOI18N
        btnGV.setText("Gest. ventas realizadas");
        btnGV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGVActionPerformed(evt);
            }
        });
        jPanel3.add(btnGV);

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlPanelAccDirectos, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPanelAccDirectos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(403, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/P-VENTAS-ICONX300.png"))); // NOI18N

        jToolBar1.setBackground(new java.awt.Color(102, 102, 102));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel5.setText("    ");
        jToolBar1.add(jLabel5);

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha: ");
        jToolBar1.add(lblFecha);

        jLabel9.setText("   ");
        jToolBar1.add(jLabel9);
        jToolBar1.add(jSeparator18);

        jLabel12.setText("   ");
        jToolBar1.add(jLabel12);

        lbIp.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbIp.setForeground(new java.awt.Color(255, 255, 255));
        lbIp.setText("ip");
        jToolBar1.add(lbIp);

        jLabel19.setText("   ");
        jToolBar1.add(jLabel19);
        jToolBar1.add(jSeparator3);

        jLabel13.setText("   ");
        jToolBar1.add(jLabel13);

        lbversion.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbversion.setForeground(new java.awt.Color(255, 255, 255));
        lbversion.setText("Versión del Software:");
        jToolBar1.add(lbversion);

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Software de gestión de Artículos, Compras y Ventas.");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("INFORMACIÓN DE LA EMPRESA");
        jLabel17.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RAZÓN SOCIAL:");

        lbEmpresa.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lbEmpresa.setText("SIN ESPECIFICAR");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SUCURSAL:");

        lbSucursal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbSucursal.setForeground(new java.awt.Color(255, 255, 255));
        lbSucursal.setText("SIN ESPECIFICAR");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("R.U.C.:");

        lbRUC.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbRUC.setForeground(new java.awt.Color(255, 255, 255));
        lbRUC.setText("SIN ESPECIFICAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbRUC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmpresa)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRUC)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbSucursal))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(210, 229, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("SIN ESPECIFICAR");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USUARIO:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PERFIL:");

        lbUsuario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("SIN ESPECIFICAR");

        lbPerfil.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbPerfil.setForeground(new java.awt.Color(255, 255, 255));
        lbPerfil.setText("SIN ESPECIFICAR");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ACCESO AL SISTEMA");
        jLabel18.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        rSButtonIconUno1.setBackground(new java.awt.Color(0, 102, 102));
        rSButtonIconUno1.setBackgroundHover(new java.awt.Color(3, 136, 136));
        rSButtonIconUno1.setForegroundHover(new java.awt.Color(255, 0, 0));
        rSButtonIconUno1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButtonIconUno1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rSButtonIconUno1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        rSButtonIconUno1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rSButtonIconUno1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rSButtonIconUno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconUno1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSButtonIconUno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButtonIconUno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(panelImage1);

        mbBarraMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        mnSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/menubuttonofthreelines_79781.png"))); // NOI18N
        mnSistema.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnSistema.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemFondo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15.png"))); // NOI18N
        itemFondo.setText("Gestionar Fondo del Sistema");
        itemFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFondoActionPerformed(evt);
            }
        });
        mnSistema.add(itemFondo);
        mnSistema.add(jSeparator4);

        jMenuItem52.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/datalook15.png"))); // NOI18N
        jMenuItem52.setText("Cerrar sesión");
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        mnSistema.add(jMenuItem52);

        mnCalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calculator.png"))); // NOI18N
        mnCalc.setText("Calculadora de windows");
        mnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCalcActionPerformed(evt);
            }
        });
        mnSistema.add(mnCalc);
        mnSistema.add(jSeparator12);

        mnCerrarSistema.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnCerrarSistema.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnCerrarSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        mnCerrarSistema.setText("Cerrar el sistema              ");
        mnCerrarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCerrarSistemaActionPerformed(evt);
            }
        });
        mnSistema.add(mnCerrarSistema);

        mbBarraMenu.add(mnSistema);

        mnConfiguracion.setText("Configuración");
        mnConfiguracion.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnConfiguracion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        jMenuItem1.setText("Establecer impresora predeterminada");
        jMenuItem1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem1.setOpaque(true);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnConfiguracion.add(jMenuItem1);

        jMenuItem9.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/datalook15.png"))); // NOI18N
        jMenuItem9.setText("Información del Software");
        jMenuItem9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem9.setOpaque(true);
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mnConfiguracion.add(jMenuItem9);

        mbBarraMenu.add(mnConfiguracion);

        mnMantenimiento.setText("Mantenimiento");
        mnMantenimiento.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnMantenimiento.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        mnInformacion.setBackground(new java.awt.Color(255, 255, 255));
        mnInformacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15.png"))); // NOI18N
        mnInformacion.setText("Informaciones generales y auxiliares");
        mnInformacion.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnInformacion.setOpaque(true);

        itemEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        itemEmpresa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        itemEmpresa.setText("Gestionar empresa");
        itemEmpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        itemEmpresa.setOpaque(true);
        itemEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmpresaActionPerformed(evt);
            }
        });
        mnInformacion.add(itemEmpresa);

        itemSucursal.setBackground(new java.awt.Color(255, 255, 255));
        itemSucursal.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        itemSucursal.setText("Gestionar sucursales");
        itemSucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        itemSucursal.setOpaque(true);
        itemSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSucursalActionPerformed(evt);
            }
        });
        mnInformacion.add(itemSucursal);

        jSeparator14.setOpaque(true);
        mnInformacion.add(jSeparator14);

        itemFamilia.setBackground(new java.awt.Color(255, 255, 255));
        itemFamilia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        itemFamilia.setText("Gestionar familias");
        itemFamilia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        itemFamilia.setOpaque(true);
        itemFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFamiliaActionPerformed(evt);
            }
        });
        mnInformacion.add(itemFamilia);

        itemLaboratorio.setBackground(new java.awt.Color(255, 255, 255));
        itemLaboratorio.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        itemLaboratorio.setText("Gestionar Marcas");
        itemLaboratorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        itemLaboratorio.setOpaque(true);
        itemLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLaboratorioActionPerformed(evt);
            }
        });
        mnInformacion.add(itemLaboratorio);

        itemCiudades.setBackground(new java.awt.Color(255, 255, 255));
        itemCiudades.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemCiudades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        itemCiudades.setText("Gestionar ciudades");
        itemCiudades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        itemCiudades.setOpaque(true);
        itemCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCiudadesActionPerformed(evt);
            }
        });
        mnInformacion.add(itemCiudades);

        jMenuItem35.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem35.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        jMenuItem35.setText("Gestionar motivos");
        jMenuItem35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem35.setOpaque(true);
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem35);

        jSeparator9.setOpaque(true);
        mnInformacion.add(jSeparator9);

        jMenuItem51.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem51.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        jMenuItem51.setText("Gestionar motivos de ingresos");
        jMenuItem51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem51.setOpaque(true);
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem51);

        jMenuItem53.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem53.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        jMenuItem53.setText("Gestionar motivos de gastos");
        jMenuItem53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem53.setOpaque(true);
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        mnInformacion.add(jMenuItem53);

        mnMantenimiento.add(mnInformacion);

        jSeparator13.setOpaque(true);
        mnMantenimiento.add(jSeparator13);

        mnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        mnEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/person15.png"))); // NOI18N
        mnEmpleados.setText("Empleados");
        mnEmpleados.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnEmpleados.setOpaque(true);

        jMenuItem8.setBackground(java.awt.Color.white);
        jMenuItem8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        jMenuItem8.setText("Gestionar empleados (vendedores)");
        jMenuItem8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem8.setOpaque(true);
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mnEmpleados.add(jMenuItem8);

        jSeparator2.setOpaque(true);
        mnEmpleados.add(jSeparator2);

        mnComision.setBackground(java.awt.Color.white);
        mnComision.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnComision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        mnComision.setText("Comisiones");
        mnComision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnComision.setOpaque(true);
        mnComision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnComisionActionPerformed(evt);
            }
        });
        mnEmpleados.add(mnComision);

        jMenuItem10.setBackground(java.awt.Color.white);
        jMenuItem10.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem10.setText("Reporte de Ventas");
        jMenuItem10.setOpaque(true);
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        mnEmpleados.add(jMenuItem10);

        mnMantenimiento.add(mnEmpleados);

        mnProveedores.setBackground(new java.awt.Color(255, 255, 255));
        mnProveedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/person15.png"))); // NOI18N
        mnProveedores.setText("Proveedores");
        mnProveedores.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnProveedores.setOpaque(true);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem7.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        jMenuItem7.setText("Gestionar proveedores                                    ");
        jMenuItem7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem7.setOpaque(true);
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnProveedores.add(jMenuItem7);

        mnMantenimiento.add(mnProveedores);

        jSeparator11.setOpaque(true);
        mnMantenimiento.add(jSeparator11);

        mnClientes.setBackground(new java.awt.Color(255, 255, 255));
        mnClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/person15.png"))); // NOI18N
        mnClientes.setText("Clientes");
        mnClientes.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnClientes.setOpaque(true);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem6.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (2).png"))); // NOI18N
        jMenuItem6.setText("Gestionar clientes                                  ");
        jMenuItem6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem6.setOpaque(true);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnClientes.add(jMenuItem6);

        mnMantenimiento.add(mnClientes);

        mnSeguridad.setBackground(new java.awt.Color(255, 255, 255));
        mnSeguridad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/security15.png"))); // NOI18N
        mnSeguridad.setText("Seguridad");
        mnSeguridad.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnSeguridad.setOpaque(true);

        smModUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        smModUsuarios.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        smModUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/securityOk15.png"))); // NOI18N
        smModUsuarios.setText("Gestionar usuarios");
        smModUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        smModUsuarios.setOpaque(true);
        smModUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smModUsuariosActionPerformed(evt);
            }
        });
        mnSeguridad.add(smModUsuarios);

        smModUsuariosD.setBackground(new java.awt.Color(255, 255, 255));
        smModUsuariosD.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        smModUsuariosD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/securityOk15.png"))); // NOI18N
        smModUsuariosD.setText("Gestionar usuarios - Desarrollador");
        smModUsuariosD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        smModUsuariosD.setOpaque(true);
        smModUsuariosD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smModUsuariosDActionPerformed(evt);
            }
        });
        mnSeguridad.add(smModUsuariosD);

        jSeparator16.setOpaque(true);
        mnSeguridad.add(jSeparator16);

        itemExportar.setBackground(new java.awt.Color(255, 255, 255));
        itemExportar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/export15.png"))); // NOI18N
        itemExportar.setText("Generar respaldo (Backup)");
        itemExportar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        itemExportar.setOpaque(true);
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        mnSeguridad.add(itemExportar);

        itemImportar.setBackground(new java.awt.Color(255, 255, 255));
        itemImportar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/import15.png"))); // NOI18N
        itemImportar.setText("Restaurar backup (Importar BD)");
        itemImportar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        itemImportar.setOpaque(true);
        itemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemImportarActionPerformed(evt);
            }
        });
        mnSeguridad.add(itemImportar);

        mnMantenimiento.add(mnSeguridad);

        mbBarraMenu.add(mnMantenimiento);

        divisor4.setText("|");
        divisor4.setEnabled(false);
        divisor4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor4);

        mnCaja.setText("Movimiento Diario");
        mnCaja.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnCaja.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        mnIniciarCaja.setBackground(new java.awt.Color(255, 255, 255));
        mnIniciarCaja.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnIniciarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/abrircaja.png"))); // NOI18N
        mnIniciarCaja.setText("Inicializar Movimiento del Día (Apertura de Caja/s)");
        mnIniciarCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnIniciarCaja.setOpaque(true);
        mnIniciarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIniciarCajaActionPerformed(evt);
            }
        });
        mnCaja.add(mnIniciarCaja);

        jSeparator15.setOpaque(true);
        mnCaja.add(jSeparator15);

        mnCierredeCaja.setBackground(new java.awt.Color(255, 255, 255));
        mnCierredeCaja.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnCierredeCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cajacerrar.png"))); // NOI18N
        mnCierredeCaja.setText("Finalizar Movimiento del Día (Cierre de caja/s)");
        mnCierredeCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnCierredeCaja.setOpaque(true);
        mnCierredeCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCierredeCajaActionPerformed(evt);
            }
        });
        mnCaja.add(mnCierredeCaja);

        mbBarraMenu.add(mnCaja);

        divisor5.setText("|");
        divisor5.setEnabled(false);
        divisor5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor5);

        mnAyuda1.setText("Gastos e Ingresos");
        mnAyuda1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnAyuda1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        mnIngresosVarios.setBackground(new java.awt.Color(255, 255, 255));
        mnIngresosVarios.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnIngresosVarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cajasumar.png"))); // NOI18N
        mnIngresosVarios.setText("Registrar Ingresos y cobranzas");
        mnIngresosVarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnIngresosVarios.setOpaque(true);
        mnIngresosVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIngresosVariosActionPerformed(evt);
            }
        });
        mnAyuda1.add(mnIngresosVarios);

        jSeparator19.setOpaque(true);
        mnAyuda1.add(jSeparator19);

        mnGastosVarios.setBackground(new java.awt.Color(255, 255, 255));
        mnGastosVarios.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnGastosVarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cajarestar.png"))); // NOI18N
        mnGastosVarios.setText("Registrar gastos y retiros");
        mnGastosVarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnGastosVarios.setOpaque(true);
        mnGastosVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGastosVariosActionPerformed(evt);
            }
        });
        mnAyuda1.add(mnGastosVarios);

        mbBarraMenu.add(mnAyuda1);

        divisor6.setText("|");
        divisor6.setEnabled(false);
        divisor6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        divisor6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        divisor6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mbBarraMenu.add(divisor6);

        mnArticulos.setText("Productos");
        mnArticulos.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnArticulos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildorax40 - copia.png"))); // NOI18N
        jMenuItem2.setText("Gestionar todos los productos               ");
        jMenuItem2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem2.setOpaque(true);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnArticulos.add(jMenuItem2);

        jSeparator10.setOpaque(true);
        mnArticulos.add(jSeparator10);

        jMenuItem3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildoraajustex45 - copia.png"))); // NOI18N
        jMenuItem3.setText("Ajustar stock de productos");
        jMenuItem3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem3.setOpaque(true);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnArticulos.add(jMenuItem3);

        jSeparator1.setOpaque(true);
        mnArticulos.add(jSeparator1);

        jMenuItem4.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildorasalidazx45 - copia.png"))); // NOI18N
        jMenuItem4.setText("Aplicar salida a productos");
        jMenuItem4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem4.setOpaque(true);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnArticulos.add(jMenuItem4);

        jMenuItem5.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pildorasalidazx45 - copia.png"))); // NOI18N
        jMenuItem5.setText("Controlar salidas aplicadas a productos");
        jMenuItem5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem5.setOpaque(true);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnArticulos.add(jMenuItem5);

        mbBarraMenu.add(mnArticulos);

        mnCompras.setText("Compras");
        mnCompras.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnCompras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jMenuItem30.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem30.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem30.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/comprax40 - copia.png"))); // NOI18N
        jMenuItem30.setText("Registrar compras de proveedores");
        jMenuItem30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem30.setOpaque(true);
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        mnCompras.add(jMenuItem30);

        mnNCProveedor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnNCProveedor.setText("Notas de Crédito del Proveedor");
        mnNCProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNCProveedorActionPerformed(evt);
            }
        });
        mnCompras.add(mnNCProveedor);

        mnPagoProveedor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnPagoProveedor.setText("Pago a Proveedores");
        mnPagoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPagoProveedorActionPerformed(evt);
            }
        });
        mnCompras.add(mnPagoProveedor);

        jSeparator6.setOpaque(true);
        mnCompras.add(jSeparator6);

        mnGC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        mnGC.setBackground(new java.awt.Color(255, 255, 255));
        mnGC.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnGC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        mnGC.setText("Gestionar todas las compras realizadas                                  ");
        mnGC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnGC.setOpaque(true);
        mnGC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGCActionPerformed(evt);
            }
        });
        mnCompras.add(mnGC);

        mbBarraMenu.add(mnCompras);

        mnVentas.setText("Ventas");
        mnVentas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnVentas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem23.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem23.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ventax40 - copia.png"))); // NOI18N
        jMenuItem23.setText("Realizar ventas");
        jMenuItem23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem23.setOpaque(true);
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        mnVentas.add(jMenuItem23);

        jMenuItem24.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ventapresupuestox40 - copia.png"))); // NOI18N
        jMenuItem24.setText("Generar presupuestos");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        mnVentas.add(jMenuItem24);

        mnNCVenta.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnNCVenta.setText("Notas de Crédito");
        mnNCVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNCVentaActionPerformed(evt);
            }
        });
        mnVentas.add(mnNCVenta);

        jSeparator5.setOpaque(true);
        mnVentas.add(jSeparator5);

        mnGV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        mnGV.setBackground(new java.awt.Color(255, 255, 255));
        mnGV.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        mnGV.setText("Gestionar todas las ventas realizadas                                     ");
        mnGV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnGV.setOpaque(true);
        mnGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGVActionPerformed(evt);
            }
        });
        mnVentas.add(mnGV);

        mnGVE.setBackground(new java.awt.Color(255, 255, 255));
        mnGVE.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnGVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/setting15 (3).png"))); // NOI18N
        mnGVE.setText("Extracto de cuentas - ventas crédito");
        mnGVE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mnGVE.setOpaque(true);
        mnGVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGVEActionPerformed(evt);
            }
        });
        mnVentas.add(mnGVE);

        mnGNCVenta.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnGNCVenta.setText("Consultar Notas de Crédito");
        mnGNCVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGNCVentaActionPerformed(evt);
            }
        });
        mnVentas.add(mnGNCVenta);

        mnGPE.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        mnGPE.setText("Gestionar presupuestos elaborados");
        mnGPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGPEActionPerformed(evt);
            }
        });
        mnVentas.add(mnGPE);

        mbBarraMenu.add(mnVentas);

        mnReportes.setText("Reportes");
        mnReportes.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnReportes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        rpVentas.setBackground(new java.awt.Color(255, 255, 255));
        rpVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rpVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        rpVentas.setText("Ventas");
        rpVentas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpVentas.setOpaque(true);

        jMenuItem27.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem27.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem27.setText("Resumen de Caja");
        jMenuItem27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem27.setOpaque(true);
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        rpVentas.add(jMenuItem27);

        jMenuItem66.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem66.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem66.setText("Total de ventas (Valorizado)");
        jMenuItem66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem66.setOpaque(true);
        jMenuItem66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem66ActionPerformed(evt);
            }
        });
        rpVentas.add(jMenuItem66);

        jMenuItem67.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem67.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem67.setText("Ranking de ventas");
        jMenuItem67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem67.setOpaque(true);
        jMenuItem67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem67ActionPerformed(evt);
            }
        });
        rpVentas.add(jMenuItem67);

        mnReportes.add(rpVentas);

        rpCompras.setBackground(new java.awt.Color(255, 255, 255));
        rpCompras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rpCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        rpCompras.setText("Compras");
        rpCompras.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpCompras.setOpaque(true);
        mnReportes.add(rpCompras);

        rpDevoluciones.setBackground(new java.awt.Color(255, 255, 255));
        rpDevoluciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rpDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        rpDevoluciones.setText("Devoluciones");
        rpDevoluciones.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpDevoluciones.setOpaque(true);
        mnReportes.add(rpDevoluciones);

        rpPresupuestos.setBackground(new java.awt.Color(255, 255, 255));
        rpPresupuestos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rpPresupuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        rpPresupuestos.setText("Presupuestos");
        rpPresupuestos.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpPresupuestos.setOpaque(true);
        mnReportes.add(rpPresupuestos);

        jSeparator7.setOpaque(true);
        mnReportes.add(jSeparator7);

        rpArticulos.setBackground(new java.awt.Color(255, 255, 255));
        rpArticulos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rpArticulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        rpArticulos.setText("Artículos");
        rpArticulos.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpArticulos.setOpaque(true);

        jMenuItem36.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem36.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem36.setText("Listado e Inventario de Artículos");
        jMenuItem36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem36.setOpaque(true);
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        rpArticulos.add(jMenuItem36);

        jMenuItem38.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem38.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem38.setText("Stock Valorizado");
        jMenuItem38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem38.setOpaque(true);
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        rpArticulos.add(jMenuItem38);

        jSeparator8.setOpaque(true);
        rpArticulos.add(jSeparator8);

        jMenuItem40.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem40.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem40.setText("Salidas por Artículo");
        jMenuItem40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem40.setOpaque(true);
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        rpArticulos.add(jMenuItem40);

        jMenuItem41.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem41.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem41.setText("Salidas por Motivo");
        jMenuItem41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem41.setOpaque(true);
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        rpArticulos.add(jMenuItem41);

        mnReportes.add(rpArticulos);

        rpClientes.setBackground(new java.awt.Color(255, 255, 255));
        rpClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rpClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        rpClientes.setText("Clientes");
        rpClientes.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpClientes.setOpaque(true);

        jMenuItem42.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem42.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem42.setText("Listado de Clientes");
        jMenuItem42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem42.setOpaque(true);
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        rpClientes.add(jMenuItem42);

        jMenuItem43.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem43.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem43.setText("Artículos comprados por el cliente");
        jMenuItem43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem43.setOpaque(true);
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        rpClientes.add(jMenuItem43);

        jMenuItem44.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem44.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem44.setText("Ventas por cliente");
        jMenuItem44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem44.setOpaque(true);
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        rpClientes.add(jMenuItem44);

        jMenuItem45.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem45.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem45.setText("Clientes Activos");
        jMenuItem45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem45.setOpaque(true);
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        rpClientes.add(jMenuItem45);

        mnReportes.add(rpClientes);

        rpProveedores.setBackground(new java.awt.Color(255, 255, 255));
        rpProveedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rpProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        rpProveedores.setText("Proveedores");
        rpProveedores.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpProveedores.setOpaque(true);

        jMenuItem46.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem46.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem46.setText("Listado");
        jMenuItem46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem46.setOpaque(true);
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        rpProveedores.add(jMenuItem46);

        jMenuItem47.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem47.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem47.setText("Artículos Comprados");
        jMenuItem47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem47.setOpaque(true);
        jMenuItem47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem47ActionPerformed(evt);
            }
        });
        rpProveedores.add(jMenuItem47);

        mnReportes.add(rpProveedores);

        rpVendedores.setBackground(new java.awt.Color(255, 255, 255));
        rpVendedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        rpVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/List.png"))); // NOI18N
        rpVendedores.setText("Vendedores");
        rpVendedores.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rpVendedores.setOpaque(true);

        jMenuItem54.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem54.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        jMenuItem54.setText("Comisiones generados");
        jMenuItem54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem54.setOpaque(true);
        jMenuItem54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem54ActionPerformed(evt);
            }
        });
        rpVendedores.add(jMenuItem54);

        mnReportes.add(rpVendedores);

        mbBarraMenu.add(mnReportes);

        mnAyuda.setText("Sistema");
        mnAyuda.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        mnAyuda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jMenuItem17.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem17.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Copyright 25.png"))); // NOI18N
        jMenuItem17.setText("Acerca de...");
        jMenuItem17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jMenuItem17.setOpaque(true);
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        mnAyuda.add(jMenuItem17);

        mbBarraMenu.add(mnAyuda);

        setJMenuBar(mbBarraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {
            dlgAjusteStock ajuste = new dlgAjusteStock(this, true);
            ajuste.setLocationRelativeTo(null);
            ajuste.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        /*try {
            dlgSalidaMercaderia salida = new dlgSalidaMercaderia(this, true);
            salida.setLocationRelativeTo(null);
            salida.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
       Mensajes.Sistema("La función: Aplicar salidas a artículos se encuentra bloqueada \nen estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        /*try {
            dlgConSalidas conSalidas = new dlgConSalidas(this, true);
            conSalidas.setLocationRelativeTo(null);
            conSalidas.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }*/
        Mensajes.Sistema("La función: Controlar salidas aplicadas a artículos se encuentra bloqueada \nen estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        abrirClientes();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        abrirArticulos();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnCerrarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCerrarSistemaActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_mnCerrarSistemaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        abrirProveedor();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void itemLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLaboratorioActionPerformed
        // TODO add your handling code here:
        try {
            dlgLaboratorio laboratorio = new dlgLaboratorio(this, true);
            laboratorio.setLocationRelativeTo(null);
            laboratorio.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemLaboratorioActionPerformed

    private void itemCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCiudadesActionPerformed
        // TODO add your handling code here:
        try {
            dlgCiudad ciu = new dlgCiudad(this, true);
            ciu.setLocationRelativeTo(null);
            ciu.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemCiudadesActionPerformed

    private void itemFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFamiliaActionPerformed
        // TODO add your handling code here:
        try {
            dlgFamilia familia = new dlgFamilia(this, true);
            familia.setLocationRelativeTo(null);
            familia.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemFamiliaActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        try {
            dlgVendedor vend = new dlgVendedor(this, true);
            vend.setSize(1100, 490);
            vend.setLocationRelativeTo(null);
            vend.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        btnComprasActionPerformed(null);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        // TODO add your handling code here:
        try {
            dlgMotivo motivo = new dlgMotivo(this, true);
            motivo.setLocationRelativeTo(null);
            motivo.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        btnVentasActionPerformed(null);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        /*   dlgPresupuestos presupuesto = new dlgPresupuestos(this, false);
        presupuesto.setLocationRelativeTo(null);
        presupuesto.setVisible(true);*/
        Mensajes.Sistema("La función: Generar presupuestos de venta se encuentra bloqueada \nen estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void mnGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGVActionPerformed
        // TODO add your handling code here:
            try {
            dlgConsultarFacturas cf = new dlgConsultarFacturas(this, true);
            cf.setLocationRelativeTo(null);
            cf.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnGVActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        // TODO add your handling code here:
       Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
      /*  GenerarReporte nr;
        nr = new GenerarReporte();
        nr.MostrarReporte(System.getProperty("user.dir") + "/Reportes/Proveedores/Proveedor.jasper", "Reporte de Proveedores", "Proveedores.pdf");*/
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    private void mnGPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGPEActionPerformed
        // TODO add your handling code here:
        /*  try {
            dlgConsultarPresupuesto cp = new dlgConsultarPresupuesto(this, false);
            cp.setLocationRelativeTo(null);
            cp.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }*/
        Mensajes.Sistema("La función: Gestionar presupuestos elaborados se encuentra bloqueada \nen estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_mnGPEActionPerformed

    private void mnGNCVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGNCVentaActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsNotaCredito cnc = new dlgConsNotaCredito(this, false);
            cnc.setLocationRelativeTo(null);
            cnc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_mnGNCVentaActionPerformed

    private void mnNCVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNCVentaActionPerformed
        // TODO add your handling code here:
        dlgNotasCredito nc = new dlgNotasCredito(this, true);
        nc.setLocationRelativeTo(null);
        nc.setVisible(true);
    }//GEN-LAST:event_mnNCVentaActionPerformed

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        // TODO add your handling code here:
        CerrarCesion();


    }//GEN-LAST:event_jMenuItem52ActionPerformed

    public void salir() {
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del sistema?");
        if (rpta == 0) {
            String msg = ControlLogeo.desLogeo();
            System.exit(0);
            //this.dispose();

        }
    }

    public void CerrarCesion() {
        int rpta = Mensajes.confirmar("¿Seguro que desea Cerrar Sesión?");
        if (rpta == 0) {
            String msg = ControlLogeo.desLogeo();
            //System.exit(0);
            this.dispose();
            frmAcceso ac = new frmAcceso();
            ac.setLocationRelativeTo(null);
            ac.setVisible(true);

        }
    }
    
    void abrirImpresoras() {
        try {
            dlgImpresoras impre = new dlgImpresoras(this, true);
            impre.setLocationRelativeTo(null);
            impre.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirFactura() {
        try {
            dlgVentas factura = new dlgVentas(this, true);
            factura.setLocationRelativeTo(null);
            factura.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirCompras() {
        try {
            dlgCompras compras = new dlgCompras(this, false);
            compras.setLocationRelativeTo(null);
            compras.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }

    }

    void abrirClientes() {
        try {
            dlgClientes clientes = new dlgClientes(this, true);
            clientes.setSize(1000, 540);
            clientes.setLocationRelativeTo(null);
            clientes.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void abrirArticulos() {
        try {
            dlgArticulos articulo = new dlgArticulos(this, false);
            articulo.setLocationRelativeTo(null);
            articulo.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    private void smModUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smModUsuariosActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestUsuario gu = new dlgGestUsuario(this, true);
            gu.setLocationRelativeTo(null);
            gu.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_smModUsuariosActionPerformed

    private void mnComisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnComisionActionPerformed
        // TODO add your handling code here:
        /*dlgComisionEmpleado ce = new dlgComisionEmpleado(this, true);
        ce.setLocationRelativeTo(null);
        ce.setVisible(true);*/
        Mensajes.Sistema("La función: Comisiones se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_mnComisionActionPerformed

    private void mnGCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGCActionPerformed
        // TODO add your handling code here:
            try {
            dlgConsultarCompras consCompras = new dlgConsultarCompras(this, true);
            consCompras.setLocationRelativeTo(null);
            consCompras.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnGCActionPerformed

    private void mnCierredeCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCierredeCajaActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja ya fue cerrada.\n\nPodra acceder a este formulario para visualizar los movimientos en la siguiente apertura de caja.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                dlgCajaDia cajaDia = new dlgCajaDia(this, true);
                cajaDia.setLocationRelativeTo(null);
                cajaDia.setVisible(true);
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.informacion("ESTA FUNCION ESTA SIENDO DESARROLLADO ACTUALMENTE");
    }//GEN-LAST:event_mnCierredeCajaActionPerformed

    private void mnGastosVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGastosVariosActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara registrar pagos de servicios u otros egresos sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                dlgGastos gastos = new dlgGastos(this, true);
                gastos.setLocationRelativeTo(null);
                gastos.setVisible(true);
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnGastosVariosActionPerformed

    private void mnIngresosVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIngresosVariosActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara registrar cobranzas u otros ingresos sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
            } else {
                dlgIngreso ingreso = new dlgIngreso(this, true);
                ingreso.setLocationRelativeTo(null);
                ingreso.setVisible(true);
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
        //Mensajes.informacion("ESTA FUNCION ESTARA DISPONIBLE EN LA SIGUIENTE ACTUALIZACION");
    }//GEN-LAST:event_mnIngresosVariosActionPerformed

    private void itemFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFondoActionPerformed
        // TODO add your handling code here:
        try {
            dlgFondo fondo = new dlgFondo(this, true);
            fondo.setLocationRelativeTo(null);
            fondo.setVisible(true);
            //((JPanelConFondo) panelFondo).setImagen("/Recursos/imagen8.jpg");
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemFondoActionPerformed

    private void itemEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmpresaActionPerformed
        // TODO add your handling code here:
        try {
            dlgEmpresa empresa = new dlgEmpresa(this, true);
            empresa.setLocationRelativeTo(null);
            empresa.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemEmpresaActionPerformed

    private void itemSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSucursalActionPerformed
        // TODO add your handling code here:
        try {
            dlgSucursal sucursal = new dlgSucursal(this, true);
            sucursal.setLocationRelativeTo(null);
            sucursal.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_itemSucursalActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("La función: Generar respaldo se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_itemExportarActionPerformed

    private void itemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemImportarActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("La función: Restaurar backup se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_itemImportarActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        dlgAyuda a = new dlgAyuda(this, true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("La función: Reporte de ventas se encuentra bloqueada en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void mnPagoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPagoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnPagoProveedorActionPerformed

    private void mnNCProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNCProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnNCProveedorActionPerformed

    private void mnIniciarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIniciarCajaActionPerformed
        // TODO add your handling code here:
        try {
            String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja WHERE ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
            if (!fe.equals(Fecha.fechaCorrecta())) {
                dlgCaja caja = new dlgCaja(this, true);
                caja.setLocationRelativeTo(null);
                caja.setVisible(true);
            } else {
                Mensajes.informacion("La caja ya fue inicializada.\n\nPuede comenzar a registrar compras o realizar ventas\nsin ningún inconveniente.");
            }
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_mnIniciarCajaActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        // TODO add your handling code here:
        try {
            dlgDetalleIngreso detalleI = new dlgDetalleIngreso(this, true);
            detalleI.setLocationRelativeTo(null);
            detalleI.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        // TODO add your handling code here:
        try {
            dlgDetalleGasto detalleG = new dlgDetalleGasto(this, true);
            detalleG.setLocationRelativeTo(null);
            detalleG.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
        if (!fe.equals(Fecha.fechaCorrecta())) {
            Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a vender sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
        } else {
            abrirFactura();
        }
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        abrirClientes();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        // TODO add your handling code here:
        String fe = generarCodigos.getFecha("SELECT ca_fechainicio FROM caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1");
        if (!fe.equals(Fecha.fechaCorrecta())) {
            Mensajes.informacion("La caja del día aún no ha sido inicializada.\n\nPara poder comenzar a registrar las compras a proveedores sera necesario hacerlo.\nLa apertura puede realizarse con los perfiles ADMINISTRADOR y VENTAS.");
        } else {
            abrirCompras();
        }
    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        // TODO add your handling code here:
        abrirProveedor();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosActionPerformed

        // TODO add your handling code here:
        abrirArticulos();
    }//GEN-LAST:event_btnArticulosActionPerformed

    private void btnGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGVActionPerformed
        // TODO add your handling code here:
        mnGVActionPerformed(null);
    }//GEN-LAST:event_btnGVActionPerformed

    private void btnGCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGCActionPerformed
        // TODO add your handling code here:
        mnGCActionPerformed(null);
    }//GEN-LAST:event_btnGCActionPerformed

    private void mnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCalcActionPerformed
        // TODO add your handling code here:
        try        
    {
        Runtime rt = Runtime.getRuntime();           
        Process p = rt.exec("calc");            
        p.waitFor();        
    }        
    catch ( IOException | InterruptedException ioe )       
    {            
        ioe.getMessage();
    }
    }//GEN-LAST:event_mnCalcActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        abrirImpresoras();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnGVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGVEActionPerformed
        // TODO add your handling code here:
        try {
            dlgConsultarCreditos cc = new dlgConsultarCreditos(this, true);
            cc.setLocationRelativeTo(null);
            cc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_mnGVEActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        dlgSoftware a = new dlgSoftware(this, true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void smModUsuariosDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smModUsuariosDActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestUsuarioD gud = new dlgGestUsuarioD(this, true);
            gud.setLocationRelativeTo(null);
            gud.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }//GEN-LAST:event_smModUsuariosDActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteResumenCaja rsc = new dlgReporteResumenCaja(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteTotalVentas rsc = new dlgReporteTotalVentas(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem66ActionPerformed

    private void jMenuItem67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem67ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteRankingFecha rsc = new dlgReporteRankingFecha(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem67ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteArticulos rsc = new dlgReporteArticulos(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        // TODO add your handling code here:
       /* try {
            dlgReporteStockValorizado rsc = new dlgReporteStockValorizado(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }*/
       Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed
        // TODO add your handling code here:
        //Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
        try {
            dlgReporteComisionesGenerados rsc = new dlgReporteComisionesGenerados(this, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_jMenuItem54ActionPerformed

    private void jMenuItem47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem47ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem47ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
        // TODO add your handling code here:
        Mensajes.Sistema("Este reporte se encuentra bloqueado en estos momentos.\nPara más información comuniquese con el proveedor del sistema.");
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void rSButtonIconUno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconUno1ActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_rSButtonIconUno1ActionPerformed
    void abrirProveedor() {
        try {
            dlgProveedores proveedor = new dlgProveedores(this, true);
            proveedor.setSize(1200, 540);
            proveedor.setLocationRelativeTo(null);
            proveedor.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Servidor no esta activo");
        }
    }

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
            setVisible(true);
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo el icono del sistema.");
        }
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnArticulos;
    public static javax.swing.JButton btnClientes;
    public static javax.swing.JButton btnCompras;
    public static javax.swing.JButton btnGC;
    public static javax.swing.JButton btnGV;
    public static javax.swing.JButton btnProveedores;
    public static javax.swing.JButton btnVentas;
    public static javax.swing.JMenu divisor4;
    public static javax.swing.JMenu divisor5;
    public static javax.swing.JMenu divisor6;
    private javax.swing.JMenuItem itemCiudades;
    private javax.swing.JMenuItem itemEmpresa;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemFamilia;
    public static javax.swing.JMenuItem itemFondo;
    private javax.swing.JMenuItem itemImportar;
    private javax.swing.JMenuItem itemLaboratorio;
    private javax.swing.JMenuItem itemSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem23;
    public static javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem38;
    public static javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JLabel lbEmpresa;
    private javax.swing.JLabel lbIp;
    public static javax.swing.JLabel lbPerfil;
    public static javax.swing.JLabel lbRUC;
    public static javax.swing.JLabel lbSucursal;
    public static javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lbversion;
    private javax.swing.JMenuBar mbBarraMenu;
    public static javax.swing.JMenu mnArticulos;
    public static javax.swing.JMenu mnAyuda;
    public static javax.swing.JMenu mnAyuda1;
    public static javax.swing.JMenu mnCaja;
    private javax.swing.JMenuItem mnCalc;
    private javax.swing.JMenuItem mnCerrarSistema;
    private javax.swing.JMenuItem mnCierredeCaja;
    public static javax.swing.JMenu mnClientes;
    public static javax.swing.JMenuItem mnComision;
    public static javax.swing.JMenu mnCompras;
    public static javax.swing.JMenu mnConfiguracion;
    public static javax.swing.JMenu mnEmpleados;
    private javax.swing.JMenuItem mnGC;
    public static javax.swing.JMenuItem mnGNCVenta;
    private javax.swing.JMenuItem mnGPE;
    private javax.swing.JMenuItem mnGV;
    public static javax.swing.JMenuItem mnGVE;
    private javax.swing.JMenuItem mnGastosVarios;
    public static javax.swing.JMenu mnInformacion;
    private javax.swing.JMenuItem mnIngresosVarios;
    private javax.swing.JMenuItem mnIniciarCaja;
    public static javax.swing.JMenu mnMantenimiento;
    public static javax.swing.JMenuItem mnNCProveedor;
    public static javax.swing.JMenuItem mnNCVenta;
    public static javax.swing.JMenuItem mnPagoProveedor;
    public static javax.swing.JMenu mnProveedores;
    public static javax.swing.JMenu mnReportes;
    public static javax.swing.JMenu mnSeguridad;
    public static javax.swing.JMenu mnSistema;
    public static javax.swing.JMenu mnVentas;
    public static javax.swing.JPanel panelFondo;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    public static javax.swing.JPanel pnlPanelAccDirectos;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno1;
    public static javax.swing.JMenu rpArticulos;
    public static javax.swing.JMenu rpClientes;
    public static javax.swing.JMenu rpCompras;
    public static javax.swing.JMenu rpDevoluciones;
    public static javax.swing.JMenu rpPresupuestos;
    public static javax.swing.JMenu rpProveedores;
    public static javax.swing.JMenu rpVendedores;
    public static javax.swing.JMenu rpVentas;
    private javax.swing.JMenuItem smModUsuarios;
    public static javax.swing.JMenuItem smModUsuariosD;
    // End of variables declaration//GEN-END:variables
}
