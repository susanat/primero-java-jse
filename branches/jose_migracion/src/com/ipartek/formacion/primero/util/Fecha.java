package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Fecha {
	public static final String FORMATO_FECHA_CASTELLANO = "dd/MM/yyyy";
	public static final String FORMATO_FECHA_EUSKERA = "yyyy/MM/dd";

	/**
	 * Devuelve un String con el formato de una fecha correspondiente al idioma
	 * indicado
	 *
	 * @param hoyDate
	 *            {@code GregorianCalendar} fecha a formatear fecha
	 * @param idioma
	 *            {@code enum} formato de la fecha(Euskera/Espagnol)
	 * @see com.ipartek.formacion.primero.util
	 * @return
	 */
	public static String getString(GregorianCalendar hoyDate, Idioma idioma) {
		String resul = "";
		SimpleDateFormat formato = null;

		switch (idioma) {
		case CASTELLANO:
			formato = new SimpleDateFormat(FORMATO_FECHA_CASTELLANO);
			resul = formato.format(hoyDate.getTime());
			break;
		case EUSKARA:
			formato = new SimpleDateFormat(FORMATO_FECHA_EUSKERA);
			resul = formato.format(hoyDate.getTime());
		default:
			break;
		}
		return resul;
	}

	/**
	 * Devuelve un String con el formato de una fecha correspondiente al idioma
	 * indicado
	 *
	 * @param milisegundos
	 *            {@code long} milisegundos desde 01/01/1970
	 * @param idioma
	 *            {@code enum} formato de la fecha(Euskera/Espagnol)
	 * @see com.ipartek.formacion.primero.util
	 * @return
	 */
	public static String getString(long milisegundos, Idioma idioma) {
		String resul = "";

		// obtenemos la fecha a partir de los milisegundo
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(milisegundos);

		// llamamos a la funcion de arriba
		resul = getString(gc, idioma);
		return resul;
	}

}
