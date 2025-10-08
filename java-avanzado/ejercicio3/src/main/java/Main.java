
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main (String[] args) {

        Path resourcePath = Paths.get("src", "main", "resources", "numeros.txt");
        try {
            Files.createDirectories(resourcePath.getParent());


        //Crear el archivo y abrirlo.
        try (FileWriter writer = new FileWriter (resourcePath.toFile())) {

            //Guardar el valor "1" tres veces
            for (int i = 0; i < 3; i++) {
                writer.write("1");
            }

            writer.write("\n");

            //Guardar el valor "2" seis veces
            for (int i = 0; i < 6; i++) {
                writer.write("2");
            }
            writer.write("\n");
            writer.close();

            URL resource = Main.class.getClassLoader().getResource("numeros.txt");
            if (resource == null) {
                throw new IllegalArgumentException("File not found");
            } else {
                System.out.println("Econtré el archivo");
            }

            InputStream in = Main.class.getClassLoader().getResourceAsStream("numeros.txt");

            //Mostrar por pantalla el contenido del archivo
            try (BufferedReader leer = new BufferedReader(new InputStreamReader(in))) {

                String contenido;

                while ((contenido = leer.readLine()) != null) {
                    System.out.println(contenido);

                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
            /*BufferedWriter writer2 = new BufferedWriter
                    (new FileWriter(String.valueOf(in)));

            //Escribir y leer nuevamente el archivo
            try (BufferedReader leer = new BufferedReader (new InputStreamReader(in))) {

                String contenido;

                //Mostrar por pantalla el contenido nuevo del archivo
                while ((contenido = leer.readLine()) != null) {

                    String contenidoNuevo = contenido.replace("2", "3");

                    writer2.write(contenidoNuevo);
                    writer2.newLine();
                    System.out.println(contenidoNuevo);

                }
                writer2.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
