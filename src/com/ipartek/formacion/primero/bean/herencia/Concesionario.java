package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculo
 *
 * @author Ander Uraga Real
 *
 */
public class Concesionario {

	/**
	 * Atributo <code>statico</code> para llevar el contador de Vehiculos
	 * vendidos
	 */
	private static int ventasGlobales = 0;

	/**
	 * Atributo no estatico, para las ventas de cada Concesionario
	 */
	private int ventas = 0;

	/**
	 * Constructor vacio, inicializa las ventas a cero
	 */
	public Concesionario() {
		super();
		this.ventas = 0;
	}

	// getter y setters
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
