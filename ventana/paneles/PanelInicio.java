package ventana.paneles;

import javax.swing.*;
import java.awt.*;

public class PanelInicio extends JPanel
{
    public JButton btnJugar;
    public JButton btnMusicOnOff;
    public JButton btnMostrarControles;

    private JLabel lblLogo;
   
    public PanelInicio()
    {
        this.setLayout(null);
        btnJugar = new JButton();
        btnJugar.setIcon(new ImageIcon("./Recursos/Botones_Logos/botonJugar.png"));
        btnJugar.setOpaque(false);
        btnJugar.setBounds(556,500,388,138);
        this.add(btnJugar);

        btnMusicOnOff = new JButton();
        btnMusicOnOff.setIcon(new ImageIcon("./Recursos/Botones_Logos/botonUnmute.png"));
        btnMusicOnOff.setBounds(10,10,100,100);
        this.add(btnMusicOnOff);

        btnMostrarControles = new JButton("controles");
        btnMostrarControles.setIcon(new ImageIcon("./Recursos/Botones_Logos/botonInstrucciones.png"));
        btnMostrarControles.setBounds(120,10,100,100);
        this.add(btnMostrarControles);

        lblLogo = new JLabel(new ImageIcon("./Recursos/Botones_Logos/Logo_DuckHunt(Negro).jpg"));
        lblLogo.setBounds(400,50,700,393);
        this.add(lblLogo);
    }

    @Override
    public void paint(Graphics g)
	{
		Image imagen = new ImageIcon(getClass().getResource("/Recursos/Fondos/fondoJuego.png")).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
    }
	
}