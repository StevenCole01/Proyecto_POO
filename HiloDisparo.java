public class HiloDisparo extends Thread implements Runnable
{
    private boolean detenerHilo;

    private Bala bala;
    private Cazadora cazadora;
    private int x;

    private ReproductorEfectos sonidoDisparo;

    public HiloDisparo(Bala bala, Cazadora cazadora)
    {
        this.bala = bala;
        this.cazadora = cazadora; 
        this.detenerHilo = false;  
        this.sonidoDisparo = new ReproductorEfectos("DisparoRecarga");     
    }

    @Override
    public void run() 
    {
        detenerHilo = false;
        do
        {           
           if(cazadora.getPermitirMov() == false)
           {
               sonidoDisparo.playMusic();
               bala.setVisible(true);
                x = (int)cazadora.getLocation().getX();

                for (int y=700; y>0; y=y-5) 
                {
                    bala.setLocation(x+55,y);
                    retardo(7);
                }
                bala.setLocation(750,1000);
                bala.setVisible(false);
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
}