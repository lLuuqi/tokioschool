package modulo4;

import java.util.Scanner;

public class M1_09_Luciano_Pelaez {

public static int contarVocales(String cadena) {

    int contar = 0;

    for (int i = 0; i <cadena.length() ; i++) {
        char vocal = cadena.charAt(i);

        if (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u')
            contar++;
    }
    return contar;
}

    public static void main(String[] args) {

    String palabra;

        System.out.println("Ingrese la frase/palabra: ");

        Scanner sc = new Scanner(System.in);
            palabra = sc.nextLine();
            sc.close();

        System.out.println("Cantidad de vocales: "+contarVocales(palabra.toLowerCase()));


    }
}
