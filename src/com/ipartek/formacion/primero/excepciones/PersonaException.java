package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.Persona;

public class PersonaException extends Exception {

	// contantes
	private static final long serialVersionUID = 1829175731493970446L;

	// Edad
	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar comprendida entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;
	public static final int COD_EDAD_NO_VALIDA = 0;

	// TODO: nombre menor de 2 caracteres

	public static final String MSG_ARGUMENTO_INVALIDO = "La longitud del argumento debe ser mayor de "
			+ Persona.LONG_MIN;
	public static final int COD_ARG_INVALIDO = 1;

	// atributos
	int codigo;

	// constructores
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
