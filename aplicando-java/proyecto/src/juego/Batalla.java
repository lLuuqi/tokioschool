package juego;

import personajes.Bestia;
import personajes.Heroe;
import personajes.Personaje;

/**
 * Batalla por turnos entre un ejercito de héroes y uno de bestias.
 *
 * En cada turno se enfrentan los personajes que ocupan la misma posición
 * en cada ejército; los sobrantes no luchan. En cada lucha atacan los dos
 * personajes, primero el héroe y después la bestia, aunque el primero haya
 * matado al segundo. Al terminar cada lucha se retiran los muertos, y los
 * compañeros de posiciones posteriores avanzan para cubrir las bajas.
 *
 * @author Luciano
 */
public class Batalla {

    /**
     * Número máximo de turnos. Evita bucles infinitos si ningún personaje puede dañar
     * a su rival. (Por ejemplo, armaduras muy altas).
     */
    public static final int MAX_TURNOS = 1000;

    /** Ejercito de los héroes. */
    private final Ejercito<Heroe> heroes;

    /** Ejercito de las bestias. */
    private final Ejercito<Bestia> bestias;

    /** Texto con todo lo ocurrido en la batalla. */
    private final StringBuilder registroBatalla =  new StringBuilder();

    /**
     * Prepara una batalla entre dos ejercitos.
     *
     * @param heroes ejercito de los héroes.
     * @param bestias ejercito de las bestias.
     */
    public Batalla(Ejercito<Heroe> heroes, Ejercito<Bestia> bestias) {
        this.heroes = heroes;
        this.bestias = bestias;
    }

    /**
     * Ejecuta la batalla completa,turno a turno, hasta que uno de los dos ejercitos
     * queda sin personajes o se alcanza el máximo de turnos.
     *
     * @return el relato de la batalla, con el resultado final en la última linea.
     */
    public String combate () {

        registroBatalla.setLength(0);
        int turno = 0;

        while (!heroes.estaDerrotado() && !bestias.estaDerrotado() && turno < MAX_TURNOS) {
            turno++;
            registrar("Turno " + turno + ":");
            jugarTurno();
        }
        registrar(obtenerResultado());
        return registroBatalla.toString();
    }

    /**
     * Juega un turno: enfrenta a los personajes de cada posición y retira a los
     * derrotados después de cada lucha.
     */
    private void jugarTurno () {

        int posicion = 0;
        while (posicion < Math.min(heroes.getTamanio(), bestias.getTamanio())) {

            enfrentar (heroes.getPersonaje(posicion), bestias.getPersonaje(posicion));

            anunciarDerrotados(heroes);
            anunciarDerrotados(bestias);
            posicion++;
        }
    }

    /**
     * Enfrenta a dos personajes: primero ataca el héroe y luego la bestia.
     *
     * @param heroe personaje del ejercito de héroes.
     * @param bestia personaje del ejercito de bestias.
     */
    private void enfrentar (Personaje heroe, Personaje bestia) {

        registrar(" Lucha  entre  " + heroe + " y " + bestia);
        registrar("    " + heroe.atacar(bestia));
        registrar("    " + bestia.atacar(heroe));
    }

    /**
     * Retira a los personajes derrotados de un ejercito y anuncia
     * su muerte.
     *
     * @param ejercito ejercito que se revisa (de héroes o de bestias).
     */
    private void anunciarDerrotados(Ejercito<? extends  Personaje> ejercito) {

        for (Personaje derrotado : ejercito.eliminarDerrotados()) {

            registrar("  ¡Muere " + derrotado.getRaza() + " " + derrotado.getNombre() + "!");
        }
    }

    /**
     * Determina el resultado final de la batalla.
     *
     * Hay empate si ambos ejercitos se quedan sin personajes o si se alcanza el límite
     * de turnos.
     *
     * @return el mensaje con el resultado.
     */
    private String obtenerResultado () {

        boolean quedanHeroes = !heroes.estaDerrotado();
        boolean quedanBestias = !bestias.estaDerrotado();

        if (quedanHeroes && !quedanBestias) {
            return "¡¡VICTORIA DE LOS " + heroes.getNombre().toUpperCase() + "!!";
        }
        if (quedanBestias && !quedanHeroes) {
            return "¡¡VICTORIA DE LAS " + bestias.getNombre().toUpperCase() + "!!";
        }
        return "¡¡EMPATE!!";
    }

    /**
     * Añade una linea al registro de la batalla.
     *
     * @param texto linea que se añade.
     */
    private void registrar (String texto) {
        registroBatalla.append(texto).append('\n');
    }
}
