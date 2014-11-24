package com.ipartek.formacion.primero.util;

import java.util.HashMap;

public class Dado {

	public static String[] alumnos = new String[] { "Susana", "Zuahitz",
			"Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario", "Aritz",
			"Fran", "Maitane", "Jose" };

	static public void tirar() {
		int aleatorio = getTirada();
		System.out.println(alumnos[aleatorio]);
	}

	static public int getTirada() {
		return (int) (Math.random() * alumnos.length);
	}

	public static void main(String[] args) {
		// tirar();
		estadisticas(1000000);
	}

	/**
	 * Muestra por pantalla el numero de veces que ha salido en la tirada cada
	 * uno de los participantes. Ej: participante aparaciones
	 * ----------------------------- susana 2 aritz 98
	 * ----------------------------- 2 participantes 100
	 * 
	 * @param numTiradas
	 *            veces que se lanzara
	 */
	public static void estadisticas(int numTiradas) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int tirada;
		int sumaTiradas = 0;

		inicializarHashMap(hm);
		for (int i = 0; i < numTiradas; i++) {
			tirada = getTirada();
			hm.put(tirada, hm.get(tirada) + 1);
		}

		System.out.println("--------------------------------");
		System.out.println("Participante             Tiradas");
		System.out.println("--------------------------------");
		for (int i = 0; i < hm.size(); i++) {
			System.out.println(alumnos[i] + "                 " + hm.get(i));
			sumaTiradas = sumaTiradas + hm.get(i);
		}
		System.out.println("--------------------------------");
		System.out.println(hm.size() + " participantes             "
				+ sumaTiradas + " tiradas");
		System.out.println("--------------------------------");
	}

	/**
	 * Inicializar un {@code HashMap<Integer,Integer>} a alumnos.length
	 * elementos con valor 0 cada uno de ellos
	 * 
	 * @param hm
	 *            {@code HashMap} a inicializar
	 */
	private static void inicializarHashMap(HashMap<Integer, Integer> hm) {
		for (int i = 0; i < alumnos.length; i++) {
			hm.put(i, 0);
		}
	}
}
