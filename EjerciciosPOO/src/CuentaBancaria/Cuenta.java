package CuentaBancaria;

public class Cuenta  {

    protected float saldo;
    protected float comMensual = 0f;
    protected float tasaAnual;
    protected int numRetiros = 0;
    protected int numIngresos = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void depositar (double dinero) {
        if (dinero > 0) {
            this.saldo += (float) dinero;
        }
    }

    public float getSaldo() {
        return saldo;
    }

    public void retirar (double dinero) {
        if (dinero > 0 && dinero <= this.saldo) {
            this.saldo -= (float) dinero;
            numRetiros++;
        }
    }

    public void interesMensual () {
        double intMensual = this.saldo * (tasaAnual / 12);
        this.saldo += (float) intMensual;

    }

    public void extractoMensual () {
        this.saldo -= comMensual;
        this.interesMensual();
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", comMensual=" + comMensual +
                ", tasaAnual=" + tasaAnual +
                ", numRetiros=" + numRetiros +
                ", numIngresos=" + numIngresos +
                '}';
    }
}

