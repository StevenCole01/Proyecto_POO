import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Zorro extends JLabel
{
    private BufferedImage sprite;
    private BufferedImage subSprite;

    private final int alto = 110;
    private final int ancho = 180;

    private int numSumSprite;
    private final String direccion;

    public Zorro(String direccion)
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

        this.direccion = direccion;
        numSumSprite = 5;

    }

    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(subSprite,0,0,ancho,alto,null);
    }
    
    public void cambiarSubSprite()
    {
        //this.setVisible(false);
        if (direccion == "Derecha")
        {
            switch (numSumSprite)
            {
                case 5:
                this.subSprite = this.sprite.getSubimage(0,0,68,40);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(68,0,68,40);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(136,0,68,40);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(204,0,68,40);
                this.numSumSprite = 4;
                break;
                case 4:
                this.subSprite = this.sprite.getSubimage(272,0,68,40);
                this.numSumSprite = 5;
                break;
            }
        }
        else if (direccion == "Izquierda")
        {
            switch (numSumSprite)
            {
                case 5:
                this.subSprite = this.sprite.getSubimage(0,40,68,40);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(68,40,68,40);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(132,40,68,40);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(204,40,68,40);
                this.numSumSprite = 4;
                break;
                case 4:
                this.subSprite = this.sprite.getSubimage(272,40,68,40);
                this.numSumSprite = 5;
                break;
            }
        }
        //this.setVisible(true);
    }

    public String getDireccion()
    {
        return this.direccion;
    }
}