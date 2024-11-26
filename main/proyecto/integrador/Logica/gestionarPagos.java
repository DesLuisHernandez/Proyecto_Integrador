/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import main.proyecto.integrador.Datos.Pago;
import main.proyecto.integrador.Datos.PagoDAO;

/**
 *
 * @author Alejandra
 */
public class gestionarPagos {
        //private ClienteDAO clienteDAO = new ClienteDAO();
    PagoDAO pagoDAO = new PagoDAO(); 
    
    public List<Pago> obtenerPago() {
        return PagoDAO.listar();
    }  
    
    public boolean registrarPago(Pago pago) {
        return PagoDAO.agregar(pago);
    }
    
    public void llenarComboBoxVenta(JComboBox<String> comboBox) {
        // Obtener los proyectos desde el DAO
        Map<String, String> ventas = pagoDAO.obtenerAVenta();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los ventas
        for (String nombreVenta : ventas.keySet()) {
            comboBox.addItem(nombreVenta);
        }
    }
    
    public void llenarComboBoxCliente(JComboBox<String> comboBox) {
        // Obtener los proyectos desde el DAO
        Map<String, String> clientes = pagoDAO.obtenerClientes();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los clientes
        for (String nombreCliente : clientes.keySet()) {
            comboBox.addItem(nombreCliente);
        }
    }
    
    public void llenarComboBoxUsuarios(JComboBox<String> comboBox) {
        // Obtener los proyectos desde el DAO
        Map<String, String> usuarios = pagoDAO.obtenerUsuarios();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los clientes
        for (String nombreUsuario : usuarios.keySet()) {
            comboBox.addItem(nombreUsuario);
        }
    }

    
    public String obtenerIdVentaSeleccionado(JComboBox<String> comboBox) {
        String ventaSeleccionado = (String) comboBox.getSelectedItem();
        if (ventaSeleccionado != null) {
            Map<String, String> ventas = pagoDAO.obtenerAVenta(); // Mapa String -> String
            return ventas.getOrDefault(ventaSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
    
    public String obtenerIdClienteSeleccionado(JComboBox<String> comboBox) {
        String clienteSeleccionado = (String) comboBox.getSelectedItem();
        if (clienteSeleccionado != null) {
            Map<String, String> clientes = pagoDAO.obtenerClientes(); // Mapa String -> String
            return clientes.getOrDefault(clienteSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
    
    public String obtenerIdUsuarioSeleccionado(JComboBox<String> comboBox) {
        String usuarioSeleccionado = (String) comboBox.getSelectedItem();
        if (usuarioSeleccionado != null) {
            Map<String, String> usuarios = pagoDAO.obtenerUsuarios(); // Mapa String -> String
            return usuarios.getOrDefault(usuarioSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
    
}
