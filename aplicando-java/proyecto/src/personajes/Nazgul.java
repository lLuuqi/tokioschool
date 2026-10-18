package personajes;

/**
 * Bestia de la raza Nazgûl. (Añadida como ampliación)
 *
 * Regla especial: Su potencia ofensiva aumenta 10 puntos si el rival es un Hobbit.
 *
 * @author Luciano
 */
public class Nazgul extends Bestia{

    /** Puntos de potencia extra si el rival es un Hobbit. */
    private static final int BONUS_CONTRA_HOBBIT = 10;

    /**
     * Crea un nazgûl.
     *
     * @param nombre Nombre del nazgûl.
     * @param vida Vida del nazgûl.
     * @param armadura Armadura del nazgûl.
     */
    public Nazgul(String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     *
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Nazgul";
    }

    /**
     * Calcula la potencia ofensiva sumando el bonus si el rival es un Hobbit.
     *
     * @param rival personaje al que se va a atacar.
     * @return la tirada normal, más el bonus si el rival es un Hobbit.
     */
    @Override
    protected int calcularPotencia(Personaje rival) {

        int potencia = super.calcularPotencia(rival);

        if(rival instanceof Hobbit) {
            potencia += BONUS_CONTRA_HOBBIT;
        }   return potencia;
    }
}
