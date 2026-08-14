package learning.tokioschool.parking;

import learning.tokioschool.parking.db.ManagerDb;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingTest {

    private static ManagerDb managerDb;

    @BeforeAll
    static void prepararBaseDeDatos() throws Exception {

        managerDb = new ManagerDb();
        managerDb.crearTabla();
    }
    @Test
    void existeCoche () {

        Parking parking = new Parking();

        Coche coche = new Coche("Seat", "Leon", LocalDateTime.now(), null);

        parking.putCoche("TEST123", coche);

        assertTrue (parking.existeCoche("TEST123"));
    }
    @Test
    void getCoche() {

        Parking parking = new Parking();

        Coche coche = new Coche(
                "Toyota",
                "Corolla",
                LocalDateTime.now(),
                null
        );

        parking.putCoche("TEST456", coche);

        Coche cocheEncontrado = parking.getCoche("TEST456");

        assertNotNull(cocheEncontrado);
        assertEquals("Toyota", cocheEncontrado.getMarca());
        assertEquals("Corolla", cocheEncontrado.getModelo());
    }
    @Test
    void getCocheNoExiste() {

        Parking parking = new Parking();

        Coche coche = parking.getCoche("NOEXISTE");

        assertNull(coche);
    }
    @Test
    void imprimirCochesSistema() {

        Parking parking = new Parking();

        Coche coche = new Coche(
                "BMW",
                "Serie 3",
                LocalDateTime.now(),
                null
        );

        parking.putCoche("TEST789", coche);

        assertDoesNotThrow(() -> parking.imprimirCochesSistema());
    }
    @Test
    void imprimirCochesParking() {

        Parking parking = new Parking();

        Coche cocheDentro = new Coche(
                "Seat",
                "Ibiza",
                LocalDateTime.now(),
                null
        );

        Coche cocheFuera = new Coche(
                "Ford",
                "Focus",
                LocalDateTime.now().minusHours(2),
                LocalDateTime.now()
        );

        parking.putCoche("TESTPARK1", cocheDentro);
        parking.putCoche("TESTPARK2", cocheFuera);

        assertDoesNotThrow(() -> parking.imprimirCochesParking());
    }
    @Test
    void cantidadAPagar() {

        Parking parking = new Parking();

        Coche coche = new Coche(
                "Audi",
                "A3",
                LocalDateTime.now().minusHours(2),
                LocalDateTime.now()
        );

        parking.putCoche("TESTPAGO1", coche);

        assertDoesNotThrow(
                () -> parking.cantidadAPagar("TESTPAGO1")
        );
    }
    @Test
    void cantidadAPagarCocheNoExiste() {

        Parking parking = new Parking();

        assertDoesNotThrow(
                () -> parking.cantidadAPagar("NOEXISTE")
        );
    }
}
