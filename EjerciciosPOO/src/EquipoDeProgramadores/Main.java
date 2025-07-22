package EquipoDeProgramadores;

import java.util.Scanner;

public class Main {

    private static Scanner entrada = new Scanner(System.in);
    private static EquipoProgramadores equipo = null;

    public static void main (String [] args) {

        System.out.println("\t\tCreación de Equipo");
        System.out.println("\t\t\t:::: :::: ::::\n");
        System.out.println("Nombre del equipo: ");
        String nombreEquipo = entrada.nextLine();
        System.out.println("Universidad que representa: ");
        String universidadEquipo = entrada.nextLine();
        System.out.println("Lenguaje de programación: ");
        String lenguajeEquipo = entrada.nextLine();

        int tamañoEquipo = 0;
        do {
            System.out.println("Integrantes del equipo (min: 2 / max: 3): ");
            tamañoEquipo = Integer.parseInt(entrada.nextLine());
        } while (tamañoEquipo < 2 || tamañoEquipo > 3);

        equipo = new EquipoProgramadores (nombreEquipo, universidadEquipo, tamañoEquipo, lenguajeEquipo);

        int opcion = 0;

        do {
            System.out.println("\t\tGestión del Equipo");
            System.out.println("\t\t:::: :::: ::::");
            System.out.println("1- Agregar programador al equipo");
            System.out.println("2- Mostrar datos del equipo");
            System.out.println("3- Finalizar");
            System.out.println("Opción: ");

            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1: nuevoProgramador();
                    break;
                case 2: mostrarEquipo(equipo);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 3);
    }
    private static void nuevoProgramador () {

        Programador nuevo = null;

        do {
            System.out.println("\n\t\tNuevo programador");
            System.out.println("\t\t\t :::: :::: ::::\n");
            System.out.println("Nombre: ");
            String nombre = entrada.nextLine();
            System.out.println("Apellido: ");
            String apellido = entrada.nextLine();

            try {
                nuevo = new Programador(nombre, apellido);
            } catch (Exception excepcion) {
                System.out.println("¡Error!: "+ excepcion.getMessage());
            }
        } while (nuevo == null);

            try {
                equipo.agregarProgramador(nuevo);

            } catch (Exception excepcion) {
                System.out.println("¡Error!: "+ excepcion.getMessage());
            }
    }

    private static void mostrarEquipo (EquipoProgramadores equipo) {
        System.out.println("\n\t\tDatos del Equipo");
        System.out.println("\t\t :::: :::: ::::\n");
        System.out.println("Nombre: " + equipo.getNombreEquipo());
        System.out.println("Universidad: " + equipo.getUniversidadEquipo());
        System.out.println("Lenguaje: " + equipo.getLenguajeEquipo());
        System.out.println("Cantidad de miembros: " + equipo.getTamañoEquipo());
        System.out.println("\t\tMiembros");
        System.out.println("\t:::: ::::");

        for (Programador prog : equipo.getProgramadores()) {
            if (prog == null)
                System.out.println("---> Miembro sin registrar");
            else
                System.out.println("---> "+ prog.getNombre() + " " + prog.getApellido());
        }
    }
}
