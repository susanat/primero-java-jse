package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

public interface Ordenable {

	public float getPeso();

	/**
	 * Clase que implementa la interfaz Comparator para poder ordenar Interfaces
	 * de tipo Ordenable por el peso (calorias de Churro y Potencia de Vehiculo
	 * electrico)
	 *
	 * @author Joseba Carrión Blanco
	 *
	 */

	public class comparatorPeso implements Comparator<Ordenable> {

		@Override
		public int compare(Ordenable o1, Ordenable o2) {

			return (Float.compare(o1.getPeso(), o2.getPeso()));
		}

	}
}
