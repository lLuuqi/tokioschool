import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    /** Declaramos algunas variables para su posterior uso*/
    private JTextField ventana;
    private double numero1 = 0;
    private double numero2 = 0;
    private double memoria = 0;
    private String operador = "";

    /** Creamos la calculadora con sus respectivas caracteristicas*/
    public Calculadora () {

        /**Titulo*/
        setTitle("Calculadora Tokio");
        /**Tamaño de la ventana*/
        setSize(500,450);
        /**Cierre de la aplicacion al dejar de utilizarla*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**Dimensiones del contenedor*/
        setLayout(new BorderLayout(10,10));

        /**Creamos el campo de texto en la ventana*/
        ventana = new JTextField();
        /**Definimos que el texto comience de derecha a izquierda*/
        ventana.setHorizontalAlignment(JTextField.RIGHT);
        /**Deshabilitamos la posibilidad de modificar el texto de la ventana*/
        ventana.setEditable(false);
        /**Dimensiones de la ventana*/
        ventana.setPreferredSize(new Dimension(100,60));
        /**Definimos la posicion de la ventana de texto*/
        add(ventana, BorderLayout.NORTH);

        /**Creamos el panel de los numeros*/
        JPanel panelCentro = new JPanel();
        /**Definimos sus dimensiones*/
        panelCentro.setLayout(new BorderLayout(10, 10));
        /**Definimos columnas, filas y espaciado*/
        panelCentro.setLayout(new GridLayout(4, 4, 10, 10));
        /**Creamos los botones con sus respectivos numeros u operadores*/
        String [] botones = {"1", "2", "3", "+",
                "4", "5", "6", "-", "7", "8",
                "9", "*", "0", ".", "=", "/"};

        /**Recorremos el array de String para añadir el texto respectivo a cada boton*/
        for(String texto : botones){
            JButton boton =  new JButton(texto);
            boton.addActionListener(this);
            panelCentro.add(boton);
        }
        /**Posicionamos el panel en el centro de la ventana*/
        add(panelCentro, BorderLayout.CENTER);

        /**Repetimos el proceso anterior pero con el panel del lado derecho (Funciones especiales)*/
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridLayout(3, 1, 10, 10));

        String [] funciones = {"Limpiar", "Guardar", "Recuperar"};

        for(String texto : funciones){
            JButton boton =  new JButton(texto);
            boton.addActionListener(this);
            panelDerecho.add(boton);
        }
        /**Posicionamos el panel del lado derecho de la ventana*/
        add(panelDerecho, BorderLayout.EAST);

    }
    /**Sobreescribimos los métodos no implementados de ActionListener*/
    @Override
    public void actionPerformed(ActionEvent e) {

        /**Declaramos la variable action para su posterior uso como boton de accion*/
        String action = e.getActionCommand();

        /**Definimos todos los numeros incluido el "."*/
        if (action.matches("[0-9.]")) {
            ventana.setText(ventana.getText() + action);

        }
        /**Definimos los operadores*/
        else if (action.matches("[+\\-*/]")) {
            numero1 = Double.parseDouble(ventana.getText());
            operador = action;
            ventana.setText("");

        }
        /**Definimos el igual "=" con un switch por cada operacion que se pueda generar*/
        else if (action.equals("=")) {

            numero2 = Double.parseDouble(ventana.getText());
            double resultado = 0;

            switch (operador) {
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                case "/":
                    if (numero2 != 0)
                        resultado = numero1 / numero2;
                    else {
                        ventana.setText("Math Error");
                        return;
                    }
                    break;
            }
            /**Mostramos por ventana el resultado de la operacion que se realice*/
            ventana.setText(String.valueOf(resultado));
        }
        /**Definimos la funcion "Limpiar" liberando el campo de texto*/
        else if (action.equals("Limpiar")) {
            ventana.setText("");
            numero1 = 0;
            numero2 = 0;
            operador = "";
        }
        /**Definimos la funcion "Guardar" para guardar en memoria lo que se desee*/
        else if (action.equals("Guardar")) {
            if (!ventana.getText().isEmpty()) {
                memoria = Double.parseDouble(ventana.getText());
            }
        }
        /**Definimos la funcion "Recuperar" para retornar ese valor guardado en memoria*/
        else if (action.equals("Recuperar")) {
            ventana.setText(String.valueOf(memoria));
        }
    }
}
/**Creamos el main para poder dar arranque a nuestro programa*/
public void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        new Calculadora().setVisible(true);
    });
}

