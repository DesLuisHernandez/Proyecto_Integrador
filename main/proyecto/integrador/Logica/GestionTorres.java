/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
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
}
