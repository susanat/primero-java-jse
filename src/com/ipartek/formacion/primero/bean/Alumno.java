package com.ipartek.formacion.primero.bean;


import java.util.ArrayList;

public class Alumno extends Persona {

	//atributos
	private ArrayList<Calificacion> calificaciones;

	//constructor
	public Alumno() {
		super();
		calificaciones = new ArrayList<Calificacion>();
	}

	//getter y settes
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	
	
	
	
	
}
