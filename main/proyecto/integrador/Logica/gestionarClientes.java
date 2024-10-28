/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
import main.proyecto.integrador.Datos.Cliente;
import main.proyecto.integrador.Datos.ClienteDAO;

/**
 *
 * @author genny
 */
public class gestionarClientes {
    
    //private ClienteDAO clienteDAO = new ClienteDAO();
    ClienteDAO clienteDAO = new ClienteDAO(); 
    
    public List<Cliente> obtenerCliente() {
        return ClienteDAO.listar();
    }  
    
    public boolean registrarCliente(Cliente cliente) {
        return ClienteDAO.agregar(cliente);
    }
}
