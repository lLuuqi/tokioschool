package CuentaBancaria;

public class CuentaAhorro extends Cuenta {

    public CuentaAhorro(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    public boolean cuentaActiva () {
        if (this.saldo < 100) {
            return false;

        } else {
            return true;
        }

    }

    @Override
    public void depositar(double dinero) {
        super.depositar(dinero);
        if (cuentaActiva()) {
            this.saldo += (float) dinero;
        }
    }

    @Override
    public void retirar(double dinero) {
        super.retirar(dinero);
        if (cuentaActiva()) {
            this.saldo -= (float) dinero;
            if (numRetiros > 4) {
            this.comMensual += 1.5f;
            }
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    if (cuentaActiva()) {
     this.saldo -= comMensual;
    } else {
        System.out.println("Cuenta inactiva");
        }
    }

    public void imprimir () {
        System.out.printf("\nSaldo: %.2f\n", saldo);
        System.out.printf("Comision Mensual: %.2f\n", comMensual);
        System.out.println("Total Transacciones: " + (numIngresos + numRetiros) + "\n");
    }
}