package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

/**
 * Clase que representa un vehiculo
 * 
 * @author Fran
 *
 */
public class Vehiculo implements Comparable<Vehiculo> {
	protected int numPlazas;
	protected float dimensiones;
	protected float potencia;
	/**
	 * Número de plazas mínimas que puede tener un vehículo
	 */
	public static final int MIN_PLAZAS = 2;
	/**
	 * Dimensión mínima que puede tener un vehículo
	 */
	public static final float MIN_DIM = 50f;
	/**
	 * Potencia mínima que debe tener un vehículo
	 */
	public static final float MIN_POTENCIA = 100f;

	public Vehiculo(float potencia, int numPlazas) {
		super();
		setNumPlazas(numPlazas);
		setDimensiones(MIN_DIM);
		setPotencia(potencia);
	}

	public Vehiculo(float potencia) {
		super();
		setNumPlazas(MIN_PLAZAS);
		setDimensiones(MIN_DIM);
		setPotencia(potencia);
	}

	public Vehiculo() {
		super();
		setNumPlazas(MIN_PLAZAS);
		setDimensiones(MIN_DIM);
		setPotencia(MIN_POTENCIA);
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPazas) {
		this.numPlazas = numPazas;
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

	@Override
	public String toString() {
		return "Vehiculo [numPazas=" + numPlazas + ", dimensiones="
				+ dimensiones + ", potencia=" + potencia + "]";
	}

	@Override
	public int compareTo(Vehiculo o) {
		return Float.compare(this.getPotencia(), o.getPotencia());
	}

	/**
	 * Comparator para número de plazas
	 */
	public class ComparatorNumeroPlazas implements Comparator<Vehiculo> {

		@Override
		public int compare(Vehiculo o1, Vehiculo o2) {
			return Integer.compare(o1.getNumPlazas(), o2.getNumPlazas());
		}

	}
}
