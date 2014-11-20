package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

public class ComparatorOrdenable implements Comparator<Ordenable> {

	@Override
	public int compare(Ordenable o0, Ordenable o1) {
		return Integer.compare(o0.getPeso(), o1.getPeso());
	}
}
