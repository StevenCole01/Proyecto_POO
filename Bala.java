import javax.swing.JLabel;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Bala extends JLabel
{
    private BufferedImage sprite;

    public Bala()
    {
       try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Bala.png"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        this.setSize(60, 60);
    }
    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(sprite,0,0,60,60,null);
	}
}