package com.ipartek.formacion.primero.util;

import java.util.HashMap;

public class Dado {

	public static final String[] ALUMNOS_TIRADA = new String[] { "Susana",
			"Zuahitz", "Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario",
			"Aritz", "Fran", "Maitane", "Jose" };

	/**
	 * Numero de tiradas a realizar
	 */
	public static final int numTiradas = 20;

	static public void tirar() {
		int aleatorio = getTirada();
		System.out.println(ALUMNOS_TIRADA[aleatorio]);
	}

	static public int getTirada() {
		return (int) (Math.random() * ALUMNOS_TIRADA.length);
	}

	public static void main(String[] args) {
		tirar();
		estadisticas(1);

	}

	/**
	 * Muestra por pantalla una tabla con todos los participantes y el numero de
	 * veces que han salido elegidos
	 *
	 * ej: --------------------------- Participantes Tiradas
	 * --------------------------- Susana 12 Zuhaitz 98 Fran 1.112 etc etc
	 * --------------------------- 12 Participantes 2.345
	 * ---------------------------
	 *
	 * @param numTiradas
	 *            {@code int} numero de veces a tirar el dado
	 */
	public static void estadisticas(int numTiradas) {
		// TODO usar un HasMap
		System.out.println("Estadisticas");
		System.out.println("---------------------------");
		System.out.println("Participantes       Tiradas");
		System.out.println("---------------------------");
		System.out.println("---------------------------");
		System.out.println("---------------------------");

	}

	/**
	 * Genera un HashMap con los alumnos clave: nombre del alumno value: veces
	 * que ha salido (inicialmente 0)
	 * 
	 * @return HashMap con los alumnos y las veces que han salido
	 */
	private HashMap inicializarHasMap() {
		HashMap hm = new HashMap();

		// Recorremos el array con los alumnos
		for (int i = 0; i < ALUMNOS_TIRADA.length; i++) {
			// Para cada alumno le añado en el HashMap con clave: nombre y
			// valor: 0
			hm.put(ALUMNOS_TIRADA[i], 0);
		}
		// Devolvemos el HashMap
		return hm;
	}

}
