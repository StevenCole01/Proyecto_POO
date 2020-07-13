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

    private boolean flagMovDerecha;
    private boolean flagMovIzquierda;

    private int numSumSprite;

    private String movimiento; //Neutral,Izquierda,Derecha,Disparo
    private boolean permitirMov; 
    private boolean saltando;

    private boolean colisionado;

    public Cazadora()
    {
       try
        {
            this.sprite= ImageIO.read(new File("./Recursos/Personajes/Cazadora01.png"));
            subSprite = this.sprite.getSubimage(0, 0, 34, 36);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        this.setSize(alto, ancho);

        flagMovDerecha = false;
        flagMovIzquierda = false;
        movimiento = "Neutral";
        numSumSprite = 1;
        permitirMov = true;
        saltando = false;
        colisionado = false;
    }

    public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(subSprite,0,0,alto,ancho,null);
    }

    public void cambiarSubSprite()
    {
        this.setVisible(false);
        if (movimiento == "Neutral")
        {
            switch (numSumSprite)
            {                 
                case 4:
                this.subSprite = this.sprite.getSubimage(0,72,34,36);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(0,72,34,36);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(0,72,34,36);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(0,72,34,36);
                this.numSumSprite = 4;
                break;
            }
        }
        else if (movimiento == "Derecha")
        {
            switch (numSumSprite)
            {
               
                case 4:
                this.subSprite = this.sprite.getSubimage(0,0,34,36);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(34,0,34,36);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(68,0,34,36);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(34,0,34,36);
                this.numSumSprite = 4;
                break;
            }
        }
        else if (movimiento == "Izquierda")
        {
            switch (numSumSprite)
            {
                case 4:
                this.subSprite = this.sprite.getSubimage(0,36,34,36);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(34,34,34,36);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(68,36,34,36);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(34,34,34,36);
                this.numSumSprite = 4;
                break;
            }
        }
        else if (movimiento == "Disparo")
        {
            switch (numSumSprite)
            {                 
                case 4:
                this.subSprite = this.sprite.getSubimage(34,72,34,36);
                this.numSumSprite = 1;
                break;
                case 1:
                this.subSprite = this.sprite.getSubimage(34,72,34,36);
                this.numSumSprite = 2;
                break;
                case 2:
                this.subSprite = this.sprite.getSubimage(34,72,34,36);
                this.numSumSprite = 3;
                break;
                case 3:
                this.subSprite = this.sprite.getSubimage(34,72,34,36);
                this.numSumSprite = 4;
                break;
            }
        }
        this.setVisible(true);
    }
    
    public void setFlagMovDerecha(boolean flagMovDerecha)
    {
        this.flagMovDerecha = flagMovDerecha;
    }
    
    public void setFlagMovIzquierda(boolean flagMovIzquierda)
    {
        this.flagMovIzquierda = flagMovIzquierda;
    }
   
    public boolean getFlagMovDerecha()
    {
        return this.flagMovDerecha;
    }

    public boolean getFlagMovIzquierda()
    {
        return this.flagMovIzquierda;
    }

    public void setMovimiento(String movimiento)
    {
        this.movimiento = movimiento;
    }

    public boolean getPermitirMov()
    {
        return this.permitirMov;
    }

    public void setPermitirMov(boolean permitirMov)
    {
        this.permitirMov = permitirMov;
    }

    public boolean getSaltando()
    {
        return this.saltando;
    }

    public void setSaltando(boolean saltando)
    {
        this.saltando = saltando;
    }

    public boolean getColisionado()
    {
        return this.colisionado;
    }

    public void setColisionado(boolean colisionado)
    {
        this.colisionado = colisionado;
    }

    
}


