package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase Churro que implementa la interfaz ordenable
 * 
 * @author Joseba Carrión Blanco
 *
 */

public class Churro implements Ordenable {
	private float calorias;

	// Constructor

	public Churro(float calorias) {
		super();
		setCalorias(calorias);
	}

	// Getters y setters

	public float getCalorias() {
		return calorias;
	}

	public void setCalorias(float calorias) {
		this.calorias = calorias;
	}

	@Override
	public float getPeso() {
		return (this.getCalorias());
	}

}
