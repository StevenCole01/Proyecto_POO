import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Pato extends JLabel
{
    private BufferedImage sprite;
    private BufferedImage subSprite;

    private final int alto = 120;
    private final int ancho = 120;

    private int posX;
    private int posY;

    private boolean direccion; //Derecha(true) o Izquierda(false)
    private String trayectoria; //Ecuacion
    private int velocidad;//factor que se multiplica por la posicion en X para que asi se mueva mas rapido segun la trayectoria

    public Pato()
    {
       try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Pato.png"));
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