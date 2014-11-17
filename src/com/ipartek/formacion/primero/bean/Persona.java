package com.ipartek.formacion.primero.bean;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

import com.ipartek.formacion.primero.excepciones.PersonaException;

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
public class Persona implements Comparable<Persona> {

	static final char SEXO_VARON = 'v';
	static final char SEXO_MUJER = 'm';
	static final char SEXO_OTROS = 'o';

	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;

	static final String NOMBRE_NULO = "sin determinar";

	// Atributos
	String nombre;
	String apellido1;
	String apellido2;
	int edad;
	String dni;
	String poblacion;
	boolean mayorEdad = false;
	String telefono;
	char sexo = 'o';
	ArrayList<Libro> libros;

	// ArrayList<Calificacion> calificaciones;

	// Constructor
	public Persona() {
		super();
		this.nombre = "Jhon";
		this.apellido1 = "Doe";
		this.dni = "xxxxxxxxx";
	}

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona(String nombre, String apellido1, String dni) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.dni = dni;
	}

	public Persona(String nombre, String apellido1, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.edad = edad;
		this.dni = dni;
		this.mayorEdad = (this.edad >= 18) ? true : false;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {
		if (nombre.length() >= 2) {
			this.nombre = nombre;
		} else {
			throw new PersonaException(PersonaException.MSG_LONG_INVALIDA);
		}
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) throws PersonaException {
		if (apellido1.length() >= 2) {
			this.apellido1 = apellido1;
		} else {
			throw new PersonaException(PersonaException.MSG_LONG_INVALIDA);
		}
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws PersonaException {
		if (apellido2.length() >= 2) {
			this.apellido2 = apellido2;
		} else {
			throw new PersonaException(PersonaException.MSG_LONG_INVALIDA);
		}

	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {

		if (edad >= MIN_EDAD && edad <= MAX_EDAD) {
			this.edad = edad;
			this.mayorEdad = (this.edad >= MIN_EDAD) ? true : false;
		} else {
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA);
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	/*
	 * public ArrayList<Calificacion> getCalificaciones() { return
	 * calificaciones; }
	 * 
	 * public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
	 * this.calificaciones = calificaciones; }
	 */
	// Metodos
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + ", dni="
				+ dni + ", poblacion=" + poblacion + ", mayorEdad=" + mayorEdad
				+ ", telefono=" + telefono + ", sexo=" + sexo + "]";
	}

	@Override
	public int compareTo(Persona o) {
		Collator myDefaultCollator = Collator.getInstance(Locale.getDefault());

		return myDefaultCollator.compare(this.getNombre(), o.getNombre());
	}

	public static class ComparatorEdad implements Comparator<Persona> {

		@Override
		public int compare(Persona o1, Persona o2) {
			return Integer.compare(o1.getEdad(), o2.getEdad());
		}
	}

}
