package Universidad;

public class PAS extends Personal {

    protected int horasExtras;

    public PAS(String nombre, String DNI, String cat) {
        super(nombre, DNI, cat);


    }

    public void sumarHorasExtras (int horasExtras) {

        this.horasExtras = horasExtras;

    }



}
