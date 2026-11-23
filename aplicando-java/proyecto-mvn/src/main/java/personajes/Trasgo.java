package personajes;

/**
 * Bestia de la raza Trasgo.
 *
 * @author Luciano
 */
public class Trasgo extends Bestia {

    /**
     * Crea un Trasgo.
     *
     * @param nombre Nombre del Trasgo.
     * @param vida Vida del Trasgo.
     * @param armadura Armadura del Trasgo.
     */
    public Trasgo (String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     *
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Trasgo";
    }
}
