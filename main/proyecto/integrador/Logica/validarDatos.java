/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import main.proyecto.integrador.Datos.Conexion;

/**
 *
 * @author genny
 */

public class validarDatos {   
    public int intentos = 0;
    
    // Método para validar el rol del usuario
    public String validarRol(String login) {
        String rolUsuario = null; // Inicializa como null
        String sql = "SELECT r.NOMBRE FROM ROL r " +
                 "JOIN USUARIO_ROL ur ON r.ID = ur.ROL_ID " +
                 "JOIN USUARIO u ON ur.USUARIO_ID = u.ID " +
                 "WHERE u.LOGIN = ?";

        try (Connection con = Conexion.getConnection(); 
            PreparedStatement pst = con.prepareStatement(sql)) {
         
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
        
            if (rs.next()) {
                rolUsuario = rs.getString("NOMBRE"); // Obtener el rol del usuario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rolUsuario; // Retornar el rol o null si no tiene rol
    }
    
    //Metodo para validar los intentos
    public int contarIntentos(){
        intentos++;// Incrementa el contador en cada llamada
        return intentos;
    }
    
    // Método para validar el usuario
    public boolean validarUsuario(String login, String contrasena) {
        boolean valido = false;
        String sql = "SELECT * FROM USUARIO WHERE LOGIN=? AND CONTRASENA=?";
        
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, login);
            pst.setString(2, contrasena);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                valido = true; // Usuario encontrado
                intentos = 0;
            }else {
                contarIntentos();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valido;
    }  
}
