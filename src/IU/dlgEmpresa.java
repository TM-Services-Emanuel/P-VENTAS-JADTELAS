package IU;

import Componentes.ConexionBD;
import Componentes.Mensajes;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlEmpresa;
import Datos.GestionarEmpresa;
import Componentes.validarCampos;
import static IU.frmPrincipal.lbEmpresa;
import static IU.frmPrincipal.lbSucursal;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;

public final class dlgEmpresa extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    private String visual=null;
    public MariaDbStatement sentencia;
    public MariaDbConnection  con;
    private ResultSet rs;
    public dlgEmpresa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        prepararBD();
        cabe.empresa(tbEmpresa);
        controlEmpresa.lisEmpresa(tbEmpresa);
        tbEmpresa.getTableHeader().setReorderingAllowed(false);
        Visual();
        lbvisual.setVisible(false);
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Gestionar empresa");
        }else{
            this.setTitle(Software.getSoftware()+" - Gestionar empresa");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gpVisual = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpresa = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbRuc = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rbSi = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        lbvisual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemCancelar = new javax.swing.JMenuItem();
        itemEliminar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(1, 9));

        btnNuevo.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document30.png"))); // NOI18N
        btnNuevo.setText("Nuevo-F1");
        btnNuevo.setToolTipText("Nuevo - F1");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit30.png"))); // NOI18N
        btnModificar.setText("Modif-F5");
        btnModificar.setToolTipText("Modificar - F5");
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save30.png"))); // NOI18N
        btnGuardar.setText("Guardar-F6");
        btnGuardar.setToolTipText("Guardar - F6");
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel30.png"))); // NOI18N
        btnCancelar.setText("Cancel-Esc");
        btnCancelar.setToolTipText("Cancelar - Esc");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/garbage30.png"))); // NOI18N
        btnEliminar.setText("Elim-Supr");
        btnEliminar.setToolTipText("Eliminar - Supr");
        btnEliminar.setEnabled(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);

        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setText("Salir-Alt+F4");
        btnSalir.setToolTipText("Salir - Alt+F4");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);

        tbEmpresa.setBackground(new java.awt.Color(255, 255, 204));
        tbEmpresa.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        tbEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEmpresa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbEmpresa.getTableHeader().setResizingAllowed(false);
        tbEmpresa.getTableHeader().setReorderingAllowed(false);
        tbEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpresa);

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel3.setText("ID Empresa");

        lbNombre.setText("Razón Social");

        lbRuc.setText("R.U.C.");

        txtRuc.setBackground(new java.awt.Color(255, 255, 204));
        txtRuc.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtRuc.setEnabled(false);
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        txtCelular.setBackground(new java.awt.Color(255, 255, 204));
        txtCelular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtCelular.setEnabled(false);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        jLabel4.setText("Dirección");

        txtDireccion.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtDireccion.setEnabled(false);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel5.setText("Teléfono");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtTelefono.setEnabled(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel6.setText("Celular");

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 204));
        txtCod.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Activo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 11))); // NOI18N

        gpVisual.add(rbSi);
        rbSi.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        rbSi.setSelected(true);
        rbSi.setText("Si");
        rbSi.setEnabled(false);
        rbSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSiActionPerformed(evt);
            }
        });

        gpVisual.add(rbNo);
        rbNo.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        rbNo.setText("No");
        rbNo.setEnabled(false);
        rbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbSi)
                .addGap(18, 18, 18)
                .addComponent(rbNo)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSi)
                    .addComponent(rbNo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerifyInputWhenFocusTarget(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 11))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Asegurese que solo una EMPRESA este activa en la tabla,");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("en el caso de que tenga insertado mas de un registro.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barMenu.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        menuOpciones.setText("Opciones");
        menuOpciones.setFocusable(false);
        menuOpciones.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        menuOpciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuOpciones.add(itemNuevo);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
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
        itemGuardar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
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
        itemCancelar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel15.png"))); // NOI18N
        itemCancelar.setText("Cancelar");
        itemCancelar.setEnabled(false);
        itemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCancelarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemCancelar);

        itemEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemEliminar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/garbage15.png"))); // NOI18N
        itemEliminar.setText("Eliminar");
        itemEliminar.setEnabled(false);
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemEliminar);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuOpciones.add(jMenuItem1);

        barMenu.add(menuOpciones);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCelular))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lbRuc)
                                    .addComponent(lbNombre))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)))))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbvisual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbvisual, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbNombre)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        String cod = GestionarEmpresa.getCodigo();
        txtCod.setText(cod);
        btnNuevo.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        itemGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        txtNombre.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        rbSi.setEnabled(true);
        rbNo.setEnabled(true);
        txtNombre.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        Visual();
        CabecerasTablas.limpiarTablas(tbEmpresa);
        controlEmpresa.lisEmpresa(tbEmpresa);
        txtNombre.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:a
        try{
            int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION){
                btnEliminar.setEnabled(false);
                itemEliminar.setEnabled(false);
                btnModificar.setEnabled(false);
                itemModificar.setEnabled(false);
                btnCancelar.setEnabled(false);
                itemCancelar.setEnabled(false);
                txtNombre.setEnabled(false);
                txtRuc.setEnabled(false);
                txtDireccion.setEnabled(false);
                txtTelefono.setEnabled(false);
                txtCelular.setEnabled(false);
                rbSi.setEnabled(false);
                rbNo.setEnabled(false);
                controlEmpresa.delEmpresa();
                limpiarCampos();
                CabecerasTablas.limpiarTablas(tbEmpresa);
                controlEmpresa.lisEmpresa(tbEmpresa);
                btnCancelarActionPerformed(null);
            }
        }catch(Exception ee){}
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (validarCampos.estaVacio(txtNombre)&& validarCampos.estaVacio(txtRuc)) {
            try{
                int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION){
                    controlEmpresa.actEmpresa();
                    btnNuevo.setEnabled(true);
                    itemNuevo.setEnabled(true);
                    btnModificar.setEnabled(false);
                    itemModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    itemEliminar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    itemCancelar.setEnabled(false);
                    txtNombre.setEnabled(false);
                    txtRuc.setEnabled(false);
                    txtDireccion.setEnabled(false);
                    txtTelefono.setEnabled(false);
                    txtCelular.setEnabled(false);
                    rbSi.setEnabled(false);
                    rbNo.setEnabled(false);
                    limpiarCampos();
                    CabecerasTablas.limpiarTablas(tbEmpresa);
                    controlEmpresa.lisEmpresa(tbEmpresa);
                }
            }catch(Exception ee){}
            
        }else {
            Mensajes.informacion("Debe llenar obligatoriamente los campos con *");
            if(txtNombre.getText().equals("")){
                txtNombre.requestFocus();
            }else if (txtRuc.getText().equals("")){
                txtRuc.requestFocus();
            }
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (validarCampos.estaVacio(txtNombre)&& validarCampos.estaVacio(txtRuc)) {
            try{
                int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION){
                    String cod = GestionarEmpresa.getCodigo();
                    txtCod.setText(cod);
                    controlEmpresa.addEmpresa();
                    btnGuardar.setEnabled(false);
                    itemGuardar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    itemCancelar.setEnabled(false);
                    txtNombre.setEnabled(false);
                    txtRuc.setEnabled(false);
                    txtDireccion.setEnabled(false);
                    txtTelefono.setEnabled(false);
                    txtCelular.setEnabled(false);
                    rbSi.setEnabled(false);
                    rbNo.setEnabled(false);
                    limpiarCampos();
                    CabecerasTablas.limpiarTablas(tbEmpresa);
                    controlEmpresa.lisEmpresa(tbEmpresa);
                }
            }catch(Exception ee){}
        }else {
            Mensajes.informacion("Debe llenar obligatoriamente los campos con resaltados");
            if(txtNombre.getText().equals("")){
                txtNombre.requestFocus();
            }else if (txtRuc.getText().equals("")){
                txtRuc.requestFocus();
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        //cargarComboBox.cargar(dlgGestAriculos.cbUnidad, "SELECT * FROM unidad WHERE uni_indicador='S'");
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            informacionGral();
            this.dispose();
        }
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tbEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpresaMouseClicked
        // TODO add your handling code here:
        btnNuevo.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnModificar.setEnabled(true);
        itemModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        itemEliminar.setEnabled(true);
        txtNombre.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        rbSi.setEnabled(true);
        rbNo.setEnabled(true);

        int fila = tbEmpresa.getSelectedRow();
        String cod = tbEmpresa.getValueAt(fila, 0).toString();
        String nom = tbEmpresa.getValueAt(fila, 1).toString();
        String ruc = tbEmpresa.getValueAt(fila, 2).toString();
        String direccion = tbEmpresa.getValueAt(fila, 3).toString();
        String telefono = tbEmpresa.getValueAt(fila, 4).toString();
        String celular = tbEmpresa.getValueAt(fila, 5).toString();
        visual= tbEmpresa.getValueAt(fila, 6).toString();

        txtCod.setText(cod);
        txtNombre.setText(nom);
        txtRuc.setText(ruc);
        txtDireccion.setText(direccion);
        txtTelefono.setText(telefono);
        txtCelular.setText(celular);
        if(visual.equals("SI")){
            rbSi.setSelected(true);
        }else{
            rbNo.setSelected(true);
        }
        Visual();
    }//GEN-LAST:event_tbEmpresaMouseClicked

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

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed
        // TODO add your handling code here:
        btnEliminarActionPerformed(null);
    }//GEN-LAST:event_itemEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        btnNuevo.setEnabled(true);
        itemNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        itemCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        itemEliminar.setEnabled(false);
        txtNombre.setEnabled(false);
        txtRuc.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        rbSi.setEnabled(false);
        rbNo.setEnabled(false);
        limpiarCampos();
        tbEmpresa.clearSelection();
        btnNuevo.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        int limite=39;
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if (txtNombre.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        int limite=10;
        if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              System.out.println("Ingresa Solo Numeros");
        }
        if (txtRuc.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=39;
        if (txtDireccion.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtRucKeyPressed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        int limite=12;
        if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              System.out.println("Ingresa Solo Numeros");
        }
        if (txtTelefono.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        int limite=12;
        if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              System.out.println("Ingresa Solo Numeros");
        }
        if (txtCelular.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void rbSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSiActionPerformed
        // TODO add your handling code here:
        Visual();
    }//GEN-LAST:event_rbSiActionPerformed

    private void rbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoActionPerformed
        // TODO add your handling code here:
        Visual();
    }//GEN-LAST:event_rbNoActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        btnSalir.doClick();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    void limpiarCampos()
    {
        txtCod.setText("");
        txtNombre.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        //lbvisual.setText("");
    }
    void Visual(){
        if(rbSi.isSelected()){
          lbvisual.setText("SI");
        }else{
          lbvisual.setText("NO");
        }
    }

    public void prepararBD(){
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
    public void informacionGral(){
        try {
            rs = sentencia.executeQuery("select * from v_sucursal where em_visualizar='SI' and em_indicador='S'");
            rs.first();
            try{
                if(rs.getRow()!=0){
                            //txtCod.setText(rs.getString(1));
                            lbSucursal.setText(rs.getString(2));
                            lbEmpresa.setText(rs.getString(3));
                }else{
                    System.out.println("No se puede cargar Información Gral.");
                    frmPrincipal.lbEmpresa.setText("NOMBRE FARMACIA");
                    frmPrincipal.lbSucursal.setText("NOMBRE SUCURSAL");
                }
            }catch(SQLException ee){
            System.out.println(ee.getMessage());
            }
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
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
            java.util.logging.Logger.getLogger(dlgEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(() -> {
            dlgEmpresa dialog = new dlgEmpresa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    public static javax.swing.ButtonGroup gpVisual;
    private javax.swing.JMenuItem itemCancelar;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemModificar;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbNombre;
    public static javax.swing.JLabel lbRuc;
    public static javax.swing.JLabel lbvisual;
    private javax.swing.JMenu menuOpciones;
    public static javax.swing.JRadioButton rbNo;
    public static javax.swing.JRadioButton rbSi;
    private javax.swing.JTable tbEmpresa;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
