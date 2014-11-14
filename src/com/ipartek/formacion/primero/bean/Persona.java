package com.ipartek.formacion.primero.bean;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;

import com.ipartek.formacion.primero.excepciones.PersonaException;
import com.ipartek.formacion.primero.util.Utilidades;

public class Persona implements Comparable<Persona> {

	static final char SEXO_VARON = 'v';
	static final char SEXO_MUJER = 'm';
	static final char SEXO_OTROS = 'o';

	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;

	public static final int LONG_MIN = 2;

	static final String SIN_DETERMINAR = "Sin Determinar";

	// Atributos

	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String dni;
	private String poblacion;
	private boolean mayoredad = false;
	private String telefono;
	private char sexo = 'o';
	private Libro libro;
	private ArrayList<Libro> Libros;

	// Constructores

	// Constructor vacio

	public Persona() {
		super();
	}

	// Constructor con varios parametros (en este caso 3) e inicializamos el
	// sexo en "otros"

	public Persona(String nombre, String apellido1, String apellido2)
			throws PersonaException {
		super();
		// Llamamos a los setters para poder tener un control sobre lo que se
		// introduce
		setNombre(nombre);
		setApellido1(apellido1);
		setApellido2(apellido2);
		setSexo(Persona.SEXO_OTROS);

	}

	public Persona(String nombre, int edad) throws PersonaException {
		super();
		setNombre(nombre);
		setEdad(edad);
	}

	// Getters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {
		if (nombre == null || nombre.length() < LONG_MIN) {
			throw new PersonaException(PersonaException.MSG_ARGUMENTO_INVALIDO,
					PersonaException.COD_ARG_INVALIDO);
		}
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) throws PersonaException {
		if (apellido1 == null || apellido1.length() < LONG_MIN) {
			throw new PersonaException(PersonaException.MSG_ARGUMENTO_INVALIDO,
					PersonaException.COD_ARG_INVALIDO);
		}
		this.apellido1 = apellido1;

	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws PersonaException {
		if (apellido2 == null || apellido2.length() < LONG_MIN) {
			throw new PersonaException(PersonaException.MSG_ARGUMENTO_INVALIDO,
					PersonaException.COD_ARG_INVALIDO);
		}
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public ArrayList<Libro> getLibros() {
		return Libros;
	}

	// Setters

	public void setEdad(int edad) throws PersonaException {
		if (edad < MIN_EDAD || edad > MAX_EDAD) {
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
					PersonaException.COD_EDAD_NO_VALIDA);

		}
		this.edad = edad;
		this.mayoredad = (this.edad >= MIN_EDAD) ? true : false;

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (Utilidades.comprobarDni(dni)) {
			// El dni es correcto
			this.dni = dni;
		} else {
			// El dni es incorrecto
			this.dni = SIN_DETERMINAR;
		}

	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		if ("".equals(poblacion) || poblacion == null) {
			this.poblacion = SIN_DETERMINAR;
		} else {
			this.poblacion = poblacion;
		}

	}

	public boolean isMayoredad() {
		return mayoredad;
	}

	public void setMayoredad(boolean mayoredad) {
		this.mayoredad = mayoredad;
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
		if (sexo != SEXO_VARON && sexo != SEXO_MUJER && sexo != SEXO_OTROS) {
			this.sexo = SEXO_OTROS;
		}
		this.sexo = sexo;
	}

	// Metodos

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + ", dni="
				+ dni + ", poblacion=" + poblacion + ", mayoredad=" + mayoredad
				+ ", telefono=" + telefono + ", sexo=" + sexo + "]";
	}

	@Override
	public int compareTo(Persona o) {
		Collator collator = Collator.getInstance();// Cogemos el locale del
		// sistema

		return (collator.compare(this.getNombre(), o.getNombre()));
	}

	/**
	 * Clase que implementa la interfaz comparator para comparar los objetos de
	 * tipo persona por edad
	 *
	 * @author Joseba Carrión Blanco
	 *
	 */
	public static class comparatorEdad implements Comparator<Persona> {

		@Override
		public int compare(Persona o1, Persona o2) {
			return (Integer.compare(o1.getEdad(), o2.getEdad()));

		}

	}// final de la clase comparatorEdad

}// Final de clase persona
