package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculo
 *
 * @author Ander Uraga Real
 *
 */
public class Concesionario {

	/**
	 * Atributo estatico para llevar el contador de vehiculos vendidos
	 */

	private static int ventasGlobales = 0;
	/**
	 * Atributo no estatico para las ventas de cada Concesionario
	 */
	private int ventas = 0;

	/**
	 * Constructor vacio que inicializa las ventas a 0
	 */

	public Concesionario() {
		super();
		this.ventas = 0;
	}

	// getters y setters

	public static int getVentasGlobales() {
		return ventasGlobales;
	}

	public int getVentas() {
		return ventas;
	}

	/**
	 * Inicializa el contador ventasGlobales a 0
	 * 
	 * @param ventasGlobales
	 */

	public static void setVentasGlobales(int ventasGlobales) {
		Concesionario.ventasGlobales = ventasGlobales;
	}

	/**
	 * compramos un vehiculo que puede ser <code>VehiculoElectrico</code> o
	 * <code>VehiculoGasolina</code>
	 *
	 * @param electrico
	 *            true <code>VehiculoElectrico</code>, false
	 *            <code>VehiculoGasolina</code>
	 * @return <code>Vehiculo</code> comprado
	 */
	public Vehiculo comprarVehiculo(boolean electrico) {

		ventas++;
		ventasGlobales++;

		Vehiculo resul = null;
		if (electrico) {
			resul = new VehiculoElectrico();
		} else {
			resul = new VehiculoGasolina();
		}
		return resul;
	}

}
