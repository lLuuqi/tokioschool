package CalculosNumericos;

import java.util.Scanner;

public class CalculosNumericos {

    public static double logaritmoNeperiano (double numero) {

       double resultado = Math.log(numero);

        if (numero <= 0) {

            throw new ArithmeticException("El número ingresado debe ser positivo y distinto de '0'.");

        } return resultado;
    }

    public static double raizCuadrada (double numero) {

        double resultado = Math.sqrt(numero);

        if (numero <= 0) {

            throw new ArithmeticException("El número ingresado debe ser positivo y distinto de '0'.");

        } return resultado;
    }

    public static void main (String[] args) {


        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese un número: ");

        double resultado = entrada.nextDouble();

        System.out.println("El logaritmo neperiano del número ingresado es: " + logaritmoNeperiano(resultado));

        System.out.println("La raíz cuadrada del número ingresado es: " + raizCuadrada(resultado));
    }
}
