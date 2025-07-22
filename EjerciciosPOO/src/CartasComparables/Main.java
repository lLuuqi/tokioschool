package CartasComparables;

public class Main {

        public static void main(String[] args) {

            Baraja baraja = new Baraja();
            Mazo mazo = baraja.getMazo();
            System.out.println("Baraja original: ");
            System.out.println(mazo.toString());

            mazo.ordena();
            System.out.println("\nOrdenado NATURAL(por número incrementando y palo): ");
            System.out.println(mazo.toString());

            mazo.ordena(new ComparadorDeCartas.PorPaloYPorNumeroDecreciente());
            System.out.println("\nOrdenado por número decrementado y palo: ");
            System.out.println(mazo.toString());

            mazo.ordena(new PorNumeroIncrementalYPalo());
            System.out.println("\nOrdenado número incrementado y palo: ");
            System.out.println(mazo.toString());


        }

    }
