package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Fecha {

	/**
	 * Devuelve el formato de fecha según el idioma recibido.
	 *
	 * @param fecha
	 *            Fecha a formatear
	 * @param idioma
	 *            Idioma al que se quiere formatear
	 * @return String con la fecha formateada
	 */
	public static String getString(GregorianCalendar fecha, Idioma idioma) {
		String res = "";
		SimpleDateFormat sdf;

		switch (idioma) {
		case CASTELLANO:
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			res = sdf.format(fecha.getTime());
			break;
		case EUSKERA:
			sdf = new SimpleDateFormat("yyyy/MM/dd");
			res = sdf.format(fecha.getTime());
			break;
		}

		return res;
	}

	/**
	 * Devuelve el formato de fecha en milisegundos según el idioma recibido.
	 * 
	 * @param fechaMilisegundos
	 *            Fecha en milisegundos a formatear
	 * @param idioma
	 *            Idioma al que se quiere formatear
	 * @return String con la fecha formateada
	 */
	public static String getString(Long fechaMilisegundos, Idioma idioma) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(fechaMilisegundos);
		return getString(gc, idioma);
	}
}
