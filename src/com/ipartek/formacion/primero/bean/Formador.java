package com.ipartek.formacion.primero.bean;

public class Formador extends Persona {
	
	//Atributos
	public static final float SUELDO_MIN = 646.56f;//sueldo minimo
	private float sueldo;

	//constructor
	public Formador() {
		//llamamos con esto al del padre
		super();
		setSueldo (SUELDO_MIN);
	}

	//Getter y Setter
	public float getSueldo() {
		return sueldo;
	}

	/**
	 * Sueldo mensual en euros y bruto
	 * Siempre sera el minimo <code>SUELDO_MIN</code>
	 * @param sueldo en euros
	 */
	public void setSueldo(float sueldo) {
		if ( sueldo > SUELDO_MIN){
			this.sueldo = sueldo;
		}
	}
	
	

}
