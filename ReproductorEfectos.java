import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

class ReproductorEfectos
{
    private String efecto;
    private Clip clip;

    private final String ruta;
    
    public ReproductorEfectos(String efecto)
    {  
        this.efecto = efecto;

        switch(efecto)
        {
            case "DisparoRecarga":
            ruta = "./Recursos/Efectos_Sonido/DisparoRecarga.wav";
            break;

            case "Quack":
            ruta = "./Recursos/Efectos_Sonido/Quack.wav";
            break;

            /*case "Disparo":
            ruta = "./Recursos/Efectos_Sonido/Disparp";
            break;*/

            default:
            ruta ="";
            break;

        }
         
        
    }

    public void playMusic()
    {   
       // ruta = "./musica/MusicUpstream.wav";
        try {

            File musicPath = new File(ruta);

            if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else
            {
                System.out.println("Error al intentar reproducir");
            }

        }catch (Exception e)
        {}
    }
    
    public void stopPlaying()
    {
        clip.stop();
    }

	
}