package com.ipartek.formacion.primero.bean;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

import com.impartek.formacion.primero.excepciones.PersonaException;

/**
 * Clase para reprensentar un Alumno, se compone de:
 * <ol>
 * <li>nombre {@code String} obligatorio</li>
 * </ol>
 *
 *
 * @author Mario Alvaro
 *
 */
public class Persona implements Comparable<Persona> {

	static final char SEXO_VARON = 'v';
	static final char SEXO_MUJER = 'm';
	static final char SEXO_OTROS = 'o';

	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;
	public static final int MIN_LENGTH = 2;

	static final String NOMBRE_DEFECTO = "Jhon";
	static final String APELLIDO_DEFECTO = "Doe";
	static final String DNI_DEFECTO = "xxxxxxxxx";

	// Atributos
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected int edad;
	protected String dni;
	protected String poblacion;
	protected boolean mayorEdad = false;
	protected String telefono;
	protected char sexo = 'o';
	protected ArrayList<Libro> libros;

	// Constructor
	public Persona() {
		super();
		this.nombre = NOMBRE_DEFECTO;
		this.apellido1 = APELLIDO_DEFECTO;
		this.dni = DNI_DEFECTO;

	}

	public Persona(String nombre, int edad) throws PersonaException {
		super();
		setNombre(nombre);
		setEdad(edad);
	}

	public Persona(String nombre, String apellido1, String dni)
			throws PersonaException {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setDni(dni);
	}

	public Persona(String nombre, String apellido1, int edad, String dni)
			throws PersonaException {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setDni(dni);
		setEdad(edad);
		this.mayorEdad = (this.edad >= 18) ? true : false;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {
		if (nombre.length() >= MIN_LENGTH) {
			this.nombre = nombre;
		} else {
			throw new PersonaException(PersonaException.MSG_NOMBRE_NO_VALIDO,
					PersonaException.COD_NOMBRE_NO_VALIDO);
		}

	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) throws PersonaException {
		if (apellido1.length() >= MIN_LENGTH) {
			this.apellido1 = apellido1;
		} else {
			throw new PersonaException(PersonaException.MSG_NOMBRE_NO_VALIDO,
					PersonaException.COD_NOMBRE_NO_VALIDO);
		}
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws PersonaException {
		if (apellido2.length() >= MIN_LENGTH) {
			this.apellido2 = apellido2;
		} else {
			throw new PersonaException(PersonaException.MSG_NOMBRE_NO_VALIDO,
					PersonaException.COD_NOMBRE_NO_VALIDO);
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

	/**
	 * Compara la edad de esta instancia y la de otra persona
	 */
	@Override
	public int compareTo(Persona o) {

		return Integer.compare(this.edad, o.getEdad());
	}

	public static class ComparatorNombres implements Comparator<Persona> {
		/**
		 * Compara el nombre entre 2 objetos tipo <code>Persona</code> sin tener
		 * en cuenta mayúsculas y minúsculas ni acentos y símbolos
		 */
		@Override
		public int compare(Persona o1, Persona o2) {
			Locale esp = new Locale("es_ES");
			Collator espCollator = Collator.getInstance(esp);
			return espCollator.compare(o1.getNombre().toLowerCase(), o2
					.getNombre().toLowerCase());
		}

	}

}
