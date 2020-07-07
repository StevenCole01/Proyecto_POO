public class HiloMovientoPatos extends Thread implements Runnable
{
    private boolean detener;
    Pato[] arregloPatos;

    public HiloMovientoPatos(Pato[] arregloPatos)
    {
        this.arregloPatos = arregloPatos;
    }
    
    @Override
    public void run()
    {
        detener = false;
        do
        {
            for (int x=1490; x>-3300 ; x=x-5) 
			{
				arregloPatos[0].setLocation(x,500);

				for (int i =1 ; i<6; i++) {
					arregloPatos[i].setLocation(x+(50*i),500);
				}	
			}
        }
        while(detener == false);
        
    }

    public void detenerHilo()
    {
        this.detener = true;
    }
}