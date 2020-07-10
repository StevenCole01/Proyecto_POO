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

    
    private final String direccion; //Iquierda o Derecha
    private int numSumSprite;
    private int posVariableY;
    private int trayectoria; //Ecuacion    

    public Pato(String direccion)
    {
        this.direccion = direccion;
        this.numSumSprite = (int)(Math.random()*4+1);;

        rndmTrayectoria();
        rndmPosVariableY();

        try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Pato.png"));
            cambiarSubSprite();
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

    public void cambiarSubSprite()
    {
        if (direccion == "Derecha")
        {
            switch (numSumSprite)
            { 
                case 4:
                this.subSprite = this.sprite.getSubimage(0,0,36,36);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(36,0,36,36);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(72,0,36,36);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(36,0,36,36);
                this.numSumSprite = 4;
                break;
            }
        }
        else if (direccion == "Izquierda")
        {
            switch (numSumSprite)
            {
                case 4:
                this.subSprite = this.sprite.getSubimage(0,36,36,36);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(36,36,36,36);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(72,36,36,36);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(36,36,36,36);
                this.numSumSprite = 4;
                break;
            }
        }
    }
    
    public void rndmPosVariableY()
    {
        posVariableY = (int)(Math.random()*200+100);
    }
    
    public int getPosVariableY()
    {
        return this.posVariableY;
    }

    public void rndmTrayectoria()
    {
        trayectoria = (int)(Math.random()*5+1);
    }

    public int getTrayectoria()
    {
        return this.trayectoria;
    }

}