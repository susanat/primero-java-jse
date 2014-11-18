package com.ipartek.formacion.proyectoclase.util;

public class Dado {

	public static final String[] ALUMNOS = new String[] { "Susana", "Zuahitz",
			"Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario", "Aritz",
			"Fran", "Maitane", "Jose" };

	static public void tirar() {
		int aleatorio = getTirada();
		System.out.println(ALUMNOS[aleatorio]);
	}

	public static int getTirada() {

		return (int) (Math.random() * ALUMNOS.length);
	}

	public static void main(String[] args) {
		tirar();

	}

}
