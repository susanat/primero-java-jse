package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

/**
 * Clase Alumno que hereda de la clase Persona. Tiene como unico atributo
 * distintivo un ArrayList de calificaciones
 * 
 * @author Joseba Carrión Blanco
 *
 */

public class Alumno extends Persona {

	private ArrayList<Calificacion> calificaciones;

	// Constructores
	public Alumno() {
		super();
	}

	public Alumno(String nombre, String apellido1, String apellido2) {
		super(nombre, apellido1, apellido2);
	}

	public Alumno(ArrayList<Calificacion> calificaciones) {
		super();
		this.calificaciones = calificaciones;
	}

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

}
