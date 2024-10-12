/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author genny
 */
import java.sql.Connection;
import java.sql.SQLException;

public class ProyectoIntegrador {

    public static void main(String[] args) {
        testConnection();
    }
public static void testConnection() {
        Connection con = null;

        try {
            // Intenta obtener la conexión
            con = Conexion.getConnection();
            
            // Verifica si la conexión se estableció correctamente
            if (con != null) {
                System.out.println("Conexión exitosa a la base de datos!");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        } finally {
            // Asegúrate de cerrar la conexión si se estableció
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}