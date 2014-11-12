package com.ipartek.formacion.primero.bean;

public class Formador extends Persona {
	
	private float sueldo;
	
	public static final float MIN_SUELDO = 1000f;
	
	public Formador() {
		super();
		setSueldo(MIN_SUELDO);
	}

	public Formador(String nombre, String apellido1, int edad, String dni) {
		super(nombre, apellido1, edad, dni);
		setSueldo(MIN_SUELDO);
	}

	public Formador(String nombre, String apellido1, String dni) {
		super(nombre, apellido1, dni);
		setSueldo(MIN_SUELDO);
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Formador [sueldo=" + sueldo + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", dni=" + dni + "]";
	}
}
