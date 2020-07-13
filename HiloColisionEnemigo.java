import javax.swing.JButton;
import javax.swing.JLabel;

public class HiloColisionEnemigo extends Thread implements Runnable
{
    private boolean detener;

    private Lobo loboDerecha, loboIzquierda;
    private Zorro zorroDerecha, zorroIzquierda;
    private Jabali jabaliDerecha, jabaliIzquierda;
    private Cazadora cazadora;
    private HiloMovimientoCazadora hiloCazadora;
    private HiloDisparo hiloDisparo;
    private HiloMovimientoEnemigos hiloEnemigos;
    private Cronometro cronometro;

    private JButton btnContinuar;
    private JLabel lblMensajeDeColision;

    public HiloColisionEnemigo(Lobo loboDerecha, Lobo loboIzquierda, Zorro zorroDerecha, Zorro zorroIzquierda, Jabali jabaliDerecha, Jabali jabaliIzquierda, Cazadora cazadora,
    HiloMovimientoCazadora hiloCazadora, HiloDisparo hiloDisparo, HiloMovimientoEnemigos hiloEnemigos, JButton btnContinuar, JLabel lblMensajeDeColision, Cronometro cronometro)
    {
        this.loboDerecha = loboDerecha; //1
        this.loboIzquierda = loboIzquierda; //2
        this.zorroDerecha = zorroDerecha; //3
        this.zorroIzquierda = zorroIzquierda; //4
        this.jabaliDerecha = jabaliDerecha; //5
        this.jabaliIzquierda = jabaliIzquierda; //6
        this.cazadora = cazadora;

        this.hiloCazadora = hiloCazadora;
        this.hiloDisparo = hiloDisparo;
        this.hiloEnemigos = hiloEnemigos;
        this.cronometro = cronometro;

        this.btnContinuar = btnContinuar;
        this.lblMensajeDeColision = lblMensajeDeColision;

        this.detener = false;
    }

    @Override
    public void run()
    {
        detener = false;
        do
        {
            retardo(100);
            if (checkCollision(this.loboDerecha) == true || checkCollision(this.loboIzquierda) == true 
            ||checkCollision(this.zorroDerecha) == true || checkCollision(this.zorroIzquierda) == true 
            ||checkCollision(this.jabaliDerecha) == true || checkCollision(this.jabaliIzquierda) == true)
            {
                cronometro.detener();
                cazadora.setColisionado(true);
                hiloCazadora.detenerHilo();
                hiloDisparo.detenerHilo();
                hiloEnemigos.detenerHilo();
                detener = true;
                retardo(1000);
                lblMensajeDeColision.setVisible(true);
                btnContinuar.setVisible(true);
            }

        }while(detener == false);

    }

    public void retardo(int ms)
	{
		try
			{
				Thread.sleep(ms);
            }catch(Exception e){
				System.out.println("Error: al ejecutar el sleep");
			}
    }

    public boolean checkCollision(Lobo lobo)
    {
        
        return lobo.getBounds().intersects(cazadora.getBounds());
    }

    public boolean checkCollision(Zorro zorro)
    {
        
        return zorro.getBounds().intersects(cazadora.getBounds());
    }

    public boolean checkCollision(Jabali jabali)
    {
        
        return jabali.getBounds().intersects(cazadora.getBounds());
    }

}