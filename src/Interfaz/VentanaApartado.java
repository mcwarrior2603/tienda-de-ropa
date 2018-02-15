/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDeDatos.SQLConnection;
import Objetos.Abono;
import Objetos.Apartado;
import Objetos.Cliente;
import Utilidades.ManejoDeErrores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raul
 */
public class VentanaApartado extends javax.swing.JFrame {

    private int idClienteActual = 0;
    private int idUsuarioActual = 0;
    private int folioActual = 0;
    private int subfolio = 0;
    
    private DefaultComboBoxModel<Apartado> apartados = new DefaultComboBoxModel();   
    private DefaultTableModel abonos = new DefaultTableModel(
            new Object[]{"Ticket", "Fecha", "Recibió", "Monto", "Cancelado"},
            0){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
    
    /**
     * Creates new form Apartado
     */
    private VentanaApartado(int idUsuarioActual) {
        initComponents();     
        
        this.idUsuarioActual = idUsuarioActual;
    }   
    
    public VentanaApartado(int idUsuarioActual, int subfolio){
        initComponents();
        
        this.idUsuarioActual = idUsuarioActual;
        this.subfolio = subfolio;                
        
        cargarSubfolio();
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
        txtFolio = new javax.swing.JTextField();
        txtCliente = new Utilidades.JTextfieldPlaceHolder();
        cboApartados = new javax.swing.JComboBox();
        txtPrecio = new Utilidades.JTextfieldPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAbonos = new javax.swing.JTable();
        btnAbonar = new javax.swing.JButton();
        btnEntregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFolioDeVenta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Apartado");

        jLabel2.setText("Folio");

        txtFolio.setEditable(false);

        txtCliente.setEditable(false);
        txtCliente.setPlaceholder("Cliente");
        txtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClienteMouseClicked(evt);
            }
        });

        cboApartados.setModel(apartados);
        cboApartados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboApartadosItemStateChanged(evt);
            }
        });

        txtPrecio.setEditable(false);
        txtPrecio.setPlaceholder("Precio");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Abonos");

        tableAbonos.setModel(abonos);
        tableAbonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAbonosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAbonos);

        btnAbonar.setText("Abonar");
        btnAbonar.setEnabled(false);
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });

        btnEntregar.setText("Entregar");
        btnEntregar.setEnabled(false);

        jLabel4.setText("Saldo");

        txtSaldo.setEditable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Sub folio de venta");

        txtFolioDeVenta.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAbonar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEntregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFolioDeVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboApartados, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFolioDeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboApartados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAbonar)
                        .addComponent(btnEntregar)
                        .addComponent(jLabel4)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboApartadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboApartadosItemStateChanged
        cargarApartado();
    }//GEN-LAST:event_cboApartadosItemStateChanged

    private void txtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClienteMouseClicked
        if (evt.getClickCount() == 2) {
            idClienteActual = BuscarCliente.mostrar(this, "Seleccione el cliente");            
            if (idClienteActual == 0) 
                return;            
            cargarClienteActual();
            cargarApartado();
        }
    }//GEN-LAST:event_txtClienteMouseClicked

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
        abonar();
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void tableAbonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAbonosMouseClicked
        Ingreso.mostrar(this, 
                idUsuarioActual, 
                (int) tableAbonos.getValueAt(
                        tableAbonos.rowAtPoint(evt.getPoint()),
                        0));
        cargarClienteActual();
        cargarApartado();
    }//GEN-LAST:event_tableAbonosMouseClicked

    private void cargarSubfolio(){
        try {
            String sql = "SELECT * FROM BUSCAR_POR_SUBFOLIO WHERE SUBFOLIO=" + subfolio;
            
            ResultSet consulta = SQLConnection.select(sql);
            
            if(consulta.next()){
                idClienteActual = consulta.getInt("ID_CLIENTE");            
                folioActual = consulta.getInt("FOLIO");
                cargarClienteActual();
            }                        
        } catch (SQLException ex) {
            Logger.getLogger(VentanaApartado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarClienteActual() {
        String sql = "";
        ResultSet consulta;
        try {
            sql = "SELECT NOMBRE FROM NOMBRE_CLIENTE WHERE ID=" + idClienteActual;
            consulta = SQLConnection.select(sql);
            if(consulta.next()){
                txtCliente.setText(consulta.getString("NOMBRE"));            
                
                sql = "SELECT * FROM APARTADOS_POR_CLIENTE WHERE ID_CLIENTE=" + idClienteActual;
                consulta = SQLConnection.select(sql);
                
                apartados.removeAllElements(); 
                txtPrecio.setText("");
                txtSaldo.setText("");
                txtFolio.setText("");
                txtFolioDeVenta.setText("");
                abonos.setRowCount(0);
                btnAbonar.setEnabled(false);
                btnEntregar.setEnabled(false);
                for(int i = 0 ; consulta.next() ; i++) {
                    Apartado temp = new Apartado(
                            consulta.getInt("FOLIO"),
                            consulta.getInt("FOLIO_VENTA"),
                            consulta.getString("NOMBRE"),
                            consulta.getFloat("PRECIO"),
                            consulta.getFloat("SALDO_PENDIENTE")
                    );
                                                            
                    apartados.addElement(temp);
                    btnAbonar.setEnabled(true);
                    btnEntregar.setEnabled(true);
                    
                    if(temp.folio == folioActual){
                        cboApartados.setSelectedIndex(i);
                    }
                }
                
                cboApartadosItemStateChanged(null);
            }        
        } catch (SQLException ex) {
            Logger.getLogger(VentanaApartado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarApartado(){
        String sql = "";
        try {
            Apartado temp = (Apartado) apartados.getSelectedItem();
            
            if(temp == null)
                return;
            
            txtFolio.setText(temp.folio + "");
            txtFolioDeVenta.setText(temp.folioDeVenta + "");
            txtPrecio.setText(temp.precio + "");
            txtSaldo.setText(temp.saldoPendiente + "");                        
            
            if(temp.saldoPendiente == 0)
                btnAbonar.setEnabled(false);            
            
            sql = "SELECT * FROM ABONOS_APARTADOS WHERE FOLIO_APARTADO=" + temp.folio;
            ResultSet consulta = SQLConnection.select(sql);
            
            abonos.setRowCount(0);
            while(consulta.next()){
                
                abonos.addRow(new Object[]{
                    consulta.getInt("FOLIO_TICKET"),
                    consulta.getString("FECHA"),
                    consulta.getString("USUARIO"),
                    consulta.getFloat("MONTO"),
                    consulta.getBoolean("CANCELADO")?"Si":"No"
                });
            }
        } catch (SQLException ex) {
            ManejoDeErrores.reportarError(ex, sql);
        }        
    }        
    
    private void abonar(){
        boolean valido = false;
        
        SQLConnection.startTransaction();
        
        int folioIngreso = Ingreso.nuevoParaAbono(
                this, 
                idUsuarioActual, 
                ((Apartado)cboApartados.getSelectedItem()).folio,
                ((Apartado)cboApartados.getSelectedItem()).nombre);
        
        if(folioIngreso != 0){
            String sql = "INSERT INTO ABONOS("
                    + "FOLIO_APARTADO,"
                    + "FOLIO_TICKET)"
                    + "VALUES("
                    + folioActual + ","
                    + folioIngreso + ")";
            
            valido = SQLConnection.update(sql);
        }
        
        if(valido){
            SQLConnection.commit();
            JOptionPane.showMessageDialog(
                    this, 
                    "Abono correcto");            
        }else{
            SQLConnection.rollback();
            JOptionPane.showMessageDialog(
                    this, 
                    "No fue posible registrar el abono");            
        }
        
        cargarClienteActual();
        cargarApartado();
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
            java.util.logging.Logger.getLogger(VentanaApartado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaApartado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaApartado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaApartado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaApartado(0,1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnEntregar;
    private javax.swing.JComboBox cboApartados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAbonos;
    private Utilidades.JTextfieldPlaceHolder txtCliente;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtFolioDeVenta;
    private Utilidades.JTextfieldPlaceHolder txtPrecio;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
