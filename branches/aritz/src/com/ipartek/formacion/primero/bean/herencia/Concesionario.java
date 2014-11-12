package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar vehiculos
 *
 * @author Aritz Tellaeche
 *
 */
public class Concesionario {

	/**
	 * atributo <code>static</code> para llevar el contador de vehiculos
	 * vendidos
	 */
	private static int ventasGlobales = 0;

	/**
	 * atributo no <code>static</code> para las ventas de cada concesionario
	 */
	private int ventas = 0;

	// constructor
	/**
	 * constructor vacio, inicializa las ventas a cero
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
	 * compramos un vehiculo q puede ser VehiculoElectrico o VehiculoGasolina
	 *
	 * @param electrico
	 *            true <code>VehiculoElectrico</code>, false
	 *            <code>VehiculoGasolina</code>
	 * @return <code>vehiculo</code> comprado
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
