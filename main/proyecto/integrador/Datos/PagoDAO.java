/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;

import java.math.BigDecimal;
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
public class PagoDAO {
    
public static List<Pago> listar() {
        List<Pago> listaPagos = new ArrayList<>();
        String sql = "SELECT * FROM PAGO"; 
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Pago pago = new Pago();
                pago.setValorPago(rs.getBigDecimal("VALOR_PAGO")); 
                pago.setFechaPago(rs.getDate("FECHA_PAGO")); 
                pago.setCedula_cliente(rs.getBigDecimal("CEDULA_CLIENTE")); 
                pago.setMatricula_venta(rs.getBigDecimal("MATRICULA_VENTA"));
                pago.setId_usuario(rs.getString("ID_USUARIO")); 
                listaPagos.add(pago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPagos;
    }
    
    public static boolean agregar(Pago pago) {
        String sql = "INSERT INTO PAGO (VALOR_PAGO, FECHA_PAGO, CEDULA_CLIENTE, MATRICULA_VENTA, ID_USUARIO) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            BigDecimal valorPago = new BigDecimal(pago.getValorPago().toString());  // Convertir Number a BigDecimal
            pst.setBigDecimal(1, valorPago); 
            pst.setDate(2, new java.sql.Date(pago.getFechaPago().getTime()));
            BigDecimal cedCliente = new BigDecimal(pago.getCedula_cliente().toString());  // Convertir Number a BigDecimal
            pst.setBigDecimal(3, cedCliente); 
            BigDecimal matVenta = new BigDecimal(pago.getMatricula_venta().toString());  // Convertir Number a BigDecimal
            pst.setBigDecimal(4, matVenta); 
            pst.setString(5, pago.getId_usuario());                      
            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
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
            throw new RuntimeException("Error al obtener los clientes: " + e.getMessage());
        }
        return proyectoMap;
    }
    
    public Map<String, String> obtenerAVenta() {
        Map<String, String> proyectoMap = new HashMap<>();
        String sql = "SELECT MATRICULA, PRECIO_TOTAL FROM VENTA";
    
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String idMatricula = rs.getString("MATRICULA"); // Cambiar a getString
                String nombreMatricula = rs.getString("PRECIO_TOTAL");
                proyectoMap.put(nombreMatricula, idMatricula); // Relacionar nombre con id
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las ventas: " + e.getMessage());
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
