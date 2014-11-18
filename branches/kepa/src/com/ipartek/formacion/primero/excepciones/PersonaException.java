package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.Persona;

public class PersonaException extends Exception {

	// Constantes
	private static final long serialVersionUID = 1L;
	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar comprendida entre 18 y 99"
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;
	public static final String MSG_DATO_NO_VALIDO = Persona.MIN_LONG_APELLIDO
			+ "caracteres minimo";

	public static final int COD_EDAD_NO_VALIDA = 0;
	public static final int COD_DATO_NO_VALIDO = 0;

	// Atributos
	int codigo;
	public Object getMessage;

	// COnstructores
	public PersonaException(String message) {
		super(message);
	}

	public PersonaException(String message, int codigo) {
		super(message);
		this.codigo = codigo;
	}

	// Getters/Setters
	public int getCodigo() {
		return codigo;
	}

}
