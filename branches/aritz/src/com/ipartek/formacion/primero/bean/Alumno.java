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
public class Alumno extends Persona{
	
	
	// Atributos
	
	ArrayList<Calificacion> calificaciones;
	
	// Constructor
	public Alumno() {
		super();
		this.nombre = "Jhon";
		this.apellido1 = "Doe";
		this.dni = "xxxxxxxxx";
	}
	
	public Alumno(String nombre, String apellido1, String dni) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.dni = dni;
	}

	
	public Alumno(String nombre, String apellido1, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.edad = edad;
		this.dni = dni;
		this.mayorEdad = (this.edad>=18)? true: false; 
	}

	// Getters y Setters
	
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
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
