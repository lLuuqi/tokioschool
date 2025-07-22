package CartasComparables;

public class Carta implements Comparable <Carta> {
	
	private final String numero;
    private final String palo;

    public Carta(String numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return the palo
     */
    public String getPalo() {
        return palo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 47 * hash + (this.palo != null ? this.palo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.palo != other.palo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numero + " " + palo;
    }

    @Override
    public int compareTo(Carta otraCarta) {
        if(otraCarta.equals(this)) {
            return 0;
        }
        else {
            if (this.palo.equals(otraCarta.palo)) {

                int posicionC1 = 0, posicionC2 = 0;

                for (int i = 0; i < Baraja.numeros.length; i++) {

                    if (this.numero.equals(Baraja.numeros[i]))
                        posicionC1 = i;

                    if (otraCarta.equals(Baraja.numeros[i]))
                        posicionC2 = i;
                }
                    if (posicionC1 == posicionC2)
                        return 0; //Número es igual

                    else if (posicionC1 < posicionC2)
                        return -1; //Carta1 es menor que Carta2
                    else
                        return 1; //Carta2 es menor que Carta1
            } else
                return this.palo.compareTo(otraCarta.palo);
        }
    }
}



