package personajes;

/**
 * Bestia de la raza Orco.
 *
 * Regla especial: Su ataque reduce la armadura del rival un 10%. La reducción se aplica
 * a ese ataque; la armadura real del rival no se modifica.
 *
 * @author Luciano
 */
public class Orco extends Bestia {

    /** Porcentaje en que se reduce la armadura del rival atacado. */
    private static final int PORCENTAJE_REDUCCION_ARMADURA = 10;

    /**
     * Crea un Orco.
     *
     * @param nombre Nombre del Orco.
     * @param vida Vida del Orco.
     * @param armadura Armadura del Orco.
     */
    public Orco (String nombre, int vida, int armadura) {
        super(nombre, vida, armadura);
    }

    /**
     * Metodo que devuelve el nombre de la raza.
     *
     * @return nombre de la raza.
     */
    @Override
    public String getRaza() {
        return "Orco";
    }

    /**
     * Calcula la armadura del rival reducida para cada ataque.
     *
     * Se calcula * 90/100 en lugar de * 0.9 para evitar errores de redondeos con decimales.
     *
     * @param rival personaje al que se va a atacar.
     * @return la armadura del rival reducida un 10%.
     */
    @Override
    protected int calcularArmaduraRival(Personaje rival) {
        return rival.getArmadura() * (100 - PORCENTAJE_REDUCCION_ARMADURA) / 100;
    }
}
