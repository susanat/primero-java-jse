package com.ipartek.formacion.primero.excepciones;

public class ExcepcionEjemplo1 {

	static void metodoA() {
		metodoB();
	}

	static void metodoB() {
		metodoC();
	}

	static void metodoC() {
		String cadena = null;
		cadena.length();
	}

	public static void main(String[] args) {
		metodoA();
	}

}
