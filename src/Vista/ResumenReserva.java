/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.ControlDescuento;
import controlador.ControlLabel;
import controlador.JDBCHabitacionDAO;
import controlador.JDBCPaxDAO;
import modelo.Habitacion;
import modelo.Pax;
import modelo.Reserva;

/**
 *
 * @author proyetco
 */
public class ResumenReserva extends javax.swing.JFrame {
    Reserva res = Reserva.getRes();
    Pax pasajero = Pax.getPax();
    JDBCPaxDAO jdbcpax = new JDBCPaxDAO();
    JDBCHabitacionDAO jdbchab = new JDBCHabitacionDAO();
    Habitacion[] h;

    /**
     * Creates new form Cobro
     */
    public ResumenReserva() {
        initComponents();
        Pax.clearPax();
        h = jdbchab.selectAll();
        pasajero = jdbcpax.selectRead(res.getRut());
        LBPaxPpal.setText(pasajero.getNombre()+" "+pasajero.getApellidoPat());
        LBOcupantes.setText(res.getOcupantes().toString());
        LBHab.setText(jdbchab.selectNombreHab(res.getIdhabitacion()));
        ControlLabel.setLabelPrecioPorPersona(res, LBPreciopp);
        LBDesc.setText(ControlDescuento.getDescuento(res.getOcupantes()));        
        ControlLabel.setPrecioSubTotal(res, LBDescpp);
        ControlLabel.setPrecioTotal(res, LBTotal, ControlDescuento.getMultiplicadorDescuento(res.getOcupantes()));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BTNCobrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TFPago = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        LBVuelto = new javax.swing.JLabel();
        LBPaxPpal = new javax.swing.JLabel();
        LBOcupantes = new javax.swing.JLabel();
        LBHab = new javax.swing.JLabel();
        LBPreciopp = new javax.swing.JLabel();
        LBDesc = new javax.swing.JLabel();
        LBDescpp = new javax.swing.JLabel();
        LBTotal = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(314, 440));
        setMinimumSize(new java.awt.Dimension(314, 440));
        setPreferredSize(new java.awt.Dimension(314, 440));
        setResizable(false);
        setSize(new java.awt.Dimension(314, 440));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Resumen");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 64, 17);

        jLabel2.setText("Pasajero Principal:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 70, 88, 14);

        jLabel3.setText("Total de ocupantes:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 90, 96, 14);

        jLabel4.setText("Habitacion:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 110, 54, 14);

        jLabel5.setText("Precio por persona:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 130, 94, 14);

        jLabel6.setText("Descuento:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 220, 55, 14);

        jLabel7.setText("Descuento por persona:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 240, 116, 14);

        jLabel8.setText("Total:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 260, 28, 14);

        BTNCobrar.setText("Pagar");
        getContentPane().add(BTNCobrar);
        BTNCobrar.setBounds(180, 370, 61, 23);

        jLabel9.setText("Pago:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(130, 300, 28, 14);
        getContentPane().add(TFPago);
        TFPago.setBounds(180, 300, 96, 20);

        jLabel10.setText("Vuelto:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(120, 330, 34, 14);

        LBVuelto.setText("-");
        getContentPane().add(LBVuelto);
        LBVuelto.setBounds(180, 330, 80, 14);

        LBPaxPpal.setText("-");
        getContentPane().add(LBPaxPpal);
        LBPaxPpal.setBounds(180, 70, 90, 14);

        LBOcupantes.setText("-");
        getContentPane().add(LBOcupantes);
        LBOcupantes.setBounds(180, 90, 100, 14);

        LBHab.setText("-");
        getContentPane().add(LBHab);
        LBHab.setBounds(180, 110, 100, 14);

        LBPreciopp.setText("-");
        getContentPane().add(LBPreciopp);
        LBPreciopp.setBounds(180, 130, 100, 14);

        LBDesc.setText("-");
        getContentPane().add(LBDesc);
        LBDesc.setBounds(180, 220, 80, 14);

        LBDescpp.setText("-");
        getContentPane().add(LBDescpp);
        LBDescpp.setBounds(180, 240, 90, 14);

        LBTotal.setText("-");
        getContentPane().add(LBTotal);
        LBTotal.setBounds(180, 260, 90, 14);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/resumen_reserva_bg.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 314, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ResumenReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResumenReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResumenReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResumenReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResumenReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNCobrar;
    private javax.swing.JLabel LBDesc;
    private javax.swing.JLabel LBDescpp;
    private javax.swing.JLabel LBHab;
    private javax.swing.JLabel LBOcupantes;
    private javax.swing.JLabel LBPaxPpal;
    private javax.swing.JLabel LBPreciopp;
    private javax.swing.JLabel LBTotal;
    private javax.swing.JLabel LBVuelto;
    private javax.swing.JTextField TFPago;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
