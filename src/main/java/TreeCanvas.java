import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TreeCanvas extends JPanel
{
    private BufferedImage img;


    public TreeCanvas(BufferedImage img)
    {
        this.img = img;
    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, null, 10, 10);
    }
}
