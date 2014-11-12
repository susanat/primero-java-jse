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
public class Alumno extends Persona {
	
	private ArrayList<Calificacion> calificaciones;
	
	// Constructor
	public Alumno() {
		super();
		calificaciones = new ArrayList<Calificacion>();
	}
	
	public Alumno(String nombre, String apellido1, String dni) {
		super(nombre, apellido1, dni);
		calificaciones = new ArrayList<Calificacion>();
	}

	
	public Alumno(String nombre, String apellido1, int edad, String dni) {
		super(nombre, apellido1, edad, dni);
		calificaciones = new ArrayList<Calificacion>();
	}

	// Getters y Setters

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

}
