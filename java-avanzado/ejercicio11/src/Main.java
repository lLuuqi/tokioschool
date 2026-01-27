import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {

        /**Definimos la coleccion de datos*/
        List<Persona> datos = new ArrayList<>();

        /**Añadimos los datos a la coleccion*/
        datos.add(new Persona("Pedro", "38567890", "pedrope98_@gmail.com"));
        datos.add(new Persona("Maria", "40565800", "mariaramos10@gmail.com"));
        datos.add(new Persona("Carlos", "343320210", "@gmail.com"));
        datos.add(new Persona("Oscar", "41567110", "oscar.gomez@gmail.es"));
        datos.add(new Persona("Rodrig0", "3255770", "rodriro23@gmail.com"));
        datos.add(new Persona("Lucrecia", "29447790", "lucr3ci@@gmail.com"));

        /**Recorremos la lista de personas para ir validando una por una más adelante*/
        for (Persona p : datos) {
            personaValida (p);
        }

    }
    /**Creamos el metodo 'personaValida' para poder hacer uso de la validacion en el 'for'*/
    public static void personaValida (Persona p) {

        boolean esValido = true;
        System.out.println("\nValidación en progreso de: "+p.getNombre());

        /**Declaramos las sentencias para saber si es valida o no cada persona*/
        if (!validarNombre (p.getNombre())) {
            System.out.println("¡Error! -> Nombre no valido.");
            esValido = false;
        }
        if (!validarDni (p.getDni())) {
            System.out.println("¡Error! -> DNI no valido.");
            esValido = false;
        }
        if (!validarEmail (p.getEmail())) {
            System.out.println("¡Error! -> Email no valido.");
            esValido = false;
        }
    }
    /**Creamos los metodos con cada validacion para su posterior uso en las sentencias*/
    private static boolean validarNombre(String nombre) {
        return nombre.matches("[a-zA-Z][^0-9]+");
    }

    private static boolean validarDni(String dni) {
        return dni.matches("^[0-9]{8}$");
    }

    private static boolean validarEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
