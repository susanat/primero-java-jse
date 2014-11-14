package com.impartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.Persona;

/**
 * Clase para crear excepciones personalizadas
 *
 * @author Mario Alvaro
 *
 */
public class PersonaException extends Exception {
	// constantes
	private static final long serialVersionUID = 1L;

	// edad
	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar comprendida entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;
	public static final int COD_EDAD_NO_VALIDA = 0;

	// nombre, appelidos
	public static final String MSG_NOMBRE_NO_VALIDO = "El nombre y/o apellido debe tener una longitud mayor de "
			+ Persona.MIN_LENGTH;
	public static final int COD_NOMBRE_NO_VALIDO = 1;

	// atributos
	private int codigoError;

	// constructores
	public PersonaException(String message) {
		super(message);

	}

	public PersonaException(String message, int codigo) {
		super(message);
		this.codigoError = codigo;

	}

	// getters
	public int getCodigoError() {
		return codigoError;
	}

}
