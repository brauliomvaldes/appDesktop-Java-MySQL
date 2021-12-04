/**
 * fecha de creacion: junio de 2018
 * nombre: FambioDeFecha
 * Su función es cambiar la fecha para el sistema de ser necesario
 * entrada fecha
 * salida nueva fecha
 * @author: braulio valdes 
 */
package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import static vista.MenuPrincipalBiblioteca.diaSistema;
import static vista.MenuPrincipalBiblioteca.esNumero;
import static vista.MenuPrincipalBiblioteca.lbFechaSistema;
import static vista.MenuPrincipalBiblioteca.mesSistema;
import static vista.MenuPrincipalBiblioteca.yearSistema;

/**
 *
 * @author BRAULIOMARIANO
 */
public class FCambioDeFecha extends javax.swing.JFrame {

    /**
     * Creates new form FCategoria
     */
    
    int topeDiaMes;
    
    public FCambioDeFecha() {
        initComponents();
        poblarCalendario();
        //this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        poblarCalendario();
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
        btnCerrar = new javax.swing.JButton();
        cmbMesAplicacion = new javax.swing.JComboBox<>();
        cmbYearAplicacion = new javax.swing.JComboBox<>();
        cmbDiaAplicacion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("<   F E C H A     P R OC E S O   >");

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        cmbMesAplicacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbMesAplicacion.setForeground(new java.awt.Color(0, 0, 255));
        cmbMesAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesAplicacionActionPerformed(evt);
            }
        });

        cmbYearAplicacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbYearAplicacion.setForeground(new java.awt.Color(0, 0, 255));
        cmbYearAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearAplicacionActionPerformed(evt);
            }
        });

        cmbDiaAplicacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbDiaAplicacion.setForeground(new java.awt.Color(0, 0, 255));
        cmbDiaAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiaAplicacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbDiaAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMesAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbYearAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDiaAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbYearAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void poblarCalendario(){
        try{
           
            for(int d=1;d<32;d++){
                cmbDiaAplicacion.addItem(String.valueOf(d));
            }
           
            for(int m=1;m<13;m++){
                cmbMesAplicacion.addItem(String.valueOf(m));
            }
            for(int a=yearSistema;a>2000;a--){
                cmbYearAplicacion.addItem(String.valueOf(a));
            }
            cmbDiaAplicacion.setSelectedIndex(diaSistema-1);
            cmbMesAplicacion.setSelectedIndex(mesSistema-1);
            cmbYearAplicacion.setSelectedIndex(0);
                    
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "fecha:"+diaSistema+"/"+mesSistema+"/"+yearSistema, "",0);
        }
          
    }

    private boolean validaFecha(){
        
        topeDiaMes=0;
               
        if(mesSistema==1 || mesSistema==3 || mesSistema==5 || mesSistema==7 || mesSistema ==8 || mesSistema==10 || mesSistema==12){
            topeDiaMes = 31;
        }
        if(mesSistema==4 || mesSistema==6 || mesSistema==9 || mesSistema ==11){
            topeDiaMes = 30;
        }
        if(mesSistema==2){
            topeDiaMes = 28;
        }
        if((yearSistema%4==0) & mesSistema==2){
            topeDiaMes = 29;    
        }
        if (this.isActive()){
            if(diaSistema>topeDiaMes || mesSistema == 0 || diaSistema == 0 || yearSistema == 0){
                JOptionPane.showMessageDialog(null, "Atención! fecha del sistema erronea", "",1);
                return false;
            }
        }else{
            return false;
        }
        return true;
        
    }

    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

    
    
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cmbMesAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesAplicacionActionPerformed
        // TODO add your handling code here:
        if(mesSistema != Integer.parseInt(cmbMesAplicacion.getItemAt(cmbMesAplicacion.getSelectedIndex()))){
            int mes = mesSistema;
            String m = cmbMesAplicacion.getItemAt(cmbMesAplicacion.getSelectedIndex());
            if(esNumero(m)){
                mesSistema = Integer.parseInt(m);
                if(validaFecha()){
                    m = String.valueOf(diaSistema)+"/"+String.valueOf(mesSistema)+"/"+String.valueOf(yearSistema);
                    lbFechaSistema.setText(m);
                }else{
                    mesSistema= mes;
                }
            }
        }
    }//GEN-LAST:event_cmbMesAplicacionActionPerformed

    private void cmbYearAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearAplicacionActionPerformed
        // TODO add your handling code here:
        if(yearSistema != Integer.parseInt(cmbYearAplicacion.getItemAt(cmbYearAplicacion.getSelectedIndex()))){
            int year = yearSistema;
            String y = cmbYearAplicacion.getItemAt(cmbYearAplicacion.getSelectedIndex());
            if(esNumero(y)){
                yearSistema = Integer.parseInt(y);
                if(validaFecha()){
                    y = String.valueOf(diaSistema)+"/"+String.valueOf(mesSistema)+"/"+String.valueOf(yearSistema);
                    lbFechaSistema.setText(y);
                }else{
                    yearSistema= year;
                }
            }
        }
    }//GEN-LAST:event_cmbYearAplicacionActionPerformed

    private void cmbDiaAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiaAplicacionActionPerformed
        // TODO add your handling code here:
        if(diaSistema != Integer.parseInt(cmbDiaAplicacion.getItemAt(cmbDiaAplicacion.getSelectedIndex()))){
            int dia = diaSistema;
            String d = cmbDiaAplicacion.getItemAt(cmbDiaAplicacion.getSelectedIndex());
            if(esNumero(d)){
                diaSistema = Integer.parseInt(d);
                if(validaFecha()){
                    d = String.valueOf(diaSistema)+"/"+String.valueOf(mesSistema)+"/"+String.valueOf(yearSistema);
                    lbFechaSistema.setText(d);
                }else{
                    diaSistema= dia;
                }
            }
        }
    }//GEN-LAST:event_cmbDiaAplicacionActionPerformed

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
            java.util.logging.Logger.getLogger(FCambioDeFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCambioDeFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCambioDeFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCambioDeFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCambioDeFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cmbDiaAplicacion;
    private javax.swing.JComboBox<String> cmbMesAplicacion;
    private javax.swing.JComboBox<String> cmbYearAplicacion;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}