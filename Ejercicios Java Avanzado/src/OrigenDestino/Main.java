package OrigenDestino;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main (String [] args) {

        //Ubicamos la ruta del archivo original.
        Path ruta = Paths.get("M2_T02_Origen.txt");

        //Creamos un objeto de lectura para el archivo y uno para escritura (el archivo Destino).
        try (BufferedReader leer = Files.newBufferedReader(ruta);
        BufferedWriter writer = new BufferedWriter(new FileWriter("M2_T02_Destino.txt"))){

            String contenidoOrigen;
            String contenidoDestino;

            //Mientras el archivo tenga lineas de texto que leer las mostrará en pantalla.
            while ((contenidoOrigen = leer.readLine()) != null) {

                System.out.println(contenidoOrigen);

                //Reemplazamos los espacios por guiones.
                contenidoDestino = contenidoOrigen.replace(" ", "-");

                //Escribimos el nuevo contenido en el archivo creado con anterioridad (Destino).
                writer.write(contenidoDestino);
                writer.newLine();


            }
            

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
