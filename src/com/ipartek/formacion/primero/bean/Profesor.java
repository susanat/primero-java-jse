package com.ipartek.formacion.primero.bean;

/**
 * Clase Profesor que hereda de la clase Persona. Tiene como unico atributo distintivo el float sueldo
 * @author Joseba Carrión Blanco
 *
 */

public class Profesor extends Persona {
	
	public static final float MIN_SUELDO = 646.56f;
	
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
		if(sueldo > MIN_SUELDO){
			this.sueldo = sueldo;
		}
		
	}
	
	

}
