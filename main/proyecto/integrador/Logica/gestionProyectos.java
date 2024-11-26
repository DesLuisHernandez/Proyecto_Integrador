/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import main.proyecto.integrador.Datos.Proyectos;
import main.proyecto.integrador.Datos.ProyectosDAO;


/**
 *
 * @author genny
 */
public class gestionProyectos {
    private ProyectosDAO proyectoDAO = new ProyectosDAO(); 
    
    public List<Proyectos> obtenerProyectos() {
        return proyectoDAO.listar();
    }  
    
    public boolean registrarProyectos(Proyectos proyecto) {
        //return proyectoDAO.agregar(proyecto);
       return proyectoDAO.registrarProyecto(proyecto);
    }
    
    public void llenarComboBoxUsuarios(JComboBox<String> comboBox) {
        // Obtener los USUARIOS desde el DAO
        Map<String, String> usuarios = proyectoDAO.obtenerUsuarios();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los USARIOS
        for (String nombreUsuario : usuarios.keySet()) {
            comboBox.addItem(nombreUsuario);
        }
    }

    
    public String obtenerIdUsuarioSeleccionado(JComboBox<String> comboBox) {
        String usuarioSeleccionado = (String) comboBox.getSelectedItem();
        if (usuarioSeleccionado != null) {
            Map<String, String> proyectos = proyectoDAO.obtenerUsuarios(); // Mapa String -> String
            return proyectos.getOrDefault(usuarioSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
    
    
}
