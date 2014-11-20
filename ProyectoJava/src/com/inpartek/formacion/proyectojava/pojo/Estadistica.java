package com.inpartek.formacion.proyectojava.pojo;

import java.util.GregorianCalendar;

public class Estadistica {
    private int regLeido;
    private GregorianCalendar tiempo;
    private int regCorrecto;
    private int regIncorrecto;
    private int regEstadistica;

    public Estadistica(final int regLeido, final GregorianCalendar tiempo,
	    final int regCorrecto, final int regIncorrecto,
	    final int regEstadistica) {
	super();
	this.regLeido = regLeido;
	this.tiempo = tiempo;
	this.regCorrecto = regCorrecto;
	this.regIncorrecto = regIncorrecto;
	this.regEstadistica = regEstadistica;
    }

    public int getRegLeido() {
	return regLeido;
    }

    public void setRegLeido(final int regLeido) {
	this.regLeido = regLeido;
    }

    public GregorianCalendar getTiempo() {
	return tiempo;
    }

    public void setTiempo(final GregorianCalendar tiempo) {
	this.tiempo = tiempo;
    }

    public int getRegCorrecto() {
	return regCorrecto;
    }

    public void setRegCorrecto(final int regCorrecto) {
	this.regCorrecto = regCorrecto;
    }

    public int getRegIncorrecto() {
	return regIncorrecto;
    }

    public void setRegIncorrecto(final int regIncorrecto) {
	this.regIncorrecto = regIncorrecto;
    }

    public int getRegEstadistica() {
	return regEstadistica;
    }

    public void setRegEstadistica(final int regEstadistica) {
	this.regEstadistica = regEstadistica;
    }

}
