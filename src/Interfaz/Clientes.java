/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDeDatos.SQLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class Clientes extends javax.swing.JDialog {

    private static final int NUEVO = 1;
    private static final int VER = 2;
    
    private int idClienteActual = 0;
    private int uso;
    
    /**
     * Creates new form NuevoCliente
     */
    private Clientes(java.awt.Frame parent, boolean modal, int uso) {
        super(parent, modal);
        initComponents();
        
        this.uso = uso;
        
        setLocationRelativeTo(null);
    }

    private Clientes(java.awt.Frame parent, boolean modal, int uso, int idCliente) {
        super(parent, modal);
        initComponents();
        
        this.uso = uso;
        this.idClienteActual = idCliente;
        
        setLocationRelativeTo(null);
        
        cargarCliente();
    }
    
    private void cargarCliente(){
        try {
            String sql = "SELECT * FROM CLIENTES WHERE ID=" + idClienteActual;
            
            ResultSet consulta = SQLConnection.select(sql);                
            if(consulta.next()){
                txtNombre.setText(consulta.getString("NOMBRE"));
                txtApellidoPaterno.setText(consulta.getString("APELLIDO_PATERNO"));
                txtApellidoMaterno.setText(consulta.getString("APELLIDO_MATERNO"));
                txtTelefono1.setText(consulta.getString("TELEFONO1"));
                txtTelefono2.setText(consulta.getString("TELEFONO2"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        txtNombre = new Utilidades.JTextfieldPlaceHolder();
        txtTelefono1 = new Utilidades.JTextfieldPlaceHolder();
        txtTelefono2 = new Utilidades.JTextfieldPlaceHolder();
        txtApellidoPaterno = new Utilidades.JTextfieldPlaceHolder();
        txtApellidoMaterno = new Utilidades.JTextfieldPlaceHolder();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Cliente");

        txtNombre.setPlaceholder("Nombre");

        txtTelefono1.setPlaceholder("Telefono 1");

        txtTelefono2.setPlaceholder("Telefono 2");

        txtApellidoPaterno.setPlaceholder("Apellido Paterno");

        txtApellidoMaterno.setPlaceholder("Apellido Materno");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtNombre.getText().trim().isEmpty() ||
                txtApellidoPaterno.getText().trim().isEmpty() ||
                txtTelefono1.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(
                    this, 
                    "Asegurese de llenar todos los campos");
            return;
        }          
        if(uso == NUEVO){
            String sql = "INSERT INTO CLIENTES("
                    + "NOMBRE, "
                    + "APELLIDO_PATERNO,"
                    + "APELLIDO_MATERNO,"
                    + "TELEFONO1,"
                    + "TELEFONO2)"
                    + "VALUES("
                    + "'" + txtNombre.getText().trim() + "',"
                    + "'" + txtApellidoPaterno.getText().trim() + "',"
                    + "'" + txtApellidoMaterno.getText().trim() + "',"
                    + "'" + txtTelefono1.getText().trim() + "',"
                    + "'" + txtTelefono2.getText().trim() + "')";
            
            if(SQLConnection.update(sql)){
                JOptionPane.showMessageDialog(
                        this,
                        "Cliente agregado correctamente");
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible agregar el cliente");
            }
        }else if(uso == VER){
            String sql = "UPDATE CLIENTES SET "
                    + "NOMBRE=" + "'" + txtNombre.getText().trim() + "',"
                    + "APELLIDO_PATERNO=" + "'" + txtApellidoPaterno.getText().trim() + "'," 
                    + "APELLIDO_MATERNO=" + "'" + txtApellidoMaterno.getText().trim() + "',"
                    + "TELEFONO1=" + "'" + txtTelefono1.getText().trim() + "',"
                    + "TELEFONO2=" + "'" + txtTelefono2.getText().trim() + "' "
                    + "WHERE ID=" + idClienteActual;
            
            if(SQLConnection.update(sql)){
                JOptionPane.showMessageDialog(
                        this,
                        "Cliente modificado correctamente");
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible modificar el cliente");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
        
    public static void nuevo(JFrame parent){
        Clientes dialogo = new Clientes(parent, true, NUEVO);
        
        dialogo.setVisible(true);
        dialogo.dispose();
    }
    
    public static void mostrar(JFrame parent, int idCliente){
        Clientes dialogo = new Clientes(parent, true, VER, idCliente);
        
        dialogo.setVisible(true);
        dialogo.dispose();
    }        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private Utilidades.JTextfieldPlaceHolder txtApellidoMaterno;
    private Utilidades.JTextfieldPlaceHolder txtApellidoPaterno;
    private Utilidades.JTextfieldPlaceHolder txtNombre;
    private Utilidades.JTextfieldPlaceHolder txtTelefono1;
    private Utilidades.JTextfieldPlaceHolder txtTelefono2;
    // End of variables declaration//GEN-END:variables
}