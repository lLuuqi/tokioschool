package interfaz;

import personajes.Personaje;

/**
 * Forma de crear personajes de un bando concreto.
 *
 * Es una interfaz funcional que permite pasar un metodo como parámetr, por
 * ejemplo: FabricaPersonajes::crearHeroe. Gracias a ella, una clase sirve para
 * los dos bandos.
 *
 * @param <T> tipo de personaje que se crea.
 * @author Luciano
 */
@FunctionalInterface
public interface CreadorPersonaje <T extends Personaje> {

    /**
     * Crea un personaje.
     *
     * @param tipo raza del personaje.
     * @param nombre nombre del personaje.
     * @param vida vida del personaje.
     * @param armadura armadura del personaje.
     * @return el personaje creado.
     */
    T crearPersonaje(String tipo, String nombre, int vida, int armadura);
}
