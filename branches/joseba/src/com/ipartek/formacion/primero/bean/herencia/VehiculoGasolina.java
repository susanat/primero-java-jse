package com.ipartek.formacion.primero.bean.herencia;

import java.io.Serializable;

public class VehiculoGasolina extends Vehiculo implements Arrancable,
		Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4748285716110328057L;
	/**
	 * Para serializar objetos, nos lo pone eclipse auntomaticamente
	 */

	private boolean gasolina;

	/**
	 * Constructor por defecto, siempre es gasolina
	 */

	public VehiculoGasolina() {
		super();
	}

	public VehiculoGasolina(boolean gasolina) {
		super();
		setGasolina(true);
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
