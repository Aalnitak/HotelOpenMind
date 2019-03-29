/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.ControlComboBox;
import controlador.ControlFormulario;
import controlador.JDBCPaxDAO;
import controlador.Validacion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import modelo.ArrayRuts;
import modelo.FormularioRegistroPax;
import modelo.Pax;
import modelo.Reserva;

/**
 *
 * @author duoc
 */
public class Registro extends javax.swing.JFrame {
    
    int paxActual;
    JDBCPaxDAO jdbcpax = new JDBCPaxDAO();
    Pax pasajero = Pax.getPax();
    FormularioRegistroPax frp;
    Reserva res = Reserva.getRes();
    boolean paxNoExiste = true;
    ArrayList<Integer> ruts;

    /**
     * Creates new form Registro
     *
     * @param paxActual
     *
     */
    public Registro(int paxActual) {
        
        this.paxActual = paxActual;
        initComponents();
        LBPasajeroPrincipal.setVisible(false);
        BTNSorteo.setVisible(false);
        LBTotal.setText(String.valueOf(res.getOcupantes()));
        LBActual.setText(String.valueOf(this.paxActual));
        if (this.paxActual == 1) {
            LBPasajeroPrincipal.setVisible(true);
        }
        LBPremio.setVisible(false);
        Pax.clearPax();
        frp = FormularioRegistroPax.getForm(TFRut, TFDigitoVerificador, TFNombre, TFApellidoPat, TFApellidoMat, TFNac, CBFechaAño, CBFechaMes, CBFechaDia, CBSexo);
        ruts = ArrayRuts.getArray();
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
        LBActual = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LBTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TFRut = new javax.swing.JTextField();
        TFNombre = new javax.swing.JTextField();
        TFApellidoPat = new javax.swing.JTextField();
        TFApellidoMat = new javax.swing.JTextField();
        CBSexo = new javax.swing.JComboBox<>();
        CBFechaDia = new javax.swing.JComboBox<>();
        CBFechaMes = new javax.swing.JComboBox<>();
        CBFechaAño = new javax.swing.JComboBox<>();
        TFNac = new javax.swing.JTextField();
        BTNSorteo = new javax.swing.JButton();
        BTNIngresar = new javax.swing.JButton();
        BTNCancelar = new javax.swing.JButton();
        BTNVolver = new javax.swing.JButton();
        LBPasajeroPrincipal = new javax.swing.JLabel();
        BTNVerificar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TFDigitoVerificador = new javax.swing.JTextField();
        LBPremio = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(533, 420));
        setMinimumSize(new java.awt.Dimension(533, 420));
        setPreferredSize(new java.awt.Dimension(533, 420));
        setResizable(false);
        setSize(new java.awt.Dimension(533, 420));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Registro de pasajeros");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, -1));

        jLabel2.setText("Rut:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 80, -1));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 110, -1));

        jLabel4.setText("Apellido Paterno:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 170, -1));

        LBActual.setText("-");
        getContentPane().add(LBActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        jLabel6.setText("/");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        LBTotal.setText("-");
        getContentPane().add(LBTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        jLabel5.setText("Sexo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 90, -1));

        jLabel7.setText("Fecha Nacimiento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 170, -1));

        jLabel8.setText("Nacionalidad:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 140, -1));

        jLabel9.setText("Apellido Materno:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 170, -1));
        getContentPane().add(TFRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 140, -1));
        getContentPane().add(TFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 190, -1));
        getContentPane().add(TFApellidoPat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 190, -1));
        getContentPane().add(TFApellidoMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 190, -1));

        CBSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "M", "F" }));
        getContentPane().add(CBSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 50, -1));

        getContentPane().add(CBFechaDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 50, -1));

        CBFechaMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--seleccione--", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        CBFechaMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBFechaMesActionPerformed(evt);
            }
        });
        getContentPane().add(CBFechaMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 94, -1));

        CBFechaAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930" }));
        CBFechaAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBFechaAñoActionPerformed(evt);
            }
        });
        getContentPane().add(CBFechaAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 84, -1));
        getContentPane().add(TFNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 190, -1));

        BTNSorteo.setText("SORTEO!");
        BTNSorteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSorteoActionPerformed(evt);
            }
        });
        getContentPane().add(BTNSorteo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 110, 125));

        BTNIngresar.setText("Ingresar");
        BTNIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 356, -1, -1));

        BTNCancelar.setText("Cancelar");
        getContentPane().add(BTNCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 356, -1, -1));

        BTNVolver.setText("Anterior");
        getContentPane().add(BTNVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 356, -1, -1));

        LBPasajeroPrincipal.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        LBPasajeroPrincipal.setText("PASAJERO PRINCIPAL");
        getContentPane().add(LBPasajeroPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 160, -1));

        BTNVerificar.setText("Verificar pax");
        BTNVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVerificarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 140, 30));

        jLabel10.setText("-");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 20, 10));
        getContentPane().add(TFDigitoVerificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 40, -1));

        LBPremio.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        LBPremio.setText("Has sido premiado!, este pasajero no pagara incorporación");
        getContentPane().add(LBPremio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/registro_bg.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNIngresarActionPerformed
        // TODO add your handling code here:
        
        if (paxNoExiste) {
            ControlFormulario.llenarPasajeroCon(frp, pasajero);
        }
        if (paxActual == 1) {
            pasajero.setClientePpal(true);
            res.setRut(pasajero.getRut());
            
        }
        
        jdbcpax.insert(pasajero);
        ArrayRuts.setRut(pasajero.getRut());
        paxActual++;
        
        if (paxActual > res.getOcupantes()) {
            res.setFechaEntrada(LocalDateTime.now());
            if (res.getMomento()) {
                res.setFechaSalida(LocalDateTime.now().plusHours(3));
            } else {
                res.setFechaSalida(LocalDateTime.now().plusHours(12));
            }
            new ResumenReserva().setVisible(true);
            dispose();
        } else {
            new Registro(paxActual).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_BTNIngresarActionPerformed

    private void BTNVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNVerificarActionPerformed
        // TODO add your handling code here:

        Pax.clearPax();
        if (Validacion.validarInt(TFRut.getText())) {
            int rut = Integer.parseInt(TFRut.getText());
            if (jdbcpax.existe(rut)) {
                pasajero = jdbcpax.selectRead(rut);
                ControlFormulario.llenarFormularioRegistro(pasajero, frp);
                paxNoExiste = false;
                
            }
            
            if (jdbcpax.isClienteFrecuente(pasajero)) {
                pasajero.setClienteFrecuente(true);
                BTNSorteo.setVisible(true);
            }
            
        }
        

    }//GEN-LAST:event_BTNVerificarActionPerformed

    private void CBFechaAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBFechaAñoActionPerformed
        // TODO add your handling code here:

        int mesSeleccionado = CBFechaMes.getSelectedIndex();
        ControlComboBox.llenarCBFechaNacimientoRegistro(mesSeleccionado, Integer.valueOf(CBFechaAño.getSelectedItem().toString()), CBFechaDia);
        

    }//GEN-LAST:event_CBFechaAñoActionPerformed

    private void CBFechaMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBFechaMesActionPerformed
        // TODO add your handling code here:

        int mesSeleccionado = CBFechaMes.getSelectedIndex();
        ControlComboBox.llenarCBFechaNacimientoRegistro(mesSeleccionado, Integer.valueOf(CBFechaAño.getSelectedItem().toString()), CBFechaDia);

    }//GEN-LAST:event_CBFechaMesActionPerformed

    private void BTNSorteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSorteoActionPerformed
        // TODO add your handling code here:
        Random rd = new Random();
        boolean premiado = rd.nextBoolean();
        LBPremio.setVisible(true);
        if (premiado) {
            LBPremio.setText("HAS SIDO PREMIADO!, esta vez es gratis para ti");
        } else {
            LBPremio.setText("esta vez no has ganado, mejor suerte para la proxima");
        }
        pasajero.setCantidadVecesPremiado(pasajero.getCantidadVecesPremiado()+1);
        res.setPrincipalPremiado(premiado);
        BTNSorteo.setEnabled(false);
        

    }//GEN-LAST:event_BTNSorteoActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        new Registro().setVisible(true);
        }
        });s*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNCancelar;
    private javax.swing.JButton BTNIngresar;
    private javax.swing.JButton BTNSorteo;
    private javax.swing.JButton BTNVerificar;
    private javax.swing.JButton BTNVolver;
    private javax.swing.JComboBox<String> CBFechaAño;
    private javax.swing.JComboBox<String> CBFechaDia;
    private javax.swing.JComboBox<String> CBFechaMes;
    private javax.swing.JComboBox<String> CBSexo;
    private javax.swing.JLabel LBActual;
    private javax.swing.JLabel LBPasajeroPrincipal;
    private javax.swing.JLabel LBPremio;
    private javax.swing.JLabel LBTotal;
    private javax.swing.JTextField TFApellidoMat;
    private javax.swing.JTextField TFApellidoPat;
    private javax.swing.JTextField TFDigitoVerificador;
    private javax.swing.JTextField TFNac;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFRut;
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
