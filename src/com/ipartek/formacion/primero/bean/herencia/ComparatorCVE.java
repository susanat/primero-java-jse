package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

/**
 * Clase para utilizar de comparador entre dos interfaces <code>Ordenable</code>
 * con atributos <code>int</code>
 * 
 * @author Mario Alvaro
 *
 */
public class ComparatorCVE implements Comparator<Ordenable> {

	@Override
	public int compare(Ordenable o1, Ordenable o2) {

		return Integer.compare(o1.getPeso(), o2.getPeso());
	}
}
