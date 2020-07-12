public class HiloCaidaDelPato extends Thread implements Runnable
{
    private Pato pato;
    private boolean detenerHilo;
    private int x;
    private int y;

    boolean caida;

    public HiloCaidaDelPato(Pato pato)
    {
        this.pato = pato;
        this.detenerHilo = false;

        this.caida = false;
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

}