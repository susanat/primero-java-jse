package com.ipartek.formacion.primero.bean;

public class Formador extends Persona {
	float sueldo;

	public static final float SUELDO_MIN = 646.56f;
	
	public Formador() {
		super();
		setSueldo(SUELDO_MIN);
	}

	public float getSueldo() {
		return sueldo;
	}
/**
 * Sueldo mensual en euros y bruto.
 * @param sueldo
 */
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
}
