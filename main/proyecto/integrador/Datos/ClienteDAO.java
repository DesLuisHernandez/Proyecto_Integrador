/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author genny
 */
public class ClienteDAO {
    
    public static List<Cliente> listar() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE"; // Cambia a tu tabla y campos reales
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula(rs.getString("CEDULA"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setApellido(rs.getString("APELLIDO"));
                cliente.setDireccion(rs.getString("DIRECCION"));
                cliente.setTelefono(rs.getString("TELEFONO")); 
                cliente.setCorreo(rs.getString("CORREO")); 
                cliente.setSisben(rs.getString("SISBEN").charAt(0)); 
                cliente.setSubsi_minis(rs.getString("SUBSI_MINIS").charAt(0));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }
    
    public static boolean agregar(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (CEDULA, NOMBRE, APELLIDO, DIRECCION, TELEFONO, CORREO, SISBEN, SUBSI_MINIS) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, cliente.getCedula());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getDireccion());
            pst.setString(5, cliente.getTelefono());
            pst.setString(6, cliente.getCorreo());      
            pst.setString(7, String.valueOf(cliente.getSisben()));
            pst.setString(8, String.valueOf(cliente.getSubsi_minis()));                      
            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }
    
}
