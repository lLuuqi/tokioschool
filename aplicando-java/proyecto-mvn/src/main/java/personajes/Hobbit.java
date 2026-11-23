package personajes;

/**
 * Héroe de la raza Hobbit.
 *
 * Regla especial: Tienen una disminución de potencia al atacar contra los trasgos de -10 puntos.
 *
 * @author Luciano
 */
public class Hobbit extends Heroe {

    /** Puntos de potencia que se restan al atacar un trasgo*/
    private static final int PENALIZACION_POTENCIA_TRASGO = 5;

    /**
     * Crea un hobbit.
     *
     * @param nombre Nombre del hobbit.
     * @param vida Vida del hobbit.
     * @param armadura Armadura del hobbit.
     */
    public Hobbit (String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     *
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Hobbit";
    }

    /**
     * Calcula la potencia restando la penalización de ataque contra trasgos.
     *
     * La potencia nunca baja de 0 para que los mensajes no muestren tiradas negativas.
     *
     * @param rival personaje al que se va a atacar.
     * @return la tirada normal menos la penalización de potencia si el rival es un trasgo.
     */
    @Override
    protected int calcularPotencia (Personaje rival) {

        int potencia = super.calcularPotencia(rival);

        if (rival instanceof Trasgo) {
            potencia = Math.max(0, potencia - PENALIZACION_POTENCIA_TRASGO);
        }
        return potencia;
    }
}
