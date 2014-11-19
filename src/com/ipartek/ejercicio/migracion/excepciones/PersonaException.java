package com.ipartek.ejercicio.migracion.excepciones;

public class PersonaException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -9181319064807734990L;

    // DNI no valido

    public static final String MSG_DNI_NO_VALIDO = "El DNI que ha introducido no es valido";
    public static final int COD_DNI_NO_VALIDO = 0;

    // Email no valido
    public static final String MSG_EMAIL_NO_VALIDO = "El EMAIL que ha introducido no es valido";
    public static final int COD_EMAIL_NO_VALIDO = 1;

    // Edad no comprendida entre 18 y 99
    public static final String MSG_EDAD_NO_VALIDA = "LA EDAD debe estar comprendida entre 18 y 99 años";
    public static final int COD_EDAD_NO_VALIDA = 2;

    // Atributos

    int codigo;

    public PersonaException(String message) {
	super(message);
    }

    public PersonaException(String message, int codigo) {
	super(message);
	this.codigo = codigo;
    }

}
