package IU;

import Componentes.Mensajes;
import Componentes.Software;
import Componentes.traerIP;
import Controladores.ControlLogeo;
import Controladores.controlPerfil;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.UnsupportedLookAndFeelException;

public final class frmAcceso extends javax.swing.JFrame {
    public frmAcceso() {
        initComponents();
        txtUsuario.requestFocus();
        titulo();
        cargarIcono();
        try { 
            lblIP.setText("HOST IP : "+traerIP.getIP());
            lblHost.setText("HOST: "+traerIP.getHostname());
        } catch (Exception e) {
        }
        
    }
    
    void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Bienvenido");
        }else{
            this.setTitle("Bienvendo a "+Software.getSoftware());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblHost = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        txtUsuario = new RSMaterialComponent.RSTextFieldMaterial();
        psPasword = new RSMaterialComponent.RSPasswordMaterial();
        jPanel5 = new javax.swing.JPanel();
        lblIP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rSButtonIconUno1 = new RSMaterialComponent.RSButtonIconUno();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("OMEGLE", 0, 50)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/P-VENTAS-ICONX300.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 330, 110));

        lblHost.setFont(new java.awt.Font("HelveticaCondensed", 1, 20)); // NOI18N
        lblHost.setForeground(new java.awt.Color(255, 255, 255));
        lblHost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHost.setText("NOMBRE HOST");
        lblHost.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(lblHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 310, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CONTRASEÑA");

        lblMensaje.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(40, 66, 81));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setColorMaterial(new java.awt.Color(255, 51, 0));
        txtUsuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtUsuario.setPlaceholder("");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        psPasword.setForeground(new java.awt.Color(0, 0, 0));
        psPasword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        psPasword.setColorMaterial(new java.awt.Color(255, 51, 0));
        psPasword.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        psPasword.setPlaceholder("");
        psPasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psPaswordActionPerformed(evt);
            }
        });
        psPasword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psPaswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                psPaswordKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(psPasword, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psPasword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 360, 320, 110));

        jPanel5.setBackground(new java.awt.Color(61, 61, 61));

        lblIP.setBackground(new java.awt.Color(255, 255, 255));
        lblIP.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lblIP.setForeground(new java.awt.Color(255, 255, 255));
        lblIP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP.setText("IP : ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 330, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/llaveInicio2.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 330, 180));

        rSButtonIconUno1.setBackground(new java.awt.Color(0, 102, 102));
        rSButtonIconUno1.setBackgroundHover(new java.awt.Color(255, 0, 0));
        rSButtonIconUno1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        rSButtonIconUno1.setPreferredSize(new java.awt.Dimension(30, 30));
        rSButtonIconUno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconUno1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonIconUno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 0, 15, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        psPasword.requestFocus();
        psPasword.selectAll();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=10;
        if (txtUsuario.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void psPaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psPaswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psPaswordActionPerformed

    private void psPaswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psPaswordKeyPressed
        // TODO add your handling code here:
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
            ControlLogeo.logear();
            controlPerfil.perfil();
            this.dispose();
        } catch (Exception e) {
            txtUsuario.requestFocus();
            txtUsuario.selectAll();
            System.out.println("Error al cargar Principal: "+e.toString());
        }
        }
    }//GEN-LAST:event_psPaswordKeyPressed

    private void psPaswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psPaswordKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=15;
        if (psPasword.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_psPaswordKeyTyped

    private void rSButtonIconUno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconUno1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_rSButtonIconUno1ActionPerformed

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
            setVisible(true);
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
    }
    /*void LookAndFeel() {
        //Look And Feel
        System.setProperty(
                "Quaqua.tabLayoutPolicy", "wrap"
        );
        try {
            //UIManager.setLookAndFeel(tema);
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
            //UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
            //UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ParseException | UnsupportedLookAndFeelException erro) {
            //Mensajes.informacion("Error al cargar el tema");
            System.out.println("Error al cargar el tema");
        }
    }*/
    /*public void LookAndFeel2() {
        //Look And Feel
        System.setProperty(
                "Quaqua.tabLayoutPolicy", "wrap"
        );
        try {
            SubstanceLookAndFeel.setSkin(tema);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            Mensajes.informacion("Error al cargar el tema");
        }
    }*/
    
    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[])throws UnsupportedLookAndFeelException {
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
       java.util.logging.Logger.getLogger(frmAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
        //</editor-fold>
        
       //</editor-fold>
           

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmAcceso().setVisible(true);
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JLabel lblHost;
    public static javax.swing.JLabel lblIP;
    public static javax.swing.JLabel lblMensaje;
    public static RSMaterialComponent.RSPasswordMaterial psPasword;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno1;
    public static RSMaterialComponent.RSTextFieldMaterial txtUsuario;
    // End of variables declaration//GEN-END:variables

}
