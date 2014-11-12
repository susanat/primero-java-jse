package com.ipartek.formacion.primero.bean.herencia;

/**
 * objeto para poder comprar Vehiculo
 * 
 * @author Curso
 *
 */
public class Concesionario {

	/**
	 * atributo estatico para llevar el contador de vehiculos vendidos
	 * 
	 */
	private static int ventasGlobales = 0;

	/**
	 * atributo no estatico para las ventas de cada concesionario
	 */
	private int ventas = 0;

	/**
	 * constructor vacio. inicializa las ventas a 0.
	 */
	public Concesionario() {
		super();
		this.ventas = 0;
	}

	public static int getVentasGlobales() {
		return ventasGlobales;
	}

	public int getVentas() {
		return ventas;
	}

	/**
	 * compramos un vehiculo que puede ser electrico o gasolina
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

	public void setVentasGlobales(int vg) {
		ventasGlobales = vg;
	}
}
