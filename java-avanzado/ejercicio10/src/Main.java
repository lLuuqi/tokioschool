public class Main {
    public static void main (String[] args) {

        /**Guardamos el número '1000' en una variable*/
        int autos = 1000;

        /**Creamos el StringBuilder*/
        StringBuilder coches = new StringBuilder("Hay coches");

        /**Mostramos su contenido por consola*/
        System.out.println(coches);

        /**Mostramos la capacidad actual por consola*/
        System.out.println("Capacidad: " + coches.capacity());

        /**Mostramos la longitud actual por consola*/
        System.out.println("Longitud: " + coches.length());

        /**Añadimos a la cadena de texto el siguiente String con el metodo 'append'*/
        coches.append(" en el desguace");

        /**Mostramos el contenido actualizado por consola*/
        System.out.println(coches);

        /**Modificamos y reemplazamos partes del texto con el metodo 'replace'
         *  y la variable anteriormente declarada*/
        coches.replace(4, 4, "más de " + autos + " ");

        /**Mostramos el contenido actualizado por consola*/
        System.out.println(coches);

        /**Utilizamos el metodo 'substring' para obtener los ultimos 4 caracteres del string*/
        String ultimosDigitos = coches.substring(coches.length() - 4);

        /**Mostramos los 4 ultimos caracteres por consola*/
        System.out.println("Últimos 4 caracteres: " + ultimosDigitos);

        /**Mostramos la capacidad final por consola*/
        System.out.println("Capacidad final: " + coches.capacity());

        /**Mostramos la longitud actual por consola*/
        System.out.println("Longitud final: " + coches.length());

        System.out.println("===============================");

        /**Aquí repetimos el ejercicio anterior pero con la clase 'StringBuffer'*/
        StringBuffer cochesBuffer = new StringBuffer ("Hay coches");

        System.out.println(cochesBuffer);

        System.out.println("Capacidad: "+cochesBuffer.capacity());

        System.out.println("Longitud: "+cochesBuffer.length());

        cochesBuffer.append(" en el desguace");

        System.out.println(cochesBuffer);

        cochesBuffer.replace(4, 4, "más de "+autos+" ");

        System.out.println(cochesBuffer);

        String ultimosDigitos2 = cochesBuffer.substring(cochesBuffer.length() -4);

        System.out.println("Últimos 4 caracteres: "+ultimosDigitos2);

        System.out.println("Capacidad final: "+cochesBuffer.capacity());

        System.out.println("Longitud final: "+cochesBuffer.length());
    }
}
