//Consumidor
public class Publico implements Runnable{

    public Caja cajaGalletas;

    public Publico(Caja cajaGalletas) {
        this.cajaGalletas = cajaGalletas;
    }

    @Override
    public void run() {

        //Estimamos el tiempo de consumo
        try {
            while (true) {
                cajaGalletas.consumir();
                Thread.sleep(3000);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
