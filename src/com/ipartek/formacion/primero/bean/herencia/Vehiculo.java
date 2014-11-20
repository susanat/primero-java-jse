package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

/**
 * Tipo de Vehiculo
 *
 * @author Jose A. Perez
 *
 */
public class Vehiculo implements Comparable<Vehiculo> {
	// Atributos
	protected int numPlazas; // PROTECTED - para que puedan ser visibles por las
	// clases que heredan de el
	protected float dimensiones;
	protected float potencia;

	// Constantes
	public static final int MIN_PLAZAS = 2;
	public static final float MIN_DIM = 50f;
	public static final float MIN_POTENCIA = 100f;

	// Constructor
	public Vehiculo() {
		super();
		setNumPlazas(MIN_PLAZAS);
		setDimensiones(MIN_DIM);
		setPotencia(MIN_POTENCIA);
	}

	public Vehiculo(int plazas) {
		this();
		setNumPlazas(plazas);
	}

	public Vehiculo(float potencia) {
		this();
		setPotencia(potencia);
	}

	public Vehiculo(int plazas, float potencia) {
		this();
		setNumPlazas(plazas);
		setPotencia(potencia);
	}

	// Getters and Setters
	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		if (numPlazas < MIN_PLAZAS) {
			this.numPlazas = MIN_PLAZAS;
		} else {
			this.numPlazas = numPlazas;
		}
	}

	public float getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(float dimensiones) {
		if (dimensiones < MIN_DIM) {
			this.dimensiones = MIN_DIM;
		} else {
			this.dimensiones = dimensiones;
		}
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		if (potencia < MIN_POTENCIA) {
			this.potencia = MIN_POTENCIA;
		} else {
			this.potencia = potencia;
		}
	}

	// Otras
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
	 * Comparator para numero de plazas
	 */
	public static class ComparatorNumeroPlazas implements Comparator<Vehiculo> {

		@Override
		public int compare(Vehiculo o1, Vehiculo o2) {
			return Integer.compare(o1.getNumPlazas(), o2.getNumPlazas());
		}

	}
}
