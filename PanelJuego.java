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

    JButton btnRegresar;

    public Cazadora cazadora;
    public Pato[] arregloPatos;
    public Zorro zorro;
    public Jabali jabali;

    HiloMovientoPatos hiloPatos;
    
    //Logo_DuckHunt(Negro)
    public PanelJuego() 
    {
        cazadora = new Cazadora();
        cazadora.setLocation(600, 720);
        this.add(cazadora);

        arregloPatos = new Pato[8];
        for (int i=0; i<8; i++)
        {
            arregloPatos[i] = new Pato();
            arregloPatos[i].setLocation(i*150, 500);
            this.add(arregloPatos[i]);
        }
        /*pato = new Pato();
        pato.setLocation(700, 700);
        this.add(pato);*/

        zorro = new Zorro();
        zorro.setLocation(400, 700);
        this.add(zorro);

        jabali = new Jabali();
        jabali.setLocation(200, 700);
        this.add(jabali);

        this.setLayout(null);
        this.btnRegresar = new JButton("regresar");
        this.btnRegresar.setBounds(400,400,100,50);
        this.add(btnRegresar);

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
        hiloPatos = new HiloMovientoPatos(this.arregloPatos)
    }
}

