package com.ipartek.formacion.proyectoclase.pojo;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.ipartek.formacion.proyectoclase.util.Idioma;

public class Fecha {
	private static SimpleDateFormat fmt;

	public static String getString(GregorianCalendar fecha, Idioma idioma) {
		String dateFormatted = "";

		// TODO Implementar
		switch (idioma) {
		case CASTELLANO:
			fmt = new SimpleDateFormat("dd/MM/yyyy");
			break;
		case EUSKERA:
			fmt = new SimpleDateFormat("yyyy/MM/dd");
			break;
		}
		fmt.setCalendar(fecha);
		dateFormatted = fmt.format(fecha.getTime());
		return dateFormatted;

	}

	public static String getString(long fecha, Idioma idioma) {
		String dateFormatted = "";
		GregorianCalendar aux = new GregorianCalendar();
		switch (idioma) {
		case CASTELLANO:
			fmt = new SimpleDateFormat("dd/MM/yyyy");
			break;
		case EUSKERA:
			fmt = new SimpleDateFormat("yyyy/MM/dd");
			break;
		}
		aux.setTimeInMillis(fecha);
		fmt.setCalendar(aux);
		dateFormatted = fmt.format(aux.getTime());
		return dateFormatted;
	}
}
