package IU;

import Componentes.Mensajes;
import Componentes.RenderDecimal;
import Componentes.Reporte;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class dlgArticulos extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    clsExportarExcel Export;
    public Reporte jasper;

    public dlgArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        jasper = new Reporte();
        cabe.Articulos(tbProductos);
        controlArticulo.filtrarGral(tbProductos, "");
        Renders();
        txtBuscar.requestFocus();
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Gestor de artículos");
        }else{
            this.setTitle(Software.getSoftware()+" - Gestor de artículos");
        }
    }

    public static void Renders() {
        dlgArticulos.tbProductos.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimal());
        dlgArticulos.tbProductos.getColumnModel().getColumn(13).setCellRenderer(new RenderDecimal());
        dlgArticulos.tbProductos.getColumnModel().getColumn(15).setCellRenderer(new RenderDecimal());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mbtnMmodificar = new javax.swing.JMenuItem();
        mbtnEliminar = new javax.swing.JMenuItem();
        grupoBotones = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonBigIcon_new();
        btnModificar = new newscomponents.RSButtonBigIcon_new();
        btnEliminar = new newscomponents.RSButtonBigIcon_new();
        btnRefrescar = new newscomponents.RSButtonBigIcon_new();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevoE = new javax.swing.JMenuItem();
        itemModificarE = new javax.swing.JMenuItem();
        itemEliminarE = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemExportar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemNuevoE1 = new javax.swing.JMenuItem();

        mbtnMmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificarproducto - copia.png"))); // NOI18N
        mbtnMmodificar.setText("     Modificar");
        mbtnMmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnMmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mbtnMmodificar);

        mbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteproducto - copia.png"))); // NOI18N
        mbtnEliminar.setText("     Eliminar");
        mbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mbtnEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search15.png"))); // NOI18N
        jLabel3.setText("Buscador de Artículos:");

        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbProductos.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductos.setGridColor(new java.awt.Color(204, 204, 204));
        tbProductos.setRowHeight(20);
        tbProductos.setShowGrid(true);
        tbProductos.setShowHorizontalLines(true);
        tbProductos.setShowVerticalLines(false);
        tbProductos.getTableHeader().setResizingAllowed(false);
        tbProductos.getTableHeader().setReorderingAllowed(false);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbProductosMousePressed(evt);
            }
        });
        tbProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(583, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 6));

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
        jPanel1.add(btnNuevo);

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
        jPanel1.add(btnModificar);

        btnEliminar.setBackground(new java.awt.Color(0, 102, 102));
        btnEliminar.setBorder(null);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBgHover(new java.awt.Color(0, 102, 102));
        btnEliminar.setFgIcon(new java.awt.Color(153, 153, 153));
        btnEliminar.setFgText(new java.awt.Color(153, 153, 153));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnEliminar.setIconTextGap(0);
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE_FOREVER);
        btnEliminar.setPixels(0);
        btnEliminar.setSizeIcon(45.0F);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);

        btnRefrescar.setBackground(new java.awt.Color(0, 102, 102));
        btnRefrescar.setBorder(null);
        btnRefrescar.setText("ACTUALIZAR");
        btnRefrescar.setBgHover(new java.awt.Color(0, 102, 102));
        btnRefrescar.setFgIcon(new java.awt.Color(153, 153, 153));
        btnRefrescar.setFgText(new java.awt.Color(153, 153, 153));
        btnRefrescar.setFocusPainted(false);
        btnRefrescar.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        btnRefrescar.setIconTextGap(0);
        btnRefrescar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btnRefrescar.setPixels(0);
        btnRefrescar.setSizeIcon(45.0F);
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefrescar);

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
        jPanel1.add(btnSalir);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_menu_black_24.png"))); // NOI18N
        jMenu1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemNuevoE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevoE.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemNuevoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_add_box_black_24.png"))); // NOI18N
        itemNuevoE.setText("NUEVO");
        itemNuevoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoEActionPerformed(evt);
            }
        });
        jMenu1.add(itemNuevoE);

        itemModificarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificarE.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_edit_black_24.png"))); // NOI18N
        itemModificarE.setText("MODIFICAR");
        itemModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemModificarE);

        itemEliminarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemEliminarE.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_delete_forever_black_24.png"))); // NOI18N
        itemEliminarE.setText("ELIMINAR");
        itemEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemEliminarE);
        jMenu1.add(jSeparator2);

        itemExportar.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_file_download_black_24.png"))); // NOI18N
        itemExportar.setText("EXPORTAR LISTADO DE PRODUCTOS A EXCEL");
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        jMenu1.add(itemExportar);
        jMenu1.add(jSeparator3);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/outline_exit_to_app_black_24.png"))); // NOI18N
        itemSalir.setText("SALIR");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(itemSalir);

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleName("OPCIONES");

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_history_edu_black_24.png"))); // NOI18N
        jMenu2.setText("REPORTE");
        jMenu2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        itemNuevoE1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemNuevoE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_pageview_black_24.png"))); // NOI18N
        itemNuevoE1.setText("Reporte de Artículos con Stock Crítico");
        itemNuevoE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoE1ActionPerformed(evt);
            }
        });
        jMenu2.add(itemNuevoE1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMousePressed
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int number = tbProductos.rowAtPoint(p);
            ListSelectionModel modelos = tbProductos.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tbProductosMousePressed
    void nuevoArticulo() {
        dlgGestArticulos gestArticulos = new dlgGestArticulos(null, true);
        gestArticulos.setLocationRelativeTo(null);
        gestArticulos.Nuevo();
        gestArticulos.setVisible(true);

    }
    private void mbtnMmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnMmodificarActionPerformed
        // TODO add your handling code here:
        dlgGestArticulos a = new dlgGestArticulos(null, false);
        a.setLocationRelativeTo(null);
        controlArticulo.aModifcar();
        dlgGestArticulos.btnNuevo.setEnabled(false);
        dlgGestArticulos.itemNuevo.setEnabled(false);
        dlgGestArticulos.btnModificar.setEnabled(true);
        dlgGestArticulos.itemModificar.setEnabled(true);
        dlgGestArticulos.btnGuardar.setEnabled(false);
        dlgGestArticulos.itemGuardar.setEnabled(false);
        dlgGestArticulos.btnCancelar.setEnabled(true);
        dlgGestArticulos.itemCancelar.setEnabled(true);
        dlgGestArticulos.txtCodBarra.requestFocus();
        dlgGestArticulos.txtStock.setEnabled(false);
        a.modcbLaboratorio();
        a.modcbProveedor();
        a.modcbFamilia();
        dlgGestArticulos.CalculoIVAC();
        a.setVisible(true);
    }//GEN-LAST:event_mbtnMmodificarActionPerformed
    void modArticulo() {
        int x = tbProductos.getSelectedRow();
        if (x < 0) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        } else {
            try {
                dlgGestArticulos a = new dlgGestArticulos(null, false);
                a.setLocationRelativeTo(null);
                controlArticulo.aModifcar();
                dlgGestArticulos.btnNuevo.setEnabled(false);
                dlgGestArticulos.itemNuevo.setEnabled(false);
                dlgGestArticulos.btnModificar.setEnabled(true);
                dlgGestArticulos.itemModificar.setEnabled(true);
                dlgGestArticulos.btnGuardar.setEnabled(false);
                dlgGestArticulos.itemGuardar.setEnabled(false);
                dlgGestArticulos.btnCancelar.setEnabled(true);
                dlgGestArticulos.itemCancelar.setEnabled(true);
                dlgGestArticulos.txtCodBarra.requestFocus();
                dlgGestArticulos.txtStock.setEnabled(false);
                a.modcbLaboratorio();
                a.modcbProveedor();
                a.modcbFamilia();
                dlgGestArticulos.CalculoIVAC();
                a.setVisible(true);
            } catch (Exception e) {
                //Mensajes.error("Seleccione una fila de la tabla");     
            }
            tbProductos.clearSelection();
        }

    }    void delArticulo() {
        try {
            int x = tbProductos.getSelectedRow();
            String desc = tbProductos.getValueAt(x, 5).toString();
            int rpta = Mensajes.confirmar("Desea realmente eliminar " + desc + " de la lista");
            if (rpta == 0) {
                controlArticulo.delArticulo();
                CabecerasTablas.limpiarTablas(tbProductos);
                controlArticulo.listArticulo(tbProductos, "cod");
                txtBuscar.setText("");
                txtBuscar.requestFocus();
            }
        } catch (Exception e) {
            Mensajes.error("Seleccione una fila de la tabla");
        }
    }
    private void mbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int x = tbProductos.getSelectedRow();
            String desc = tbProductos.getValueAt(x, 5).toString();
            int rpta = Mensajes.confirmar("Desea realmente eliminar " + desc + " de la lista");
            if (rpta == 0) {
                controlArticulo.delArticulo();
                CabecerasTablas.limpiarTablas(tbProductos);
                controlArticulo.listArticulo(tbProductos, "cod");
                txtBuscar.setText("");
                txtBuscar.requestFocus();
            }
        } catch (Exception e) {
            Mensajes.informacion("Seleccione una fila de la tabla");
        }
    }//GEN-LAST:event_mbtnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        System.out.println(txtBuscar.getText().trim().length());
        try {
            String cod = txtBuscar.getText();
            cabe.Articulos(tbProductos);
            CabecerasTablas.limpiarTablas(tbProductos);
            controlArticulo.filtrarGral(tbProductos, cod);
            /*cabe.Articulos(tbProductos);
            controlArticulo.listArticulo(tbProductos, "cod");
            CabecerasTablas.limpiarTablas(tbProductos);
            controlArticulo.filtrarGral(tbProductos, cod);*/
            Renders();
        } catch (Exception e) {
            System.out.println("Mensaje de Error: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            try {
                dlgGestArticulos a = new dlgGestArticulos(null, false);
                a.setLocationRelativeTo(null);
                controlArticulo.aModifcar();
                //a.setTitle("Gestionar Productos");
                dlgGestArticulos.btnNuevo.setEnabled(false);
                dlgGestArticulos.itemNuevo.setEnabled(false);
                dlgGestArticulos.btnModificar.setEnabled(true);
                dlgGestArticulos.itemModificar.setEnabled(true);
                dlgGestArticulos.btnGuardar.setEnabled(false);
                dlgGestArticulos.itemGuardar.setEnabled(false);
                dlgGestArticulos.btnCancelar.setEnabled(true);
                dlgGestArticulos.itemCancelar.setEnabled(true);
                dlgGestArticulos.txtCodBarra.requestFocus();
                dlgGestArticulos.txtStock.setEnabled(false);
                a.modcbLaboratorio();
                a.modcbProveedor();
                a.modcbFamilia();
                dlgGestArticulos.CalculoIVAC();
                a.setVisible(true);
            } catch (Exception e) {
                Mensajes.error("No se pudo cagar informacion del Producto");

            }
        }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void itemNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoEActionPerformed
        // TODO add your handling code here:
        btnNuevoActionPerformed(null);
    }//GEN-LAST:event_itemNuevoEActionPerformed

    private void itemModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarEActionPerformed
        // TODO add your handling code here:
        btnModificarActionPerformed(null);
    }//GEN-LAST:event_itemModificarEActionPerformed

    private void itemEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarEActionPerformed
        // TODO add your handling code here:
        btnEliminarActionPerformed(null);
    }//GEN-LAST:event_itemEliminarEActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed

        try {
            Export = new clsExportarExcel();
            Export.exportarExcel(tbProductos);
        } catch (IOException ex) {
            Logger.getLogger(dlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemExportarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                dlgGestArticulos a = new dlgGestArticulos(null, false);
                a.setLocationRelativeTo(null);
                controlArticulo.aModifcar();
                dlgGestArticulos.btnNuevo.setEnabled(false);
                dlgGestArticulos.itemNuevo.setEnabled(false);
                dlgGestArticulos.btnModificar.setEnabled(true);
                dlgGestArticulos.itemModificar.setEnabled(true);
                dlgGestArticulos.btnGuardar.setEnabled(false);
                dlgGestArticulos.itemGuardar.setEnabled(false);
                dlgGestArticulos.btnCancelar.setEnabled(true);
                dlgGestArticulos.itemCancelar.setEnabled(true);
                dlgGestArticulos.txtCodBarra.requestFocus();
                dlgGestArticulos.txtStock.setEnabled(false);
                a.modcbLaboratorio();
                a.modcbProveedor();
                a.modcbFamilia();
                dlgGestArticulos.CalculoIVAC();
                a.setVisible(true);
            } catch (Exception e) {
                //Mensajes.error("No se pudo cagar informacion del Producto" + e.getMessage());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txtBuscar.requestFocus();
            txtBuscar.selectAll();
        }
    }//GEN-LAST:event_tbProductosKeyPressed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        System.out.println(txtBuscar.getText().length());
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tbProductos.getRowCount() <= 0) {
                txtBuscar.requestFocus();
                txtBuscar.selectAll();
            } else {
                tbProductos.requestFocus();
                tbProductos.getSelectionModel().setSelectionInterval(0, 0);
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void itemNuevoE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoE1ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteStockCritico rsc = new dlgReporteStockCritico(null, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }

        //
    }//GEN-LAST:event_itemNuevoE1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }else{
            txtBuscar.requestFocus();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // TODO add your handling code here:
        cabe.Articulos(tbProductos);
        controlArticulo.filtrarGral(tbProductos, "");
        Renders();
        txtBuscar.setText("");
        txtBuscar.requestFocus();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        nuevoArticulo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        delArticulo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
         modArticulo();        
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(dlgArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgArticulos dialog = new dlgArticulos(new javax.swing.JFrame(), true);
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
    private newscomponents.RSButtonBigIcon_new btnEliminar;
    private newscomponents.RSButtonBigIcon_new btnModificar;
    private newscomponents.RSButtonBigIcon_new btnNuevo;
    private newscomponents.RSButtonBigIcon_new btnRefrescar;
    private newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JMenuItem itemEliminarE;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemModificarE;
    private javax.swing.JMenuItem itemNuevoE;
    public javax.swing.JMenuItem itemNuevoE1;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem mbtnEliminar;
    private javax.swing.JMenuItem mbtnMmodificar;
    public static javax.swing.JTable tbProductos;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
