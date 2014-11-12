package com.ipartek.formacion.primero.bean.herencia;

/**
 * clase abstracta para realizar las tareas en comun de sus hijos
 * 
 * @author Curso
 *
 */
public abstract class Figura {
	// int x;
	// int y;

	Punto punto;

	protected class Punto {
		int x;
		int y;

		protected Punto() {
			this.x = 0;
			this.y = 0;
		}

		protected Punto(int x, int y) {
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

	public Figura() {
		super();
		setPunto(new Punto());
	}

	public Figura(Punto punto) {
		super();
		this.punto = punto;
	}

	// metodo implementado

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	/**
	 * retorna true si es movida la figura, false en caso contrario.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	boolean mover(Punto punto) {
		boolean resul = true;
		// TODO comparar objeto completo con equals, en vez de comparar todos
		// los atributos
		if (punto.getX() == this.punto.getX()
				&& punto.getY() == this.punto.getY()) {
			resul = false;
		}
		return resul;
	}

	// metodo abstracto
	/**
	 * dibuja por pantalla la figura
	 */
	abstract void dibujar();
}
