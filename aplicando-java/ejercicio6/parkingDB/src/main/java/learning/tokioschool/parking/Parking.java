package learning.tokioschool.parking;

import learning.tokioschool.parking.db.ManagerDb;

public class Parking {

	final ManagerDb managerDb;

	public Parking() {
		managerDb = new ManagerDb();
	}

	/**
	 * Metodo que comprueba si existe un coche en el sistema
	 * 
	 * @param matricula
	 * @return
	 */
	public boolean existeCoche(final String matricula) {
		return managerDb.search(matricula) != null;
	}

	/**
	 * Metodo que obtiene un coche del sistema
	 * 
	 * @param matricula
	 * @return
	 */
	public Coche getCoche(final String matricula) {
		return managerDb.search(matricula);
	}

	/**
	 * Metodo que añade un coche al sistema
	 * 
	 * @param matricula
	 * @param coche
	 */
	public void putCoche(final String matricula, final Coche coche) {
		managerDb.insert(matricula, coche);
	}

	/**
	 * Metodo que imprime todos los coches del sistema, tanto los que estan dentro del parking como los que no.
	 */
	public void imprimirCochesSistema() {
		try {
			managerDb.searchAll().forEach((k, v) -> {
				System.out.println("Matricula: " + k + " Datos del " + v);
			});
		} catch (Exception ex) {
			System.out.println("Error al imprimir coches en el sistema");
		}
	}

	/**
	 * Metodo que imprime los coches que estan dentro del parking (horaSalida = null)
	 */
	public void imprimirCochesParking() {
		try {
			managerDb.searchAllFilterHoraSalida().forEach((k, v) -> {
					System.out.println("Matricula: " + k + " Datos del " + v);
			});
		} catch (Exception ex) {
			System.out.println("Error al imprimir coches en el parking");
		}
	}

	/**
	 * Método que calcula la cantidad a pagar por un coche según el tiempo que ha estado dentro del parking
	 * @param matricula
	 */
	public void cantidadAPagar(final String matricula) {

		if (matricula != null) {

			Coche coche = managerDb.search(matricula);

			if (coche != null) {
				System.out.println("Cantidad a pagar " + coche.cantidadAPagar());
			}
		}
	}

}
