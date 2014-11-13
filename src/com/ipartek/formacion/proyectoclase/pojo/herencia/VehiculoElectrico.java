package com.ipartek.formacion.proyectoclase.pojo.herencia;

import java.io.Serializable;

public class VehiculoElectrico extends Vehiculo implements Arrancable,
		Serializable, Comparable<Vehiculo> {

	private float capacidadBateria;

	public static final Double MIN_POTENCIA = 150.0;

	/**
	 * Capacidad minima para una bateria
	 */
	static public final float MIN_CAP_BATERIA = 0;

	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(VehiculoElectrico.MIN_POTENCIA);
	}

	public VehiculoElectrico(Double potencia) {
		// super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
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
	public int compareTo(Vehiculo o) {
		// TODO Auto-generated method stub
		int resultado = 0;
		if (this.potencia < o.getPotencia()) {
			resultado = -1;
		} else if (this.potencia > o.getPotencia()) {
			resultado = 1;
		}
		return resultado;
	}

}
