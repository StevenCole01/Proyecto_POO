import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel
{
    /*  Panel del Juego
    +Arreglo de Patos
    +Enemigos
    +cazador
    +Label Puntos
    */
    JLabel lblPuntos;  

    public Cazadora cazadora;
    public Pato[] arregloPatosDerecha;
    public Pato[] arregloPatosIzquierda;
    public Zorro zorro;
    public Jabali jabali;

    public HiloMovientoPatos hiloPatos;
    public HiloMovimientoCazadora hiloCazadora;
    
    //Logo_DuckHunt(Negro)
    public PanelJuego() 
    {
        cazadora = new Cazadora();
        cazadora.setLocation(600, 720);
        this.add(cazadora);

        arregloPatosDerecha = new Pato[8];
        for (int i=0; i<8; i++)
        {
            arregloPatosDerecha[i] = new Pato("Derecha");
            arregloPatosDerecha[i].setLocation(i*150, 400);
            this.add(arregloPatosDerecha[i]);
        }
        
        arregloPatosIzquierda = new Pato[8];
        for (int i=0; i<8; i++)
        {
            arregloPatosIzquierda[i] = new Pato("Izquierda");
            arregloPatosIzquierda[i].setLocation(i*150, 500);
            this.add(arregloPatosIzquierda[i]);
        }
        

        zorro = new Zorro();
        zorro.setLocation(400, 700);
        this.add(zorro);

        jabali = new Jabali();
        jabali.setLocation(200, 700);
        this.add(jabali);

        this.setLayout(null);

        creandoHilos();

    }

    @Override
    public void paint(Graphics g)
	{
		Image imagen = new ImageIcon(getClass().getResource("./Recursos/Fondos/fondoJuego.png")).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
    }

    public void creandoHilos()
    {
        hiloPatos = new HiloMovientoPatos(this.arregloPatosDerecha, this.arregloPatosIzquierda);
        hiloCazadora = new HiloMovimientoCazadora(cazadora);
    }
}

