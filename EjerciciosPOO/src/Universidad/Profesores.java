package Universidad;

public class Profesores extends PDI {

    private float horas = 37f;
    private float valorHora = 8f;
    private float semanas = 4;
    private int sexenios;

    public Profesores(String nombre, String DNI, int sexenios, String cat) {
    super(nombre, DNI, cat);

        this.sexenios = sexenios;
    }

    @Override
    public void calcularSalario() {
        super.calcularSalario();

        if (this.sexenios <= 6 && this.sexenios >= 1) {
            this.sexenios = sexenios * 100;
        }
        this.salario = (horas * valorHora) * semanas;
        this.salario += this.sexenios;

    }

}
