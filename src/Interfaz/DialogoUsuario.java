/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDeDatos.SQLConnection;
import Objetos.NivelesCliente;
import Utilidades.BCrypt;
import java.awt.Frame;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class DialogoUsuario extends javax.swing.JDialog {

    public static final int NUEVO = 1;
    public static final int MODIFICAR = 2;
    
    private int uso = 0;
    private int idUsuarioActual = 0;
    
    private boolean usuarioValido = false;
    private boolean contraseniaValida = false;
    
    private DefaultComboBoxModel<NivelesCliente> modeloNiveles = new DefaultComboBoxModel();
    
    /**
     * Creates new form DialogoUsuario
     */
    private DialogoUsuario(java.awt.Frame parent, boolean modal, int uso, int idUsuarioActual) {
        super(parent, modal);
        initComponents();
        
        this.uso = uso;
        this.idUsuarioActual = idUsuarioActual;
        
        cargarNiveles();
        
        cboNivel.setModel(modeloNiveles);
        
        setLocationRelativeTo(null);
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
        txtUsuario = new Utilidades.JTextfieldPlaceHolder();
        txtContrasenia = new Utilidades.JPasswordFieldPlaceHolder();
        txtConfirmarContrasenia = new Utilidades.JPasswordFieldPlaceHolder();
        cboNivel = new javax.swing.JComboBox();
        chkActivo = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblCheck = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Usuario");

        txtUsuario.setPlaceholder("Usuario");
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });

        txtContrasenia.setPlaceholder("Contraseña");

        txtConfirmarContrasenia.setPlaceholder("Confirme contraseña");
        txtConfirmarContrasenia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmarContraseniaFocusLost(evt);
            }
        });

        chkActivo.setText("Activo");

        jButton1.setText("Cancelar");

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblCheck.setPreferredSize(new java.awt.Dimension(20, 20));

        lblContrasenia.setForeground(new java.awt.Color(255, 0, 0));
        lblContrasenia.setPreferredSize(new java.awt.Dimension(200, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkActivo)
                                .addGap(51, 51, 51)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(cboNivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtConfirmarContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkActivo)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(uso == NUEVO){
            if(!usuarioValido || !contraseniaValida)
                return;
            String sql = "INSERT INTO USUARIOS("
                    + "NOMBRE, "
                    + "CONTRASENIA, "
                    + "ID_NIVEL, "
                    + "ACTIVO) "
                    + "VALUES("
                    + "'" + txtUsuario.getText() + "',"
                    + "'" + BCrypt.hashpw(txtContrasenia.getText(), BCrypt.gensalt()) + "',"
                    + ((NivelesCliente)cboNivel.getSelectedItem()).id + ","
                    + chkActivo.isSelected() + ")";
            
            if(SQLConnection.update(sql)){
                JOptionPane.showMessageDialog(this, "Usuario creado correctamente");
                setVisible(false);                
            }else{
                JOptionPane.showMessageDialog(this, "No fue posible crear el usuario");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        try {
            if(txtUsuario.getText().trim().isEmpty())
                return;
            String sql = "SELECT NOMBRE FROM USUARIOS WHERE NOMBRE='" + txtUsuario.getText().trim() + "'";
            
            ResultSet consulta = SQLConnection.select(sql);
            
            usuarioValido = !consulta.next();
            
            if(usuarioValido){
                lblCheck.setIcon(new ImageIcon(new ImageIcon(
                        DialogoUsuario.class.getResource("/res/iconos/check.png")).
                        getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));                
            }else{
                lblCheck.setIcon(new ImageIcon(new ImageIcon(
                        DialogoUsuario.class.getResource("/res/iconos/cross.png")).
                        getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtConfirmarContraseniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmarContraseniaFocusLost
        contraseniaValida = txtContrasenia.getText().equals(
                txtConfirmarContrasenia.getText());
        
        if(!contraseniaValida)
            lblContrasenia.setText("Las contraseñas no coinciden");
        else
            lblContrasenia.setText("");
    }//GEN-LAST:event_txtConfirmarContraseniaFocusLost

    private void cargarNiveles(){
        try {
            String sqlNivel = "SELECT * FROM NIVEL_DE_USUARIO WHERE ID_USUARIO=" + idUsuarioActual;
            
            ResultSet consulta = SQLConnection.select(sqlNivel);
            
            if(consulta.next()){
                int nivel = consulta.getInt("ID_NIVEL");
                String sql = "SELECT * FROM NIVELES_USUARIO WHERE ID>=" + nivel;
                
                consulta = SQLConnection.select(sql);
                
                while(consulta.next()){
                    modeloNiveles.addElement(new NivelesCliente(
                            consulta.getInt("ID"), 
                            consulta.getString("NOMBRE")));                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void nuevo(Frame parent, int idUsuarioActual){
        DialogoUsuario dialogo = new DialogoUsuario(parent, true, NUEVO, idUsuarioActual);
        
        dialogo.setVisible(true);
        dialogo.dispose();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboNivel;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCheck;
    private javax.swing.JLabel lblContrasenia;
    private Utilidades.JPasswordFieldPlaceHolder txtConfirmarContrasenia;
    private Utilidades.JPasswordFieldPlaceHolder txtContrasenia;
    private Utilidades.JTextfieldPlaceHolder txtUsuario;
    // End of variables declaration//GEN-END:variables
}
