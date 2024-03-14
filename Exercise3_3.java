import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Exercise3_3 extends JPanel {

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Draw the car body
        GeneralPath car = new GeneralPath();
        car.moveTo(10, 80);
        car.lineTo(100, 80);
        car.lineTo(100, 60);
        car.lineTo(130, 40);
        car.lineTo(190, 40);
        car.lineTo(220, 60);
        car.lineTo(220, 80);
        car.lineTo(300, 80);
        car.lineTo(280, 110);
        car.lineTo(40, 110);
        car.closePath();

        // Draw the wheels
        Ellipse2D wheel1 = new Ellipse2D.Double(60, 80, 40, 40);
        Ellipse2D wheel2 = new Ellipse2D.Double(220, 80, 40, 40);

        // Draw control points for the curves
        g2d.setColor(Color.RED);
        g2d.fillRect(90, 70, 5, 5); // Control point for the quadratic curve
        g2d.fillRect(210, 70, 5, 5); // Control point for the quadratic curve
        g2d.fillRect(130, 40, 5, 5); // Control point for the cubic curve
        g2d.fillRect(190, 40, 5, 5); // Control point for the cubic curve

        // Draw dashed lines connecting the ending points of curves with their control points
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        g2d.drawLine(100, 80, 90, 70); // Dashed line from (100, 80) to control point of the quadratic curve
        g2d.drawLine(220, 80, 210, 70); // Dashed line from (220, 80) to control point of the quadratic curve
        g2d.drawLine(130, 40, 130, 40); // Dashed line from (130, 40) to control point of the cubic curve
        g2d.drawLine(190, 40, 190, 40); // Dashed line from (190, 40) to control point of the cubic curve

        g2d.setColor(Color.BLACK);
        g2d.draw(car);
        g2d.fill(wheel1);
        g2d.fill(wheel2);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Car");
            frame.add(new Exercise3_3());
            frame.setSize(350, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
