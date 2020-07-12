public class HiloMovimientoEnemigos extends Thread implements Runnable
{
    private boolean detener;

    private Lobo loboDerecha, loboIzquierda;
    private Zorro zorroDerecha, zorroIzquierda;
    private Jabali jabaliDerecha, jabaliIzquierda;

    private int enemigoMover;

    public HiloMovimientoEnemigos(Lobo loboDerecha, Lobo loboIzquierda, Zorro zorroDerecha, Zorro zorroIzquierda, Jabali jabaliDerecha, Jabali jabaliIzquierda)
    {
        this.loboDerecha = loboDerecha; //1
        this.loboIzquierda = loboIzquierda; //2
        this.zorroDerecha = zorroDerecha; //3
        this.zorroIzquierda = zorroIzquierda; //4
        this.jabaliDerecha = jabaliDerecha; //5
        this.jabaliIzquierda = jabaliIzquierda; //6
        
    }

    @Override
    public void run()
    {
        this.detener = false;
        do
        {
            retardo(1000);                      
            if((int)(Math.random()*3+1) == 1)
            { 
                enemigoMover =  (int)(Math.random()*6+1);
                
                switch (enemigoMover)
                {
                    case 1:
                        for (int x=-200; x<1600; x=x+1) 
                        {
                            loboDerecha.setLocation(x,(int) loboDerecha.getLocation().getY());
                            
                            if ((x%20) == 0)//Aleteo de patos
                            {
                                loboDerecha.cambiarSubSprite();
                            }
                            retardo(3);
                            /* if(loboDerecha.intersects(cazadora.getLocation()) == true)
                            {
                                break;
                            } */
                        }
                        loboDerecha.setLocation(-200,(int) loboDerecha.getLocation().getY());                        
                    break;

                    case 2:
                        for (int x=1600; x>-200; x=x-1) 
                        {
                            loboIzquierda.setLocation(x,(int) loboIzquierda.getLocation().getY());
                            
                            if ((x%20) == 0)//Aleteo de patos
                            {
                                loboIzquierda.cambiarSubSprite();
                            }
                            retardo(3);
                            /* if(loboDerecha.intersects(cazadora.getLocation()) == true)
                            {
                                break;
                            } */
                        }
                        loboIzquierda.setLocation(1600,(int) loboIzquierda.getLocation().getY());  
                    break;

                    case 3:
                        for (int x=-200; x<1600; x=x+1) 
                            {
                                zorroDerecha.setLocation(x,(int) zorroDerecha.getLocation().getY());
                                
                                if ((x%20) == 0)//Aleteo de patos
                                {
                                    zorroDerecha.cambiarSubSprite();
                                }
                                retardo(3);
                                /* if(loboDerecha.intersects(cazadora.getLocation()) == true)
                                {
                                    break;
                                } */
                            }
                            zorroDerecha.setLocation(-200,(int) zorroDerecha.getLocation().getY());  
                    break;

                    case 4:
                        for (int x=1600; x>-200; x=x-1) 
                            {
                                zorroIzquierda.setLocation(x,(int) zorroIzquierda.getLocation().getY());
                                
                                if ((x%20) == 0)//Aleteo de patos
                                {
                                    zorroIzquierda.cambiarSubSprite();
                                }
                                retardo(3);
                                /* if(loboDerecha.intersects(cazadora.getLocation()) == true)
                                {
                                    break;
                                } */
                            }
                            zorroIzquierda.setLocation(1600,(int) zorroIzquierda.getLocation().getY());  
                    break;

                    case 5:
                        for (int x=-200; x<1600; x=x+1) 
                            {
                                jabaliDerecha.setLocation(x,(int) jabaliDerecha.getLocation().getY());
                                
                                if ((x%20) == 0)//Aleteo de patos
                                {
                                    jabaliDerecha.cambiarSubSprite();
                                }
                                retardo(3);
                                /* if(loboDerecha.intersects(cazadora.getLocation()) == true)
                                {
                                    break;
                                } */
                            }
                            jabaliDerecha.setLocation(-200,(int) jabaliDerecha.getLocation().getY());  
                    break;

                    case 6:
                        for (int x=1600; x>-200; x=x-1) 
                            {
                                jabaliIzquierda.setLocation(x,(int) jabaliIzquierda.getLocation().getY());
                                
                                if ((x%20) == 0)//Aleteo de patos
                                {
                                    jabaliIzquierda.cambiarSubSprite();
                                }
                                retardo(3);
                                /* if(loboDerecha.intersects(cazadora.getLocation()) == true)
                                {
                                    break;
                                } */
                            }
                            jabaliIzquierda.setLocation(1600,(int) jabaliIzquierda.getLocation().getY());  
                    break;

                }
            }



            

        }while (detener == false);

    }

    public void detenerHilo()
    {
        this.detener = true;
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