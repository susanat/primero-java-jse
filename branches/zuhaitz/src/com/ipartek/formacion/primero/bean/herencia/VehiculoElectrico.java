package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoElectrico extends Vehiculo implements Arrancable,
		Ordenable {
	// Atributos
	private float capacidadBaterias;

	/**
	 * Capacidad mínima para una batería.
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

	public VehiculoElectrico(final float potencia) {
		// super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(potencia);
	}

	// Getters y setters
	@Override
	public void setPotencia(final float potencia) {
		super.setPotencia(potencia);
	}

	public float getCapacidadBaterias() {
		return capacidadBaterias;
	}

	public void setCapacidadBaterias(final float capacidadBaterias) {
		this.capacidadBaterias = capacidadBaterias;
	}

	// Métodos
	@Override
	public String toString() {
		return "VehiculoElectrico [capacidadBaterias=" + capacidadBaterias
				+ ", numPlazas=" + numPlazas + ", dimensiones=" + dimensiones
				+ ", potencia=" + potencia + "]";
	}

	@Override
	public final boolean arrancar() {
		return true;
	}

	@Override
	public final float getPeso() {
		return super.getPotencia();
	}

}
