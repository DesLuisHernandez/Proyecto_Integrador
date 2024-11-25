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
 * @author Alejandra
 */
public class ApartamentosDAO {
    public static List<Apartamentos> listar() {
        List<Apartamentos> listaAptos = new ArrayList<>();
        String sql = "SELECT * FROM APARTAMENTO"; 
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
                Apto.setIdTorre(rs.getString("ID_TORRE")); 
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
}
