public class Ciudades {

    private String nombre;
    private String provincia;
    private int habitantes;

    /**Constructor de la clase Ciudades*/
    public Ciudades (String nombre, String provincia, int habitantes) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.habitantes = habitantes;
    }
    /**Sus respectivos Getter and Setters*/
    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia () {
        return provincia;
    }

    public void setProvincia (String provincia) {
        this.provincia = provincia;
    }

    public double getHabitantes () {
        return habitantes;
    }

    public void setHabitantes (int habitantes) {
        this.habitantes = habitantes;
    }
}
