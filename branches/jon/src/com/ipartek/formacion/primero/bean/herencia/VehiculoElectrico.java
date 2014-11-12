package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoElectrico extends Vehiculo implements Arrancable  {
	private float capacidadBaterias;

	/**
	 * Capacidad minima para una bateria
	 */
	static public final float MIN_CAP_BATERIA = 0;
	public static final float MIN_POTENCIA = 150f;
	
	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(MIN_POTENCIA);
	}

	@Override
	public void setPotencia(float potencia){
		this.potencia = potencia;
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
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
