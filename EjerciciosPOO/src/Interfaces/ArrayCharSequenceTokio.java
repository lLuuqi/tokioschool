package Interfaces;

import java.util.Arrays;

public class ArrayCharSequenceTokio implements CharSequenceTokio{

    private char [] caracteres;


    @Override
    public int length() {
        return caracteres.length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= caracteres.length) {
            return 0;
        }
        return caracteres[index];
    }

    @Override
    public CharSequenceTokio subSequence(int start, int end) {

        if (start < 0 || end >= caracteres.length || start > end) {
            return null;
        }

        return new ArrayCharSequenceTokio(Arrays.copyOfRange(caracteres, start, end));
    }

    @Override
    public String toString() {
        return new String(caracteres);
    }

    public ArrayCharSequenceTokio(char [] caracteres1)  {

        this.caracteres = caracteres1;
    }

    public char[] getCaracteres() {
        return caracteres;
    }
}
