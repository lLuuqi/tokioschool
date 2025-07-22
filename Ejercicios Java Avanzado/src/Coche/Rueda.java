package Coche;

public class Rueda {

        private String tipo, marca, modelo;
        private double medida;

        public Rueda (String tipo, String marca, String modelo, double medida) {
            this.medida = medida;
            this.tipo = tipo;
            this.marca = marca;
            this.modelo = modelo;
        }

        public double getMedida() {
            return medida;
        }

        public void setMedida(double medida) {
            this.medida = medida;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

    }

