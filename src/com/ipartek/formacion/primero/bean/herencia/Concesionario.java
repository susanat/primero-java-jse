package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculos
 *
 * @author Joseba Carrión Blanco
 *
 */
public class Concesionario {

	/**
	 * Atributo estatico para llevar el contador de vehiculos vendidos
	 */

	private static int ventasGlobales = 0;

	/**
	 * Atributo no estatico para las ventas de cada concesionario
	 */
	private int ventas = 0;

	/**
	 * Constructor vacio. Inicializa las ventas DEL CONCESIONARIO a 0
	 */
	public Concesionario() {
		super();
		this.ventas = 0;
	}

	// Getters y setters

	public int getVentas() {
		return ventas;
	}

	public int getVentasGlobales() {
		return ventasGlobales;
	}

	public void setVentasGlobales(int ventas) {
		ventasGlobales = ventas;

	}

	/**
	 * Compramos un vehiculo que puede ser VehiculoElectrico o VehiculoGasolina
	 *
	 * @param electrico
	 *            true si es VehiculoElectrico, false si es VehiculoGasolina
	 * @return {@code Vehiculo} comprado
	 */

	public Vehiculo comprarVehiculo(boolean electrico) {
		Vehiculo resul = null;
		if (electrico) {
			resul = new VehiculoElectrico();
		} else {
			resul = new VehiculoGasolina();
		}

		ventasGlobales++;
		ventas++;

		return resul;
	}

	/**
	 * Funcion que resetea la variable ventasGlobales
	 */

}
