package com.ipartek.formacion.primero.bean.herencia;

public class Vehiculo {
	
	//Atributos - protected es parecido a private pero las clases hijas lo pueden utilizar, es menos restrintivo
	protected int numPlazas;
	protected float dimensiones;
	protected float potencias;
	
	//constantes
	public static final int MIN_PLAZAS = 2;
	public static final float MIN_DIM = 50f;
	public static final float MIN_POTENCIA = 100f;
	
	public Vehiculo() {
		super();
		setNumPlazas(MIN_PLAZAS);
		setDimensiones(MIN_DIM);
		setPotencias(MIN_POTENCIA);
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


	public float getPotencias() {
		return potencias;
	}


	public void setPotencias(float potencias) {
		this.potencias = potencias;
	}


	@Override
	public String toString() {
		return "Vehiculo [numPlazas=" + numPlazas + ", dimensiones="
				+ dimensiones + ", potencias=" + potencias + "]";
	}


	
	
	
	
	
	
	

}
