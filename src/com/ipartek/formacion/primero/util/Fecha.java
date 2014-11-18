package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase Fecha para formatear fechas
 *
 * @author Maitane Casado Fernandez
 *
 */
public class Fecha {

	/**
	 * Formatea la fecha segun el {@code Idioma} en el que se vaya a leer
	 *
	 * @param hoyDate
	 *            {@code GregorianCalendar}La fecha en GregorianCalendar
	 * @param idioma
	 *            {@code enum}Idioma en el que se va a leer. Viene de la clase
	 *            enum Idioma
	 * @see package com.ipartek.formacion.primero.util;
	 *
	 * @return {@code String} con la fecha formateada
	 */

	public static String getString(GregorianCalendar hoyDate, Idioma idioma) {
		String rdo = "";
		SimpleDateFormat formato = null;

		if (idioma == Idioma.CASTELLANO) {
			formato = new SimpleDateFormat("dd/MM/yyyy");
		}

		else if (idioma == Idioma.EUSKERA) {
			formato = new SimpleDateFormat("yyyy/MM/dd");

		}

		rdo = formato.format(hoyDate.getTime());
		return rdo;

	}

	/**
	 * Formatea la fecha segun el {@code Idioma} en el que se vaya a leer
	 *
	 * @param hoyDate
	 *            La fecha en formato {@code long}
	 * @param idioma
	 *            Idioma en el que se va a leer. Viene de la clase {@code enum}
	 *            Idioma
	 * @return {@code String} con la fecha formateada
	 */

	public static String getString(long hoyDate, Idioma idioma) {
		String rdo = "";

		Date date = new Date(hoyDate);
		GregorianCalendar fecha = new GregorianCalendar();
		fecha.setTime(date);
		rdo = getString(fecha, idioma);
		return rdo;

	}

}
