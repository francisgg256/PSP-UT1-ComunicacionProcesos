package org.iesalandalus.programacion.procesos.basicos.lecturadatosubproceso;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo4 {
    public static void main(String[] args) {
        // Ejecutamos el proceso DIR
        //Declaramos las variables para el proceso, para la lectura de caracteres y el código de salida
        Process proceso1;
        int c;
        int exitVal;

        try
        {
            //Creamos el proceso con los comandos que se van a ejecutar usando start
            proceso1 = new ProcessBuilder("CMD", "/C", "DIR").start();

            // Mostramos carácter a carácter la salida generada por DIR
            //Obtenemos un InputStream conectado a la salida estándar del subproceso para poder mostrar la salida
            InputStream is = proceso1.getInputStream();

            //Leemos carácter a carácter la salida del proceso
            //el while sigue ejecutando hasta que da -1 o lo que es lo mismo no hay nadad más que leer
            while ((c = is.read()) != -1)
                //Se castea  los enteros a char para poder mostrarlo
                System.out.print((char) c);

            //Cerramos el flujo
            is.close();


            // COMPROBACIÓN DE ERROR - 0 bien - DISTINTO DE 0 mal
            //Hacemos waitFor para bloquear el proceso padre hasta que finalice el proceso hijo
            exitVal = proceso1.waitFor(); // recoge la salida de System.exit()
            //Muestra si el subproceso ha finalizado correctamente
            System.out.println("El subproceso finalizó con valor de Salida: " + exitVal);
        }
        catch (IOException | InterruptedException ex)
        {
            //Capturamos la IOException y la InterruptedException y si da error se muestra un mensaje de error
            System.out.println(ex.getMessage());
        }
    }
}


