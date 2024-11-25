/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;
import main.proyecto.integrador.Datos.UsuariosDAO;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import main.proyecto.integrador.Datos.Conexion;
import main.proyecto.integrador.Datos.Usuarios;
/**
 *
 * @author genny
 */
public class UsuarioService {
    private UsuariosDAO usuarioDAO = new UsuariosDAO();
    
    public boolean autenticarUsuario(String login, String contrasena) {
        return usuarioDAO.validarUsuario(login, contrasena);
    }
    
     public List<Usuarios> listarUsuarios() {
        return usuarioDAO.listar();
    }
         
    // Método para editar un usuario
    public boolean editarUsuario(String cedula, String nombre, String apellido, String email, String activo) {
        // Crear el objeto usuario con los datos recibidos
        Usuarios usuario = new Usuarios();
        usuario.setCedula(cedula);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setActivo(activo.charAt(0)); // Convertir el string a char ('S' o 'N')

        // Abrir la conexión y pasarla al DAO para actualizar el usuario
        try (Connection con = Conexion.getConnection()) {
            return usuarioDAO.editar(usuario, con);
        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejo de excepción
            return false;
        }
    }
    
    public boolean agregarUsuario(Usuarios usuario) {
        return usuarioDAO.agregar(usuario);
    }
    
    public boolean eliminarUsuario(String cedula) {
        return usuarioDAO.eliminarUsuario(cedula);
    }
    
    // Método para verificar si un usuario existe
    public boolean existeUsuario(String cedula) {
        return usuarioDAO.existeUsuario(cedula);
    }
    
    
}
