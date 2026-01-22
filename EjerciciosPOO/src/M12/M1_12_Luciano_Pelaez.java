package M12;

public class M1_12_Luciano_Pelaez {

    public static void main(String[] args) {

        Bag bolso = new Bag();

        bolso.add("Coche");
        bolso.add(123);
        bolso.add("Zapato");
        bolso.add(3.14);
        bolso.add("Botella");

        System.out.println("Tamaño de la bolsa: "+bolso.size());
        System.out.println("Objeto extraído de la bolsa: "+bolso.extract());
        System.out.println("La bolsa está vacía?: "+bolso.isEmpty());
        System.out.println("La bolsa contiene este objeto?: "+bolso.contains("Zapato"));


    }
}
