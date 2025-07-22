package OrigenDestino;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        //Creamos un objeto para localizar la ruta.
        Path localizar = Paths.get("M2_T02_Origen.txt");

        //Comprobamos si existe o no el archivo en dicha ruta.
        if(!Files.exists(localizar)) {
            System.out.println("No existe dicho archivo.");
        } else {
            System.out.println("El archivo si existe.");
        }

        //Leemos el arhcivo con scanner.
        try (Scanner leer = new Scanner(Paths.get("M2_T02_Origen.txt"));){

            //Reemplazamos espacios por '-'
            Files.writeString(localizar, "Hola-Mundo\n¿Qué-tal-estás?");

            //Copiamos el contenido modificado de Origen.txt a Destino.txt
            Files.copy(localizar, Path.of("M2_T02_Destino.txt"));

            while (leer.hasNextLine()) {
                System.out.println(leer.nextLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
