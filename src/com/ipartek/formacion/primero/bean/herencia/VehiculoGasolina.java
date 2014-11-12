package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoGasolina extends Vehiculo implements Arrancable{
	
	//atributos
	private boolean gasolina;

	
	//constructor
	/**
	 * constructor por defecto
	 */
	public VehiculoGasolina() {
		super();
		setGasolina (true);
	}


	//getters y setters
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
