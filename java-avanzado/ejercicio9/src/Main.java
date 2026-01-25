import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main (String[] args) {

        /**Creamos la colección de ciudades*/
        ArrayList <Ciudades> ciudades = new ArrayList<Ciudades>();

        /**Agregamos manualmente la información al array*/
        ciudades.add(new Ciudades("Merlo", "Buenos Aires", 80000));
        ciudades.add(new Ciudades("Padua", "Buenos Aires", 66000));
        ciudades.add(new Ciudades("Villa Carlos Paz", "Córdoba", 100000));
        ciudades.add(new Ciudades("Colón", "Entre ríos", 23000));
        ciudades.add(new Ciudades("Zárate", "Buenos Aires", 57000));

        /** ¿Cuántas ciudades hay en total? */
        System.out.println("Hay "+ciudades.size()+" ciudades en total.");

        /**Con stream obtenemos la respuesta de cuántas ciudades tienen más de 1000 habitantes*/
        long ciudadHabitantes = ciudades.stream()
             .filter(ciudades1 -> ciudades1.getProvincia().equalsIgnoreCase("Buenos Aires"))
             .filter(ciudades1 -> ciudades1.getHabitantes() > 1000).count();

        System.out.println("Las ciudades de Buenos Aires con más habitantes son: "+ciudadHabitantes);

        /**Obtenemos las provincias que hay con stream y utilizando un Set*/
        Set <String> provincia = ciudades.stream().map(Ciudades::getProvincia).collect(Collectors.toSet());

        System.out.println("Las provincias son: "+provincia);

        /**Obtenemos la cantidad de provincias diferentes*/
        System.out.println("Cantidad de provincias diferentes: "+provincia.size());

        /**Con un boolean y stream obtenemos las ciudades de Buenos Aires con más de 50000 habitantes*/
        boolean ciudadMasHabitantes = ciudades.stream()
                .anyMatch(ciudades1 -> ciudades1.getProvincia().equalsIgnoreCase("Buenos Aires")
                && ciudades1.getHabitantes() > 50000);

        System.out.println("¿Hay ciudades de Buenos Aires con más de '50.000' habitantes?: "+ciudadMasHabitantes);

    }
}
