/**
 * 
 */
package com.ipartek.formacion.primero.bean.herencia;

/**
 * @author Ander Uraga Real
 *
 */
public class Cuadrado extends Figura implements Redimensionable {

	private int cara; //longitud la cara del cauadrado
	
	
	
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




	//getter y setters

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
		System.out.println("Soy un Cuadrado");

	}

}
