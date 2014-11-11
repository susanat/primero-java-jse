package com.ipartek.formacion.primero.bean;

public class Formador extends Persona {

	public static final float MIN_SUELDO = 0f;
	
	private float sueldo = MIN_SUELDO;

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	public Formador(){
		super();
	}

}
