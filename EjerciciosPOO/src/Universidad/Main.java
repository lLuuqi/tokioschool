package Universidad;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String [] args) {

        Profesores pro1 = new Profesores("Carlos", "45678890", 2, "Profesor");
        Informáticos info1 = new Informáticos("Pepe", "5687493", "Informático");
        Administrativos adm1 = new Administrativos("Julia", "43567897", "Administrativo");
        List<Personal> personas = new ArrayList<>();

        Universidad uno = new Universidad(personas);

        personas.add(pro1);
        personas.add(info1);
        personas.add(adm1);


        pro1.calcularSalario();

        info1.sumarHorasExtras(20);
        info1.sumarHorasExtras(23);
        info1.sumarHorasExtras(10);
        info1.calcularSalario();


        adm1.sumarHorasExtras(25);
        adm1.sumarHorasExtras(20);
        adm1.sumarHorasExtras(12);
        adm1.calcularSalario();

        uno.imprimirNominas(personas);
        uno.obtenerPresupuestoTotal(personas);
    }

}
