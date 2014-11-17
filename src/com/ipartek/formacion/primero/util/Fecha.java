package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase fecha para trabajar con formateo de fechas
 *
 * @author Joseba Carrión Blanco
 *
 */
public class Fecha {

	/**
	 * Funcion que formatea fechas
	 *
	 * @param hoyDate
	 *            Fecha a formatear
	 * @param idioma
	 *            Idioma en el que vamos a formatear la fecha
	 * @return Un String con la fecha formateada
	 */

	public static String getString(GregorianCalendar hoyDate, Idioma idioma) {
		String resul = "";
		SimpleDateFormat formato;

		Date fecha = new Date(hoyDate.getTimeInMillis());

		if (idioma.equals(Idioma.CASTELLANO)) {
			formato = new SimpleDateFormat("dd/M/yyyy");

		} else {
			formato = new SimpleDateFormat("yyyy/M/dd");

		}
		resul = formato.format(fecha);
		return resul;

	}

	/**
	 * Funcion que formatea fechas
	 *
	 * @param hoyDate
	 *            La fecha a formatear en milisegundos
	 * @param idioma
	 *            El idioma en el que vamos a formatear la fecha
	 * @return Un String con la fecha formateada
	 */
	public static String getString(Long hoyDate, Idioma idioma) {
		String resul = "";
		SimpleDateFormat formato;
		Date fecha = new Date(hoyDate);
		if (idioma.equals(Idioma.CASTELLANO)) {
			formato = new SimpleDateFormat("dd/M/yyyy");

		} else {
			formato = new SimpleDateFormat("yyyy/M/dd");

		}
		resul = formato.format(fecha);
		return resul;
	}
}
