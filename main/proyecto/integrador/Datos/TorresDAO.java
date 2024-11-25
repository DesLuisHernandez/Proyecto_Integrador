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
public class TorresDAO {
    public List<Torres> listar() {
        List<Torres> listaTorres= new ArrayList<>();
        String sql = "SELECT * FROM TORRES";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Torres torre = new Torres();
                torre.setNumero_torre(rs.getInt("NUMERO_TORRE"));
                torre.setCantidadAptos(rs.getInt("CANTIDAD_APTOS"));
                torre.setId_Proyecto(rs.getString("ID_PROYECTO"));
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
}
