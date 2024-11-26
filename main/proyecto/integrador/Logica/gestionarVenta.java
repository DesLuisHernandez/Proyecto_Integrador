/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import main.proyecto.integrador.Datos.Venta;
import main.proyecto.integrador.Datos.VentaDAO;

/**
 *
 * @author Luis Hernandez
 */
public class gestionarVenta {
    
    private VentaDAO ventaDAO = new VentaDAO();
    
    public List<Venta> obtenerVentas() {
        return ventaDAO.listar();
    }    
    
    public boolean registrarVenta(Venta venta) {
        return ventaDAO.agregar(venta);
    }
    
    public void llenarComboBoxApto(JComboBox<String> comboBox) {
        // Obtener los proyectos desde el DAO
        Map<String, String> aptos = ventaDAO.obtenerApartamentos();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los proyectos
        for (String nombreApto : aptos.keySet()) {
            comboBox.addItem(nombreApto);
        }
    }
    
    public void llenarComboBoxCliente(JComboBox<String> comboBox) {
        // Obtener los proyectos desde el DAO
        Map<String, String> clientes = ventaDAO.obtenerClientes();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los clientes
        for (String nombreCliente : clientes.keySet()) {
            comboBox.addItem(nombreCliente);
        }
    }
    
    public void llenarComboBoxUsuarios(JComboBox<String> comboBox) {
        // Obtener los proyectos desde el DAO
        Map<String, String> usuarios = ventaDAO.obtenerUsuarios();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los clientes
        for (String nombreUsuario : usuarios.keySet()) {
            comboBox.addItem(nombreUsuario);
        }
    }

    
    public String obtenerIdAptoSeleccionado(JComboBox<String> comboBox) {
        String aptoSeleccionado = (String) comboBox.getSelectedItem();
        if (aptoSeleccionado != null) {
            Map<String, String> aptos = ventaDAO.obtenerApartamentos(); // Mapa String -> String
            return aptos.getOrDefault(aptoSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
    
    public String obtenerIdClienteSeleccionado(JComboBox<String> comboBox) {
        String clienteSeleccionado = (String) comboBox.getSelectedItem();
        if (clienteSeleccionado != null) {
            Map<String, String> clientes = ventaDAO.obtenerClientes(); // Mapa String -> String
            return clientes.getOrDefault(clienteSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
    
    public String obtenerIdUsuarioSeleccionado(JComboBox<String> comboBox) {
        String usuarioSeleccionado = (String) comboBox.getSelectedItem();
        if (usuarioSeleccionado != null) {
            Map<String, String> usuarios = ventaDAO.obtenerUsuarios(); // Mapa String -> String
            return usuarios.getOrDefault(usuarioSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
}
