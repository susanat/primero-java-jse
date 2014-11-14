package com.ipartek.formacion.primero.bean.interfaces;

import java.util.Comparator;

public interface IOrdenable {

	public float getPeso();

	/**
	 * Clase que implementa la interfaz Comparator para poder ordenar Interfaces
	 * de tipo Ordenable por el peso (calorias de Churro y Potencia de Vehiculo
	 * electrico)
	 *
	 * @author Joseba Carrión Blanco
	 *
	 */

	public class comparatorPeso implements Comparator<IOrdenable> {
		// TODO: Crear esta clase en un fichero externo
		@Override
		public int compare(IOrdenable o1, IOrdenable o2) {

			return (Float.compare(o1.getPeso(), o2.getPeso()));
		}

	}
}
