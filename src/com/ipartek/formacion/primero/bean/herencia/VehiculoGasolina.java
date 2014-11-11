package com.ipartek.formacion.primero.bean.herencia;

import java.io.Serializable;

public class VehiculoGasolina extends Vehiculo implements Arrancable,
		Serializable {

	// Atributos
	private boolean gasolina;

	// Constructores
	public VehiculoGasolina() {
		super();
		setGasolina(true);
		;
	}

	// Getters & Setters
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
