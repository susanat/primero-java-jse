package com.ipartek.formacion.primero.bean.herencia;

public class Vehiculo {
	
	//Atributos
	
	//protected es como private pero las clases hijas pueden utilizarlo
	protected int numPlazas;
	protected float dimensiones;
	protected float potencia;
	
	//constantes
	
	public static final int MIN_PLAZAS = 2;
	public static final float MIN_DIM = 50f;
	public static final float MIN_POTENCIA = 100f;
	
	//Constructor
	
	public Vehiculo(){
		super();
		this.setNumPlazas(MIN_PLAZAS);
		this.setDimensiones(MIN_DIM);
		this.setPotencia(MIN_POTENCIA);
	}


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


	@Override
	public String toString() {
		return "Vehiculo [numPlazas=" + numPlazas + ", dimensiones="
				+ dimensiones + ", potencia=" + potencia + "]";
	}
	
	

}
