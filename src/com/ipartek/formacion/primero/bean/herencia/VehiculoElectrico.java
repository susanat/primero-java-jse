package com.ipartek.formacion.primero.bean.herencia;

import java.io.Serializable;


public class VehiculoElectrico extends Vehiculo implements Arrancable, Serializable {

	private float capacidadBaterias;
	
	public static final float MIN_POTENCIA = 150f;
	
	/**
	 * Capacidad minima para una bateria
	 */
	static public final float MIN_CAP_BATERIA = 0; 
	
	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(VehiculoElectrico.MIN_POTENCIA);		
	}
	
	public VehiculoElectrico( float potencia) {
		//super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(potencia);
	}
	
	@Override
	public void setPotencia(float potencia) {		
		super.setPotencia(potencia);
	}
	

	public float getCapacidadBaterias() {
		return capacidadBaterias;
	}

	public void setCapacidadBaterias(float capacidadBaterias) {
		this.capacidadBaterias = capacidadBaterias;
	}

	@Override
	public String toString() {
		
		return "VehiculoElectrico [capacidadBaterias=" + capacidadBaterias
				+ ", numPlazas=" + numPlazas + ", dimensiones=" + dimensiones
				+ ", potencia=" + potencia + "]";
	}

	@Override
	public boolean arrancar() {		
		return true;
	}
	
	
	
}
