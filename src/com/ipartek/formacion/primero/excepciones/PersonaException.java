package com.ipartek.formacion.primero.excepciones;

import com.ipartek.formacion.primero.practicas.migracion.Persona;

public class PersonaException extends Exception {

	// Constantes
	private static final long serialVersionUID = -6547958395313153107L;

	// Error por edad menor a 18 o mayor a 99
	public static final String MSG_EDAD_NO_VALIDA = "La edad debe estar entre "
			+ Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;
	public static final int COD_EDAD_NO_VALIDA = 0;

	// ERROR: por nombre o apellidos menor a 2 caracteres
	/*
	 * public static final int COD_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO = 1;
	 * public static final String MSG_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO =
	 * "El nombre y los apellidos deben de tener como minimo " +
	 * Persona.TAM_MIN_NOMBRE_APELLIDOS + " letras";
	 */
	// ERROR: no existe el dato
	public static final int COD_DATO_INCOMPLETO = 2;
	public static final String MSG_DATO_INCOMPLETO = "Falta el dato";

	// ERROR: el formato de un dato de tipo email no es correcto
	// (nombre@gmail.com)
	public static final int COD_FORMATO_EMAIL_INCORRECTO = 3;
	public static final String MSG_FORMATO_EMAIL_INCORRECTO = "El formato del email no es el correcto";

	// ERROR: el formato de un dato de tipo DNI
	// nn nnn nnn C
	public static final int COD_FORMATO_DNI_INCORRECTO = 4;
	public static final String MSG_FORMATO_DNI_INCORRECTO = "El formato del dni no es correcto";

	// ERROR: la letra del DNI
	public static final int COD_LETRA_DNI_INCORRECTA = 5;
	public static final String MSG_LETRA_DNI_INCORRECTA = "La letra del dni no es correcta";

	// ERROR: la letra del DNI
	public static final int COD_FORMATO_TEXTO_INCORRECTO = 6;
	public static final String MSG_FORMATO_TEXTO_INCORRECTO = "El formato del texto es incorrecto";

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
