package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.Persona;

public class PersonaException extends Exception {

	// Constantes
	/**
	 *
	 */
	private static final long serialVersionUID = 1829175731493970446L;

	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar comprendida entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD + ".";
	public static final int COD_EDAD_NO_VALIDA = 0;

	public static final int MIN_LENGTH = 2;
	public static final String MSG_LENGTH_SHORT = "La longitud debe ser mayor que "
			+ MIN_LENGTH + ".";
	public static final int COD_LENGTH_SHORT = 1;

	// Atributos
	int codigo;

	// Constructores
	public PersonaException(String message) {
		super(message);
	}

	public PersonaException(String message, int codigo) {
		super(message);
		this.codigo = codigo;
	}

	// Setters & Getters
	public int getCodigo() {
		return codigo;
	}

}
