package personajes;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Lobo extends JLabel
{
    private BufferedImage sprite;
    private BufferedImage subSprite;

    private final int alto = 120;
    private final int ancho = 180;

    private int numSumSprite;
    private final String direccion;

    public Lobo(String direccion)
    {
       try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Lobo.png"));
            subSprite = this.sprite.getSubimage(0, 0, 80, 50);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        this.setSize(ancho, alto);

        this.direccion = direccion;
        numSumSprite = 5;
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
                case 6:
                this.subSprite = this.sprite.getSubimage(0,50,80,50);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(80,50,80,50);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(160,50,80,50);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(240,50,80,50);
                this.numSumSprite = 4;
                break;
                case 4:
                this.subSprite = this.sprite.getSubimage(320,50,80,50);
                this.numSumSprite = 5;
                break;
                case 5:
                this.subSprite = this.sprite.getSubimage(0,50,80,50);
                this.numSumSprite = 6;
                break;

            }
        }
        else if (direccion == "Izquierda")
        {
            switch (numSumSprite)
            {
                case 6:
                this.subSprite = this.sprite.getSubimage(0,0,80,50);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(80,0,80,50);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(160,0,80,50);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(240,0,80,50);
                this.numSumSprite = 4;
                break;
                case 4:
                this.subSprite = this.sprite.getSubimage(320,0,80,50);
                this.numSumSprite = 5;
                break;
                case 5:
                this.subSprite = this.sprite.getSubimage(0,0,80,50);
                this.numSumSprite = 6;
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