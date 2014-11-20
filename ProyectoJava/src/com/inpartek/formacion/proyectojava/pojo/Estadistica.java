package com.inpartek.formacion.proyectojava.pojo;

import java.util.GregorianCalendar;

public class Estadistica {
	private int regLeido;
	private GregorianCalendar tiempo;
	private int regCorrecto;
	private int regIncorrecto;
	private int regEstadistica;

	public Estadistica(final int pregLeido, final GregorianCalendar ptiempo,
			final int pregCorrecto, final int pregIncorrecto,
			final int pregEstadistica) {
		super();
		this.regLeido = pregLeido;
		this.tiempo = ptiempo;
		this.regCorrecto = pregCorrecto;
		this.regIncorrecto = pregIncorrecto;
		this.regEstadistica = pregEstadistica;
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

	public void setRegCorrecto(final int pregCorrecto) {
		this.regCorrecto = pregCorrecto;
	}

	public void setRegEstadistica(final int pregEstadistica) {
		this.regEstadistica = pregEstadistica;
	}

	public void setRegIncorrecto(final int pregIncorrecto) {
		this.regIncorrecto = pregIncorrecto;
	}

	public void setRegLeido(final int pregLeido) {
		this.regLeido = pregLeido;
	}

	public void setTiempo(final GregorianCalendar ptiempo) {
		this.tiempo = ptiempo;
	}

}
