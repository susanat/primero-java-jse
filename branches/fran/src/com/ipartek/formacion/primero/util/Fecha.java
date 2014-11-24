package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase para trabajar con fechas
 * 
 * @author Fran
 *
 */
public class Fecha {

	/**
	 * Metodo para obtener una fecha(Date) en formato string segun el idioma
	 * 
	 * @param hoyDate
	 *            fecha a formatear
	 * @param idioma
	 *            idioma que determina el formato
	 * @see com.ipartek.formacion.primero.util.Idioma
	 * @return string con la fecha
	 */
	public static String getString(Date hoyDate, Idioma idioma) {
		String resul = "";
		String formatoString = "";

		switch (idioma) {
		case CASTELLANO:
			formatoString = "dd/MM/YYYY";
			break;
		case EUSKARA:
			formatoString = "YYYY/MM/dd";
			break;
		}

		SimpleDateFormat formato = new SimpleDateFormat(formatoString);
		resul = formato.format(hoyDate);
		return resul;
	}

	/**
	 * Metodo para obtener una fecha(long) en formato string segun el idioma
	 * 
	 * @param hoyDate
	 *            fecha a formatear
	 * @param idioma
	 *            idioma que determina el formato
	 * @see com.ipartek.formacion.primero.util.Idioma
	 * @return string con la fecha
	 */
	public static String getString(long hoyDate, Idioma idioma) {
		String resul = "";
		resul = getString(new Date(hoyDate), idioma);
		return resul;
	}

}
