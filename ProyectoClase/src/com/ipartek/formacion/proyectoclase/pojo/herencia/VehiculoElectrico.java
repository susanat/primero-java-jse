package com.ipartek.formacion.proyectoclase.pojo.herencia;

import com.ipartek.formacion.proyectoclase.pojo.IOrdenable;

public class VehiculoElectrico extends Vehiculo implements Arrancable,
		IOrdenable {

	/**
	 *
	 */

	private float capacidadBateria;

	public static final Double MIN_POTENCIA = 150.0;

	/**
	 * Capacidad minima para una bateria
	 */
	static public final float MIN_CAP_BATERIA = 0f;

	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(VehiculoElectrico.MIN_POTENCIA);
	}

	public VehiculoElectrico(Double potencia) {
		this();
		setPotencia(potencia);
	}

	@Override
	public void setPotencia(Double potencia) {
		super.setPotencia(potencia);
	}

	public float getCapacidadBateria() {
		return capacidadBateria;
	}

	public void setCapacidadBaterias(float capacidadBateria) {
		this.capacidadBateria = capacidadBateria;
	}

	@Override
	public String toString() {

		String dimensiones = new String("");
		return "VehiculoElectrico [capacidadBaterias=" + capacidadBateria
				+ ", numPlazas=" + numPlazas + ", dimensiones=" + dimensiones
				+ ", potencia=" + potencia + "]";
	}

	@Override
	public Boolean arrancar() {
		return true;
	}

	@Override
	public Double getPeso() {
		// TODO Auto-generated method stub
		return this.potencia;

	}

}
