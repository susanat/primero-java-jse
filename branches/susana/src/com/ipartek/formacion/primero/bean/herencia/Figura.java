package com.ipartek.formacion.primero.bean.herencia;

/**
 * Una clase abstracta para realizar las tareas en común de sus hijoa
 * 
 * @author Susana Costoya
 *
 */

public abstract class Figura {

	// Atributos
	Punto punto;

	// int x;
	// int y;

	// Constructor
	public Figura() {
		super();
		setPunto(new Punto());
	}

	public Figura(Punto punto) {
		super();
		setPunto(punto);
	}

	// Getter y Setter

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	/**
	 * Mueve una figuara de su posicion actual a la nueva
	 * 
	 * @param x
	 *            posicion x a mover
	 * @param y
	 *            posicion y a mover
	 * @return true si es movida la figura, false en caso contrario
	 */

	// metodo implementado
	boolean mover(Punto punto) {
		// TODO comparar objeto completo con Equals, en ve de comparar los
		// atributos
		boolean resul = false;
		if ((punto.getX() == this.punto.getX())
				&& (punto.getY() == this.punto.getY())) {
			resul = false;
		}
		return resul;
	}

	// metodo abstracto

	/**
	 * Dibuja por pantalla la figura
	 */
	abstract void dibujar();

	/**
	 * Clase interna para trabajar con coordenadas x e y
	 */

	//TODO Recordar que un fichero (*.java) puede contener más de una clase, pero sólo una puede ser public.
	// protected => solo para los hijos
	protected class Punto {

		int x;
		int y;

		Punto() {
			this.x = 0;
			this.y = 0;
		}

		Punto(int x, int y) {
			this.x = 0;
			this.y = 0;
		}

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
	}

}
