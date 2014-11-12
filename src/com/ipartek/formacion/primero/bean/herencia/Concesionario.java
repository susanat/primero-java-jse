package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculo
 *
 * @author Susana Costoya
 *
 */
public class Concesionario {

	/**
	 * Variable
	 * <code> o atributo estatico para llevar el contador de vehiculos vendidos
	 */
	private static int ventasGlobales = 0;

	/**
	 * Atributo no statico,para la venta de cada Concesionario
	 */
	private int ventas = 0;

	/**
	 * Constructo vacio, inicializa las ventas a cero
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

	public static void setVentasGlobales(int ventas) {
		ventasGlobales = ventas;
	}

	/**
	 * Compramps un vehiculo que puede ser <code>VehiculoElectrico</code> o
	 * <code>VehiculoGasolina</code>
	 *
	 * @param electico
	 *            true <code>VehiculoElectrico</code>, false
	 *            <code>VehiculoGasolina</code>
	 * @return <code>Vehiculo</code> comprado
	 */

	public Vehiculo comprarVehiculo(boolean electrico) {

		ventas++;
		ventasGlobales++;

		Vehiculo result = null;
		if (electrico) {
			result = new VehiculoElectrico();
		} else {
			result = new VehiculoGasolina();
		}
		return result;
	}

}
