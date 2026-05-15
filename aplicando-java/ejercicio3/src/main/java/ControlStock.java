import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ControlStock extends Application {

    @Override
    public void start (Stage ventanaPrincipal) throws Exception {

        FXMLLoader loader = new FXMLLoader(ControlStock.class.getResource("stock.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene escena = new Scene(root, 600, 400);
        escena.getStylesheets().add(
                getClass().getResource("estilos.css").toExternalForm());
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setScene(escena);
        ventanaPrincipal.setTitle("Control de Stock");
        ventanaPrincipal.show();

    }
}
