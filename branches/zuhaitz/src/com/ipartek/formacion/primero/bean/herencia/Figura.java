package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase abstracta para realizar las tareas en común de sus hijas
 * 
 * @author Curso
 *
 */
public abstract class Figura {

	// Atributos
	private int x;
	private int y;

	// Constructor
	public Figura(int x, int y) {
		super();
		setX(x);
		setY(y);
	}

	// Getters & Setters
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

	// Métodos
	/**
	 * Mueve una Figura de su posición actual a la nueva
	 * 
	 * @param x
	 *            posición x a mover
	 * @param y
	 *            posición y a mover
	 * @return true si la Figura se ha movido, false en caso contrario
	 */
	public boolean mover(int x, int y) {
		boolean res = true;
		if (getX() == x && getY() == y) {
			res = false;
		}
		return res;
	}

	/**
	 * Dibuja por pantalla la Figura
	 */
	public abstract void dibujar();

}
