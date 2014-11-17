package com.ipartek.formacion.primero.bean.herencia;

public class CocheElectrico implements Ordenable {

	private int potencia;

	public CocheElectrico(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public int getPeso() {
		return potencia;
	}

}
