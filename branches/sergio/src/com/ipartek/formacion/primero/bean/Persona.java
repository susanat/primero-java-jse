package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

/**
 * Clase para reprensentar un Alumno, se compone de:
 * <ol>
 * 	<li>nombre {@code String} obligatorio</li>
 * </ol>
 * 
 * 
 * @author Ander Uraga Real
 *
 */
public class Persona {
	
	public static final char SEXO_VARON = 'v';
	public static final char SEXO_MUJER = 'm';
	public static final char SEXO_OTROS = 'o';
	
	public static final int MAYOR_EDAD = 18;
	
	public static final String NOMBRE_NULO = "undefined";
	
	
	// Atributos
	private String nombre = NOMBRE_NULO;
	private String apellido1 = NOMBRE_NULO;
	private String apellido2 = NOMBRE_NULO;
	private int edad = 0;
	private String dni = NOMBRE_NULO;
	private String poblacion = NOMBRE_NULO;
	private boolean mayorEdad = false;
	private String telefono = NOMBRE_NULO;
	private char sexo = SEXO_OTROS;	
	private ArrayList<Libro> libros = null;
	
	
	// Constructor
	public Persona() {
		super();
		
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
		this.mayorEdad = (this.edad>=MAYOR_EDAD)? true: false;
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
	
	

}
