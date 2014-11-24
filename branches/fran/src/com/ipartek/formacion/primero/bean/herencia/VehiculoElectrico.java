package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase que representa un vehiculo electrico, extiende de la clase vehiculo
 * 
 * @author Fran
 *
 */
public class VehiculoElectrico extends Vehiculo implements Arrancable,
Ordenable, Cloneable {
	private float capacidadBaterias;
	/**
	 * Capacidad de batería mínima que debe tener un vehículo eléctrico
	 */
	public static final float MIN_BATERIAS = 0f;
	/**
	 * Potencia mínima que debe tener un vehículo eléctrico
	 */
	public static final float MIN_POTENCIA = 150f;

	public VehiculoElectrico() {
		super();
		setCapacidadBaterias(MIN_BATERIAS);
		setPotencia(MIN_POTENCIA);
	}

	public VehiculoElectrico(float potencia) {
		super(potencia);
		setCapacidadBaterias(MIN_BATERIAS);
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
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @see com.ipartek.formacion.primero.bean.herencia.Ordenable#getPeso()
	 */
	@Override
	public float getPeso() {
		float resul = getPotencia();
		return resul;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
