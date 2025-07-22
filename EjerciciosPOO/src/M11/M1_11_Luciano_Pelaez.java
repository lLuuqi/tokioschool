class Rectangulo {

    int base, altura;

    public Rectangulo (int base, int altura) {

        this.base = Math.abs(base);
        this.altura = Math.abs(altura);

        }

    public Rectangulo() {

        this(2, 1);

    }

    public boolean esCuadrado () {

        boolean esCuadrado = false;
        if (this.base == this.altura) {
            esCuadrado = true;
        }

        return esCuadrado;
    }

    public int area () {

        return this.base * this.altura;

    }

    public int perimetro () {

        return (this.base+this.altura)*2;
    }

    public void gira () {

        this.base = this.altura;

    }

    }


