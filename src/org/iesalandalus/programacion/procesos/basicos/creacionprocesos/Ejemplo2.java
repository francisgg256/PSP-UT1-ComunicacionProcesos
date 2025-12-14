package org.iesalandalus.programacion.procesos.basicos.creacionprocesos;

import java.io.IOException;

public class Ejemplo2 {
    public static void main(String[] args) {
        //Obtenemos la instancia de Runtime con el getRuntime
        Runtime r=Runtime.getRuntime();

        //Comando del que queremos saber la información, se pueden añadir más comandos
        String [] comando={"NOTEPAD"};
        try
        {
            //Se ejecuta el comando usando el proceso
            Process proceso1=r.exec(comando);
            //Obtenemos la información del proceso
            ProcessHandle.Info proceso1Info=proceso1.info();

            // Mostrar información del proceso
            informacionProceso(proceso1Info);


        }
        catch (IOException | SecurityException | NullPointerException | IllegalArgumentException e)
        {
            //Capturamos la IOException la SecurityException, la NullPointerException y la IllegalArgumentException y si da error se muestra un mensaje de error
            System.out.println(e.getMessage());
        }

    }

    //Método para mostrar por consola la información del proceso
    private static void informacionProceso(ProcessHandle.Info info) {
        // Muestra el nombre del sistema operativo donde se está ejecutando la JVM.
        System.out.println("Sistema Operativo      : " + System.getProperty("os.name"));
        // Muestra el comando completo asociado al proceso (ruta del ejecutable), envuelto en un Optional.
        System.out.println("Comando                : " + info.command());
        // Muestra los argumentos con los que se lanzó el proceso, también como Optional.
        System.out.println("Argumentos             : " + info.arguments());
        // Muestra el instante de inicio del proceso (fecha/hora), si el SO proporciona ese dato.
        System.out.println("Instante de inicio     : " + info.startInstant());
        // Muestra la duración total de CPU consumida por el proceso hasta ese momento.
        System.out.println("Total duración         : " + info.totalCpuDuration());
        // Muestra el usuario del sistema que es propietario del proceso.
        System.out.println("Usuario                : " + info.user());
    }
}
