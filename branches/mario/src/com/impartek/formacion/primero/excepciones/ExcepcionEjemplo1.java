package com.impartek.formacion.primero.excepciones;

public class ExcepcionEjemplo1 {

	static void metodoA() {
		try {
			metodoB();
		} catch (ExcepcionPersonalizada e) {
			System.out.println("Cazada la excepcion: " + e.getCodigoError()
					+ " - " + e.getMensaje());
		}

	}

	static void metodoB() throws ExcepcionPersonalizada {
		metodoC();
	}

	/*
	 * Metodo para probar NullPointerException static void metodoC() throws
	 * Exception { String cadena = null; cadena.length();
	 *
	 * }
	 */
	static void metodoC() throws ExcepcionPersonalizada {
		throw new ExcepcionPersonalizada(102,
				"Error para probar excepcion personalizada");

	}

	public static void main(String[] args) {

		metodoA();

	}

}
