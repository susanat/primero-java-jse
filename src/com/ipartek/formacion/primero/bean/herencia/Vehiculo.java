package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

public class Vehiculo implements Comparable<Vehiculo> {
	protected int numPlazas;
	protected float dimensiones;
	protected float potencia;

	public static final int MIN_PLAZAS = 2;
	public static final float MIN_DIM = 50;
	public static final float MIN_POTENCIA = 100f;

	public Vehiculo() {
		super();
		setNumPlazas(MIN_PLAZAS);
		setDimensiones(MIN_DIM);
		setPotencia(MIN_POTENCIA);
	}

	public Vehiculo(float potencia) {
		this();
		setPotencia(potencia);
	}

	public Vehiculo(int plazas) {
		this();
		setNumPlazas(plazas);
	}

	public Vehiculo(float potencia, int numPlazas) {
		super();
		setNumPlazas(numPlazas);
		setPotencia(potencia);
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

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public int compareTo(Vehiculo o) {
		return Float.compare(this.getPotencia(), o.getPotencia());
	}

	/**
	 * comparator para numero de plazas
	 */

	public static class ComparatorNumeroPlazas implements Comparator<Vehiculo> {

		@Override
		public int compare(Vehiculo o1, Vehiculo o2) {
			return Integer.compare(o1.getNumPlazas(), o2.getNumPlazas());
		}

	}
}
