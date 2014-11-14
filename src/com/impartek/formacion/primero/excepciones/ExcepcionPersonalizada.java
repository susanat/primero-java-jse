package com.impartek.formacion.primero.excepciones;

/**
 * Clase para crear excepciones personalizadas
 * 
 * @author Mario Alvaro
 *
 */
public class ExcepcionPersonalizada extends Exception {

	private static final long serialVersionUID = 1L;

	private int codigoError;
	private String mensaje;

	// Constructor
	public ExcepcionPersonalizada(int codigoError, String mensaje) {
		super();
		this.codigoError = codigoError;
		this.mensaje = mensaje;
	}

	// Getters
	public int getCodigoError() {
		return codigoError;
	}

	public String getMensaje() {
		return mensaje;
	}

}
