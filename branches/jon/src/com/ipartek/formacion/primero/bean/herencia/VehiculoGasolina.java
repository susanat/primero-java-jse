package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoGasolina extends Vehiculo implements Arrancable {
	private boolean gasolina;

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
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
