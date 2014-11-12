package com.ipartek.formacion.primero.bean.herencia;

public class Cuadrado extends Figura implements Redimensionable {

	// Atributos
	private int cara; // Longitud de la cara del cuadrado

	// Constructores
	public Cuadrado(Punto punto) {
		super(punto);
		setCara(LONG_MIN);
	}

	public Cuadrado(Punto punto, int cara) {
		super(punto);
		setCara(cara);
	}

	// Getters & Setters
	public int getCara() {
		return cara;
	}

	public void setCara(int cara) {
		this.cara = cara;
	}

	// Métodos
	@Override
	public void dibujar() {

	}

}
