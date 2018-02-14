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
public class ReporteEgresos extends javax.swing.JFrame {

    private int idUsuarioActual;
    
    private DefaultTableModel modeloEgresos = new DefaultTableModel(
            new Object[]{"Folio", "Fecha", "Usuario", "Tipo", "Monto", "Cancelado"},0){                
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
    
    /**
     * Creates new form ReporteEgresos
     */
    public ReporteEgresos(int idUsuarioActual) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.idUsuarioActual = idUsuarioActual;
        
        tableEgresos.setModel(modeloEgresos);
        
        txtFechaFin.setText(Fecha.hoy());
        txtFechaInicio.setText(Fecha.hoy());
        
        tableEgresos.getColumnModel().getColumn(0).setMaxWidth(50);
        tableEgresos.getColumnModel().getColumn(0).setMinWidth(50);
        tableEgresos.getColumnModel().getColumn(1).setMaxWidth(150);
        tableEgresos.getColumnModel().getColumn(1).setMinWidth(150);
        tableEgresos.getColumnModel().getColumn(3).setMaxWidth(100);
        tableEgresos.getColumnModel().getColumn(3).setMinWidth(100);
        tableEgresos.getColumnModel().getColumn(4).setMaxWidth(75);
        tableEgresos.getColumnModel().getColumn(4).setMinWidth(75);
        tableEgresos.getColumnModel().getColumn(5).setMaxWidth(75);
        tableEgresos.getColumnModel().getColumn(5).setMinWidth(75);
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
        txtFechaInicio = new javax.swing.JFormattedTextField();
        txtPeriodo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JFormattedTextField();
        rbtnHoy = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEgresos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Reporte Ingresos");

        txtFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/d"))));

        txtPeriodo.setText("Periodo");

        jLabel2.setText("al");

        txtFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));

        rbtnHoy.setSelected(true);
        rbtnHoy.setText("Hoy");

        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableEgresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableEgresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEgresosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEgresos);

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
                        .addGap(0, 152, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarReporte();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableEgresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEgresosMouseClicked
        if(evt.getClickCount() != 2)
        return;

        Egreso.mostrar(
            this,
            idUsuarioActual,
            Integer.parseInt((String) tableEgresos.getValueAt(
                tableEgresos.rowAtPoint(evt.getPoint()),
                0)));
        cargarReporte();
    }//GEN-LAST:event_tableEgresosMouseClicked

    public void cargarReporte(){
        String sql = "";
        try {                       
            String fechaInicio = rbtnHoy.isSelected() ? Fecha.hoy() : txtFechaInicio.getText();
            String fechaFin = rbtnHoy.isSelected() ? Fecha.hoy() : txtFechaFin.getText();
            
            sql = "SELECT * FROM REPORTE_EGRESOS "
                    + "WHERE DATE(FECHA)>='" + fechaInicio + "' AND DATE(FECHA)<='" + fechaFin + "'";                        
            
            ResultSet consulta = SQLConnection.select(sql);
            
            modeloEgresos.setRowCount(0);
            
            while(consulta.next()){
                modeloEgresos.addRow(new Object[]{
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
            java.util.logging.Logger.getLogger(ReporteEgresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteEgresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteEgresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteEgresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteEgresos(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnHoy;
    private javax.swing.JTable tableEgresos;
    private javax.swing.JFormattedTextField txtFechaFin;
    private javax.swing.JFormattedTextField txtFechaInicio;
    private javax.swing.JRadioButton txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
