package com.inpartek.formacion.proyectojava.pojo;


public class Estadistica {
	private int regLeido;
	private long tiempo;
	private int regCorrecto;
	private int regIncorrecto;
	private int regduplicado;

	public Estadistica(final int pregLeido, final int pregCorrecto,
			final int pregIncorrecto, final int pregduplicado) {
		super();
		this.regLeido = pregLeido;
		this.regCorrecto = pregCorrecto;
		this.regIncorrecto = pregIncorrecto;
		this.regduplicado = pregduplicado;
	}

	public Estadistica(final int pregLeido, final long ptiempo,
			final int pregCorrecto, final int pregIncorrecto,
			final int pregEstadistica) {
		super();
		this.regLeido = pregLeido;
		this.tiempo = ptiempo;
		this.regCorrecto = pregCorrecto;
		this.regIncorrecto = pregIncorrecto;
		this.regduplicado = pregEstadistica;
	}

	public int getRegCorrecto() {
		return regCorrecto;
	}

	public int getRegduplicado() {
		return regduplicado;
	}

	public int getRegIncorrecto() {
		return regIncorrecto;
	}

	public int getRegLeido() {
		return regLeido;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setRegCorrecto(final int pregCorrecto) {
		this.regCorrecto = pregCorrecto;
	}

	public void setRegduplicado(final int pregduplicado) {
		this.regduplicado = pregduplicado;
	}

	public void setRegIncorrecto(final int pregIncorrecto) {
		this.regIncorrecto = pregIncorrecto;
	}

	public void setRegLeido(final int pregLeido) {
		this.regLeido = pregLeido;
	}

	public void setTiempo(final long ptiempo) {
		this.tiempo = ptiempo;
	}

}
