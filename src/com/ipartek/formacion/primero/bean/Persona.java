package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

/**
 * Clase para reprensentar un Persona, se compone de:
 * <ol>
 * 	<li>nombre {@code String} por defecto 'sin determinar'</li>
 *  <li>apellido1 {@code String} por defecto 'sin determinar'</li>
 *  <li>apellido2 {@code String}</li>
 *  <li>edad {@code int} - por defecto 18</li>
 *  <li>dni {@code String} - por defecto 'xxxxxxxxx'</li>
 *  <li>poblacion {@code String}</li>
 *  <li>mayorEdad {@code boolean} - por defecto True</li>
 *  <li>telefono {@code String}</li>
 *  <li>sexo {@code char} - por defecto (v)aron</li>
 *  <li>libros {@code ArrayList<Libro>}</li>
 * </ol>
 * @author Ander Uraga Real
 *
 */
public class Persona {
	/**
	 * Caracter 'v' para indicar varon
	 * Caracter 'm' para indicar mujer
	 * Caracter 'o' para indicar otros
	 */
	public static final char SEXO_VARON = 'v';
	public static final char SEXO_MUJER = 'm';
	public static final char SEXO_OTROS = 'o';
	

	/**
	 * Edad por defecto de una persona
	 */
	public static final int EDAD_POR_DEFECTO = 18;
	/**
	 * Edad en la cual se considera mayor de edad
	 */
	public static final int MAYOR_EDAD = 18;
	
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
	
	
	// Metodos privados
	private void valoresPorDefecto(){
		setEdad(EDAD_POR_DEFECTO);
		this.mayorEdad = (this.edad>=MAYOR_EDAD)? true: false;
		setSexo(SEXO_VARON);
		setNombre(NOMBRE_NULO);
		setApellido1(APELLIDO_NULO);
		setDni(DNI_NULO);		
	}
	
	// Constructor
	public Persona() {
		super();
		valoresPorDefecto();
	}
	
	public Persona(String nombre, String apellido1, String dni) {
		super();
		valoresPorDefecto();
		setNombre(nombre);
		setApellido1(apellido1);
		setDni(dni);
	}

	
	public Persona(String nombre, String apellido1, int edad, String dni) {
		super();
		valoresPorDefecto();
		setNombre(nombre);
		setApellido1(apellido1);
		setDni(dni);
		setEdad(edad);
		this.mayorEdad = (this.edad>=MAYOR_EDAD)? true: false;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre.isEmpty()){
			this.nombre = NOMBRE_NULO;
		}else{
			this.nombre = nombre;
		}
		
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		if (apellido1.isEmpty()){
			this.apellido1 = APELLIDO_NULO;
		}else{
			this.apellido1 = apellido1;
		}
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
		if(dni.isEmpty()){
			this.dni = DNI_NULO;
		}else{
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
	
	

}
