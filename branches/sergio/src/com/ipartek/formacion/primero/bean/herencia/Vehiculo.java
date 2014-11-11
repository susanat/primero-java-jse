package com.ipartek.formacion.primero.bean.herencia;

public class Vehiculo {
	
	protected int numPlazas;
	protected float dimensiones;
	protected float potencia;
	
	//constantes
	public static final int MIN_PLAZAS = 2;
	public static final float MIN_DIM = 50f;
	public static final float MIN_POTENCIA = 100f;
	
	
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


	public Vehiculo(){
		this.setDimensiones(MIN_DIM);
		this.setNumPlazas(MIN_PLAZAS);
		this.setPotencia(MIN_POTENCIA);		
	}

	public Vehiculo(int numPlazas, float dimensiones, float potencia) {
		super();
		this.numPlazas = numPlazas;
		this.dimensiones = dimensiones;
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Vehiculo "
				+ "[numPlazas=" + numPlazas + ", "
				+ "dimensiones="+ dimensiones + ", "
				+ "potencia=" + potencia + "]";
	}
	
	
	
	

}
