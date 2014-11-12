package com.ipartek.formacion.primero.bean;

import java.util.Comparator;

public class Churro implements Comparable<Churro>, Comparator<Churro> {

	private Double caloria;

	public Churro() {
		super();
	}

	public Churro(Double caloria) {
		super();
		this.caloria = caloria;
	}

	@Override
	public int compareTo(Churro o) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public int compare(Churro o1, Churro o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Double getCaloria() {
		return caloria;
	}

	public void setCaloria(Double caloria) {
		this.caloria = caloria;
	}

}
