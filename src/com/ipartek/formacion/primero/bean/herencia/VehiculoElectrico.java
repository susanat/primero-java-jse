package com.ipartek.formacion.primero.bean.herencia;

import java.io.Serializable;

import com.ipartek.formacion.primero.bean.interfaces.IOrdenable;

/**
 * Clase VehiculoElectrico que hereda de la Clase Vehiculo e implementa las
 * interfaces Arrancable, Serializable y Ordenable
 *
 * @author Joseba Carrión Blanco
 *
 */

public class VehiculoElectrico extends Vehiculo implements Arrancable,
		Serializable, IOrdenable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private float capacidadBaterias;

	/**
	 * Capacidad minima para una bateria
	 */
	public static final float MIN_CAP_BATERIA = 0;
	public static final float MIN_POTENCIA = 150;

	// Constructores

	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(MIN_POTENCIA);

	}

	public VehiculoElectrico(float bateria, float potencia) {
		super();
		setCapacidadBaterias(bateria);
		setPotencia(potencia);
	}

	// Setters y getters

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
		return (this.getPotencia());
	}

}
