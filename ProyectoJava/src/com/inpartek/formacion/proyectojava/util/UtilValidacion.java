package com.inpartek.formacion.proyectojava.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO implementar las validaciones en la clase Persona
public class UtilValidacion {
    private final static String DNI_PATTERN = "(\\d{1,8}[A-Z])";
    private final static String EDAD_PATTERN = "^\\d+$";
    private final static String EMAIL_PATTERN = "^[\\w\\.=-]+@[\\w\\.-]+\\.[\\w]{2,3}$";

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

    public static boolean validarEmail(final String email) {
	Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
	Matcher m = emailPattern.matcher(email);

	if (m.matches()) {
	    return true;
	} else {
	    return false;
	}

    }
}
