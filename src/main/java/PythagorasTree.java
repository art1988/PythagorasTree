

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PythagorasTree
{
    private static BufferedImage image;
    private static Graphics graphics;

    private JFrame window;
    private TreeCanvas treeCanvas;

    private final int IMG_W = 460, IMG_H = 440;



    public PythagorasTree()
    {
        window = new JFrame("PythagorasTree");
        window.setSize(500, 500);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        window.setLocation((int)(dim.getWidth() / 3), (int)(dim.getHeight() / 5));

        image = new BufferedImage(IMG_W, IMG_H, BufferedImage.TYPE_INT_RGB);

        graphics = image.getGraphics();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0,0, IMG_W, IMG_H);
        graphics.setColor(Color.BLACK);

        treeCanvas = new TreeCanvas(image);

        window.getContentPane().add(treeCanvas);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        PythagorasTree pythagorasTree = new PythagorasTree();

        pythagorasTree.drawVertLine();
    }

    private void drawVertLine() throws InterruptedException
    {
        int  x_end = IMG_W / 2, y_end = (int)(IMG_H / 1.5),
             x_start = IMG_W / 2, y_start = (int)(IMG_H / 1.1);

        graphics.drawLine(x_start, y_start, x_end, y_end);

        int len = 70;

        drawTree(len, x_end, y_end, 140, 50);
    }

    private void drawTree(int len, int x, int y, int ang_long, int ang_short)
    {
        int x_long = (int) (len * Math.cos(degreeToRad(ang_long))) + x,
            y_long = -(int) (len * Math.sin(degreeToRad(ang_long))) + y;

        int x_short = (int) (len * Math.cos(degreeToRad(ang_short))) + x,
            y_short = -(int) (len * Math.sin(degreeToRad(ang_short))) + y;

        graphics.drawLine(x, y, x_long, y_long);
        graphics.drawLine(x, y, x_short, y_short);

        if(len <= 3) return;

        len *= 0.76;

        ang_long += 50;
        ang_short += 50;

        // draw left side
        drawTree(len, x_long, y_long, ang_long, ang_short);

        ang_long -= 95;
        ang_short -= 95;

        // draw right side
        drawTree(len, x_short, y_short, ang_long, ang_short);
    }

    private double degreeToRad(int degree)
    {
        return degree * Math.PI / 180;
    }
}
