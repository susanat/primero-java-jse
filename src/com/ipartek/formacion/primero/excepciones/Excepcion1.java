package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.herencia.Vehiculo;
import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;
import com.ipartek.formacion.primero.bean.herencia.VehiculoGasolina;

public class Excepcion1 {

	// propiedades necesarias

	static int array_corto[] = new int[5];

	public static void main(String args[]) {

		try {

			System.out.println();

			System.out.println(".antes de la excepcion");

			// Pete para ArrayIndexOutOfBoundsException
			array_corto[4] = 10;

			// pete para ArithmeticException
			int i = 12 / 1;

			// pete para NullPointerException
			// String cadena = null;
			// cadena.length();

			// pete por Excepcion no especificada

			Vehiculo vg = new VehiculoElectrico();
			((VehiculoGasolina) vg).isGasolina();
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

		catch (NullPointerException e) {
			System.out.println("NullPointerException: " + e.getMessage());
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println(".excepcion general");
			System.out.println("Mensaje: " + e.getMessage());
			e.printStackTrace();
		}

		finally {

			// después del try catch...

			System.out.println(".siempre se ejecuta [finally]");

		}

	}

}