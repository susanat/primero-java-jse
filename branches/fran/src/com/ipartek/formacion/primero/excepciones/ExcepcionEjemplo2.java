package com.ipartek.formacion.primero.excepciones;

public class ExcepcionEjemplo2 {
	// propiedades necesarias
	static int arrayCorto[] = new int[5];

	public static void main(String args[]) {
		try {
			System.out.println();
			System.out.println(".antes de la excepcion");
			arrayCorto[10] = 10;
			System.out.println(".no hay una excepcion");
		} catch (ArrayIndexOutOfBoundsException e) {
			// se captura una excepción por intentar acceder a una posición
			// fuera de los límites del array.
			System.out.println(".hay una excepcion por acceso incorrecto");
		} catch (ArithmeticException e) {
			// se captura una excepción aritmética.
			System.out.println(".hay una excepcion por error aritmetico");
		} catch (Exception e) {
			System.out.println("Excepcion general: " + e.getMessage());
		} finally {
			// después del try catch...
			System.out.println(".siempre se ejecuta [finally]");
		}
	}
}
