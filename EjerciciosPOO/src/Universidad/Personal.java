package Universidad;

public class Personal {

    private String nombre;
    private String cat;
    protected float salario;
    private float horas;
    private float valorHora;
    private float semanas;

    public Personal(String nombre, String DNI, String cat) {
        this.nombre = nombre;
        this.cat = cat;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void calcularSalario () {

        this.salario = (this.horas * this.valorHora) * this.semanas;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "nombre='" + nombre + '\'' +
                ", cat='" + cat + '\'' +
                ", salario=" + salario +
                '}';
    }
}

