package com.ipartek.formacion.proyectoclase.pojo.herencia;

import java.util.Comparator;

/**
 * @author Urko Villanueva
 *
 */
public class Vehiculo implements Comparable<Vehiculo> {
    /**
	 *
	 */
    protected Integer numPlazas;
    /**
	 *
	 */
    protected Double dim;
    /**
	 *
	 */
    protected Double potencia;

    // constantes
    /**
	 *
	 */
    public static final int MIN_PLAZAS = 2;
    /**
	 *
	 */
    public static final double MIN_DIM = 50.0;
    /**
	 *
	 */
    public static final double MIN_POTENCIA = 50.0;

    /**
	 *
	 */
    public Vehiculo() {
	super();
	setNumPlazas(Vehiculo.MIN_PLAZAS);
	setDim(Vehiculo.MIN_DIM);
	setPotencia(Vehiculo.MIN_POTENCIA);
    }

    public Vehiculo(final Double potencia) {
	this();
	setPotencia(potencia);
    }

    public Vehiculo(final Integer numPlazas) {
	this();
	setNumPlazas(numPlazas);
    }

    public Vehiculo(final Double potencia, final Integer numPlazas) {
	this();
	setPotencia(potencia);
	setNumPlazas(numPlazas);
    }

    @Override
    public String toString() {
	return "Vehiculo [numPlazas=" + numPlazas + ", dim=" + dim
		+ ", potencia=" + potencia + "]";
    }

    @Override
    public int compareTo(final Vehiculo v) {
	// TODO Auto-generated method stub
	return Double.compare(this.getPotencia(), v.getPotencia());
    }

    public Integer getNumPlazas() {
	return numPlazas;
    }

    public void setNumPlazas(final Integer numPlazas) {
	this.numPlazas = numPlazas;
    }

    public Double getDim() {
	return dim;
    }

    public void setDim(final Double pdim) {
	this.dim = pdim;
    }

    public Double getPotencia() {
	return potencia;
    }

    public void setPotencia(final Double ppotencia) {
	this.potencia = ppotencia;
    }

    public static class ComparatorNumeroPlazas implements Comparator<Vehiculo> {

	@Override
	public int compare(final Vehiculo o1, final Vehiculo o2) {
	    // TODO Auto-generated method stub
	    return Integer.compare(o1.getNumPlazas(), o2.getNumPlazas());
	}

    }
}
