/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.ControlLabel;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.Habitacion;

/**
 *
 * @author duoc
 */
public class Habitaciones extends javax.swing.JFrame {

    Habitacion[] h;

    /**
     * Creates new form Habitaciones
     */
    public Habitaciones() {
        initComponents();
        h = Habitacion.getHab();
        //setear label de ocupado o no
        JLabel[] labels = {LBHab0,LBHab1,LBHab2,LBHab3,LBHab4};
        ControlLabel.setLabelHabitacionOcupada(h, labels);
        //setear nombre de habitacion en boton
        JButton[] buttons = {BTNHab0,BTNHab1,BTNHab2,BTNHab3,BTNHab4};
        ControlLabel.setButtonNombreHabitacion(h, buttons);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTNHab0 = new javax.swing.JButton();
        BTNHab1 = new javax.swing.JButton();
        BTNHab2 = new javax.swing.JButton();
        BTNHab3 = new javax.swing.JButton();
        BTNHab4 = new javax.swing.JButton();
        LBHab0 = new javax.swing.JLabel();
        LBHab1 = new javax.swing.JLabel();
        LBHab2 = new javax.swing.JLabel();
        LBHab3 = new javax.swing.JLabel();
        LBHab4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BTNVolver = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(341, 389));
        setMinimumSize(new java.awt.Dimension(341, 389));
        setResizable(false);
        setSize(new java.awt.Dimension(341, 389));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTNHab0.setText("Habitacion0");
        BTNHab0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHab0ActionPerformed(evt);
            }
        });
        getContentPane().add(BTNHab0, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 80, -1, -1));

        BTNHab1.setText("Habitacion1");
        BTNHab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHab1ActionPerformed(evt);
            }
        });
        getContentPane().add(BTNHab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 127, -1, -1));

        BTNHab2.setText("Habitacion2");
        BTNHab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHab2ActionPerformed(evt);
            }
        });
        getContentPane().add(BTNHab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 174, -1, -1));

        BTNHab3.setText("Habitacion3");
        BTNHab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHab3ActionPerformed(evt);
            }
        });
        getContentPane().add(BTNHab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 221, -1, -1));

        BTNHab4.setText("Habitacion4");
        BTNHab4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHab4ActionPerformed(evt);
            }
        });
        getContentPane().add(BTNHab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 268, -1, -1));

        LBHab0.setText("-");
        getContentPane().add(LBHab0, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 85, -1, -1));

        LBHab1.setText("-");
        getContentPane().add(LBHab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 132, -1, -1));

        LBHab2.setText("-");
        getContentPane().add(LBHab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 179, -1, -1));

        LBHab3.setText("-");
        getContentPane().add(LBHab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 226, -1, -1));

        LBHab4.setText("-");
        getContentPane().add(LBHab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 273, -1, -1));

        jLabel1.setText("Seleccione la habitacion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        BTNVolver.setText("Volver");
        BTNVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVolverActionPerformed(evt);
            }
        });
        getContentPane().add(BTNVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/habitaciones_bg.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNHab4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHab4ActionPerformed
        // TODO add your handling code here:
        new PedirProducto(5).setVisible(true);
        dispose();
        
    }//GEN-LAST:event_BTNHab4ActionPerformed

    private void BTNHab0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHab0ActionPerformed
        // TODO add your handling code here:
        new PedirProducto(1).setVisible(true);
        dispose();
    }//GEN-LAST:event_BTNHab0ActionPerformed

    private void BTNHab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHab1ActionPerformed
        // TODO add your handling code here:
        new PedirProducto(2).setVisible(true);
        dispose();
    }//GEN-LAST:event_BTNHab1ActionPerformed

    private void BTNHab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHab2ActionPerformed
        // TODO add your handling code here:
        new PedirProducto(3).setVisible(true);
        dispose();
    }//GEN-LAST:event_BTNHab2ActionPerformed

    private void BTNHab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHab3ActionPerformed
        // TODO add your handling code here:
        new PedirProducto(4).setVisible(true);
        dispose();
    }//GEN-LAST:event_BTNHab3ActionPerformed

    private void BTNVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNVolverActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNVolverActionPerformed

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
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Habitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Habitaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNHab0;
    private javax.swing.JButton BTNHab1;
    private javax.swing.JButton BTNHab2;
    private javax.swing.JButton BTNHab3;
    private javax.swing.JButton BTNHab4;
    private javax.swing.JButton BTNVolver;
    private javax.swing.JLabel LBHab0;
    private javax.swing.JLabel LBHab1;
    private javax.swing.JLabel LBHab2;
    private javax.swing.JLabel LBHab3;
    private javax.swing.JLabel LBHab4;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
