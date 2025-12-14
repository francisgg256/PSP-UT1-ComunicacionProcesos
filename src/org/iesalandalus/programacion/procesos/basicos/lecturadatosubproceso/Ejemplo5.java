package org.iesalandalus.programacion.procesos.basicos.lecturadatosubproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo5 {
    public static void main(String[] args) {
        // Variable para guardar el código de salida del subproceso.
        int exitVal = 0;

        try
        {
            // Crear proceso con argumentos
            ProcessBuilder pb = new ProcessBuilder("ping", "google.com");
            //ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "google.com"); Para Linux

            // Iniciar el proceso
            Process proceso = pb.start();

            // Se prepara un lector de texto para leer la salida estándar del proceso línea a línea.
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String linea;
            // readLine() devuelve null cuando no hay más líneas que leer.
            while ((linea = lector.readLine()) != null) {
                //Se muestra cada línea que el comando ping va generando
                System.out.println(linea);
            }

            // Esperar fin del proceso
            exitVal = proceso.waitFor();
            //Muestra si el subproceso finalizó de forma correcta
            System.out.println("El subproceso finalizó con valor de Salida: " + exitVal);

        }
        catch (IOException | InterruptedException e)
        {
            //Capturamos la IOException y la InterruptedException y si da error se muestra un mensaje de error
            System.out.println(e.getMessage());
        }
    }
}
