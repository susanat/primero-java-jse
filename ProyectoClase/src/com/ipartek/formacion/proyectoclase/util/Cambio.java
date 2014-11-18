package com.ipartek.formacion.proyectoclase.util;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Cambio es una clase java se encarga de calcular las vueltas a una cantidad de
 * dinero para una factura determinada
 * 
 * @author Urko Villanueva
 *
 */

public class Cambio {
	/**
	 * Coleccion cambios es un <code>TreeMap<Double,Integer></code> ordenado a
	 * la inversa que tiene como indices los valores de monedas y billetes como
	 * valor el numero de monedas y/o billetes que se van a devolver
	 */
	private TreeMap<Double, Integer> cambios;
	/**
	 * Valor en euros de la moneda minima
	 */
	private final static int MONEDA_MINIMA = 2;

	/**
	 * Inicializa el valor del Map de los cambios con los valores de monedas y
	 * billetes
	 */
	public Cambio() {
		super();
		iniValor();
	}

	/**
	 * Calcula los billetes y monedas devuletos de cambio
	 * 
	 * @param d_entregado
	 *            {@code Double} dinero entregado
	 * @param coste
	 *            {@code Double} coste de la compra
	 * 
	 */
	public void calcularVueltas(Double dentregado, Double coste) {

		Double dinero = 0.0;

		MyMath.compruebaMayor(dentregado);
		MyMath.compruebaMayor(coste);

		dinero = dentregado - coste;
		for (Map.Entry<Double, Integer> entry : cambios.entrySet()) {
			Double index = entry.getKey();
			Integer valor = entry.getValue();
			valor = calcularNumero(dinero, index);
			cambios.put(index, valor);
			dinero = MyMath.round(calcularRestante(dinero, index), 2);
		}
	}

	/**
	 * Muestra los datos por pantalla diferenciando de monedas y billetes
	 */
	public void mostrarCambios() {
		for (Map.Entry<Double, Integer> entry : cambios.entrySet()) {
			Double index = entry.getKey();
			Integer valor = entry.getValue();

			if (index > MONEDA_MINIMA)
				System.out.println("En " + valor + " Billetes de " + index);
			else
				System.out.println("En " + valor + " Monedas de " + index);
		}
	}

	private void iniValor() {
		cambios = new TreeMap<Double, Integer>(Collections.reverseOrder());
		final double B_50 = 50.0, B_20 = 20.0, B_10 = 10.0, B_5 = 5.0, M_2 = 2.0, M_1 = 1.0;
		final double M_05 = 0.5, M_02 = 0.2, M_01 = 0.1, M_005 = 0.05, M_002 = 0.02, M_001 = 0.01;

		cambios.put(B_50, 0);
		cambios.put(B_20, 0);
		cambios.put(B_10, 0);
		cambios.put(B_5, 0);
		cambios.put(M_1, 0);
		cambios.put(M_2, 0);
		cambios.put(M_05, 0);
		cambios.put(M_02, 0);
		cambios.put(M_01, 0);
		cambios.put(M_005, 0);
		cambios.put(M_002, 0);
		cambios.put(M_001, 0);
	}

	/**
	 *
	 * @param dinero
	 * @param valor
	 * @return
	 */
	private Integer calcularNumero(Double dinero, Double valor) {
		Integer numero = 0;
		numero = (int) (dinero / valor);
		return numero;
	}

	/**
	 * Calcular el dinero restante para un dinero y u
	 * 
	 * @param dinero
	 *            {@code}
	 * @param valor
	 *            {@code}
	 * @return devuelve
	 */
	private Double calcularRestante(Double dinero, Double valor) {
		Double resto = 0.0;
		resto = dinero % valor;
		return resto;
	}

	/**
	 * Obtener los cambios totales
	 * 
	 * @return {@code TreeMap} de {@code <Double,Integer>} con las vueltas
	 * @see observar la constante MONEDA_MINIMA
	 */
	public TreeMap<Double, Integer> getCambios() {
		return cambios;
	}

}
