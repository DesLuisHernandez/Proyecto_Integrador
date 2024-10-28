/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
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
}
