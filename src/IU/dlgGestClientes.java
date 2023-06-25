package IU;

import Componentes.Mensajes;
import Componentes.cargarComboBox;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlCliente;
import Datos.GestionarCliente;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public final class dlgGestClientes extends javax.swing.JDialog {

    public dlgGestClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboBox.cargar(cbCiudad, "SELECT * FROM ciudad WHERE ciu_indicador='S'");
        cargarIcono();
        lbCiudad.setVisible(false);
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        btnNuevo.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JTabbedPane();
        pnDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodC = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRazonS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox();
        btnCiudad = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        pnFacturacion = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        chbContado = new javax.swing.JCheckBox();
        chbCredito = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        txtLimite = new javax.swing.JTextField();
        c5 = new javax.swing.JLabel();
        pnObservacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaS = new javax.swing.JTextArea();
        btnSalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbCiudad = new javax.swing.JLabel();
        lbm = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemCancelar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        contenedor.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        contenedor.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        pnDatos.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        pnDatos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnDatosFocusGained(evt);
            }
        });

        jLabel1.setText("ID Cliente");

        lblCodC.setBackground(new java.awt.Color(255, 255, 204));
        lblCodC.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblCodC.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblCodC.setOpaque(true);

        jLabel2.setText("Nombre y A. o Raón S.   ");

        txtRazonS.setBackground(new java.awt.Color(255, 255, 204));
        txtRazonS.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSActionPerformed(evt);
            }
        });
        txtRazonS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSKeyTyped(evt);
            }
        });

        jLabel3.setText("Contacto");

        txtContacto.setBackground(new java.awt.Color(255, 255, 204));
        txtContacto.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });
        txtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactoKeyTyped(evt);
            }
        });

        jLabel4.setText("Dirección");

        txtDireccion.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel5.setText("Ciudad");

        cbCiudad.setBackground(new java.awt.Color(255, 255, 204));
        cbCiudad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        cbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCiudadActionPerformed(evt);
            }
        });
        cbCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCiudadKeyPressed(evt);
            }
        });

        btnCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnCiudad.setToolTipText("Gestionar Ciudad");
        btnCiudad.setBorderPainted(false);
        btnCiudad.setContentAreaFilled(false);
        btnCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadActionPerformed(evt);
            }
        });

        jLabel6.setText("Celular   ");

        jLabel7.setText("Teléfono");

        jLabel11.setText("C.I o R.U.C.   ");

        txtRuc.setBackground(new java.awt.Color(255, 255, 204));
        txtRuc.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
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

        txtTelefono.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtCelular.setBackground(new java.awt.Color(255, 255, 204));
        txtCelular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        c3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        c4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        javax.swing.GroupLayout pnDatosLayout = new javax.swing.GroupLayout(pnDatos);
        pnDatos.setLayout(pnDatosLayout);
        pnDatosLayout.setHorizontalGroup(
            pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDatosLayout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel6)
                                .addGap(12, 12, 12)
                                .addComponent(txtCelular))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDatosLayout.createSequentialGroup()
                                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDatosLayout.createSequentialGroup()
                                .addComponent(lblCodC, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRazonS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c1)
                            .addComponent(c3)
                            .addComponent(c4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(24, 24, 24))
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnDatosLayout.setVerticalGroup(
            pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCodC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(c2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDatosLayout.createSequentialGroup()
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(c3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCelular)
                            .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))))
                    .addComponent(c4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        btnCiudad.getAccessibleContext().setAccessibleDescription("");

        contenedor.addTab("Datos", pnDatos);

        pnFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnFacturacionMouseClicked(evt);
            }
        });
        pnFacturacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnFacturacionKeyPressed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opcion de Venta"));

        chbContado.setSelected(true);
        chbContado.setText("Contado");
        chbContado.setEnabled(false);

        chbCredito.setText("Credito");
        chbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCreditoActionPerformed(evt);
            }
        });

        jLabel8.setText("Linea de Crédito");

        txtLimite.setBackground(new java.awt.Color(255, 255, 204));
        txtLimite.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        txtLimite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLimite.setText("0");
        txtLimite.setEnabled(false);
        txtLimite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLimiteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLimiteKeyReleased(evt);
            }
        });

        c5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/alert20.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbContado)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(chbCredito)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c5)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chbContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chbCredito)
                        .addComponent(jLabel8)
                        .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(c5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnFacturacionLayout = new javax.swing.GroupLayout(pnFacturacion);
        pnFacturacion.setLayout(pnFacturacionLayout);
        pnFacturacionLayout.setHorizontalGroup(
            pnFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnFacturacionLayout.setVerticalGroup(
            pnFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        contenedor.addTab("Facturación", pnFacturacion);

        txaS.setBackground(new java.awt.Color(255, 255, 204));
        txaS.setColumns(20);
        txaS.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txaS.setRows(5);
        txaS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaSKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaS);

        javax.swing.GroupLayout pnObservacionLayout = new javax.swing.GroupLayout(pnObservacion);
        pnObservacion.setLayout(pnObservacionLayout);
        pnObservacionLayout.setHorizontalGroup(
            pnObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnObservacionLayout.setVerticalGroup(
            pnObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        contenedor.addTab("Observación", pnObservacion);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(1, 9));

        btnNuevo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document30.png"))); // NOI18N
        btnNuevo.setText("Nuevo-F1");
        btnNuevo.setToolTipText("Nuevo - F3");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
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
        jPanel5.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
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
        jPanel5.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
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
        jPanel5.add(btnCancelar);

        lbm.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N

        barMenu.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        menuOpciones.setText("Opciones");
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
        menuOpciones.add(jSeparator1);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lbm, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbm, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            actualizartablaClientes();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        cargarComboBox.cargar(cbCiudad, "SELECT * FROM ciudad WHERE ciu_indicador='S'");
        String cod = GestionarCliente.getCodigo();
        lblCodC.setText(cod);
        btnNuevo.setEnabled(false);
        itemNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        itemGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        itemCancelar.setEnabled(true);
        btnCiudad.setEnabled(true);
        txtRazonS.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtContacto.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        txaS.setEnabled(true);
        cbCiudad.setEnabled(true);
        chbContado.setEnabled(true);
        chbCredito.setEnabled(true);
        contenedor.setSelectedIndex(0);
        cbCiudad.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        if (validarCampos.estaVacio(txtRazonS) && validarCampos.estaVacio(txtRuc) && validarCampos.estaVacio(txtDireccion) && validarCampos.estaVacio(txtCelular)) {
            try{
                int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION){
                    controlCliente.actCliente();
                    actualizartablaClientes();
                    this.dispose();
                }
            }catch(Exception ee){}
        } else {
            lbm.setText("Campo Obligatorio");
            if(txtRazonS.getText().equals("")){
                txtRazonS.requestFocus();
                c1.setVisible(true);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            }else if(txtRuc.getText().equals("")){
                txtRuc.requestFocus();
                c1.setVisible(false);
                c2.setVisible(true);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            }else if (txtDireccion.getText().trim()==null){
                txtDireccion.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(true);
                c4.setVisible(false);
                c5.setVisible(false);
            }else if(txtCelular.getText().trim()==null){
                txtCelular.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(true);
                c5.setVisible(false);
            }else if(txtLimite.getText().trim()==null){
                contenedor.setSelectedIndex(1);
                txtLimite.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        if (validarCampos.estaVacio(txtRazonS) && validarCampos.estaVacio(txtRuc) && validarCampos.estaVacio(txtDireccion) && validarCampos.estaVacio(txtCelular) && validarCampos.estaVacio(txtLimite)) {
            try{
                int resp = JOptionPane.showConfirmDialog(this,"¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION){
                    String cod = GestionarCliente.getCodigo();
                    lblCodC.setText(cod);
                    controlCliente.addCliente();
                    actualizartablaClientes();
                    btnCancelarActionPerformed(null);
                }
                
            }catch(HeadlessException ee){}
            
        } else {
            lbm.setText("Campo Obligatorio");
            if(txtRazonS.getText().equals("")){
                txtRazonS.requestFocus();
                c1.setVisible(true);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            }else if(txtRuc.getText().equals("")){
                txtRuc.requestFocus();
                c1.setVisible(false);
                c2.setVisible(true);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(false);
            }else if (txtDireccion.getText().equals("")){
                txtDireccion.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(true);
                c4.setVisible(false);
                c5.setVisible(false);
            }else if(txtCelular.getText().equals("")){
                txtCelular.requestFocus();
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(true);
                c5.setVisible(false);
            }else if(txtLimite.getText().equals("")){
                txtLimite.requestFocus();
                contenedor.setSelectedComponent(pnFacturacion);
                c1.setVisible(false);
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
                c5.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        btnNuevo.setEnabled(true);
        itemNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        itemModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        itemGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        itemCancelar.setEnabled(false);
        btnCiudad.setEnabled(false);
        txtRazonS.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        txtContacto.setEnabled(false);
        cbCiudad.setEnabled(false);
        txtRuc.setEnabled(false);
        txaS.setEnabled(false);
        txtLimite.setEnabled(false);
        chbContado.setEnabled(false);
        chbCredito.setEnabled(false);
        chbCredito.setSelected(false);
        lbm.setText("");
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        c5.setVisible(false);
        btnNuevo.requestFocus();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void itemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCancelarActionPerformed
        // TODO add your handling code here:
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_itemCancelarActionPerformed

    private void txaSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaSKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txaS.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txaSKeyTyped

    private void chbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCreditoActionPerformed
        // TODO add your handling code here:
        if(chbCredito.isSelected()){
            txtLimite.setEnabled(true);
            txtLimite.requestFocus();
        }else{
            txtLimite.setEnabled(false);
        }
    }//GEN-LAST:event_chbCreditoActionPerformed

    private void txtLimiteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLimiteKeyReleased
        // TODO add your handling code here:
        try{
            if(Integer.parseInt(txtLimite.getText()) < 0){
            txtLimite.setText("0");
        }
        }catch(NumberFormatException e){}
        
        DecimalFormat df = new DecimalFormat("#,###");
 
        if (txtLimite.getText().trim().length() >= 1) {
 
            txtLimite.setText( df.format(Integer.valueOf(txtLimite.getText().trim().replace(".", "").replace(",", ""))) );
        }
    }//GEN-LAST:event_txtLimiteKeyReleased

    private void pnFacturacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnFacturacionKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pnFacturacionKeyPressed

    private void pnFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnFacturacionMouseClicked
        // TODO add your handling code here:
        System.out.println(evt.getButton());
    }//GEN-LAST:event_pnFacturacionMouseClicked

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        int limite=15;
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

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
        txtContacto.requestFocus();
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        int limite=15;
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

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        txtCelular.requestFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        int limite=11;
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

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucKeyPressed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

    private void btnCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCiudadActionPerformed
        // TODO add your handling code here:
        dlgCiudad pro = new dlgCiudad(null, true);
        pro.setLocationRelativeTo(null);
        pro.setVisible(true);
    }//GEN-LAST:event_btnCiudadActionPerformed

    private void cbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCiudadActionPerformed
        // TODO add your handling code here:
        String id = cargarComboBox.getCodidgo(cbCiudad);
        lbCiudad.setText(id);
    }//GEN-LAST:event_cbCiudadActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txtDireccion.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 49);
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=49;
        if (txtContacto.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtContactoKeyTyped

    private void txtContactoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtContacto);
        validarCampos.cantCaracteres(txtContacto, 29);
    }//GEN-LAST:event_txtContactoKeyPressed

    private void txtRazonSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txtRazonS.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtRazonSKeyTyped

    private void txtRazonSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSKeyPressed
        // TODO add your handling code here:
        validarCampos.soloLetras(txtRazonS);
        validarCampos.cantCaracteres(txtRazonS, 199);
    }//GEN-LAST:event_txtRazonSKeyPressed

    private void pnDatosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnDatosFocusGained
        // TODO add your handling code here:
        txtRazonS.requestFocus();
    }//GEN-LAST:event_pnDatosFocusGained

    private void txtLimiteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLimiteKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtLimite);
        int limite=8;
        if (txtLimite.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtLimiteKeyPressed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void cbCiudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCiudadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtRazonS.requestFocus();
        }
    }//GEN-LAST:event_cbCiudadKeyPressed

    private void txtRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSActionPerformed
        // TODO add your handling code here:
        txtRuc.requestFocus();
    }//GEN-LAST:event_txtRazonSActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
        contenedor.setSelectedComponent(pnFacturacion);
        chbCredito.requestFocus();
    }//GEN-LAST:event_txtContactoActionPerformed

    void limpiarCampos()
    {
        lblCodC.setText("");
        lbCiudad.setText("");
        txtRazonS.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtContacto.setText("");
        txtCelular.setText("");
        txtTelefono.setText("");
        cbCiudad.list();
        txaS.setText("");
        txtLimite.setText("0");
    }
    void actualizartablaClientes(){
         CabecerasTablas cabe = new CabecerasTablas();
         cabe.cliente(dlgClientes.tablaClientes);
         CabecerasTablas.limpiarTablas(dlgClientes.tablaClientes);
         controlCliente.listClientes(dlgClientes.tablaClientes, "clientes.cli_codigo");
     }
    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
    }
    
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
            java.util.logging.Logger.getLogger(dlgGestClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgGestClientes dialog = new dlgGestClientes(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCiudad;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    public static javax.swing.JComboBox cbCiudad;
    public static javax.swing.JCheckBox chbContado;
    public static javax.swing.JCheckBox chbCredito;
    private javax.swing.JTabbedPane contenedor;
    public static javax.swing.JMenuItem itemCancelar;
    public static javax.swing.JMenuItem itemGuardar;
    public static javax.swing.JMenuItem itemModificar;
    public static javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public static javax.swing.JLabel lbCiudad;
    public static javax.swing.JLabel lblCodC;
    private javax.swing.JLabel lbm;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JPanel pnDatos;
    private javax.swing.JPanel pnFacturacion;
    private javax.swing.JPanel pnObservacion;
    public static javax.swing.JTextArea txaS;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtContacto;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtLimite;
    public static javax.swing.JTextField txtRazonS;
    public static javax.swing.JTextField txtRuc;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
