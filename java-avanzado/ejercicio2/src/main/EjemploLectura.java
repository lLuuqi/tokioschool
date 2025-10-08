package OrigenDestino;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class EjemploLectura {

    public static void main(String[] args) {
        // Usamos el class loader para acceder al recurso en el classpath
        try (BufferedReader leer = new BufferedReader(
                    new InputStreamReader(
                        EjemploLectura.class.getResourceAsStream("/M2_T02_Origen.txt"),
                        StandardCharsets.UTF_8
                    ));
             BufferedWriter writer = new BufferedWriter(new FileWriter("M2_T02_Destino.txt"))) {

            String contenidoOrigen;
            while ((contenidoOrigen = leer.readLine()) != null) {
                System.out.println(contenidoOrigen);
                String contenidoDestino = contenidoOrigen.replace(" ", "-");
                writer.write(contenidoDestino);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}

