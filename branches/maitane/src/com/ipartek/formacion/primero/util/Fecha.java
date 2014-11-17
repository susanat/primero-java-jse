package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {

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

	public static String getString(long hoyDate, Idioma idioma) {
		String rdo = "";

		Date date = new Date(hoyDate);
		GregorianCalendar fecha = new GregorianCalendar();
		fecha.setTime(date);
		rdo = getString(fecha, idioma);
		return rdo;

	}

}
