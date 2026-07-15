package learning.tokioschool.parking;

import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;

public class CocheTest {

    @Test
    public void cantidadAPagarHora () {

        LocalDateTime entrada = LocalDateTime.of(2025, 1, 1, 10, 0);
        LocalDateTime salida = LocalDateTime.of(2025, 1, 1, 11, 0);

        Coche coche = new Coche ("Seat", "Leon", entrada, salida);

        float resultado = coche.cantidadAPagar();

        assertEquals (9.0f, resultado, 0.01f);
    }
    @Test
    public void cantidadAPagarMediaHora () {

        LocalDateTime entrada = LocalDateTime.of(2025, 3, 4, 12, 0);
        LocalDateTime salida = LocalDateTime.of(2025, 3, 4, 12, 30);

        Coche coche = new Coche ("Audi", "Q2", entrada, salida);

        float resultado = coche.cantidadAPagar();

        assertEquals (4.5f, resultado, 0.01f);
    }
}