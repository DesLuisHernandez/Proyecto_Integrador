package main.proyecto.integrador.Presentacion;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Luis Hernández
 */
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import main.proyecto.integrador.Datos.Apartamentos;
import main.proyecto.integrador.Datos.Cliente;

import main.proyecto.integrador.Datos.Usuarios;
import main.proyecto.integrador.Datos.Conexion;
import main.proyecto.integrador.Datos.Pago;
import main.proyecto.integrador.Datos.Proyectos;
import main.proyecto.integrador.Datos.Torres;
import main.proyecto.integrador.Datos.UsuariosDAO;
import main.proyecto.integrador.Datos.Venta;
import main.proyecto.integrador.Logica.GestionTorres;
import main.proyecto.integrador.Logica.gestionApartamentos;
import main.proyecto.integrador.Logica.gestionProyectos;
import main.proyecto.integrador.Logica.gestionarClientes;
import main.proyecto.integrador.Logica.gestionarPagos;
import main.proyecto.integrador.Logica.gestionarUsuario;
import main.proyecto.integrador.Logica.gestionarVenta;

public class Principal extends javax.swing.JFrame {
    /**
     * Creates new form Principal
     */
    CardLayout cardLayout;
    private String rol; // Atributo para guardar el rol del usuario

    public Principal(String rol) throws HeadlessException {
        initComponents();
        cardLayout =(CardLayout)(jPanelPrincipal.getLayout()); 
        this.rol = rol;
        jLNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        jLNombreUsuario.setText(rol);
    }
        
    public Principal() {
        //initComponents();
        //cardLayout =(CardLayout)(jPanelPrincipal.getLayout());    
    }
    
    public void listarTablaUsuarios() {
        try {
            // Inicializa el modelo de tabla
            MiModeloTabla modelo = new MiModeloTabla(); // Usa el modelo personalizado
            modelo.addColumn("Cédula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Email");
            modelo.addColumn("Direccion");

            tableUsuarios.setModel(modelo);
            
            modelo.setRowCount(0); // Limpia la tabla antes de añadir nuevos datos

            // Inicializa el servicio y obtiene la lista de usuarios
            gestionarUsuario usuarioService = new gestionarUsuario();
            List<Usuarios> usuarios = usuarioService.listarUsuarios();

            // Llena la tabla con los datos de usuarios
            for (Usuarios usuario : usuarios) {
                Object[] fila = { usuario.getCedula(), usuario.getNombre(), 
                                usuario.getApellido(), usuario.getEmail(), usuario.getDireccion()};
                modelo.addRow(fila);
            }
        } catch (Exception ex) { // Manejo de excepciones generales
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al actualizar tabla de usuarios", ex);
        }
    }
     
    public void listarTablaVentas() {
        DefaultTableModel modelo = (DefaultTableModel) tVentas.getModel();
        modelo.setRowCount(0);
        try {
            // Inicializa el servicio y obtiene la lista de ventas
            gestionarVenta ventaService = new gestionarVenta();
            List<Venta> ventas = ventaService.obtenerVentas();

            // Llena la tabla con los datos de usuarios
            // Rellena la tabla con la lista de ventas
            for (Venta venta : ventas) {
                Object[] fila = {
                venta.getMatricula(),
                venta.getPrecio_Total(),
                venta.getCantidad_Cuotas(),
                venta.getIntereses(),
                venta.getFecha_esctritura_venta(),
                venta.getFecha_venta(),
                venta.getValorSubsidio(),
                venta.getId_Apto(),
                venta.getCedula_Cliente(),
                venta.getId_Usuario()
                };
                modelo.addRow(fila);
            }
        } catch (Exception ex) { // Manejo de excepciones generales
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al actualizar tabla de ventas", ex);
        }
    }
     
     public void listarTablaClientes() {
        DefaultTableModel modelo = (DefaultTableModel) tClientes.getModel();
        modelo.setRowCount(0);
        try {
            // Inicializa el servicio y obtiene la lista de clientes
            gestionarClientes clienteService = new gestionarClientes();
            List<Cliente> clientes = clienteService.obtenerCliente();

            // Llena la tabla con los datos de usuarios
            // Rellena la tabla con la lista de ventas
            for (Cliente cliente : clientes) {
                Object[] fila = {
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getSisben(),
                cliente.getSubsi_minis()
                };
                modelo.addRow(fila);
            }
            // Configura el ComboBox para el campo Sisben
            JComboBox<String> comboBoxSisben = new JComboBox<>(new String[]{"S", "N"});
            tClientes.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBoxSisben));
            
            // Configura el ComboBox para el campo Sisben
            JComboBox<String> comboBoxsub = new JComboBox<>(new String[]{"S", "N"});
            tClientes.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(comboBoxsub));
            
        } catch (Exception ex) { // Manejo de excepciones generales
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al actualizar tabla de clientes", ex);
        }
    }
     
    public void listarTablaPagos() {
        DefaultTableModel modelo = (DefaultTableModel) tPagos.getModel();
        modelo.setRowCount(0);
        try {
            // Inicializa el servicio y obtiene la lista de ventas
            gestionarPagos PagosService = new gestionarPagos();
            List<Pago> pagos = PagosService.obtenerPago();

            // Llena la tabla con los datos de usuarios
            // Rellena la tabla con la lista de ventas
            for (Pago pago : pagos) {
                Object[] fila = {
                pago.getValorPago(),
                pago.getFechaPago(),
                pago.getCedula_cliente(),
                pago.getMatricula_venta(),
                pago.getId_usuario()
                };
                modelo.addRow(fila);
            }
        } catch (Exception ex) { // Manejo de excepciones generales
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al actualizar tabla de pagos", ex);
        }
    }
    
    public void listarTablaProyectos() {
        DefaultTableModel modelo = (DefaultTableModel) tProyectos.getModel();
        modelo.setRowCount(0);
        try {
            // Inicializa el servicio y obtiene la lista de Proyectos
            gestionProyectos ProyectosService = new gestionProyectos();
            List<Proyectos> proyectos = ProyectosService.obtenerProyectos();

            // Llena la tabla con los datos de usuarios
            // Rellena la tabla con la lista de ventas
            for (Proyectos proyecto : proyectos) {
                Object[] fila = {
                proyecto.getNombre(),
                proyecto.getCantTorres(),
                proyecto.getIdUsuario()
                };
                modelo.addRow(fila);
            }
        } catch (Exception ex) { // Manejo de excepciones generales
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al actualizar tabla de Proyectos", ex);
        }
    }
    
    public void listarTablaTorres() {
        DefaultTableModel modelo = (DefaultTableModel) tTorres.getModel();
        modelo.setRowCount(0);
        try {
            // Inicializa el servicio y obtiene la lista de Torres
            GestionTorres TorresService = new GestionTorres();
            List<Torres> torres = TorresService.obtenerTorres();

            // Llena la tabla con los datos de usuarios
            // Rellena la tabla con la lista de ventas
            for (Torres torre : torres) {
                Object[] fila = {
                torre.getNumero_torre(),
                torre.getCantidadAptos(),
                torre.getId_Proyecto()
                };
                modelo.addRow(fila);
            }
        } catch (Exception ex) { // Manejo de excepciones generales
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al actualizar tabla de Torres", ex);
        }
    }
    
    public void listarTablaApartamentos() {
        DefaultTableModel modelo = (DefaultTableModel) tAptos.getModel();
        modelo.setRowCount(0);
        try {
            // Inicializa el servicio y obtiene la lista de Torres
            gestionApartamentos aptosService = new gestionApartamentos();
            List<Apartamentos> aptos = aptosService.obtenerApto();

            // Llena la tabla con los datos de usuarios
            // Rellena la tabla con la lista de ventas
            for (Apartamentos apto : aptos) {
                Object[] fila = {
                apto.getNumApto(),
                apto.getTipoLocal(),
                apto.getTipoApto(),
                apto.getTipoGaraje(),
                apto.getArea(),
                apto.getIdTorre(),
                };
                modelo.addRow(fila);
            }
        } catch (Exception ex) { // Manejo de excepciones generales
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al actualizar tabla de Apartamentos", ex);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanelMenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLNombreUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbRegistrarCliente = new javax.swing.JButton();
        jbPagos = new javax.swing.JButton();
        jbVentas = new javax.swing.JButton();
        jbUsuarios = new javax.swing.JButton();
        jbProyectos = new javax.swing.JButton();
        jPanelPrincipal = new javax.swing.JPanel();
        pclProyectos = new javax.swing.JPanel();
        pProyectos = new javax.swing.JPanel();
        bAgregarProyecto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        pApartamentos = new javax.swing.JPanel();
        bAgregarTorre = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tProyectos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tTorres = new javax.swing.JTable();
        pApartamentos1 = new javax.swing.JPanel();
        bAgregarApto = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tAptos = new javax.swing.JTable();
        pclUsuarios = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bGuardar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        pclTyA = new javax.swing.JPanel();
        pclVentas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tVentas = new javax.swing.JTable();
        pclPagos = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tPagos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        bAgregarPago = new javax.swing.JButton();
        pclReportes = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bAgregarCliente = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tClientes = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane2.setDividerSize(0);

        jPanelMenu.setBackground(new java.awt.Color(255, 153, 0));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Construct MAX S.A");
        jPanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
        jPanelMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 120, 160, 10));
        jPanelMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 256, 169, 10));
        jPanelMenu.add(jLNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 230, 112, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/file.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 79, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/avatar.png"))); // NOI18N
        jPanelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 80, 75));

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/cerrar-sesion.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.setContentAreaFilled(false);
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 470, 90, -1));

        jbRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/analitica.png"))); // NOI18N
        jbRegistrarCliente.setText("Registrar cliente");
        jbRegistrarCliente.setContentAreaFilled(false);
        jbRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarClienteActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 430, 150, -1));

        jbPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/dinero.png"))); // NOI18N
        jbPagos.setText("Generar pagos");
        jbPagos.setContentAreaFilled(false);
        jbPagos.setMargin(new java.awt.Insets(2, 15, 3, 14));
        jbPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagosActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 390, 170, -1));

        jbVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/contrato.png"))); // NOI18N
        jbVentas.setText("Gestionar Venta");
        jbVentas.setContentAreaFilled(false);
        jbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVentasActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 350, 170, -1));

        jbUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/usuario.png"))); // NOI18N
        jbUsuarios.setContentAreaFilled(false);
        jbUsuarios.setLabel("Gestionar usuario");
        jbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsuariosActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 310, 160, -1));

        jbProyectos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/proyecto.png"))); // NOI18N
        jbProyectos.setContentAreaFilled(false);
        jbProyectos.setLabel("Gestionar proyecto");
        jbProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProyectosActionPerformed(evt);
            }
        });
        jPanelMenu.add(jbProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 270, 170, -1));

        jSplitPane2.setLeftComponent(jPanelMenu);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new java.awt.CardLayout());

        pclProyectos.setBackground(new java.awt.Color(255, 255, 255));

        pProyectos.setBackground(new java.awt.Color(204, 255, 255));

        bAgregarProyecto.setText("Agregar");
        bAgregarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarProyectoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Proyectos");

        javax.swing.GroupLayout pProyectosLayout = new javax.swing.GroupLayout(pProyectos);
        pProyectos.setLayout(pProyectosLayout);
        pProyectosLayout.setHorizontalGroup(
            pProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pProyectosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(154, 154, 154)
                .addComponent(bAgregarProyecto)
                .addGap(10, 10, 10))
        );
        pProyectosLayout.setVerticalGroup(
            pProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pProyectosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregarProyecto)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        pApartamentos.setBackground(new java.awt.Color(204, 255, 255));

        bAgregarTorre.setText("Agregar");
        bAgregarTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarTorreActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Torres");

        javax.swing.GroupLayout pApartamentosLayout = new javax.swing.GroupLayout(pApartamentos);
        pApartamentos.setLayout(pApartamentosLayout);
        pApartamentosLayout.setHorizontalGroup(
            pApartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pApartamentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(169, 169, 169)
                .addComponent(bAgregarTorre)
                .addGap(11, 11, 11))
        );
        pApartamentosLayout.setVerticalGroup(
            pApartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pApartamentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pApartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregarTorre)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        tProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad Torres", "Usuario"
            }
        ));
        jScrollPane2.setViewportView(tProyectos);

        tTorres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero", "Cantidad Apartamentos", "Proyecto"
            }
        ));
        jScrollPane4.setViewportView(tTorres);

        pApartamentos1.setBackground(new java.awt.Color(204, 255, 255));

        bAgregarApto.setText("Agregar");
        bAgregarApto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarAptoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Apartamentos");

        javax.swing.GroupLayout pApartamentos1Layout = new javax.swing.GroupLayout(pApartamentos1);
        pApartamentos1.setLayout(pApartamentos1Layout);
        pApartamentos1Layout.setHorizontalGroup(
            pApartamentos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pApartamentos1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(126, 126, 126)
                .addComponent(bAgregarApto)
                .addGap(11, 11, 11))
        );
        pApartamentos1Layout.setVerticalGroup(
            pApartamentos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pApartamentos1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pApartamentos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregarApto)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        tAptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Tipo Local", "Tipo Apartamento", "Tipo Garaje", "Area", "Torre"
            }
        ));
        jScrollPane9.setViewportView(tAptos);

        javax.swing.GroupLayout pclProyectosLayout = new javax.swing.GroupLayout(pclProyectos);
        pclProyectos.setLayout(pclProyectosLayout);
        pclProyectosLayout.setHorizontalGroup(
            pclProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pApartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pApartamentos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pclProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pclProyectosLayout.setVerticalGroup(
            pclProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pclProyectosLayout.createSequentialGroup()
                .addComponent(pProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pApartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pApartamentos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelPrincipal.add(pclProyectos, "pclProyectos");

        pclUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/agregar-usuario.png"))); // NOI18N
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/editar.png"))); // NOI18N
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/proyecto/integrador/images/quitar-usuario.png"))); // NOI18N
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableUsuarios.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tableUsuariosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tableUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditar)
                .addGap(1, 1, 1)
                .addComponent(bEliminar)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bGuardar)
                    .addComponent(bEditar)
                    .addComponent(bEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pclUsuariosLayout = new javax.swing.GroupLayout(pclUsuarios);
        pclUsuarios.setLayout(pclUsuariosLayout);
        pclUsuariosLayout.setHorizontalGroup(
            pclUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pclUsuariosLayout.setVerticalGroup(
            pclUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclUsuarios, "pclUsuarios");

        pclTyA.setBackground(new java.awt.Color(255, 51, 255));

        javax.swing.GroupLayout pclTyALayout = new javax.swing.GroupLayout(pclTyA);
        pclTyA.setLayout(pclTyALayout);
        pclTyALayout.setHorizontalGroup(
            pclTyALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );
        pclTyALayout.setVerticalGroup(
            pclTyALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(pclTyA, "pclTyA");

        pclVentas.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setText("VENTA");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(174, 174, 174)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Precio total", "Cantidad cuotas", "Intereses", "Fecha escritura", "Fecha venta", "Valor subsidio", "Apartamento", "Cliente", "Usuario"
            }
        ));
        jScrollPane6.setViewportView(tVentas);

        javax.swing.GroupLayout pclVentasLayout = new javax.swing.GroupLayout(pclVentas);
        pclVentas.setLayout(pclVentasLayout);
        pclVentasLayout.setHorizontalGroup(
            pclVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pclVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );
        pclVentasLayout.setVerticalGroup(
            pclVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pclVentasLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelPrincipal.add(pclVentas, "pclVentas");

        pclPagos.setBackground(new java.awt.Color(255, 255, 255));

        tPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Valor Pago", "Fecha Pago", "Cedula Cliente", "Matricula Venta", "Usuario"
            }
        ));
        jScrollPane8.setViewportView(tPagos);

        jPanel5.setBackground(new java.awt.Color(255, 255, 51));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("PAGOS");

        bAgregarPago.setText("Agregar");
        bAgregarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAgregarPago)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAgregarPago)
                .addContainerGap())
        );

        javax.swing.GroupLayout pclPagosLayout = new javax.swing.GroupLayout(pclPagos);
        pclPagos.setLayout(pclPagosLayout);
        pclPagosLayout.setHorizontalGroup(
            pclPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pclPagosLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );
        pclPagosLayout.setVerticalGroup(
            pclPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pclPagosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelPrincipal.add(pclPagos, "pclPagos");

        pclReportes.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setText("CLIENTES");

        bAgregarCliente.setText("Agregar");
        bAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAgregarCliente)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAgregarCliente)
                .addContainerGap())
        );

        tClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO", "CORREO", "SISBEN", "SUBSIDIO"
            }
        ));
        jScrollPane7.setViewportView(tClientes);

        javax.swing.GroupLayout pclReportesLayout = new javax.swing.GroupLayout(pclReportes);
        pclReportes.setLayout(pclReportesLayout);
        pclReportesLayout.setHorizontalGroup(
            pclReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );
        pclReportesLayout.setVerticalGroup(
            pclReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pclReportesLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelPrincipal.add(pclReportes, "pclReportes");

        jSplitPane2.setRightComponent(jPanelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProyectosActionPerformed
        // TODO add your handling code here:
        // Verificar si el rol es "Administrador"
        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            cardLayout.show(jPanelPrincipal, "pclProyectos");
            listarTablaProyectos();
            listarTablaTorres();
            listarTablaApartamentos();
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "No tienes permisos para realizar esta acción.", "Permiso denegado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbProyectosActionPerformed
    
    private void jbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsuariosActionPerformed
        // Verificar si el rol es "Administrador"
        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            //Cambia la vista a pclUsuarios
            cardLayout.show(jPanelPrincipal, "pclUsuarios");
            // Llama al método para actualizar la tabla de usuarios
            listarTablaUsuarios();   
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "No tienes permisos para realizar esta acción.", "Permiso denegado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbUsuariosActionPerformed

    private void jbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVentasActionPerformed
        // TODO add your handling code here:      
        // Verificar si el rol es "ASESOR"
        if (rol.equalsIgnoreCase("ASESOR")) {
            //Cambia la vista a pclUsuarios
            cardLayout.show(jPanelPrincipal, "pclVentas");
            listarTablaVentas();
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "No tienes permisos para realizar esta acción.", "Permiso denegado", JOptionPane.WARNING_MESSAGE);
        }       
    }//GEN-LAST:event_jbVentasActionPerformed

    private void jbPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagosActionPerformed
        // TODO add your handling code here:      
        // Verificar si el rol es "ASESOR"
        if (rol.equalsIgnoreCase("ASESOR")) {
            //Cambia la vista a pclUsuarios
            cardLayout.show(jPanelPrincipal, "pclPagos");
            listarTablaPagos();
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "No tienes permisos para realizar esta acción.", "Permiso denegado", JOptionPane.WARNING_MESSAGE);
        }             
    }//GEN-LAST:event_jbPagosActionPerformed

    private void jbRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarClienteActionPerformed
        // TODO add your handling code here:      
        // Verificar si el rol es "ASESOR"
        if (rol.equalsIgnoreCase("ASESOR")) {
            //Cambia la vista a pclUsuarios
            cardLayout.show(jPanelPrincipal, "pclReportes");
            listarTablaClientes();
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "No tienes permisos para realizar esta acción.", "Permiso denegado", JOptionPane.WARNING_MESSAGE);
        }  
    }//GEN-LAST:event_jbRegistrarClienteActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        try {
             int selectedRow = tableUsuarios.getSelectedRow();
             // Validar que se haya seleccionado una fila
            if (selectedRow != -1) {
                
                // Asegurarse de que los cambios se reflejan en el modelo
                if (tableUsuarios.isEditing()) {
                    tableUsuarios.getCellEditor().stopCellEditing();
                }
                // Obtener los valores de la fila seleccionada
                String cedula = tableUsuarios.getValueAt(selectedRow, 0).toString();
                String nombre = tableUsuarios.getValueAt(selectedRow, 1).toString();
                String apellido = tableUsuarios.getValueAt(selectedRow, 2).toString();
                String email = tableUsuarios.getValueAt(selectedRow, 3).toString();
                String direccion = tableUsuarios.getValueAt(selectedRow, 4).toString();

                // Llamar al método de la capa lógica para actualizar el usuario
                gestionarUsuario usuarioService = new gestionarUsuario();
                boolean actualizado = usuarioService.editarUsuario(cedula, nombre, apellido, email, direccion);

                if (actualizado) {
                     JOptionPane.showMessageDialog(this,"Usuario actualizado correctamente.");
                    // Refrescar la tabla para mostrar los datos actualizados
                    usuarioService.listarUsuarios();  // Método que vuelve a listar los usuarios
                } else {
                     JOptionPane.showMessageDialog(this,"No se pudo actualizar el usuario.");
                }
            } else {
                JOptionPane.showMessageDialog(this,"Por favor seleccione una fila.");
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error al editar usuario", ex);
        }    
    }//GEN-LAST:event_bEditarActionPerformed

    private void tableUsuariosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tableUsuariosAncestorAdded
       
    }//GEN-LAST:event_tableUsuariosAncestorAdded

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        // Crear y mostrar el formulario para agregar usuario
        AddUsuario user = new AddUsuario(this); // Cambia a la ventana principal
        user.setVisible(true);
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tableUsuarios.getSelectedRow(); // Obtiene la fila seleccionada

        if (filaSeleccionada >= 0) {
            String cedula = tableUsuarios.getValueAt(filaSeleccionada, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de que desea eliminar al usuario con cédula " + cedula + "?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                gestionarUsuario usuarioService = new gestionarUsuario();
                if (usuarioService.eliminarUsuario(cedula)) {
                    JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente");
                    listarTablaUsuarios(); // Actualiza la tabla
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el usuario");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para eliminar.");
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AddVenta venta = new AddVenta(this); // Cambia a la ventana principal
        venta.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarClienteActionPerformed
        // TODO add your handling code here:
        AddCliente cliente = new AddCliente(this); // Cambia a la ventana principal
        cliente.setVisible(true);
    }//GEN-LAST:event_bAgregarClienteActionPerformed

    private void bAgregarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarPagoActionPerformed
        // TODO add your handling code here:
        AddPago pago = new AddPago(this); // Cambia a la ventana principal
        pago.setVisible(true);
    }//GEN-LAST:event_bAgregarPagoActionPerformed

    private void bAgregarTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarTorreActionPerformed
        // TODO add your handling code here:
        AddTorre torre = new AddTorre(this); // Cambia a la ventana principal
        torre.setVisible(true);
    }//GEN-LAST:event_bAgregarTorreActionPerformed

    private void bAgregarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarProyectoActionPerformed
        // TODO add your handling code here:
        AddProyecto proyecto = new AddProyecto(this); // Cambia a la ventana principal
        proyecto.setVisible(true);
    }//GEN-LAST:event_bAgregarProyectoActionPerformed

    private void bAgregarAptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarAptoActionPerformed
        // TODO add your handling code here:
        AddApto apto = new AddApto(this); // Cambia a la ventana principal
        apto.setVisible(true);
    }//GEN-LAST:event_bAgregarAptoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregarApto;
    private javax.swing.JButton bAgregarCliente;
    private javax.swing.JButton bAgregarPago;
    private javax.swing.JButton bAgregarProyecto;
    private javax.swing.JButton bAgregarTorre;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLNombreUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jbPagos;
    private javax.swing.JButton jbProyectos;
    private javax.swing.JButton jbRegistrarCliente;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbUsuarios;
    private javax.swing.JButton jbVentas;
    private javax.swing.JPanel pApartamentos;
    private javax.swing.JPanel pApartamentos1;
    private javax.swing.JPanel pProyectos;
    private javax.swing.JPanel pclPagos;
    private javax.swing.JPanel pclProyectos;
    private javax.swing.JPanel pclReportes;
    private javax.swing.JPanel pclTyA;
    private javax.swing.JPanel pclUsuarios;
    private javax.swing.JPanel pclVentas;
    private javax.swing.JTable tAptos;
    private javax.swing.JTable tClientes;
    private javax.swing.JTable tPagos;
    private javax.swing.JTable tProyectos;
    private javax.swing.JTable tTorres;
    private javax.swing.JTable tVentas;
    private javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables

}
