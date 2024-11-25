/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
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
    
}
