package com.ipartek.formacion.primero.bean;

/**
 * Hereda de la clase Persona
 * Se compone de los siguientes atributos
 * <ol>
 * 	<li>sueldo {@code float}</li> 	
 * </ol>
 * @author Jose A. Perez
 *
 */
public class Formador extends Persona {
	// Atributos
	private float sueldo;
	
	// Constantes
	/**
	 * Sueldo mensual minimo que recibe el formador
	 */
	public static final float SUELDO_MINIMO = 646.56f;


	// Constructores
	public Formador(String nombre, String apellido1, int edad, String dni) {
		super(nombre, apellido1, edad, dni);
		setSueldo(SUELDO_MINIMO);

		
		
	}

	public Formador(String nombre, String apellido1, String dni) {
		super(nombre, apellido1, dni);
		setSueldo(SUELDO_MINIMO);
	} 
	
	public Formador(String nombre, String apellido1, String dni, float sueldo) {
		super(nombre, apellido1, dni);
		setSueldo(SUELDO_MINIMO);
		
	}

	
	// Getters y Setters
	public float getSueldo() {
		return sueldo;
	}

	/**
	 * Sueldo mensual en euros y bruto
	 * Siempre sera mayor o igual al minimo <code>SUELDO_MINIMO</code>
	 * @param sueldo
	 */
	public void setSueldo(float sueldo) {
		if (sueldo>SUELDO_MINIMO){
			this.sueldo = sueldo;
		}
	}

	@Override
	public String toString() {
		return "Formador [sueldo=" + sueldo + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", edad=" + edad + ", dni=" + dni + ", poblacion="
				+ poblacion + ", mayorEdad=" + mayorEdad + ", telefono="
				+ telefono + ", sexo=" + sexo + ", libros=" + libros + "]";
	}
	
}
