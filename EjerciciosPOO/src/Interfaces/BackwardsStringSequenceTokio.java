package Interfaces;

public class BackwardsStringSequenceTokio implements CharSequenceTokio {

    private String cadena;

    @Override
    public int length() {
        return cadena.length();
    }

    @Override
    public char charAt(int index) {

        if (index < 0 || index >= cadena.length()) {
            return 0;
        }
        return cadena.charAt(length() - 1 - index);
    }

    @Override
    public CharSequenceTokio subSequence(int start, int end) {

        if (start < 0 || end > cadena.length() || start > end) {
            return null;
        }

        String subCadena = "";

        for (int i = end -1; i >= start; i--)
            subCadena += cadena.charAt(i);

        return new BackwardsStringSequenceTokio(subCadena);
    }

    @Override
    public String toString() {
        return cadena;
    }

    public BackwardsStringSequenceTokio(String cadena2) {

        StringBuilder cadenaInvertida = new StringBuilder();

        for (int i = cadena2.length()-1; i >= 0; i--)
            cadenaInvertida.append(cadena2.charAt(i));

        this.cadena = cadenaInvertida.toString();
    }
}
