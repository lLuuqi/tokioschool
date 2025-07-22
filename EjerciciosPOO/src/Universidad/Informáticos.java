package Universidad;

public class Informáticos extends PAS {

    private float horas = 40f;
    private float valorHora = 6f;
    private float semanas = 4;

    public Informáticos (String nombre, String DNI, String cat) {
        super(nombre, DNI, cat);

    }

    @Override
    public void calcularSalario() {
        super.calcularSalario();

        this.salario = (horas * valorHora) * semanas;
        this.salario += (horasExtras * 6);
        this.horasExtras = 0;


    }
}
