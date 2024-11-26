/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import main.proyecto.integrador.Datos.Torres;
import main.proyecto.integrador.Datos.TorresDAO;

/**
 *
 * @author Alejandra
 */
public class GestionTorres {
        
    private TorresDAO torreDAO = new TorresDAO();
    
    public List<Torres> obtenerTorres() {
        return torreDAO.listar();
    }    
    
    public boolean registrarTorre(Torres torres) {
        return torreDAO.agregar(torres);
    }
    
    public void llenarComboBoxProyectos(JComboBox<String> comboBox) {
        // Obtener los proyectos desde el DAO
        Map<String, String> proyectos = torreDAO.obtenerProyectos();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los proyectos
        for (String nombreProyecto : proyectos.keySet()) {
            comboBox.addItem(nombreProyecto);
        }
    }

    
    public String obtenerIdProyectoSeleccionado(JComboBox<String> comboBox) {
        String proyectoSeleccionado = (String) comboBox.getSelectedItem();
        if (proyectoSeleccionado != null) {
            Map<String, String> proyectos = torreDAO.obtenerProyectos(); // Mapa String -> String
            return proyectos.getOrDefault(proyectoSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
}
