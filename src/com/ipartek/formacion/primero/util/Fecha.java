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
	 *            - la fecha de hoy
	 * @param idioma
	 *            - idioma al que se quiere formatear la fecha
	 * @return un String con la fecha formateada
	 */
	public static String getString(GregorianCalendar hoyDate, Idioma idioma) {
		return getString(hoyDate.getTimeInMillis(), idioma);

	}

	/**
	 * Dada una fecha en milisegundos y un idiom, formatea la fecha en
	 * consecuencia
	 *
	 * @param fechaHoy
	 *            - Fecha en milisegundos
	 * @param idioma
	 *            - idioma al que se quiere formatear la fecha
	 * @return resul - String con la fecha formateada
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

		Date fecha = new Date(fechaHoy);
		resul = formato.format(fecha);
		return resul;

	}

}
