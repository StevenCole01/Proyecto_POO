import java.io.*;

class Archivo
{	

    public static int leerHighScore()
    {
        String strLine = new String();

        try(FileInputStream fis = new FileInputStream("High_Score.txt");
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader( new InputStreamReader(in));)
        {
            strLine = br.readLine();
            // in.close();
        }
        catch (Exception e ) //Agregar Excepciones
        {
        e.printStackTrace();
        System.exit(1);
        }
        //arraylist.remove(arraylist.size()-1); // remover el ultimo elemento, que es null
        return Integer.parseInt(strLine);
    }

    public static void borrarHighScore()
    {
        File file = new File("High_Score.txt");
        file.delete();
    }

    public static void guardarHighScore(int puntuacion) 
    {
        try{
        FileOutputStream fos = new FileOutputStream ("High_Score.txt");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
        String puntuacionInt= Integer.toString(puntuacion); // parseo a string***
        out.write(puntuacionInt);
        out.close(); 
        }
        catch (Exception e) //Agregar Excepciones
        { 
        e.printStackTrace();
        System.exit(1);
        }   
    }   


}
