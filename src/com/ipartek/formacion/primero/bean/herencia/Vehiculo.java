package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

public class Vehiculo implements Comparable<Vehiculo> {

	// Atributos
	protected int numPlazas;
	protected float dimensiones;
	protected float potencia;

	// Constantes
	public static final int MIN_PLAZAS = 2;
	public static final float MIN_DIM = 50f;
	public static final float MIN_POTENCIA = 100f;

	// Constructores
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

	public Vehiculo(float potencia, int plazas) {
		this();
		setNumPlazas(plazas);
		setPotencia(potencia);
	}

	public Vehiculo(int plazas) {
		this();
		setNumPlazas(plazas);
	}

	// Getters y setters
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

	// Métodos
	@Override
	public String toString() {
		return "Vehiculo [numPlazas=" + numPlazas + ", dimensiones="
				+ dimensiones + ", potencia=" + potencia + "]";
	}

	@Override
	public int compareTo(Vehiculo o) {
		return Float.compare(this.getPotencia(), o.getPotencia());
	}

	/**
	 * Comparator para número de plazas
	 *
	 * @author Curso
	 *
	 */
	public static class ComparatorNumPlazas implements Comparator<Vehiculo> {

		@Override
		public int compare(Vehiculo o1, Vehiculo o2) {
			return Integer.compare(o1.getNumPlazas(), o2.getNumPlazas());
		}

	}
}
