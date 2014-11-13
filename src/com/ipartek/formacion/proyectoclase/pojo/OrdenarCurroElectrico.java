package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Comparator;

public class OrdenarCurroElectrico implements Comparator<IOrdenable> {

	@Override
	public int compare(IOrdenable o1, IOrdenable o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.getPeso(), o2.getPeso());
	}

}
