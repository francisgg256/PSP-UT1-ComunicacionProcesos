package org.iesalandalus.programacion.procesos.basicos.creacionprocesos;

import java.io.IOException;

public class Ejemplo1 {
    public static void main(String[] args) {

        creaProcesoNotePadProcessBuilder();
        creaProcesoNotePadRuntime();
    }

    private static void creaProcesoNotePadProcessBuilder()
    {
        // Creamos el proceso que lanza el comando NOTEPAD
        ProcessBuilder pb=new ProcessBuilder("NOTEPAD");
        try
        {
            //Se lanza el proceso
            Process proceso1=pb.start();
            //Se muestra el PID del proceso
            System.out.println("PID del nuevo proceso: " + proceso1.pid());
        }
        catch (IOException e)
        {
            //Capturamos la IOException y si da error se muestra un mensaje de error
            System.out.println(e.getMessage());
        }
    }

    private static void creaProcesoNotePadRuntime()
    {
        try
        {
            //Creamos el proceso usando getRuntime para obtener la instancia y usamos exec para ejecutar el comando
            Process proceso1=Runtime.getRuntime().exec("NOTEPAD");
            //Mostramos el PID del proceso
            System.out.println("PID del nuevo proceso: " + proceso1.pid());
        }
        catch (IOException | SecurityException e)
        {
            //Capturamos la IOException y la SecurityException y si da error se muestra un mensaje de error
            System.out.println(e.getMessage());
        }
        catch (NullPointerException | IllegalArgumentException e)
        {
            //Capturamos la NullPointerException y la IllegalArgumentException y si da error se muestra un mensaje de error
            System.out.println("ERROR: El comando especificado como parámetro es nulo o vacío.");
        }

    }
}
