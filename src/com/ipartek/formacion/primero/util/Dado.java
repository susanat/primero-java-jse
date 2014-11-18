package com.ipartek.formacion.primero.util;

public class Dado {

	static final String[] ALUMNOS_TIRADA = new String[] { "Susana", "Zuahitz",
			"Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario", "Aritz",
			"Fran", "Maitane", "Jose" };

	static public void tirar() {
		int aleatorio = getTirada();
		System.out.println(ALUMNOS_TIRADA[aleatorio]);
	}

	static public int getTirada() {
		return (int) (Math.random() * ALUMNOS_TIRADA.length);
	}

	public static void main(String[] args) {
		tirar();

	}

}
