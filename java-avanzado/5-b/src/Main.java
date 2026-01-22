public class Main {

    public static void main (String[] args) {

        Carta carta = new Carta(Numero.AS, Palo.BASTOS);
        Carta carta2 = new Carta(Numero.REY, Palo.ORO);
        Carta carta3 = new Carta(Numero.SIETE, Palo.COPAS);
        Carta carta4 = new Carta(Numero.SEIS, Palo.ESPADAS);

        System.out.println(carta);
        System.out.println(carta2);
        System.out.println(carta3);
        System.out.println(carta4);
    }
}
