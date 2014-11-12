/**
 * 
 */
package com.ipartek.formacion.primero.bean.herencia;

/**
 * @author Maitane Casado
 *
 */
public class Cuadrado extends Figura implements Redimensionable {

	private int cara; //longitud la cara del cauadrado
	
	
	
	/**
	 * @param x
	 * @param y
	 */
	public Cuadrado(Punto pto) {
		super(pto);
		setCara(LONG_MIN);
	}
	
	
	
	
	public Cuadrado(Punto pto, int cara) {
		super(pto);
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
		// TODO Auto-generated method stub

	}

}
