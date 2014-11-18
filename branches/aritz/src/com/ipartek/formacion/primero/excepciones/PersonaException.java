package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.Persona;

public class PersonaException extends Exception {

	/**
	 *
	 */
	// constantes
	private static final long serialVersionUID = 1829175731493970446L;
	public static final String MSG_EDAD_NO_VALIDA = "la edad debe estar comprendida entre  "
			+ Persona.MAYOR_EDAD + " y " + Persona.MAX_EDAD;
	public static final int COD_EDAD_NO_VALIDA = 0;

	// TODO nombre apellidos >= de 2 chars
	public static final String MSG_NOMBRE_NO_VALIDO = "Debe tener mas de 2 caracteres";
	public static final int COD_NOMBRE_NO_VALIDO = 2;

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

	// getters y setters
	public int getCodigo() {
		return codigo;
	}

}
