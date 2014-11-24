package com.ipartek.formacion.primero.bean.herencia;

import com.impartek.formacion.primero.interfaces.Ordenable;

public class VehiculoElectrico extends Vehiculo implements Arrancable,
Ordenable, Cloneable {

    private float capacidadBaterias;

    public static final float MIN_POTENCIA = 150.0f;
    /**
     * Capacidad minima para una bateria
     */
    static public final float MIN_CAP_BATERIA = 0;

    public VehiculoElectrico() {
	super();
	setCapacidadBaterias(MIN_CAP_BATERIA);
	setPotencia(MIN_POTENCIA);
    }

    public VehiculoElectrico(float potencia) {
	super();
	setCapacidadBaterias(MIN_CAP_BATERIA);
	setPotencia(potencia);
    }

    @Override
    public void setPotencia(float potencia) {

	super.setPotencia(potencia);
    }

    public float getCapacidadBaterias() {
	return capacidadBaterias;
    }

    public void setCapacidadBaterias(float capacidadBaterias) {
	this.capacidadBaterias = capacidadBaterias;
    }

    @Override
    public String toString() {
	return "VehiculoElectrico [capacidadBaterias=" + capacidadBaterias
		+ ", numPlazas=" + numPlazas + ", dimensiones=" + dimensiones
		+ ", potencia=" + potencia + "]";
    }

    @Override
    public boolean arrancar() {
	return true;
    }

    @Override
    public int getPeso() {
	return (int) this.potencia;
    }

    @Override
    public VehiculoElectrico clone() throws CloneNotSupportedException {
	return (VehiculoElectrico) super.clone();
    }

}
