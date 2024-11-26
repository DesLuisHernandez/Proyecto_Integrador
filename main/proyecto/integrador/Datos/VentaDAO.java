/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author genny
 */
public class VentaDAO {
    
    public List<Venta> listar() {
        List<Venta> listaVentas = new ArrayList<>();
        String sql = "SELECT * FROM VENTA"; // Cambia a tu tabla y campos reales
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setMatricula(rs.getDouble("MATRICULA"));
                venta.setPrecio_Total(rs.getDouble("PRECIO_TOTAL"));
                venta.setCantidad_Cuotas(rs.getInt("CANTIDAD_CUOTAS"));
                venta.setIntereses(rs.getInt("INTERESES"));
                venta.setFecha_esctritura_venta(rs.getDate("FECHA_ESCRITURA_VENTA"));
                venta.setFecha_venta(rs.getDate("FECHA_VENTA"));
                venta.setValorSubsidio(rs.getDouble("VALOR_SUBSIDIO"));
                venta.setId_Apto(rs.getString("ID_APTO"));
                venta.setCedula_Cliente(rs.getString("CEDULA_CLIENTE")); 
                venta.setId_Usuario(rs.getString("ID_USUARIO")); 
                listaVentas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVentas;
    }

    public boolean agregar(Venta venta) {
        String sql = "INSERT INTO VENTA (MATRICULA,PRECIO_TOTAL, CANTIDAD_CUOTAS, INTERESES,FECHA_ESCRITURA_VENTA,FECHA_VENTA,VALOR_SUBSIDIO,ID_APTO, CEDULA_CLIENTE, ID_USUARIO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, venta.getMatricula());
            pst.setDouble(2, venta.getPrecio_Total());
            pst.setDouble(3, venta.getCantidad_Cuotas());
            pst.setDouble(4, venta.getIntereses());
            pst.setDate(5, new java.sql.Date(venta.getFecha_esctritura_venta().getTime()));
            pst.setDate(6, new java.sql.Date(venta.getFecha_venta().getTime()));
            pst.setDouble(7, venta.getValorSubsidio());
            pst.setString(8, venta.getId_Apto());
            pst.setString(9, venta.getCedula_Cliente());
            pst.setString(10, venta.getId_Usuario());
                      
            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }
    
    public Map<String, String> obtenerApartamentos() {
        Map<String, String> proyectoMap = new HashMap<>();
        String sql = "SELECT ID, NUM_APTO FROM APARTAMENTO";
    
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String idApto = rs.getString("ID"); // Cambiar a getString
                String nombreApto = rs.getString("NUM_APTO");
                proyectoMap.put(nombreApto, idApto); // Relacionar nombre con id
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los apartamentos: " + e.getMessage());
        }
        return proyectoMap;
    }
    
    public Map<String, String> obtenerClientes() {
        Map<String, String> proyectoMap = new HashMap<>();
        String sql = "SELECT CEDULA, NOMBRE FROM CLIENTE";
    
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String cedCliente = rs.getString("CEDULA"); // Cambiar a getString
                String nombreCliente = rs.getString("NOMBRE");
                proyectoMap.put(nombreCliente, cedCliente); // Relacionar nombre con id
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los apartamentos: " + e.getMessage());
        }
        return proyectoMap;
    }
    
    public Map<String, String> obtenerUsuarios() {
        Map<String, String> proyectoMap = new HashMap<>();
        String sql = """ 
        SELECT U.ID, U.NOMBRE 
        FROM USUARIO U, USUARIO_ROL UR
        WHERE U.ID = UR.USUARIO_ID
        AND UR.ROL_ID = 2     
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
