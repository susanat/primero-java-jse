package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;
import java.util.Comparator;

import com.ipartek.formacion.primero.bean.herencia.Vehiculo;

/**
 * 
 * Clase para representar un alumno, se compone de:
 *<ol>
 *	<li>nombre {@code String} obligatorio</li>
 *</ol> 
 *
 * @author Susana Costoya
 */

public class Persona implements Comparable<Persona> {

	// Atributos
	
	static final char SEXO_VARON = 'v';
	static final char SEXO_MUJER = 'm';
	static final char SEXO_OTROS = 'o';
	
	static final int MAYOR_EDAD = 18;
	
	static final String NOMBRE_NULO = "sin determinar";

	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String dni;
	private String poblacion;
	private boolean mayorEdad = false;
	private String tfno;
	private char sexo = 'o';
	ArrayList<Libro2> libro;
	//ArrayList<Calificacion> calificacion; - Quitamos tambien los getter y setters

	// Constructores

	public Persona() {
		super();
		this.nombre = "Sin definir";
		this.apellido1 = "Sin definir";
		this.apellido2 = "Sin definir";
		this.edad = 0;
		this.dni = "Sin definir";
		this.poblacion = "Sin determinar";
		this.mayorEdad = false;
		this.tfno = "0000000";
		this.sexo = '/';
	}
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}




	public Persona(String nombre, String apellido1, String apellido2, int edad,
			String dni, String poblacion, String tfno, char sexo) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.dni = dni;
		this.poblacion = poblacion;
		this.tfno = tfno;
		this.sexo = sexo;
		if (edad < 18) {
			this.mayorEdad = false;
		} else {
			this.mayorEdad = true;
		}
	}
	
	//Getters y setters

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
		if (edad < 18) {
			this.mayorEdad = false;
		} else {
			this.mayorEdad = true;
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

	public void setMayorEdad(boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	
	//Metodos 
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + ", dni="
				+ dni + ", poblacion=" + poblacion + ", mayorEdad=" + mayorEdad
				+ ", tfno=" + tfno + ", sexo=" + sexo + "]";
	}
	
	/**
	 * Comparador para ordenar edad
	 */

	@Override
	public int compareTo(Persona p) {
		return Integer.compare(this.getEdad(), p.getEdad());
	}

	
	
}
