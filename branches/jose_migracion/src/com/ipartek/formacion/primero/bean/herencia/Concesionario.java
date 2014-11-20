package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculo
 *
 * @author Jose A. Perez
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

	// Constructores
	/**
	 * Constructor vacio, inicializa las ventas a cero
	 */
	public Concesionario() {
		super();
		this.ventas = 0;
		// NOTA - no se inicializa ventasGlobales,
		// para que no se resetee cada vez que se cree un nuevo Concesionario
	}

	// Getters y Setters
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
	 * compramos un vehiculo que puede ser VehiculoElectrico o VehiculoGasolina
	 *
	 * @param electrico
	 *            true - <code>VehiculoElectrico</code>, false -
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
