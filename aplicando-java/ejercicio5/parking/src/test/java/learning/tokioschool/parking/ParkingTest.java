package learning.tokioschool.parking;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ParkingTest {

    private Parking parking;

    @Before
    public void setUp() {
        parking = new Parking();
    }
    @Test
    public void testPutCoche () {

        Coche coche = new Coche("Volskwagen", "Bora", LocalDateTime.now(), null);
        parking.putCoche("3241ABC", coche);

        assertTrue(parking.existeCoche("3241ABC"));
    }
    @Test
    public void testExisteCoche () {

        Coche coche =  new Coche("Ford", "Focus", LocalDateTime.now(), null);
        parking.putCoche("5432ABC", coche);

        assertTrue(parking.existeCoche("5432ABC"));
    }
    @Test
    public void testNoExisteCoche () {

        assertFalse(parking.existeCoche("8765AAA"));
    }
    @Test
    public void testGetCoche () {

        Coche coche = new Coche ("Audi", "A3", LocalDateTime.now(), null);
        parking.putCoche("3241ABC", coche);

        Coche resultado =  parking.getCoche("3241ABC");
        assertEquals(resultado, coche);
    }
    @Test
    public void testImprimirCochesSistema () {

        Coche coche = new Coche ("Chevrolet", "Corvette", LocalDateTime.now(), null);
        parking.putCoche("3241ABC", coche);

        //Guardamos la consola principal
        PrintStream consolaPrincipal = System.out;
        //Creamos una consola secundaria (o falsa) para guardar lo que se imprimiría por pantalla
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        //Ejecutamos el metodo
        parking.imprimirCochesSistema();
        //Restauramos la consola principal
        System.setOut(consolaPrincipal);
        //Comprobamos que la matricula existe
        assertTrue(salida.toString().contains("3241ABC"));
    }
    @Test
    public void testImprimirCochesParking () {

        Coche coche = new Coche ("Fiat", "500L", LocalDateTime.now(), null);
        parking.putCoche("8796OPE", coche);

        PrintStream consolaPrincipal = System.out;

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        parking.imprimirCochesParking();

        System.setOut(consolaPrincipal);

        assertTrue(salida.toString().contains("8796OPE"));
    }
    @Test
    public void testNoImprimirCocheFueraParking () {

        Coche coche = new Coche ("Fiat", "500X", LocalDateTime.now(), null);
        parking.putCoche("2234IUA", coche);

        PrintStream consolaPrincipal = System.out;

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        parking.imprimirCochesParking();

        System.setOut(consolaPrincipal);
        assertTrue(salida.toString().contains("2234IUA"));
    }
    @Test
    public void testCantidadAPagar () {

        LocalDateTime entrada = LocalDateTime.of(2025, 3, 4, 12, 0);
        LocalDateTime salida = LocalDateTime.of(2025, 3, 4, 13, 30);

        Coche coche = new Coche ("Audi", "A5", entrada, salida);
        parking.putCoche("2554JKL", coche);

        PrintStream consolaPrincipal = System.out;

        ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaConsola));

        parking.cantidadAPagar("2554JKL");
        System.setOut(consolaPrincipal);

        assertTrue(salidaConsola.toString().contains("13.5"));
    }
}
