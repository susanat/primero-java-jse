package com.inpartek.formacion.proyectojava.exception;

import com.inpartek.formacion.proyectojava.pojo.Persona;

public class PersonaException extends Exception {

	/**
     *
     */
	private int codigo;
	private static final long serialVersionUID = 1L;
	public static final int COD_EDAD_NO_VALIDA = 0;
	public static final int COD_LONG_TEXTO_NO_VALIDA = 10;
	public static final int COD_DNI_NO_VALIDO = 20;
	public static final int COD_EMAIL_NO_VALIDO = 30;

	public static final String MSG_TEXTO_NO_VALIDO = "EL TEXTO INTRODUCIDO DEBE DE TENER ALMENOS "
			+ Persona.TEXTO_LONG_MIN + " CARACTERES";

	public static final String MSG_EDAD_NO_VALIDA = "LA EDAD INTRODUCIDA DEBE DE ESTAR COMPRENDIDA ENTRE "
			+ Persona.EDAD_MIN + " Y " + Persona.EDAD_MAX;

	public static final String MSG_DNI_NO_VALIDO = "EL TEXTO INTRODUCIDO DEBE DE CONSTAR DE 8 NUMEROS Y UNA LETRA";
	public static final String MSG_EMAIL_NO_VALIDA = "EL EMAIL DE CONSTAR DE UNA ID @ Y NOMBRE DE DOMINIO";

	public PersonaException() {
		super();
	}

	public PersonaException(final String message) {
		super(message);
	}

	public PersonaException(final String message, final int pcodigo) {
		super(message);
		this.codigo = pcodigo;
	}

	public PersonaException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public PersonaException(final String message, final Throwable cause,
			final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PersonaException(final Throwable cause) {
		super(cause);
	}

	public int getCodigo() {
		return codigo;
	}

}
