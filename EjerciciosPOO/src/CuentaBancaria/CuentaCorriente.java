package CuentaBancaria;

public class CuentaCorriente extends Cuenta {

    private float sobreGiro;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        sobreGiro = 0f;

    }


    @Override
    public void retirar(double dinero) {
        super.retirar(dinero);
        this.saldo -= dinero;
        if (this.saldo < 0) {
            sobreGiro = this.saldo;
            this.saldo = 0;
        }
        System.out.println("Retiro realizado.");
    }

    @Override
    public void depositar(double dinero) {
        super.depositar(dinero);
        if (sobreGiro < 0) {
            sobreGiro += dinero;

        if (sobreGiro > 0) {
            super.depositar(sobreGiro);
            sobreGiro = 0;
            }
            System.out.println("Ingreso realizado.");
        }
        else super.depositar(dinero);
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    public void imprimir () {
        System.out.printf("\nSaldo: %.2f\n", saldo);
        System.out.printf("Comision Mensual: %.2f\n", comMensual);
        System.out.println("Total Transacciones: " + (numIngresos + numRetiros));
        System.out.printf("Sobregiro: %.2f\n\n", sobreGiro);
    }
}
