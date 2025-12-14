package org.iesalandalus.programacion.procesos.basicos.lecturadatosubproceso;

public class Ejemplo6 {
    public static void main(String[] args) throws Exception {
        // Ejecutamos el proceso DIR
        // Hereda entrada/salida/error del proceso padre
        // Creamos un ProcessBuilder para ejecutar el comando DIR en Windows.
        ProcessBuilder pb =  new ProcessBuilder("CMD", "/C", "DIR");
        //Se lanza el proceso
        Process p = pb.inheritIO().start();

        //Se lanza otro comando distinto
        pb =  new ProcessBuilder("ping", "google.com");
        //Se lanza el proceso
        p = pb.inheritIO().start();

        //Espera a que el ping termine y muestra como finalizó el subproceso
        System.out.println("El subproceso finalizó con valor de salida: " + p.waitFor());
    }
}
