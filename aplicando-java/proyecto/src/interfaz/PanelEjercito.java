package interfaz;

import juego.Ejercito;
import personajes.Personaje;

import javax.swing.*;
import java.awt.*;

/**
 * Panel para crear y ordenar el ejercito de un bando.
 * Contiene un formulario para añadir personajes y una lista con los
 * botones Subir, Bajar y Eliminar. Es genérico, de modo que la misma clase
 * sirve para el panel de héroes y para el de bestias.
 *
 * @param <T> tipo de personajes del ejercito.
 * @author Luciano
 */
public class PanelEjercito <T extends Personaje> extends JPanel {

    /** Ejército que se configura en este panel. Nunca participa directamente en una batalla. */
    private final Ejercito<T> ejercito;

    /** Forma de crear los personajes de este bando. */
    private final CreadorPersonaje<T> creador;

    /** Campo para el nombre del personaje. */
    private final JTextField campoNombre = new JTextField(12);

    /** Desplegable con las razas del bando. */
    private final JComboBox<String> comboTipo;

    /** Campo para los puntos de vida. */
    private final JTextField campoVida = new JTextField(12);

    /** Campo para el nivel de armadura. */
    private final JTextField campoArmadura = new JTextField(12);

    /** Modelo con los textos que muestra la lista. */
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();

    /** Lista visible con los personajes del ejército. */
    private final JList<String> lista = new JList<>(modeloLista);

    /**
     * Crea el panel de un bando.
     *
     * @param titulo titulo del panel y nombre del ejercito.
     * @param tipos razas que aparecen en el desplegable.
     * @param creador forma de crear los personajes de este bando.
     */
    public PanelEjercito(String titulo, String[] tipos, CreadorPersonaje<T> creador) {
        this.ejercito = new Ejercito<>(titulo);
        this.creador = creador;
        this.comboTipo = new JComboBox<>(tipos);

        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(titulo),
                BorderFactory.createEmptyBorder(5, 8, 8, 8)));

        add(crearFormulario(), BorderLayout.NORTH);
        add(crearPanelLista(), BorderLayout.CENTER);
    }

    // ---------- Construcción de la interfaz ----------

    /**
     * Construye el formulario para añadir personajes.
     *
     * @return el panel con los campos y botón "Añadir".
     */
    private JPanel crearFormulario() {

        JPanel campos = new JPanel(new  GridLayout(4, 2, 5, 5));
        campos.add(Estilos.crearEtiqueta("Nombre:"));
        campos.add(campoNombre);
        campos.add(Estilos.crearEtiqueta("Tipo:"));
        campos.add(comboTipo);
        campos.add(Estilos.crearEtiqueta("Vida:"));
        campos.add(campoVida);
        campos.add(Estilos.crearEtiqueta("Armadura:"));
        campos.add(campoArmadura);

        JButton botonAnadir = new JButton("Añadir");
        Estilos.estilizarBoton(botonAnadir, Estilos.COLOR_BOTON, Estilos.FUENTE_BOTON);
        botonAnadir.addActionListener(e -> anadirPersonaje());

        JPanel panelBoton = new JPanel(new BorderLayout(5, 5));
        panelBoton.add(botonAnadir);

        JPanel formulario = new JPanel(new BorderLayout(5, 5));
        formulario.add(campos, BorderLayout.CENTER);
        formulario.add(botonAnadir, BorderLayout.SOUTH);
        return formulario;
    }

    /**
     * Construye la lista de personajes con los botones de ordenación.
     *
     * @return el panel con la lista y los botones "Subir", "Bajar" y "Eliminar".
     */
    private JPanel crearPanelLista() {

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setVisibleRowCount(6);

        JButton botonSubir = new JButton("Subir");
        JButton botonBajar = new JButton("Bajar");
        JButton botonEliminar = new JButton("Eliminar");

        Estilos.estilizarBoton(botonSubir, Estilos.COLOR_BOTON, Estilos.FUENTE_BOTON);
        Estilos.estilizarBoton(botonBajar, Estilos.COLOR_BOTON, Estilos.FUENTE_BOTON);
        Estilos.estilizarBoton(botonEliminar, Estilos.COLOR_BOTON, Estilos.FUENTE_BOTON);

        botonSubir.addActionListener(e -> subirSeleccionado());
        botonBajar.addActionListener(e -> bajarSeleccionado());
        botonEliminar.addActionListener(e -> eliminarSeleccionado());

        JPanel botones = new JPanel(new GridLayout(1, 3, 5, 0));
        botones.add(botonSubir);
        botones.add(botonBajar);
        botones.add(botonEliminar);

        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);
        return  panel;
    }

    // ---------- Acciones de los botones ----------

    /**
     * Valida los datos del formulario y, si son correctos, añade el personaje
     * al final del ejercito. Si no lo son, muestra un mensaje de error.
     */
    private void anadirPersonaje() {

        String nombre = campoNombre.getText().trim();

        if (nombre.isEmpty()) {
            mostrarError("El nombre no puede estar vacío.");
            return;
        }

        int vida;
        int armadura;
        try {

            vida = Integer.parseInt(campoVida.getText().trim());
            armadura = Integer.parseInt(campoArmadura.getText().trim());

        } catch (NumberFormatException e) {

            mostrarError("La vida y la armadura deben ser números enteros.");
            return;
        }

        if(vida <= 0 || armadura < 0) {

            mostrarError("La vida debe ser mayor que 0 " +
                    "y la armadura no puede ser un número negativo.");
            return;
        }

        String tipo = comboTipo.getItemAt(comboTipo.getSelectedIndex());
        ejercito.agregar(creador.crearPersonaje(tipo, nombre, vida, armadura));
        actualizarLista(ejercito.getTamanio() - 1);
        limpiarFormulario();
    }

    /** Sube una posición el personaje seleccionado. */
    private void subirSeleccionado() {

        int posicion = obtenerSeleccion();
        if (posicion == -1) return;
        ejercito.subir(posicion);
        actualizarLista(Math.max(0, posicion - 1));
    }

    /** Baja una posición el personaje seleccionado. */
    private void bajarSeleccionado() {

        int posicion = obtenerSeleccion();
        if (posicion == -1) return;
        ejercito.bajar(posicion);
        actualizarLista(Math.min(ejercito.getTamanio() - 1, posicion + 1));
    }

    /** Elimina del ejercito el personaje seleccionado. */
    private void eliminarSeleccionado() {
        int posicion = obtenerSeleccion();
        if (posicion == -1) return;
        ejercito.eliminar(posicion);
        actualizarLista(Math.min(posicion, ejercito.getTamanio() - 1));
    }

    // ---------- Métodos que usa la ventana principal ----------

    /**
     * Indica si el ejercito de este panel no tiene personajes.
     *
     * @return true si el ejercito está vacío.
     */
    public boolean estaVacio() {
        return ejercito.estaDerrotado();
    }

    /**
     * Crea un ejercito nuevo con personajes nuevos e idénticos a los del panel.
     *
     * La batalla resta vida y elimina a los derrotados. Luchando con una copia,
     * el ejército configurado queda intacto y la batalla puede repetirse.
     *
     * @return una copia del ejercito, lista para luchar.
     */
    public Ejercito<T> crearCopiaEjercito() {

        Ejercito<T> copia = new Ejercito<>(ejercito.getNombre());

        for(T p : ejercito.getPersonajes()) {
            copia.agregar(creador.crearPersonaje(p.getRaza(),
                    p.getNombre(), p.getVida(), p.getArmadura()));
        }
        return copia;
    }

    // ---------- Métodos auxiliares ----------

    /**
     * Devuelve la posición seleccionada en la lista. Si no hay ninguna,
     * avisa al usuario.
     *
     * @return la posición seleccionada o -1 si no hay selección.
     */
    private int obtenerSeleccion() {

        int posicion = lista.getSelectedIndex();

        if (posicion == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un personaje de la lista.",
                    "Ningún personaje seleccionado.", JOptionPane.INFORMATION_MESSAGE);
        }
        return posicion;
    }

    /**
     * Vuelve a llenar la lista a partir del ejército, que es la única fuente
     * de datos, y selecciona una posición.
     *
     * @param posicionSeleccionada posición que queda seleccionada; si no es válida
     *                             no se selecciona nada.
     */
    private void actualizarLista(int posicionSeleccionada) {
        modeloLista.clear();
        for (T p : ejercito.getPersonajes()) {
            modeloLista.addElement(p.getNombre() + " - " + p.getRaza() + " - "
                    + p.getVida() + " - " + p.getArmadura());
        }
        if (posicionSeleccionada >= 0 && posicionSeleccionada < modeloLista.size()) {
            lista.setSelectedIndex(posicionSeleccionada);
        }
    }

    /** Vacía los campos del formulario y deja el cursor en el nombre. */
    private void limpiarFormulario() {

        campoNombre.setText("");
        campoVida.setText("");
        campoArmadura.setText("");
        campoNombre.requestFocusInWindow();
    }

    /**
     * Muestra un mensaje de error en una ventana emergente.
     *
     * @param mensaje texto del error
     */
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Datos no válidos.",
                JOptionPane.ERROR_MESSAGE);
    }
}
