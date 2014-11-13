package com.ipartek.formacion.proyectoclase.excepciones;

public class ExcepcionEjemplo1 {

	public static void main(String[] args) {
		metodoA();
	}

	public static void metodoA() {
		metodoB();
	}

	public static void metodoB() {
		metodoC();
	}

	public static void metodoC() {
		String cadena = null;
		cadena.length();
	}
}
