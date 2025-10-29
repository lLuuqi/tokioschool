import java.io.*;

public class Main {

    public static void main(String[] args) {

        //Creamos el archivo de texto.
        String nombreArchivo = "numeros.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {

            //Creamos y escribimos en el archivo tres "1" y seis "2"
            for (int i = 0; i < 3; i++) {
                bw.write("1");
                bw.newLine();
            }

            for (int i = 0; i < 6; i++) {
                bw.write("2");
                bw.newLine();
            }

            } catch (IOException e) {
                throw new RuntimeException(e);
        }

            //Mostramos el contenido.
            System.out.println("Contenido original del archivo:");
            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }

            //Leemos el contenido y reemplazamos los "2" por "3".
            try {
                    StringBuilder contenido = new StringBuilder();

                try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

                    String linea;

                    while ((linea = br.readLine()) != null) {
                        contenido.append(linea.replace("2", "3"));
                        contenido.append("\n");
                    }
                }

                //Sobrescribir el archivo con los nuevos valores
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
                    bw.write (contenido.toString());
                }

                //Mostrar el nuevo contenido.
                System.out.println("\nContenido después de reemplazar los '2' por '3':");

                    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }

                    }

                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                }

            }

        }