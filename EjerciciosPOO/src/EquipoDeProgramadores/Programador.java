package EquipoDeProgramadores;

public class Programador {

    private String nombre;
    private String apellido;

    public Programador (String nombre, String apellido) throws Exception {

        this.nombre = nombre;
        this.apellido = apellido;

        if (nombre.length() >= 20 )
            throw new Exception ("El campo 'Nombre' no puede superar los 20 caracteres.");
        if (apellido.length() >= 20)
            throw new Exception ("El campo 'Apellido' no puede superar los 20 caracteres.");

        if (!cadenaEsValida(nombre))
            throw new Exception ("El campo 'Nombre' no admite caracteres numéricos, solo texto.");
        if (!cadenaEsValida(apellido))
            throw new Exception ("El campo 'Apellido' no admite caracteres numéricos, solo texto.");
    }

    private boolean cadenaEsValida (String cadena) {

        for (int i = 0; i < cadena.length(); i++) {

            char caracter = cadena.charAt(i);
            if (caracter >= '0' && caracter <= '9')
                return false;
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

