package com.ipartek.formacion.primero.bean;

public class Formador extends Persona {
	
	public static final float SUELDO_MIN = 646.56f;
	
	//atributos
	 private float sueldo;

	//constructor
	public Formador() {
		super();
		setSueldo(SUELDO_MIN);
	}

	
	//getters / setters
	public float getSueldo() {
		return sueldo;
	}

	/**
	 * sueldo mensual en euros y bruto
	 * siempre sera el minimo <code>SUELDO_MIN</code>
	 * @param sueldo
	 */
	public void setSueldo(float sueldo) {
		
		if (sueldo > SUELDO_MIN)
			this.sueldo = sueldo;
	}
	
}
