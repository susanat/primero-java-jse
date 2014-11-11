package com.ipartek.formacion.proyectoclase.pojo.herencia;
/**
 * Obejto para poder comprar {@code Vehiculo}.
 * @author Urko Villanueva
 *
 */
public class Concesionario {
/**
 * Comparmos n vehiculo que puede ser un VehiculoElectrico o VehiculoGasolina.
 * @param electrico {@code Boolean} true VehiculoElectrico, false VehiculoGasolina
 * @return <code>Vehiculo</code> comprado
 */
	public static Vehiculo comprarVehiculo(final boolean electrico) {
		Vehiculo v = null;
		if (electrico) {
			v = new VehiculoElectrico();
		} else {
			v = new VehiculoGasolina();
		}
		return v;
	}

}
