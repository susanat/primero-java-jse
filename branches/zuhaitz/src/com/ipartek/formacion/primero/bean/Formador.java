package com.ipartek.formacion.primero.bean;

public class Formador extends Persona {

	public static final int MIN_SUELDO = 0;

	// Properties
	private float sueldo;

	// Constructores
	public Formador() {
		super();
		setSueldo(MIN_SUELDO);
	}

	public Formador(String nombre, String apellido1, int edad, String dni) {
		super(nombre, apellido1, edad, dni);
	}

	// Getters & Setters
	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	// Methods
	@Override
	public String toString() {
		return "Formador " + this.getNombre() + " " + this.getApellido1()
				+ ", sueldo = " + this.getSueldo() + ".";
	}
}
