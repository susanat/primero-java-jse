package com.ipartek.formacion.primero.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que simula el comportamiento de un dado.
 *
 * @author Curso
 *
 */
public final class Dado {

	/**
	 * El número de tiradas para el Dado.
	 */
	public static final int NUMERO_TIRADAS = 100;

	/**
	 * Array con los alumnos.
	 */
	public static final String[] ALUMNOS_TIRADA = new String[] { "Susana",
			"Zuhaitz", "Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario",
			"Aritz", "Fran", "Maitane", "Jose" };

	/**
	 * Constructor por defecto.
	 */
	private Dado() {
	}

	/**
	 * Tira el Dado y el resultado se lo asigna a un array de String.
	 *
	 * @return String con el alumno
	 */
	public static String tirar() {
		int aleatorio = getTirada();
		// System.out.println(ALUMNOS_TIRADA[aleatorio]);
		return ALUMNOS_TIRADA[aleatorio];
	}

	/**
	 * Hace un random.
	 *
	 * @return int Devuelve un entero con el resultado del random
	 */
	public static int getTirada() {
		return (int) (Math.random() * ALUMNOS_TIRADA.length);
	}

	/**
	 * Muestra por pantalla una tabla con todos los participanetes y el número
	 * de veces que han salido elegidos.
	 *
	 * ej:
	 *
	 * ---------------------------------------
	 * Participante********************Tiradas
	 * ---------------------------------------
	 * Susana*******************************12
	 * Zuhaitz******************************98
	 * Fran******************************1.112
	 * etc.*******************************etc.
	 * ---------------------------------------
	 * 13*Participantes******************2.345
	 * ---------------------------------------
	 *
	 * @param numTiradas
	 *            Número de veces a tirar el Dado
	 *
	 */
	public static void estadisticas(final int numTiradas) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (String string : ALUMNOS_TIRADA) {
			hm.put(string, 0);
		}

		String nombre = "";
		for (int i = 0; i < numTiradas; i++) {
			nombre = tirar();
			hm.put(nombre, hm.get(nombre) + 1);
		}

		System.out.println("Estadísticas");
		System.out.println("---------------------------------------");
		System.out.println("Participante			Tiradas");
		System.out.println("---------------------------------------");

		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + "				"
					+ Utilidades.format(entry.getValue()));
		}

		System.out.println("---------------------------------------");
		System.out.println(ALUMNOS_TIRADA.length + " Participantes		"
				+ Utilidades.format(numTiradas));
		System.out.println("---------------------------------------");

		int count = 0;
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			count += entry.getValue();
		}
		System.out.println(count);

	}

	public static void main(final String[] args) {
		tirar();
		estadisticas(NUMERO_TIRADAS);
	}

}
