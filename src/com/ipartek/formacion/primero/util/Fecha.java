package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Fecha {

	public enum eIdioma{
		CASTELLANO,
		EUSKARA
	}

	/**
	 * Formatear fecha segun {@code Idioma}
	 *
	 * @param hoyDate
	 *            {@code GregorianCalendar} con la fecha a formatear
	 * @param idioma
	 *            {@code enum} para Idioma
	 * @see com.ipartek.formacion.primero.util.Idioma
	 *
	 * @return {@code String} con la fecha formateada
	 */
	public static String getString(GregorianCalendar hoyDate, eIdioma idioma) {
		String resul = "";
		String mascaraES = "dd/MM/yyyy";
		String mascaraEU = "yyyy/MM/dd";
		SimpleDateFormat sdf = null;

		switch (idioma) {
		case CASTELLANO:
			sdf = new SimpleDateFormat(mascaraES);
			break;
		case EUSKARA:
			sdf = new SimpleDateFormat(mascaraEU);
			break;
		default:
			break;
		}

		resul = sdf.format(hoyDate.getTime());
		return resul;
	}

	/**
	 * Formatear fecha segun {@code Idioma}
	 * 
	 * @see getString(GregorianCalendar hoyDate, Idioma idioma)
	 * @param timeInMillis
	 *            long con la fecha en milisegundos
	 * @param idioma
	 *            {@code enum} para Idioma
	 * @return {@code String} con la fecha formateada
	 */
	public static Object getString(long timeInMillis, eIdioma idioma) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(timeInMillis);
		return getString(gc, idioma);
	}

}
