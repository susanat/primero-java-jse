package com.ipartek.formacion.proyectoclase.pojo;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.ipartek.formacion.proyectoclase.util.Idioma;

/**
 *
 * @author Urko Villanueva
 *
 */
public class Fecha {
	/**
	 * {@code SimpleDateFormat}
	 */
	private static SimpleDateFormat fmt;

	/***
	 *
	 * @param fecha
	 * @param idioma
	 * @return dateFromatted {@code String}
	 */
	public static String getString(GregorianCalendar fecha, Idioma idioma) {
		/**
		 *
		 */
		String dateFormatted = "";

		// TODO Implementar
		switch (idioma) {
		case CASTELLANO:
			fmt = new SimpleDateFormat("dd/M/yyyy");
			break;
		case EUSKERA:
			fmt = new SimpleDateFormat("yyyy/M/dd");
			break;
		}
		fmt.setCalendar(fecha);
		dateFormatted = fmt.format(fecha.getTime());
		return dateFormatted;

	}

	/**
	 *
	 * @param fecha
	 * @param idioma
	 * @return dateFromatted {@code String}
	 */
	public static String getString(long fecha, Idioma idioma) {
		String dateFormatted = "";
		GregorianCalendar aux = new GregorianCalendar();
		switch (idioma) {
		case CASTELLANO:
			fmt = new SimpleDateFormat("dd/M/yyyy");
			break;
		case EUSKERA:
			fmt = new SimpleDateFormat("yyyy/M/dd");
			break;
		}
		aux.setTimeInMillis(fecha);
		fmt.setCalendar(aux);
		dateFormatted = fmt.format(aux.getTime());
		return dateFormatted;
	}

}
