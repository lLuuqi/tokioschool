package juego;

import personajes.Personaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Ejercito formado por una lista ordenada de personajes.
 *
 * La clase es genérica para que el compilador evite mezclar los bandos.
 *
 * @param <T> tipo de personaje que forma el ejercito.
 *
 * @author Luciano
 */
public class Ejercito <T extends Personaje> {

    /** Nombre del ejercito (Héroes o Bestias). */
    private final String nombre;

    /** Personajes del ejercito, en orden de posición. */
    private final List<T> personajes = new ArrayList<>();

    /**
     * Crea un ejercito vacío.
     *
     * @param nombre nombre del ejercito.
     */
    public Ejercito (String nombre) {
        this.nombre = nombre;
    }

    /**
     * Añade un personaje al final del ejercito.
     *
     * @param personaje personaje que se incorpora.
     */
    public void agregar (T personaje) {
        personajes.add (personaje);
    }

    /**
     * Devuelve el personaje de una posición.
     *
     * @param posicion posición del personaje, empezando en 0.
     * @return el personaje de esa posición.
     * @throws IndexOutOfBoundsException si la posición no existe
     */
    public T getPersonaje (int posicion) {
        return personajes.get(posicion);
    }

    /**
     * Devuelve el número de personajes del ejercito.
     *
     * @return el número de personajes.
     */
    public int getTamanio () {
        return personajes.size();
    }

    /**
     * Indica si el ejercito se ha quedado sin personajes.
     *
     * @return true si no le queda ningún personaje.
     */
    public boolean estaDerrotado () {
        return personajes.isEmpty();
    }

    /**
     * Elimina del ejercito a los personajes derrotados.
     *
     * Al ser eliminados, los personajes de posiciones posteriores avanzan para cubrir
     * las bajas.
     *
     * @return los personajes eliminados, para poder anunciar su muerte.
     */
    public List<T> eliminarDerrotados () {

        List<T> derrotados = new ArrayList<>();

        Iterator<T> iterador = personajes.iterator();

        while (iterador.hasNext()) {
            T personaje = iterador.next();

            if (!personaje.estaVivo()) {
                derrotados.add(personaje);
                iterador.remove();
            }
        } return derrotados;
    }

    /**
     * Sube un personaje una posición, intercambiándolo con el anterior.
     * Si ya es el primero, no hace nada.
     *
     * @param posicion posición del personaje que se sube.
     */
    public void subir (int posicion) {
        if (posicion > 0 && posicion < personajes.size()) {
            Collections.swap(personajes, posicion, posicion - 1);
        }
    }

    /**
     * Baja un personaje una posición, intercambiándolo con el siguiente.
     * Si ya es el último, no hace nada.
     *
     * @param posicion posición del personaje que se baja.
     */
    public void bajar (int posicion) {
        if (posicion >= 0 && posicion < personajes.size() - 1) {
            Collections.swap(personajes, posicion, posicion + 1);
        }
    }

    /**
     * Elimina el personaje de una posición. Si la posición no existe, no
     * hace nada.
     *
     * @param posicion posición del personaje que se elimina.
     */
    public void eliminar (int posicion) {
        if (posicion >= 0 && posicion < personajes.size()) {
            personajes.remove(posicion);
        }
    }

    /**
     * Devuelve los personajes del ejercito en una lista de solo lectura, para que sólo puedan
     * modificarse con los métodos de esta clase.
     *
     * @return la lista de personajes, no modificable.
     */
    public List<T> getPersonajes () {
        return Collections.unmodifiableList(personajes);
    }

    /**
     * Devuelve el nombre del ejercito.
     *
     * @return el nombre.
     */
    public String getNombre () {
        return nombre;
    }
}
