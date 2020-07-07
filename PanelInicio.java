import javax.swing.*;
import java.awt.*;

public class PanelInicio extends JPanel
{
    /*
    + Boton jugar 
    +Logo
    +Boton mostrar controles
    +Label imagen de controles
    */

    public JButton btnJugar;
    public JButton btnMusicOnOff;
    public JButton btnMostrarControles;

    public JLabel lblLogo;
    public JLabel lblControles;

   


    public PanelInicio()
    {
        this.setLayout(null);
        btnJugar = new JButton("Jugar");
        btnJugar.setIcon(new ImageIcon("./Recursos/Botones_Logos/botonPlay.png"));
        btnJugar.setBounds(530,500,440,160);
        this.add(btnJugar);

        

        lblLogo = new JLabel(new ImageIcon("./Recursos/Botones_Logos/Logo_DuckHunt(Negro).jpg"));
        lblLogo.setBounds(400,50,700,393);
        this.add(lblLogo);
        
    }

    @Override
    public void paint(Graphics g)
	{
		Image imagen = new ImageIcon(getClass().getResource("./Recursos/Fondos/fondoJuego.png")).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
    }
	
}