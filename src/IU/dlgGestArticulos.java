package IU;

import Componentes.ConexionBD;
import Componentes.Mensajes;
import Componentes.Redondeo;
import Componentes.Reporte;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import Datos.GestionarArticulos;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;

public class dlgGestArticulos extends javax.swing.JDialog {

    //public static ResultSet rs;
    public static MariaDbStatement sentencia;
    public static MariaDbConnection con;
    public static int id;
    public Reporte jasper;

    public dlgGestArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jasper = new Reporte();
        titulo();
        //prepararBD();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        Invisible();
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Crear o modificar artículo");
        }else{
            this.setTitle(Software.getSoftware()+" - Crear o modificar artículo");
        }
    }

    private void CargarCombos() {
        cargarComboBox.cargar(cbLaboratorio, "SELECT * FROM laboratorio WHERE lab_indicador='S'");
        cargarComboBox.cargar(cbProveedor, "SELECT pro_codigo, pro_razonsocial, pro_indicador FROM proveedor WHERE pro_indicador='S'");
        cargarComboBox.cargar(cbFamilia, "SELECT * FROM familia WHERE fam_indicador='S'");
    }

    private void Invisible() {
        txtCodPro.setVisible(false);
        txtCodFam.setVisible(false);
        txtCodLab.setVisible(false);
        txtPrecioVentaL.setVisible(false);
        txtPrecioPublicoL.setVisible(false);
        txtCostoL.setVisible(false);
        txtPrecioVentaML.setVisible(false);
        panelLibre.setVisible(false);
        lbAccionT.setVisible(false);
        jScrollPane3.setVisible(false);
        lbPP.setVisible(false);
        lbD.setVisible(false);
        txtPrecioPublico.setVisible(false);
        txtDesc.setVisible(false);
    }

    private void Habilitacion() {
        btnNuevo.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        itemGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        btnLaboratorio.setEnabled(true);
        btnProveedor.setEnabled(true);
        btnFamilia.setEnabled(true);
        txtCodBarra.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtPrincipio.setEnabled(true);
        txtAccion.setEnabled(true);
        rLibre.setEnabled(true);
        rControlado.setEnabled(true);
        rNacional.setEnabled(true);
        rImportado.setEnabled(true);
        rActivo.setEnabled(true);
        rInactivo.setEnabled(true);
        cbLaboratorio.setEnabled(true);
        cbFamilia.setEnabled(true);
        cbProveedor.setEnabled(true);
        txtCosto.setEnabled(true);
        txtPrecioPublico.setEnabled(true);
        txtGanancia.setEnabled(true);
        txtDesc.setEnabled(true);
        txtPrecioVenta.setEnabled(true);
        txtStock.setEnabled(true);
        txtStockMin.setEnabled(true);
        dfecha.setEnabled(false);
    }

    private void pintarEstado() {
        if (rActivo.isSelected()) {
            rActivo.setFont(new java.awt.Font("Tahoma", 1, 11));
            rActivo.setForeground(new java.awt.Color(0, 0, 51));
            rInactivo.setFont(new java.awt.Font("Tahoma", 0, 11));
            rInactivo.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            rActivo.setFont(new java.awt.Font("Tahoma", 0, 11));
            rActivo.setForeground(new java.awt.Color(0, 0, 0));
            rInactivo.setFont(new java.awt.Font("Tahoma", 1, 11));
            rInactivo.setForeground(new java.awt.Color(0, 0, 51));
        }
    }

    private void pintarVenta() {
        if (rLibre.isSelected()) {
            rLibre.setFont(new java.awt.Font("Tahoma", 1, 11));
            rLibre.setForeground(new java.awt.Color(0, 0, 51));
            rControlado.setFont(new java.awt.Font("Tahoma", 0, 11));
            rControlado.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            rLibre.setFont(new java.awt.Font("Tahoma", 0, 11));
            rLibre.setForeground(new java.awt.Color(0, 0, 0));
            rControlado.setFont(new java.awt.Font("Tahoma", 1, 11));
            rControlado.setForeground(new java.awt.Color(0, 0, 51));
        }
    }

    private void pintarTipo() {
        if (rNacional.isSelected()) {
            rNacional.setFont(new java.awt.Font("Tahoma", 1, 11));
            rNacional.setForeground(new java.awt.Color(0, 0, 51));
            rImportado.setFont(new java.awt.Font("Tahoma", 0, 11));
            rImportado.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            rNacional.setFont(new java.awt.Font("Tahoma", 0, 11));
            rNacional.setForeground(new java.awt.Color(0, 0, 0));
            rImportado.setFont(new java.awt.Font("Tahoma", 1, 11));
            rImportado.setForeground(new java.awt.Color(0, 0, 51));
        }
    }

    private void Cancelar() {
        limpiarCampos();
        btnNuevo.setEnabled(true);
        itemNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        itemCancelar.setEnabled(false);
        btnLaboratorio.setEnabled(false);
        btnProveedor.setEnabled(false);
        btnFamilia.setEnabled(false);
        txtCodBarra.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtPrincipio.setEnabled(false);
        txtAccion.setEnabled(false);
        rLibre.setEnabled(false);
        rControlado.setEnabled(false);
        rNacional.setEnabled(false);
        rImportado.setEnabled(false);
        rActivo.setEnabled(false);
        rInactivo.setEnabled(false);
        cbLaboratorio.setEnabled(false);
        cbFamilia.setEnabled(false);
        cbProveedor.setEnabled(false);
        txtCosto.setEnabled(false);
        txtPrecioPublico.setEnabled(false);
        txtGanancia.setEnabled(false);
        txtDesc.setEnabled(false);
        txtPrecioVenta.setEnabled(false);
        txtStock.setEnabled(false);
        txtStockMin.setEnabled(false);
        dfecha.setEnabled(false);
        pintarEstado();
        pintarVenta();
        pintarTipo();
        Volver();
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        rNacional = new javax.swing.JRadioButton();
        rImportado = new javax.swing.JRadioButton();
        rActivo = new javax.swing.JRadioButton();
        rInactivo = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbLaboratorio = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbProveedor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbFamilia = new javax.swing.JComboBox();
        btnFamilia = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnLaboratorio = new javax.swing.JButton();
        lbGan = new javax.swing.JLabel();
        lbIVA = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodBarra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        c1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtPrincipio = new javax.swing.JTextArea();
        lbAccionT = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAccion = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbD = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        c2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JTextField();
        c6 = new javax.swing.JLabel();
        c8 = new javax.swing.JLabel();
        lbPP = new javax.swing.JLabel();
        txtPrecioPublico = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        c4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtStockMin = new javax.swing.JTextField();
        c5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtUltCompra = new javax.swing.JTextField();
        dfecha = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        txtIVACosto = new javax.swing.JTextField();
        c9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        ckHabilitar = new javax.swing.JCheckBox();
        txtPrecioVentaM = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtCantM = new javax.swing.JTextField();
        txtPrecioVentaML = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtCodLab = new javax.swing.JTextField();
        txtCostoL = new javax.swing.JTextField();
        txtCodPro = new javax.swing.JTextField();
        txtPrecioPublicoL = new javax.swing.JTextField();
        txtCodFam = new javax.swing.JTextField();
        txtPrecioVentaL = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnGuardar = new newscomponents.RSButtonBigIcon_new();
        btnCancelar = new newscomponents.RSButtonBigIcon_new();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        panelLibre = new javax.swing.JPanel();
        rLibre = new javax.swing.JRadioButton();
        rControlado = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemCancelar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(rNacional);
        rNacional.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        rNacional.setSelected(true);
        rNacional.setText("PRODUCTO NACIONAL");
        rNacional.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rNacional.setOpaque(false);
        rNacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rNacionalActionPerformed(evt);
            }
        });
        jPanel8.add(rNacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 17));

        buttonGroup2.add(rImportado);
        rImportado.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        rImportado.setText("PRODUCTO IMPORTADO");
        rImportado.setOpaque(false);
        rImportado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rImportadoActionPerformed(evt);
            }
        });
        jPanel8.add(rImportado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 16));

        buttonGroup3.add(rActivo);
        rActivo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        rActivo.setSelected(true);
        rActivo.setText("ACTIVO");
        rActivo.setOpaque(false);
        rActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActivoActionPerformed(evt);
            }
        });
        jPanel8.add(rActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, 20));

        buttonGroup3.add(rInactivo);
        rInactivo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        rInactivo.setText("INACTIVO");
        rInactivo.setOpaque(false);
        rInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rInactivoActionPerformed(evt);
            }
        });
        jPanel8.add(rInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 80, 20));

        jLabel17.setBackground(new java.awt.Color(0, 102, 102));
        jLabel17.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ORIGEN Y STATUS");
        jLabel17.setOpaque(true);
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 340, 90));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Marca");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        cbLaboratorio.setBackground(new java.awt.Color(255, 255, 204));
        cbLaboratorio.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cbLaboratorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbLaboratorio.setNextFocusableComponent(cbProveedor);
        cbLaboratorio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLaboratorioItemStateChanged(evt);
            }
        });
        cbLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLaboratorioActionPerformed(evt);
            }
        });
        cbLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbLaboratorioKeyPressed(evt);
            }
        });
        jPanel7.add(cbLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 230, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Proveedor");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        cbProveedor.setBackground(new java.awt.Color(255, 255, 204));
        cbProveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cbProveedor.setAutoscrolls(true);
        cbProveedor.setNextFocusableComponent(cbFamilia);
        cbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedorActionPerformed(evt);
            }
        });
        cbProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbProveedorKeyPressed(evt);
            }
        });
        jPanel7.add(cbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 230, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Familia");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        cbFamilia.setBackground(new java.awt.Color(255, 255, 204));
        cbFamilia.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cbFamilia.setNextFocusableComponent(txtCosto);
        cbFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFamiliaActionPerformed(evt);
            }
        });
        cbFamilia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbFamiliaKeyPressed(evt);
            }
        });
        jPanel7.add(cbFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 230, -1));

        btnFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnFamilia.setToolTipText("Gestionar Familia");
        btnFamilia.setBorderPainted(false);
        btnFamilia.setContentAreaFilled(false);
        btnFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFamiliaActionPerformed(evt);
            }
        });
        jPanel7.add(btnFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 21, 20));

        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnProveedor.setToolTipText("Gestionar Proveedor");
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        jPanel7.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 21, 20));

        btnLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnLaboratorio.setToolTipText("Gestionar Laboratorio");
        btnLaboratorio.setBorderPainted(false);
        btnLaboratorio.setContentAreaFilled(false);
        btnLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaboratorioActionPerformed(evt);
            }
        });
        jPanel7.add(btnLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 21, 20));

        lbGan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        lbGan.setForeground(new java.awt.Color(0, 0, 51));
        lbGan.setText("Ganancia Sugerida:");
        jPanel7.add(lbGan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 123, -1));

        lbIVA.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        lbIVA.setForeground(new java.awt.Color(0, 0, 51));
        lbIVA.setText("I.V.A Sugerido:");
        jPanel7.add(lbIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 100, -1));

        jLabel18.setBackground(new java.awt.Color(0, 102, 102));
        jLabel18.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("CLASIFICACIÓN");
        jLabel18.setOpaque(true);
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 340, 160));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("INFORMACIÓN DEL ARTÍCULO");
        jLabel9.setOpaque(true);
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("ID Artículo");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 37, -1, 20));

        txtCodProducto.setEditable(false);
        txtCodProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtCodProducto.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jPanel5.add(txtCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 37, 136, 23));

        jButton1.setText("Generar Código de Barra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 37, 176, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Código Barra");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 74, 126, -1));

        txtCodBarra.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtCodBarra.setNextFocusableComponent(txtDescripcion);
        txtCodBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodBarraActionPerformed(evt);
            }
        });
        txtCodBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodBarraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodBarraKeyTyped(evt);
            }
        });
        jPanel5.add(txtCodBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 71, 318, 23));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("Descripción del artículo");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 108, -1, -1));

        txtDescripcion.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtDescripcion.setNextFocusableComponent(txtPrincipio);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jPanel5.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 105, 318, 23));

        c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N
        jPanel5.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 107, 15, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Observación");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 139, -1, 23));

        jScrollPane4.setHorizontalScrollBar(null);

        txtPrincipio.setColumns(20);
        txtPrincipio.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtPrincipio.setRows(2);
        txtPrincipio.setAutoscrolls(false);
        txtPrincipio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPrincipio.setNextFocusableComponent(txtAccion);
        txtPrincipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrincipioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrincipioKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtPrincipio);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 139, 318, 46));

        lbAccionT.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbAccionT.setText("Acción Terapéutica");
        jPanel5.add(lbAccionT, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 196, -1, 23));

        txtAccion.setColumns(20);
        txtAccion.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        txtAccion.setRows(2);
        txtAccion.setAutoscrolls(false);
        txtAccion.setNextFocusableComponent(cbLaboratorio);
        txtAccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAccionKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtAccion);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 196, 318, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 490, 260));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbD.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 15)); // NOI18N
        lbD.setForeground(new java.awt.Color(0, 0, 51));
        lbD.setText("% Descuento");
        lbD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtDesc.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        txtDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDesc.setText("0");
        txtDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescMouseClicked(evt);
            }
        });
        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 51));
        jLabel19.setText("Precio Venta");
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtPrecioVenta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        txtPrecioVenta.setForeground(new java.awt.Color(0, 102, 0));
        txtPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioVentaMouseClicked(evt);
            }
        });
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("Precio Costo");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtCosto.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCostoMouseClicked(evt);
            }
        });
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 51));
        jLabel16.setText("% Lucro");
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtGanancia.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        txtGanancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGanancia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGananciaFocusLost(evt);
            }
        });
        txtGanancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGananciaMouseClicked(evt);
            }
        });
        txtGanancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGananciaActionPerformed(evt);
            }
        });
        txtGanancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGananciaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGananciaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGananciaKeyTyped(evt);
            }
        });

        c6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        c8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        lbPP.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 15)); // NOI18N
        lbPP.setForeground(new java.awt.Color(0, 0, 51));
        lbPP.setText("Precio Publico");
        lbPP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtPrecioPublico.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        txtPrecioPublico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioPublico.setText("0");
        txtPrecioPublico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioPublicoMouseClicked(evt);
            }
        });
        txtPrecioPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioPublicoActionPerformed(evt);
            }
        });
        txtPrecioPublico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioPublicoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioPublicoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioPublicoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lbD, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c6)))))
                .addGap(10, 10, 10))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPP)
                    .addComponent(txtPrecioPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbD))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19))
                    .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 34, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        jLabel13.setText("Stock");

        txtStock.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStock.setText("0.0");
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        jLabel14.setText("Stock Mínimo");

        txtStockMin.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtStockMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMin.setText("0");
        txtStockMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStockMinMouseClicked(evt);
            }
        });
        txtStockMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockMinActionPerformed(evt);
            }
        });
        txtStockMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockMinKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockMinKeyTyped(evt);
            }
        });

        c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        jLabel15.setText("Vencimiento");

        jLabel25.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        jLabel25.setText("Ult. Compra");

        txtUltCompra.setEditable(false);
        txtUltCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtUltCompra.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtUltCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUltCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUltCompraActionPerformed(evt);
            }
        });

        dfecha.setBackground(new java.awt.Color(255, 255, 204));
        dfecha.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(60, 60, 60)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c5)
                            .addComponent(c4)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel15))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUltCompra)
                            .addComponent(dfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(c4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c5)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dfecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUltCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(49, 49, 49))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, 124));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        jLabel11.setText("I.V.A. Grabada");

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        jLabel12.setText("Costo I.V.A.");

        txtIVA.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIVA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIVAMouseClicked(evt);
            }
        });
        txtIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIVAActionPerformed(evt);
            }
        });
        txtIVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIVAKeyPressed(evt);
            }
        });

        txtIVACosto.setEditable(false);
        txtIVACosto.setBackground(new java.awt.Color(255, 255, 255));
        txtIVACosto.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtIVACosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        c9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIVACosto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c9)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(c9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIVACosto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 34, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ckHabilitar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        ckHabilitar.setText("Precio especial por cantidad");
        ckHabilitar.setOpaque(false);
        ckHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckHabilitarActionPerformed(evt);
            }
        });
        ckHabilitar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckHabilitarKeyPressed(evt);
            }
        });

        txtPrecioVentaM.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        txtPrecioVentaM.setForeground(new java.awt.Color(0, 102, 0));
        txtPrecioVentaM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaM.setText("0");
        txtPrecioVentaM.setEnabled(false);
        txtPrecioVentaM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioVentaMMouseClicked(evt);
            }
        });
        txtPrecioVentaM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaMActionPerformed(evt);
            }
        });
        txtPrecioVentaM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Aplicar a partir de:");

        jLabel22.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 51));

        txtCantM.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        txtCantM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantM.setText("3");
        txtCantM.setEnabled(false);
        txtCantM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantMMouseClicked(evt);
            }
        });
        txtCantM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantMActionPerformed(evt);
            }
        });
        txtCantM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantMKeyTyped(evt);
            }
        });

        txtPrecioVentaML.setEditable(false);
        txtPrecioVentaML.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtPrecioVentaML.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaML.setText("0");

        jLabel23.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Mts / Unids");

        jLabel26.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 51));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Precio de venta:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(ckHabilitar)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(txtCantM, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(txtPrecioVentaM, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecioVentaML, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(11, 11, 11))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ckHabilitar)
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioVentaM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtPrecioVentaML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel22)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 34, -1, 210));

        jLabel20.setBackground(new java.awt.Color(0, 102, 102));
        jLabel20.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("MARGEN DE UTILIDAD, IVA Y STOCK");
        jLabel20.setOpaque(true);
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 835, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 275, 835, 250));
        jPanel2.getAccessibleContext().setAccessibleName("");

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(txtCodLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 44, -1));

        txtCostoL.setEditable(false);
        txtCostoL.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtCostoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCostoL.setText("0");
        txtCostoL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoLActionPerformed(evt);
            }
        });
        jPanel10.add(txtCostoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 43, -1));
        jPanel10.add(txtCodPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 44, -1));

        txtPrecioPublicoL.setEditable(false);
        txtPrecioPublicoL.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtPrecioPublicoL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioPublicoL.setText("0");
        jPanel10.add(txtPrecioPublicoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 43, -1));
        jPanel10.add(txtCodFam, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 44, -1));

        txtPrecioVentaL.setEditable(false);
        txtPrecioVentaL.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtPrecioVentaL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaL.setText("0");
        jPanel10.add(txtPrecioVentaL, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 43, -1));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnNuevo.setBackground(new java.awt.Color(0, 102, 102));
        btnNuevo.setBorder(null);
        btnNuevo.setText("NUEVO");
        btnNuevo.setBgHover(new java.awt.Color(0, 102, 102));
        btnNuevo.setFgIcon(new java.awt.Color(153, 153, 153));
        btnNuevo.setFgText(new java.awt.Color(153, 153, 153));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnNuevo.setIconTextGap(0);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnNuevo.setPixels(0);
        btnNuevo.setSizeIcon(45.0F);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnModificar.setBackground(new java.awt.Color(0, 102, 102));
        btnModificar.setBorder(null);
        btnModificar.setText("MODIFICAR");
        btnModificar.setBgHover(new java.awt.Color(0, 102, 102));
        btnModificar.setFgIcon(new java.awt.Color(153, 153, 153));
        btnModificar.setFgText(new java.awt.Color(153, 153, 153));
        btnModificar.setFocusPainted(false);
        btnModificar.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnModificar.setIconTextGap(0);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setPixels(0);
        btnModificar.setSizeIcon(45.0F);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar);

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setBorder(null);
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBgHover(new java.awt.Color(0, 102, 102));
        btnGuardar.setFgIcon(new java.awt.Color(153, 153, 153));
        btnGuardar.setFgText(new java.awt.Color(153, 153, 153));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnGuardar.setIconTextGap(0);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setPixels(0);
        btnGuardar.setSizeIcon(45.0F);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar);

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setBorder(null);
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBgHover(new java.awt.Color(0, 102, 102));
        btnCancelar.setFgIcon(new java.awt.Color(153, 153, 153));
        btnCancelar.setFgText(new java.awt.Color(153, 153, 153));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setPixels(0);
        btnCancelar.setSizeIcon(45.0F);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar);

        btnSalir.setBackground(new java.awt.Color(0, 102, 102));
        btnSalir.setBorder(null);
        btnSalir.setText("SALIR");
        btnSalir.setBgHover(new java.awt.Color(0, 102, 102));
        btnSalir.setFgIcon(new java.awt.Color(153, 153, 153));
        btnSalir.setFgText(new java.awt.Color(153, 153, 153));
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnSalir.setIconTextGap(0);
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        btnSalir.setPixels(0);
        btnSalir.setSizeIcon(45.0F);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir);

        jPanel10.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 400, 60));

        panelLibre.setBackground(new java.awt.Color(255, 255, 255));
        panelLibre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelLibre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rLibre);
        rLibre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        rLibre.setSelected(true);
        rLibre.setText("Venta Libre");
        rLibre.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rLibre.setOpaque(false);
        rLibre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rLibreActionPerformed(evt);
            }
        });
        panelLibre.add(rLibre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 17));

        buttonGroup1.add(rControlado);
        rControlado.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        rControlado.setText("Controlado");
        rControlado.setOpaque(false);
        rControlado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rControladoActionPerformed(evt);
            }
        });
        panelLibre.add(rControlado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 16));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/No-entry.png"))); // NOI18N
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panelLibre.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/OK.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        panelLibre.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jPanel10.add(panelLibre, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 120, 56));

        barMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        barMenu.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        menuOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_menu_black_24.png"))); // NOI18N
        menuOpciones.setFocusable(false);
        menuOpciones.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        menuOpciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuOpciones.add(itemNuevo);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit15.png"))); // NOI18N
        itemModificar.setText("Guardar Modificación");
        itemModificar.setEnabled(false);
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemModificar);

        itemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemGuardar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save15.png"))); // NOI18N
        itemGuardar.setText("Guardar Nuevo");
        itemGuardar.setEnabled(false);
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemGuardar);

        itemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemCancelar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel15.png"))); // NOI18N
        itemCancelar.setText("Cancelar");
        itemCancelar.setEnabled(false);
        itemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCancelarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemCancelar);
        menuOpciones.add(jSeparator2);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuOpciones.add(itemSalir);

        barMenu.add(menuOpciones);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFamiliaActionPerformed
        // TODO add your handling code here:
        if (cbFamilia.getSelectedIndex() == 0) {
            txtGanancia.setText("");
            lbGan.setText("");
            lbIVA.setText("");
        } else {
            String item = String.valueOf(cbFamilia.getSelectedItem());
            try {
                prepararBD();
                ResultSet rs = sentencia.executeQuery("Select fam_codigo from familia where fam_nombre='" + item + "' and fam_indicador='S'");
                rs.first();
                id = rs.getInt("fam_codigo");
               rs.close();
               sentencia.close();
               con.close();
            } catch (SQLException ex) {
                Mensajes.error("ID familia:" + ex.getMessage());
            }
            try {
                String sql = "select fam_ganancia, fam_iva from familia where fam_codigo=" + id + " and fam_indicador='S'";
                
                try {
                    prepararBD();
                    ResultSet rss = sentencia.executeQuery(sql);
                    rss.first();
                    lbGan.setText(String.valueOf("Ganancia Sugerida: " + rss.getInt(1)));
                    lbIVA.setText(String.valueOf("I.V.A Sugerido: " + rss.getString(2)));
                    //txtIVA.setText(rss.getString(2));
                    rss.close();
                    sentencia.close();
                    con.close();
                } catch (Exception e) {
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        }
    }//GEN-LAST:event_cbFamiliaActionPerformed

    private void cbLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLaboratorioActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbLaboratorioActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        btnNuevoActionPerformed(null);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        // TODO add your handling code here:
        btnModificarActionPerformed(null);
    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // TODO add your handling code here:
        btnGuardarActionPerformed(null);
    }//GEN-LAST:event_itemGuardarActionPerformed

    private void itemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCancelarActionPerformed
        // TODO add your handling code here:
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_itemCancelarActionPerformed

    private void rLibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rLibreActionPerformed
        // TODO add your handling code here:
        pintarVenta();
    }//GEN-LAST:event_rLibreActionPerformed

    private void btnFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFamiliaActionPerformed
        // TODO add your handling code here:
        dlgFamilia fa = new dlgFamilia(null, true);
        fa.setLocationRelativeTo(null);
        fa.setVisible(true);
    }//GEN-LAST:event_btnFamiliaActionPerformed

    private void btnLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaboratorioActionPerformed
        // TODO add your handling code here:
        dlgLaboratorio la = new dlgLaboratorio(null, true);
        la.setLocationRelativeTo(null);
        la.setVisible(true);
    }//GEN-LAST:event_btnLaboratorioActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        dlgProveedores pro = new dlgProveedores(null, true);
        pro.setSize(1230, 570);
        pro.setLocationRelativeTo(null);
        pro.setVisible(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
        CalcularDescuento();
        CalcularGanancia();
        ckHabilitar.requestFocus();
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtPrecioPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioPublicoActionPerformed
        // TODO add your handling code here:
        if (!txtPrecioPublico.getText().trim().isEmpty()) {
            CalcularDescuento();
            txtDesc.requestFocus();
        }

    }//GEN-LAST:event_txtPrecioPublicoActionPerformed

    private void txtGananciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGananciaActionPerformed
        // TODO add your handling code here:
        if (!txtCostoL.getText().trim().isEmpty() && !txtGanancia.getText().trim().isEmpty()) {
            CalcularPrecioVentaxGan();
            CalcularDescuento();
            txtPrecioVenta.requestFocus();
        }

    }//GEN-LAST:event_txtGananciaActionPerformed

    private void cbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProveedorActionPerformed

    private void txtGananciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaKeyReleased

    private void txtPrecioPublicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPublicoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioPublico.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioPublico.setText(df.format(Integer.valueOf(txtPrecioPublico.getText().trim().replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
            System.out.println("c: " + e.getMessage());
        }
        if (txtPrecioPublico.getText().length() >= 1) {
            DecimalFormat df = new DecimalFormat("#0");
            txtPrecioPublicoL.setText(df.format(Integer.valueOf(txtPrecioPublico.getText().trim().replace(".", "").replace(",", ""))));
        }
    }//GEN-LAST:event_txtPrecioPublicoKeyReleased

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtCosto.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtCosto.setText(df.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
            }
        } catch (Exception e) {
            System.out.println("c: " + e.getMessage());
        }
        try {
            if (!txtCosto.getText().trim().isEmpty()) {
                DecimalFormat dff = new DecimalFormat("#0");
                txtCostoL.setText(dff.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtCostoL.setText("0");
            }
            CalculoIVAC();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtCostoKeyReleased

    private void txtDescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyReleased
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtDesc.getText()) < 0) {
                txtDesc.setText("0");
                if (txtDesc.getText().trim().length() == 0) {
                    txtDesc.setText("0");
                }
            }
        } catch (NumberFormatException e) {
        }


    }//GEN-LAST:event_txtDescKeyReleased

    private void txtPrecioVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioVenta.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioVenta.setText(df.format(Integer.valueOf(txtPrecioVenta.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtPrecioVenta.setText("0");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        if (txtPrecioVenta.getText().equals("")) {
            txtPrecioVenta.setText("0");
        } else {
            DecimalFormat dff = new DecimalFormat("#0");
            txtPrecioVentaL.setText(dff.format(Integer.valueOf(txtPrecioVenta.getText().trim().replace(".", "").replace(",", ""))));
        }
    }//GEN-LAST:event_txtPrecioVentaKeyReleased

    private void txtIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIVAActionPerformed
        // TODO add your handling code here:
        if (txtIVA.getText().trim().isEmpty()) {
            txtIVA.setText("5");
        } else {
            int iva = Integer.parseInt(txtIVA.getText());
            switch (iva) {
                case 5 ->
                    CalculoIVAC();
                case 10 ->
                    CalculoIVAC();
                case 0 ->
                    txtIVACosto.setText("0.0");
                default -> {
                    Mensajes.error("IVA NO VALIDO");
                    txtIVA.setText("5");
                    txtIVA.requestFocus();
                    txtIVA.selectAll();
                }
            }
        }

    }//GEN-LAST:event_txtIVAActionPerformed

    private void txtPrecioPublicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPublicoKeyTyped
        // TODO add your handling code here:

        int limite = 10;
        /*char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }*/
        if (txtPrecioPublico.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioPublicoKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        // TODO add your handling code here:
        int limite = 10;
        if (txtCosto.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void rNacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rNacionalActionPerformed
        // TODO add your handling code here:
        pintarTipo();
    }//GEN-LAST:event_rNacionalActionPerformed

    private void txtCostoLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoLActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:  
        if (!txtCosto.getText().trim().isEmpty()) {
            CalcularPrecioVentaxGan();
            txtGanancia.requestFocus();
            txtGanancia.selectAll();
        }

    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtGananciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGananciaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaFocusLost

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
        if (txtPrecioPublicoL.getText().trim().equals("0")) {
            txtDesc.setText("0");
            txtPrecioVenta.requestFocus();
        } else {
            CalcularPrecioVentaxDesc();
            CalcularGanancia();
            txtPrecioVenta.requestFocus();
        }
    }//GEN-LAST:event_txtDescActionPerformed

    private void txtUltCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUltCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUltCompraActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtPrincipioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrincipioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtPrincipioKeyTyped

    private void txtAccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtAccionKeyTyped

    private void txtCodBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraKeyPressed
        // TODO add your handling code here:
        /* if (!txtCodBarra.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtCodBarra);
        }*/

    }//GEN-LAST:event_txtCodBarraKeyPressed

    private void txtGananciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 5;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtGanancia.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGananciaKeyTyped

    private void txtDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyTyped
        // TODO add your handling code here:
        //char c = evt.getKeyChar();
        int limite = 5;
        /*if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }*/
        if (txtDesc.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        // TODO add your handling code here:

        int limite = 10;
        if (txtPrecioVenta.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        // TODO add your handling code here:
        //char c = evt.getKeyChar();
        int limite = 7;
        if (txtStock.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtStockMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinKeyTyped
        // TODO add your handling code here:
        // char c = evt.getKeyChar();
        int limite = 5;
        /*if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }*/
        if (txtStockMin.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockMinKeyTyped

    private void rActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActivoActionPerformed
        // TODO add your handling code here:
        pintarEstado();
    }//GEN-LAST:event_rActivoActionPerformed

    private void rInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rInactivoActionPerformed
        // TODO add your handling code here:
        pintarEstado();
    }//GEN-LAST:event_rInactivoActionPerformed

    private void rControladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rControladoActionPerformed
        // TODO add your handling code here:
        pintarVenta();
    }//GEN-LAST:event_rControladoActionPerformed

    private void rImportadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rImportadoActionPerformed
        // TODO add your handling code here:
        pintarTipo();
    }//GEN-LAST:event_rImportadoActionPerformed

    private void txtPrecioVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioVentaMouseClicked
        // TODO add your handling code here:
        txtPrecioVenta.selectAll();
    }//GEN-LAST:event_txtPrecioVentaMouseClicked

    private void txtCostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCostoMouseClicked
        // TODO add your handling code here:
        txtCosto.selectAll();
    }//GEN-LAST:event_txtCostoMouseClicked

    private void txtPrecioPublicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioPublicoMouseClicked
        // TODO add your handling code here:
        txtPrecioPublico.selectAll();
    }//GEN-LAST:event_txtPrecioPublicoMouseClicked

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void txtCodBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodBarraActionPerformed
        // TODO add your handling code here:
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtCodBarraActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
        txtPrincipio.requestFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtPrincipioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrincipioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbLaboratorio.requestFocus();
            cbLaboratorio.setPopupVisible(true);
        }
    }//GEN-LAST:event_txtPrincipioKeyPressed

    private void txtAccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccionKeyPressed

    private void cbLaboratorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbLaboratorioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbProveedor.requestFocus();
            cbProveedor.setPopupVisible(true);
        }
    }//GEN-LAST:event_cbLaboratorioKeyPressed

    private void cbProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbProveedorKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbFamilia.requestFocus();
            cbFamilia.setPopupVisible(true);
        }
    }//GEN-LAST:event_cbProveedorKeyPressed

    private void cbFamiliaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbFamiliaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCosto.requestFocus();
        }
    }//GEN-LAST:event_cbFamiliaKeyPressed

    private void txtIVAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIVAKeyPressed
        // TODO add your handling code here:
        if (!txtIVA.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtIVA);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtStock.isEnabled()) {
                txtStockMin.requestFocus();
                txtStockMin.selectAll();
            } else {
                txtStock.requestFocus();
                txtStock.selectAll();
            }
        }
    }//GEN-LAST:event_txtIVAKeyPressed

    private void txtIVAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIVAMouseClicked
        // TODO add your handling code here:
        txtIVA.selectAll();
    }//GEN-LAST:event_txtIVAMouseClicked

    private void txtDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyPressed
        // TODO add your handling code here:
        if (!txtDesc.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtDesc);
        }
    }//GEN-LAST:event_txtDescKeyPressed

    private void txtPrecioVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyPressed
        // TODO add your handling code here:
        if (!txtPrecioVenta.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioVenta);
        }
    }//GEN-LAST:event_txtPrecioVentaKeyPressed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        // TODO add your handling code here:
        if (!txtCosto.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtCosto);
        }
    }//GEN-LAST:event_txtCostoKeyPressed

    private void txtPrecioPublicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPublicoKeyPressed
        // TODO add your handling code here:
        if (!txtPrecioPublico.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioPublico);
        }

    }//GEN-LAST:event_txtPrecioPublicoKeyPressed

    private void txtDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescMouseClicked
        // TODO add your handling code here:
        txtDesc.selectAll();
    }//GEN-LAST:event_txtDescMouseClicked

    private void txtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyPressed
        // TODO add your handling code here:
        //validarCampos.soloNumeros(txtStock);
        validarCampos.soloDecimales(txtStock);
    }//GEN-LAST:event_txtStockKeyPressed

    private void txtStockMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtStock);
    }//GEN-LAST:event_txtStockMinKeyPressed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
        if (txtStock.getText().isEmpty()) {
            txtStock.setText("0.0");
            txtStock.selectAll();
        } else {
            txtStockMin.requestFocus();
            txtStockMin.selectAll();
        }

    }//GEN-LAST:event_txtStockActionPerformed

    private void txtStockMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockMinActionPerformed
        // TODO add your handling code here:
        if (txtStockMin.getText().isEmpty()) {
            txtStockMin.setText("0");
            txtStockMin.selectAll();
        } else if (txtStockMin.getText().equals("0")) {
            txtStockMin.selectAll();
        } else {
            if (!btnGuardar.isEnabled()) {
                btnModificar.doClick();
            } else {
                btnGuardar.doClick();
            }

        }
    }//GEN-LAST:event_txtStockMinActionPerformed

    private void txtStockMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockMinMouseClicked
        // TODO add your handling code here:
        txtStockMin.selectAll();
    }//GEN-LAST:event_txtStockMinMouseClicked

    private void txtGananciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGananciaMouseClicked
        // TODO add your handling code here:
        txtGanancia.selectAll();
    }//GEN-LAST:event_txtGananciaMouseClicked

    private void txtGananciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyPressed
        // TODO add your handling code here:
        if (!txtGanancia.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtGanancia);
        }
    }//GEN-LAST:event_txtGananciaKeyPressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void cbLaboratorioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLaboratorioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLaboratorioItemStateChanged

    private void txtPrecioVentaMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioVentaMMouseClicked
        // TODO add your handling code here:
        txtPrecioVenta.selectAll();
    }//GEN-LAST:event_txtPrecioVentaMMouseClicked

    private void txtPrecioVentaMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaMActionPerformed

    private void txtPrecioVentaMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtIVA.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioVentaMKeyPressed

    private void txtPrecioVentaMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioVentaM.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioVentaM.setText(df.format(Integer.valueOf(txtPrecioVentaM.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtPrecioVentaM.setText("0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (txtPrecioVentaM.getText().equals("")) {
            txtPrecioVentaM.setText("0");
        } else {
            DecimalFormat dff = new DecimalFormat("#0");
            txtPrecioVentaML.setText(dff.format(Integer.valueOf(txtPrecioVentaM.getText().trim().replace(".", "").replace(",", ""))));
        }
    }//GEN-LAST:event_txtPrecioVentaMKeyReleased

    private void txtPrecioVentaMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMKeyTyped
        // TODO add your handling code here:
        int limite = 10;
        if (txtPrecioVentaM.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaMKeyTyped

    private void txtCantMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMMouseClicked

    private void txtCantMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantMActionPerformed
        // TODO add your handling code here:
        if (txtCantM.getText().isEmpty()) {
            txtCantM.setText("3");
            txtPrecioVentaM.requestFocus();
        } else if (Integer.parseInt(txtCantM.getText()) < 3) {
            Mensajes.informacion("Para aplicar Precio por Caja se requiere una Cantidad mayor o igual a 3");
            txtCantM.setText("3");
            txtPrecioVentaM.requestFocus();
        } else {
            txtPrecioVentaM.requestFocus();
        }
    }//GEN-LAST:event_txtCantMActionPerformed

    private void txtCantMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyPressed
        // TODO add your handling code here:
        if (!txtCantM.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioVenta);
        }
    }//GEN-LAST:event_txtCantMKeyPressed

    private void txtCantMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMKeyReleased

    private void txtCantMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMKeyTyped

    private void ckHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckHabilitarActionPerformed
        // TODO add your handling code here:
        if (ckHabilitar.isSelected()) {
            txtCantM.setEnabled(true);
            txtPrecioVentaM.setEnabled(true);
            txtCantM.requestFocus();
        } else {
            txtCantM.setEnabled(false);
            txtPrecioVentaM.setEnabled(false);
            //txtCantM.setText("2");
            //txtPrecioVentaM.setText("0");
            //txtPrecioVentaML.setText("0");
        }
    }//GEN-LAST:event_ckHabilitarActionPerformed

    private void ckHabilitarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckHabilitarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtIVA.requestFocus();
        }
    }//GEN-LAST:event_ckHabilitarKeyPressed

    private void txtCodBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtCodBarraKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Generar el código de barra de este artículo?");
        if (rpta == 0) {
            jasper.reporteUnParametroVerticalCodBarra("\\Reports\\articulos\\codigoBarra.jasper", "codArt", Integer.parseInt(txtCodProducto.getText().trim()));
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        CargarCombos();
        limpiarCampos();
        cbFamiliaActionPerformed(null);
        Habilitacion();
        pintarEstado();
        pintarVenta();
        pintarTipo();
        String cod = GestionarArticulos.getCodigo();
        txtCodProducto.setText(cod);
        txtCodBarra.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (cbLaboratorio.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Laboratorio");
            cbLaboratorio.requestFocus();
        } else if (cbProveedor.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Proveedor");
            cbProveedor.requestFocus();
        } else if (cbFamilia.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione una Familia");
            cbFamilia.requestFocus();
        } else if (Integer.parseInt(txtGanancia.getText()) < 0) {
            Mensajes.error("Ganancia fuera de rango");
            txtGanancia.requestFocus();
        } else if (Integer.parseInt(txtDesc.getText()) < 0) {
            Mensajes.error("Descuento fuera de rango");
            txtDesc.requestFocus();
        }else if (validarCampos.estaVacio(txtDescripcion) && validarCampos.estaVacio(txtCostoL) && validarCampos.estaVacio(txtPrecioPublicoL) && validarCampos.estaVacio(txtPrecioVentaL)
                && validarCampos.estaVacio(txtStock) && validarCampos.estaVacio(txtStockMin) && validarCampos.estaVacio(txtIVA)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarArticulos.getCodigo();
                    txtCodProducto.setText(cod);
                    controlArticulo.addArticulo();
                    Cancelar();
                } else {
                    txtCodBarra.requestFocus();
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        } else {
            Mensajes.informacion("Verifique que todos los campos exigidos esten completados");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (cbLaboratorio.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Laboratorio");
            cbLaboratorio.requestFocus();
        } else if (cbProveedor.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Proveedor");
            cbProveedor.requestFocus();
        } else if (cbFamilia.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione una Familia");
            cbFamilia.requestFocus();
        } else if (Integer.parseInt(txtGanancia.getText()) < 0) {
            Mensajes.error("Ganancia fuera de rango");
            txtGanancia.requestFocus();
        } else if (Integer.parseInt(txtDesc.getText()) < 0) {
            Mensajes.error("Descuento fuera de rango");
            txtDesc.requestFocus();
        } else if (validarCampos.estaVacio(txtDescripcion) && validarCampos.estaVacio(txtCostoL) && validarCampos.estaVacio(txtPrecioPublicoL) && validarCampos.estaVacio(txtPrecioVentaL)
                && validarCampos.estaVacio(txtStock) && validarCampos.estaVacio(txtStockMin) && validarCampos.estaVacio(txtIVA)) {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlArticulo.actArticulo();
                    Cancelar();
                } else {
                    txtCodBarra.requestFocus();
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        } else {
            Mensajes.informacion("Debe llenar obligatoriamente los campos señalados");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar?");
        if (rpta == 0) {
            limpiarCampos();
            btnNuevo.setEnabled(true);
            itemNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            itemModificar.setEnabled(false);
            btnGuardar.setEnabled(false);
            itemGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            itemCancelar.setEnabled(false);
            btnLaboratorio.setEnabled(false);
            btnProveedor.setEnabled(false);
            btnFamilia.setEnabled(false);
            txtCodBarra.setEnabled(false);
            txtDescripcion.setEnabled(false);
            txtPrincipio.setEnabled(false);
            txtAccion.setEnabled(false);
            rLibre.setEnabled(false);
            rControlado.setEnabled(false);
            rNacional.setEnabled(false);
            rImportado.setEnabled(false);
            rActivo.setEnabled(false);
            rInactivo.setEnabled(false);
            cbLaboratorio.setEnabled(false);
            cbFamilia.setEnabled(false);
            cbProveedor.setEnabled(false);
            txtCosto.setEnabled(false);
            txtPrecioPublico.setEnabled(false);
            txtGanancia.setEnabled(false);
            txtDesc.setEnabled(false);
            txtPrecioVenta.setEnabled(false);
            txtStock.setEnabled(false);
            txtStockMin.setEnabled(false);
            dfecha.setEnabled(false);
            pintarEstado();
            pintarVenta();
            pintarTipo();
            Volver();
            this.dispose();
        } else {
            txtCodBarra.requestFocus();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            Volver();
            this.dispose();
        } else {
            txtCodBarra.requestFocus();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    public void CalcularPrecioVentaxGan() {
        //try {
        if (!txtGanancia.getText().trim().isEmpty()) {
            int c = Integer.valueOf(txtCostoL.getText().trim());
            int g = Integer.valueOf(txtGanancia.getText().trim());
            int v = (int) (c + ((c / 100) * (g)));
            String PV = String.valueOf(Redondeo.redondearI(v));
            txtPrecioVentaL.setText(PV);
            DecimalFormat df = new DecimalFormat("#,###");
            txtPrecioVenta.setText(df.format(Integer.valueOf(PV.trim().replace(".", "").replace(",", ""))));

        }
        //  } catch (Exception e) {
        //  }
    }

    public void CalcularPrecioVentaxDesc() {
        try {
            int pp = Integer.valueOf(txtPrecioPublicoL.getText().trim());
            int d = Integer.valueOf(txtDesc.getText().trim());
            int v = (int) (pp - ((pp / 100) * (d)));
            String PV = String.valueOf(Redondeo.redondearI(v));
            txtPrecioVentaL.setText(PV);
            DecimalFormat df = new DecimalFormat("#,###");
            txtPrecioVenta.setText(df.format(Integer.valueOf(PV.trim().replace(".", "").replace(",", ""))));
        } catch (Exception ee) {
        }
    }

    public void CalcularDescuento() {
        if (txtPrecioPublicoL.getText().trim().equals("0")) {
            txtDesc.setText("0");
        } else {
            try {
                int pv = Integer.parseInt(txtPrecioVentaL.getText().trim());
                int pp = Integer.parseInt(txtPrecioPublicoL.getText().trim());
                if (pp < pv) {
                    Mensajes.informacion("PRECIO VENTA MAYOR A PRECIO PUBLICO");
                } else {
                    int dif = pp - pv;
                    int desc = (dif * 100) / pp;
                    txtDesc.setText(String.valueOf(Redondeo.redondearI(desc)));
                }
            } catch (Exception e) {
            }
        }
    }

    public static void CalculoIVAC() {
        try {
            int c = Integer.valueOf(txtCostoL.getText().trim());
            double div = 0;
            double iva = Integer.valueOf(txtIVA.getText().trim());
            double cosIVA;
            switch ((int) iva) {
                case 5 ->
                    div = 21;
                case 10 ->
                    div = 11;
                default -> {
                }
            }
            if (iva != 0) {
                cosIVA = (c / div);
                txtIVACosto.setText(String.valueOf(Redondeo.redondearD(cosIVA)));
            } else {
                txtIVACosto.setText("0.0");
            }
        } catch (Exception e) {
        }

    }

    public void CalcularGanancia() {
        try {
            int pv;
            int pc;
            int G;
            pv = Integer.valueOf(txtPrecioVentaL.getText().trim());
            pc = Integer.valueOf(txtCostoL.getText().trim());
            G = (pv - pc) / (pc / 100);
            txtGanancia.setText(String.valueOf(Redondeo.redondearI(G)));
        } catch (Exception e) {
        }
    }

    public void Nuevo() {
        btnNuevoActionPerformed(null);
    }

    public static void limpiarCampos() {
        txtDescripcion.setText("");
        txtCodBarra.setText("");
        txtPrincipio.setText("");
        txtAccion.setText("");
        txtCosto.setText("");
        txtCostoL.setText("");
        txtPrecioPublico.setText("0");
        txtPrecioPublicoL.setText("0");
        txtGanancia.setText("");
        txtDesc.setText("0");
        txtPrecioVenta.setText("");
        txtPrecioVentaL.setText("");
        txtStock.setText("0.0");
        txtStockMin.setText("0");
        txtIVA.setText("");
        txtIVACosto.setText("");
        txtCodLab.setText("");
        txtCodFam.setText("");
        txtCodPro.setText("");
        cbLaboratorio.setSelectedIndex(0);
        cbProveedor.setSelectedIndex(0);
        cbFamilia.setSelectedIndex(0);
        rActivo.setSelected(true);
        rNacional.setSelected(true);
        rLibre.setSelected(true);
    }

    void Volver() {
        CabecerasTablas cabe = new CabecerasTablas();
        cabe.Articulos(dlgArticulos.tbProductos);
        CabecerasTablas.limpiarTablas(dlgArticulos.tbProductos);
        controlArticulo.filtrarGral(dlgArticulos.tbProductos, "");
        dlgArticulos.Renders();
        dlgArticulos.txtBuscar.requestFocus();
        dlgArticulos.txtBuscar.setText("");
        dlgArticulos.tbProductos.clearSelection();
    }

    public static void prepararBD() {
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

    public void modcbLaboratorio() {
        DefaultComboBoxModel ml = new DefaultComboBoxModel();
        String CodLaboratorio = txtCodLab.getText().trim();
        try {
            prepararBD();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM laboratorio WHERE lab_indicador='S'");
            ml.addElement("**OPCIONES**");
            while (rs.next()) {
                ml.addElement(rs.getString("lab_nombre"));
            }
            ResultSet rss = sentencia.executeQuery("SELECT * FROM laboratorio WHERE lab_codigo=" + CodLaboratorio);
            rss.first();
            Object descripcion = (Object) rss.getString("lab_nombre");
            dlgGestArticulos.cbLaboratorio.setModel(ml);
            dlgGestArticulos.cbLaboratorio.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            sentencia.close();
            con.close();
        } catch (SQLException ew) {
            //Mensajes.error("TIENES UN ERROR AL CARGAR LOS LABORATORIOS: "+ew.getMessage().toUpperCase());
        }
    }

    public void modcbProveedor() {
        DefaultComboBoxModel pr = new DefaultComboBoxModel();
        String CodProveedor = txtCodPro.getText().trim();
        try {
            prepararBD();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM proveedor WHERE pro_indicador='S'");
            pr.addElement("**OPCIONES**");
            while (rs.next()) {
                pr.addElement(rs.getString("pro_razonsocial"));
            }
            ResultSet rss = sentencia.executeQuery("SELECT * FROM proveedor WHERE pro_codigo=" + CodProveedor);
            rss.first();
            Object descripcion = (Object) rss.getString("pro_razonsocial");
            dlgGestArticulos.cbProveedor.setModel(pr);
            dlgGestArticulos.cbProveedor.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            sentencia.close();
            con.close();
        } catch (SQLException ew) {
            //Mensajes.error("TIENES UN ERROR AL CARGAR LOS PROVEEDORES: "+ew.getMessage().toUpperCase());
        }
    }

    public void modcbFamilia() {
        DefaultComboBoxModel fm = new DefaultComboBoxModel();
        String CodFamilia = txtCodFam.getText().trim();
        try {
            prepararBD();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM familia WHERE fam_indicador='S'");
            fm.addElement("**OPCIONES**");
            while (rs.next()) {
                fm.addElement(rs.getString("fam_nombre"));
            }
            ResultSet rss = sentencia.executeQuery("SELECT * FROM familia WHERE fam_codigo=" + CodFamilia);
            rss.first();
            Object descripcion = (Object) rss.getString("fam_nombre");
            dlgGestArticulos.cbFamilia.setModel(fm);
            dlgGestArticulos.cbFamilia.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            sentencia.close();
            con.close();
        } catch (SQLException ew) {
            //Mensajes.error("TIENES UN ERROR AL CARGAR LAS FAMILIAS: "+ew.getMessage().toUpperCase());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgGestArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgGestArticulos dialog = new dlgGestArticulos(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenuBar barMenu;
    public static newscomponents.RSButtonBigIcon_new btnCancelar;
    public static javax.swing.JButton btnFamilia;
    public static newscomponents.RSButtonBigIcon_new btnGuardar;
    public static javax.swing.JButton btnLaboratorio;
    public static newscomponents.RSButtonBigIcon_new btnModificar;
    public static newscomponents.RSButtonBigIcon_new btnNuevo;
    public static javax.swing.JButton btnProveedor;
    private newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel c8;
    private javax.swing.JLabel c9;
    public static javax.swing.JComboBox<String> cbFamilia;
    public static javax.swing.JComboBox<String> cbLaboratorio;
    public static javax.swing.JComboBox<String> cbProveedor;
    public static javax.swing.JCheckBox ckHabilitar;
    public static com.toedter.calendar.JDateChooser dfecha;
    public static javax.swing.JMenuItem itemCancelar;
    public static javax.swing.JMenuItem itemGuardar;
    public static javax.swing.JMenuItem itemModificar;
    public static javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbAccionT;
    private javax.swing.JLabel lbD;
    private javax.swing.JLabel lbGan;
    private javax.swing.JLabel lbIVA;
    private javax.swing.JLabel lbPP;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JPanel panelLibre;
    public static javax.swing.JRadioButton rActivo;
    public static javax.swing.JRadioButton rControlado;
    public static javax.swing.JRadioButton rImportado;
    public static javax.swing.JRadioButton rInactivo;
    public static javax.swing.JRadioButton rLibre;
    public static javax.swing.JRadioButton rNacional;
    public static javax.swing.JTextArea txtAccion;
    public static javax.swing.JTextField txtCantM;
    public static javax.swing.JTextField txtCodBarra;
    public static javax.swing.JTextField txtCodFam;
    public static javax.swing.JTextField txtCodLab;
    public static javax.swing.JTextField txtCodPro;
    public static javax.swing.JTextField txtCodProducto;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtCostoL;
    public static javax.swing.JTextField txtDesc;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtGanancia;
    public static javax.swing.JTextField txtIVA;
    public static javax.swing.JTextField txtIVACosto;
    public static javax.swing.JTextField txtPrecioPublico;
    public static javax.swing.JTextField txtPrecioPublicoL;
    public static javax.swing.JTextField txtPrecioVenta;
    public static javax.swing.JTextField txtPrecioVentaL;
    public static javax.swing.JTextField txtPrecioVentaM;
    public static javax.swing.JTextField txtPrecioVentaML;
    public static javax.swing.JTextArea txtPrincipio;
    public static javax.swing.JTextField txtStock;
    public static javax.swing.JTextField txtStockMin;
    private javax.swing.JTextField txtUltCompra;
    // End of variables declaration//GEN-END:variables
}
