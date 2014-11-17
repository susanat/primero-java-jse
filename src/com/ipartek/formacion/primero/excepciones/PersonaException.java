package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.Persona;

public class PersonaException extends Exception {
	// Constantes
	private static final long serialVersionUID = -6547958395313153107L;
	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar comprendida entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;
	public static final int COD_EDAD_NO_VALIDA = 0;
	public static final String MSG_LONG_TOO_SHORT = "Longitud mínima de "
			+ Persona.MIN_CAR + " caracteres";
	public static final int COD_LONG_TOO_SHORT = 1;

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

	// Getters y setters
	public int getCodigo() {
		return codigo;
	}
}
