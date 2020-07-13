public class HiloCaidaDelPato extends Thread implements Runnable
{
    private Pato pato;
    private Marcador marcador;
    private boolean detenerHilo;
    private int x;
    private int y;

    private boolean caida;

    private ReproductorEfectos sonidoPato;

    public HiloCaidaDelPato(Pato pato, Marcador marcador)
    {
        this.pato = pato;
        this.marcador = marcador;
        this.detenerHilo = false;
        this.caida = false;
        this.sonidoPato = new ReproductorEfectos("Quack");
       // x =0;
        y =0;
    }

    @Override
    public void run()
    {
        detenerHilo = false;
        do
        { 
            if (caida == true)
            { 
                sonidoPato.playMusic();
                marcador.agregarPuntos();
                marcador.actualizarMarcador();
                pato.setVisible(true);
                pato.setLocation(x+20,y);
                pato.setVisible(true);
                pato.spriteCaida("Impacto");
                retardo(600);
                pato.spriteCaida("Caida");
                    for (int i = y; i < 700; i=i+5) 
                    {
                        pato.setLocation(x,i);
                        retardo(7);
                    }
                pato.setLocation(750,1000);
                pato.setVisible(false);
                caida = false;
            }
        }while(detenerHilo == false);           
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

    public void detenerHilo()
    {
        this.detenerHilo = true;
    }

    public void activarCaida()
    {
        this.caida = true;

    }

    public void setCoordenadas(int x, int y)
    {
        this.x = x;
        this.y =y;
    }

   /* public void

    public boolean getCaida()
    {
        return this.caida;
    }*/

}