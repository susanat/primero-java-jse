package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculo
 * @author Jose A. Perez
 *
 */
public class Concesionario {
	/**
	 * compramos un vehiculo que puede ser VehiculoElectrico o VehiculoGasolina
	 * @param electrico true - <code>VehiculoElectrico</code>, false - <code>VehiculoGasolina</code> 
	 * @return <code>Vehiculo</code> comprado
	 */
	public static Vehiculo comprarVehiculo(boolean electrico){
		Vehiculo resul = null;
		if (electrico){
			resul = new VehiculoElectrico();
		}else{
			resul = new VehiculoGasolina();
		}
		return resul;
	}
}
