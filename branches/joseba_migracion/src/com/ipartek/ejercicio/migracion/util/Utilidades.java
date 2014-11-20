package com.ipartek.ejercicio.migracion.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
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

    /**
     * Funcion que comprueba la correcta codificacion de los carateres
     * 
     * @param input
     * @return
     */

    public static boolean isUTF8MisInterpreted(String input) {
	// convenience overload for the most common UTF-8 misinterpretation
	// which is also the case in your question
	return isUTF8MisInterpreted(input, "Windows-1252");
    }

    /**
     * Funcion que comprueba la correcta codicicacion de los caracteres
     *
     * @param input
     * @param encoding
     * @return
     */

    public static boolean isUTF8MisInterpreted(String input, String encoding) {

	CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
	CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
	ByteBuffer tmp;
	try {
	    tmp = encoder.encode(CharBuffer.wrap(input));
	}

	catch (CharacterCodingException e) {
	    return false;
	}

	try {
	    decoder.decode(tmp);
	    return true;
	} catch (CharacterCodingException e) {
	    return false;
	}
    }

}
