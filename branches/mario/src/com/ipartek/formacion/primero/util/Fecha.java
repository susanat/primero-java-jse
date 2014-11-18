package com.ipartek.formacion.primero.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Clase para formatear las fechas dependiendo del idioma
 *
 * @author Mario Alvaro
 *
 */
public class Fecha {

	/**
	 * Dada una fecha sin formatear y un idioma, formatea la fecha en
	 * consecuencia
	 *
	 * @param hoyDate
	 *            - {@code GregorianCalendar} la fecha de hoy
	 * @param idioma
	 *            - {@code enum} idioma al que se quiere formatear la fecha
	 * @return {@code String} con la fecha formateada
	 */
	public static String getString(GregorianCalendar hoyDate, Idioma idioma) {
		return getString(hoyDate.getTimeInMillis(), idioma);

	}

	/**
	 * Dada una fecha en milisegundos y un idioma, formatea la fecha en
	 * consecuencia
	 *
	 * @param fechaHoy
	 *            - {@code long} Fecha en milisegundos
	 * @param idioma
	 *            - {@code enum} idioma al que se quiere formatear la fecha
	 * @return resul - {@code String} con la fecha formateada
	 */
	public static String getString(long fechaHoy, Idioma idioma) {
		String resul = "";
		SimpleDateFormat formato;

		switch (idioma) {
		case CASTELLANO:
			formato = new SimpleDateFormat("dd/MM/yyyy");
			break;
		case EUSKERA:
			formato = new SimpleDateFormat("yyyy/MM/dd");
			break;
		default:
			formato = new SimpleDateFormat();
			break;
		}
		resul = formato.format(new Date(fechaHoy));
		return resul;

	}

}
