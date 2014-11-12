/**
 * 
 */
package com.ipartek.formacion.primero.bean.herencia;

/**
 * @author Joseba Carrión Blanco
 *
 */
public class Cuadrado extends Figura implements Redimensionable{
	
	private int cara; //Longitud de la cara del cuadrado
	

	/**
	 * @param x
	 * @param y
	 */
	public Cuadrado(int x, int y) {
		super(x, y);
		setCara(LONG_MIN);
	}
	
	
	public Cuadrado(Punto punto){
		super(punto);
		setCara(LONG_MIN);
	}
	

	public Cuadrado(int x, int y, int cara) {
		super(x, y);
		setCara(cara);
	}



	public int getCara() {
		return cara;
	}

	public void setCara(int cara) {
		this.cara = cara;
	}

	/**
	 * Metodo abstracto de la superclase Figura, se debe Implementar en la clase hija
	 */
	@Override
	void dibujar() {
		System.out.println("Soy un cuadrado!!!");

	}

}
