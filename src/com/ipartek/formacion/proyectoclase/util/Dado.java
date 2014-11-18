package com.ipartek.formacion.proyectoclase.util;

public class Dado {

	private static final String[] alumnos = new String[] { "Susana", "Zuahitz",
			"Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario", "Aritz",
			"Fran", "Maitane", "Jose" };

	static public void tirar() {
		int aleatorio = getTirada();
		System.out.println(alumnos[aleatorio]);
	}

	public static int getTirada() {

		return (int) (Math.random() * alumnos.length);
	}

	public static void main(String[] args) {
		tirar();

	}

}
