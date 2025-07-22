package Universidad;

import java.util.List;

public class Universidad {


    public Universidad(List<Personal> personas) {

    }

    public void imprimirNominas (List<Personal> personas) {

        for (Personal persona : personas ) {
            System.out.println(persona);
        }
    }
    public float obtenerPresupuestoTotal (List<Personal> personas) {

        float salario = 0;

        for (Personal persona : personas) {

            salario += persona.getSalario();


        } return salario;
    }
}
