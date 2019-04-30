/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Interfaz.Reportes.Consultas;
import Interfaz.Transacciones.Ingreso;
import Interfaz.Transacciones.Egreso;
import Interfaz.Transacciones.EntradaMercancia;
import Interfaz.Reportes.Inventario;
import Interfaz.Reportes.ReporteIngresos;
import Interfaz.Reportes.ReporteEgresos;
import Interfaz.Reportes.ReporteVentas;
import Interfaz.Reportes.CorteCaja;
import Interfaz.Reportes.ReporteEntradas;
import BaseDeDatos.SQLConnection;
import Interfaz.Menu.ItemSubmenu;
import Interfaz.Menu.ModifiedFlowLayout;
import Interfaz.Menu.PanelSubmenu;
import Objetos.Producto;
import Utilidades.Fecha;
import Utilidades.JTextfieldPlaceHolder;
import Utilidades.Seguridad;
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
import java.util.ArrayList;
import java.util.Random;
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
    private final JButton btnApartado = new JButton("Crédito");
    private final JButton btnTarjeta = new JButton("Tarjeta");    
    private final JButton btnAperturar = new JButton("Aperturar caja");    
    
    private final JTable tableVenta = new JTable();        
    
    private final PanelSubmenu menuArchivo = new PanelSubmenu("Menu", "/res/iconos/menu.png");
    private final PanelSubmenu menuProductos = new PanelSubmenu("Productos", "/res/iconos/productos.png");
    private final PanelSubmenu menuCategorias = new PanelSubmenu("Categorias", "/res/iconos/categoria.png");
    private final PanelSubmenu menuClientes = new PanelSubmenu("Clientes", "/res/iconos/clientes.png");
    private final PanelSubmenu menuUsuarios = new PanelSubmenu("Usuarios", "/res/iconos/usuarios.png");
    private final PanelSubmenu menuTransacciones = new PanelSubmenu("Transacciones", "/res/iconos/transacciones.png");
    private final PanelSubmenu menuReportes = new PanelSubmenu("Reportes", "/res/iconos/reportes.png");
    private final PanelSubmenu menuApartados = new PanelSubmenu("Apartados", "/res/iconos/apartados.png");
    private final PanelSubmenu menuConsultar = new PanelSubmenu("Consultar", "/res/iconos/consultar.png");    
        
    private final ItemSubmenu itemCancelarVenta = new ItemSubmenu("Cancelar", "/res/iconos/cancelar.png"){
        @Override
        public void click() {
            cancelarVenta();
        }        
    };
    private final ItemSubmenu itemCerrarSesion = new ItemSubmenu("Cerrar sesión", "/res/iconos/cerrar sesion.png"){
        @Override
        public void click() {
            setVisible(false);
            dispose();
            
            new Login().setVisible(true);
        }        
    };
    private final ItemSubmenu itemAjustes = new ItemSubmenu("Ajustes", "/res/iconos/ajustes.png"){
        @Override
        public void click() {
            new Ajustes(getThis()).setVisible(true);
        }        
    };
    private final ItemSubmenu itemSalir = new ItemSubmenu("Salir", "/res/iconos/salir.png"){
        @Override
        public void click() {
            setVisible(false);
            dispose();     
            System.exit(0);
        }        
    };
    private final ItemSubmenu itemNuevoProducto = new ItemSubmenu("Nuevo", "/res/iconos/nuevo.png"){
        @Override
        public void click() {
            DialogoProducto.nuevo(getThis());            
        }        
    };
    private final ItemSubmenu itemModificarProducto = new ItemSubmenu("Modificar", "/res/iconos/modificar.png") {

        @Override
        public void click() {
//            DialogoProducto.modificar(getThis());
        }
    };
    private final ItemSubmenu itemNuevaCategoria = new ItemSubmenu("Nuevo", "/res/iconos/nuevo.png"){
        @Override
        public void click() {
//            Categorias.nuevo(getThis());
        }        
    };
    private final ItemSubmenu itemNuevoCliente = new ItemSubmenu("Nuevo", "/res/iconos/nuevo.png") {

        @Override
        public void click() {
//            Clientes.nuevo(null);
        }
    };
    private final ItemSubmenu itemModificarCliente = new ItemSubmenu("Modificar", "/res/iconos/modificar.png") {

        @Override
        public void click() {
//            int id = BuscarCliente.mostrar(getThis(), "Seleccione el usuario a modificar");
//            
//            if(id == 0)
//                return;
//            
//            Clientes.mostrar(getThis(), id);
        }
    };
    private final ItemSubmenu itemNuevoUsuario = new ItemSubmenu("Nuevo", "/res/iconos/nuevo.png") {
        @Override
        public void click() {
//            DialogoUsuario.nuevo(getThis(), idUsuario, nivelUsuario);
        }
    };
    private final ItemSubmenu itemModificarUsuario = new ItemSubmenu("Modificar", "/res/iconos/modificar.png") {
        @Override
        public void click() {
//            DialogoUsuario.modificar(getThis(), idUsuario, nivelUsuario);
        }
    };
    private final ItemSubmenu itemModificarUsuarioActual = new ItemSubmenu("Modificar Actual", "/res/iconos/usuario actual.png") {
        @Override
        public void click() {
//            DialogoUsuario.modificarUsuarioActual(getThis(), idUsuario, nivelUsuario);
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
    private final ItemSubmenu itemInventario = new ItemSubmenu("Inventario", "/res/iconos/existencia.png") {
        @Override
        public void click() {
            Inventario inventario = new Inventario();
            inventario.setVisible(true);
        }
    };
    private final ItemSubmenu itemCorteCaja = new ItemSubmenu("Corte de caja", "/res/iconos/corte de caja.png") {
        @Override
        public void click() {
            new CorteCaja().setVisible(true);
        }
    };
    private final ItemSubmenu itemReporteConsultas = new ItemSubmenu("Consultas", "/res/iconos/consultar.png") {
        @Override
        public void click() {
//            new Consultas().setVisible(true);
        }
    };
    private final ItemSubmenu itemApartado = new ItemSubmenu("Consultar", "/res/iconos/consultar.png") {
        @Override
        public void click() {
//            VentanaApartado apartado = new VentanaApartado(idUsuario);
//            apartado.setVisible(true);
        }
    };
    private final ItemSubmenu itemPrecio = new ItemSubmenu("Precio", "/res/iconos/precio.png") {
        @Override
        public void click() {
//            ConsultarProducto.mostrar(getThis(), idUsuario);
        }
    };
    private final ItemSubmenu itemExterno = new ItemSubmenu("Externo", "/res/iconos/existencia.png") {
        @Override
        public void click() {
//            JOptionPane.showMessageDialog(this, "Función aún no habilitada");
        }
    };    
    private final ItemSubmenu itemTransaccion = new ItemSubmenu("Transacciones", "/res/iconos/transacciones.png") {
        @Override
        public void click() {
//            ConsultarTransaccion.mostrar(getThis(), idUsuario);
        }
    };    
    private final ItemSubmenu itemNuevoIngreso = new ItemSubmenu("Nuevo ingreso", "/res/iconos/ingresos.png") {
        @Override
        public void click() {
            Ingreso.nuevo(getThis(), idUsuario);
        }
    };    
    private final ItemSubmenu itemNuevoEgreso = new ItemSubmenu("Nuevo egreso", "/res/iconos/egresos.png") {
        @Override
        public void click() {
            Egreso.nuevo(getThis(), idUsuario);
        }
    };    
    private final ItemSubmenu itemNuevaEntrada = new ItemSubmenu("Entrada de mercancía", "/res/iconos/compras.png") {
        @Override
        public void click() {
            EntradaMercancia.nuevo(getThis(), idUsuario);
        }
    };    
    
    
    //</editor-fold>
        
    private final Font fuenteTabla = new Font("Arial", Font.BOLD, 15);    
    
    private float porcentajeApartado = 0.3f;
    
    private int idUsuario = 1;
    private int nivelUsuario;
    private int folioVentaActual = 0;
    private int idClienteActual = 0;
    
    private boolean cajaAbierta = false;
    
    private ArrayList<Producto> listaProductos = new ArrayList();
    
    private final DefaultTableModel modeloVenta = new DefaultTableModel(
            new Object[]{"Clave", "Producto", "Precio"},0){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
    
    private float total = 0;
    
    public Main(int idUsuario, int nivelUsuario){
        panelPrincipal = (JPanel) getContentPane();                
                       
        this.idUsuario = idUsuario; 
        this.nivelUsuario = nivelUsuario;   
        
        init();                                             
        
        setVisible(true);
        setResizable(false);
        
        folioVentaActual = createVenta();        
    }
    
    private void init(){
        setMenu();
        setVenta();
        setDerecha();
        
        panelPrincipal.setBackground(Configuracion.colorFondo);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelPrincipal.setLayout(new BorderLayout(15, 15));
        panelPrincipal.add(scrollMenu, BorderLayout.WEST);
        panelPrincipal.add(panelVenta, BorderLayout.CENTER);
        panelPrincipal.add(panelDerecho, BorderLayout.EAST);
        
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        
    }
    
    private void setMenu(){
        
        PanelSubmenu.setFondo(Configuracion.colorMenu);
        
        scrollMenu.getViewport().setBackground(Configuracion.colorPaneles);
        panelMenu.setOpaque(false);
        
        panelMenu.setLayout(new ModifiedFlowLayout()); 
        
        menuProductos.setOpaque(false);
        menuProductos.setBackground(Color.WHITE);
        menuUsuarios.setOpaque(false);
        menuUsuarios.setBackground(Color.WHITE);         
        
        scrollMenu.setViewportView(panelMenu);        
        scrollMenu.setPreferredSize(new Dimension(100, 0));
        scrollMenu.getVerticalScrollBar().setUnitIncrement(15);
        
        panelMenu.add(menuArchivo);
        panelMenu.add(menuConsultar);
        panelMenu.add(menuTransacciones);        
        if(nivelUsuario < 2)
            panelMenu.add(menuProductos);
        if(nivelUsuario < 2)
            panelMenu.add(menuCategorias);        
        panelMenu.add(menuClientes);
                        
        panelMenu.add(menuReportes);
        panelMenu.add(menuApartados);  
        if(nivelUsuario < 2)
            panelMenu.add(menuUsuarios);
        
        menuArchivo.addItem(itemCancelarVenta);
        menuArchivo.addItem(itemCerrarSesion);
        if(nivelUsuario < 2){
            menuArchivo.addItem(itemAjustes);        
        }
        menuArchivo.addItem(itemSalir);
        menuProductos.addItem(itemNuevoProducto);
        menuProductos.addItem(itemModificarProducto);
        menuCategorias.addItem(itemNuevaCategoria);
        menuClientes.addItem(itemNuevoCliente);
        menuClientes.addItem(itemModificarCliente);
        menuUsuarios.addItem(itemNuevoUsuario);
        menuUsuarios.addItem(itemModificarUsuario);
        menuUsuarios.addItem(itemModificarUsuarioActual);
        menuReportes.addItem(itemCorteCaja);
        if(nivelUsuario < 2){
            menuReportes.addItem(itemInventario);        
            menuReportes.addItem(itemReporteConsultas);
            menuReportes.addItem(itemEgresos);
            menuReportes.addItem(itemIngresos);
            menuReportes.addItem(itemCompras);
            menuReportes.addItem(itemVentas);        
        }
        menuApartados.addItem(itemApartado);
        menuTransacciones.addItem(itemNuevoIngreso);
        menuTransacciones.addItem(itemNuevoEgreso);
        if(nivelUsuario < 2)
            menuTransacciones.addItem(itemNuevaEntrada);
        menuConsultar.addItem(itemPrecio);
        menuConsultar.addItem(itemExterno);
        menuConsultar.addItem(itemTransaccion);
    }
    
    private void setVenta(){
        
        panelVenta.setBackground(Configuracion.colorPaneles);
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
        labelLogo.setBackground(Color.WHITE);
        labelLogo.setOpaque(true);  
        labelLogo.setHorizontalAlignment(JLabel.CENTER);
//        labelLogo.setIcon(new ImageIcon(new ImageIcon(
//                Configuracion.rutaLogo).getImage().
//                getScaledInstance((int)(Toolkit.getDefaultToolkit().getScreenSize().width / 3), 150, Image.SCALE_DEFAULT)));
        labelLogo.setIcon(new ImageIcon(new ImageIcon(Login.class.getResource("/res/deac.png"))
                .getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH)));
        
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
        txtClave.setPlaceholder("Clave de producto");
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
        if(checkApertura(Fecha.hoy())){
            panelListaVenta.add(txtClave, BorderLayout.SOUTH);
            btnEfectivo.setEnabled(true);
            btnApartado.setEnabled(true);
            btnTarjeta.setEnabled(false);
        }else{
            panelListaVenta.add(btnAperturar, BorderLayout.SOUTH);
            btnEfectivo.setEnabled(false);
            btnApartado.setEnabled(false);
            btnTarjeta.setEnabled(false);
        }
        btnAperturar.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent evt){
                float monto = Apertura.mostrar(getThis());
                
                if(registrarAperturaDeCaja(monto)){
                    JOptionPane.showMessageDialog(
                            getThis(),
                            "Apertura registrada correctamente");
                    panelListaVenta.remove(btnAperturar);
                    panelListaVenta.add(txtClave, BorderLayout.SOUTH);
                    panelListaVenta.updateUI();
                    btnEfectivo.setEnabled(true);
                    btnApartado.setEnabled(true);
                    btnTarjeta.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(
                            getThis(),
                            "No se pudo registrar apertura");
                }
            }
            
        });
                        
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
        txtTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));        
        txtTotal.updateUI();
        setTotal(total);
        
        panelFormasDePago.setOpaque(false);
        panelFormasDePago.setLayout(new GridLayout(1, 3, 5, 5));
        panelFormasDePago.add(btnEfectivo);
        panelFormasDePago.add(btnApartado);
        panelFormasDePago.add(btnTarjeta);
        
        btnEfectivo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {                
                if(!listaProductos.isEmpty())
                    insertCompraContado();
            }   
            
        });
        btnApartado.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {                
                if(!listaProductos.isEmpty())   
                    insertCompraApartado();
            }
            
        });
    }                        
    
    private void setDerecha(){
       
        panelDerecho.setBackground(Configuracion.colorPaneles);
        panelDerecho.setLayout(new BorderLayout(10, 10));
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDerecho.add(panelPublicidad, BorderLayout.NORTH);
        panelDerecho.add(panelBotones, BorderLayout.CENTER);
        
        panelPublicidad.setPreferredSize(new Dimension(700, 500));
        panelPublicidad.setOpaque(false);
        panelPublicidad.setLayout(new BorderLayout());
        panelPublicidad.add(labelPublicidad, BorderLayout.CENTER);
        
//            labelPublicidad.setIcon(new ImageIcon(new ImageIcon(
//                    Main.class.getResource("/res/fenix.png")).getImage().
//                    getScaledInstance(700, 500, Image.SCALE_SMOOTH))
//            );
        labelPublicidad.setOpaque(true);
        labelPublicidad.setBackground(Color.WHITE);
                   
        panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelBotones.setOpaque(false);        
    }
    
    private int recuperarVenta(){
        String sql = "SELECT * FROM DETALLES_VENTAS_PENDIENTES";
        int folioVenta = 0;
        
        try {                                    
            ResultSet consulta = SQLConnection.select(sql);
            
            if(consulta.next()){
                folioVenta = consulta.getInt("FOLIO");
                idClienteActual = consulta.getInt("ID_CLIENTE");                                
                
                String cargarVenta = "SELECT * FROM DETALLE_VENTA "
                        + "WHERE FOLIO_VENTA=" + folioVenta;
                
                consulta = SQLConnection.select(cargarVenta);
                
                while(consulta.next()){
                    Producto temp = new Producto(
                            consulta.getString("CLAVE"),
                            consulta.getString("NOMBRE"),
                            consulta.getFloat("PRECIO"),
                            consulta.getInt("ASIGNACION")
                    );
                    
                    modeloVenta.addRow(new Object[]{
                            temp.clave,
                            temp.nombre,
                            temp.precio
                    });
                    
                    listaProductos.add(temp);
                    
                    total += consulta.getFloat("PRECIO");
                }
                setTotal(total);
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
                + "ID_CLIENTE, "
                + "TOTAL)"
                + "VALUES("
                + idUsuario + ","
                + "'Pendiente',"
                + "(SELECT ID FROM CLIENTES WHERE NOMBRE='PUBLICO' AND APELLIDO_PATERNO='GENERAL'),"
                + 0 + ")";   
        
        idClienteActual = 0;
        
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
        if(valido){
            SQLConnection.commit();
            modeloVenta.setRowCount(0);
            listaProductos.clear();
            total = 0;
            setTotal(total);
        }else 
            SQLConnection.rollback();
        return folioVenta;
    }
    
    private void addProducto(){
        Producto temp = getProducto(txtClave.getText().trim());
        int idAsignacion = 0;
        
        if (temp == null) {
            return;
        }       
                
        idAsignacion = insertProductoDB(temp);
        if(idAsignacion == 0)
            return;
        
        temp.idAsignacion = idAsignacion;
        
        modeloVenta.addRow(new Object[]{
            temp.clave,
            temp.nombre,
            temp.precio
        });
        
        listaProductos.add(temp);
        
        txtClave.setText("");        

        total += temp.precio;
        setTotal(total);
        
    }
    
    private int insertProductoDB(Producto nuevo){
        int idASignacion = 0;
        
        SQLConnection.startTransaction();
        
        String sql = "INSERT INTO VENTAS_PRODUCTOS("
                + "FOLIO_VENTA, "
                + "CLAVE_PRODUCTO, "
                + "PRECIO) "
                + "VALUES("
                + folioVentaActual + ","
                + "'" + nuevo.clave + "',"
                + nuevo.precio + ")";
        String updateTotal = "UPDATE VENTAS SET "
                + "TOTAL=" + total + " "
                + "WHERE FOLIO=" + folioVentaActual;
        
        SQLConnection.startTransaction();
        if(SQLConnection.update(sql) && SQLConnection.update(updateTotal)){
            try {
                String selectID = "SELECT MAX(ID_ASIGNACION) AS ID FROM VENTAS_PRODUCTOS;";
                
                ResultSet consulta = SQLConnection.select(selectID);
                
                consulta.next();
                
                idASignacion = consulta.getInt("ID");
                
                SQLConnection.commit();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo agregar el producto");            
        }
        return idASignacion;                
    }
    
    private void insertCompraContado(){
        int folioVenta;
        int folioIngreso;
        boolean valido = false;
                
        SQLConnection.startTransaction();

        idClienteActual = BuscarCliente.mostrar(
                this, 
                "Seleccione el cliente que compra");        
        if(idClienteActual == 0)
            return;
        
        folioIngreso = Ingreso.nuevoParaVenta(getThis(), idUsuario, folioVentaActual, total);
        
        if (folioIngreso != 0) {
                        
            if(folioVentaActual != 0){            
                String sqlPago = "INSERT INTO PAGOS_DE_CONTADO("
                        + "FOLIO_VENTA, "
                        + "FOLIO_INGRESO) "
                        + "VALUES("
                        + folioVentaActual + ","
                        + folioIngreso + ")";       
                
                boolean existenciasActualizadas = true;                           
                String updateExistencia = "UPDATE PRODUCTOS SET EXISTENCIA=EXISTENCIA-1 "
                        + "WHERE CLAVE='";
                for(int i = 0 ; i < listaProductos.size() && existenciasActualizadas ; i++){
                    existenciasActualizadas = SQLConnection.update(
                            updateExistencia + listaProductos.get(i).clave + "'");
                }
                
                if(SQLConnection.update(sqlPago) 
                        && updateVenta("Efectivo") 
                        && existenciasActualizadas)
                    valido = true;
            }
        }
        if(valido){
            SQLConnection.commit();
            JOptionPane.showMessageDialog(
                    this,
                    "Compra registrada correctamente"
            );            
            folioVentaActual = createVenta();
        }else{
            SQLConnection.rollback();
            JOptionPane.showMessageDialog(
                    this,
                    "No fue posible realizar la compra"
            );
        }
    }                
    
    private void insertCompraApartado(){
    
        boolean valido = true;
        boolean apartadoIndividual = true;
        
        String individual = "Individual";
        String grupal = "Grupal";
        
        Object tipo = JOptionPane.showInputDialog(
                this,
                "Seleccione el tipo de apartado",
                "Tipo de apartado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{individual, grupal},
                individual);
        
        if(tipo == null)
            return;
        else if (tipo == individual){
        
            SQLConnection.startTransaction();                
        
            idClienteActual = BuscarCliente.mostrar(
                    this, 
                    "Seleccione el cliente que aparta");        
            if(idClienteActual == 0)
                return;
            
            for(int i = 0 ; i < listaProductos.size() && valido ; i++){
                boolean apartadoCorrecto = createApartado(
                        listaProductos.get(i), 
                        idClienteActual);
                
                valido = valido && apartadoCorrecto;            
            }
            
            updateVenta("Apartado");
            
            if(valido){ 
                SQLConnection.commit();
                JOptionPane.showMessageDialog(
                        this,
                        "Venta realizada correctamente"
                );
                
                folioVentaActual = createVenta();            
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible realizar la compra"
                );
                SQLConnection.rollback();
            }
        }else if(tipo == grupal){
            SQLConnection.startTransaction();                
        
            idClienteActual = BuscarCliente.mostrar(
                    this, 
                    "Seleccione el cliente que aparta");        
            if(idClienteActual == 0)
                return;
                        
            boolean apartadoCorrecto = createApartado(
                        listaProductos,
                        idClienteActual);                            
            
            updateVenta("Apartado");
            
            if(apartadoCorrecto){ 
                SQLConnection.commit();
                JOptionPane.showMessageDialog(
                        this,
                        "Venta realizada correctamente"
                );
                
                folioVentaActual = createVenta();            
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "No fue posible realizar la compra"
                );
                SQLConnection.rollback();
            }
        }
    }
    
    private boolean createApartado(Producto ing, int idCliente){
        try {            
            int folioApartado = 0;
            int folioIngreso = 0;
            
            String sqlBase = "INSERT INTO APARTADOS("                    
                    + "ID_CLIENTE,"
                    + "TOTAL,"
                    + "SALDO_PENDIENTE)"
                    + "VALUES("                    
                    + idCliente + ","
                    + ing.precio + ","
                    + ing.precio + ")";  //Pendiente obtener el enganche
            String getFolio = "SELECT MAX(FOLIO) AS FOLIO FROM APARTADOS";            
            
            if(!SQLConnection.update(sqlBase))
                return false;
            
            ResultSet consulta = SQLConnection.select(getFolio);
            consulta.next();
            folioApartado = consulta.getInt("FOLIO");
            
            String sqlApartadoProductos = 
                    "INSERT INTO APARTADOS_ASIGNACIONES(FOLIO_APARTADO, ID_ASIGNACION) "
                    + "VALUES(" + folioApartado + ", " + ing.idAsignacion + ")";
            if(!SQLConnection.update(sqlApartadoProductos))
                return false;
            
            folioIngreso = Ingreso.nuevoParaEnganche(
                    this,
                    idUsuario,
                    folioApartado,
                    ing.precio * porcentajeApartado,
                    ing.nombre);
            if(folioIngreso == 0)
                return false;
            
            String getMonto = "SELECT MONTO FROM INGRESOS WHERE FOLIO=" + folioIngreso;
            consulta = SQLConnection.select(getMonto);
            float monto = 0;
            if(consulta.next())
                monto = consulta.getFloat("MONTO");                        
            
            String updateSaldo = "UPDATE APARTADOS "
                    + "SET SALDO_PENDIENTE=SALDO_PENDIENTE-" + monto + " "
                    + "WHERE FOLIO=" + folioApartado;                    
            
            String insertAbono = "INSERT INTO ABONOS("
                    + "FOLIO_TICKET, "
                    + "FOLIO_APARTADO)"
                    + "VALUES("                    
                    + folioIngreso + ","
                    + folioApartado + ")";
            if(!SQLConnection.update(insertAbono) || !SQLConnection.update(updateSaldo)) 
                return false;                                            
                    
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean createApartado(ArrayList<Producto> ing, int idCliente){
        try {            
            int folioApartado = 0;
            int folioIngreso = 0;
            
            float total = 0;
            for(int i = 0 ; i < ing.size() ; i++){
                total += ing.get(i).precio;
            }
            
            String sqlBase = "INSERT INTO APARTADOS("                    
                    + "ID_CLIENTE,"
                    + "TOTAL,"
                    + "SALDO_PENDIENTE)"
                    + "VALUES("                    
                    + idCliente + ","
                    + total + ","
                    + total + ")";  //Pendiente obtener el enganche            
            String getFolio = "SELECT MAX(FOLIO) AS FOLIO FROM APARTADOS";
            String getEnganche = "SELECT MONTO FROM INGRESOS ";
            
            if(!SQLConnection.update(sqlBase))
                return false;
            
            ResultSet consulta = SQLConnection.select(getFolio);
            consulta.next();
            folioApartado = consulta.getInt("FOLIO");              
            
            String sqlApartadoProductos = 
                    "INSERT INTO APARTADOS_ASIGNACIONES(FOLIO_APARTADO, ID_ASIGNACION) "
                    + "SELECT " + folioApartado + ", ID_ASIGNACION "
                    + "FROM VENTAS_PRODUCTOS WHERE FOLIO_VENTA=" + folioVentaActual;
            if(!SQLConnection.update(sqlApartadoProductos))
                return false;
            
            folioIngreso = Ingreso.nuevoParaEnganche(
                    this,
                    idUsuario,
                    folioApartado,
                    total * porcentajeApartado,
                    "");
            if(folioIngreso == 0)
                return false;
            
            String getMonto = "SELECT MONTO FROM INGRESOS WHERE FOLIO=" + folioIngreso;
            consulta = SQLConnection.select(getMonto);
            float monto = 0;
            if(consulta.next())
                monto = consulta.getFloat("MONTO");
            String updateSaldo = "UPDATE APARTADOS "
                    + "SET SALDO_PENDIENTE=SALDO_PENDIENTE-" + monto + " "
                    + "WHERE FOLIO=" + folioApartado; 
                        
            System.out.println(updateSaldo);
            
            String insertAbono = "INSERT INTO ABONOS("
                    + "FOLIO_TICKET, "
                    + "FOLIO_APARTADO)"
                    + "VALUES("                    
                    + folioIngreso + ","
                    + folioApartado + ")";
            if(!SQLConnection.update(insertAbono) || !SQLConnection.update(updateSaldo)) 
                return false;                                            
                    
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;       
    }
    
    private boolean updateVenta(String formaDePago){
        String sql = "UPDATE VENTAS SET "
                + "FORMA_PAGO='" + formaDePago + "',"
                + "ID_USUARIO=" + idUsuario + ", "
                + "ID_CLIENTE=" + idClienteActual + ", "
                + "FECHA=NOW(), "
                + "TOTAL=" + total + " "
                + "WHERE FOLIO=" + folioVentaActual;
        String deleteVentaPendiente = "DELETE FROM VENTAS_PENDIENTES "
                + "WHERE FOLIO_VENTA=" + folioVentaActual;        
        
        return SQLConnection.update(sql) && SQLConnection.update(deleteVentaPendiente);
    }
    
    private void cancelarVenta(){
        
        if(!cajaAbierta)
            return;
        
        String sql = "UPDATE VENTAS SET CANCELADO=TRUE WHERE FOLIO=" + folioVentaActual;
        
        SQLConnection.startTransaction();
        if(updateVenta("Cancelado")){            
            if(SQLConnection.update(sql)){
                JOptionPane.showMessageDialog(
                        this, 
                        "Venta cancelada");
                SQLConnection.commit();
                folioVentaActual = createVenta();
                return;
            }
        }
        JOptionPane.showMessageDialog(
                        this, 
                        "No fue posible realizar la cancelación");
        SQLConnection.rollback();
        
    }
    
    private boolean checkApertura(String date){
        try {
            String selectApertura = "SELECT * FROM APERTURAS_DE_CAJA WHERE FECHA='" + date + "'";
            
            ResultSet consulta = SQLConnection.select(selectApertura);
            
            cajaAbierta = consulta.next();
            menuTransacciones.setActive(cajaAbierta);
            return cajaAbierta;
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean registrarAperturaDeCaja(Float monto){
                        
        String sql = "INSERT INTO APERTURAS_DE_CAJA"
                + "(FECHA, MONTO) "
                + "VALUES"
                + "(NOW(), " + monto + ")";
        
        boolean registroCorrecto = SQLConnection.update(sql);       
        
        menuTransacciones.setActive(registroCorrecto);
        cajaAbierta = registroCorrecto;
        return registroCorrecto;
    }

    private void setTotal(float total){
        this.total = total;
        txtTotal.setText("$" + total);
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
    
    public void cargarConfiguracion(){
        
    }
    
}