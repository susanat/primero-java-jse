package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;

import com.ipartek.formacion.primero.bean.interfaces.IOrdenable;

public class ComparatorOrdenable implements Comparator<IOrdenable> {

	@Override
	public int compare(IOrdenable o1, IOrdenable o2) {
		return Integer.compare(o1.getPeso(), o2.getPeso());
	}

}
