/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDeDatos.SQLConnection;
import Utilidades.Fecha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raul
 */
public class EntradaMercancia extends javax.swing.JDialog {

    private static final int VER = 1;
    private static final int NUEVO = 2;    
    private int uso;    
    
    private int idUsuarioActual = 0;
    private String claveProductoActual = "";
    private int folioCompra = 0;
    private int folioEgreso = 0;
    
    private DefaultTableModel modelProductos = new DefaultTableModel(
            new Object[]{"Clave", "Producto", "Cantidad", "Costo Unitario", "Costo Total"},
            0){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };   
        
    /**
     * Creates new form EntradaMercancía
     */
    private EntradaMercancia(
            java.awt.Frame parent, 
            boolean modal, 
            int idUsuarioActual, 
            int uso) {
        super(parent, modal);
        initComponents();
        
        this.idUsuarioActual = idUsuarioActual;                
        
        tableProductos.setModel(modelProductos);
        txtFecha.setText(Fecha.now());
        
        tableProductos.getColumnModel().getColumn(0).setMaxWidth(100);
        tableProductos.getColumnModel().getColumn(0).setMinWidth(100);
        tableProductos.getColumnModel().getColumn(2).setMaxWidth(100);
        tableProductos.getColumnModel().getColumn(4).setMaxWidth(100);
        
        cargar();
    }

    private EntradaMercancia(
            java.awt.Frame parent, 
            boolean modal, 
            int idUsuarioActual, 
            int uso,
            int folioCompra) {
        super(parent, modal);
        initComponents();
        
        this.uso = uso;
        this.idUsuarioActual = idUsuarioActual;  
        this.folioCompra = folioCompra;
        
        tableProductos.setModel(modelProductos);
        txtFecha.setText(Fecha.now());
        
        tableProductos.getColumnModel().getColumn(0).setMaxWidth(100);
        tableProductos.getColumnModel().getColumn(0).setMinWidth(100);
        tableProductos.getColumnModel().getColumn(2).setMaxWidth(100);
        tableProductos.getColumnModel().getColumn(4).setMaxWidth(100);
        
        cargar();
    }
    
    private void cargarProducto(String clave){
        try {
            String sql = "SELECT NOMBRE FROM PRODUCTOS WHERE CLAVE='" + clave + "'";
            
            ResultSet consulta = SQLConnection.select(sql);
            if (consulta.next()) {
                txtProducto.setText(consulta.getString("NOMBRE"));
                txtCantidad.setText("0");
                txtCostoUnitario.setText("0.00");
                txtCostoTotal.setText("0.00");
                txtClave.setText(clave);
                claveProductoActual = clave;
                btnAniadir.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntradaMercancia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargar(){
        try {
            String selectCompra = "SELECT * FROM REPORTE_COMPRAS WHERE FOLIO=" + this.folioCompra;
            
            ResultSet consulta = SQLConnection.select(selectCompra);                        
            
            if(!consulta.next())
                return;                        
            
            txtFolio.setText(consulta.getString("FOLIO"));
            txtFecha.setText(consulta.getString("FECHA"));
            txtTotal.setText(consulta.getString("TOTAL"));
            chkCancelado.setEnabled(consulta.getBoolean("CANCELADO"));
                        
            folioEgreso = consulta.getInt("FOLIO_EGRESO");
            
            String selectProductos = "SELECT * FROM COMPRA_DETALLE WHERE FOLIO_COMPRA=" + this.folioCompra;
            
            consulta = SQLConnection.select(selectProductos);
            
            while(consulta.next()){
                modelProductos.addRow(new Object[]{
                    consulta.getString("CLAVE"),
                    consulta.getString("NOMBRE"),
                    consulta.getString("CANTIDAD"),
                    consulta.getString("PRECIO_UNITARIO"),
                    consulta.getString("PRECIO_TOTAL")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntradaMercancia.class.getName()).log(Level.SEVERE, null, ex);
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

        btnGuardar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtCantidad = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCostoUnitario = new javax.swing.JFormattedTextField();
        txtCostoTotal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtTotal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        chkCancelado = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        txtClave = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnAniadir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnEgreso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");

        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtCantidad.setText("0");

        jLabel8.setText("Costo Unitario");

        txtCostoUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCostoUnitario.setText("0");
        txtCostoUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCostoUnitarioFocusLost(evt);
            }
        });

        txtCostoTotal.setEditable(false);
        txtCostoTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtCostoTotal.setText("0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Entrada De Mercancía");

        jLabel9.setText("Costo Total");

        jLabel2.setText("Folio");

        jLabel10.setText("Total");

        txtFolio.setEditable(false);

        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");

        jLabel3.setText("Fecha");

        txtFecha.setEditable(false);

        chkCancelado.setText("Cancelado");
        chkCancelado.setEnabled(false);

        jLabel4.setText("Producto");

        txtProducto.setEditable(false);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

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

        jLabel5.setText("Clave de producto");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel6.setText("Cantidad");

        btnAniadir.setText("Añadir");
        btnAniadir.setEnabled(false);
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProductos);

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Doble clic para eliminar");

        btnEgreso.setText("Mostrar Egreso");
        btnEgreso.setEnabled(false);
        btnEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(txtCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(10, 10, 10)
                                .addComponent(txtCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtProducto)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chkCancelado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 544, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(142, 142, 142)
                        .addComponent(btnEgreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(455, 455, 455)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFecha))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnNuevo)
                            .addGap(329, 329, 329))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAniadir)
                    .addComponent(jLabel6)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkCancelado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jButton5)
                    .addComponent(btnEliminar)
                    .addComponent(btnEgreso))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        SQLConnection.startTransaction();

        int folioEgreso = Egreso.nuevoCompra(
            null,
            idUsuarioActual,
            Float.parseFloat(txtTotal.getText()));

        if(folioEgreso == 0){
            JOptionPane.showMessageDialog(
                this,
                "No se pudo guardar",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            SQLConnection.rollback();
            return;
        }

        String insertCompra = "INSERT INTO COMPRAS(FOLIO_EGRESO) VALUES(" + folioEgreso + ")";

        if(SQLConnection.update(insertCompra)){

            for(int i = 0 ; i < modelProductos.getRowCount() ; i++){
                String insertProducto =
                "INSERT INTO COMPRAS_PRODUCTOS("
                + "FOLIO_COMPRA,"
                + "CLAVE_PRODUCTO,"
                + "CANTIDAD,"
                + "PRECIO_UNITARIO) VALUES("
                + "(SELECT MAX(FOLIO) FROM COMPRAS),"
                + "'" + modelProductos.getValueAt(i, 0) + "',"
                + modelProductos.getValueAt(i, 2) + ","
                + modelProductos.getValueAt(i, 3) + ");";

                String updateExistencia = "UPDATE PRODUCTOS "
                + "SET EXISTENCIA=EXISTENCIA+"  + modelProductos.getValueAt(i, 2) + " "
                + "WHERE CLAVE='" + modelProductos.getValueAt(i, 0) + "'";

                if(!SQLConnection.update(insertProducto) || !SQLConnection.update(updateExistencia)){
                    SQLConnection.rollback();                    
                    return;
                }
            }
        }else{
            SQLConnection.rollback();
            return;
        }

        SQLConnection.commit();
        JOptionPane.showMessageDialog(this, "Compra registrada correctamente");
        setVisible(false);
        dispose();
        return;
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCostoUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCostoUnitarioFocusLost
        int cantidad = Integer.parseInt(
            txtCantidad.getText().isEmpty() ?
            "0" : txtCantidad.getText());
        float costoUnitario = Float.parseFloat(
            (txtCostoUnitario.getText().isEmpty() ?
                "0" : txtCostoUnitario.getText()));

        txtCostoTotal.setText(cantidad * costoUnitario + "");
    }//GEN-LAST:event_txtCostoUnitarioFocusLost

    private void txtClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClaveMouseClicked
        if(evt.getClickCount() != 2 || uso == VER)
        return;

        cargarProducto(BuscarProducto.mostrar(null));
    }//GEN-LAST:event_txtClaveMouseClicked

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        cargarProducto(txtClave.getText());
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtClave.setText(DialogoProducto.nuevo(null));
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed
        int cantidad = Integer.parseInt(
            txtCantidad.getText().isEmpty() ?
            "0" : txtCantidad.getText());
        float costoUnitario = Float.parseFloat(
            (txtCostoUnitario.getText().isEmpty() ?
                "0" : txtCostoUnitario.getText()));

        modelProductos.addRow(new Object[]{
            claveProductoActual,
            txtProducto.getText(),
            cantidad,
            costoUnitario,
            costoUnitario * cantidad
        });

        float totalTemp = Float.parseFloat(txtTotal.getText());
        txtTotal.setText(totalTemp + costoUnitario * cantidad + "");

        btnAniadir.setEnabled(false);
        txtClave.setText("");
        txtProducto.setText("");
        txtCantidad.setText("0");
        txtCostoUnitario.setText("0.00");
        txtCostoTotal.setText("0.00");
    }//GEN-LAST:event_btnAniadirActionPerformed

    private void tableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseClicked
        if(evt.getClickCount() != 2 || uso == VER)
            return;
        
        int fila = tableProductos.rowAtPoint(evt.getPoint());

        float totalTemp = Float.parseFloat(txtTotal.getText());
        int cantidad = (Integer) tableProductos.getValueAt(fila, 2);
        float costoUnitario = (Float) tableProductos.getValueAt(fila, 3);
        txtTotal.setText(totalTemp - costoUnitario * cantidad + "");

        modelProductos.removeRow(fila);
    }//GEN-LAST:event_tableProductosMouseClicked

    private void btnEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEgresoActionPerformed
        Egreso.mostrar(null, idUsuarioActual, folioEgreso);
    }//GEN-LAST:event_btnEgresoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void eliminar(){
        String deleteCompra = "UPDATE COMPRAS SET CANCELADO=TRUE WHERE FOLIO=" + folioCompra;                
        
        SQLConnection.startTransaction();
        
        if(!SQLConnection.update(deleteCompra) || !actualizarExistencias()){
            SQLConnection.rollback();
            JOptionPane.showMessageDialog(
                    this, 
                    "No fue posible cancelar la compra",
                    "Eror",
                    JOptionPane.ERROR_MESSAGE);                        
        }else{
            JOptionPane.showMessageDialog(
                    this, 
                    "Compra cancelada correctamente");
            SQLConnection.commit();
            setVisible(true);
            dispose();
        }
    }
    
    private boolean actualizarExistencias(){
        
        for(int i = 0 ; i < modelProductos.getRowCount() ; i++){
            String sql = "UPDATE PRODUCTOS "
                    + "SET EXISTENCIA=EXISTENCIA-" + modelProductos.getValueAt(i, 2) + " "
                    + "WHERE CLAVE='" + modelProductos.getValueAt(i, 0) + "'";
            
            if(!SQLConnection.update(sql))
                return false;
        }
        return false;
    }
    
    public static void nuevo(JFrame parent, int idUsuario){
        EntradaMercancia dialogo = new EntradaMercancia(parent, true, idUsuario, NUEVO);
        
        dialogo.btnGuardar.setEnabled(true);
        dialogo.btnEgreso.setEnabled(false);
        dialogo.btnEliminar.setEnabled(false);
        
        dialogo.setVisible(true);
        dialogo.dispose();
    }
    
    public static void mostrar(JFrame parent, int idUsuario, int folio){
        EntradaMercancia dialogo = new EntradaMercancia(parent, true, idUsuario, VER, folio);
        
        dialogo.btnNuevo.setEnabled(false);
        dialogo.txtClave.setEnabled(false);
        dialogo.txtCantidad.setEnabled(false);
        dialogo.txtCostoUnitario.setEnabled(false);
        dialogo.txtCostoTotal.setEnabled(false);
        dialogo.txtProducto.setEnabled(false);
        
        dialogo.btnEliminar.setEnabled(!dialogo.chkCancelado.isSelected());
        dialogo.btnEgreso.setEnabled(true);
        
        dialogo.setVisible(true);
        dialogo.dispose();
    }
    
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
            java.util.logging.Logger.getLogger(EntradaMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EntradaMercancia.nuevo(null, 1);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnEgreso;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chkCancelado;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableProductos;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextField txtClave;
    private javax.swing.JFormattedTextField txtCostoTotal;
    private javax.swing.JFormattedTextField txtCostoUnitario;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
