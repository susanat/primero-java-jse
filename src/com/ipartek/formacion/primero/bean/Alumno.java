package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

public class Alumno extends Persona {

	// Properties
	private ArrayList<Calificacion> calificaciones;

	// Constructores
	public Alumno() {
		super();
		calificaciones = new ArrayList<Calificacion>();
	}

	public Alumno(String nombre, String apellido1, int edad, String dni) {
		super(nombre, apellido1, edad, dni);
	}

	// Getters & Setters
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	// Methods
	/*
	 * @Override public String toString() { return "Alumno " + this.getNombre()
	 * + " " + this.getApellido1() + ", calificaciones = " +
	 * this.getCalificaciones() + "."; }
	 */

}
