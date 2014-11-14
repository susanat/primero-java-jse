package com.ipartek.formacion.primero.excepciones;


public class ExcepcionEjemplo1 {

	public static void main(String[] args) {
		try {
			metodoA();
		} catch (ExcepcionesPersonalizadas e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void metodoA() throws ExcepcionesPersonalizadas,
			NullPointerException {
		metodoB();
	}

	private static void metodoB() throws ExcepcionesPersonalizadas,
			NullPointerException {
		metodoC();
	}

	private static void metodoC() throws ExcepcionesPersonalizadas,
			NullPointerException {
		String provocaError = null;
		provocaError.length();
	}

}
