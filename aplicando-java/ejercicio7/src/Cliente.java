import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Esta clase permite la conexión con el servidor, escribir un mensaje por consola
 * para ser enviado y recibirlo transformado a mayúsculas por el servidor.
 */
public class Cliente {
    /**
     * Este método establece la conexión con el servidor y gestiona el envío de mensajes y recepción
     * de respuestas por parte del servidor.
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {

        try (Socket conecta = new Socket("localhost", 5000);
             Scanner teclado = new Scanner(System.in);
             OutputStream salida = conecta.getOutputStream();
             PrintWriter escribir = new PrintWriter(salida, true);
             InputStream entrada = conecta.getInputStream();
             InputStreamReader leer =  new InputStreamReader(entrada);
             BufferedReader lector = new BufferedReader(leer);){

            String mensaje;
        /* El cliente solicita/lee un mensaje escrito por consola, lo envía al servidor y
        aguarda la respuesta. Muestra la respuesta recibida y realiza la comprobación.
        El bucle se repite hasta que el cliente escriba la palabra "salir".
         */
            do {
                mensaje = teclado.nextLine();
                escribir.println(mensaje);

                String respuesta =  lector.readLine();
                System.out.println(respuesta);

            } while(!mensaje.equals("salir"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
