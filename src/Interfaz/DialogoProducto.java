/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDeDatos.SQLConnection;
import Objetos.Categoria;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Raul
 */
public class DialogoProducto extends javax.swing.JDialog {

    public static final int NUEVO = 0;
    public static final int MODIFICAR = 1;
    
    private String claveActual = "";
    private int uso = 0;
    
    private DefaultComboBoxModel<Categoria> modeloCategorias = new DefaultComboBoxModel<Categoria>();
    
    /**
     * Creates new form NuevoProducto
     */
    private DialogoProducto(java.awt.Frame parent, boolean modal, int uso) {
        super(parent, modal);                
        initComponents();
        
        this.uso = uso;
        
        cboCategorias.setModel(modeloCategorias);
                
        cargarCategorias();        
        
        setLocationRelativeTo(null);
    }

    private void cargarCategorias(){
        try {
            String sql = "SELECT * FROM CATEGORIAS";
            
            ResultSet consulta = SQLConnection.select(sql);
            
            while(consulta.next()){
                modeloCategorias.addElement(
                        new Categoria(
                                consulta.getInt("ID"),
                                consulta.getString("NOMBRE")
                ));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarProducto(String clave){
        try {
            String sql = "SELECT * FROM DETALLES_PRODUCTOS WHERE CLAVE='" + clave + "'";
            
            ResultSet consulta = SQLConnection.select(sql);
            
            if(consulta.next()){
                claveActual = clave;
                
                txtClave.setText(clave);
                txtNombre.setText(consulta.getString("NOMBRE"));
                String categoria = consulta.getString("CATEGORIA");
                for(int i = 0 ; i < cboCategorias.getItemCount() ; i++){
                    if(modeloCategorias.getElementAt(i).toString().equalsIgnoreCase(categoria)){
                        cboCategorias.setSelectedIndex(i);
                        i = cboCategorias.getItemCount();
                    }
                }
                chkNuevo.setSelected(consulta.getBoolean("NUEVO"));
                txtPrecio.setText(consulta.getString("PRECIO"));
                txtImagen.setText(consulta.getString("IMAGEN"));
                txtDetalles.setText(consulta.getString("DETALLES"));
                
                cboCategorias.setEnabled(true);
                chkNuevo.setEnabled(true);
                txtPrecio.setEnabled(true);
                btnCargarImagen.setEnabled(true);
                txtDetalles.setEnabled(true);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogoProducto.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel5 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboCategorias = new javax.swing.JComboBox();
        chkNuevo = new javax.swing.JCheckBox();
        txtImagen = new javax.swing.JTextField();
        btnCargarImagen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalles = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Producto");

        jLabel5.setText("Clave");

        txtClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClaveMouseClicked(evt);
            }
        });
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });

        jLabel3.setText("Categoría");

        chkNuevo.setText("Nuevo");

        txtImagen.setEditable(false);

        btnCargarImagen.setText("Cargar imagen");
        btnCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImagenActionPerformed(evt);
            }
        });

        txtDetalles.setColumns(20);
        txtDetalles.setRows(5);
        jScrollPane1.setViewportView(txtDetalles);

        jLabel4.setText("Detalles");

        jButton2.setText("Guardar");
        jButton2.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");

        jLabel6.setText("Imagen");

        jLabel7.setText("Precio");

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtPrecio.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 418, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargarImagen))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(cboCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(56, 56, 56)
                                .addComponent(chkNuevo))
                            .addComponent(jLabel4))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(chkNuevo))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCargarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClaveMouseClicked

    }//GEN-LAST:event_txtClaveMouseClicked

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        cargarProducto(txtClave.getText());
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImagenActionPerformed
        JFileChooser selectorImagen = new JFileChooser();
        
        selectorImagen.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png"));
        
        if(selectorImagen.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File imagen = selectorImagen.getSelectedFile();
            
            txtImagen.setText(imagen.getAbsolutePath());
        }        
    }//GEN-LAST:event_btnCargarImagenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(txtNombre.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Nombre del producto inválido");
            return;
        }   
        
        if(txtClave.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Clave del producto inválido");
            return;
        } 
        
        String sql = "";
        if (uso == NUEVO) 
            sql = "INSERT INTO PRODUCTOS("
                    + "CLAVE,"
                    + "NOMBRE,"
                    + "NUEVO,"
                    + "ID_CATEGORIA,"
                    + "PRECIO,"
                    + "DETALLES,"
                    + "IMAGEN,"
                    + "TALLA) VALUES("
                    + "'" + txtClave.getText().trim() + "',"
                    + "'" + txtNombre.getText() + "',"
                    + chkNuevo.isSelected() + ","
                    + ((Categoria) cboCategorias.getSelectedItem()).id + ","
                    + txtPrecio.getText() + ","
                    + "'" + txtDetalles.getText() + "',"
                    + "'" + txtImagen.getText().replace("\\", "/") + "',"
                    + "'0');";
        else
            sql = "UPDATE PRODUCTOS SET "
                    + "CLAVE=" + "'" + txtClave.getText().trim() + "',"
                    + "NOMBRE=" + "'" + txtNombre.getText() + "',"
                    + "NUEVO=" + chkNuevo.isSelected() + ","
                    + "ID_CATEGORIA=" + ((Categoria) cboCategorias.getSelectedItem()).id + ","
                    + "PRECIO=" + txtPrecio.getText() + ","
                    + "DETALLES=" + "'" + txtDetalles.getText() + "',"
                    + "IMAGEN=" + "'" + txtImagen.getText().replace("\\", "/") + "' "
                    + "WHERE CLAVE='" + claveActual + "'";

        if(SQLConnection.update(sql)){
            claveActual = txtClave.getText().trim();
            JOptionPane.showMessageDialog(this, "Producto guardado correctamente");
            setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        if(uso != MODIFICAR || evt.getClickCount() != 2)
            return;
        
        String clave = BuscarProducto.mostrar(null);                
        
        cargarProducto(clave);
    }//GEN-LAST:event_txtNombreMouseClicked

    public static String nuevo(JFrame parent){
        DialogoProducto dialogo = new DialogoProducto(parent, true, NUEVO);
        
        dialogo.setVisible(true);
        dialogo.dispose();
        
        return dialogo.claveActual;
    }
    
    public static void modificar(JFrame parent){
        DialogoProducto dialogo = new DialogoProducto(parent, true, MODIFICAR);
        
        dialogo.txtDetalles.setEnabled(false);
        dialogo.btnCargarImagen.setEnabled(false);
        dialogo.txtPrecio.setEnabled(false);
        dialogo.cboCategorias.setEnabled(false);
        dialogo.chkNuevo.setEnabled(false);
        
        dialogo.setVisible(true);
    }        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarImagen;
    private javax.swing.JComboBox cboCategorias;
    private javax.swing.JCheckBox chkNuevo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextArea txtDetalles;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}

