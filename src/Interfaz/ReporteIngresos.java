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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raul
 */
public class ReporteIngresos extends javax.swing.JFrame {

    private int idUsuarioActual;
    
    private DefaultTableModel modeloIngresos = new DefaultTableModel(
            new Object[]{"Folio", "Fecha", "Usuario", "Tipo", "Monto", "Cancelado"},0){                
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
    
    /**
     * Creates new form ReporteIngresos
     */
    public ReporteIngresos(int idUsuario) {
        initComponents();
        
        this.idUsuarioActual = idUsuario;
        
        txtFechaFin.setText(Fecha.hoy());
        txtFechaInicio.setText(Fecha.hoy());
        
        tableIngresos.setModel(modeloIngresos);        
        
        tableIngresos.getColumnModel().getColumn(0).setMaxWidth(100);
        tableIngresos.getColumnModel().getColumn(0).setMinWidth(100);
        tableIngresos.getColumnModel().getColumn(1).setMaxWidth(200);
        tableIngresos.getColumnModel().getColumn(1).setMinWidth(200);
        tableIngresos.getColumnModel().getColumn(3).setMaxWidth(100);
        tableIngresos.getColumnModel().getColumn(3).setMinWidth(100);
        tableIngresos.getColumnModel().getColumn(4).setMaxWidth(100);
        tableIngresos.getColumnModel().getColumn(4).setMinWidth(100);
    }

    public void cargarReporte(){
        String sql = "";
        try {                       
            String fechaInicio = rbtnHoy.isSelected() ? Fecha.hoy() : txtFechaInicio.getText();
            String fechaFin = rbtnHoy.isSelected() ? Fecha.hoy() : txtFechaFin.getText();
            
            sql = "SELECT * FROM REPORTE_INGRESOS "
                    + "WHERE DATE(FECHA)>='" + fechaInicio + "' AND DATE(FECHA)<='" + fechaFin + "'";                        
            
            ResultSet consulta = SQLConnection.select(sql);
            
            modeloIngresos.setRowCount(0);
            
            while(consulta.next()){
                modeloIngresos.addRow(new Object[]{
                    consulta.getString("FOLIO"),
                    consulta.getString("FECHA"),
                    consulta.getString("USUARIO"),
                    consulta.getString("TIPO"),
                    consulta.getString("MONTO"),
                    consulta.getBoolean("CANCELADO")?"Si":"No"
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteIngresos.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JFormattedTextField();
        txtPeriodo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JFormattedTextField();
        rbtnHoy = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableIngresos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Reporte Ingresos");

        txtFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/d"))));

        buttonGroup1.add(txtPeriodo);
        txtPeriodo.setText("Periodo");

        jLabel2.setText("al");

        txtFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));

        buttonGroup1.add(rbtnHoy);
        rbtnHoy.setSelected(true);
        rbtnHoy.setText("Hoy");

        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableIngresosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableIngresos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnHoy)
                                .addGap(18, 18, 18)
                                .addComponent(txtPeriodo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton1)))
                        .addGap(0, 254, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeriodo)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnHoy)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarReporte();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableIngresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIngresosMouseClicked
        if(evt.getClickCount() != 2)
            return;
        
        Ingreso.mostrar(
                this, 
                idUsuarioActual,
                Integer.parseInt((String) tableIngresos.getValueAt(
                        tableIngresos.rowAtPoint(evt.getPoint()),
                        0)));
        cargarReporte();
    }//GEN-LAST:event_tableIngresosMouseClicked

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
            java.util.logging.Logger.getLogger(ReporteIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteIngresos(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnHoy;
    private javax.swing.JTable tableIngresos;
    private javax.swing.JFormattedTextField txtFechaFin;
    private javax.swing.JFormattedTextField txtFechaInicio;
    private javax.swing.JRadioButton txtPeriodo;
    // End of variables declaration//GEN-END:variables
}