/**
 * 
 */
package com.ipartek.formacion.primero.bean.herencia;

/**
 * @author Sergio Rubio Nieto
 *
 */
public class Cuadrado extends Figura implements IRedimensionable {

	private int cara; //longitud de la cara del cuadrado
		
	/**
	 * Get value from cara
	 * @return int
	 */
	public int getCara() {
		return cara;		
	}

	/**
	 * Set value for cara
	 * @param cara
	 */
	public void setCara(int cara) {
		this.cara = cara;
	}

	/**
	 * @param x
	 * @param y
	 */
	public Cuadrado(int x, int y) {
		super(x, y);
		
		this.setCara(LONG_MIN);
	}
	
	/**
	 * @param x
	 * @param y
	 * @param cara
	 */
	public Cuadrado(int x, int y, int cara) {
		super(x, y);
		
		this.setCara(cara);
	}

	/* (non-Javadoc)
	 * @see com.ipartek.formacion.primero.bean.herencia.Figura#dibujar()
	 */
	@Override
	void dibujar() {
		// TODO Auto-generated method stub

	}

}
