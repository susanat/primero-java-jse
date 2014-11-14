package com.ipartek.formacion.proyectoclase.excepciones;

import com.ipartek.formacion.proyectoclase.pojo.Persona;

public class PersonaException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final int COD_EDAD_NO_VALIDA = 0;
	public static final int COD_LONG_TEXTO_NO_VALIDA = 10;

	public static final String MSG_TEXTO_NO_VALIDO = "EL TEXTO INTRODUCIDO DEBE DE TENER ALMENOS "
			+ Persona.TEXTO_LONG_MIN + " CARACTERES";
	public static final String MSG_EDAD_NO_VALIDA = "LA EDAD INTRODUCIDA DEBE DE ESTAR COMPRENDIDA ENTRE "
			+ Persona.MIN_EDAD + " Y " + Persona.MAYOR_EDAD;
	// TODO nombre menor a 2 letras de longitud
	/**
	 *
	 */
	private int codigo;

	public PersonaException() {
		super();
	}

	public PersonaException(String message, int codigo) {
		super(message);
		this.codigo = codigo;
	}

	public PersonaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PersonaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonaException(String message) {
		super(message);
	}

	public PersonaException(Throwable cause) {
		super(cause);
	}

	public int getCodigo() {
		return codigo;
	}

}
