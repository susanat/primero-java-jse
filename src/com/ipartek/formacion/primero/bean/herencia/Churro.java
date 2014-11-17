package com.ipartek.formacion.primero.bean.herencia;

public class Churro implements Ordenable {

	private int calorias;

	public Churro(int calorias) {
		this.calorias = calorias;
	}

	@Override
	public int getPeso() {
		return calorias;
	}

}
