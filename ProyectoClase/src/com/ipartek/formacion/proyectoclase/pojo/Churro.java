package com.ipartek.formacion.proyectoclase.pojo;

public class Churro implements Comparable<Churro>, IOrdenable {

    private Double caloria;

    public Churro() {
	super();
    }

    public Churro(final Double pcaloria) {
	super();
	this.caloria = pcaloria;
    }

    @Override
    public int compareTo(final Churro o) {
	// TODO Auto-generated method stub
	return Double.compare(this.caloria, o.getCaloria());
    }

    public Double getCaloria() {
	return caloria;
    }

    public void setCaloria(final Double pcaloria) {
	this.caloria = pcaloria;
    }

    @Override
    public Double getPeso() {
	// TODO Auto-generated method stub
	return this.caloria;
    }

}
