import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelCircular extends JPanel {

    // Definir el radio de las esquinas redondeadas
    private final int radius;

    public PanelCircular(int radius) {
        this.radius = radius;
        setOpaque(false); // Hacer el panel transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Crear una forma redondeada
        RoundRectangle2D roundRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius);

        // Establecer el color de fondo
        g2d.setColor(getBackground());
        g2d.fill(roundRect); // Rellenar el panel

        // Crear un degradado para el borde
        GradientPaint borderGradient = new GradientPaint(0, 0, new Color(255, 165, 0),  // Color amarillo-naranja
                                                         getWidth(), getHeight(), new Color(255, 200, 0)); // Color más claro
        g2d.setPaint(borderGradient);
        g2d.setStroke(new java.awt.BasicStroke(2)); // Establecer el grosor del borde
        g2d.draw(roundRect); // Dibujar el borde redondeado
    }
}
