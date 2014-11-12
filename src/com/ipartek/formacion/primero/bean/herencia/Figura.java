package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase abstracta para realizar las tareas en común de sus hijas
 * 
 * @author Curso
 *
 */
public abstract class Figura {

	// Atributos
	private Punto punto;

	// Constructor
	public Figura(Punto punto) {
		super();
		this.punto = punto;
	}

	// Getters & Setters
	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
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
	public boolean mover(Punto punto) {
		boolean res = true;
		if (punto.equals(this.punto)) {
			res = false;
		}
		return res;
	}

	/**
	 * Dibuja por pantalla la Figura
	 */
	public abstract void dibujar();

	/**
	 * Clase interna para dibujar un punto
	 * 
	 * @author Curso
	 *
	 */
	protected class Punto {
		private int x;
		private int y;

		protected Punto() {
			super();
			this.x = 0;
			this.y = 0;
		}

		protected Punto(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		protected int getX() {
			return x;
		}

		protected void setX(int x) {
			this.x = x;
		}

		protected int getY() {
			return y;
		}

		protected void setY(int y) {
			this.y = y;
		}

	}
}
