package com.ipartek.formacion.primero.bean.herencia;

import java.io.Serializable;

public class VehiculoElectrico extends Vehiculo implements Arrancable,
		Serializable, Ordenable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6377077734494654255L;

	private float capacidadBaterias;

	public static final float MIN_POTENCIA = 150F;

	/*
	 * Capacidad minima de una bateria
	 */
	static public final float MIN_CAP_BATERIA = 0;

	public VehiculoElectrico() {
		super();

		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(VehiculoElectrico.MIN_POTENCIA);
	}

	public VehiculoElectrico(float potencia) {
		super();
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

	@Override
	public float getPeso() {
		return getPotencia();
	}

}
