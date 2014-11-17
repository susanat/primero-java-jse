package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

public class ComparatorOrdenable implements Comparator<Ordenable> {

	@Override
	public int compare(Ordenable o1, Ordenable o2) {
		return Float.compare(o1.getPeso(), o2.getPeso());
	}

}