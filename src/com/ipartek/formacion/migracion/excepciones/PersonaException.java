package com.ipartek.formacion.migracion.excepciones;

import com.ipartek.formacion.migracion.bean.Persona;

public class PersonaException extends Exception {

	// constantes
	private static final long serialVersionUID = 1829175731493970446L;

	// edad
	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar comprendida entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;
	public static final int COD_EDAD_NO_VALIDA = 0;

	// nombre,apellido1,apellido2 < 2 longitud
	public static final String MSG_STRING_CORTO = Persona.MIN_STRING
			+ " longitud minima";
	public static final int COD_STRING_CORTO = 1;

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

	// getter/setters
	public int getCodigo() {
		return codigo;
	}

}
