package com.ipartek.formacion.primero.bean;

public class Formador extends Persona {
	
	//atributos
	float sueldo;

	//constructor
	public Formador() {
		super();
		this.sueldo=1000.50f;
	}

	
	//getters / setters
	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	//metodos
	@Override
	public String toString() {
		return "Formador [sueldo=" + sueldo + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", dni=" + dni + ", telefono=" + telefono + "]";
	}
	
}
