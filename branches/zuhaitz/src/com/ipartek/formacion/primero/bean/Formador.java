package com.ipartek.formacion.primero.bean;

import com.ipartek.formacion.primero.excepciones.PersonaException;

public class Formador extends Persona {

	public static final float MIN_SUELDO = 646.56f;

	// Properties
	private float sueldo;

	// Constructores
	public Formador() {
		super();
		setSueldo(MIN_SUELDO);
	}

	public Formador(String nombre, String apellido1, int edad, String dni)
			throws PersonaException {
		super(nombre, apellido1, edad, dni);
	}

	// Getters & Setters
	public float getSueldo() {
		return sueldo;
	}

	/**
	 * Sueldo mensual en euros y bruto. Siempre ser� el m�nimo
	 * <code>MIN_SUELDO</code>
	 *
	 * @param sueldo
	 *            en euros
	 */
	public void setSueldo(float sueldo) {
		this.sueldo = MIN_SUELDO;
		if (sueldo > MIN_SUELDO) {
			this.sueldo = sueldo;
		}
	}

	// Methods
	@Override
	public String toString() {
		return "Formador " + this.getNombre() + " " + this.getApellido1()
				+ ", sueldo = " + this.getSueldo() + ".";
	}
}
