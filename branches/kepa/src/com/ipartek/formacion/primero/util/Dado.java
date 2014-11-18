package com.ipartek.formacion.primero.util;

public class Dado {

	static String[] alumnos = new String[] { "Susana", "Zuahitz", "Kepa",
			"Urko", "Jon", "Sergio", "Joseba", "Mario", "Aritz", "Fran",
			"Maitane", "Jose" };

	static public void tirar() {
		int aleatorio = (int) (Math.random() * alumnos.length);
		System.out.println(alumnos[aleatorio]);
	}

	/**
	 * Muestra por pantalla una tabla con todos los participantes y el numero de
	 * veces que han salido elegidos
	 * 
	 * ej: ----------------------------------- Participante | Tiradas
	 * ----------------------------------- Susana 12 Zuahitz 98 Fran 1.112 etc
	 * ----------------------------------- 13 Participantes 2.345
	 * 
	 * 
	 * @param numTiradas
	 *            numero de veces a tirar el Dado
	 */

	public static void estadisticas(int numTiradas) {

		// TODO usar un HashMap

	}

	public static void main(String[] args) {
		tirar();

	}

}
