package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase Abstracta para realizar las tareas en común de sus hijos
 * @author Mario Alvaro
 *
 */
public abstract class Figura {
	
	//atributos
	int x;
	int y;
	
	//constructor
	public Figura(int x, int y) {
		super();
		setX(x);
		setY(y);
	}
	
	//getter y setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	//metodo implementado
	/**
	 * Mueve una <code>Figura</code> de su posicion actual a la nueva
	 * @param x posicion x a mover
	 * @param y posicion y a mover
	 * @return true si es movida la <code>Figura</code>, false en caso contrario
	 */
	boolean mover(int x, int y){
		boolean resul = false;
		if ( ( getX() == x ) && ( getY() == y ) ) {
			resul = true;
		}
		return resul;
	}
	
	//metodo abstracto

	/**
	 * Dibuja por pantalla la <code>Figura</code>
	 */
	abstract void dibujar();
	
}















