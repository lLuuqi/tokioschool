package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Colores, fuentes y utilidades de diseño de la interfaz gráfica.
 *
 * Si precisamos modificar algún diseño gráfico, lo hacemos en una sola clase.
 *
 * @author Luciano
 */
public final class Estilos {

    /** Constructor privado: es una clase de utilidad y no se crean objetos de ella. */
    private Estilos(){

    }

    //                  --------------- Colores ---------------

    /** Color de fondo de la ventana y sus paneles (tono pergamino). */
    public static final Color COLOR_FONDO_VENTANA = new Color(232, 222, 199);

    /** Color de los títulos de los recuadros. */
    public static final Color COLOR_TITULO = new Color(110, 60, 20);

    /** Color del texto de las etiquetas del formulario. */
    public static final Color COLOR_ETIQUETA = new Color(60, 40, 20);

    /** Color de fondo de los botones "Añadir". */
    public static final Color COLOR_BOTON = new Color(60, 90, 55);

    /** Color de fondo del área con el relato de la batalla. */
    public static final Color COLOR_FONDO_REGISTRO = new Color(245, 239, 224);

    /** Color del texto del relato de la batalla. */
    public static final Color COLOR_TEXTO_REGISTRO = new Color(60, 40, 20);

    /** Color de fondo del botón "¡LUCHA!". */
    public static final Color COLOR_BOTON_LUCHA = new Color(140, 30, 30);

    //                  --------------- Fuentes ---------------

    /** Fuente por defecto de campos, desplegables, listas y botones sin estilo propio. */
    public static final Font FUENTE_NORMAL = new Font(Font.SANS_SERIF, Font.PLAIN, 13);

    /** Fuente de los títulos de los recuadros. */
    public static final Font FUENTE_TITULO = new Font(Font.SERIF, Font.BOLD, 16);

    /** Fuente de las etiquetas del formulario. */
    public static final Font FUENTE_ETIQUETA = new Font(Font.SERIF, Font.BOLD, 14);

    /** Fuente de los botones "Añadir". */
    public static final Font FUENTE_BOTON = new Font(Font.SANS_SERIF, Font.BOLD, 13);

    /** Fuente del botón "¡LUCHA!". */
    public static final Font FUENTE_BOTON_LUCHA = new Font(Font.SERIF, Font.BOLD, 18);

    /**
     * Fuente del relato de la batalla. Es monoespaciada para que las
     * sangrías queden alineadas, como en la consola.
     */
    public static final Font FUENTE_REGISTRO = new Font(Font.MONOSPACED, Font.PLAIN, 13);

    /**
     * Aplica los valores por defecto de toda la aplicación.
     *
     * Debe llamarse antes de crear la ventana porque los componentes leen
     * estos valores al crearse.
     */
    public static void aplicarTemaGlobal () {

        UIManager.put("Panel.background", COLOR_FONDO_VENTANA);
        UIManager.put("TitledBorder.font", FUENTE_TITULO);
        UIManager.put("TitledBorder.titleColor", COLOR_TITULO);
        UIManager.put("TitledBorder.border", BorderFactory.createLineBorder(COLOR_TITULO));
        UIManager.put("Label.font", Estilos.FUENTE_NORMAL);
        UIManager.put("TextField.font", Estilos.FUENTE_NORMAL);
        UIManager.put("ComboBox.font", Estilos.FUENTE_NORMAL);
        UIManager.put("List.font", Estilos.FUENTE_NORMAL);
        UIManager.put("Button.font", Estilos.FUENTE_NORMAL);
        UIManager.put("TitledBorder.font", Estilos.FUENTE_TITULO);
    }

    /**
     * Crea una etiqueta de formulario con el estilo común.
     *
     * @param texto texto de la etiqueta.
     * @return la etiqueta con fuente y color aplicados.
     */
    public static JLabel crearEtiqueta (String texto){
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(FUENTE_ETIQUETA);
        etiqueta.setForeground(COLOR_ETIQUETA);
        return etiqueta;
    }

    /**
     * Da a un botón colores propios, un borde plano, cursor de mano y un
     * efecto al pasar el ratón por encima.
     *
     * @param boton al que se aplica el estilo.
     * @param colorFondo color de fondo del botón.
     * @param fuente fuente del texto del botón.
     */
    public static void estilizarBoton(JButton boton, Color colorFondo, Font fuente) {

        boton.setFont(fuente);
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // Borde compuesto: línea exterior más oscura y margen interior vacío
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorFondo.darker()),
                BorderFactory.createEmptyBorder(6, 18, 6, 18)));

        // Clase anónima que aclara el botón mientras el ratón está encima
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorFondo.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorFondo);
            }
        });
    }
}
