package IU;

import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.Redondeo;
import Componentes.Software;
import Componentes.generarCodigos;
import Controladores.ControlCaja;
import Datos.GestionarCaja;
import Modelo.Caja;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public final class dlgCajaDia extends javax.swing.JDialog {
    public String NCaja;
    public int ING;
    public int GAS;
    public int INI;
    
    public dlgCajaDia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        Invisible();
        try {
            NCaja=(generarCodigos.ObtenerCodigo("SELECT ca_id from caja where ca_indicador='S' ORDER BY ca_id DESC LIMIT 1"));
            System.out.println("N CAja hoy: "+NCaja);
            Caja caj = GestionarCaja.busCaja(NCaja);
            DecimalFormat df = new DecimalFormat("#,###");
            lbInicial.setText(df.format(Integer.valueOf(String.valueOf(caj.getCaInicial()).trim().replace(".", "").replace(",", ""))));
            txtIncial.setText(String.valueOf(caj.getCaInicial()));
            INI=((caj.getCaInicial()));
            lbNCaja.setText(String.valueOf(caj.getCaId()));
            lbApertura.setText(String.valueOf(caj.getFechaI()+" "+caj.getHoraI()));
            lbUsuI.setText(String.valueOf(caj.getUsuarioI()));
            if(caj.getIndicador().equals("S")){
                lbEstado.setText("ABIERTO");
            }else{
                lbEstado.setText("CERRADO");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        totalVentasCont();
        totalVentasCred();
        totalCompraCont();
        totalCompraCred();
        totalGasto();
        totalIngreso();
        gastoTotal();
        ingresoTotal();
        totalCaja();
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Cerrar movimientos del día");
        }else{
            this.setTitle(Software.getSoftware()+" - Cerrar movimientos del día");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbApertura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbUsuI = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbNCaja = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbInicial = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblDiferencia = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTotalVentas = new javax.swing.JTextField();
        txtTotalIngreso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIngresoT = new javax.swing.JTextField();
        txtTotalVentasC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtTotalCompra = new javax.swing.JTextField();
        txtTotalGastos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtGastoTotal = new javax.swing.JTextField();
        txtTotalCompraC = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtIncial = new javax.swing.JTextField();
        txtTotalE = new javax.swing.JTextField();
        txtDiferencia = new javax.swing.JTextField();
        barMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel5.setLayout(new java.awt.GridLayout(1, 9));

        btnCerrar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icon-cerrarcaja.png"))); // NOI18N
        btnCerrar.setText("Cerrar Caja-F6");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnCerrar);

        btnImprimir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/printer30.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerifyInputWhenFocusTarget(false);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel5.add(btnImprimir);

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
        jPanel5.add(btnSalir);

        jPanel7.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, -1, 62));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Caja abierta el:");

        lbApertura.setText("FECHA Y HORA");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Por el usuario:");

        lbUsuI.setText("USUSARIO");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Estado actual:");

        lbEstado.setForeground(new java.awt.Color(0, 153, 0));
        lbEstado.setText("ESTADO");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Cierre de movimiento diario N°");

        lbNCaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNCaja.setText("NCaja");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel4.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Caja incial del día:");

        lbInicial.setBackground(new java.awt.Color(255, 255, 255));
        lbInicial.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbInicial.setForeground(new java.awt.Color(153, 0, 0));
        lbInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInicial.setText("0");
        lbInicial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbInicial.setOpaque(true);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Cierre final de la caja (Se contabilizan todas las ventas activas):");

        lblDiferencia.setBackground(new java.awt.Color(255, 255, 255));
        lblDiferencia.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblDiferencia.setForeground(new java.awt.Color(0, 153, 0));
        lblDiferencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiferencia.setText("0");
        lblDiferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblDiferencia.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RESUMEN FINAL");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(lblDiferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbUsuI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNCaja)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbApertura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbUsuI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(lbEstado)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        txtTotalVentas.setEditable(false);
        txtTotalVentas.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalVentas.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTotalVentas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalVentas.setText("0");
        txtTotalVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtTotalIngreso.setEditable(false);
        txtTotalIngreso.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalIngreso.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTotalIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalIngreso.setText("0");
        txtTotalIngreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Suma de las ventas a contado en efectivo:");

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Suma de las cobranzas y otros ingresos en efectivo:");

        jLabel14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel14.setText("TOTAL  DE TODOS LOS INGRESOS EN EFECTIVO EN LA CAJA:");

        txtIngresoT.setEditable(false);
        txtIngresoT.setBackground(new java.awt.Color(255, 255, 255));
        txtIngresoT.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtIngresoT.setForeground(new java.awt.Color(0, 153, 0));
        txtIngresoT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIngresoT.setText("0");
        txtIngresoT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtTotalVentasC.setEditable(false);
        txtTotalVentasC.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalVentasC.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtTotalVentasC.setForeground(new java.awt.Color(0, 0, 102));
        txtTotalVentasC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalVentasC.setText("0");
        txtTotalVentasC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("PARA CONSIDERAR: Calculo de ventas a Crédito:");

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DETALLE DE INGRESOS");
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIngresoT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTotalVentasC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtIngresoT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotalVentasC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        txtTotalCompra.setEditable(false);
        txtTotalCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompra.setText("0");
        txtTotalCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtTotalGastos.setEditable(false);
        txtTotalGastos.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalGastos.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtTotalGastos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalGastos.setText("0");
        txtTotalGastos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Suma de las compras a contado:");

        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Suma de los pagos y retiros:");

        jLabel15.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("TOTAL DE TODOS LOS EGRESOS DEL LA CAJA:");

        txtGastoTotal.setEditable(false);
        txtGastoTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtGastoTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtGastoTotal.setForeground(new java.awt.Color(153, 0, 0));
        txtGastoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGastoTotal.setText("0");
        txtGastoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtTotalCompraC.setEditable(false);
        txtTotalCompraC.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalCompraC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtTotalCompraC.setForeground(new java.awt.Color(0, 0, 102));
        txtTotalCompraC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompraC.setText("0");
        txtTotalCompraC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("PARA CONSIDERAR: Compras a crédito");

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DETALLE DE EGRESOS");
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalCompraC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtGastoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txtTotalCompra)
                                .addComponent(txtTotalGastos)))))
                .addGap(18, 18, 18))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGastoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCompraC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtIncial.setEditable(false);
        txtIncial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIncial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIncial.setText("0");

        txtTotalE.setEditable(false);
        txtTotalE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotalE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalE.setText("0");

        txtDiferencia.setEditable(false);
        txtDiferencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12)); // NOI18N
        txtDiferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDiferencia.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(311, 311, 311)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTotalE, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIncial, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(txtDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(txtTotalE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)
                            .addComponent(txtIncial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(322, Short.MAX_VALUE)))
        );

        barMenu.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        menuOpciones.setText("Opciones");
        menuOpciones.setFocusable(false);
        menuOpciones.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        menuOpciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itemNuevo.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        itemNuevo.setText("Cerrar Caja");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuOpciones.add(itemNuevo);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        itemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/printer15.png"))); // NOI18N
        itemModificar.setText("Imprimir");
        itemModificar.setEnabled(false);
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        menuOpciones.add(itemModificar);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
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
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void Invisible(){
        txtTotalE.setVisible(false);
        txtIncial.setVisible(false);
        txtDiferencia.setVisible(false);
    }
    void totalVentasCont() {
        try {
            String TotalVenta=(generarCodigos.getDecimales("SELECT IFNULL((select SUM(fac_totalfinal) from factura where caja_ca_id = "+NCaja+" and fac_indicador='S' and fac_tipoventa='CONTADO'),0)"));
            DecimalFormat df = new DecimalFormat("#,###");
            txtTotalVentas.setText(df.format(Integer.valueOf((TotalVenta.trim().replace(".", "").replace(",", "")))));
        } catch (Exception e) {
            txtTotalVentas.setText("0");
        }
    }
    void totalVentasCred() {
        try {
            String TotalVenta=(generarCodigos.getDecimales("SELECT IFNULL((select SUM(fac_totalfinal) from factura where caja_ca_id = "+NCaja+" and fac_indicador='S' and fac_tipoventa='CREDITO'),0)"));
            DecimalFormat df = new DecimalFormat("#,###");
            txtTotalVentasC.setText(df.format(Integer.valueOf((TotalVenta.trim().replace(".", "").replace(",", "")))));   
        } catch (Exception e) {
            txtTotalVentasC.setText("0");
        }
    }
    
    void totalCompraCont() {
        try {
            String TotalCompra=(generarCodigos.getDecimales("SELECT IFNULL((select SUM(com_total) from compra where caja_ca_id = " +NCaja+ " and com_indicador='S' and com_condpago='CONTADO'),0)"));
            DecimalFormat df = new DecimalFormat("#,###");
            txtTotalCompra.setText(df.format(Integer.valueOf((TotalCompra.trim().replace(".", "").replace(",", "")))));
        } catch (Exception e) {
            txtTotalCompra.setText("0");
        }
        
    }
    void totalCompraCred() {
        try {
            String TotalCompra=(generarCodigos.getDecimales("SELECT IFNULL((select SUM(com_total) from compra where caja_ca_id = " +NCaja+ " and com_indicador='S' and com_condpago='CREDITO'),0)"));
            DecimalFormat df = new DecimalFormat("#,###");
            txtTotalCompraC.setText(df.format(Integer.valueOf((TotalCompra.trim().replace(".", "").replace(",", "")))));
        } catch (Exception e) {
            txtTotalCompraC.setText("0");
        }
        
    }

    void totalGasto() {
        try {
            DecimalFormat df = new DecimalFormat("#,###");
            String TotalGasto=(generarCodigos.getDecimales("SELECT IFNULL((select SUM(ga_importe) from gastos where caja_ca_id = " +NCaja+ " and ga_indicador='S'),0)"));
            txtTotalGastos.setText(df.format(Integer.valueOf((TotalGasto.trim().replace(".", "").replace(",", "")))));
        } catch (Exception e) {
            txtTotalGastos.setText("0");
        }
    }
    
    void totalIngreso() {
        try {
            String TotalIngreso=(generarCodigos.getDecimales("SELECT IFNULL((select SUM(ing_importe) from ingreso where caja_ca_id = " +NCaja+ " and ing_indicador='S'),0)"));
            DecimalFormat df = new DecimalFormat("#,###");
            txtTotalIngreso.setText(df.format(Integer.valueOf((TotalIngreso.trim().replace(".", "").replace(",", "")))));
        } catch (Exception e) {
            txtTotalIngreso.setText("0");
        }
        
    }

    void gastoTotal() {
        try {
            StringBuilder sql = new StringBuilder("SELECT IFNULL((SELECT IFNULL((select SUM(com_total) from compra where caja_ca_id =");
            sql.append(NCaja);sql.append(" and com_indicador='S' and com_condpago='CONTADO'),0))+");
            sql.append("(SELECT IFNULL((select SUM(ga_importe) from gastos where caja_ca_id = ");
            sql.append(NCaja);sql.append(" and ga_indicador='S'),0)),0)");
            DecimalFormat df = new DecimalFormat("#,###");
            String GastoTotal=(generarCodigos.getDecimales(sql.toString()));
            GAS=Integer.parseInt(GastoTotal);
            txtGastoTotal.setText(df.format(Integer.valueOf((GastoTotal.trim().replace(".", "").replace(",", "")))));
        } catch (Exception e) {
            txtGastoTotal.setText("0");
        }
    }
    
    void ingresoTotal(){
        try {
            StringBuilder sql = new StringBuilder("SELECT IFNULL((SELECT IFNULL((select SUM(fac_totalfinal) from factura where caja_ca_id=");
            sql.append(NCaja);sql.append(" and fac_indicador='S' and fac_tipoventa='CONTADO'),0))+");
            sql.append("(SELECT IFNULL((select SUM(ing_importe) from ingreso where caja_ca_id=");
            sql.append(NCaja);sql.append(" and ing_indicador='S'),0)),0)");
            DecimalFormat df = new DecimalFormat("#,###");
            String IngresoTotal=(generarCodigos.getDecimales(sql.toString()));
            ING=Integer.parseInt(IngresoTotal);
            txtIngresoT.setText(df.format(Integer.valueOf((IngresoTotal.trim().replace(".", "").replace(",", "")))));
        } catch (Exception e) {
            txtIngresoT.setText("0");
        }
    }
    
    void totalCaja(){
        //int res = ING-GAS;
        int res = ING;
        int ini =Integer.parseInt(txtIncial.getText());
        txtTotalE.setText(String.valueOf(Redondeo.redondearI(res)));
        
        DecimalFormat df = new DecimalFormat("#,###");
        String FINAL=(String.valueOf(Redondeo.redondearI(res)));
        //lbCajaFinal.setText(df.format(Integer.valueOf((FINAL.trim().replace(".", "").replace(",", "")))));
        //txtDiferencia.setText(String.valueOf(Redondeo.redondearI(res-ini)));
        String DIFERENCIA=(String.valueOf(Redondeo.redondearI(res)));
        lblDiferencia.setText(df.format(Integer.valueOf((DIFERENCIA.trim().replace(".", "").replace(",", "")))));
    }
    /*void totalCaja(){
        int res = (ING+INI)-GAS;
        int ini =Integer.parseInt(txtIncial.getText());
        txtTotalE.setText(String.valueOf(Redondeo.redondearI(res)));
        
        DecimalFormat df = new DecimalFormat("#,###");
        String FINAL=(String.valueOf(Redondeo.redondearI(res)));
        lbCajaFinal.setText(df.format(Integer.valueOf((FINAL.trim().replace(".", "").replace(",", "")))));
        txtDiferencia.setText(String.valueOf(Redondeo.redondearI(res-ini)));
        String DIFERENCIA=(String.valueOf(Redondeo.redondearI(res-ini)));
        lblDiferencia.setText(df.format(Integer.valueOf((DIFERENCIA.trim().replace(".", "").replace(",", "")))));
    }*/
    
    
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
       if(Integer.parseInt(txtTotalE.getText())< 0){
            Mensajes.error("El cierre final de la caja contiene saldo negativo.\nNo se puede proceder a cerrar la caja.\nConsejo: verifique si una o varias operaciones no fueron duplicados.");
        }else{
         int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Cerrar la Caja y finalizar las operaciones?", "Cierre de caja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION) {
            try {
                ControlCaja.actCaja();
                btnCerrar.setEnabled(false);
                //btnImprimir.setEnabled(true);
                //int respu = JOptionPane.showConfirmDialog(this, "¿Desea imprimir ticket de arqueo?", "Cierre de caja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                //if (respu == JOptionPane.YES_OPTION) {
                //imprimirCierre();
            //}
            } catch (Exception e) {
                Mensajes.error(e.getMessage());
            }
        }   
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            this.dispose();
        }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
        btnCerrar.doClick();
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed
    
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
            java.util.logging.Logger.getLogger(dlgCajaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgCajaDia dialog = new dlgCajaDia(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JMenuItem itemModificar;
    public static javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbApertura;
    public static javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbInicial;
    public static javax.swing.JLabel lbNCaja;
    private javax.swing.JLabel lbUsuI;
    public static javax.swing.JLabel lblDiferencia;
    private javax.swing.JMenu menuOpciones;
    public static javax.swing.JTextField txtDiferencia;
    private javax.swing.JTextField txtGastoTotal;
    public static javax.swing.JTextField txtIncial;
    private javax.swing.JTextField txtIngresoT;
    private javax.swing.JTextField txtTotalCompra;
    private javax.swing.JTextField txtTotalCompraC;
    public static javax.swing.JTextField txtTotalE;
    private javax.swing.JTextField txtTotalGastos;
    private javax.swing.JTextField txtTotalIngreso;
    private javax.swing.JTextField txtTotalVentas;
    private javax.swing.JTextField txtTotalVentasC;
    // End of variables declaration//GEN-END:variables
}
