import javax.swing.*;
import java.awt.*;

public class PanelFinal extends JPanel
{
    /* Panel Game Over
    +LabelPuntuacion
    +Boton reiniciar(o seguir)
    +Boton Salir (juego o menu)
    + Logo o mensaje */

    JButton btnListo;

    JLabel lblTiempo;
    JLabel lblPuntuacion;
    JLabel lblPatosEliminados;
    JLabel lblMejorPuntuacion;
    JLabel lblMejorTiempo;

    public PanelFinal()
    {
        this.setLayout(null);
        
        btnListo = new JButton();
        btnListo.setIcon(new ImageIcon("./Recursos/Botones_Logos/botonListo.png"));
        btnListo.setBounds(1230,690,150,56);
        this.add(btnListo);

        
        lblTiempo = new JLabel("TIEMPO");
        lblTiempo.setBounds(1120,207,245,55);
        lblTiempo.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTiempo.setFont(new Font("Helvetica", Font.PLAIN, 30));
        lblTiempo.setForeground(Color.white);
        this.add(lblTiempo);

        lblPuntuacion = new JLabel("PUNTUACION");
        lblPuntuacion.setBounds(1120,290,245,55);
        lblPuntuacion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPuntuacion.setFont(new Font("Helvetica", Font.PLAIN, 30));
        lblPuntuacion.setForeground(Color.white);
        this.add(lblPuntuacion);

        lblPatosEliminados = new JLabel("PATOSELIM");
        lblPatosEliminados.setBounds(1120,380,245,55);
        lblPatosEliminados.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPatosEliminados.setFont(new Font("Helvetica", Font.PLAIN, 30));
        lblPatosEliminados.setForeground(Color.white);
        this.add(lblPatosEliminados);

        lblMejorTiempo= new JLabel("MTIEMPO");
        lblMejorTiempo.setBounds(1120,515,245,55);
        lblMejorTiempo.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMejorTiempo.setFont(new Font("Helvetica", Font.PLAIN, 30));
        lblMejorTiempo.setForeground(Color.white);
        this.add(lblMejorTiempo);

        lblMejorPuntuacion = new JLabel("MPUNTUACION");
        lblMejorPuntuacion.setBounds(1120,598,245,55);
        lblMejorPuntuacion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMejorPuntuacion.setFont(new Font("Helvetica", Font.PLAIN, 30));
        lblMejorPuntuacion.setForeground(Color.white);
        this.add(lblMejorPuntuacion);    
    }

    @Override
    public void paint(Graphics g)
	{
		Image imagen = new ImageIcon(getClass().getResource("./Recursos/Fondos/FondoFinal.jpg")).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
    }

}