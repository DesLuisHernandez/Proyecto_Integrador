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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alejandra
 */
public class TorresDAO {
    public List<Torres> listar() {
        List<Torres> listaTorres= new ArrayList<>();
        String sql = """ 
        SELECT T.NUMERO_TORRE, T.CANTIDAD_APTOS, P.NOMBRE
        FROM TORRES T, PROYECTOS P
        WHERE T.ID_PROYECTO = P.ID        
        """;
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Torres torre = new Torres();
                torre.setNumero_torre(rs.getInt("NUMERO_TORRE"));
                torre.setCantidadAptos(rs.getInt("CANTIDAD_APTOS"));
                torre.setId_Proyecto(rs.getString("NOMBRE"));
                listaTorres.add(torre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaTorres;
    }

    public boolean agregar(Torres torre) {
        String sql = "INSERT INTO TORRES (NUMERO_TORRE, CANTIDAD_APTOS, ID_PROYECTO) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, torre.getNumero_torre());
            pst.setInt(2, torre.getCantidadAptos());
            pst.setString(3, torre.getId_Proyecto());
                      
            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }  
    
    public Map<String, String> obtenerProyectos() {
        Map<String, String> proyectoMap = new HashMap<>();
        String sql = "SELECT ID, NOMBRE FROM PROYECTOS";
    
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String idProyecto = rs.getString("ID"); // Cambiar a getString
                String nombreProyecto = rs.getString("NOMBRE");
                proyectoMap.put(nombreProyecto, idProyecto); // Relacionar nombre con id
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los proyectos: " + e.getMessage());
        }
        return proyectoMap;
    }
     
}
