package interfaz;

import juego.Batalla;
import juego.FabricaPersonajes;
import personajes.Bestia;
import personajes.Heroe;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del juego en modo gráfico.
 *
 * @author Luciano
 */
public class VentanaBatalla extends JFrame {

    /** Panel para configurar el ejército de héroes. */
    private final PanelEjercito<Heroe> panelHeroe =
            new PanelEjercito<>("Héroes", FabricaPersonajes.TIPOS_HEROE,
                    FabricaPersonajes::crearHeroe);

    /** Panel para configurar el ejército de bestias. */
    private final PanelEjercito<Bestia> panelBestia =
            new PanelEjercito<>("Bestias", FabricaPersonajes.TIPOS_BESTIA,
                    FabricaPersonajes::crearBestia);

    /** Área de texto donde se muestra el desarrollo de la batalla. */
    private final JTextArea areaResultado = new JTextArea(18, 70);

    /** Construye la ventana y coloca todos sus componentes. */
    public VentanaBatalla() {
        super("Señor de los Anillos: Batalla por la Tierra Media");

        JPanel panelEjercitos = new JPanel(new GridLayout(1, 2, 10, 0));
        panelEjercitos.add(panelHeroe);
        panelEjercitos.add(panelBestia);

        JButton botonLucha = new JButton("¡LUCHA!");
        Estilos.estilizarBoton(botonLucha, Estilos.COLOR_BOTON_LUCHA, Estilos.FUENTE_BOTON_LUCHA);
        botonLucha.setToolTipText("Enfrenta a los dos ejércitos");
        botonLucha.addActionListener(e -> luchar());

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(botonLucha);

        areaResultado.setEditable(false);
        areaResultado.setFont(Estilos.FUENTE_REGISTRO);
        areaResultado.setBackground(Estilos.COLOR_FONDO_REGISTRO);
        areaResultado.setForeground(Estilos.COLOR_TEXTO_REGISTRO);
        areaResultado.setMargin(new Insets(8, 8, 8, 8));

        JPanel panelLucha = new JPanel(new BorderLayout(5, 5));
        panelLucha.setBorder(BorderFactory.createTitledBorder("Lucha"));
        panelLucha.add(panelBoton, BorderLayout.NORTH);
        panelLucha.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        JPanel contenido = new JPanel(new BorderLayout(10, 10));
        contenido.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contenido.add(panelEjercitos, BorderLayout.NORTH);
        contenido.add(panelLucha, BorderLayout.CENTER);
        setContentPane(contenido);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Enfrenta a los dos ejércitos y muestra el desarrollo de la batalla.
     *
     * Lucha con copias de los ejércitos, para que los configurados en los
     * paneles no se modifiquen y la batalla pueda repetirse.
     */
    private void luchar() {
        if (panelHeroe.estaVacio() || panelBestia.estaVacio()) {
            JOptionPane.showMessageDialog(this, "Cada ejercito necesita al menos un personaje.",
                   "Faltan tropas", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Batalla batalla = new Batalla(panelHeroe.crearCopiaEjercito(), panelBestia.crearCopiaEjercito());
        areaResultado.setText(batalla.combate());
        areaResultado.setCaretPosition(0);

    }

    /**
     * Entrada al juego en modo gráfico.
     * La ventana se crea con "SwingUtilities.invokeLater(Runnable)"
     * porque Swing debe usarse siempre desde su propio hilo de eventos.
     *
     * @param args argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Estilos.aplicarTemaGlobal();
            new VentanaBatalla().setVisible(true);
        });
    }
}
