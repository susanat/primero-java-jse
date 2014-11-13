package com.ipartek.formacion.primero.bean;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Persona implements Comparable<Persona> {

	// Atributos
	String nombre;
	String apellido1;
	String apellido2;
	int edad;
	String dni;
	String poblacion;
	boolean mayorEdad;
	String telefono;
	char sexo;

	// Constructores
	public Persona() {
		super();
	}

	public Persona(String nombre, String apellido1, int edad, String dni) {
		super();
		setNombre(nombre);
		setApellido1(apellido1);
		setEdad(edad);
		setDni(dni);
	}

	public Persona(String nombre, int edad) {
		super();
		setNombre(nombre);
		setEdad(edad);
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

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public void setMayorEdad(boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
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

	// Métodos
	@Override
	public String toString() {
		String strMayorEdad = (mayorEdad = true) ? "Sí" : "No";
		return nombre + " " + apellido1 + " " + apellido2 + ", edad = " + edad
				+ ", DNI = " + dni + ", población = " + poblacion
				+ ", mayor de edad = " + strMayorEdad + ", teléfono = "
				+ telefono + ", sexo = " + sexo + ".";
	}

	@Override
	public int compareTo(Persona o) {
		Collator esCollator = Collator.getInstance(Locale.getDefault());
		esCollator.setStrength(Collator.PRIMARY);
		return esCollator.compare(this.getNombre(), o.getNombre());
	}

	/**
	 * Comparator para edad
	 *
	 * @author Curso
	 *
	 */
	public static class ComparatorEdad implements Comparator<Persona> {

		@Override
		public int compare(Persona o1, Persona o2) {
			return Integer.compare(o1.getEdad(), o2.getEdad());
		}

	}
}
