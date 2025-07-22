package CuentaBancaria;

public class main {

    public static void main(String[] args) {

        CuentaAhorro cuentaAhorro = new CuentaAhorro(3000, 2.5f);

        cuentaAhorro.imprimir();
        cuentaAhorro.retirar(1000);
        cuentaAhorro.imprimir();
        cuentaAhorro.retirar(1500);
        cuentaAhorro.imprimir();
        cuentaAhorro.depositar(200);
        cuentaAhorro.retirar(200);
        cuentaAhorro.retirar(200);
        cuentaAhorro.retirar(200);
        cuentaAhorro.retirar(200);
        cuentaAhorro.imprimir();

    }
}
