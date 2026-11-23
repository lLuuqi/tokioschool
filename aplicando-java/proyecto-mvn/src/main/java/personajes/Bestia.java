package personajes;

/**
 * Personaje del ejercito de las Bestias
 *
 * Su ataque se basa en la tirada de un único dado de 0 a 90.
 *
 * @author Luciano
 */

public abstract class Bestia extends Personaje {
    /**
     * Crea una bestia
     *
     * @param nombre Nombre de la bestia
     * @param vida Vida de la bestia
     * @param armadura Armadura de la bestia
     */
    public Bestia(String nombre, int vida, int armadura) {
        super (nombre, vida, armadura);
    }

    /**
     * Tira un dado de 0 a 90.
     *
     * @return un valor entre 0 y 90,ambos incluidos
     */
    @Override
    protected int tirarDados() {
        return (int) (Math.random() * 91);
    }
}
