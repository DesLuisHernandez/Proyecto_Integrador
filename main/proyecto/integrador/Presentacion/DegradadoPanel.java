/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Luis Hernández
 */
package main.proyecto.integrador.Presentacion;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DegradadoPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Definir el degradado de color: desde blanco a negro
        GradientPaint gp = new GradientPaint(0, 0, Color.WHITE, 0, getHeight(), Color.BLACK);

        // Aplicar el degradado
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
