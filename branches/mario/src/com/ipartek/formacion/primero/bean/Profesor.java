package com.ipartek.formacion.primero.bean;

public class Profesor extends Persona {

	private float sueldo;

	public static final float MIN_SUELDO = 1.0f;
	public Profesor() {
		super();
		sueldo = MIN_SUELDO;
	}

	public Profesor(float sueldo) {
		super();
		setSueldo(sueldo);
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		if (sueldo < 0) {
			sueldo = MIN_SUELDO;
		}else{
			this.sueldo = sueldo;
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
