package com.ipartek.formacion.primero.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {

	public static Object getString(GregorianCalendar hoyDate, Idioma castellano) {
		
		Date actual = new java.util.Date();
		int hora, minutos, segundos;
		Calendar calendario = new GregorianCalendar();
		hora= calendario.get(calendario.HOUR_OF_DAY);
		minutos = calendario.get(calendario.MINUTE);
		segundos = calendario.get(calendario.SECOND);
		
		
		SimpleDateFormat formatoCastellano = new SimpleDateFormat("dd"+ "/"+"MM"+ "/"+"yyyy");
		String hoyStringCastellano = formatoCastellano.format(actual);
		
		System.out.println("La fecha en castellano es " + hoyStringCastellano + " y la hora " +  hora + ":" + minutos + ":" + segundos);
				
		
		return null;
	}

	
	
	
}
