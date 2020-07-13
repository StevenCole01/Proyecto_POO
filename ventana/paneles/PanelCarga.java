package ventana.paneles;

import javax.swing.*;
import java.awt.*;

public class PanelCarga extends JPanel
{   
    /* Agregar la ruta a la imagen correcta */
    @Override
    public void paint(Graphics g)
	{
		Image imagen = new ImageIcon(getClass().getResource("/Recursos/Botones_Logos/Logo_DuckHunt(Negro).jpg")).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
    }
    
}