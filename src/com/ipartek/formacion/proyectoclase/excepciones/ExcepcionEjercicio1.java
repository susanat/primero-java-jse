package com.ipartek.formacion.proyectoclase.excepciones;

public class ExcepcionEjercicio1 {
	static int array_corto[] = new int[5];

	public static void main(String args[]) {

		try {

			System.out.println();

			System.out.println(".antes de la excepcion");

			// array_corto[10] = 10;
			System.out.println(dividir(10, 0));
			System.out.println(".no hay una excepcion");
			/*
			 * Las excepciones de tipo Runtime más tipicas son: - NullPointer -
			 * ArrayIndexOutofBounds - NoSuchElementException -
			 * ClassCastException
			 * 
			 * Hay que diferenciar entre Errores (Runtime) o Fallos no debidos a
			 * la programación (IOException)
			 */
		}

		catch (ArrayIndexOutOfBoundsException e) {
			// se captura una excepción por intentar acceder a una posición
			// fuera de los límites del array.

			System.out.println(".hay una excepcion por acceso incorrecto"
					+ e.getMessage());
			e.printStackTrace();

		} catch (ArithmeticException e) {
			// se captura una excepción aritmética.
			System.out.println(".hay una excepcion por error aritmetico "
					+ e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			// se captura una excepción aritmética.
			System.out.println(".hay una excepcion por error objeto nulo "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(".hay una excepcion generica " + e.getMessage());
			e.printStackTrace();
		} finally {
			// después del try catch...
			System.out.println(".siempre se ejecuta [finally]");

		}

	}

	public static double dividir(int dividendo, int divisor)
			throws ArithmeticException {
		if (divisor == 0) {
			throw new ArithmeticException();
		}
		return ((double) dividendo / divisor);
	}
}
