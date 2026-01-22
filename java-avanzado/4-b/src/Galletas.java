//Productor
public class Galletas implements Runnable {

    public Caja cajaGalletas;
    private int contador = 0;

    public Galletas (Caja cajaGalletas) {
        this.cajaGalletas = cajaGalletas;
    }

    @Override
    public void run() {

        //Estimamos el tiempo de producción
        try {
            while (true) {
                cajaGalletas.producir (contador++);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
