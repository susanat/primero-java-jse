package com.ipartek.formacion.primero.bean.herencia;

/**
 * Tipo de Vehiculo
 * 
 * @author Jose A. Perez
 *
 */
public class Vehiculo {
	// Atributos
	protected int numPlazas;		// PROTECTED - para que puedan ser visibles por las clases que heredan de el
	protected float dimensiones;
	protected float potencia;
	
	
	// Constantes
	public static final int MIN_PLAZAS = 2;
	public static final float MIN_DIM = 50f;
	public static final float MIN_POTENCIA = 100f;
	
	
	// Constructor
	public Vehiculo() {
		super();
		setNumPlazas(MIN_PLAZAS);
		setDimensiones(MIN_DIM);
		setPotencia(MIN_POTENCIA);
	}


	// Getters and Setters
	public int getNumPlazas() {
		return numPlazas;
	}


	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}


	public float getDimensiones() {
		return dimensiones;
	}


	public void setDimensiones(float dimensiones) {
		this.dimensiones = dimensiones;
	}


	public float getPotencia() {
		return potencia;
	}


	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}


	// Otras
	@Override
	public String toString() {
		return "Vehiculo [numPlazas=" + numPlazas + ", dimensiones="
				+ dimensiones + ", potencia=" + potencia + "]";
	}
}
