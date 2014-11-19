package com.ipartek.formacion.migracion.bean;

import com.ipartek.formacion.migracion.excepciones.PersonaException;

/**
 * Clase para reprensentar un Alumno, se compone de:
 * <ol>
 * <li>nombre {@code String} obligatorio</li>
 * </ol>
 *
 *
 * @author Ander Uraga Real
 *
 */
public class Persona {

	public static final int MIN_STRING = 2;
	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;

	// Atributos
	String nombre;
	String apellido1;
	String poblacion;
	int edad;
	String mail;
	String dni;
	String categoria;

	// Constructor
	public Persona() {
		super();
		this.nombre = "Jhon";
		this.apellido1 = "Doe";
		this.dni = "xxxxxxxxx";
	}

	public Persona(String nombre, String apellido1, String dni) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.dni = dni;
	}

	public Persona(String nombre, String apellido1, String poblacion, int edad,
			String mail, String dni, String categoria) throws PersonaException {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setPoblacion(poblacion);
		setEdad(edad);
		setMail(mail);
		setDni(dni);
		setCategoria(categoria);
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
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
		if (edad >= MIN_EDAD && edad <= MAX_EDAD) {
			this.edad = edad;
		} else {
			// lanzar PersonaException
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
					PersonaException.COD_EDAD_NO_VALIDA);
		}
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	// Metodos
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", poblacion=" + poblacion + ", edad=" + edad + ", mail="
				+ mail + ", dni=" + dni + ", categoria=" + categoria + "]";
	}

}
