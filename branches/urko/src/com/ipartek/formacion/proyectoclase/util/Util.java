package com.ipartek.formacion.proyectoclase.util;

public class Util {

	/**
	 * Genera un número de DNI {@code String} valido: numero y letra en mayusculas
	 * @return {@code String} devuelve el numero de DNI generado
	 */
	public static String generarDNI(){
		String dni 		= null;
		Integer n_dni 		= 0;
		Character letra = null;

		n_dni = generarNumeroDni();
		letra = generarLetraDni(n_dni);
		
		dni = n_dni.toString()+letra.toString();
		
		return dni;
	}
	private static Integer generarNumeroDni(){
		final int LIMITE_SUP = 99999999;
		Integer n_dni = 0;
		n_dni = (int)Math.floor(Math.random()*LIMITE_SUP+1);
		
		return n_dni;
	}
	private static Character generarLetraDni(Integer n_dni){
		final char[] letras	= {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'};
		Character c 		= null;
		
		MyMath.compruebaMayor((double)n_dni);
		c =	letras[n_dni%letras.length];
		
		return c;
	}
	
	
	/**
	 * Comprueba si una letra es una vocal
	 * @param c {@code Character} la letra a validar
	 * @return {@code Boolean} nos devuelve si es cierto si es una vocal o no
	 */
	public static Boolean isVocal(Character c){
		Boolean cierto = false;
		Character cha = Character.toLowerCase(c);
		switch(cha){
			case 'á':
			case 'é':
			case 'í':
			case 'ó':
			case 'ú':
			case 'ü':
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				cierto = true;
			break;
			default:
				cierto = false;
				break;
		}
		return cierto;
	}
}

