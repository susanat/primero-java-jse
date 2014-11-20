package com.ipartek.formacion.migracion.exception;

/**
 * Clase con las excepciones personalizadas.
 *
 * @author Curso
 *
 */
public class PersonaException extends Exception {

	/************************* CONSTANTES **************************/
	/**
	 * Serial Version UID para la serialización.
	 */
	private static final long serialVersionUID = -8848179782140137362L;

	/**
	 * Mensaje para ExceptionPersona que muestra que la cantidad de campos que
	 * hay en la línea es incorrecta.
	 */
	public static final String DATOS_PERSONA_LENGTH = "La cantidad de campos en la línea es incorrecta. "
			+ "Debería ser <nombre>, <apellido1>, <poblacion>, <edad>, <mail>, <categoria>";

	/**
	 * Código para la ExceptionPersona de que la cantidad de campos que hay en
	 * la línea es incorrecta.
	 */
	public static final String COD_PERSONA_LENGTH = "CANTIDAD DE CAMPOS INCORRECTA";

	/**
	 * Mensaje para ExceptionPersona que muestra que la edad no está en el rango
	 * correcto (18-99).
	 */
	public static final String EDAD_PERSONA = "La edad de la Persona está fuera de rango, debería estar entre 18 y 99.";

	/**
	 * Código para la ExceptionPersona de que la edad está fuera de rango.
	 */
	public static final String COD_EDAD_PERSONA = "EDAD";

	/************************** ATRIBUTOS **************************/
	/**
	 * Código de la ExceptionPersona.
	 */
	private String codigo;

	/************************ CONSTRUCTORES ************************/
	/**
	 * Le manda a super el mensaje que va a salir en la ExceptionPersona.
	 *
	 * @param message
	 *            Mensaje de la ExceptionPersona
	 * @param pCodigo
	 *            Código de la ExceptionPersona
	 */
	public PersonaException(final String message, final String pCodigo) {
		super(message);
		this.codigo = pCodigo;
	}

	/********************** GETTERS & SETTERS **********************/
	/**
	 * Retorna el código de la ExceptionPersona.
	 *
	 * @return codigo
	 */
	public final String getCodigo() {
		return codigo;
	}
}
