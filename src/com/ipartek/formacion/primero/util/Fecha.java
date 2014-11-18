package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Fecha {

	/**
	 * formatear fecha segun idiomas
	 *
	 * @param hoyDate
	 *            {@code GregorianCalendar} con la fecha a formatear
	 * @param idioma
	 *            {@code enum} para idioma
	 * @return {@code String }con la fecha formateada
	 * */

	public static String getString(GregorianCalendar hoyDate, Idioma idioma) {
		String resul = "";
		String mascaraES = "dd/mm/yyyy";
		String mascaraEU = "yyyy/mm/dd";
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
	 *
	 * @see getString(GregorianCalendar hoyDate, Idioma idioma)
	 * @param timeInMillis
	 *            {@code long} con la fecha a formatear
	 * @param idioma
	 *            {@code enum} para idioma
	 * @return {@code String }con la fecha formateada
	 */
	public static Object getString(long timeInMillis, Idioma idioma) {

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(timeInMillis);
		return getString(gc, idioma);
	}

}
