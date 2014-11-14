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
 * @author Maitane Casado
 *
 */
public class Persona implements Comparable<Persona> {

	static final char SEXO_VARON = 'v';
	static final char SEXO_MUJER = 'm';
	static final char SEXO_OTROS = 'o';

	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;

	public static final int MIN_LONG_STRING = 2;

	static final String NOMBRE_NULO = "sin determinar";

	/*
	 * static final String SMALLnTILDE = new String("\u00F1"); // ñ static final
	 * String CAPITALnTILDE = new String("\u00D1"); // Ñ
	 *
	 * static final String SPANISH = ("< a,A,á,Á < b,B < c,C " +
	 * "< ch, cH, Ch, CH " + "< d,D < e,E,é,É < f,F " +
	 * "< g,G < h,H < i,I.í,Í < j,J < k,K < l,L " + "< ll, lL, Ll, LL " +
	 * "< m,M < n,N " + "< " + SMALLnTILDE + "," + CAPITALnTILDE + " " +
	 * "< o,O,ó,Ó < p,P < q,Q < r,R " +
	 * "< s,S < t,T < u,U,ú,Ú,ü,Ü < v,V < w,W < x,X " + "< y,Y < z,Z");
	 */

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

	public Persona(String nombre, String apellido1, String dni)
			throws PersonaException {
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

	public Persona(String nombre, int edad) throws PersonaException {
		super();
		setNombre(nombre);
		setEdad(edad);
		setApellido1("Doe");
		setDni("xxxxxxxx");
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {

		if (nombre == null || nombre.length() < MIN_LONG_STRING) {

			throw new PersonaException(
					PersonaException.MSG_LONG_STRING_NO_VALIDO,
					PersonaException.CODE_LONG_STRING_NO_VALIDO);
		} else {
			this.nombre = nombre;
		}

	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) throws PersonaException {

		if (apellido1 == null || apellido1.length() < MIN_LONG_STRING) {

			throw new PersonaException(
					PersonaException.MSG_LONG_STRING_NO_VALIDO,
					PersonaException.CODE_LONG_STRING_NO_VALIDO);
		} else {
			this.apellido1 = apellido1;
		}
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws PersonaException {
		if (apellido2 == null || apellido2.length() < MIN_LONG_STRING) {

			throw new PersonaException(
					PersonaException.MSG_LONG_STRING_NO_VALIDO,
					PersonaException.CODE_LONG_STRING_NO_VALIDO);
		} else {
			this.apellido2 = apellido2;
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

			// lanzar PersonaException
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDO,
					PersonaException.CODE_EDAD_NO_VALIDO);
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
	public int compareTo(Persona o) {
		Collator collator = Collator.getInstance(new Locale("es_ES"));
		collator.setStrength(Collator.PRIMARY);
		// collator.setDecomposition(Collator.CANONICAL_DECOMPOSITION);

		// RuleBasedCollator esCollator = new RuleBasedCollator(SPANISH);

		// return (this.getNombre().compareTo(o.getNombre()));

		return collator.compare(this.getNombre(), o.getNombre());
	}

	public static class ComparatorEdad implements Comparator<Persona> {

		@Override
		public int compare(Persona o1, Persona o2) {

			return Integer.compare(o1.getEdad(), o2.getEdad());
		}

	}

}
