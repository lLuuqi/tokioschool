package Interfaces;

public interface CharSequenceTokio {
	
	/**
     * Devuelve la longitud de esta secuencia de caracteres.
     * @return  N�mero de chars que existen en la secuencia.
     */
    int length();

    /**
     * Devuelve el char que se situa en el �ndice indicado por index.
     * Un �ndice v�lido toma valores entre 0 y length() - 1.
     * Si el �ndice no es v�lido se devuelve el caracter cero (char con valor cero)
     *
     * @param   index   �ndice del char a ser devuelto.
     * @return  el char localizado en index o el char con valor cero si el �ndice es incorrecto.
     */
    char charAt(int index);

    /**
     * Devuelve una nueva CharSequenceTokio que es un subsecuencia de esta secuencia.
     * La subsecuencia empieza en el caracter situado en la posici�n start y acaba
     * en el caracter situado en la posici�n end - 1.
     * Si start == end se devuelve un CharSequenceTokio sin caracteres.
     * Si start no es una posici�n v�lida o si end no es una posici�n v�lida o si
     * start > end se devuelve un objeto nulo (null).
     *
     * @param   start   el �ndice de comienzo, inclu�do.
     * @param   end     el �ndice de fin, exclu�do
     * @return  La subsecuencia especificada o null si los �ndices no son v�lidos.
     */
    CharSequenceTokio subSequence(int start, int end);

    /**
     * Devuelve una representaci�n con forma de String de la secuencia de caracteres.
     * La longitud del String ser� igual a la longitud de la secuencia.
     * @return  Un String que contiene exactamente la secuencia de caracteres.
     */
    public String toString();

}
