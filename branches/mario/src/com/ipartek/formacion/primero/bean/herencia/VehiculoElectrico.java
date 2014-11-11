package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoElectrico extends Vehiculo {

	private float capacidadBaterias ;
	
	public static final float MIN_POTENCIA = 150.0f;
	/**
	 * Capacidad minima para una bateria
	 */
	static public final float MIN_CAP_BATERIA = 0; 

	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(MIN_POTENCIA);
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
	
	
	
}
