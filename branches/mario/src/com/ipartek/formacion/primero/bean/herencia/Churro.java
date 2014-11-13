package com.ipartek.formacion.primero.bean.herencia;

import com.impartek.formacion.primero.interfaces.Ordenable;

public class Churro implements Ordenable {

	String tipo;
	int calorias;

	public Churro(String tipo, int calorias) {
		super();
		this.tipo = tipo;
		this.calorias = calorias;
	}

	// Getter y setter
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	@Override
	public int getPeso() {

		return this.calorias;
	}

}
