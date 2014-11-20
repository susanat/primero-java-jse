package com.inpartek.formacion.proyectojava.pojo;

import java.util.GregorianCalendar;

public class Estadistica {
	private int regLeido;
	private GregorianCalendar tiempo;
	private int regCorrecto;
	private int regIncorrecto;
	private int regEstadistica;

	public Estadistica(final int _regLeido, final GregorianCalendar _tiempo,
			final int _regCorrecto, final int _regIncorrecto,
			final int _regEstadistica) {
		super();
		this.regLeido = _regLeido;
		this.tiempo = _tiempo;
		this.regCorrecto = _regCorrecto;
		this.regIncorrecto = _regIncorrecto;
		this.regEstadistica = _regEstadistica;
	}

	public int getRegCorrecto() {
		return regCorrecto;
	}

	public int getRegEstadistica() {
		return regEstadistica;
	}

	public int getRegIncorrecto() {
		return regIncorrecto;
	}

	public int getRegLeido() {
		return regLeido;
	}

	public GregorianCalendar getTiempo() {
		return tiempo;
	}

	public void setRegCorrecto(final int regCorrecto) {
		this.regCorrecto = regCorrecto;
	}

	public void setRegEstadistica(final int regEstadistica) {
		this.regEstadistica = regEstadistica;
	}

	public void setRegIncorrecto(final int regIncorrecto) {
		this.regIncorrecto = regIncorrecto;
	}

	public void setRegLeido(final int regLeido) {
		this.regLeido = regLeido;
	}

	public void setTiempo(final GregorianCalendar tiempo) {
		this.tiempo = tiempo;
	}

}
