package com.ipartek.ejercicio.migracion;

import com.ipartek.ejercicio.migracion.excepciones.PersonaException;
import com.ipartek.ejercicio.migracion.util.Utilidades;

public class Persona {

    // Atributos de la clase

    private String nombre;
    private String apellido;
    private String poblacion;
    private int edad;
    private String mail;
    private String dni;
    private String categoria;

    // Constructores

    public Persona(String nombre, String apellido, String poblacion, int edad,
	    String mail, String dni, String categoria) throws PersonaException {
	super();
	setNombre(nombre);
	setApellido(apellido);
	setPoblacion(poblacion);
	setEdad(edad);
	setMail(mail);
	setDni(dni);
	setCategoria(categoria);
    }

    public Persona(String nombre, String apellido, String poblacion, int edad,
	    String mail, String dni, String categoria, boolean flag) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.poblacion = poblacion;
	this.edad = edad;
	this.mail = mail;
	this.dni = dni;
	this.categoria = categoria;
    }

    // Getters y setters

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) throws PersonaException {
	if (Utilidades.isUTF8MisInterpreted(nombre)) {
	    this.nombre = nombre;
	} else {
	    throw new PersonaException(PersonaException.MSG_CARACTER_NO_VALIDO,
		    PersonaException.COD_CARACTER_NO_VALIDO);
	}
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) throws PersonaException {
	if (Utilidades.isUTF8MisInterpreted(apellido)) {
	    this.apellido = apellido;
	} else {
	    throw new PersonaException(PersonaException.MSG_CARACTER_NO_VALIDO,
		    PersonaException.COD_CARACTER_NO_VALIDO);
	}
    }

    public String getPoblacion() {
	return poblacion;
    }

    public void setPoblacion(String poblacion) throws PersonaException {
	if (Utilidades.isUTF8MisInterpreted(poblacion)) {
	    this.poblacion = poblacion;
	} else {
	    throw new PersonaException(PersonaException.MSG_CARACTER_NO_VALIDO,
		    PersonaException.COD_CARACTER_NO_VALIDO);
	}

    }

    public int getEdad() {
	return edad;
    }

    public void setEdad(int edad) throws PersonaException {
	if (edad < 18 || edad > 99) {
	    // edad no valida
	    this.edad = edad;
	    throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
		    PersonaException.COD_EDAD_NO_VALIDA);
	} else {
	    // Edad valida
	    this.edad = edad;
	}

    }

    public String getMail() {
	return mail;
    }

    public void setMail(String mail) throws PersonaException {
	if (Utilidades.validarEmail(mail)
		|| Utilidades.isUTF8MisInterpreted(mail)) {
	    // Mail correcto
	    this.mail = mail;
	} else {
	    // mail incorrecto
	    this.mail = mail;
	    if (!Utilidades.validarEmail(mail)) {
		throw new PersonaException(
			PersonaException.MSG_EMAIL_NO_VALIDO,
			PersonaException.COD_EMAIL_NO_VALIDO);
	    }
	    if (!Utilidades.isUTF8MisInterpreted(mail)) {
		throw new PersonaException(
			PersonaException.MSG_CARACTER_NO_VALIDO,
			PersonaException.COD_CARACTER_NO_VALIDO);
	    }

	}

    }

    public String getDni() {
	return dni;
    }

    public void setDni(String dni) throws PersonaException {
	if (Utilidades.validarDNI(dni) || Utilidades.isUTF8MisInterpreted(dni)) {
	    // Dni correcto
	    this.dni = dni;
	} else {
	    this.dni = dni;
	    if (!Utilidades.validarDNI(dni)) {
		throw new PersonaException(PersonaException.MSG_DNI_NO_VALIDO,
			PersonaException.COD_DNI_NO_VALIDO);
	    }
	    if (Utilidades.isUTF8MisInterpreted(dni)) {
		throw new PersonaException(
			PersonaException.MSG_CARACTER_NO_VALIDO,
			PersonaException.COD_CARACTER_NO_VALIDO);
	    }

	}

    }

    public String getCategoria() {
	return categoria;
    }

    public void setCategoria(String categoria) throws PersonaException {
	if (Utilidades.isUTF8MisInterpreted(categoria)) {
	    this.categoria = categoria;
	} else {
	    throw new PersonaException(PersonaException.MSG_CARACTER_NO_VALIDO,
		    PersonaException.COD_CARACTER_NO_VALIDO);
	}

    }

    public void setCategoriaNoCheck(String categoria) {
	this.categoria = categoria;
    }

}
