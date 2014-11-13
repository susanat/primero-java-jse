package com.ipartek.formacion.primero.bean.herencia;

public class Churro implements Ordenable {

	// Crear array de churros y CocheElectricos para ordenar con la interfaz

	// Atributos
	private int calorias;

	// Constructor
	public Churro() {
		super();
		setCalorias(calorias);
	}

	public Churro(int calorias) {
		super();
		setCalorias(calorias);
	}

	// Getters & Setters
	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	// Métodos
	@Override
	public float getPeso() {
		return getCalorias();
	}

}
