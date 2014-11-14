package com.ipartek.formacion.primero.bean;

public class PersonaException extends Exception {

	/**
	 * Serialización 
	 */
	private static final long serialVersionUID = -4979826915799927264L;
	
	
	public static final String MSG_EDAD_NO_VALIDA = 
			"Edad entre " + Persona.MIN_EDAD + " y " + Persona.MAX_EDAD;
	
	public static final int COD_EDAD_NO_VALIDA = 0;
		
		
	
	public static final int COD_STRING_CORTO = 1;


	public static final String MSG_STRING_CORTO = "Ha de ser mayor de " + Persona.STRING_MAYOR_QUE + " caracteres.";
		
	
	private int codigo;
	
	public int getCodigo(){
		return codigo;
	}
	
	
	

	/*
	public PersonaException() {
		super();
		// TODO Auto-generated constructor stub
	}
	*/

	/*
	public PersonaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	*/

	/*
	public PersonaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	*/

	public PersonaException(String message) {
		super(message);
		
	}
	
	public PersonaException(String message, int codigo) {
		super(message);
		this.codigo = codigo;
	}

	/*
	public PersonaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	*/
	
	

}
