package com.ipartek.formacion.migracion.bean;

import com.ipartek.formacion.migracion.excepciones.PersonaException;

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
public class Persona {// implements Comparable<Persona> {

	static final char SEXO_VARON = 'v';
	static final char SEXO_MUJER = 'm';
	static final char SEXO_OTROS = 'o';

	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;

	public static final int MIN_LONG_STRING = 2;

	static final String NOMBRE_NULO = "sin determinar";

	// Atributos
	private String nombre;
	private String apellido;
	private String poblacion;
	private int edad;
	private String email;
	private String dni;
	private String categoria;
	private boolean mayorEdad;

	// Constructor
	public Persona() {
		super();
		this.nombre = "Jhon";
		this.apellido = "Doe";
		this.dni = "xxxxxxxxx";
	}

	/*
	 * public Persona(final String nombre, final String apellido1, final String
	 * dni) throws PersonaException { super(); this.nombre = nombre;
	 * this.apellido = apellido1; this.dni = dni; }
	 *
	 * public Persona(final String _nombre, final String _apellido1, final int
	 * _edad, final String _dni) throws PersonaException { super(); this.nombre
	 * = _nombre; this.apellido = _apellido1; setEdad(_edad); this.dni = _dni;
	 * this.mayorEdad = (this.edad >= 18) ? true : false; }
	 *
	 * public Persona(final String nombre, final int edad) throws
	 * PersonaException { super(); setNombre(nombre); setEdad(edad);
	 * setApellido1("Doe"); setDni("xxxxxxxx"); }
	 */

	public Persona(String nombre, String apellido, String poblacion, int edad,
			String email, String dni, String categoria) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.poblacion = poblacion;
		this.edad = edad;
		this.email = email;
		this.dni = dni;
		this.categoria = categoria;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String _nombre) {// throws PersonaException {

		if (_nombre == null || _nombre.length() < MIN_LONG_STRING) {

			/*
			 * throw new PersonaException(
			 * PersonaException.MSG_LONG_STRING_NO_VALIDO,
			 * PersonaException.CODE_LONG_STRING_NO_VALIDO);
			 */
		} else {
			this.nombre = _nombre;
		}

	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(final String apellido1) throws PersonaException {

		if (apellido1 == null || apellido1.length() < MIN_LONG_STRING) {

			throw new PersonaException(
					PersonaException.MSG_LONG_STRING_NO_VALIDO,
					PersonaException.CODE_LONG_STRING_NO_VALIDO);
		} else {
			this.apellido = apellido1;
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(final int edad) throws PersonaException {
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

	public void setDni(final String dni) {
		this.dni = dni;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(final String _poblacion) {
		this.poblacion = _poblacion;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(final String _cat) {
		this.categoria = _cat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Metodos
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido
				+ ", poblacion=" + poblacion + ", edad=" + edad + ", email="
				+ email + ", dni=" + dni + ", categoria=" + categoria + "]";
	}

	/*
	 * @Override public int compareTo(final Persona o) { Collator collator =
	 * Collator.getInstance(new Locale("es_ES"));
	 * collator.setStrength(Collator.PRIMARY); //
	 * collator.setDecomposition(Collator.CANONICAL_DECOMPOSITION);
	 * 
	 * // RuleBasedCollator esCollator = new RuleBasedCollator(SPANISH);
	 * 
	 * // return (this.getNombre().compareTo(o.getNombre()));
	 * 
	 * return collator.compare(this.getNombre(), o.getNombre()); }
	 * 
	 * public static class ComparatorEdad implements Comparator<Persona> {
	 * 
	 * @Override public int compare(final Persona o1, final Persona o2) {
	 * 
	 * return Integer.compare(o1.getEdad(), o2.getEdad()); }
	 * 
	 * }
	 */

}
