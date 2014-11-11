package com.ipartek.formacion.primero.bean.herencia;

public class Vehiculo {

	//ATRIBUTOS
	protected int numPlazas;
	protected float dimensiones;
	protected float potencia;
	
	//CONSTANTES
	public static final int MIN_PLAZAS=2;
	public static final float MIN_DIM=50F;
	public static final float MIN_POTENCIA=100F;
	
	//CONSTRUCTOR
	public Vehiculo() {
		super();
		
		setNumPlazas(MIN_PLAZAS);
		setDimensiones(MIN_DIM);
		setPotencia(MIN_POTENCIA);
		
	}


	//GETTERS / SETTERS
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


	//METODOS
	@Override
	public String toString() {
		return "Vehiculo [numPlazas=" + numPlazas + ", dimensiones="
				+ dimensiones + ", potencia=" + potencia + "]";
	}
	
	
	
}
