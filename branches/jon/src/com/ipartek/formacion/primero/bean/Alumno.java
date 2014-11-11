package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

public class Alumno extends Persona {
	ArrayList<Calificacion> calificaciones;

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
}
