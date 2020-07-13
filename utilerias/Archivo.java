package utilerias;

import java.io.*;

public class Archivo
{	
    public static int leerMejorPuntuacion()
    {
        String strLine = new String();

        try(FileInputStream fis = new FileInputStream("./Recursos/Puntuaciones/Mejor_Puntuacion.txt");
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

    public static void borrarMejorPuntuacion()
    {
        File file = new File("./Recursos/Puntuaciones/Mejor_Puntuacion.txt");
        file.delete();
    }

    public static void guardarMejorPuntuacion(int puntuacion) 
    {
        try{
        FileOutputStream fos = new FileOutputStream ("./Recursos/Puntuaciones/Mejor_Puntuacion.txt");
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
    
    //****************************************************************************************** */
    
    public static int leerMejorTiempo()
    {
        String strLine = new String();

        try(FileInputStream fis = new FileInputStream("./Recursos/Puntuaciones/Mejor_Tiempo.txt");
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

    public static void borrarMejorTiempo()
    {
        File file = new File("./Recursos/Puntuaciones/Mejor_Tiempo.txt");
        file.delete();
    }

    public static void guardarMejorTiempo(int tiempo) 
    {
        try{
        FileOutputStream fos = new FileOutputStream ("./Recursos/Puntuaciones/Mejor_Tiempo.txt");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
        String tiempoInt= Integer.toString(tiempo); // parseo a string***
        out.write(tiempoInt);
        out.close(); 
        }
        catch (Exception e) //Agregar Excepciones
        { 
        e.printStackTrace();
        System.exit(1);
        }   
    }
}
