package personajes;

/**
 * Bestia de la raza Troll.
 *
 * @author Luciano
 */
public class Troll extends Bestia {

    /**
     * Crea un Troll.
     *
     * @param nombre Nombre del Troll.
     * @param vida Vida del Troll.
     * @param armadura Armadura del Troll.
     */
    public Troll(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     *
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Troll";
    }
}
