package com.ipartek.formacion.proyectoclase.pojo.herencia;

/**
 * Obejto para poder comprar {@code Vehiculo}.
 *
 * @author Urko Villanueva
 *
 */
public class Concesionario {
	/**
	 * Atributo <code>estatico</code> para llevar el contador de Vehiculos
	 * vendidos
	 */
	private static int ventaGlobal = 0;

	/***
	 * Atributo no estatico para la venta de cada Concesionario
	 */
	private int venta;

	/**
	 * Constructor vacio inicializa las ventas a 0
	 */
	public Concesionario() {
		super();
		this.venta = 0;
		setVenta(0);
	}

	public int getVenta() {
		return venta;
	}

	private void setVenta(int venta) {
		if (venta >= 0) {
			this.venta = venta;
		}
	}

	public static int getVentaGlobal() {
		return ventaGlobal;
	}

	/**
	 * Comparmos n vehiculo que puede ser un VehiculoElectrico o
	 * VehiculoGasolina.
	 *
	 * @param electrico
	 *            {@code Boolean} true VehiculoElectrico, false VehiculoGasolina
	 * @return <code>Vehiculo</code> comprado
	 */
	public Vehiculo comprarVehiculo(final boolean electrico) {
		Vehiculo v = null;
		if (electrico) {
			v = new VehiculoElectrico();

		} else {
			v = new VehiculoGasolina();
		}
		ventaGlobal++;
		venta++;
		return v;
	}

	/**
	 *
	 */
	public static void resetearCompraVehiculos() {
		Concesionario.ventaGlobal = 0;
	}

}
