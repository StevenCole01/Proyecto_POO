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

    private int numSumSprite;
    private final String direccion;
    

    public Jabali(String direccion)
    {
       try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Jabali.png"));
            subSprite = this.sprite.getSubimage(0,0,57,47);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        this.setSize(ancho, alto);

        this.direccion = direccion;
        numSumSprite = 3;
        cambiarSubSprite();
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
                case 3:
                this.subSprite = this.sprite.getSubimage(0,47,57,47);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(57,47,57,47);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(114,47,57,47);
                this.numSumSprite = 3;
                break;
            }
        }
        else if (direccion == "Izquierda")
        {
            switch (numSumSprite)
            {
                case 3:
                this.subSprite = this.sprite.getSubimage(0,0,57,47);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(57,0,57,47);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(114,0,57,47);
                this.numSumSprite = 3;
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