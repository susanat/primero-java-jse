package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase que representa un vehiculo de gasolina, extiende de la clase vehiculo
 * @author Fran
 *
 */
public class VehiculoGasolina extends Vehiculo implements Arrancable {
	private float deposito;
	/**
	 * Capacidad mínima en litros que debe tener el depósito de un vehículo de gasolina
	 */
	public static final float MIN_LITROS = 40f;

	public VehiculoGasolina() {
		super();
		setDeposito(MIN_LITROS);
	}

	public float getDeposito() {
		return deposito;
	}

	public void setDeposito(float deposito) {
		this.deposito = deposito;
	}

	@Override
	public boolean arrancar() {
		return true;
	}

}
