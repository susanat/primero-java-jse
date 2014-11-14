package com.impartek.formacion.primero.excepciones;

public class ExcepcionEjemplo1 {

	static void metodoA() {
		try {
			metodoB();
		} catch (PersonaException e) {
			System.out.println("Cazada la excepcion: " + e.getCodigoError()
					+ " - " + e.getMessage());
		}

	}

	static void metodoB() throws PersonaException {
		metodoC();
	}

	/*
	 * Metodo para probar NullPointerException static void metodoC() throws
	 * Exception { String cadena = null; cadena.length();
	 * 
	 * }
	 */
	static void metodoC() throws PersonaException {
		throw new PersonaException("Error para probar excepcion personalizada",
				102);

	}

	public static void main(String[] args) {

		metodoA();

	}

}
