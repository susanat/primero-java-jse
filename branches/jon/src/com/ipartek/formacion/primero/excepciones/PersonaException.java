package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.Persona;

public class PersonaException extends Exception {

	private static final long serialVersionUID = 1829175731493970446L;

	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar comprendida entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;

	public static final String MSG_LONG_INVALIDA = "Longitud invalida";

	int codigo;

	public PersonaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PersonaException(String message, int codigo) {
		super(message);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

}
