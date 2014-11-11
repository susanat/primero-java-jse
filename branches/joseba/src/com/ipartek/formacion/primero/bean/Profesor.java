package com.ipartek.formacion.primero.bean;

public class Profesor extends Persona {
	
	public static final float MIN_SUELDO = 0f;
	
	private float sueldo;

	public Profesor(){
		super();
		this.setSueldo(MIN_SUELDO);
		
	}
	public Profesor(float sueldo) {
		super();
		this.setSueldo(sueldo);
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	

}
