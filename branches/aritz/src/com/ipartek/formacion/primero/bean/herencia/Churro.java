package com.ipartek.formacion.primero.bean.herencia;

public class Churro implements Ordenable {

	// atributos
	protected float calorias;

	// constructor
	public Churro() {
		super();
		setCalorias(calorias);
	}

	public Churro(float calorias) {
		super();
		setCalorias(calorias);
	}

	// getters y setters
	public float getCalorias() {
		return calorias;
	}

	public void setCalorias(float calorias) {
		this.calorias = calorias;
	}

	@Override
	public float getPeso() {

		return getCalorias();
	}

}
