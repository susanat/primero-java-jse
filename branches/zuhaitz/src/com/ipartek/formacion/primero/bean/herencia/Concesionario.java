package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar un Vehículo
 * 
 * @author Curso
 *
 */

public class Concesionario {

	/**
	 * Compramos un vehículo que puede ser <code>VehiculoElectrico</code> o
	 * <code>VehiculoGasolina</code>
	 * 
	 * @param electrico
	 *            true <code>VehiculoElectrico</code>, false
	 *            <code>VehiculoGasolina</code>
	 * @return <code>Vehiculo</code> comprado
	 */
	public static Vehiculo comprarVehiculo(boolean electrico) {
		Vehiculo res;
		if (electrico) {
			res = new VehiculoElectrico();
		} else {
			res = new VehiculoGasolina();
		}
		return res;
	}

}
