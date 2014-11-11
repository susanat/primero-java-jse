package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase Abstracta para realizar las tareas en comun de sus hijos
 * @author Jose A. Perez
 *
 */
public abstract class Figura {
	// Atributos
	int x;
	int y;
	
	// Constructor
	public Figura(int x, int y) {
		super();
		setX(x);
		setY(y);
	}

	// Getters y Setters
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
	

	// metodo implementado
	/**
	 * mueve una Figura de su posicion actual a la nueva
	 * @param x posicion x a mover
	 * @param y posicion y a mover
	 * @return true si es movida la Figura, false eoc
	 */
	public boolean mover (int x, int y){
		boolean resul = true;
		if ((getX() == x) && (getY() == y)){
			resul=false;
		}
		return resul;
	}
	
	// metodo abstracto
	/**
	 * Dibuja por pantalla la Figura
	 */
	abstract void dibujar();
}
