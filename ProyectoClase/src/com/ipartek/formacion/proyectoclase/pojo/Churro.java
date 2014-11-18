package com.ipartek.formacion.proyectoclase.pojo;

public class Churro implements Comparable<Churro>, IOrdenable {

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
		return Double.compare(this.caloria, o.getCaloria());
	}

	public Double getCaloria() {
		return caloria;
	}

	public void setCaloria(Double caloria) {
		this.caloria = caloria;
	}

	@Override
	public Double getPeso() {
		// TODO Auto-generated method stub
		return this.caloria;
	}

}
