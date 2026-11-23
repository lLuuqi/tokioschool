package personajes;

/**
 * Personaje del ejercito de los Héroes.
 *
 * Su ataque se basa en la tirada de dos dados de 0 a 100 incluidos, de los que se elige el
 * mayor valor.
 *
 * @author Luciano
 */
public abstract class Heroe extends Personaje {
    /**
     * Crea un Héroe.
     * @param nombre Nombre del héroe.
     * @param vida Vida del héroe.
     * @param armadura Armadura del héroe.
     */
    public Heroe(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Tira dos dados de 0 a 100 y devuelve el mayor.
     *
     * @return un valor entre 0 y 100, ambos incluidos.
     */
    @Override
    protected int tirarDados() {
        //Math.random() nunca llega a 1, así que multiplicamos por 101 para que el 100 sea posible.
        int dados1 = (int) (Math.random() * 101);
        int dados2 = (int) (Math.random() * 101);

        return Math.max(dados1, dados2);
    }
}
