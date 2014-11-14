package com.ipartek.formacion.primero.bean;

import com.impartek.formacion.primero.excepciones.PersonaException;

public class Formador extends Persona {

	private float sueldo;

	public static final float MIN_SUELDO = 646.53f; // bruto por mes en euros

	public Formador() {
		super();
		sueldo = MIN_SUELDO;
	}

	public Formador(String nombre, String apellido1, String dni, int edad,
			float sueldo) throws PersonaException {
		super(nombre, apellido1, edad, dni);
		setSueldo(sueldo);
	}

	public float getSueldo() {
		return sueldo;
	}

	/**
	 * Sueldo mensual en euros y en bruto. Siempre será minimo
	 * <code>MIN_SUELDO</code>
	 * 
	 * @param sueldo
	 *            en euros
	 */
	public void setSueldo(float sueldo) {
		if (sueldo > MIN_SUELDO) {
			this.sueldo = sueldo;
		} else {
			this.sueldo = MIN_SUELDO;
		}

	}

	@Override
	public String toString() {
		return "Profesor [sueldo=" + sueldo + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", edad=" + edad + ", dni=" + dni + ", poblacion="
				+ poblacion + ", mayorEdad=" + mayorEdad + ", telefono="
				+ telefono + ", sexo=" + sexo + ", libros=" + libros + "]";
	}

}
