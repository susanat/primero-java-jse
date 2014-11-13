/**
 *
 */
package com.ipartek.formacion.primero.bean.herencia;

import com.impartek.formacion.primero.interfaces.Redimensionable;

/**
 *
 * @author Mario Alvaro
 *
 */
public class Cuadrado extends Figura implements Redimensionable {

	private int cara; // longitud de la cara del cuadrado

	/**
	 * @param x
	 * @param y
	 */
	public Cuadrado() {
		super();
		setCara(LONG_MIN);
	}

	public Cuadrado(int x, int y, int cara) {
		super();
		punto.setX(x);
		punto.setY(y);
		setCara(cara);
	}

	// getter y setter
	public int getCara() {
		return cara;
	}

	public void setCara(int cara) {
		this.cara = cara;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ipartek.formacion.primero.bean.herencia.Figura#dibujar()
	 */
	@Override
	void dibujar() {
		System.out.println("Soy un Cuadrado");

	}

}
