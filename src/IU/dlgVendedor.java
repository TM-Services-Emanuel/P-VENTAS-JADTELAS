package IU;

import Componentes.Mensajes;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlVendedor;
import static IU.dlgGestVendedor.btnNuev;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public final class dlgVendedor extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    clsExportarExcel Export;
    public dlgVendedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.vendedor(tablaEmpleados);
        controlVendedor.listVendedor(tablaEmpleados, "vendedor.ven_codigo");
        tablaEmpleados.getTableHeader().setReorderingAllowed(false);
        cargarIcono();
        cbkBuscarActionPerformed(null);
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Gestionar empleados");
        }else{
            this.setTitle(Software.getSoftware()+" - Gestionar empleados");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemPModificarE = new javax.swing.JMenuItem();
        itemPEliminarE = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoE = new javax.swing.JButton();
        btnModificarE = new javax.swing.JButton();
        btnEliminarE = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        cbkBuscar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevoE = new javax.swing.JMenuItem();
        itemModificarE = new javax.swing.JMenuItem();
        itemEliminarE = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemOrdenC = new javax.swing.JMenuItem();
        itemOrdenN = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemExportar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();

        jPopupMenu1.setLabel("Opciones");

        itemPModificarE.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemPModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editUser15.png"))); // NOI18N
        itemPModificarE.setText("     Modificar");
        itemPModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPModificarEActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemPModificarE);

        itemPEliminarE.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemPEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteUser15 (2).png"))); // NOI18N
        itemPEliminarE.setText("     Eliminar");
        itemPEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPEliminarEActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemPEliminarE);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(1, 5));

        btnNuevoE.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnNuevoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/newUsar40.png"))); // NOI18N
        btnNuevoE.setText("Nuevo-F1");
        btnNuevoE.setToolTipText("Nuevo");
        btnNuevoE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoE);

        btnModificarE.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editUser40.png"))); // NOI18N
        btnModificarE.setText("Modif-F5");
        btnModificarE.setToolTipText("Modificar");
        btnModificarE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarE);

        btnEliminarE.setFont(new java.awt.Font("SansSerif", 0, 9)); // NOI18N
        btnEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteUser40 (2).png"))); // NOI18N
        btnEliminarE.setText("Elim-Supr");
        btnEliminarE.setToolTipText("Eliminar");
        btnEliminarE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarE);

        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setText("Salir-Alt+F4");
        btnSalir.setToolTipText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        tablaEmpleados.setBackground(new java.awt.Color(255, 255, 204));
        tablaEmpleados.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaEmpleados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaEmpleados.setComponentPopupMenu(jPopupMenu1);
        tablaEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMousePressed(evt);
            }
        });
        tablaEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaEmpleadosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Teclas Arriba/Abajo para Navegar | Enter para Seleccionar Empleado");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtBuscar.setBackground(new java.awt.Color(255, 255, 204));
        txtBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        txtBuscar.setEnabled(false);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        cbkBuscar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        cbkBuscar.setSelected(true);
        cbkBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cbkBuscar.setOpaque(false);
        cbkBuscar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        cbkBuscar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cbkBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search15.png"))); // NOI18N
        jLabel1.setText("Buscador de Empleados");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbkBuscar)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbkBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevoE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevoE.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/newUsar40 - copia.png"))); // NOI18N
        itemNuevoE.setText("Nuevo");
        itemNuevoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoEActionPerformed(evt);
            }
        });
        jMenu1.add(itemNuevoE);

        itemModificarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificarE.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editUser15.png"))); // NOI18N
        itemModificarE.setText("Modificar");
        itemModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemModificarE);

        itemEliminarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemEliminarE.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteUser15 (2).png"))); // NOI18N
        itemEliminarE.setText("Eliminar");
        itemEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemEliminarE);
        jMenu1.add(jSeparator1);

        itemOrdenC.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemOrdenC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/orderC15.png"))); // NOI18N
        itemOrdenC.setText("Ordenar por Código");
        itemOrdenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenCActionPerformed(evt);
            }
        });
        jMenu1.add(itemOrdenC);

        itemOrdenN.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemOrdenN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/orderN15.png"))); // NOI18N
        itemOrdenN.setText("Ordenar por Nombre");
        itemOrdenN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenNActionPerformed(evt);
            }
        });
        jMenu1.add(itemOrdenN);
        jMenu1.add(jSeparator2);

        itemExportar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/excel15.png"))); // NOI18N
        itemExportar.setText("Exportar datos a EXCEL");
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        jMenu1.add(itemExportar);
        jMenu1.add(jSeparator3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem6.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        jMenuItem6.setText("Salir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 370, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        String cod = txtBuscar.getText();
        CabecerasTablas.limpiarTablas(tablaEmpleados);
        controlVendedor.filNombre(tablaEmpleados, cod);

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void itemOrdenNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenNActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablas(tablaEmpleados);
        controlVendedor.listVendedor(tablaEmpleados, "vendedor.ven_nombre");
    }//GEN-LAST:event_itemOrdenNActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEActionPerformed
        // TODO add your handling code here:
        dlgGestVendedor vend = new dlgGestVendedor(null, true);
        vend.setLocationRelativeTo(null);
        vend.setTitle("Agregar Empleado");
        btnNuev.doClick();
        vend.setVisible(true);
        
    }//GEN-LAST:event_btnNuevoEActionPerformed

    private void itemNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoEActionPerformed
        // TODO add your handling code here:
        btnNuevoEActionPerformed(null);
    }//GEN-LAST:event_itemNuevoEActionPerformed

    private void btnModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestVendedor ven = new dlgGestVendedor(null, true);
            ven.setLocationRelativeTo(null);
            controlVendedor.aModificar();
            ven.setTitle("Modificación de Empleado");
            dlgGestVendedor.btnModificar.setEnabled(true);
            dlgGestVendedor.itemModificar.setEnabled(true);
            dlgGestVendedor.btnGuardar.setEnabled(false);
            dlgGestVendedor.itemGuardar.setEnabled(false);
            dlgGestVendedor.btnNuev.setEnabled(false);
            dlgGestVendedor.itemNuevo.setEnabled(false);
            dlgGestVendedor.btnCancelar.setEnabled(true);
            dlgGestVendedor.itemCancelar.setEnabled(true);
            ven.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Seleccione un fila de la tabla");
        }
    }//GEN-LAST:event_btnModificarEActionPerformed

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed
        // TODO add your handling code here:
        if (tablaEmpleados.getSelectedRow() < 0) {
            Mensajes.informacion("Seleccione un fila de la tabla");
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlVendedor.delVendedor();
                    CabecerasTablas.limpiarTablas(tablaEmpleados);
                    controlVendedor.listVendedor(tablaEmpleados, "vendedor.ven_codigo");
                }
            } catch (Exception e) {
                //Mensajes.informacion("Seleccione un fila de la tabla");
            }
        }
    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void itemModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarEActionPerformed
        // TODO add your handling code here:
        btnModificarEActionPerformed(null);
    }//GEN-LAST:event_itemModificarEActionPerformed

    private void itemEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarEActionPerformed
        // TODO add your handling code here:
        btnEliminarEActionPerformed(null);
    }//GEN-LAST:event_itemEliminarEActionPerformed

    private void itemOrdenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenCActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablas(tablaEmpleados);        
        controlVendedor.listVendedor(tablaEmpleados, "vendedor.ven_codigo");
    }//GEN-LAST:event_itemOrdenCActionPerformed

    private void itemPModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPModificarEActionPerformed
        // TODO add your handling code here:
        btnModificarEActionPerformed(null);
    }//GEN-LAST:event_itemPModificarEActionPerformed

    private void itemPEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPEliminarEActionPerformed
        // TODO add your handling code here:
        btnEliminarEActionPerformed(null);
    }//GEN-LAST:event_itemPEliminarEActionPerformed

    private void cbkBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkBuscarActionPerformed
        // TODO add your handling code here:
        habilitarbusqueda();
    }//GEN-LAST:event_cbkBuscarActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed
        // TODO add your handling code here:
        try {
            Export = new clsExportarExcel();
            Export.exportarExcel(tablaEmpleados);
        } catch (IOException ex) {
            Logger.getLogger(dlgVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemExportarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txtBuscar.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void tablaEmpleadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMousePressed
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt))
        {
            Point p = evt.getPoint();
            int number = tablaEmpleados.rowAtPoint(p);
            ListSelectionModel modelos = tablaEmpleados.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tablaEmpleadosMousePressed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
        {
            try {
                dlgGestVendedor ven = new dlgGestVendedor(null, true);
                ven.setLocationRelativeTo(null);
                controlVendedor.aModificar();
                ven.setTitle("Modificación de Empleado");
                dlgGestVendedor.btnModificar.setEnabled(true);
                dlgGestVendedor.itemModificar.setEnabled(true);
                dlgGestVendedor.btnGuardar.setEnabled(false);
                dlgGestVendedor.itemGuardar.setEnabled(false);
                dlgGestVendedor.btnNuev.setEnabled(false);
                dlgGestVendedor.itemNuevo.setEnabled(false);
                dlgGestVendedor.btnCancelar.setEnabled(true);
                dlgGestVendedor.itemCancelar.setEnabled(true);
                ven.setVisible(true);
            } catch (Exception e) {
                Mensajes.informacion("No se pudo cargar información del vendedor");
            }
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tablaEmpleados.requestFocus();
            tablaEmpleados.changeSelection (0, 5, false, false );
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1KeyPressed

    private void tablaEmpleadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaEmpleadosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                dlgGestVendedor ven = new dlgGestVendedor(null, true);
                ven.setLocationRelativeTo(null);
                controlVendedor.aModificar();
                ven.setTitle("Modificación de Empleado");
                dlgGestVendedor.btnModificar.setEnabled(true);
                dlgGestVendedor.itemModificar.setEnabled(true);
                dlgGestVendedor.btnGuardar.setEnabled(false);
                dlgGestVendedor.itemGuardar.setEnabled(false);
                dlgGestVendedor.btnNuev.setEnabled(false);
                dlgGestVendedor.itemNuevo.setEnabled(false);
                dlgGestVendedor.btnCancelar.setEnabled(true);
                dlgGestVendedor.itemCancelar.setEnabled(true);
                ven.setVisible(true);
            } catch (Exception e) {
                Mensajes.error("No se pudo cagar informacion del Producto" + e.getMessage());
                
            }
        }
    }//GEN-LAST:event_tablaEmpleadosKeyPressed

    void habilitarbusqueda(){
        if(cbkBuscar.isSelected()){
            txtBuscar.setEnabled(true);
            txtBuscar.requestFocus();
        }else{
            txtBuscar.setEnabled(false);
            txtBuscar.setText("");
            CabecerasTablas.limpiarTablas(tablaEmpleados);
            controlVendedor.listVendedor(tablaEmpleados, "vendedor.ven_codigo");
        }
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
            java.util.logging.Logger.getLogger(dlgVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgVendedor dialog = new dlgVendedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnModificarE;
    private javax.swing.JButton btnNuevoE;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbkBuscar;
    private javax.swing.JMenuItem itemEliminarE;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemModificarE;
    private javax.swing.JMenuItem itemNuevoE;
    private javax.swing.JMenuItem itemOrdenC;
    private javax.swing.JMenuItem itemOrdenN;
    private javax.swing.JMenuItem itemPEliminarE;
    private javax.swing.JMenuItem itemPModificarE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    public static javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
