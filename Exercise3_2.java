import java.awt.*;
import javax.swing.*;

public class Exercise3_2 extends JPanel {

    private int x0, y0, x1, y1;

    // Constructor to initialize the starting and ending points of the line
    public Exercise3_2(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    // Method to draw the components
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLine(g, x0, y0, x1, y1);
    }

    // Method to draw a line using structural algorithm
    private void drawLine(Graphics g, int x0, int y0, int x1, int y1) {
        // Calculate horizontal and vertical changes
        int dx = x1 - x0;
        int dy = y1 - y0;

        // Determine the step direction
        int stepX = (dx > 0) ? 1 : -1;
        int stepY = (dy > 0) ? 1 : -1;

        // Calculate the length of the line in steps
        int dxAbs = Math.abs(dx);
        int dyAbs = Math.abs(dy);
        int steps = Math.max(dxAbs, dyAbs);

        // Draw the line pixel by pixel
        for (int i = 0; i < steps; i++) {
            // Draw one black pixel at coordinate (x0, y0)
            g.setColor(Color.BLACK);
            g.fillRect(x0, y0, 1, 1);

            // Update the position (x0, y0) to the next pixel
            x0 += stepX;
            y0 += stepY;
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Define the coordinates of the starting and ending points of the line
        int x0 = 50; // x coordinate of the starting point of the line
        int y0 = 50; // y coordinate of the starting point of the line
        int x1 = 150; // x coordinate of the ending point of the line
        int y1 = 70; // y coordinate of the ending point of the line

        // Create a frame
        JFrame frame = new JFrame("Exercise 3.2");
        // Create a panel to draw the line
        Exercise3_2 panel = new Exercise3_2(x0, y0, x1, y1);
        // Set the default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add the panel to the frame
        frame.add(panel);
        // Set the size of the frame
        frame.setSize(200, 120);
        // Display the frame
        frame.setVisible(true);
    }
}

