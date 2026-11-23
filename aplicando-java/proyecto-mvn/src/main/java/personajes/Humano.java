package personajes;

/**
 * Héroe de la raza humana.
 *
 * @author Luciano
 */
public class Humano extends Heroe {
    /**
     * Crea un humano.
     * @param nombre Nombre del humano.
     * @param vida Vida del humano.
     * @param armadura Armadura del humano.
     */
    public Humano (String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Humano";
    }
}
