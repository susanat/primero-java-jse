package com.ipartek.formacion.primero.bean;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import com.ipartek.formacion.primero.excepciones.PersonaException;

public class Persona implements Comparable<Persona> {

	// Constantes
	public static final int MIN_EDAD = 18;
	public static final int MAX_EDAD = 99;

	// Atributos
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String dni;
	private String poblacion;
	private boolean mayorEdad;
	private String telefono;
	private char sexo;

	// Constructores
	public Persona() {
		super();
	}

	public Persona(final String nombre, final int edad) throws PersonaException {
		super();
		setNombre(nombre);
		setEdad(edad);
	}

	public Persona(final String nombre, final String apellido1, final int edad,
			final String dni) throws PersonaException {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setEdad(edad);
		setDni(dni);
		this.mayorEdad = (this.edad >= 18) ? true : false;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) throws PersonaException {
		if (validarLenght(nombre)) {
			this.nombre = nombre;
		} else {
			throw new PersonaException(PersonaException.MSG_LENGTH_SHORT,
					PersonaException.COD_LENGTH_SHORT);
		}
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(final String apellido1) throws PersonaException {
		if (validarLenght(apellido1)) {
			this.apellido1 = apellido1;
		} else {
			throw new PersonaException(PersonaException.MSG_LENGTH_SHORT,
					PersonaException.COD_LENGTH_SHORT);
		}
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(final String apellido2) throws PersonaException {
		if (validarLenght(apellido2)) {
			this.apellido2 = apellido2;
		} else {
			throw new PersonaException(PersonaException.MSG_LENGTH_SHORT,
					PersonaException.COD_LENGTH_SHORT);
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(final int edad) throws PersonaException {
		if (edad >= MIN_EDAD & edad <= MAX_EDAD) {
			this.edad = edad;
			this.mayorEdad = (this.edad >= MIN_EDAD) ? true : false;
		} else {
			// Lanzar PersonaException
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
					PersonaException.COD_EDAD_NO_VALIDA);
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

	public void setPoblacion(final String poblacion) {
		this.poblacion = poblacion;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}

	public void setMayorEdad(final boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(final char sexo) {
		this.sexo = sexo;
	}

	// Métodos
	@Override
	public String toString() {
		final String strMayorEdad = (mayorEdad = true) ? "Sí" : "No";
		return nombre + " " + apellido1 + " " + apellido2 + ", edad = " + edad
				+ ", DNI = " + dni + ", población = " + poblacion
				+ ", mayor de edad = " + strMayorEdad + ", teléfono = "
				+ telefono + ", sexo = " + sexo + ".";
	}

	@Override
	public int compareTo(final Persona o) {
		final Collator esCollator = Collator.getInstance(Locale.getDefault());
		esCollator.setStrength(Collator.PRIMARY);
		return esCollator.compare(this.getNombre(), o.getNombre());
	}

	private boolean validarLenght(final String str) {
		if (str == null || str.length() <= PersonaException.MIN_LENGTH) {
			return false;
		}
		return true;
	}

	/**
	 * Comparator para edad
	 *
	 * @author Curso
	 *
	 */
	public static class ComparatorEdad implements Comparator<Persona> {

		@Override
		public final int compare(final Persona o1, final Persona o2) {
			return Integer.compare(o1.getEdad(), o2.getEdad());
		}

	}
}
