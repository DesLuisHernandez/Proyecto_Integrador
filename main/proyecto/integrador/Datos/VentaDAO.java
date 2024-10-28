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
public class VentaDAO {
    
    public List<Venta> listar() {
        List<Venta> listaVentas = new ArrayList<>();
        String sql = "SELECT * FROM VENTA"; // Cambia a tu tabla y campos reales
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setPrecioTotal(rs.getDouble("PRECIO_TOTAL"));
                venta.setNumCuotas(rs.getInt("NUM_CUOTAS"));
                venta.setIntereses(rs.getInt("INTERESES"));
                venta.setCedCliente(rs.getString("CED_CLIENTE"));
                venta.setCedAsesor(rs.getString("CED_ASESOR")); 
                venta.setMatriculaApto(rs.getString("MATRICULA_APARTAMENTO")); 
                listaVentas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVentas;
    }

    public boolean agregar(Venta venta) {
        String sql = "INSERT INTO VENTA (PRECIO_TOTAL, NUM_CUOTAS, INTERESES, CED_CLIENTE, CED_ASESOR, MATRICULA_APARTAMENTO) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, venta.getPrecioTotal());
            pst.setInt(2, venta.getNumCuotas());
            pst.setDouble(3, venta.getIntereses());
            pst.setString(4, venta.getCedCliente());
            pst.setString(5, venta.getCedAsesor());
            pst.setString(6, venta.getMatriculaApto());
                      
            int filasInsertadas = pst.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false en caso de error
        }
    }
    
}
