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
	private static final String MASCARAES = "dd/MM/yyyy";
	private static final String MASCARAEU = "yyyy/MM/dd";

	/***
	 * Formatear fecha segun {@code Idioma} recibiendo tipo de dato
	 * {@code GregorianCalendar}
	 *
	 * @param fecha
	 *            {@code GregorianCalendar} con la fecha a formatear
	 * @param idioma
	 *            {@code enum} para Idioma
	 * @see com.ipartek.formacion.proyectoclase.util;
	 * @return dateFormatted {@code String} con la fecha formateada
	 */
	public static String getString(GregorianCalendar fecha, Idioma idioma) {
		/**
		 *
		 */
		String dateFormatted = "";

		// TODO Implementar
		switch (idioma) {
		case CASTELLANO:
			fmt = new SimpleDateFormat(MASCARAES);
			break;
		case EUSKERA:
			fmt = new SimpleDateFormat(MASCARAEU);
			break;
		}
		fmt.setCalendar(fecha);
		dateFormatted = fmt.format(fecha.getTime());
		return dateFormatted;

	}

	/***
	 * Formatear fecha segun {@code Idioma} recibiendo tipo de dato {@code long}
	 *
	 * @param fecha
	 *            {@code long} con la fecha a formatear en milisegundos
	 * @param idioma
	 *            {@code enum} para Idioma
	 * @see com.ipartek.formacion.proyectoclase.util;
	 * @return dateFormatted {@code String} con la fecha formateada
	 */
	public static String getString(long fecha, Idioma idioma) {
		String dateFormatted = "";
		GregorianCalendar aux = new GregorianCalendar();
		switch (idioma) {
		case CASTELLANO:
			fmt = new SimpleDateFormat(MASCARAES);
			break;
		case EUSKERA:
			fmt = new SimpleDateFormat(MASCARAEU);
			break;
		}
		aux.setTimeInMillis(fecha);
		fmt.setCalendar(aux);
		dateFormatted = fmt.format(aux.getTime());
		return dateFormatted;
	}

}
