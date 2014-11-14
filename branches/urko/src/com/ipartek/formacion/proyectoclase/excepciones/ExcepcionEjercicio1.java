package com.ipartek.formacion.proyectoclase.excepciones;

public class ExcepcionEjercicio1 {
	static int array_corto[] = new int[5];

	public static void main(String args[]) {

		try {

			System.out.println();

			System.out.println(".antes de la excepcion");

			array_corto[10] = 10;

			System.out.println(".no hay una excepcion");

		}

		catch (ArrayIndexOutOfBoundsException e) {

			// se captura una excepción por intentar acceder a una posición

			// fuera de los límites del array.

			System.out.println(".hay una excepcion por acceso incorrecto");

		}

		catch (ArithmeticException e) {

			// se captura una excepción aritmética.

			System.out.println(".hay una excepcion por error aritmetico");

		}

		finally {
			// después del try catch...
			System.out.println(".siempre se ejecuta [finally]");

		}

	}
}
