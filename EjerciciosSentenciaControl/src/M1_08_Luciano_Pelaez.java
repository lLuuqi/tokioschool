package modulo4;

public class M1_08_Luciano_Pelaez {
static int [] list;

static boolean numero (int num) {
	for(int i = 0; i < list.length; i++) {
		if (list[i] == num) {
			return false;
		}
	} return true;
}

	public static void main(String[] args) {

		int [] numEnteros = {1, 2, 3, 3, 3, 4, 5, 6, 7, 7, 7, 8, 9, 10, 10};
		list = new int[numEnteros.length];

		for (int i = 0; i < numEnteros.length; i++){
				int cont = 0;
				for(int j = 0; j < numEnteros.length; j++){
					if (numEnteros[i] == numEnteros[j]){
						cont++;
						if (numero(numEnteros[i])){
							list[i] = numEnteros[i];
						}
					}
				} if (list[i] != 0){
					System.out.println(list[i] + " se repite: "+cont);
				}
			}

		}

	}