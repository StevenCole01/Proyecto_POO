import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

class Reproductor
{

    private Clip clip;
    
    private boolean reproduciendo;

    public void playMusic()
    {

        String musicLocation = "./Recursos/Efectos_Sonido/MusicaDeFondo.wav";

        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                reproduciendo = true;
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
        reproduciendo = false;
    }

    public boolean getReproduciendo()
    {
        return this.reproduciendo;
    }

	
}