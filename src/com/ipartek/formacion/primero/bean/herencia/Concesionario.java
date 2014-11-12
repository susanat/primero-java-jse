package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculo
 *
 * @author Mario Alvaro
 *
 */
public class Concesionario {
	public static final int SINVENTAS = 0;
	/**
	 * Atributo <code>static</code> para llevar el contador de
	 * <code>Vehiculos</code> vendidos
	 */
	private static int ventasGlobales;
	/**
	 * Atributo no estatico, para las ventas de cada <code>Concesionario</code>
	 */
	private int ventas;

	/**
	 * Constructor vacio, inicializa las ventas a cero
	 */
	public Concesionario() {
		super();
		setVentas(SINVENTAS);
		setVentasGlobales(SINVENTAS);
	}

	// getter y setters

	public int getVentasGlobales() {
		return ventasGlobales;
	}

	public void setVentasGlobales(int ventaGlob) {
		ventasGlobales = ventaGlob;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	/**
	 * compramos un vehiculo que puede ser <code>VehiculoElectrico</code> o
	 * <code>VehiculoGasolina</code>
	 *
	 * @param electrico
	 *            - true <code>VehiculoElectrico</code>, false
	 *            <code>VehiculoGasolina</code>
	 * @return <code>Vehiculo</code> comparado
	 */
	public Vehiculo comprarVehiculo(boolean electrico) {
		ventasGlobales++;
		ventas++;
		Vehiculo resul = null;

		if (electrico) {
			resul = new VehiculoElectrico();
		} else {
			resul = new VehiculoGasolina();
		}
		return resul;
	}

}
