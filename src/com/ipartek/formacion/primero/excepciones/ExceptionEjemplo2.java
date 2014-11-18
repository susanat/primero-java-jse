package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.herencia.Vehiculo;
import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;
import com.ipartek.formacion.primero.bean.herencia.VehiculoGasolina;

public class ExceptionEjemplo2 {

	// propiedades necesarias

	static int arrayCorto[] = new int[5];

	public static void main(final String args[]) {
		try {
			System.out.println();
			System.out.println("Antes de la excepción");
			// array_corto[10] = 10;

			final Vehiculo vg = new VehiculoElectrico();
			((VehiculoGasolina) vg).isGasolina();

			System.out.println("No hay una excepción");
		} catch (final ArrayIndexOutOfBoundsException e) {
			// se captura una excepción por intentar acceder a una posición
			// fuera de los límites del array.
			System.out.println("Hay una excepción por acceso incorrecto");
		} catch (final ArithmeticException e) {
			// se captura una excepción aritmética.
			System.out.println("Hay una excepción por error aritmetico");
		} catch (final NullPointerException e) {
			// se captura una excepción aritmética.
			System.out.println("NullPointerException => " + e.getMessage());
			e.printStackTrace();
		} catch (final Exception e) {
			// se captura una excepción aritmética.
			System.out.println("Exception => " + e.getMessage());
			e.printStackTrace();
		} finally {
			// después del try catch...
			System.out.println("Siempre se ejecuta [finally]");
		}
	}
}
