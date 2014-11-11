package com.ipartek.formacion.primero.bean.herencia;

public class Vehiculo {

	// Atributos
	protected int numPlazas;
	protected float dimensiones;
	protected float potencia;

	// Constantes
	public static final int MIN_PLAZAS = 2;
	public static final float MIN_DIM = 50f;
	public static final float MIN_POTENCIA = 100f;

	// Constructores
	public Vehiculo() {
		super();
		setNumPlazas(MIN_PLAZAS);
		setDimensiones(MIN_DIM);
		setPotencia(MIN_POTENCIA);
	}

	// Getters y setters
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

	// Métodos
	@Override
	public String toString() {
		return "Vehiculo [numPlazas=" + numPlazas + ", dimensiones="
				+ dimensiones + ", potencia=" + potencia + "]";
	}

}
