package com.ipartek.formacion.primero.bean;

public class Alumno extends Persona {

	public static final int MIN_CALIFICACIONES = 0;

	// Properties
	private float calificaciones;

	// Constructores
	public Alumno() {
		super();
		setCalificaciones(MIN_CALIFICACIONES);
	}

	public Alumno(String nombre, String apellido1, int edad, String dni) {
		super(nombre, apellido1, edad, dni);
	}

	// Getters & Setters
	public float getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(float calificaciones) {
		this.calificaciones = calificaciones;
	}

	// Methods
	@Override
	public String toString() {
		return "Alumno " + this.getNombre() + " " + this.getApellido1()
				+ ", calificaciones = " + this.getCalificaciones() + ".";
	}

}
