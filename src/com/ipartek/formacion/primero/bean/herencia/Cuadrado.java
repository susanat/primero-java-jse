package com.ipartek.formacion.primero.bean.herencia;

public class Cuadrado extends Figura implements Redimensioable {

	// atributos
	private int cara; // longitud del lado del cuadrado

	// constructor

	/**
	 *
	 * @param x
	 * @param y
	 */
	public Cuadrado(Punto punto) {

		super(punto);
		setCara(LONG_MIN);
	}

	public Cuadrado(Punto punto, int cara) {
		super(punto);
		setCara(cara);
	}

	// getters y setters
	public int getCara() {
		return cara;
	}

	public void setCara(int cara) {
		this.cara = cara;
	}

	@Override
	void dibujar() {
		for (int i = 0; i < cara; i++) {
			System.out.println("=");
		}
		System.out.println();

	}

}
