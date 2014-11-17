package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

public interface Ordenable {
	int getPeso();

}

class ComparatorCCE implements Comparator<Ordenable> {

	@Override
	public int compare(Ordenable o1, Ordenable o2) {
		return Integer.compare(o1.getPeso(), o2.getPeso());
	}

}