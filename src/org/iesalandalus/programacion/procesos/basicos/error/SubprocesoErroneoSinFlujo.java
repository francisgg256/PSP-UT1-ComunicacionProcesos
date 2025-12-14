package org.iesalandalus.programacion.procesos.basicos.error;

public class SubprocesoErroneoSinFlujo {
    public static void main(String[] args) throws Exception {
        // Ejecutamos el proceso DIR
        // Hereda entrada/salida/error del proceso padre
        //Creamos el proceso para ejecutar el comando erróneo
        ProcessBuilder pb =  new ProcessBuilder("CMD", "/C", "DIRf");
        //Ejecutamos el comando con start
        Process p = pb.inheritIO().start();

        // Espera a que el subproceso termine y muestra su código de salida.
        System.out.println("El subproceso finalizó con valor de salida: " + p.waitFor());

    }
}
