import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase lo que hace es crear un servidor y esperar a que el cliente se conecte
 * a través de un puerto "X" (en este caso es el 5000), recibir los mensajes que envía
 * para posteriormente transformarlos a mayúsculas y devolverlos al cliente.
 */
public class Servidor {
    /**
     * Este método inicia el servidor y gestiona la comunicación
     * con el cliente.
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {

        try (ServerSocket servidor = new ServerSocket (5000);
             Socket cliente =  servidor.accept();
             InputStream entrada = cliente.getInputStream();
             InputStreamReader leer =  new InputStreamReader(entrada);
             BufferedReader lector = new BufferedReader(leer);
             OutputStream salida = cliente.getOutputStream();
             PrintWriter escribir = new PrintWriter(salida, true);) {

            String mensaje;

            /* En esta estructura se recibe el mensaje del cliente, se lo transforma a mayúsculas,
            se lo devuelve y luego continúa hasta que el cliente envíe "salir".
             */
            do {

                mensaje = lector.readLine();
                System.out.println(mensaje);
                String mensajeMayusculas = mensaje.toUpperCase();

                escribir.println(mensajeMayusculas);

            } while (!mensaje.equals("salir"));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
