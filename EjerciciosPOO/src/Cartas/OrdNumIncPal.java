package M1_T06_P25;

import java.util.List;

public class OrdNumIncPal extends AlgoritmoOrdenacion {

    @Override
    public void ordena(List listaCartas) {
        // Algoritmo de ordenación (Criterio Burbuja)

        for (int i = 0; i < listaCartas.size() - 1; i++) {
            for (int j = 0; j < listaCartas.size() - i - 1; j++) {
                    int comparar = comparadorCarta((Carta) listaCartas.get(j), (Carta) listaCartas.get(j + 1));

                if (comparar > 0) {
                    Object aux = listaCartas.get(j + 1);
                    listaCartas.set(j + 1, listaCartas.get(j));
                    listaCartas.set(j, aux);
                }
            }
        }
    }

    public static int comparadorCarta(Carta c1, Carta c2) {

        if (c1.equals(c2))

            return 0;

        else {

            if (c1.getNumero() == c2.getNumero())

                return c1.getPalo().compareTo(c2.getPalo());

            else {


                int posicionC1 = 0, posicionC2 = 0;

                for (int i = 0; i < Baraja.numeros.length; i++) {

                    if (c1.getNumero().equals(Baraja.numeros[i]))
                        posicionC1 = i;
                    if (c2.getNumero().equals(Baraja.numeros[i]))
                        posicionC2 = i;
                }

                if (posicionC1 == posicionC2)

                    return 0; //Número es igual

                else if (posicionC1 < posicionC2)

                    return -1; //Carta 1 es menor que Carta 2

                else
                    return 1; //Carta 2 es menor que Carta 1
            }

        }
    }

}
