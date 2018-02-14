/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDeDatos.SQLConnection;
import Utilidades.Fecha;
import Utilidades.ManejoDeErrores;
import Utilidades.Seguridad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class Ingreso extends javax.swing.JDialog {

    private static final int NUEVO = 1;
    private static final int VER = 2;
    
    private int idUsuarioActual;
    private int folioActual;
    
    private int uso;
    
    private boolean correcto = false;
    
    /**
     * Creates new form Ingreso
     */
    private Ingreso(
            java.awt.Frame parent, 
            boolean modal, 
            int idUsuarioActual, 
            int uso) {
        super(parent, modal);
        
        this.idUsuarioActual = idUsuarioActual;
        
        initComponents();
        
        btnEliminar.setEnabled(false);
        btnAceptar.setEnabled(false);
        
        cargarParaNuevo();
        txtFecha.setText(Fecha.now());        
    }
    private Ingreso(
            java.awt.Frame parent, 
            boolean modal, 
            int idUsuarioActual, 
            int uso,
            int folioReferencia,
            float monto) {
        super(parent, modal);
        
        this.idUsuarioActual = idUsuarioActual;
        
        initComponents();
        
        btnEliminar.setEnabled(false);
        btnAceptar.setEnabled(false);
        
        cargarParaNuevo();
        txtFecha.setText(Fecha.now());  
        txtFolioReferencia.setText(folioReferencia + "");                
    }
    
    private Ingreso(
            java.awt.Frame parent, 
            boolean modal, 
            int idUsuarioActual, 
            int uso,
            int folio) {
        super(parent, modal);
        
        this.idUsuarioActual = idUsuarioActual;
        this.folioActual = folio;
        
        initComponents();
        
        btnEliminar.setEnabled(false);
        btnAceptar.setEnabled(false);
        txtMonto.setEditable(false);
        txtDetalles.setEditable(false);
        txtFolioReferencia.setEditable(false);                        
        
        cargarIngreso();                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox();
        txtFolio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalles = new javax.swing.JTextArea();
        btnAceptar = new javax.swing.JButton();
        txtFolioReferencia = new javax.swing.JFormattedTextField();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtFecha = new javax.swing.JFormattedTextField();
        chkCancelado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Folio Referencia");

        jLabel5.setText("Monto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Ingreso");

        txtMonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo");

        cboTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoItemStateChanged(evt);
            }
        });

        txtFolio.setEditable(false);

        jLabel7.setText("Detalles");

        jLabel2.setText("Folio");

        jLabel3.setText("Fecha");

        txtDetalles.setColumns(20);
        txtDetalles.setRows(5);
        jScrollPane1.setViewportView(txtDetalles);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtFolioReferencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel8.setText("Usuario");

        txtUsuario.setEditable(false);

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));

        chkCancelado.setText("Cancelado");
        chkCancelado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFolioReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkCancelado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha)
                            .addComponent(txtFolio))))
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
                    .addComponent(jLabel5)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFolioReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(chkCancelado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String insertIngreso = "INSERT INTO INGRESOS("
        + "FECHA,"
        + "ID_USUARIO,"
        + "TIPO,"
        + "MONTO,"
        + "DETALLES)"
        + "VALUES("
        + "NOW(),"
        + idUsuarioActual + ","
        + "'" + cboTipo.getSelectedItem() + "',"
        + txtMonto.getText() + ","
        + "'" + txtDetalles.getText() + "');";
                
        SQLConnection.startTransaction();

        if(SQLConnection.update(insertIngreso)){
            if(cboTipo.getSelectedItem().toString().equalsIgnoreCase("abono")){
                
                String insertAbono = "INSERT INTO ABONOS("
                        + "FOLIO_TICKET,"
                        + "FOLIO_APARTADO) "
                        + "VALUES("
                        +"(select max(folio) from ingresos), "
                        + "" + txtFolioReferencia.getText() + ")";
                String actualizarSaldo = "UPDATE APARTADOS "
                        + "SET SALDO_PENDIENTE=SALDO_PENDIENTE-" + txtMonto.getText() + " "
                        + "WHERE FOLIO=" + txtFolioReferencia.getText();
                
                if(!SQLConnection.update(insertAbono) || !SQLConnection.update(actualizarSaldo)){
                    SQLConnection.rollback();
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un fallo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }else if(cboTipo.getSelectedItem().toString().equalsIgnoreCase("Pago de contado")){
               
                String insertPago = "INSERT INTO PAGOS_DE_CONTADO("
                        + "FOLIO_INGRESO,"
                        + "FOLIO_VENTA) "
                        + "VALUES("
                        +"(select max(folio) from ingresos), "
                        + "" + txtFolioReferencia.getText() + ")";
                
                if(!SQLConnection.update(insertPago)){
                    SQLConnection.rollback();
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un fallo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }else{
                    correcto = true;
                    JOptionPane.showMessageDialog(this, "Ingreso guardado correctamente");
                    setVisible(false);  
                }                    
            }
        }else{
            SQLConnection.rollback();
            JOptionPane.showMessageDialog(this, "Ha ocurrido un fallo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        SQLConnection.commit();
        correcto = true;
        JOptionPane.showMessageDialog(this, "Ingreso guardado correctamente");
        setVisible(false);        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(JOptionPane.showConfirmDialog(
                this, 
                "¿Seguro que desea cancelar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            setVisible(false);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         btnCancelarActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void cboTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTipoItemStateChanged
        if(cboTipo.getSelectedItem() == null)
            return;
                
        if(cboTipo.getSelectedItem().toString().equalsIgnoreCase("Abono"))
            txtFolioReferencia.setEditable(true);
        else
            txtFolioReferencia.setEditable(false);
    }//GEN-LAST:event_cboTipoItemStateChanged

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Random r = new Random(System.nanoTime());        
        
        int folio = Integer.parseInt(txtFolio.getText());
        String fecha = txtFecha.getText();        
        int digitoValidador = Math.abs(r.nextInt())%1000000000;               
        
        String ing = JOptionPane.showInputDialog(
                "Se requiere autorización para realizar esta acción\n"
                        + "Proporcione los siguientes datos:\n"
                        + "Folio:" + txtFolio.getText() + "\n"
                        + "Fecha:" + txtFecha.getText() + "\n"
                        + "Usuario:" + idUsuarioActual + "\n"
                        + "Número de validación:" + digitoValidador + "\n\n"
                        + "Ingrese el código de autorización:");                
        if(Seguridad.checkEliminarIngreso(
                folio,
                fecha, 
                idUsuarioActual, 
                digitoValidador, 
                ing)){
            SQLConnection.startTransaction();
            String sqlCancelar = "UPDATE INGRESOS SET CANCELADO=TRUE WHERE FOLIO=" + folio;            
            String sqlUpdateSaldo = "UPDATE APARTADOS "
                    + "SET SALDO_PENDIENTE=SALDO_PENDIENTE+" + txtMonto.getText() + " "
                    + "WHERE FOLIO=" + txtFolio.getText();
            
            if(!SQLConnection.update(sqlCancelar)){
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible cancelar el ingreso",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                SQLConnection.rollback();
                return;
            }
            if(cboTipo.getSelectedItem().toString().equals("ABONO"))
                if(!SQLConnection.update(sqlUpdateSaldo)){
                    JOptionPane.showMessageDialog(
                        this,
                        "No fue posible cancelar el ingreso",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                SQLConnection.rollback();
                return;
                }            
            SQLConnection.commit();
            JOptionPane.showMessageDialog(
                    this, 
                    "¡Ingreso cancelado!");            
            setVisible(false);
            dispose();
        }else{
            JOptionPane.showMessageDialog(
                        this,
                        "Código incorrecto",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static boolean nuevo(JFrame parent, int idUsuarioActual){
        Ingreso dialogo = new Ingreso(parent, true, idUsuarioActual, NUEVO);
        
        dialogo.setVisible(true);               
        dialogo.dispose();
        
        return dialogo.correcto;
    }
    
    public static boolean nuevo(JFrame parent, int idUsuarioActual, int folioApartado){
        Ingreso dialogo = new Ingreso(parent, true, idUsuarioActual, NUEVO);
        
        dialogo.txtFolioReferencia.setText(folioApartado + "");        
        
        dialogo.setVisible(true);
        dialogo.dispose();
        
        return dialogo.correcto;
        
    }
    
    public static int nuevoParaVenta(JFrame parent, int idUsusarioActual, int folioVenta, float monto){
        Ingreso ingreso = new Ingreso(parent, true, idUsusarioActual, NUEVO, folioVenta, monto);
        
        ingreso.cboTipo.setSelectedItem("Pago de contado");        
        ingreso.txtMonto.setText(monto + "");
        
        ingreso.cboTipo.setEnabled(false);
        ingreso.txtMonto.setEnabled(false);
        ingreso.txtFolioReferencia.setEnabled(false);
        
        ingreso.setVisible(true);
        ingreso.dispose();
        
        System.out.println(ingreso.folioActual);
        
        return ingreso.folioActual;
    }
    
    public static void mostrar(JFrame parent, int idUsuarioActual, int folio){
        Ingreso dialogo = new Ingreso(parent, true, idUsuarioActual, VER, folio);
        
        dialogo.btnEliminar.setEnabled(dialogo.chkCancelado.isSelected());
        
        dialogo.setVisible(true);
        dialogo.dispose();
    }
        
    private void cargarParaNuevo(){
        
        try {
            String sqlIngreso = "SELECT * FROM TIPOS_INGRESOS";
            String sqlUsuario = "SELECT NOMBRE FROM USUARIOS WHERE ID=" + idUsuarioActual;
            
            ResultSet consulta = SQLConnection.select(sqlIngreso);
            
            for(int i = 0 ; consulta.next() ; i++){
                String tipo = consulta.getString("TIPO");
                
                ((DefaultComboBoxModel)cboTipo.getModel()).
                        addElement(tipo);
                if(tipo.equalsIgnoreCase("Abono")){
                    cboTipo.setSelectedIndex(i);
                }                
            }
            
            consulta = SQLConnection.select(sqlUsuario);
            
            System.out.println(sqlUsuario);
            if(consulta.next()){
                txtUsuario.setText(consulta.getString("NOMBRE"));
                System.out.println("Nombre de Usuario");
            }
            
            btnAceptar.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarIngreso(){
        String sql = "";
        
        try {                        
            sql = "SELECT * FROM REPORTE_INGRESOS WHERE FOLIO=" + folioActual;                        
            
            ResultSet consulta = SQLConnection.select(sql);
            if(consulta.next()){
                txtFolio.setText(consulta.getString("FOLIO"));
                txtFecha.setText(consulta.getString("FECHA"));
                txtMonto.setText(consulta.getString("MONTO"));
                txtDetalles.setText(consulta.getString("DETALLES"));
                txtUsuario.setText(consulta.getString("USUARIO"));
                chkCancelado.setSelected(consulta.getBoolean("CANCELADO"));
                ((DefaultComboBoxModel<String>)cboTipo.getModel()).addElement(
                        consulta.getString("TIPO")
                );
                
                String folioApartado = consulta.getString("FOLIO_APARTADO");                
                String folioVenta = consulta.getString("FOLIO_VENTA");
                txtFolioReferencia.setText(
                        folioApartado != null ? folioApartado : 
                        folioVenta != null ? folioVenta : "");
                
                cboTipo.setEnabled(false);
                btnEliminar.setEnabled(!consulta.getBoolean("CANCELADO"));                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                nuevo(null, 1);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cboTipo;
    private javax.swing.JCheckBox chkCancelado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDetalles;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JFormattedTextField txtFolioReferencia;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
