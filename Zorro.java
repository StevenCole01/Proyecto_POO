import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Zorro extends JLabel
{
    private BufferedImage sprite;
    private BufferedImage subSprite;

    private final int alto = 120;
    private final int ancho = 170;

    public Zorro()
    {
       try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Zorro.png"));
            subSprite = this.sprite.getSubimage(0, 0, 68, 40);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        this.setSize(ancho, alto);
    }

    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(subSprite,0,0,ancho,alto,null);
	}
}