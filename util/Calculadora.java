package com.ipartek.formacion.vueltasdinero.util;

/**
 * Clase calculadora para calcular las vueltas a devolver tras realizar una
 * compra
 * 
 * @author Maitane Casado Fernandez
 *
 */

public class Calculadora {

	// Atributos

	/**
	 * Array con todos los tipos de billetes y monedas
	 * <ul>
	 * <li>billete de 50€</li>
	 * <li>billete de 20€</li>
	 * <li>billete de 10€</li>
	 * <li>billete de 5€</li>
	 * <li>moneda de 2€</li>
	 * <li>moneda de 1€</li>
	 * <li>moneda de 0.50€</li>
	 * <li>moneda de 0.20€</li>
	 * <li>moneda de 0.10€</li>
	 * <li>moneda de 0.05€</li>
	 * <li>moneda de 0.02€</li>
	 * <li>moneda de 0.01€</li>
	 * 
	 */

	public static final float[] TIPO_MONEDAS = new float[] { 50, 20, 10, 5, 2, 1,
			(float) 0.5, (float) 0.2, (float) 0.1, (float) 0.05, (float) 0.02,
			(float) 0.01 };

	/**
	 * Array vacio en el que se almacenaran el numero de billetes/monedas a
	 * entregar
	 */

	private int[] vueltas;

	// Constructoras

	/**
	 * Constructora vacia del objeto Calculadora
	 */

	public Calculadora() {
		super();
		this.vueltas = new int[TIPO_MONEDAS.length];

	}

	// Getters/setters
	
	/**
	 * 
	 * @return {@code array } de {@code float} con los tipos de monedas y billetes
	 */

	public float[] getMonedas() {
		return TIPO_MONEDAS;
	}

	/**
	 * Obtener las vyueltas calculadas
	 * @return {@code array } de {@code int} con las vueltas
	 * para saber el valor usar variable TIPO_MONEDAS
	 */
	public int[] getVueltas() {
		return vueltas;
	}

	

	// Metodos

	/**
	 * Clacula el dinero de vuelta a entregar tras realizar una compra
	 * 
	 * @param compra
	 *            Total de la compra
	 * @param pagado
	 *            Dinero entregado para realizar el pago
	 */
	public void calcularVueltas(float compra, float pagado) {

		float cambios = pagado - compra;
		

		if (cambios >= 0f) {

			for (int i = 0; i < TIPO_MONEDAS.length; i++) {

				/*
				 * while (TIPO_MONEDAS[i] <= cambios) {
				 * 
				 * vueltas[i]++; cambios = cambios - TIPO_MONEDAS[i];
				 * 
				 * }
				 */

				vueltas[i] = (int) (cambios / TIPO_MONEDAS[i]);
				cambios %= (float) TIPO_MONEDAS[i];

				if (cambios == 0) {
					break;
				}

			}
		} else {
			System.out
					.println("No ha pagado suficiente dinero para realizar su compra");
		}

	}

	/**
	 * Devuelve 1 en positivo si el ob1 es mayor, 1 en negativo si es menor y 0
	 * si son iguales
	 * 
	 * @param obj1
	 * @param obj2
	 * @return un int 
	 */
	public int compararFloat(float obj1, float obj2) {

		int mayor;
		if (obj1 > obj2) {

			mayor = 1;
		}

		else if (obj1 < obj2) {
			mayor = -1;
		}

		else {
			mayor = 0;

		}

		return mayor;
	}

	/**
	 * Pinta el dinero a devolver poniendo el tipo de billete o moneda y el
	 * numero de ellos a entregar
	 */
	public void pintarVueltas() {

		System.out.println("Dinero a entregar: ");

		for (int i = 0; i < TIPO_MONEDAS.length; i++) {
			System.out.println(vueltas[i] + " billetes/moneda de "
					+ TIPO_MONEDAS[i]);
		}

	}

}
