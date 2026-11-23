package personajes;

/**
 * Representa a cualquier personaje del juego, ya sea héroe o bestia.
 *
 * Es una clase abstracta: nunca se crea un "personaje"genérico, sino siempre uno de
 * un tipo concreto.
 *
 * @author Luciano
 */
public abstract class Personaje {

    /**
     * Nombre del personaje. No cambia durante el juego.
     */
    private final String nombre;

    /**
     * Vida del personaje. El personaje muere al llegar a 0 o menos.
     */
    private int vida;

    /**
     * Armadura del personaje. No cambia durante el juego.
     */
    private final int armadura;

    /**
     * Crea un personaje con sus caracteristicas iniciales.
     *
     * @param nombre   Nombre del personaje.
     * @param vida     Vida inicial del personaje.
     * @param armadura Armadura del personaje.
     */
    public Personaje(String nombre, int vida, int armadura) {

        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;

    }

    // ------------- Métodos personalizables del ataque -------------

    /**
     * Realiza la tirada de dados base del personaje.
     * <p>
     * Cada bando tiene tiradas distintas, por eso lo implementan Heroe y Bestia.
     *
     * @return el resultado de la tirada.
     */
    protected abstract int tirarDados();

    /**
     * Devuelve el nombre de la raza del personaje.
     *
     * @return el nombre de la raza.
     */
    public abstract String getRaza();

    /**
     * Metodo gancho: calcula la potencia ofensiva contra un rival concreto.
     * <p>
     * Es la tirada normal por defecto, las razas con bonificaciones o penalizaciones
     * lo redefinen.
     *
     * @param rival personaje al que se va a atacar.
     * @return la potencia ofensiva para el ataque.
     */
    protected int calcularPotencia(Personaje rival) {
        return tirarDados();
    }

    /**
     * Metodo gancho: calcula la armadura del rival que se tiene en cuenta en cada ataque.
     * <p>
     * Es la armadura real del rival por defecto. Las razas con bonificaciones o penalizaciones
     * lo modifican pero no de forma permanente.
     *
     * @param rival personaje al que se va a atacar.
     * @return la armadura efectiva del rival para el ataque.
     */
    protected int calcularArmaduraRival(Personaje rival) {
        return rival.getArmadura();
    }

    // ---------- Lógica normal del ataque ----------

    /**
     * Ataca a un rival y le resta la vida correspondiente.
     * <p>
     * Solo se produce el daño si la potencia supera los puntos de armadura del rival;
     * en ese caso, el daño es la diferencia entre ambas.
     *
     * @param rival personaje que recibe el ataque.
     * @return una linea de texto que muestra el detalle de los ataques, tanto en consola
     * como para la interfaz gráfica.
     */
    public final String atacar(Personaje rival) {

        int potencia = calcularPotencia(rival);
        int armaduraRival = calcularArmaduraRival(rival);
        // Si la potencia no supera la armadura,la resta seria negativa: daño = 0
        int danio = Math.max(0, potencia - armaduraRival);
        rival.recibirDanio(danio);

        return nombre + " saca " + potencia + " y le ha quitado " + danio +
                " de vida a " + rival.getNombre();
    }

    /**
     * Resta puntos de vida al personaje.
     *
     * @param danio puntos de vida que pierde.
     */
    public void recibirDanio(int danio) {
        vida -= danio;
    }

    /**
     * Indica si el personaje sigue vivo.
     *
     * @return verdadero si su vida es mayor que 0.
     */
    public boolean estaVivo() {
        return vida > 0;
    }

    // ---------- Getters ----------

    /**
     * Devuelve el nombre del personaje.
     *
     * @return el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la vida del personaje.
     *
     * @return la vida actual.
     */
    public int getVida() {
            return vida;
    }

    /**
     * Devuelve la armadura del personaje.
     *
     * @return la armadura.
     */
    public int getArmadura() {
            return armadura;
    }

    /**
     * Devuelve el personaje con el formato de texto por consola:
     * Legolas (Vida=150 Armadura=30)
     *
     * @return la descripción del personaje.
     */
    @Override
    public String toString() {
            return nombre + " (Vida = " + vida + " Armadura = " + armadura + ")";
    }
}
