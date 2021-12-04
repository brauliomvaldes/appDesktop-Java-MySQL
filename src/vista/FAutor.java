/**
 * fecha de creacion: junio de 2018
 * nombre: FAutor
 * Su función mantenedor autores
 * entrada nombre autor
 * salida null
 * @author: braulio valdes 
 */
package vista;

import controlador.ControladorAutores;
import controlador.ControladorLibros;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Autores;
import modelo.Libros;

/**
 *
 * @author BRAULIOMARIANO
 */
public class FAutor extends javax.swing.JFrame {

    /**
     * Creates new form FCategoria
     */
    
    DefaultComboBoxModel comboAutor; 
    
    
    public FAutor() {
        initComponents();
        //this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        poblarAutor();
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
        btnAgrega = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        cmbAutor = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("MANTENEDOR AUTORES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 11, -1, -1));

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        btnAgrega.setText("Agrega");
        btnAgrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 332, -1));

        btnBorrar.setText("Cambia Estado");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        btnModificar.setText("Renombra");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        cmbAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAutorActionPerformed(evt);
            }
        });
        getContentPane().add(cmbAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 332, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("*");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 20, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaActionPerformed
        // TODO add your handling code here:
        // aqui agrega autores
        if (txtNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresa autor", "Error de Ingreso", 1);
        }else{
            String nombre = txtNombre.getText().trim();      
            ControladorAutores c = new ControladorAutores();
            Autores autores = c.leer(nombre); //recupera objeto autor si lo encuentra
            if (autores != null) {
                JOptionPane.showMessageDialog(null, "Autor existente", "Error de Ingreso", 1);
            }else{
                if(c.agregar(nombre)){
                    JOptionPane.showMessageDialog(null, "Autor creado exitosamente", "Ingreso Válido",1);
                    poblarAutor();
                }else{
                    JOptionPane.showMessageDialog(null, "Autor no fue creado", "Ingreso No Válido",1);
                }
            }
            txtNombre.setText("");
        }
    }//GEN-LAST:event_btnAgregaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
                // aqui borrado de autores
        if (txtNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresa autor", "Error de Ingreso", 1);
        }else{
            String nombre = txtNombre.getText();      
            ControladorAutores c = new ControladorAutores();
            //busca el autor
            Autores autores = c.leer(nombre); //recupera objeto autor si lo encuentra
            if (autores != null) {
                //busca el autor si esta utilizado en algún libro
                ControladorLibros lib = new ControladorLibros();
          
                Libros libros = lib.leerAutorEnLibro(autores.getId_autor()); 
                //recupera objeto libro si encuentra el autor
                if(libros!=null){
                    JOptionPane.showMessageDialog(null, "No es posible cambiar estado, esta vinculado a un libro", "no procesado",1);
                }else{
                    if(c.cambiaEstado(autores.getId_autor(),!(autores.isEstado()))){
                        if(autores.isEstado()){
                            JOptionPane.showMessageDialog(null, "Se cambio estado a "+"borrado", "Procesado",1);
                        }else{
                            JOptionPane.showMessageDialog(null, "Se cambio estado a "+"vigente", "Procesado",1);
                        }
                        poblarAutor();
                       }
                    }
            }else{
                JOptionPane.showMessageDialog(null, "Autor No existe", "Error de proceso", 1);
            }
            txtNombre.setText("");
        }

                
                
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void poblarAutor(){
        ControladorAutores c = new ControladorAutores();
        ArrayList<Autores> autores = c.consultarTodo();
        comboAutor = new DefaultComboBoxModel();
        String estado;
        for (Autores a : autores) {
          if(a.isEstado()){
             estado = "vigente"; 
          }else{
             estado = "borrado"; 
          }  
            comboAutor.addElement(a.getNombre()+"("+a.getId_autor()+")"+"["+estado+"]");
            cmbAutor.setModel(comboAutor);
        }
    }
    
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
     
       dispose();
       
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        
        if (txtNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresa autor", "Error de Ingreso", 1);
        }else{
            String nombre = txtNombre.getText();      
            ControladorAutores c = new ControladorAutores();
            Autores autores = c.leer(nombre); //recupera objeto autores si lo encuentra
            if (autores != null) {
                JOptionPane.showMessageDialog(null, "Moficación ya existe, no se registró cambio", "Error", 1);
            }else{
                // se modifica el autor
                String a = cmbAutor.getItemAt(cmbAutor.getSelectedIndex());
                int id_autor = Integer.parseInt(a.substring(a.indexOf("(") + 1, a.indexOf(")")));
                //crea un registro para hacer consulta
                Autores autor = new Autores(id_autor,nombre,true);
                if(c.modificar(autor)){
                        JOptionPane.showMessageDialog(null, "Autor modificado exitosamente", "Ingreso Válido",1);
                        poblarAutor();
                    }else{
                        JOptionPane.showMessageDialog(null, "Autor no fue modificado", "Modificación No Válida",1);
                    }
            }
        }        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cmbAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAutorActionPerformed
        // TODO add your handling code here:
        
        String a = cmbAutor.getItemAt(cmbAutor.getSelectedIndex());
        try{
            String autor = a.substring(0,a.indexOf("("));
            txtNombre.setText(autor);
        }catch(NullPointerException e){
            txtNombre.setText("");
        }
        
    
        
    }//GEN-LAST:event_cmbAutorActionPerformed

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
            java.util.logging.Logger.getLogger(FAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgrega;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}