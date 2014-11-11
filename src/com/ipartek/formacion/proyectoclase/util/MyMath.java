package com.ipartek.formacion.proyectoclase.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * La clase MyMath es una clase destinada a suplir las carencias de Java 1.6 en temas matematicos
 * @author Urko Villanueva
 *
 */
public class MyMath {
	
	/**
	 * 
	 * @param valor {@code double} es el valor a redondear
	 * @param lugar {@code int} es el numero de decimales que queramos
	 * @return redondeo {@code double}  
	 */
	public static double round(double valor, int lugar) {
		double redondeo = 0.0;
	    if (lugar < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(valor);
	    bd = bd.setScale(lugar, RoundingMode.HALF_UP);
	    redondeo = bd.doubleValue();
	    return redondeo;
	}
	/**
	 * Valida que el numero introducido es mayor que 0
	 * @param numero {@code Double} numero enviado
	 */
	public static void compruebaMayor(Double numero){
		if(numero<=0)
			throw new IllegalArgumentException("No se adminten numeros negativos");
	}
}
