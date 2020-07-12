import javax.swing.JLabel;
import java.awt.*;

public class Marcador extends JLabel 
{
    private int puntuacion;
    
    public Marcador()
    {
        this.setBackground(Color.black);
        this.setOpaque(true);
        this.setText(" Score: " + 0);
        this.setForeground(Color.white);
        this.setBounds(0,0,250,60);
        this.setFont(new Font("Agency FB", Font.PLAIN, 35));

        this.puntuacion = 0;
    }

    public void setPuntuacion(int puntuacion)
    {
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion()
    {
        return this.puntuacion;
    }

    public void agregarPuntos()
    {
        this.puntuacion += 100;
    }

    public void resetPuntuacion()
    {
        this.puntuacion = 0;
    }

    public void actualizarMarcador()
    {
        this.setText(" Score: "+ puntuacion);
    }

}