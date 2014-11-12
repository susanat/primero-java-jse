package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoGasolina extends Vehiculo implements Arrancable{

	
	private boolean gasolina;

	/**
	 * Constructor por defecto, siempre es gasolina (true)
	 */
	public VehiculoGasolina() {
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
