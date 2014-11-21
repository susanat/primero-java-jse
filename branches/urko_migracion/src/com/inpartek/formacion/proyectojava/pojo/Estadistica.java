package com.inpartek.formacion.proyectojava.pojo;

/**
 * Clase que agrupa los datos necesarios para cargar las estadisticas del
 * proyecto
 *
 * @author Urko Villanueva
 *
 */
public class Estadistica {
    private int regLeido;
    private long tiempo;
    private int regCorrecto;
    private int regIncorrecto;
    private int regduplicado;

    public Estadistica() {
	super();
	this.regLeido = 0;
	this.regCorrecto = 0;
	this.regIncorrecto = 0;
	this.regduplicado = 0;
	this.tiempo = 0;
    }

    /**
     *
     * @param pregLeido
     * @param pregCorrecto
     * @param pregIncorrecto
     * @param pregduplicado
     */
    public Estadistica(final int pregLeido, final int pregCorrecto,
	    final int pregIncorrecto, final int pregduplicado) {
	super();
	this.regLeido = pregLeido;
	this.regCorrecto = pregCorrecto;
	this.regIncorrecto = pregIncorrecto;
	this.regduplicado = pregduplicado;
	this.tiempo = 0;
    }

    /**
     *
     * @param pregLeido
     * @param ptiempo
     * @param pregCorrecto
     * @param pregIncorrecto
     * @param pregEstadistica
     */
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

    /**
     * función que se encarga de calcular el tiempo en milisengundos en el
     * formato hh:mm
     *
     * @return el tiempo {@code String} en el formato deseado
     */
    public String calculateTime() {
	final int minutes = (int) (tiempo / (60 * 1000));
	final int seconds = (int) (tiempo / 1000 % 60);
	final String str = String.format("%d:%02d", minutes, seconds);

	return str;
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
