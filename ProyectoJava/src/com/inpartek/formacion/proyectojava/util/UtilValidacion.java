package com.inpartek.formacion.proyectojava.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilValidacion {
    private final static String DNI_PATTERN = "(\\d{1,8}[A-Z])";
    private final static String EDAD_PATTERN = "^\\d+$";

    public static boolean validarDNI(final String dni) {
	Pattern dniPattern = Pattern.compile(DNI_PATTERN);
	Matcher m = dniPattern.matcher(dni);
	if (m.matches()) {
	    return true;
	} else
	    return false;
    }

    public static boolean IsNumber(final String edad) {
	Pattern edadPattern = Pattern.compile(EDAD_PATTERN);
	Matcher m = edadPattern.matcher(edad);

	if (m.matches()) {
	    return true;
	} else {
	    return false;
	}

    }
}
