package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Fecha {

	/**
	 * Devuelve un String con el formato de una fecha correspondiente al
	 * 
	 * @param hoyDate
	 * @param castellano
	 * @return
	 */
	public static String getString(GregorianCalendar hoyDate, Idioma castellano) {
		String resul = "";
		SimpleDateFormat formato = null;

		if (castellano == Idioma.CASTELLANO) {
			formato = new SimpleDateFormat("dd/MM/yyyy");
		} else {
			formato = new SimpleDateFormat("yyyy/MM/dd");
		}
		resul = formato.format(hoyDate.getTime());
		return resul;
		/*
		 * int dia = hoyDate.get(GregorianCalendar.DAY_OF_MONTH); int mes =
		 * hoyDate.get(GregorianCalendar.MONTH) + 1; int anio =
		 * hoyDate.get(GregorianCalendar.YEAR);
		 * 
		 * String diaString = String.format("%02d", dia); String mesString
		 * =String.format("%02d", mes); if (castellano){ resul = }else{
		 * 
		 * }
		 */
	}

}
