package ventana.paneles;

import javax.swing.*;
import java.awt.*;


public class PanelInstrucciones extends JPanel
{
    public JButton btnRegresar;
    
    public PanelInstrucciones()
    {
        this.setLayout(null);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setIcon(new ImageIcon("./Recursos/Botones_Logos/botonRegresar.png"));
       // btnJugar.setOpaque(true);
        btnRegresar.setBounds(10,10,100,100);
        this.add(btnRegresar);

    }

    @Override
    public void paint(Graphics g)
	{
		Image imagen = new ImageIcon(getClass().getResource("/Recursos/Fondos/ComoJugar.jpg")).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
    }
}