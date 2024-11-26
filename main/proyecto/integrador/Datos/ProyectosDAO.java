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
import java.sql.CallableStatement;

/**
 *
 * @author Alejandra
 */
public class ProyectosDAO {
    public List<Proyectos> listar() {
        List<Proyectos> listaProyectos = new ArrayList<>();
        String sql = """ 
        SELECT P.NOMBRE, P.CANTIDAD_TORRES, U.NOMBRE AS USUARIO_NOMBRE
        FROM PROYECTOS P, USUARIO U
        WHERE P.ID_USUARIO = U.ID      
        """;
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Proyectos proyecto = new Proyectos();
                proyecto.setNombre(rs.getString("NOMBRE"));
                proyecto.setCantTorres(rs.getInt("CANTIDAD_TORRES"));
                proyecto.setIdUsuario(rs.getString("USUARIO_NOMBRE"));
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
    
    public boolean registrarProyecto(Proyectos proyecto) {
        Connection conn = null;
        CallableStatement stmt = null;
        boolean registrado = false;

        try {
            // Obtener la conexión usando la clase conexion
            conn = Conexion.getConnection();

            // Llamar al procedimiento almacenado pr_crear_proyecto
            String sql = "{CALL pr_crear_proyecto(?, ?, ?)}";
            stmt = conn.prepareCall(sql);

            // Asignar los valores a los parámetros del procedimiento
            stmt.setString(1, proyecto.getNombre());  // nombre del proyecto
            stmt.setInt(2, proyecto.getCantTorres());  // cantidad de torres
            stmt.setString(3, proyecto.getIdUsuario());  // id del usuario

            // Ejecutar el procedimiento
            int resultado = stmt.executeUpdate();

            // Si la ejecución fue exitosa, el procedimiento devuelve un número mayor que 0
            if (resultado > 0) {
                registrado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return registrado;
    }
    
    public Map<String, String> obtenerUsuarios() {
        Map<String, String> proyectoMap = new HashMap<>();
        String sql = """ 
        SELECT U.ID, U.NOMBRE 
        FROM USUARIO U, USUARIO_ROL UR
        WHERE U.ID = UR.USUARIO_ID
        AND UR.ROL_ID = 1     
        """;
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String idUsuario = rs.getString("ID"); // Cambiar a getString
                String nombreUsuario = rs.getString("NOMBRE");
                proyectoMap.put(nombreUsuario, idUsuario); // Relacionar nombre con id
            }
        } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al obtener los usuarios: " + e.getMessage());
        }
    return proyectoMap;
    } 
    
}
