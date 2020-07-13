package hilos;

import personajes.*;

import java.awt.*;

public class HiloMovientoPatos extends Thread implements Runnable
{

    private boolean detener;
    private Pato[] arregloPatosDerecha;
    private Pato[] arregloPatosIzquierda;
    private int xIzq = 0;
    
    private Bala bala;

    private HiloCaidaDelPato hiloCaidaDerecha;//se declara el hilo caida
    private HiloCaidaDelPato hiloCaidaIzquierda;

    public HiloMovientoPatos(Pato[] arregloPatosDerecha, Pato[] arregloPatosIzquierda, Bala bala, HiloCaidaDelPato hiloCaidaDerecha, HiloCaidaDelPato hiloCaidaIzquierda)
    {
        this.arregloPatosDerecha = arregloPatosDerecha;
        this.arregloPatosIzquierda = arregloPatosIzquierda;
        this.bala = bala;
        this.hiloCaidaDerecha = hiloCaidaDerecha;//recibe el hilo
        this.hiloCaidaIzquierda = hiloCaidaIzquierda;
    }
    
    @Override
    public void run()
    {
        detener = false;
        do
        {
            //Mover continuamente las posiciones en x, evaluarlas en las fuciones correspondientes de cada pato y segun el resultado actualizar
            //su posicion en Y
         

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
           
            checkCollision();
            retardo(4);
            if (detener == true)
            {break;}

          }
          for (int i = 0; i < 8; i++)
          {
              arregloPatosDerecha[i].setVisible(true);
              arregloPatosIzquierda[i].setVisible(true);
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

    public void checkCollision()
    {
        for (int i =0 ; i<8; i++) 
        {
            if (arregloPatosDerecha[i].getBounds().intersects(bala.getBounds()))
            {
                arregloPatosDerecha[i].setVisible(false);
                hiloCaidaDerecha.setCoordenadas((int) arregloPatosDerecha[i].getLocation().getX(), (int) arregloPatosDerecha[i].getLocation().getY());
                //obtiene corrdenadas del pato que choco para iniciar la caida en el mismo lugar
                hiloCaidaDerecha.activarCaida();//activa la caida cambiando una variable booleana a "true"
                break;
            }

            if (arregloPatosIzquierda[i].getBounds().intersects(bala.getBounds()))
            {
                arregloPatosIzquierda[i].setVisible(false);//*******
                hiloCaidaIzquierda.setCoordenadas((int) arregloPatosIzquierda[i].getLocation().getX(), (int) arregloPatosIzquierda[i].getLocation().getY());
                //obtiene corrdenadas del pato que choco para iniciar la caida en el mismo lugar
                hiloCaidaIzquierda.activarCaida();//activa la caida cambiando una variable booleana a "true"
                break;
            }
        }
    }
}