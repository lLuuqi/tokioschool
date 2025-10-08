package Coche;

import java.util.Arrays;

public class Coche {

    private String matricula, modelo, marca;
    private double potencia, velocidadMax;
    private Chasis chasis;
    private Rueda [] ruedas;

    public Coche (String matricula, String modelo, String marca, double potencia, double velocidadMax) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.potencia = potencia;
        this.velocidadMax = velocidadMax;
    }

    public void setChasis (Chasis chasis) {
        this.chasis = chasis;
    }

    public void setRuedas (Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public static class Chasis {

        private String material;
        private double peso;

        public Chasis(String material, double peso) {
            this.material = material;
            this.peso = peso;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        @Override
        public String toString() {
            return "Chasis{" +
                    "material='" + material + '\'' +
                    ", peso=" + peso +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", potencia=" + potencia +
                ", velocidadMax=" + velocidadMax +
                ", chasis=" + chasis +
                ", ruedas=" + Arrays.toString(ruedas) +
                '}';
    }
}
