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
    public Lobo loboDerecha, loboIzquierda;
    public Zorro zorroDerecha, zorroIzquierda;
    public Jabali jabaliDerecha, jabaliIzquierda;
    public Bala bala;

    public Pato patoCaidaDerecha; //Se crea el pato para animar la caida
    public Pato patoCaidaIzquierda;
    

    public HiloMovientoPatos hiloPatos;
    public HiloMovimientoCazadora hiloCazadora;
    public HiloDisparo hiloDisparo;
    public HiloMovimientoEnemigos hiloEnemigos;
    public HiloCaidaDelPato hiloCaidaDerecha; // hilo para la caida del pato
    public HiloCaidaDelPato hiloCaidaIzquierda;
    
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

        loboDerecha = new Lobo("Derecha");
        loboDerecha.setLocation(-200,730);
        this.add(loboDerecha);        
        
        loboIzquierda = new Lobo("Izquierda");
        loboIzquierda.setLocation(1600,730);
        this.add(loboIzquierda);        

        zorroDerecha = new Zorro("Derecha");
        zorroDerecha.setLocation(-200,730);
        this.add(zorroDerecha);
         
        zorroIzquierda = new Zorro("Izquierda");
        zorroIzquierda.setLocation(1600, 730);
        this.add(zorroIzquierda);

        jabaliDerecha = new Jabali("Derecha");
        jabaliDerecha.setLocation(-200, 730);
        this.add(jabaliDerecha);

        jabaliIzquierda = new Jabali("Izquierda");
        jabaliIzquierda.setLocation(1600, 730);
        this.add(jabaliIzquierda);


        bala = new Bala();
        bala.setLocation(750,1000);
        bala.setVisible(false);
        this.add(bala);

        //iniciar el pato para la caida y se agrega a este panel
        patoCaidaDerecha = new Pato("Impacto");
        patoCaidaDerecha.setLocation(750,1000);
        this.add(patoCaidaDerecha);
        patoCaidaIzquierda = new Pato("Izquierda");//*******************
        patoCaidaIzquierda.setLocation(750,1000);
        this.add(patoCaidaIzquierda);

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
        hiloCaidaIzquierda = new HiloCaidaDelPato(patoCaidaIzquierda);
        hiloCaidaDerecha = new HiloCaidaDelPato(patoCaidaDerecha);//se crea el hilo de la animacion de caida, se le pasa el pato como parametro
        hiloPatos = new HiloMovientoPatos(this.arregloPatosDerecha, this.arregloPatosIzquierda, bala, hiloCaidaDerecha, hiloCaidaIzquierda); //en el hilo de patos tambien se pasa el hilo de caida
        hiloCazadora = new HiloMovimientoCazadora(cazadora);
        hiloDisparo = new HiloDisparo(bala, cazadora);
        hiloEnemigos = new HiloMovimientoEnemigos(loboDerecha,loboIzquierda,zorroDerecha,zorroIzquierda,jabaliDerecha,jabaliIzquierda);
    }
}

