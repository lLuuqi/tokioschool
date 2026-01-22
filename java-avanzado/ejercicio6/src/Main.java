import java.util.Objects;

public class Main {
    public static void main (String[] args) {

        Bag <Object> bolsa = new Bag<>();

        bolsa.add("PELOTA");
        bolsa.add(3.14);
        bolsa.add(2);
        bolsa.add(3456);
        bolsa.add("AUTO");

        System.out.println("Hay pelota?: "+bolsa.contains("PELOTA"));
        System.out.println("La bolsa esta vacía?: "+bolsa.isEmpty());
        System.out.println("Cuántos objetos hay en la bolsa?: "+bolsa.size());
        System.out.println("Dame un objeto: "+bolsa.extract());
        bolsa.clear();
        System.out.println("Bolsa vacía?: "+bolsa.isEmpty());


    }
}
