package com.ipartek.formacion.primero.bean;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

import com.ipartek.formacion.primero.excepciones.PersonaException;

/**
 * Clase para reprensentar un Persona, se compone de:
 * <ol>
 * <li>nombre {@code String} por defecto 'sin determinar'</li>
 * <li>apellido1 {@code String} por defecto 'sin determinar'</li>
 * <li>apellido2 {@code String}</li>
 * <li>edad {@code int} - por defecto 18</li>
 * <li>dni {@code String} - por defecto 'xxxxxxxxx'</li>
 * <li>poblacion {@code String}</li>
 * <li>mayorEdad {@code boolean} - por defecto True</li>
 * <li>telefono {@code String}</li>
 * <li>sexo {@code char} - por defecto (v)aron</li>
 * <li>libros {@code ArrayList<Libro>}</li>
 * </ol>
 *
 * @author Ander Uraga Real
 *
 */
public class Persona implements Comparable<Persona> {
	/**
	 * Caracter 'v' para indicar varon Caracter 'm' para indicar mujer Caracter
	 * 'o' para indicar otros
	 */
	public static final char SEXO_VARON = 'v';
	public static final char SEXO_MUJER = 'm';
	public static final char SEXO_OTROS = 'o';

	/**
	 * Edad por defecto de una persona Edad en la cual se considera mayor de
	 * edad
	 */
	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;

	/**
	 * Caracteristicas especiales a cumplir por los datos
	 */
	public static final int TAM_MIN_NOMBRE_APELLIDOS = 2;

	/**
	 * Valores Nulos
	 */
	public static final String NOMBRE_NULO = "sin determinar";
	public static final String APELLIDO_NULO = "sin determinar";
	public static final String DNI_NULO = "xxxxxxxxx";

	// Atributos
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected int edad;
	protected String dni;
	protected String poblacion;
	protected boolean mayorEdad;
	protected String telefono;
	protected char sexo;
	protected ArrayList<Libro> libros;

	// Constructor
	public Persona() throws PersonaException {
		super();
		setEdad(MIN_EDAD);
		this.mayorEdad = (this.edad >= MIN_EDAD) ? true : false;
		setSexo(SEXO_VARON);
		setNombre(NOMBRE_NULO);
		setApellido1(APELLIDO_NULO);
		setApellido2(APELLIDO_NULO);
		setDni(DNI_NULO);
	}

	public Persona(String nombre, int edad) throws PersonaException {
		this();
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
		this.mayorEdad = (this.edad >= MIN_EDAD) ? true : false;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {
		if (nombre.isEmpty()) {
			this.nombre = NOMBRE_NULO;
		} else {
			if (nombre.length() >= TAM_MIN_NOMBRE_APELLIDOS) {
				this.nombre = nombre;
			} else {
				throw new PersonaException(
						PersonaException.MSG_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO,
						PersonaException.COD_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO);
			}
		}

	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) throws PersonaException {
		if (apellido1.isEmpty()) {
			this.apellido1 = APELLIDO_NULO;
		} else {
			if (apellido1.length() >= TAM_MIN_NOMBRE_APELLIDOS) {
				this.apellido1 = apellido1;
			} else {
				throw new PersonaException(
						PersonaException.MSG_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO,
						PersonaException.COD_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO);
			}

		}
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) throws PersonaException {
		if (apellido2.length() >= TAM_MIN_NOMBRE_APELLIDOS) {
			this.apellido2 = apellido2;
		} else {
			throw new PersonaException(
					PersonaException.MSG_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO,
					PersonaException.COD_NOMBRE_APELLIDOS_TAMANIO_NO_VALIDO);
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
			// lanzar PersonalException
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
					PersonaException.COD_EDAD_NO_VALIDA);
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni.isEmpty()) {
			this.dni = DNI_NULO;
		} else {
			this.dni = dni;
		}
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
	 * Compara una persona por nombre y por edad Resultado: Si una persona no
	 * tiene el mismo nombre se considera la Persona menor a la que tenga el
	 * nombre menor EOC se considera la Persona menor la que tenga una menor
	 * edad
	 */
	@Override
	public int compareTo(Persona p) {
		ComparatorNombre cNombre = new ComparatorNombre();
		int nNombre = cNombre.compare(this, p);
		if (nNombre == 0) {
			ComparatorEdad cEdad = new ComparatorEdad();
			return cEdad.compare(this, p);
		} else {
			return nNombre;
		}
	}

	/**
	 * Compara a una persona por edad
	 *
	 * @author Jose A. Perez
	 *
	 */
	public static class ComparatorEdad implements Comparator<Persona> {

		@Override
		public int compare(Persona p0, Persona p1) {
			return Integer.compare(p0.getEdad(), p1.getEdad());
		}
	}

	/**
	 * Compara a una persona por nombre
	 *
	 * @author Jose A. Perez
	 *
	 */
	public static class ComparatorNombre implements Comparator<Persona> {

		@Override
		public int compare(Persona p0, Persona p1) {
			Locale locale = new Locale("es");
			Collator collator = Collator.getInstance(locale);

			String txtNombre0 = p0.getNombre().toLowerCase().replace('á', 'a')
					.replace('é', 'e').replace('í', 'i').replace('ó', 'o')
					.replace('ú', 'u').replace('ü', 'u');
			String txtNombre1 = p1.getNombre().toLowerCase().replace('á', 'a')
					.replace('é', 'e').replace('í', 'i').replace('ó', 'o')
					.replace('ú', 'u').replace('ü', 'u');

			int resul = collator.compare(txtNombre0, txtNombre1);
			return resul;
		}

	}
}
