/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luis Hernández
 */
package main.proyecto.integrador.Datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {
    
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valido;
    }
    
     public List<Usuarios> listar() {
        List<Usuarios> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO"; // Cambia a tu tabla y campos reales
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                //usuario.setId(rs.getInt("ID"));
                usuario.setCedula(rs.getString("CEDULA"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setApellido(rs.getString("APELLIDO"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setActivo(rs.getString("ACTIVO").charAt(0)); // Asumiendo que 'ACTIVO' es un char
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    // Método para editar un usuario en la base de datos 
    public boolean editar(Usuarios usuario, Connection con) throws SQLException{
        String sql = "UPDATE USUARIO SET nombre = ?, apellido = ?, email = ?, activo = ? WHERE cedula = ?";
        
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, String.valueOf(usuario.getActivo())); // 'S' o 'N'
            pst.setString(5, usuario.getCedula());
            
            int filasActualizadas = pst.executeUpdate();
            return filasActualizadas > 0; // Retorna true si se actualizaron filas
        }
    }
    
    public boolean agregar(Usuarios usuario) {
        String sql = "INSERT INTO USUARIO (CEDULA, NOMBRE, APELLIDO, EMAIL, LOGIN, CONTRASENA, ACTIVO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, usuario.getCedula());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellido());
            pst.setString(4, usuario.getEmail());
            pst.setString(5, usuario.getLogin());
            pst.setString(6, usuario.getContrasena());
            pst.setString(7, String.valueOf(usuario.getActivo())); // Convierte a String para la base de datos
            
            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }
    
    public boolean eliminarUsuario(String cedula) {
        String sql = "DELETE FROM USUARIO WHERE CEDULA = ?";
        
        try (Connection conn = Conexion.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, cedula);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0; // Devuelve true si se eliminó al menos un usuario
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Manejo de errores
        }
    }
    
    public boolean existeUsuario(String cedula) {
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE CEDULA = ?";
        try (Connection con = Conexion.getConnection(); 
            PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
        
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si hay al menos un registro
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retorna false en caso de error o si no hay registros
    }
}
