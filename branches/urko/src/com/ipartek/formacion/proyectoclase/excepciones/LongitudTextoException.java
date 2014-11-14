package com.ipartek.formacion.proyectoclase.excepciones;

public class LongitudTextoException extends Exception {

	/**
	 *
	 */
	public static final int COD_LONG_TEXTO_NO_VALIDA = 10;
	private static final int TEXTO_LONG_MIN = 2;
	public static final String MSG_TEXTO_NO_VALIDO = "EL TEXTO INTRODUCIDO DEBE DE TENER ALMENOS "
			+ TEXTO_LONG_MIN + " CARACTERES";
	private static final long serialVersionUID = 1L;
	private int codigo;

	public LongitudTextoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LongitudTextoException(String message, int codigo) {
		super(message);
		this.codigo = codigo;
	}

	public LongitudTextoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LongitudTextoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LongitudTextoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LongitudTextoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
