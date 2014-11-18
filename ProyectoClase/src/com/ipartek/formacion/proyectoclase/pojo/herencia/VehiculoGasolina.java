package com.ipartek.formacion.proyectoclase.pojo.herencia;

public class VehiculoGasolina extends Vehiculo implements Arrancable {
	/**
	 *
	 */

	/**
 *
 */
	private boolean gasolina;

	/**
 *
 */
	public VehiculoGasolina() {
		super();
		// TODO Auto-generated constructor stub
		setGasolina(true);
	}

	/**
	 * 
	 * @return
	 */
	public boolean isGasolina() {
		return gasolina;
	}

	/**
	 * 
	 * @param gasolina
	 */
	public void setGasolina(boolean gasolina) {
		this.gasolina = gasolina;
	}

	@Override
	public Boolean arrancar() {
		// TODO Auto-generated method stub
		return true;
	}
}
