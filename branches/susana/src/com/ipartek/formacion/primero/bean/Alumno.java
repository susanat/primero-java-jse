package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

public class Alumno extends Persona {
	
	//Atributos
	private ArrayList<Calificacion> calificacion;

	//constructores
	public Alumno() {
		super();
		//En ve de calificacion = null para que no falle
		calificacion = new ArrayList<Calificacion>();
	}

	//Getter y Setters
	public ArrayList<Calificacion> getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(ArrayList<Calificacion> calificacion) {
		this.calificacion = calificacion;
	}

	
}
