package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Fecha {

	public Fecha() {
		// TODO Auto-generated constructor stub
	}

	public static String getString(GregorianCalendar hoyDate, Idioma castellano) {
		String resul = "";

		String formatCas = "dd/MM/yyyy";
		String formatEus = "yyyy/MM/dd";

		String formats = null;

		switch (castellano) {
		case CASTELLANO:
			formats = formatCas;
			break;
		case EUSKERA:
			formats = formatEus;
			break;

		}

		SimpleDateFormat format = new SimpleDateFormat(formats);
		resul = format.format(hoyDate.getTime());
		return resul;
	}

	public static String getString(long date) {
		GregorianCalendar d = new GregorianCalendar();
		d.setTimeInMillis(date);
		return getString(date);
	}
}
