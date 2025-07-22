public class M1_10_Luciano_Pelaez {

    public static void main(String[] args) {

        String nombre, apellido;
        long numDoc;
        String fnac;

        Persona per1 = new Persona("Gonzalo", "Rodriguez", 38596809, "14/06/1993");
        Persona per2 = new Persona("Laura", "Pérez", 34567980, "05/07/1994");

        System.out.println("Nombre: "+per1.getNombre() + " " + "Apellido: "+per1.getApellido() +" "+ "DNI: "+ per1.getNumDoc() + " "+ "Fecha de nacimiento: " + per1.getFnac());
        System.out.println("Nombre: "+per2.getNombre() + " " + "Apellido: "+per2.getApellido() +" "+ "DNI: "+ per2.getNumDoc() + " "+ "Fecha de nacimiento: " + per2.getFnac());

    }

}
