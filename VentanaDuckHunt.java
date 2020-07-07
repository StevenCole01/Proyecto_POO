import javax.swing.*;
import java.awt.event.*;

public class VentanaDuckHunt extends JFrame implements ActionListener
{
   
    JLayeredPane paneles;
   
    PanelCarga panelCarga;
    PanelInicio panelInicio;
    PanelJuego panelJuego;
    PanelFinal panelFinal;
 

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

        paneles.add(panelCarga,new Integer(3));
        paneles.add(panelInicio,new Integer(2));
        paneles.add(panelJuego,new Integer(1));
        paneles.add(panelFinal,new Integer(0));

        panelCarga.setVisible(false);
        panelInicio.setVisible(false);
        panelJuego.setVisible(false);
        panelFinal.setVisible(false);

        this.setTitle("Duck Hunt");
		this.setSize(1500, 900);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null); //colocando la ventana en el medio

        this.add(paneles);
        panelCarga.setVisible(true);
        
        try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println("Error: al ejecutar el sleep");
        }     
        panelCarga.setVisible(false);       

        panelInicio.setVisible(true);
    
       
       /* this.add(panelJuego);
        panelJuego.setVisible(false);
        this.add(panelFinal);
        panelFinal.setVisible(false);*/ 
        
        panelInicio.btnJugar.addActionListener(this);
        panelJuego.btnRegresar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == panelInicio.btnJugar)
        {
            panelInicio.setVisible(false);
            panelJuego.setVisible(true);
                      
        }

        else if (e.getSource() == panelJuego.btnRegresar)
        {            
            panelJuego.setVisible(false);
            panelInicio.setVisible(true);
        }
    }
}