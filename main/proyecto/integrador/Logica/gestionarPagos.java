/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
import main.proyecto.integrador.Datos.Pago;
import main.proyecto.integrador.Datos.PagoDAO;

/**
 *
 * @author Alejandra
 */
public class gestionarPagos {
        //private ClienteDAO clienteDAO = new ClienteDAO();
    PagoDAO clienteDAO = new PagoDAO(); 
    
    public List<Pago> obtenerPago() {
        return PagoDAO.listar();
    }  
    
    public boolean registrarPago(Pago pago) {
        return PagoDAO.agregar(pago);
    }
    
}
