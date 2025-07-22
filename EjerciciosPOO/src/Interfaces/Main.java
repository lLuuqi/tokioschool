package Interfaces;

public class Main {

    public static void main (String args []) {

        ArrayCharSequenceTokio texto = new ArrayCharSequenceTokio(new char[] {'H', 'o', 'l', 'a'});

        System.out.println("Cadena normal: "+ texto);

        BackwardsStringSequenceTokio texto2 = new BackwardsStringSequenceTokio("Invertido");

        System.out.println("Cadena invertida: "+ texto2);
    }
}


