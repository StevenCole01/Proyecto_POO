import java.awt.*;

public class HiloMovientoPatos extends Thread implements Runnable
{
    private boolean detener;
    Pato[] arregloPatosDerecha;
    Pato[] arregloPatosIzquierda;
    int xIzq = 0;

    public HiloMovientoPatos(Pato[] arregloPatosDerecha, Pato[] arregloPatosIzquierda)
    {
        this.arregloPatosDerecha = arregloPatosDerecha;
        this.arregloPatosIzquierda = arregloPatosIzquierda;
    }
    
    @Override
    public void run()
    {
        detener = false;
        do
        {
            //Mover continuamente las posiciones en x, evaluarlas en las fuciones correspondientes de cada pato y segun el resultado actualizar
            //su posicion en Y
           
           
          /* for(int i = 0; i < 8 ; i++)
           {
            arregloPatosDerecha[i].setLocation(((int) arregloPatosDerecha[i].getLocation().getX())+1,(int)arregloPatosDerecha[i].getLocation().getY());
            arregloPatosDerecha[i].setLocation((int) arregloPatosDerecha[i].getLocation().getX(),aplicarEcuacionTrayectoria(arregloPatosDerecha[i]));            
           }
           */

          for(int xDer = -6500; xDer < 1500 ; xDer=xDer+1)
          {           
            if (xDer == -6500)
            { xIzq = 1550;}
            else{xIzq = xIzq-1;}           

            
            for (int i =0 ; i<8; i++) 
            {            
                arregloPatosDerecha[i].setLocation(xDer+900*i/*Separacion*/,aplicarEcuacionTrayectoria(arregloPatosDerecha[i]));
                arregloPatosIzquierda[i].setLocation(xIzq+900*i/*Separacion*/,aplicarEcuacionTrayectoria(arregloPatosIzquierda[i]));
                
                if ((xDer%20) == 0)//Aleteo de patos
                {
                    arregloPatosDerecha[i].cambiarSubSprite();
                }
                if ((xIzq%20) == 0)//Aleteo de patos
                {
                    arregloPatosIzquierda[i].cambiarSubSprite();
                }

                //arregloTroncos[i].setLocation(x+separacionTroncos*i,y[i]);
            }
            retardo(5);
          }

            

        }
        while(detener == false);
        
    }

    public void detenerHilo()
    {
        this.detener = true;
    }

    private int aplicarEcuacionTrayectoria(Pato p)
    {
        int x;
        int y = 0;
        Point pos = p.getLocation();
        x = (int)pos.getX();
        
        switch(p.getTrayectoria())
        {
            case 1:
                y =  ((int)(Math.sin((x/120)*100)*120))+200;
            break;
            case 2:
                y = (x/8)+100;//listo
            break;
            case 3:
                y = (-x/8)+280;//ya esta
            break;
            case 4:
                y =  ((int)(Math.sin((x/150)*70)*100))+100;// ya esta
            break;
            case 5:
                y =  ((int)(Math.sin((x/100)*30)*50))+100;//esta ya esta
            break;
        }
        return y;        
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