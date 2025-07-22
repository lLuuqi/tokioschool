package EquipoDeProgramadores;

public class EquipoProgramadores {

    private String nombreEquipo, universidadEquipo, lenguajeEquipo;
    private int tamañoEquipo;
    private Programador [] programadores;


    public EquipoProgramadores (String nombreEquipo, String universidadEquipo, int tamañoEquipo, String lenguajeEquipo) {

        this.nombreEquipo = nombreEquipo;
        this.universidadEquipo = universidadEquipo;
        this.tamañoEquipo = tamañoEquipo;
        this.lenguajeEquipo = lenguajeEquipo;
        programadores = new Programador[tamañoEquipo];
    }

    public boolean equipoCompleto () {

        return programadores[tamañoEquipo-1] != null;
    }

    public void agregarProgramador (Programador prog) throws Exception {

        if (equipoCompleto())
            throw new Exception ("El equipo está completo, no se admiten más programadores.");
        else {
            for (int i = 0; i < tamañoEquipo; i++) {
                if (programadores[i] == null) {
                    programadores[i] = prog;
                    break;
                }
            }
        }
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getUniversidadEquipo() {
        return universidadEquipo;
    }

    public String getLenguajeEquipo() {
        return lenguajeEquipo;
    }

    public int getTamañoEquipo() {
        return tamañoEquipo;
    }

    public Programador[] getProgramadores() {
        return programadores;
    }
}
