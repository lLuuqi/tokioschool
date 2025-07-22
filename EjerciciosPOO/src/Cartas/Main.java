package M1_T06_P25;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Baraja baraja = new Baraja();
        Mazo mazo = baraja.getMazo();
        System.out.println(mazo.toString());

        mazo.setAlgoritmo(new OrdPalNumInc());
        mazo.ordena();
        System.out.println(mazo.toString());

        mazo.setAlgoritmo(new OrdPalNumDec());
        mazo.ordena();
        System.out.println(mazo.toString());
        
        mazo.setAlgoritmo(new OrdNumIncPal());
        mazo.ordena();
        System.out.println(mazo.toString());



	}

}
