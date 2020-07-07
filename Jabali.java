import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Jabali extends JLabel
{
    private BufferedImage sprite;
    private BufferedImage subSprite;

    private final int alto = 120;
    private final int ancho = 140;

    public Jabali()
    {
       try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Jabali.png"));
            subSprite = this.sprite.getSubimage(0, 0, 57, 47);
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