package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase abstracta para realizar las tareas en comun de sus hijos
 * 
 * @author Aritz Tellaeche
 *
 */
public abstract class Figura {

	// atributos
	// int x;
	// int y;
	Punto punto;

	// constructor
	public Figura(Punto punto) {
		super();
		this.punto = punto;
	}

	// setters y getters
	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	// metodo implementado

	/**
	 * mueve una figura de su posicion actual a la nueva
	 * 
	 * @param x
	 *            posicion x a mover
	 * @param y
	 *            posicion y a mover
	 * @return true si es movida la figura, false en caso contrario
	 */
	boolean mover(Punto punto) {
		// TODO comparar objeto completo con equals, en vez de comparar todos
		// los atributos
		boolean resul = false;
		if ((punto.getX() == this.punto.getX())
				&& (punto.getY() == this.punto.getY())) {
			resul = false;
		}
		return resul;
	}

	// metodo abstracto
	/**
	 * dibujar por pantalla la figura
	 */
	abstract void dibujar();

	/**
	 * clase interna para trabajar con coordenadas x y
	 * 
	 * @author Aritz Tellaeche
	 *
	 */
	protected class Punto {

		// atributos
		int x;
		int y;

		// cosntructores
		protected Punto() {
			this.x = 0;
			this.y = 0;
		}

		protected Punto(int x, int y) {
			this.x = x;
			this.y = y;
		}

		// geters y setters
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
