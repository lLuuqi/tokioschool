package Coche;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main (String [] args) {


        Coche GT40 = new Coche("A310BHC", "GT40", "Ford", 485, 340);

        Coche.Chasis chasis;
        chasis = new Coche.Chasis("Carbono", 1200);
        Rueda[] ruedas = new Rueda[] {

                //Ruedas delanteras
                new Rueda("Seco", "Pirelli", "Cinturato", 215),
                new Rueda("Seco", "Pirelli", "Cinturato", 215),
                //Ruedas traseras
                new Rueda("Seco", "Pirelli", "Cinturato", 255),
                new Rueda("Seco", "Pirelli", "Cinturato", 255)
        };

        GT40.setChasis(chasis);
        GT40.setRuedas(ruedas);

        Scanner entrada = new Scanner (System.in);

        System.out.println("Bienvenido! Ingrese el modelo del coche: ");

        if (entrada.nextLine().equalsIgnoreCase("GT40")) {

            System.out.println("\t\tInformación");
            System.out.println("\t\t::: ::: :::\n");
            System.out.println("Modelo: " + GT40.getModelo());
            System.out.println("Marca: " + GT40.getMarca());
            System.out.println("Matricula: " + GT40.getMatricula());
            System.out.println("Potencia: " + GT40.getPotencia());
            System.out.println("Velocidad máxima: " + GT40.getVelocidadMax());
            System.out.println("\n\t\tInformación Adicional");
            System.out.println("\t\t\t::: ::: ::: :::\n");
            System.out.println("Ruedas delanteras/traseras: \n"+ Arrays.toString(ruedas));
            System.out.println("\nInformación del chasis: \n" + chasis);


        } else
            System.out.println("No contamos con ese modelo.");
    }

}
