package com.ipartek.formacion.primero.bean;

import com.ipartek.formacion.primero.bean.herencia.Ordenable;

public class Churros implements Ordenable {

	private int calorias;

	public Churros(int calorias) {
		this.calorias = calorias;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	@Override
	public int getPeso() {
		return getCalorias();
	}

}
