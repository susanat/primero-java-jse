package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoElectrico extends Vehiculo implements Arrancable {
	// Atributos
	private float capacidadBaterias;

	/**
	 * Capacidad m�nima para una bater�a
	 */
	// Constantes
	public static final float MIN_CAP_BATERIA = 1000f;
	public static final float MIN_POTENCIA = 150f;

	// Constructores
	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(MIN_POTENCIA);
	}

	// Getters y setters
	public void setPotencia(float potencia) {
		super.setPotencia(potencia);
	}

	public float getCapacidadBaterias() {
		return capacidadBaterias;
	}

	public void setCapacidadBaterias(float capacidadBaterias) {
		this.capacidadBaterias = capacidadBaterias;
	}

	// M�todos
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

}