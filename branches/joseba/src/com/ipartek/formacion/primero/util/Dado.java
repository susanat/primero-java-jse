package com.ipartek.formacion.primero.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dado {

	public static final String[] ALUMNOS_TIRADA = new String[] { "Susana",
			"Zuahitz", "Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario",
			"Aritz", "Fran", "Maitane", "Jose" };

	public static final int TIRADA = 1000;

	static public void tirar() {
		int aleatorio = (int) (Math.random() * ALUMNOS_TIRADA.length);
		System.out.println(ALUMNOS_TIRADA[aleatorio]);
	}

	public static int getTirada() {
		return (int) (Math.random() * ALUMNOS_TIRADA.length);
	}

	public static void main(String[] args) {
		HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
		mostrarDatos(hm2, TIRADA);

	}

	/**
	 * Funcion que recibe un hashMap y un numero de iteraciones y muestra por
	 * pantalla una table con todos los participantes y el numero de veces que
	 * han sido elegidos
	 *
	 * @param hm1
	 *            Hashset inicializado
	 * @param tiradas
	 *            numero de tiradas del dado
	 */
	public static void mostrarDatos(HashMap<String, Integer> hm1, int tiradas) {
		int tirada = -1;
		DecimalFormat formateador = new DecimalFormat("###,###.##");
		for (int i = 0; i < tiradas; i++) {
			tirada = Dado.getTirada();

			if (hm1.get(Dado.ALUMNOS_TIRADA[tirada]) == null) {
				hm1.put(Dado.ALUMNOS_TIRADA[tirada], 1);

			} else {
				hm1.put(Dado.ALUMNOS_TIRADA[tirada],
						hm1.get(Dado.ALUMNOS_TIRADA[tirada]) + 1);
			}

		}
		// Construimos lo que queremos mostrar por pantalla
		System.out.println(" --------------------------------------");
		System.out.println(" Participantes                | Tiradas");
		System.out.println(" --------------------------------------");
		Iterator<Map.Entry<String, Integer>> iterator = hm1.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();

			System.out.printf(" %-30s   %-30d", entry.getKey(),
					entry.getValue());
			System.out.println();

		}
		System.out.println(" --------------------------------------");
		System.out
		.println(" " + Dado.ALUMNOS_TIRADA.length
				+ " Participantes                "
				+ formateador.format(TIRADA));
		System.out.println(" --------------------------------------");
	}
}
