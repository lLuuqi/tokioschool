package CartasComparables;

import java.util.Comparator;

public class PorNumeroIncrementalYPalo implements Comparator <Carta> {

    @Override
    public int compare(Carta carta1, Carta carta2) {
        if(carta1.equals(carta2)) {
            return 0;

    }
        else {
            if (carta1.getPalo().equals(carta2.getPalo())) {

                int posicionC1 = 0, posicionC2 = 0;

                for (int i = 0; i < Baraja.numeros.length; i++) {

                    if (carta1.getNumero().equals(Baraja.numeros[i]))
                        posicionC1 = i;
                    if (carta2.getNumero().equals(Baraja.numeros[i]))
                        posicionC2 = i;
                }
                    if (posicionC1 == posicionC2)
                        return 0; //Número es igual
                    else if (posicionC1 < posicionC2)
                        return -1; //Carta1 es menor que Carta2, devolvemos positivo para invertir el orden.
                    else
                        return 1; //Carta2 es menor que Carta1, devolvemos negativo para invertir el orden.
                }
                else
                    return carta1.getPalo().compareTo(carta2.getPalo());
            }

        }
}



