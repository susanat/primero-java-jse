package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

/**
 * Hereda de la clase Persona
 * Se compone de los siguientes campos
 * <ol>
 *   <li>calificaciones {@code ArrayList<Calificacion>}}
 * </ol> 
 * @author Jose A. Perez
 *
 */
public class Alumno extends Persona {
	// Atributos
	private ArrayList<Calificacion> calificaciones;
	
	// Constructores
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

	
	//Metodos
	@Override
	public String toString() {
		return "Alumno [calificaciones=" + calificaciones + ", nombre="
				+ nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", edad=" + edad + ", dni=" + dni
				+ ", poblacion=" + poblacion + ", mayorEdad=" + mayorEdad
				+ ", telefono=" + telefono + ", sexo=" + sexo+"]";
	}

	
}
