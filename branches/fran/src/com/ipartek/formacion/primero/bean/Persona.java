package com.ipartek.formacion.primero.bean;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

import com.ipartek.formacion.primero.excepciones.PersonaException;

/**
 * Clase para reprensentar una persona, se compone de:
 * <ol>
 * <li>nombre {@code String} obligatorio</li>
 * </ol>
 * 
 * 
 * @author Ander Uraga Real
 *
 */
public class Persona implements Comparable<Persona> {

	public static final char SEXO_VARON = 'v';
	public static final char SEXO_MUJER = 'm';
	public static final char SEXO_OTROS = 'o';

	public static final int MAYOR_EDAD = 18;
	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;
	public static final int MIN_CAR = 2;

	public static final String NOMBRE_NULO = "sin determinar";

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
		if (nombre == null || nombre.length() < 2) {
			throw new PersonaException("Nombre,"
					+ PersonaException.MSG_LONG_TOO_SHORT,
					PersonaException.COD_LONG_TOO_SHORT);
		}
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) throws PersonaException {
		if (apellido1 == null || apellido1.length() < 2) {
			throw new PersonaException("Apellido1,"
					+ PersonaException.MSG_LONG_TOO_SHORT,
					PersonaException.COD_LONG_TOO_SHORT);
		}
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws PersonaException {
		if (apellido2 == null || apellido2.length() < 2) {
			throw new PersonaException("Apellido2,"
					+ PersonaException.MSG_LONG_TOO_SHORT,
					PersonaException.COD_LONG_TOO_SHORT);
		}
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {
		if (edad < MIN_EDAD || edad > MAX_EDAD) {
			// La edad tiene que estar comprendida entre MIN_EDAD y MAX_EDAD
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
					PersonaException.COD_EDAD_NO_VALIDA);
		}
		this.edad = edad;
		this.mayorEdad = (this.edad >= MAYOR_EDAD) ? true : false;
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
		Collator c = Collator.getInstance(new Locale("es_ES"));
		c.setStrength(Collator.PRIMARY);
		return c.compare(this.getNombre(), o.getNombre());
	}

	/**
	 * Comparator para edad
	 */
	public class ComparatorEdad implements Comparator<Persona> {

		@Override
		public int compare(Persona o1, Persona o2) {
			return Integer.compare(o1.getEdad(), o2.getEdad());
		}

	}

}
