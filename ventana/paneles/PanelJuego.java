package ventana.paneles;

import personajes.*;
import utilerias.*;
import hilos.*;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel
{
    public JButton btnContinuar;
    public JLabel lblMensajeDeColision;

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
    public HiloSaltoCazadora hiloSaltoCazadora;
    public HiloColisionEnemigo hiloColisionEnemigo;

    public Cronometro cronometro;

    public Marcador marcador;
    
    //Logo_DuckHunt(Negro)
    public PanelJuego() 
    {

        btnContinuar = new JButton(new ImageIcon("./Recursos/Botones_Logos/botonContinuar.png"));
        btnContinuar.setBounds(550,550,400,120);
        btnContinuar.setVisible(false);
        this.add(btnContinuar);

        lblMensajeDeColision = new JLabel(new ImageIcon("./Recursos/Botones_Logos/Caceria.gif"));
        lblMensajeDeColision.setBounds(500,150,500,378);
        lblMensajeDeColision.setBackground(Color.BLACK);
        lblMensajeDeColision.setOpaque(true);
        lblMensajeDeColision.setVisible(false);
        this.add(lblMensajeDeColision);

        marcador = new Marcador();
        this.add(marcador);
        
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
        patoCaidaIzquierda = new Pato("Izquierda");
        patoCaidaIzquierda.setLocation(750,1000);
        this.add(patoCaidaIzquierda);

        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g)
	{
		Image imagen = new ImageIcon(getClass().getResource("/Recursos/Fondos/fondoJuego.png")).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
    }

    public void empezarJuego()
    {
        cronometro = new Cronometro();
        hiloCaidaIzquierda = new HiloCaidaDelPato(patoCaidaIzquierda, marcador);
        hiloCaidaDerecha = new HiloCaidaDelPato(patoCaidaDerecha, marcador);//se crea el hilo de la animacion de caida, se le pasa el pato como parametro
        hiloPatos = new HiloMovientoPatos(this.arregloPatosDerecha, this.arregloPatosIzquierda, bala, hiloCaidaDerecha, hiloCaidaIzquierda); //en el hilo de patos tambien se pasa el hilo de caida
        hiloCazadora = new HiloMovimientoCazadora(cazadora);
        hiloDisparo = new HiloDisparo(bala, cazadora);
        hiloEnemigos = new HiloMovimientoEnemigos(loboDerecha,loboIzquierda,zorroDerecha,zorroIzquierda,jabaliDerecha,jabaliIzquierda);
        hiloColisionEnemigo = new HiloColisionEnemigo(loboDerecha, loboIzquierda, zorroDerecha, zorroIzquierda, jabaliDerecha, jabaliIzquierda, cazadora, hiloCazadora, hiloDisparo, hiloEnemigos, btnContinuar, lblMensajeDeColision, cronometro);

        hiloPatos.start(); 
        hiloCazadora.start();
        hiloDisparo.start();
        hiloEnemigos.start();  
        hiloCaidaDerecha.start();
        hiloCaidaIzquierda.start(); 
        hiloColisionEnemigo.start();
        cronometro.start();

        marcador.resetPuntuacion();
        marcador.actualizarMarcador();

        btnContinuar.setVisible(false);
        lblMensajeDeColision.setVisible(false);
        cazadora.setColisionado(false);
    }

    public void detenerJuego()
    {
        hiloPatos.detenerHilo(); 
        hiloCazadora.detenerHilo();
        hiloDisparo.detenerHilo();
        hiloEnemigos.detenerHilo();  
        hiloCaidaDerecha.detenerHilo();
        hiloCaidaIzquierda.detenerHilo();
    }

    public void cazadoraSaltar()
    {
        hiloSaltoCazadora = new HiloSaltoCazadora(cazadora);
        if(cazadora.getPermitirMov() == true && cazadora.getSaltando() == false)
        {
            hiloSaltoCazadora.start();
        }
    }  
}

