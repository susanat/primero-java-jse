package com.ipartek.formacion.proyectoclase.pojo.herencia;

/**
 * @author Urko Villanueva
 *
 */
public class Vehiculo {
	/**
	 *
	 */
	protected Integer numPlazas;
	/**
	 *
	 */
	protected Double dim;
	/**
	 *
	 */
	protected Double potencia;

	// constantes
	/**
	 *
	 */
	public static final int MIN_PLAZAS = 2;
	/**
	 *
	 */
	public static final double MIN_DIM = 50.0;
	/**
	 *
	 */
	public static final double MIN_POTENCIA = 50.0;

	/**
	 *
	 */
	public Vehiculo() {
		super();
		setNumPlazas(Vehiculo.MIN_PLAZAS);
		setDim(Vehiculo.MIN_DIM);
		setPotencia(Vehiculo.MIN_POTENCIA);
	}

	@Override
	public String toString() {
		return "Vehiculo [numPlazas=" + numPlazas + ", dim=" + dim
				+ ", potencia=" + potencia + "]";
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(Integer numPlazas) {
		this.numPlazas = numPlazas;
	}

	public Double getDim() {
		return dim;
	}

	public void setDim(Double dim) {
		this.dim = dim;
	}

	public Double getPotencia() {
		return potencia;
	}

	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}
}
