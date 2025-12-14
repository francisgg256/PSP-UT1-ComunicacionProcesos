package org.iesalandalus.programacion.procesos.basicos.error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SubprocesoErroneoConFlujo {
    public static void main(String[] args) {
        // Ejecutamos el proceso DIR
        //Declaramos las variables para el proceso, para la lectura de caracteres y el código de salida
        Process proceso1;
        int c;
        int exitVal;

        try
        {
            //Se crea el proceso que ejecutará un comando erróneo usando start
            proceso1 = new ProcessBuilder("CMD", "/C", "DIRf").start();

            // Mostramos carácter a carácter la salida generada por DIRf
            //Obtenemos un InputStream conectado a la salida estándar del subproceso para poder mostrar la salida
            InputStream is = proceso1.getInputStream();

            //Leemos carácter a carácter la salida del proceso
            //el while sigue ejecutando hasta que da -1 o lo que es lo mismo no hay nadad más que leer
            while ((c = is.read()) != -1)
                //Se castea  los enteros a char para poder mostrarlo
                System.out.print((char) c);

            // Obtenemos ahora el flujo de error estándar del subproceso.
            InputStream error=proceso1.getErrorStream();
            // Lo envolvemos en un BufferedReader para leerlo línea a línea como texto.
            BufferedReader br=new BufferedReader(new InputStreamReader(error));
            String linea=null;
            // Leemos todas las líneas de error generadas por el comando erróneo.
            while ((linea=br.readLine())!=null)
            {
                //Se muestran las líneas de error
                System.out.println("ERROR: " + linea);
            }

            //Cerramos el InputStream
            is.close();
            //Cerramos el BufferedReader
            br.close();

            // COMPROBACIÓN DE ERROR - 0 bien - DISTINTO DE 0 mal
            // Esperamos a que el subproceso termine y recogemos su código de salida.
            exitVal = proceso1.waitFor(); // recoge la salida de System.exit()
            //Muestra si el subproceso finalizó correctamente
            System.out.println("El subproceso finalizó con valor de Salida: " + exitVal);

        }
        catch (IOException | InterruptedException ex)
        {
            //Capturamos la IOException y la InterruptedException y si da error se muestra un mensaje de error
            System.out.println(ex.getMessage());
        }
    }
}


