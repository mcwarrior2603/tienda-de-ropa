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
public class Consultas extends javax.swing.JFrame {

    private DefaultTableModel modeloConsultas = new DefaultTableModel(
            new Object[]{"ID", "Fecha", "Producto", "Usuario"}, 0){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
    
    /**
     * Creates new form Consultas
     */
    public Consultas() {
        initComponents();
        
        tableConsultas.setModel(modeloConsultas);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableConsultas = new javax.swing.JTable();
        txtFechaInicio = new javax.swing.JFormattedTextField();
        txtPeriodo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JFormattedTextField();
        rbtnHoy = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Reporte Consultas");

        tableConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableConsultas);

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
                        .addGap(0, 73, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeriodo)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnHoy)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarReporte();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargarReporte(){
        String sql = "";
        try {                       
            String fechaInicio = rbtnHoy.isSelected() ? Fecha.hoy() : txtFechaInicio.getText();
            String fechaFin = rbtnHoy.isSelected() ? Fecha.hoy() : txtFechaFin.getText();
            
            sql = "SELECT * FROM REPORTE_CONSULTAS "
                    + "WHERE DATE(FECHA)>='" + fechaInicio + "' AND DATE(FECHA)<='" + fechaFin + "'";                        
            
            ResultSet consulta = SQLConnection.select(sql);
            
            modeloConsultas.setRowCount(0);
            
            while(consulta.next()){
                modeloConsultas.addRow(new Object[]{
                    consulta.getString("ID"),
                    consulta.getString("FECHA"),
                    consulta.getString("NOMBRE"),
                    consulta.getString("USUARIO"),                    
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteIngresos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnHoy;
    private javax.swing.JTable tableConsultas;
    private javax.swing.JFormattedTextField txtFechaFin;
    private javax.swing.JFormattedTextField txtFechaInicio;
    private javax.swing.JRadioButton txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
