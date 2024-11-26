/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import main.proyecto.integrador.Datos.Apartamentos;
import main.proyecto.integrador.Datos.ApartamentosDAO;
import main.proyecto.integrador.Datos.Torres;
import main.proyecto.integrador.Datos.TorresDAO;

/**
 *
 * @author Alejandra
 */
public class gestionApartamentos {
    
    private ApartamentosDAO apartamentoDAO = new ApartamentosDAO();
    
    public List<Apartamentos> obtenerApto() {
        return apartamentoDAO.listar();
    }    
    
    public boolean registrarApto(Apartamentos apartamentos) {
        return apartamentoDAO.agregar(apartamentos);
    }
    
    public void llenarComboBoxTorres(JComboBox<String> comboBox) {
        // Obtener los proyectos desde el DAO
        Map<String, String> torres = apartamentoDAO.obtenerTorres();

        // Limpiar el combo box
        comboBox.removeAllItems();

        // Llenar el combo box con los nombres de los proyectos
        for (String numeroTorre : torres.keySet()) {
            comboBox.addItem(numeroTorre);
        }
    }

    
    public String obtenerIdTorreSeleccionada(JComboBox<String> comboBox) {
        String proyectoSeleccionado = (String) comboBox.getSelectedItem();
        if (proyectoSeleccionado != null) {
            Map<String, String> torres = apartamentoDAO.obtenerTorres(); // Mapa String -> String
            return torres.getOrDefault(proyectoSeleccionado, ""); // Retorna "" si no encuentra el id
        }
        return ""; // Retorna vacío si no hay selección
    }
    
}
