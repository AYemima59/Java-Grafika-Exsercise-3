import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Exercise3_1 extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private BufferedImage canvas;

    public Exercise3_1() {
        canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        drawLine(-200, 300, 600, 100); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, this);
    }

    private void drawLine(int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;
        int D = 2 * dy - dx;
        int y = y0;

        for (int x = x0; x <= x1; x++) {
            drawPixel(x, y);
            if (D > 0) {
                y--;
                D += 2 * dy - 2 * dx;
            } else {
                D += 2 * dy;
            }
        }
    }

    private void drawPixel(int x, int y) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            canvas.setRGB(x, y, Color.BLACK.getRGB());
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Midpoint Line Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.getContentPane().add(new Exercise3_1());
        frame.setVisible(true);
    }
}
