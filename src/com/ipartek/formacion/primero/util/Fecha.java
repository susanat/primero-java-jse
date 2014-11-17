package com.ipartek.formacion.primero.util;

import java.util.GregorianCalendar;

public class Fecha {

	/**
	 * Función para devolver el formato de fecha según el idioma recibido.
	 *
	 * @param fecha
	 *            Fecha a formatear
	 * @param idioma
	 *            Idioma al que se quiere formatear
	 * @return String con la fecha formateada
	 */
	public static String getString(GregorianCalendar fecha, Idioma idioma) {
		String res = "";

		switch (idioma) {
		case CASTELLANO:
			res = fecha.get(GregorianCalendar.DAY_OF_MONTH) + "/"
					+ (fecha.get(GregorianCalendar.MONTH) + 1) + "/"
					+ fecha.get(GregorianCalendar.YEAR);
			break;
		case EUSKERA:
			res = fecha.get(GregorianCalendar.YEAR) + "/"
					+ (fecha.get(GregorianCalendar.MONTH) + 1) + "/"
					+ fecha.get(GregorianCalendar.DAY_OF_MONTH);
			break;
		}

		return res;
	}
}
