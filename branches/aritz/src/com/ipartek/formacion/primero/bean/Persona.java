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

	public static final int MAYOR_EDAD = 18;
	public static final int MAX_EDAD = 99;
	public static final int MIN_STRING = 2;

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

	public Persona(String nombre, String apellido1, int edad, String dni)
			throws PersonaException {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		setEdad(edad);
		this.dni = dni;
		this.mayorEdad = (this.edad >= 18) ? true : false;
	}

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {

		longitudCadena(nombre);
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) throws PersonaException {
		longitudCadena(apellido1);
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws PersonaException {
		longitudCadena(apellido2);
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {

		if (edad > MAYOR_EDAD && edad <= MAX_EDAD) {
			this.edad = edad;
			this.mayorEdad = (this.edad >= MAYOR_EDAD) ? true : false;
		} else {
			// lanzar persona exception
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
					PersonaException.COD_EDAD_NO_VALIDA);
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

	// Metodos
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + ", dni="
				+ dni + ", poblacion=" + poblacion + ", mayorEdad=" + mayorEdad
				+ ", telefono=" + telefono + ", sexo=" + sexo + "]";
	}

	@Override
	public int compareTo(Persona p) {

		Collator c = Collator.getInstance(new Locale("es-ES"));
		c.setStrength(Collator.PRIMARY);

		return c.compare(this.getNombre(), p.getNombre());
	}

	public String longitudCadena(String nombre) throws PersonaException {

		if (nombre == null || nombre.length() <= MIN_STRING) {
			// lanzar persona exception
			throw new PersonaException(PersonaException.MSG_NOMBRE_NO_VALIDO,
					PersonaException.COD_NOMBRE_NO_VALIDO);

		} else {
			this.nombre = nombre;
		}
		return nombre;

	}

	/**
	 * comparador para edades
	 *
	 * @author Aritz Tellaeche
	 *
	 */
	public static class ComparatorEdad implements Comparator<Persona> {

		@Override
		public int compare(Persona p1, Persona p2) {

			return Integer.compare(p1.getEdad(), p2.getEdad());
		}
	}

}
