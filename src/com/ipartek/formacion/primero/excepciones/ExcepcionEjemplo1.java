package com.ipartek.formacion.primero.excepciones;

public class ExcepcionEjemplo1 {

	static void metodoA() {
		metodoB();
	}

	static void metodoB() {
		metodoC();
	}

	static void metodoC() {
		try {
			String cadena = null;
			cadena.length();
		} catch (NullPointerException e) {
			System.out.println("Se ha capturado el error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		metodoA();
		tratarArrays();
	}

	static void tratarArrays() {
		try {
			String[] arrTest = new String[5];

			String strTest = null;
			arrTest[20] = "test"; // Error
			strTest.length(); // Error
		} catch (NullPointerException e) {
			System.out
					.println("Error: Se quiere acceder a un objeto que no existe");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Fuera de rango");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido un error");
			e.printStackTrace();
		}
	}
}
