public class Persona {

    String nombre, apellido;
    long numDoc;
    String fnac;

    Persona (String nombre, String apellido, long numDoc, String fnac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fnac = fnac;
        this.numDoc = numDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(long numDoc) {
        this.numDoc = numDoc;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }
}
