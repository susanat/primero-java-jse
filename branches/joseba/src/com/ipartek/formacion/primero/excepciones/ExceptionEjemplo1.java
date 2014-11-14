package com.ipartek.formacion.primero.excepciones;

public class ExceptionEjemplo1 {

	public static void main(String[] args) {
		metodoA();

	}

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

}
