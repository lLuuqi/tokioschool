import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Producto {

    private final IntegerProperty identificador;
    private final StringProperty nombreProducto;
    private final IntegerProperty stock;

    public Producto (int identificador, String nombreProducto, int stock) {

        this.identificador = new SimpleIntegerProperty(identificador);
        this.nombreProducto = new SimpleStringProperty(nombreProducto);
        this.stock = new SimpleIntegerProperty (stock);
    }
    public int getIdentificador () {
        return identificador.get();
    }
    public void setIdentificador (int identificador) {
        this.identificador.set(identificador);
    }

    public IntegerProperty identificadorProperty () {
        return identificador;
    }

    public String getNombreProducto () {
        return nombreProducto.get();
    }
    public void setNombreProducto (String nombreProducto) {
        this.nombreProducto.set(nombreProducto);
    }

    public StringProperty nombreProductoProperty () {
        return nombreProducto;
    }

    public int getStock () {
        return stock.get();
    }
    public void setStock (int stock) {
        this.stock.set(stock);
    }

    public IntegerProperty stockProperty () {
        return stock;
    }

}
