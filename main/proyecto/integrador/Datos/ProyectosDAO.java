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
public class ProyectosDAO {
    public List<Proyectos> listar() {
        List<Proyectos> listaProyectos = new ArrayList<>();
        String sql = "SELECT * FROM PROYECTOS";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Proyectos proyecto = new Proyectos();
                proyecto.setNombre(rs.getString("NOMBRE"));
                proyecto.setCantTorres(rs.getInt("CANTIDAD_TORRES"));
                proyecto.setIdUsuario(rs.getString("ID_USUARIO"));
                listaProyectos.add(proyecto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProyectos;
    }

    public boolean agregar(Proyectos proyecto) {
        String sql = "INSERT INTO PROYECTOS (NOMBRE, CANTIDAD_TORRES, ID_USUARIO) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, proyecto.getNombre());
            pst.setInt(2, proyecto.getCantTorres());
            pst.setString(3, proyecto.getIdUsuario());
                      
            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }
}
