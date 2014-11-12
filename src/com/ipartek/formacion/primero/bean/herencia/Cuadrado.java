/**
 * 
 */
package com.ipartek.formacion.primero.bean.herencia;

/**
 * @author Fran
 *
 */
public class Cuadrado extends Figura implements Redimensionable {
	
	private int cara; //longitud de la cara del cuadrado
	
	/**
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



	public int getCara() {
		return cara;
	}

	public void setCara(int cara) {
		this.cara = cara;
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.primero.bean.herencia.Figura#dibujar()
	 */
	@Override
	void dibujar() {
		System.out.println("Soy un caudrado");

	}

}
