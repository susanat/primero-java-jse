package com.ipartek.formacion.primero.bean;

public class Formador extends Persona {

	public static final float SUELDO_MIN = 646.56f; // bruto por mes en euros
	
	private float sueldo;

	public Formador() {
		super();
		setSueldo(SUELDO_MIN);
	}

	public float getSueldo() {
		return sueldo;
	}

	/**
	 * Sueldo mensual en euros y bruto.
	 * Siempre será el minimo <code>SUELDO_MIN</code>
	 * @param sueldo en euros
	 */
	public void setSueldo(float sueldo) {
		
		if ( sueldo > SUELDO_MIN ){
			this.sueldo = sueldo;
		}	
	}
	
	
	
	
}
