package com.ipartek.formacion.primero.bean.herencia;

public class VehiculoElectrico extends Vehiculo {

	//constantes
	public static final float MIN_CAPACIDAD_BATERIA = 10f;
	public static final float MIN_POTENCIA = 150f;
	
	private float capacidadBaterias;	
	
	public float getCapacidadBaterias() {
		return capacidadBaterias;
	}

	public void setCapacidadBaterias(float capacidadBaterias) {
		this.capacidadBaterias = capacidadBaterias;
	}


	@Override
	public void setPotencia(float potencia) {		
		super.setPotencia(potencia);
	}

	public VehiculoElectrico() {
		super();
		
		this.setPotencia(MIN_POTENCIA);
		this.setCapacidadBaterias(MIN_CAPACIDAD_BATERIA);
	}
	
	public VehiculoElectrico(float capacidadBaterias) {
		super();
		
		this.setPotencia(MIN_POTENCIA);
		this.capacidadBaterias = capacidadBaterias;
	}


	public VehiculoElectrico(int numPlazas, float dimensiones, float potencia, float capacidadBateria) {
		super(numPlazas, dimensiones, potencia);
		
		this.setCapacidadBaterias(capacidadBateria);
		this.setDimensiones(dimensiones);
		this.setPotencia(potencia);
		this.setCapacidadBaterias(capacidadBateria);
	}


	@Override
	public String toString() {
		return "VehiculoElectrico ["
				+ "capacidadBaterias=" + capacidadBaterias	+ ", "
				+ "numPlazas=" + numPlazas + ", "
				+ "dimensiones=" + dimensiones
				+ ", potencia=" + potencia 
				+ "]";
	}

	
	

}
