package personajes;

/**
 * Héroe de la raza Elfos.
 *
 * Regla especial: Su potencia ofensiva aumenta en 10 si el enemigo es un Orco
 *
 * @author Luciano
 */
public class Elfo extends Heroe {

    /** Puntos de potencia extra al atacar a un Orco. */
    private static final int BONUS_CONTRA_ORCOS = 10;

    /**
     * Crea un Elfo.
     *
     * @param nombre Nombre del Elfo.
     * @param vida Vida del Elfo.
     * @param armadura Armadura del Elfo.
     */
    public Elfo (String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     *
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Elfo";
    }

    /**
     * Calcula la potencia ofensiva sumando el bonus contra orcos.
     *
     * @param rival personaje al que se va a atacar
     * @return la tirada normal, más el bonus si el rival es un Orco.
     */
    @Override
    protected int calcularPotencia(Personaje rival) {

        int potencia = super.calcularPotencia(rival);

        if (rival instanceof Orco) {
            potencia += BONUS_CONTRA_ORCOS;
        }
        return potencia;
    }
}
