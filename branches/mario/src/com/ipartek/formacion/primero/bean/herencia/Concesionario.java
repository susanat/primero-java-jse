package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculo
 * @author Mario Alvaro
 *
 */
public class Concesionario {

	/**
	 * compramos un vehiculo que puede ser <code>VehiculoElectrico</code> o <code>VehiculoGasolina</code>
	 * @param electrico - true <code>VehiculoElectrico</code>, false <code>VehiculoGasolina</code>
	 * @return <code>Vehiculo</code> comparado
	 */
	static public Vehiculo comprarVehiculo(boolean electrico){
		Vehiculo resul = null;
		
		if ( electrico ) {
			resul = new VehiculoElectrico();
		}else{
			resul = new VehiculoGasolina();
		}
		return resul;
	}
	
}
