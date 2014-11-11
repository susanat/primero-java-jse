package com.ipartek.formacion.proyectoclase.pojo.herencia;

import java.io.Serializable;

public class VehiculoGasolina extends Vehiculo implements Arrancable, Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
