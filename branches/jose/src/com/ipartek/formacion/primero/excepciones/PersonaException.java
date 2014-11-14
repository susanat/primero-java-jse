package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.bean.Persona;

public class PersonaException extends Exception {

	// Constantes
	private static final long serialVersionUID = -6547958395313153107L;

	// Error por edad menor a 18 o mayor a 99
	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;
	public static final int COD_EDAD_NO_VALIDA = 0;

	// ERROR: por nombre o apellidos menor a 2 caracteres
	public static final int COD_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO = 1;
	public static final String MSG_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO = "El nombre y los apellidos deben de tener como minimo "
			+ Persona.TAM_MIN_NOMBRE_APELLIDOS + " letras";

	// Atributos
	int codigo;

	// Constructores
	public PersonaException(String message) {
		super(message);
	}

	public PersonaException(String mensaje, int codigo) {
		super(mensaje);
		this.codigo = codigo;
	}

	// Getters y Setters
	public int getCodigo() {
		return codigo;
	}

}
