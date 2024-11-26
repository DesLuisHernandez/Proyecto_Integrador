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
public class ApartamentosDAO {
    public static List<Apartamentos> listar() {
        List<Apartamentos> listaAptos = new ArrayList<>();
        String sql = """ 
        SELECT A.*, T.NUMERO_TORRE
        FROM APARTAMENTO A, TORRES T
        WHERE A.ID_TORRE = T.ID   
        """;
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Apartamentos Apto = new Apartamentos();
                Apto.setNumApto(rs.getInt("NUM_APTO"));
                Apto.setTipoLocal(rs.getString("TIPO_LOCAL"));
                Apto.setTipoApto(rs.getString("TIPO_APTO"));
                Apto.setTipoGaraje(rs.getString("TIPO_GARAJE"));
                Apto.setArea(rs.getInt("AREA")); 
                Apto.setIdTorre(rs.getString("NUMERO_TORRE")); 
                listaAptos.add(Apto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAptos;
    }
    
    public static boolean agregar(Apartamentos apartamento) {
        String sql = "INSERT INTO APARTAMENTO (NUM_APTO, TIPO_LOCAL, TIPO_APTO, TIPO_GARAJE, AREA, ID_TORRE) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, apartamento.getNumApto());
            pst.setString(2, apartamento.getTipoLocal());
            pst.setString(3, apartamento.getTipoApto());
            pst.setString(4, apartamento.getTipoGaraje());
            pst.setDouble(5, apartamento.getArea());
            pst.setString(6, apartamento.getIdTorre());                        
            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }
    
    public Map<String, String> obtenerTorres() {
        Map<String, String> proyectoMap = new HashMap<>();
        String sql = "SELECT ID, NUMERO_TORRE FROM TORRES";
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String idUsuario = rs.getString("ID"); // Cambiar a getString
                String nombreUsuario = rs.getString("NUMERO_TORRE");
                proyectoMap.put(nombreUsuario, idUsuario); // Relacionar nombre con id
            }
        } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al obtener los usuarios: " + e.getMessage());
        }
    return proyectoMap;
    }
}
