//Clase main
public class FabricaGalletas {

   public static void main(String[] args) {

        Caja cajaDeGalletas = new Caja(6);

        Thread productor = new Thread(new Galletas(cajaDeGalletas));
        Thread consumidor = new Thread(new Publico(cajaDeGalletas));

        productor.start();
        consumidor.start();
    }
}
