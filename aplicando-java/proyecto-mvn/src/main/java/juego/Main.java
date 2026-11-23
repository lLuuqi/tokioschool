package juego;

import personajes.*;

/**
 * Clase que inicia el juego en modo consola.
 *
 * Crea los ejercitos,los enfrenta y muestra el desarrollo de la batalla
 * por consola. Para el modo gráfico, ejecutar "interfaz.VentanaBatalla".
 *
 * @author Luciano
 */
public class Main {

    /**
     * Crea los ejercitos, ejecuta la batalla y muestra los resultados.
     *
     * @param args argumentos de la linea de comandos (no se usan).
     */
    public static void main(String[] args) {

        Ejercito<Heroe> heroes = new Ejercito<>("Héroes");

        heroes.agregar(new Elfo("Legolas", 150, 30));
        heroes.agregar(new Humano("Aragorn", 150, 50));
        heroes.agregar(new Humano("Boromir", 100, 60));
        heroes.agregar(new Humano("Gandalf", 300, 30));
        heroes.agregar(new Hobbit("Frodo", 20, 10));

        Ejercito<Bestia> bestias = new Ejercito<>("Bestias");

        bestias.agregar(new Orco("Lurtz", 200, 60));
        bestias.agregar(new Orco ("Shagrat", 220, 50));
        bestias.agregar(new Trasgo("Uglúk", 120, 30));
        bestias.agregar(new Trasgo("Mauhúr", 100, 30));

        Batalla batalla = new Batalla(heroes, bestias);
        System.out.println(batalla.combate());
    }
}
