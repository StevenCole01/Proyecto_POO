import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Cazadora extends JLabel{

    private BufferedImage sprite;
    private BufferedImage subSprite;

    private final int alto = 120;
    private final int ancho = 120;

    public Cazadora()
    {
       try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Cazadora.png"));
            subSprite = this.sprite.getSubimage(0, 0, 34, 36);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        this.setSize(alto, ancho);
    }

    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(subSprite,0,0,alto,ancho,null);
	}
}