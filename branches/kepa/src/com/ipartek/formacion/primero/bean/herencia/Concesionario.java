package com.ipartek.formacion.primero.bean.herencia;

/**
 * Objeto para poder comprar Vehiculo
 * 
 * @author Ander Uraga Real
 *
 */
public class Concesionario {

	/**
	 * compramos un vehiculo que puede ser <code>VehiculoElectrico</code> o
	 * <code>VehiculoGasolina</code>
	 * 
	 * @param electrico
	 *            true <code>VehiculoElectrico</code>, false
	 *            <code>VehiculoGasolina</code>
	 * @return <code>Vehiculo</code> comprado
	 */
	private static int ventaGlobal = 0;

	private int venta;

	public Concesionario() {
		super();
		this.venta = 0;
	}

	public Concesionario(int venta) {
		super();
		this.venta = venta;
	}

	public static int getVentaGlobal() {
		return ventaGlobal;
	}

	public int getVenta() {
		return venta;
	}

	public static void setVentaGlobal(int ventaGlobal) {
		Concesionario.ventaGlobal = ventaGlobal;
	}

	public Vehiculo comprarVehiculo(boolean electrico) {

		Vehiculo resul = null;
		if (electrico) {
			resul = new VehiculoElectrico();
		} else {
			resul = new VehiculoGasolina();
		}
		venta++;
		ventaGlobal++;
		return resul;
	}

}
