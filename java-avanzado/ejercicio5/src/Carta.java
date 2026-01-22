public class Carta {

    private final Numero numero;
    private final Palo palo;


    public Carta (Numero numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Numero getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return "Carta: " + numero.getAbreviatura() + palo.getAbreviatura();
    }
}

    enum Palo {

    ESPADAS ('E'),
    BASTOS ('B'),
    COPAS ('C'),
    ORO ('O');

        private final char abreviatura;

        Palo (char abreviatura) {
            this.abreviatura = abreviatura;
        }

        public char getAbreviatura() {
            return abreviatura;
        }
    }
    enum Numero {

    AS ('1'),
    DOS ('2'),
    TRES ('3'),
    CUATRO ('4'),
    CINCO ('5'),
    SEIS ('6'),
    SIETE ('7'),
    SOTA ('S'),
    CABALLO ('C'),
    REY ('R');

    private final char abreviatura;


        Numero(char abreviatura) {
            this.abreviatura = abreviatura;
        }

        public char getAbreviatura() {
            return abreviatura;
        }
    }
