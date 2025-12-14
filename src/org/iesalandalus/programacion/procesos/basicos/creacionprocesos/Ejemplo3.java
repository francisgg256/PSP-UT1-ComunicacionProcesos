package org.iesalandalus.programacion.procesos.basicos.creacionprocesos;

import java.io.IOException;

public class Ejemplo3 {
    public static void main(String[] args) {
        //Obtenemos la instancia de Runtime con el getRuntime
        Runtime r=Runtime.getRuntime();

        //Definimos los comandos que se van a ejecutar
        //String comando="NOTEPAD";
        String[] comando1={"CMD", "/C", "DIR"};
        String[] comando2 = {"cmd", "/c", "dir", "/o"};
        // 3ª forma: usando una cadena y dividiéndola para convertirla en una lista
        String[] comando3 =  {"c:/windows/system32/cmd c:\\dir"};
        String[] comando4 =  {"c:/windows/system32/shutdown -s -t 0"};
        try
        {
            //Se crea el proceso y se ejecuta el primer comando usando exec
            Process proceso1=r.exec(comando1);
            //Mostramos el PID del proceso
            System.out.println("PID del nuevo proceso: " + proceso1.pid());

            //Obtenemos la información del proceso
            ProcessHandle.Info proceso1Info=proceso1.info();

            // Mostrar información del proceso
            System.out.println("Información Proceso 1:");
            System.out.println("======================");
            informacionProceso(proceso1Info);


            //Se crea el proceso y se ejecuta el segundo comando usando start
            ProcessBuilder pb = new ProcessBuilder(comando2);
            Process proceso2=pb.start();

            //Obtenemos la información del proceso
            ProcessHandle.Info proceso2Info=proceso2.info();

            // Mostrar información del proceso
            System.out.println("\nInformación Proceso 2:");
            System.out.println("======================");
            informacionProceso(proceso2Info);

            // La expresión regular \s significa partir por los espacios en blanco
            //Se crea el proceso y se ejecuta el tercer comando
            pb = new ProcessBuilder(comando3[0].split("\\s"));
            //Obtenemos la información del proceso
            ProcessHandle.Info proceso3Info=proceso2.info();

            // Mostrar información del proceso
            System.out.println("\nInformación Proceso 3:");
            System.out.println("======================");
            informacionProceso(proceso3Info);

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
