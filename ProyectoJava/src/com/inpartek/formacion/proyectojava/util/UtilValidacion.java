package com.inpartek.formacion.proyectojava.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO implementar las validaciones en la clase Persona
public class UtilValidacion {
	public static boolean isNumber(final String edad) {
		Pattern edadPattern = Pattern.compile(EDAD_PATTERN);
		Matcher m = edadPattern.matcher(edad);

		if (m.matches()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Funcion que valida el dni que se envia
	 *
	 * @param dni
	 *            {@code String} el DNI a validar
	 * @return {@code boolean} si es correcto o incorrecto
	 */
	public static boolean validarDNI(final String dni) {
		boolean valido = false;
		Pattern dniPattern = null;
		Matcher m = null;
		dniPattern = Pattern.compile(DNI_PATTERN);
		m = dniPattern.matcher(dni);
		if (m.matches()) {
			valido = true;
		}

		return valido;
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

	private final static String DNI_PATTERN = "(\\d{1,8}[A-Z])";

	private final static String EDAD_PATTERN = "^\\d+$";

	private final static String EMAIL_PATTERN = "^[\\w\\.=-]+@[\\w\\.-]+\\.[\\w]{2,3}$";

}
