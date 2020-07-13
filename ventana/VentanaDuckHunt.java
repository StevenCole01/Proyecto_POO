package ventana;

import personajes.*;
import utilerias.*;
import ventana.paneles.*;

import javax.swing.*;
import java.awt.event.*;

public class VentanaDuckHunt extends JFrame implements ActionListener , KeyListener
{
    JLayeredPane paneles;
   
    PanelCarga panelCarga;
    PanelInicio panelInicio;
    PanelJuego panelJuego;
    PanelFinal panelFinal;
    PanelInstrucciones panelInstrucciones;

    Reproductor musica;
 
    public VentanaDuckHunt()
    {
        paneles = new JLayeredPane();

        panelCarga = new PanelCarga();
        panelCarga.setSize(1500, 900);    
        panelInicio = new PanelInicio();
        panelInicio.setSize(1500, 900);
        panelJuego = new PanelJuego();
        panelJuego.setSize(1500, 900);
        panelFinal = new PanelFinal();
        panelFinal.setSize(1500, 900);
        panelInstrucciones = new PanelInstrucciones();
        panelInstrucciones.setSize(1500,900);

        paneles.add(panelInstrucciones,new Integer(4));
        paneles.add(panelCarga,new Integer(3));
        paneles.add(panelInicio,new Integer(2));
        paneles.add(panelJuego,new Integer(1));
        paneles.add(panelFinal,new Integer(0));
        
        panelInstrucciones.setVisible(false);
        panelCarga.setVisible(false);
        panelInicio.setVisible(false);
        panelJuego.setVisible(false);
        panelFinal.setVisible(false);

        musica = new Reproductor();

        this.setTitle("Duck Hunt");
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/Botones_Logos/Icono.png")).getImage());
		this.setSize(1500, 900);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null); //colocando la ventana en el medio

        this.addKeyListener(this);

        this.add(paneles);
        
        panelCarga.setVisible(true);
        try
		{
			Thread.sleep(1500);
		}
		catch(Exception e)
		{
			System.out.println("Error: al ejecutar el sleep");
        }     
        musica.playMusic();
        panelCarga.setVisible(false);       

        panelInicio.setVisible(true);
        
        panelInicio.btnJugar.addActionListener(this);
        panelInicio.btnMusicOnOff.addActionListener(this);
        panelInicio.btnMostrarControles.addActionListener(this);   
        panelInstrucciones.btnRegresar.addActionListener(this);
        panelJuego.btnContinuar.addActionListener(this);
        panelFinal.btnListo.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == panelInicio.btnJugar)
        {
            this.requestFocus();
            panelInicio.setVisible(false);
            panelJuego.setVisible(true);
            panelJuego.empezarJuego();
        }
        if (e.getSource() == panelInicio.btnMusicOnOff)
        {
            if(musica.getReproduciendo() == true)
            {
                this.musica.stopPlaying();
                panelInicio.btnMusicOnOff.setIcon(new ImageIcon("./Recursos/Botones_Logos/botonMute.png"));
            } 
            else if (musica.getReproduciendo() == false)
            {
                this.musica.playMusic();
                panelInicio.btnMusicOnOff.setIcon(new ImageIcon("./Recursos/Botones_Logos/BotonUnmute.png"));
            }            
        }
        if (e.getSource() == panelInicio.btnMostrarControles)
        {
            panelInicio.setVisible(false);
            panelInstrucciones.setVisible(true);            
        }
        if (e.getSource() == panelInstrucciones.btnRegresar)
        {
            panelInstrucciones.setVisible(false);
            panelInicio.setVisible(true);            
        }
        if (e.getSource() == panelJuego.btnContinuar)
        {
            panelJuego.setVisible(false);
            panelJuego.detenerJuego();
            panelFinal.lblTiempo.setText(Integer.toString(panelJuego.cronometro.getTiempo())+" s");
            panelFinal.lblPuntuacion.setText(Integer.toString(panelJuego.marcador.getPuntuacion()));
            panelFinal.lblPatosEliminados.setText(Integer.toString(panelJuego.marcador.getPuntuacion()/100));
            if(Archivo.leerMejorPuntuacion() < panelJuego.marcador.getPuntuacion())
            {  
                Archivo.borrarMejorPuntuacion();
                Archivo.guardarMejorPuntuacion(panelJuego.marcador.getPuntuacion());
            }
            if(Archivo.leerMejorTiempo() < panelJuego.cronometro.getTiempo())
            {  
                Archivo.borrarMejorTiempo();
                Archivo.guardarMejorTiempo(panelJuego.cronometro.getTiempo());
            }
            panelFinal.lblMejorPuntuacion.setText(Integer.toString(Archivo.leerMejorPuntuacion()));
            panelFinal.lblMejorTiempo.setText(Integer.toString(Archivo.leerMejorTiempo()) + " s");
            panelFinal.setVisible(true);
                    
        }
        if(e.getSource() == panelFinal.btnListo)
        {
            panelFinal.setVisible(false);
            panelInicio.setVisible(true);           
        }

        
    }

    public void keyPressed(KeyEvent e)
	{	
        
        if (e.getKeyCode() == 65 &&  panelJuego.cazadora.getPermitirMov() == true)//A
        {
            panelJuego.cazadora.setFlagMovIzquierda(true);
            panelJuego.cazadora.setMovimiento("Izquierda");
        }
        else if(e.getKeyCode() == 68 && panelJuego.cazadora.getPermitirMov() == true)//D
        {
            panelJuego.cazadora.setFlagMovDerecha(true);
            panelJuego.cazadora.setMovimiento("Derecha");
        }
        else if (e.getKeyCode() == 32)
        {
           panelJuego.cazadoraSaltar();
        }	

	}

	public void keyReleased(KeyEvent e)
	{
        if (e.getKeyCode() == 65)
        {
            panelJuego.cazadora.setFlagMovIzquierda(false);
            panelJuego.cazadora.setMovimiento("Neutral");
        }
        else if(e.getKeyCode() == 68)
        {
            panelJuego.cazadora.setFlagMovDerecha(false);
            panelJuego.cazadora.setMovimiento("Neutral");            
        }
        else if (e.getKeyCode() == 10)
        {
            panelJuego.cazadora.setPermitirMov(false);
            panelJuego.cazadora.setMovimiento("Disparo");
        }	
	}

    public void keyTyped(KeyEvent e)
    {}
    
}