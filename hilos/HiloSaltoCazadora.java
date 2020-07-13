package hilos;

import personajes.Cazadora;

public class HiloSaltoCazadora extends Thread implements Runnable
{

    Cazadora cazadora;
    public HiloSaltoCazadora(Cazadora cazadora)
    {
        this.cazadora = cazadora;
    }

    public void run()
    {
        if(cazadora.getColisionado() == false)
        {
        //int x = (int) cazadora.getLocation().getX();
            cazadora.setSaltando(true);
            for (int y=730; y> 500;y=y-5) 
            {
                cazadora.setLocation((int) cazadora.getLocation().getX(),y);
                retardo(12);
            }
            for (int y=500; y<730; y=y+5) 
            {
                cazadora.setLocation((int) cazadora.getLocation().getX(),y);
                retardo(12);
            }
            cazadora.setSaltando(false);
        }
        
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

}