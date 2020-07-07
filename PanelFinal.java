import javax.swing.*;

public class PanelFinal extends JPanel
{
    /* Panel Game Over
+LabelPuntuacion
+Boton reiniciar(o seguir)
+Boton Salir (juego o menu)
+ Logo o mensaje */

    JButton btnReiniciar;
    JButton btnSalir;
    JLabel lblPuntuacion;

    public PanelFinal()
    {
        this.setLayout(null);
        
        btnReiniciar = new JButton("REINICIAR");
        btnReiniciar.setBounds(300,300,100,50);

        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(300,350,100,50);

        lblPuntuacion = new JLabel();
        lblPuntuacion.setBounds(300,200,100,50);
    }

}