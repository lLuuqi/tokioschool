package Universidad;

public class Administrativos extends PAS {

    private float horas = 37f;
    private float valorHora = 7.5f;
    private float semanas = 4;

    public Administrativos(String nombre, String DNI, String cat) {
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
