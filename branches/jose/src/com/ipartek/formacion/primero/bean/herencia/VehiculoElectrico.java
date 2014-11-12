package com.ipartek.formacion.primero.bean.herencia;


public class VehiculoElectrico extends Vehiculo implements Arrancable {

	// Atributos
	private float capacidadBaterias;

	// Constantes
	/**
	 * Capacidad minima para una bateria
	 */
	public static final float MIN_CAP_BATERIA = 0f;
	public static final float MIN_POTENCIA = 150f;

	// Constructor
	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(VehiculoElectrico.MIN_POTENCIA); // NOTA
	}

	public VehiculoElectrico(float potencia) {
		// super() -- si no se indica el SUPER siempre accede al constructor
		// vacio del padre
		setCapacidadBaterias(MIN_CAP_BATERIA);
		setPotencia(potencia);
	}

	// Getters and Setters
	public float getCapacidadBaterias() {
		return capacidadBaterias;
	}

	public void setCapacidadBaterias(float capacidadBaterias) {
		this.capacidadBaterias = capacidadBaterias;
	}

	// Otros
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
