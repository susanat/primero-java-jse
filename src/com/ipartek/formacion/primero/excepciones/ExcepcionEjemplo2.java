package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.herencia.Vehiculo;
import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;
import com.ipartek.formacion.primero.bean.herencia.VehiculoGasolina;

public class ExcepcionEjemplo2 {
	// propiedades necesarias

	static int array_corto[] = new int[5];

	public static void main(String args[]) {
		try {
			System.out.println();
			System.out.println(".antes de la excepcion");

			// ArrayIndexOutOfBoundsException
			// array_corto[10] = 10;
			array_corto[4] = 10;

			// ArithmeticException
			// int resul = 10 / 0;

			// NullPointerException
			// String nulo = null;
			// nulo.length();

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
			System.out.println("NullPointerException " + e.getMessage());
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("Excepcion general " + e.getMessage());
			e.printStackTrace();
		}

		finally {
			// después del try catch...
			System.out.println(".siempre se ejecuta [finally]");
		}
	}
}