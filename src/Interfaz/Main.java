/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BaseDeDatos.SQLConnection;
import Interfaz.Menu.ItemSubmenu;
import Interfaz.Menu.ModifiedFlowLayout;
import Interfaz.Menu.PanelSubmenu;
import Objetos.Producto;
import Utilidades.JTextfieldPlaceHolder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Raul
 */
public class Main extends JFrame{

    //<editor-fold defaultstate="collapsed" desc="Componentes de la interfaz gráfica">
    
    private final JPanel panelPrincipal;
    private final JPanel panelMenu = new JPanel();
    private final JPanel panelVenta = new JPanel();
    private final JPanel panelDerecho = new JPanel();
    private final JPanel panelPublicidad = new JPanel();
    private final JPanel panelTotal = new JPanel();
    private final JPanel panelBotones = new JPanel();
    private final JPanel panelFormasDePago = new JPanel();
    private final JPanel panelListaVenta = new JPanel();
        
    private final JScrollPane scrollMenu = new JScrollPane();
    private final JScrollPane scrollVenta = new JScrollPane();
    
    private final JTextfieldPlaceHolder txtClave = new JTextfieldPlaceHolder();
    
    private final JFormattedTextField txtTotal = new JFormattedTextField();
    
    private final JLabel labelLogo = new JLabel();    
    private final JLabel labelPublicidad = new JLabel();
    
    private final JButton btnEfectivo = new JButton("Efectivo");
    private final JButton btnApartado = new JButton("Apartado");
    private final JButton btnTarjeta = new JButton("Tarjeta");    
    
    private final JTable tableVenta = new JTable();        
    
    private final PanelSubmenu menuProductos = new PanelSubmenu("Productos", "/res/iconos/productos.png");
    private final PanelSubmenu menuUsuarios = new PanelSubmenu("Usuarios", "/res/iconos/usuarios.png");
    private final PanelSubmenu menuReportes = new PanelSubmenu("Usuarios", "/res/iconos/reportes.png");
    private final PanelSubmenu menuApartados = new PanelSubmenu("Apartados", "/res/iconos/apartados.png");
    private final PanelSubmenu menuConsultar = new PanelSubmenu("Consultar", "/res/iconos/consultar.png");    
    
    private final ItemSubmenu itemNuevoProducto = new ItemSubmenu("Nuevo", "/res/iconos/nuevo.png"){
        @Override
        public void click() {
            DialogoProducto.nuevo(getThis());            
        }        
    };
    private final ItemSubmenu itemModificarProducto = new ItemSubmenu("Modificar", "/res/iconos/modificar.png") {

        @Override
        public void click() {
            DialogoProducto.modificar(getThis());
        }
    };
    private final ItemSubmenu itemNuevoUsuario = new ItemSubmenu("Nuevo", "/res/iconos/nuevo.png") {
        @Override
        public void click() {
            DialogoUsuario.nuevo(getThis(), idUsuario);
        }
    };
    private final ItemSubmenu itemEliminarUsuario = new ItemSubmenu("Eliminar", "/res/iconos/eliminar.png") {
        @Override
        public void click() {
            System.out.println("Eliminar usuario");
        }
    };
    private final ItemSubmenu itemIngresos = new ItemSubmenu("Ingresos", "/res/iconos/ingresos.png") {
        @Override
        public void click() {
            new ReporteIngresos(idUsuario).setVisible(true);
        }
    };
    private final ItemSubmenu itemEgresos = new ItemSubmenu("Egresos", "/res/iconos/egresos.png") {
        @Override
        public void click() {
            new ReporteEgresos(idUsuario).setVisible(true);
            
        }
    };
    private final ItemSubmenu itemCompras = new ItemSubmenu("Compras", "/res/iconos/compras.png") {
        @Override
        public void click() {
            new ReporteEntradas(idUsuario).setVisible(true);
        }
    };
    private final ItemSubmenu itemVentas = new ItemSubmenu("Ventas", "/res/iconos/ventas.png") {
        @Override
        public void click() {
            new ReporteVentas(idUsuario).setVisible(true);
        }
    };
    private final ItemSubmenu itemPrecio = new ItemSubmenu("Precio", "/res/iconos/precio.png") {
        @Override
        public void click() {
            ConsultarProducto.mostrar(getThis());
        }
    };
    private final ItemSubmenu itemExistencia = new ItemSubmenu("Existencia", "/res/iconos/existencia.png") {
        @Override
        public void click() {
            System.out.println("Existencia");
        }
    };
    
    
    //</editor-fold>
        
    private final Font fuenteTabla = new Font("Arial", Font.BOLD, 15);
    private Color colorFondo = new Color(0x4d4dff);
    private Color colorPaneles = new Color(0xd9d9d9);
    
    private int idUsuario = 1;
    private int folioVentaActual = 0;
    
    private final DefaultTableModel modeloVenta = new DefaultTableModel(
            new Object[]{"Clave", "Producto", "Precio"},0){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
    
    private float total = 0;
    
    public Main(int idUsuario){
        panelPrincipal = (JPanel) getContentPane();                
                                     
        init();        
        
        this.idUsuario = idUsuario;                
                
        setVisible(true);
        
        folioVentaActual = createVenta();        
    }
    
    private void init(){
        panelPrincipal.setBackground(colorFondo);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelPrincipal.setLayout(new BorderLayout(15, 15));
        panelPrincipal.add(scrollMenu, BorderLayout.WEST);
        panelPrincipal.add(panelVenta, BorderLayout.CENTER);
        panelPrincipal.add(panelDerecho, BorderLayout.EAST);
        
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
        setMenu();
        setVenta();
        setDerecha();
    }
    
    private void setMenu(){
        
        PanelSubmenu.fondo = new Color(0x4d, 0x4d, 0xff, 0x88);
        
        scrollMenu.getViewport().setBackground(colorPaneles);
        panelMenu.setOpaque(false);
        
        panelMenu.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.CENTER, 0, 1));                        
        
        menuProductos.setOpaque(false);
        menuProductos.setBackground(Color.WHITE);
        menuUsuarios.setOpaque(false);
        menuUsuarios.setBackground(Color.WHITE);
        
        scrollMenu.setViewportView(panelMenu);
        panelMenu.setPreferredSize(new Dimension(100,0));
        
        panelMenu.add(menuProductos);
        panelMenu.add(menuUsuarios);
        panelMenu.add(menuReportes);
        panelMenu.add(menuApartados);
        panelMenu.add(menuConsultar);
        
        menuProductos.addItem(itemNuevoProducto);
        menuProductos.addItem(itemModificarProducto);
        menuUsuarios.addItem(itemNuevoUsuario);
        menuUsuarios.addItem(itemEliminarUsuario);
        menuReportes.addItem(itemEgresos);
        menuReportes.addItem(itemIngresos);
        menuReportes.addItem(itemCompras);
        menuReportes.addItem(itemVentas);
        menuConsultar.addItem(itemPrecio);
        menuConsultar.addItem(itemExistencia);
    }
    
    private void setVenta(){
        
        panelVenta.setBackground(colorPaneles);
        panelVenta.setLayout(new BorderLayout(10, 10));
        panelVenta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelVenta.add(labelLogo, BorderLayout.NORTH);
        panelVenta.add(panelListaVenta, BorderLayout.CENTER);
        panelVenta.add(panelTotal, BorderLayout.SOUTH);
                        
        panelVenta.setPreferredSize(new Dimension(
                ((int)(this.getWidth() * 0.5)),
                0
        ));
        
        labelLogo.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 3, 150));
        labelLogo.setBackground(new Color(0x9090f9));
        labelLogo.setOpaque(false);                
        labelLogo.setIcon(new ImageIcon(new ImageIcon(
                Main.class.getResource("/res/logo.png")).getImage().
                getScaledInstance((int)(Toolkit.getDefaultToolkit().getScreenSize().width / 3), 150, Image.SCALE_DEFAULT)));
        
        tableVenta.setModel(modeloVenta);
        tableVenta.getColumnModel().getColumn(0).setMaxWidth(100);
        tableVenta.getColumnModel().getColumn(0).setMinWidth(100);
        tableVenta.getColumnModel().getColumn(2).setMaxWidth(100);
        tableVenta.getColumnModel().getColumn(2).setMinWidth(100);
        tableVenta.setBackground(Color.WHITE); 
        tableVenta.setShowVerticalLines(false);
        tableVenta.setRowHeight(30);   
        tableVenta.setFont(fuenteTabla);
                        
        txtClave.setFont(fuenteTabla);        
        txtClave.addFocusListener(new FocusAdapter(){
            
            @Override
            public void focusLost(FocusEvent evt){
                addProducto();
            }
            
        });
        txtClave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                addProducto();
            }
            
        });
        
        scrollVenta.setViewportView(tableVenta);        
        scrollVenta.getViewport().setOpaque(false);
        scrollVenta.setViewportBorder(BorderFactory.createEmptyBorder());
        scrollVenta.setBackground(Color.WHITE);  
        scrollVenta.setOpaque(true);
        
        panelListaVenta.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelListaVenta.setLayout(new BorderLayout(5, 5));
        panelListaVenta.add(scrollVenta, BorderLayout.CENTER);
        panelListaVenta.add(txtClave, BorderLayout.SOUTH);
        
        panelTotal.setOpaque(false);
        panelTotal.setLayout(new BorderLayout(5,5));
        panelTotal.add(txtTotal, BorderLayout.CENTER);
        panelTotal.add(panelFormasDePago, BorderLayout.SOUTH);
        
        
        txtTotal.setPreferredSize(new Dimension(0, 75));
        txtTotal.setBackground(Color.WHITE);
        txtTotal.setOpaque(true);
        txtTotal.setFont(new Font("Arial", Font.BOLD, 36));
        txtTotal.setHorizontalAlignment(JLabel.RIGHT);
        txtTotal.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        txtTotal.setEditable(false);
        txtTotal.setText(total + "");
        txtTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));        
        txtTotal.updateUI();
        
        panelFormasDePago.setOpaque(false);
        panelFormasDePago.setLayout(new GridLayout(1, 3, 5, 5));
        panelFormasDePago.add(btnEfectivo);
        panelFormasDePago.add(btnApartado);
        panelFormasDePago.add(btnTarjeta);
        
        btnEfectivo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {                
                insertCompraContado();
            }   
            
        });
    }                        
    
    private void setDerecha(){
       
        panelDerecho.setBackground(colorPaneles);
        panelDerecho.setLayout(new BorderLayout(10, 10));
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDerecho.add(panelPublicidad, BorderLayout.NORTH);
        panelDerecho.add(panelBotones, BorderLayout.CENTER);
        
        panelPublicidad.setPreferredSize(new Dimension(700, 500));
        panelPublicidad.setOpaque(false);
        panelPublicidad.setLayout(new BorderLayout());
        panelPublicidad.add(labelPublicidad, BorderLayout.CENTER);
        
            labelPublicidad.setIcon(new ImageIcon(new ImageIcon(
                    Main.class.getResource("/res/fenix.png")).getImage().
                    getScaledInstance(700, 500, Image.SCALE_SMOOTH))
            );
                   
        panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelBotones.setOpaque(false);        
    }
    
    private int recuperarVenta(){
        String sql = "SELECT * FROM VENTAS_PENDIENTES";
        int folioVenta = 0;
        
        try {            
            
            ResultSet consulta = SQLConnection.select(sql);
            
            if(consulta.next()){
                folioVenta = consulta.getInt("FOLIO_VENTA");
                String cargarVenta = "SELECT * FROM DETALLE_VENTA "
                        + "WHERE FOLIO_VENTA=" + folioVenta;
                
                consulta = SQLConnection.select(cargarVenta);
                
                while(consulta.next()){
                    modeloVenta.addRow(new Object[]{
                        consulta.getString("CLAVE"),
                        consulta.getString("NOMBRE"),
                        consulta.getFloat("PRECIO")
                    });
                    
                    total += consulta.getFloat("PRECIO");
                }
                txtTotal.setText(total + "");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return folioVenta;
    }
    
    private int createVenta(){
        int folioVenta = 0;
        boolean valido = false;
          
        folioVenta = recuperarVenta();
        
        if(folioVenta != 0)
            return folioVenta;        
        
        String insertVenta = "INSERT INTO VENTAS("
                + "ID_USUARIO, "
                + "FORMA_PAGO, "
                + "TOTAL)"
                + "VALUES("
                + idUsuario + ","
                + "'Pendiente',"
                + total + ")";        
        
        SQLConnection.startTransaction();
        if (SQLConnection.update(insertVenta)){
            try {
                String sqlFolio = "SELECT MAX(FOLIO) AS FOLIO FROM VENTAS";
                
                ResultSet consulta = SQLConnection.select(sqlFolio);
                
                consulta.next();
                folioVenta = consulta.getInt("FOLIO");
                
                String insertVentaPendiente = "INSERT INTO VENTAS_PENDIENTES("
                        + "FOLIO_VENTA) VALUES(" + folioVenta + ")";
                
                if(SQLConnection.update(insertVentaPendiente))
                    valido = true;
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(valido)
            SQLConnection.commit();
        else 
            SQLConnection.rollback();
        return folioVenta;
    }
    
    private void addProducto(){
        Producto temp = getProducto(txtClave.getText().trim());

        if (temp == null) {
            return;
        }

        if(!insertProductoDB(temp))
            return;
        
        modeloVenta.addRow(new Object[]{
            temp.clave,
            temp.nombre,
            temp.precio
        });
        txtClave.setText("");        

        total += temp.precio;
        txtTotal.setText(total + "");
        
    }
    
    private boolean insertProductoDB(Producto nuevo){
        String sql = "INSERT INTO VENTAS_PRODUCTOS("
                + "FOLIO_VENTA, "
                + "CLAVE_PRODUCTO, "
                + "PRECIO) "
                + "VALUES("
                + folioVentaActual + ","
                + "'" + nuevo.clave + "',"
                + "'" + nuevo.precio + "')";
                                            
        if(!SQLConnection.update(sql)){
            JOptionPane.showMessageDialog(this, "No se pudo agregar el producto");
            return false;
        }
        return true;                
    }
    
    private void insertCompraContado(){
        int folioVenta;
        int folioIngreso;
        boolean valido = false;
                
        SQLConnection.startTransaction();

        folioIngreso = Ingreso.nuevoParaVenta(getThis(), idUsuario, folioVentaActual, total);
        
        if (folioIngreso != 0)
            valido = true;
        
        if(valido){
            SQLConnection.commit();
            JOptionPane.showMessageDialog(
                    this,
                    "Compra registrada correctamente"
            );
            modeloVenta.setRowCount(0);
            total = 0;
            txtTotal.setText(total + "");
            createVenta();
        }else{
            SQLConnection.rollback();
            JOptionPane.showMessageDialog(
                    this,
                    "No fue posible realizar la compra"
            );
        }
    }                
    
    private boolean updateVenta(String formaDePago){
        String sql = "UPDATE VENTAS SET "
                + "FORMA_DE_PAGO='" + formaDePago + "',"
                + "ID_USUARIO=" + idUsuario + " "
                + "FECHA=NOW()"
                + "WHERE FOLIO=" + folioVentaActual;
        String deleteVentaPendiente = "DELETE FROM VENTAS_PENDIENTES "
                + "WHERE FOLIO_VENTA=" + folioVentaActual;
        
        return SQLConnection.update(sql) && SQLConnection.update(deleteVentaPendiente);
    }
    
    private Main getThis(){
        return this;
    }
    
    private Producto getProducto(String clave){
        try {
            String sql = "SELECT * FROM PRODUCTOS_PARA_VENTA WHERE CLAVE='" + clave + "'";
            
            
            ResultSet consulta = SQLConnection.select(sql);
            
            if(consulta.next()){
                return new Producto(
                        consulta.getString("CLAVE"),
                        consulta.getString("NOMBRE"),
                        consulta.getFloat("PRECIO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        new Main(1);
    }
    
}