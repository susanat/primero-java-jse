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
	this.nombre = nombre;
	this.apellido = apellido;
	this.poblacion = poblacion;
	setEdad(edad);
	setMail(mail);
	setDni(dni);
	this.categoria = categoria;
    }

    // Getters y setters

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getPoblacion() {
	return poblacion;
    }

    public void setPoblacion(String poblacion) {
	this.poblacion = poblacion;
    }

    public int getEdad() {
	return edad;
    }

    public void setEdad(int edad) throws PersonaException {
	if (edad < 18 || edad > 99) {
	    // edad no valida
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
	if (Utilidades.validarEmail(mail)) {
	    // Mail correcto
	    this.mail = mail;
	} else {
	    // mail incorrecto
	    throw new PersonaException(PersonaException.MSG_EMAIL_NO_VALIDO,
		    PersonaException.COD_EMAIL_NO_VALIDO);

	}

    }

    public String getDni() {
	return dni;
    }

    public void setDni(String dni) throws PersonaException {
	if (Utilidades.validarDNI(dni)) {
	    // Dni correcto
	    this.dni = dni;
	} else {
	    throw new PersonaException(PersonaException.MSG_DNI_NO_VALIDO,
		    PersonaException.COD_DNI_NO_VALIDO);

	}

    }

    public String getCategoria() {
	return categoria;
    }

    public void setCategoria(String categoria) {
	this.categoria = categoria;
    }

    // Metodos

}
