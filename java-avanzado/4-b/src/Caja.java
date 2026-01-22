import java.util.ArrayList;
import java.util.List;

//Recurso común compartido
public class Caja {

    //Declaramos las variables
    private int capacidad;
    private final List<Integer> lista = new ArrayList<>(6);

    //Definimos los métodos y constructores
    public Caja (int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void producir (int valor) throws InterruptedException {

        while (lista.size() == capacidad) {

            System.out.printf("Almacen lleno, esperando consumidor...\n");
            wait();
        }

        lista.add(valor);
        System.out.printf("Produciendo: "+valor+ "cajas.\n");

        //Despierta a los consumidores
        notifyAll();
    }

    public synchronized int consumir () throws InterruptedException {

        while (lista.isEmpty()) {
            System.out.print ("Almacen vacío, esperando productor...\n");
            wait();
        }

        int valor = lista.removeFirst();
        System.out.printf("Consumiendo: "+valor+ "cajas.\n");

        //Avisa a los productores
        notifyAll();

        return valor;
    }
}
