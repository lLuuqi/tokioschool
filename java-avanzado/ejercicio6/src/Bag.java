import java.util.ArrayList;
import java.util.Random;

    public class Bag <T> {

        public ArrayList<T> objetos;

        public Bag () {

            this.objetos = new ArrayList<>();

        }

        public void add (T item) {

            this.objetos.add (item);

        }

        public void clear () {

            this.objetos.clear();

        }

        public boolean contains (T item) {

            return this.objetos.contains (item);

        }

        public boolean isEmpty () {

            return this.objetos.isEmpty();
        }

        public int size () {

            return this.objetos.size();

        }

        public T extract () {


            Random obj = new Random();

            String objeto = this.objetos.get(obj.nextInt(objetos.size())).toString();

            return (T) objeto;
        }
    }
