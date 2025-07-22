package modulo4;

import java.util.Scanner;

public class M1_07_Luciano_Pelaez {

	public static void main(String[] args) {
		
		int numCup;
		int [] total = new int [3];
		
		System.out.println("Ingrese el número de cupones obtenidos: ");
		Scanner sc = new Scanner(System.in);
		
		numCup = sc.nextInt();
		sc.close();
		total = candyCalculator(numCup);
		
			System.out.println("A continuación se muestran los caramelos, chicles y cupones restantes:");
			System.out.printf("Caramelos: %d\n", total[0]);
			System.out.printf("Chicles: %d\n", total[1]);
			System.out.printf("Cupones restantes: %d\n", total[2]);
		
				} public static int[] candyCalculator (int num_cupones) {
				 
				int caramelos = 0, chicles = 0, cuponesRestantes = 0;
				
				int [] resultado = new int [3];
				
						caramelos = num_cupones/10;
						cuponesRestantes = num_cupones%10;
						
						if (cuponesRestantes > 0) {
							chicles = cuponesRestantes/3;
							cuponesRestantes = cuponesRestantes%3;
							
							resultado[0] = caramelos;
							resultado[1] = chicles;
							resultado[2] = cuponesRestantes;
									
						} return resultado;
						
			}
}	 
					
	
				
				
				

	
