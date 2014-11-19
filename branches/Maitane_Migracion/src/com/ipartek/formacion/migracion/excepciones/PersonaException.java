package com.ipartek.formacion.migracion.excepciones;

import com.ipartek.formacion.migracion.bean.Persona;

public class PersonaException extends Exception {

	// constantes
	private static final long serialVersionUID = 7482842608259307880L;

	// edad
	public static final String MSG_EDAD_NO_VALIDO = "La edad debe estar comprendida entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;

	public static final int CODE_EDAD_NO_VALIDO = 0;

	// TODO nombre menor 2

	public static final String MSG_LONG_STRING_NO_VALIDO = Persona.MIN_LONG_STRING
			+ "Es la longitud minima de la cadena de caracteres";

	public static final int CODE_LONG_STRING_NO_VALIDO = 1;

	// atributo
	int codigo;

	// constructores
	public PersonaException(String message) {
		super(message);

	}

	public PersonaException(String message, int codigo) {
		super(message);
		this.codigo = codigo;

	}

	// getters y setters
	public int getCodigo() {
		return codigo;
	}

}
