package juego;

import personajes.*;

/**
 * Clase que crea personajes a partir del nombre de su raza.
 *
 * Los nombres de los tipos deben coincidir con lo que devuelve
 * Personaje.getRaza() de cada raza.
 *
 * @author Luciano
 */
public final class FabricaPersonajes {

    /** Razas de héroes disponibles. */
    public static final String [] TIPOS_HEROE = {"Elfo", "Humano", "Hobbit", "Enano"};

    /** Razas de bestias disponibles. */
    public static final String [] TIPOS_BESTIA = {"Orco", "Trasgo", "Troll", "Nazgul", "Urukhai"};

    /** Constructor privado: clase de utilidad y no se crean objetos de ella. */
    private FabricaPersonajes(){

    }

    /**
     * Crea un héroe de la raza indicada.
     *
     * @param tipo raza del héroe.
     * @param nombre nombre del héroe.
     * @param vida vida del héroe.
     * @param armadura armadura del héroe.
     *
     * @return el héroe creado.
     * @throws IllegalArgumentException si la raza no existe.
     */
    public static Heroe crearHeroe(String tipo, String nombre, int vida, int armadura){

        return switch (tipo) {
            case "Elfo" -> new Elfo(nombre, vida, armadura);
            case "Humano" -> new Humano(nombre, vida, armadura);
            case "Hobbit" -> new Hobbit(nombre, vida, armadura);
            case "Enano" -> new Enano(nombre, vida, armadura);
            default -> throw new IllegalArgumentException("Tipo de héroe desconocido: " + tipo);
        };
    }

    /**
     * Crea una bestia de la raza indicada.
     *
     * @param tipo raza de la bestia.
     * @param nombre nombre de la bestia.
     * @param vida vida de la bestia.
     * @param armadura armadura de la bestia.
     * @return la bestia creada.
     * @throws IllegalArgumentException si la raza no existe.
     */
    public static Bestia crearBestia(String tipo, String nombre, int vida, int armadura){
        return switch (tipo) {
            case "Orco" -> new Orco(nombre, vida, armadura);
            case "Trasgo" -> new Trasgo(nombre, vida, armadura);
            case "Troll" -> new Troll(nombre, vida, armadura);
            case "Nazgul" -> new Nazgul(nombre, vida, armadura);
            case "Urukhai" -> new Urukhai(nombre, vida, armadura);
            default -> throw new IllegalArgumentException("Tipo de bestia desconocido: " + tipo);
        };
    }
}
