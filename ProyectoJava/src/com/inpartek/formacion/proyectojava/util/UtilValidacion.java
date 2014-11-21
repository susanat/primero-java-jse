package com.inpartek.formacion.proyectojava.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO implementar las validaciones en la clase Persona
public class UtilValidacion {

    private final static String DNI_PATTERN = "(\\d{1,8})([A-Z])";
    private final static String NUMBER_PATTERN = "^\\d+$";
    private final static String EMAIL_PATTERN = "^[\\w\\.=-]+@[\\w\\.-]+\\.[\\w]{2,3}$";

    /**
     * Función que valida si el numero que se manda es un numero entero
     *
     * @param edad
     * @return
     */
    public static boolean isNumber(final String number) {
	boolean exito = false;
	Pattern edadPattern = Pattern.compile(NUMBER_PATTERN);
	Matcher m = edadPattern.matcher(number);

	if (m.matches()) {
	    exito = true;
	}
	return exito;
    }

    /**
     * Funcion que valida el dni que se envia tiene el formato adecuado 8
     * numeros y una letra
     *
     * @param dni
     *            {@code String} el DNI a validar
     * @return {@code boolean} si es correcto o incorrecto
     */
    public static boolean validarDNI(final String dni) {
	final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	int nDni;
	String letra = null;
	String reference = null;
	boolean valido = false;
	Pattern dniPattern = null;
	Matcher m = null;
	dniPattern = Pattern.compile(DNI_PATTERN);
	m = dniPattern.matcher(dni.toUpperCase());

	if (m.matches()) {
	    letra = m.group(2);
	    nDni = Integer.parseInt(m.group(1));
	    nDni = nDni % 23;
	    reference = LETRAS.substring(nDni, nDni + 1);
	    if (reference.equalsIgnoreCase(letra)) {
		valido = true;
	    }
	}

	return valido;
    }

    /***
     * Funcion que valida si el email tiene un formato valido
     *
     * @param email
     *            {@code String} la cadena de texto a validar
     * @return {@code boolean} si tiene un formato valido o no
     */
    public static boolean validarEmail(final String email) {
	boolean valido = false;
	Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
	Matcher m = emailPattern.matcher(email);

	if (m.matches()) {
	    valido = true;
	}
	return valido;
    }
}
