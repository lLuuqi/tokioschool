package personajes;

/**
 * Héroe de la raza Enanos.
 *
 * @author Luciano
 */
public class Enano extends Heroe{
    /**
     * Crea un Enano.
     * @param nombre Nombre del enano.
     * @param vida Vida del enano.
     * @param armadura Armadura del enano.
     */
    public Enano(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Enano";
    }
}
