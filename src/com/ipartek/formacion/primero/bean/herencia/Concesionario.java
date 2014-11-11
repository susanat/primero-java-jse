package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculos 
 * @author Joseba Carrión Blanco
 *
 */
public class Concesionario {
	
	/**
	 * Compramos un vehiculo que puede ser VehiculoElectrico o VehiculoGasolina
	 * @param electrico true si es VehiculoElectrico, false si es VehiculoGasolina
	 * @return {@code Vehiculo} comprado
	 */

	static public Vehiculo comprarVehiculo(boolean electrico){
		Vehiculo resul = null;
		if(electrico){
			resul = new VehiculoElectrico();
		}else{
			resul = new VehiculoGasolina();
		}
		return resul;
	}
}
