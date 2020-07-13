package hilos;

import personajes.*;

import java.awt.Point;

public class HiloMovimientoCazadora extends Thread implements Runnable
{
    Cazadora cazadora;

    boolean detener;
    Point pos;
    int x;
    int y;

    int permitirMovSprite;
    int cooldown;

    public HiloMovimientoCazadora(Cazadora cazadora)
    {
        this.detener = false;
        this.cazadora = cazadora;
        this.permitirMovSprite = 0;
        this.cooldown = 0;
    }

    @Override
    public void run()
    {
        permitirMovSprite = 0;
        detener = false;
        do
        {
            if(cazadora.getPermitirMov() == true)
            {   
                retardo(5);

                permitirMovSprite += 5;

                if(cazadora.getFlagMovDerecha() == true && ((int) cazadora.getLocation().getX()) < 1300)
                {
                    cazadora.setLocation(((int) cazadora.getLocation().getX())+1 ,(int) cazadora.getLocation().getY());
                }
                else if(cazadora.getFlagMovIzquierda() == true && ((int) cazadora.getLocation().getX()) > 100)
                {
                    cazadora.setLocation(((int) cazadora.getLocation().getX())-1 ,(int) cazadora.getLocation().getY());
                }  
                
                if ((permitirMovSprite % 100) == 0)//Aleteo de patos
                {
                    cazadora.cambiarSubSprite();
                }
            }
            else if (cazadora.getPermitirMov() == false)
            {   
                do
                {
                    retardo(10);
                    cooldown++;
                    if (cooldown == 1 || cooldown == 10 || cooldown == 20 || cooldown == 30)//Aleteo de patos
                    {
                        cazadora.cambiarSubSprite();
                    }
                }while(cooldown < 100);
                cazadora.setPermitirMov(true);
                cazadora.setMovimiento("Neutral");
                cooldown = 0;
            }
            

        }while(detener == false);

    }

    public void detenerHilo()
    {
        this.detener =true;
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