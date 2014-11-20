package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoGasolina extends Vehiculo implements Arrancable {
	// Atributos
	private boolean gasolina;

	// Constantes
	/**
	 * El coche utiza 'gasolina'
	 */
	public static final boolean ES_GASOLINA = true;
	
	// Constructor
	/**
	 * Constructor pro defecto, siempre es gasolina
	 */
	public VehiculoGasolina() {
		super();
		setGasolina(ES_GASOLINA);
	}


	public boolean isGasolina() {
		return gasolina;
	}


	public void setGasolina(boolean gasolina) {
		this.gasolina = gasolina;
	}


	@Override
	public boolean arrancar() {
		return true;
	}
}
