package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.herencia.Vehiculo;
import com.ipartek.formacion.primero.bean.herencia.VehiculoElectrico;
import com.ipartek.formacion.primero.bean.herencia.VehiculoGasolina;

public class ExcepcionEjemplo2 {

    // propiedades necesarias

    static int[] ARRAY_CORTO = new int[5];

    public static void main(String args[]) {

	try {
	    System.out.println();
	    System.out.println(".antes de la excepcion");
	    ARRAY_CORTO[4] = 10;

	    // pete para ArithmeticException
	    // int resul = 10 / 0;

	    // pete por NullPointerException
	    // String nulo = null;
	    // nulo.length();

	    // pete por una Exception que no haya sido especificada
	    final Vehiculo vg = new VehiculoElectrico();
	    ((VehiculoGasolina) vg).isGasolina();

	    System.out.println(".no hay una excepcion");

	} catch (final ArrayIndexOutOfBoundsException e) {
	    // se captura una excepción por intentar acceder a una posición
	    // fuera de los límites del array.
	    System.out.println(".hay una excepcion por acceso incorrecto");

	} catch (final ArithmeticException e) {
	    // se captura una excepción aritmética.
	    System.out.println(".hay una excepcion por error aritmetico");

	} catch (final NullPointerException e) {
	    System.out.println("NullPointerException " + e.getMessage());
	    e.printStackTrace();

	} catch (final Exception e) {
	    System.out.println("Exception general ");
	    System.out.println("Message: " + e.getMessage());
	    e.printStackTrace();

	} finally {
	    // después del try catch...
	    System.out.println(".siempre se ejecuta [finally]");
	}

    }

}
