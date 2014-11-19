package com.ipartek.ejercicio.migracion.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aeat.valida.Validador;

public class Utilidades {

    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     *
     * @param dni
     * @return
     */
    public static boolean validarDNI(String dni) {
	boolean valido = false;
	Validador validador = new Validador();
	int e = validador.checkNif(dni);
	if (e > 0) {
	    valido = true;
	} else {
	    valido = false;
	}
	return valido;

    }

    /**
     * Funcion que comprueba la validez de un mail en base a una expresion
     * regular
     *
     * @param email
     * @return
     */
    public static boolean validarEmail(String email) {
	boolean valido = false;
	Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	Matcher matcher = pattern.matcher(email);
	// True if valid email, false if invalid
	return matcher.matches();
    }

    public static boolean validarCodificacion(String cadena) {
	boolean valida = false;
	// TODO: Convertimos la cadena en bytes

	return valida;
    }

    public static byte[] getBytes(String cadena) {
	byte[] bytes = cadena.getBytes();
	return bytes;
    }

}
