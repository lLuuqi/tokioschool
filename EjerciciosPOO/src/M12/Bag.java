import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {

    public List<Object> objetos;

    public Bag() {

       this.objetos = new ArrayList<>();

    }

    public void add(Object item) {

        this.objetos.add(item);

    }

    public void clear() {

        this.objetos.clear();

    }

    public boolean contains(Object item) {

        return this.objetos.contains(item);

    }

    public boolean isEmpty() {

        return this.objetos.isEmpty();

    }

    public int size() {

        return this.objetos.size();

    }

    public Object extract() {


        Random obj = new Random();

        String obj1 = this.objetos.get(obj.nextInt(objetos.size())).toString();

        return obj1;
    }
}
