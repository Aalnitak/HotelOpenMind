/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.ControlComboBox;
import controlador.ControlLabel;
import controlador.JDBCHabitacionDAO;
import controlador.JDBCProductoDAO;
import controlador.Validacion;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Reserva;

/**
 *
 * @author duoc
 */
public class Ingreso extends javax.swing.JFrame {

    /**
     * Creates new form Ingreso
     */
    static Reserva res = Reserva.getRes();
    
    static JDBCHabitacionDAO jdbcHab;

    public Ingreso() {
        initComponents();
        ControlComboBox.llenarCBHabitacion(CBHabDispo);
        jdbcHab = new JDBCHabitacionDAO();
        
        Reserva.clearRes();
        //BGModo.setSelected(RBJornada.getModel(), true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGModo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RBMomento = new javax.swing.JRadioButton();
        RBJornada = new javax.swing.JRadioButton();
        TFCantPax = new javax.swing.JTextField();
        CBHabDispo = new javax.swing.JComboBox<>();
        BTNAceptar = new javax.swing.JButton();
        BTNVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        LBPreciopp = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LBTotal = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(431, 348));
        getContentPane().setLayout(null);

        jLabel1.setText("Ingreso");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 120, 16);

        jLabel2.setText("Numero de personas");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 60, 170, 16);

        jLabel3.setText("Habitacion");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 100, 110, 16);

        BGModo.add(RBMomento);
        RBMomento.setText("Momento (3 hrs)");
        RBMomento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBMomentoActionPerformed(evt);
            }
        });
        getContentPane().add(RBMomento);
        RBMomento.setBounds(50, 160, 160, 23);

        BGModo.add(RBJornada);
        RBJornada.setText("Jornada (12 hrs)");
        RBJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBJornadaActionPerformed(evt);
            }
        });
        getContentPane().add(RBJornada);
        RBJornada.setBounds(210, 160, 170, 23);
        getContentPane().add(TFCantPax);
        TFCantPax.setBounds(310, 60, 30, 26);

        getContentPane().add(CBHabDispo);
        CBHabDispo.setBounds(220, 90, 120, 27);

        BTNAceptar.setText("Aceptar");
        BTNAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNAceptar);
        BTNAceptar.setBounds(290, 280, 92, 29);

        BTNVolver.setText("Volver");
        BTNVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVolverActionPerformed(evt);
            }
        });
        getContentPane().add(BTNVolver);
        BTNVolver.setBounds(50, 280, 83, 29);

        jLabel4.setText("Precio Por Persona:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 210, 130, 16);

        LBPreciopp.setText("-");
        getContentPane().add(LBPreciopp);
        LBPreciopp.setBounds(310, 210, 70, 16);

        jLabel5.setText("Total");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(260, 230, 50, 16);

        LBTotal.setText("-");
        getContentPane().add(LBTotal);
        LBTotal.setBounds(310, 230, 70, 16);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ingreso_bg.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 431, 348);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BTNAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAceptarActionPerformed
        // TODO add your handling code here:
        boolean pase;
        

        if (Validacion.validarInt(TFCantPax.getText())
                & CBHabDispo.getSelectedIndex() != 0
                & (RBJornada.isSelected()|RBMomento.isSelected())) {

            res.setOcupantes(Integer.parseInt(TFCantPax.getText()));
            res.setIdhabitacion(jdbcHab.getMap().get(CBHabDispo.getSelectedItem().toString()));
            if (RBJornada.isSelected()) {
                res.setMomento(false);
            }
            if (RBMomento.isSelected()) {
                res.setMomento(true);
            }

            //pendiente, seguramente now + 15min
            
            pase = true;

        } else {
            pase = false;
        }
        
        if (pase){
            
            new Registro(1).setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Datos incorrectos");
        }

        //
    }//GEN-LAST:event_BTNAceptarActionPerformed

    private void BTNVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNVolverActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BTNVolverActionPerformed

    private void RBMomentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBMomentoActionPerformed
        // TODO add your handling code here:
        //llamar a controlLabel 
        String nombreProd = CBHabDispo.getSelectedItem().toString().concat("_momento");
        ControlLabel.setLabelPrecioIngreso(nombreProd, TFCantPax, LBTotal, LBPreciopp);


    }//GEN-LAST:event_RBMomentoActionPerformed

    private void RBJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBJornadaActionPerformed
        // TODO add your handling code here:
        String nombreProd = CBHabDispo.getSelectedItem().toString().concat("_jornada");
        ControlLabel.setLabelPrecioIngreso(nombreProd, TFCantPax, LBTotal, LBPreciopp);
    }//GEN-LAST:event_RBJornadaActionPerformed

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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGModo;
    private javax.swing.JButton BTNAceptar;
    private javax.swing.JButton BTNVolver;
    private javax.swing.JComboBox<String> CBHabDispo;
    private javax.swing.JLabel LBPreciopp;
    private javax.swing.JLabel LBTotal;
    private javax.swing.JRadioButton RBJornada;
    private javax.swing.JRadioButton RBMomento;
    private javax.swing.JTextField TFCantPax;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
