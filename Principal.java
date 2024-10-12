
import java.awt.CardLayout;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Luis Hernández
 */


public class Principal extends javax.swing.JFrame {
    /**
     * Creates new form Principal
     */
    CardLayout cardLayout;
    public Principal() {
        initComponents();
        
        cardLayout =(CardLayout)(jPanelPrincipal.getLayout());
             
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanelMenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLNombreUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbReportes = new javax.swing.JButton();
        jbPagos = new javax.swing.JButton();
        jbVentas = new javax.swing.JButton();
        jbTyA = new javax.swing.JButton();
        jbUsuarios = new javax.swing.JButton();
        jbProyectos = new javax.swing.JButton();
        jbInicio = new javax.swing.JButton();
        jPanelPrincipal = new javax.swing.JPanel();
        pclInicio = new javax.swing.JPanel();
        pclProyectos = new javax.swing.JPanel();
        pclUsuarios = new javax.swing.JPanel();
        pclTyA = new javax.swing.JPanel();
        pclVentas = new javax.swing.JPanel();
        pclPagos = new javax.swing.JPanel();
        pclReportes = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelMenu.setBackground(new java.awt.Color(255, 153, 51));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Construct MAX S.A");
        jPanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
        jPanelMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 120, 160, 10));
        jPanelMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 239, 169, 10));

        jLNombreUsuario.setText("ADMINISTRADOR");
        jPanelMenu.add(jLNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 112, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 79, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png"))); // NOI18N
        jPanelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 130, 80, 75));

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.setContentAreaFilled(false);
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 90, -1));

        jbReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analitica.png"))); // NOI18N
        jbReportes.setText("Reportes");
        jbReportes.setContentAreaFilled(false);
        jbReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReportesActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 110, -1));

        jbPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dinero.png"))); // NOI18N
        jbPagos.setText("Pagos");
        jbPagos.setContentAreaFilled(false);
        jbPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagosActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 90, -1));

        jbVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contrato.png"))); // NOI18N
        jbVentas.setText("Ventas");
        jbVentas.setContentAreaFilled(false);
        jbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 90, -1));

        jbTyA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edificio.png"))); // NOI18N
        jbTyA.setText("Torres y Aptos");
        jbTyA.setContentAreaFilled(false);
        jbTyA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTyAActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbTyA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 130, -1));

        jbUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        jbUsuarios.setText("Usuarios");
        jbUsuarios.setContentAreaFilled(false);
        jbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsuariosActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 100, -1));

        jbProyectos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/proyecto.png"))); // NOI18N
        jbProyectos.setText("Proyectos");
        jbProyectos.setContentAreaFilled(false);
        jbProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProyectosActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 110, -1));

        jbInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/casa.png"))); // NOI18N
        jbInicio.setText("Dashboard");
        jbInicio.setContentAreaFilled(false);
        jbInicio.setPreferredSize(new java.awt.Dimension(107, 24));
        jbInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInicioActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 110, -1));

        jSplitPane2.setLeftComponent(jPanelMenu);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new java.awt.CardLayout());

        pclInicio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pclInicioLayout = new javax.swing.GroupLayout(pclInicio);
        pclInicio.setLayout(pclInicioLayout);
        pclInicioLayout.setHorizontalGroup(
            pclInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pclInicioLayout.setVerticalGroup(
            pclInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclInicio, "pclInicio");

        pclProyectos.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout pclProyectosLayout = new javax.swing.GroupLayout(pclProyectos);
        pclProyectos.setLayout(pclProyectosLayout);
        pclProyectosLayout.setHorizontalGroup(
            pclProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pclProyectosLayout.setVerticalGroup(
            pclProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclProyectos, "pclProyectos");

        pclUsuarios.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout pclUsuariosLayout = new javax.swing.GroupLayout(pclUsuarios);
        pclUsuarios.setLayout(pclUsuariosLayout);
        pclUsuariosLayout.setHorizontalGroup(
            pclUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pclUsuariosLayout.setVerticalGroup(
            pclUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclUsuarios, "pclUsuarios");

        pclTyA.setBackground(new java.awt.Color(255, 51, 255));

        javax.swing.GroupLayout pclTyALayout = new javax.swing.GroupLayout(pclTyA);
        pclTyA.setLayout(pclTyALayout);
        pclTyALayout.setHorizontalGroup(
            pclTyALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pclTyALayout.setVerticalGroup(
            pclTyALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclTyA, "pclTyA");

        pclVentas.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout pclVentasLayout = new javax.swing.GroupLayout(pclVentas);
        pclVentas.setLayout(pclVentasLayout);
        pclVentasLayout.setHorizontalGroup(
            pclVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pclVentasLayout.setVerticalGroup(
            pclVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclVentas, "pclVentas");

        pclPagos.setBackground(new java.awt.Color(102, 255, 0));

        javax.swing.GroupLayout pclPagosLayout = new javax.swing.GroupLayout(pclPagos);
        pclPagos.setLayout(pclPagosLayout);
        pclPagosLayout.setHorizontalGroup(
            pclPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pclPagosLayout.setVerticalGroup(
            pclPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclPagos, "pclPagos");

        pclReportes.setBackground(new java.awt.Color(0, 255, 204));

        javax.swing.GroupLayout pclReportesLayout = new javax.swing.GroupLayout(pclReportes);
        pclReportes.setLayout(pclReportesLayout);
        pclReportesLayout.setHorizontalGroup(
            pclReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pclReportesLayout.setVerticalGroup(
            pclReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclReportes, "pclReportes");

        jSplitPane2.setRightComponent(jPanelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProyectosActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanelPrincipal, "pclProyectos");
    }//GEN-LAST:event_jbProyectosActionPerformed

    private void jbInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInicioActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanelPrincipal, "pclInicio");
        
    }//GEN-LAST:event_jbInicioActionPerformed

    private void jbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsuariosActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanelPrincipal, "pclUsuarios");
    }//GEN-LAST:event_jbUsuariosActionPerformed

    private void jbTyAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTyAActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanelPrincipal, "pclTyA");
    }//GEN-LAST:event_jbTyAActionPerformed

    private void jbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanelPrincipal, "pclVentas");
    }//GEN-LAST:event_jbVentasActionPerformed

    private void jbPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagosActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanelPrincipal, "pclPagos");
    }//GEN-LAST:event_jbPagosActionPerformed

    private void jbReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportesActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanelPrincipal, "pclReportes");
    }//GEN-LAST:event_jbReportesActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLNombreUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JButton jbInicio;
    private javax.swing.JButton jbPagos;
    private javax.swing.JButton jbProyectos;
    private javax.swing.JButton jbReportes;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbTyA;
    private javax.swing.JButton jbUsuarios;
    private javax.swing.JButton jbVentas;
    private javax.swing.JPanel pclInicio;
    private javax.swing.JPanel pclPagos;
    private javax.swing.JPanel pclProyectos;
    private javax.swing.JPanel pclReportes;
    private javax.swing.JPanel pclTyA;
    private javax.swing.JPanel pclUsuarios;
    private javax.swing.JPanel pclVentas;
    // End of variables declaration//GEN-END:variables
}
