package personajes;

/**
 * Bestia de la raza Uruk'hai.
 *
 * @author Luciano
 */
public class Urukhai extends Bestia {

    /**
     * Crea un Uruk'hai
     *
     * @param nombre Nombre del Uruk'hai.
     * @param vida Vida del Uruk'hai.
     * @param armadura Armadura del Uruk'hai.
     */
    public Urukhai(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     *
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Urukhai";
    }
}
