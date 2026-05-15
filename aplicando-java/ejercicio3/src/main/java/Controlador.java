import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controlador {

    @FXML
    private Button b_Agregar;

    @FXML
    private Button b_Modificar;

    private ObservableList <Producto> listaStock = FXCollections.observableArrayList();

    @FXML
    public void initialize () {

        col_Identificador.setCellValueFactory(data ->
                data.getValue().identificadorProperty().asObject());

        col_NomProducto.setCellValueFactory(data ->
                data.getValue().nombreProductoProperty());

        col_Stock.setCellValueFactory(data ->
                data.getValue().stockProperty().asObject());

        /*Creamos una funcionalidad para que cuando se seleccione una fila copie los datos a los TextFields*/

        tab_Producto.getSelectionModel().selectedItemProperty().addListener(
           (observable, oldValue, productoSeleccionado) -> {
                if (productoSeleccionado != null) {

                    l_Identificador.setText(String.valueOf(productoSeleccionado.getIdentificador()));

                    l_NombreProducto.setText(productoSeleccionado.getNombreProducto());

                    l_Stock.setText(String.valueOf(productoSeleccionado.getStock()));
                }
        });
    }

    @FXML
    private TableView <Producto> tab_Producto;

    @FXML
    private TableColumn <Producto, Integer> col_Identificador;

    @FXML
    private TableColumn <Producto, String> col_NomProducto;

    @FXML
    private TableColumn <Producto, Integer> col_Stock;

    @FXML
    private TextField l_Identificador;

    @FXML
    private TextField l_NombreProducto;

    @FXML
    private TextField l_Stock;

    /*Metodo para dejar vacios los campos de texto luego de haberlos utilizado.*/
    private void limpiarCampos () {

        l_Identificador.clear();
        l_NombreProducto.clear();
        l_Stock.clear();
    }
    /*Un metodo simple para mostar los mensajes de alerta y ahorrar codigo.*/

    private void mostrarAlerta (String mensaje) {
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Alerta");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }

    @FXML
    void onActionAgregar (ActionEvent event) {

        String idTexto = l_Identificador.getText();
        String nombreProducto = l_NombreProducto.getText();
        String stock = l_Stock.getText();

        /*Validamos si los campos estan vacios.*/

        if (idTexto.isEmpty() || nombreProducto.isEmpty() || stock.isEmpty()) {

            mostrarAlerta("Todos los campos son obligatorios.");
            return;
        }
        /*Creamos variables para que los campos ID y Stock sean solo numeros.*/

        int id;
        int numeroStock;
        try {
            id = Integer.parseInt(idTexto);
            numeroStock = Integer.parseInt(stock);
        }  catch (NumberFormatException e) {
            mostrarAlerta("El ID y Stock deben ser números.");
            return;
        }
        /*Verificamos que el ID no se repita.*/

        for (Producto p : tab_Producto.getItems()) {
            if (p.getIdentificador() == id) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ya existe el ID del producto");
            }
        }
        /*Agregamos los productos y una vez agregados se limpia el campo para el proximo producto.*/

        Producto nuevo = new Producto (id, nombreProducto, numeroStock);
        tab_Producto.getItems().add(nuevo);
        listaStock.add(nuevo);

        limpiarCampos();
    }

    @FXML
    void onActionModificar(ActionEvent event) {

        Producto producto = tab_Producto.getSelectionModel().getSelectedItem();

        if (producto == null) {
            mostrarAlerta("Seleccione un producto.");
            return;
        }
        String nombre = l_NombreProducto.getText();
        String stockTexto = l_Stock.getText();

        if (nombre.isEmpty() || stockTexto.isEmpty()) {
            mostrarAlerta("Nombre y Stock son campos obligatorios.");
            return;
        }
        int stock;
        try {
            stock = Integer.parseInt(stockTexto);
        } catch (NumberFormatException e) {
            mostrarAlerta("El campo Stock debe ser numérico.");
            return;
        }

        /*Metodos para modificar los datos.*/

        producto.setNombreProducto(nombre);
        producto.setStock(stock);

        /*Refrescamos la tabla para actualizarla con los datos ingresados y luego limpiamos los campos.*/

        tab_Producto.refresh();

        limpiarCampos();
    }

}
