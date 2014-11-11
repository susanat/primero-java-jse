package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

public class Alumno extends Persona {
	
	private ArrayList<Calificacion> calificaciones;
	
	//contructor
	public Alumno() {
		super();
		calificaciones = new ArrayList<Calificacion>();
	}
	
	//getters y setters
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public Alumno( String nombre, String apellido1, String dni, int edad, ArrayList<Calificacion> calificaciones) {
		super(nombre, apellido1, edad, dni);
		setCalificaciones(calificaciones);
		
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		if (calificaciones == null) {
			calificaciones = new ArrayList<Calificacion>();
		}else{
			this.calificaciones = calificaciones;
		}
	}

	@Override
	public String toString() {
		return "Alumno [calificaciones=" + calificaciones + ", nombre="
				+ nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", edad=" + edad + ", dni=" + dni
				+ ", poblacion=" + poblacion + ", mayorEdad=" + mayorEdad
				+ ", telefono=" + telefono + ", sexo=" + sexo + ", libros="
				+ libros + "]";
	}
	
	
}
