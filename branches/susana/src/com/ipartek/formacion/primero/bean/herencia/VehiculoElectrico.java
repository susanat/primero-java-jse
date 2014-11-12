package com.ipartek.formacion.primero.bean.herencia;

import java.io.Serializable;

public class VehiculoElectrico extends Vehiculo implements Arrancable,
Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1948593510373793674L;

	// Atributos
	private float capacidadBaterias;

	// Sobre-escribo MIN_POTENCIA del padre
	public static final float MIN_POTENCIA = 150f;

	/**
	 * Capacidad minima para una bateria
	 */
	static public final float MIN_CAP_BATERIA = 0;

	// constructor - con el set lo inicializo
	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencias(VehiculoElectrico.MIN_POTENCIA);
	}

	// esto es porque sobreescribe la potencia respecto al padre
	@Override
	public void setPotencias(float potencias) {
		super.setPotencias(potencias);
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
				+ ", potencias=" + potencias + "]";
	}

	@Override
	public boolean arrancar() {
		return true;
	}

}
