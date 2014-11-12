package com.ipartek.formacion.primero.bean.herencia;


/**
 * Clase Abstracta para realizar las tareas en comun de sus hijos
 * @author Ander Uraga Real
 *
 */
public abstract class Figura {

	// atributos
	Punto punto;

	// int x;
	// int y;

	// constructores
	public Figura() {
		super();
		setPunto(new Punto());
	}

	public Figura(Punto punto) {
		super();
		setPunto(punto);
	}

	// getter y setters

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	// metodo implementado

	/**
	 * Mueve una Figura de su posicion actual a la nueva
	 * 
	 * @param x
	 *            posicion x a mover
	 * @param y
	 *            posicion y a mover
	 * @return true si es movida la Figura, false en caso contrario
	 */
	boolean mover(Punto punto) {
		boolean resul = true;
		// TODO comparar obejto completo con equals, en vez de comparar todos
		// los atributos
		if ((punto.getX() == this.punto.getX())
				&& (punto.getY() == this.punto.getY())) {
			resul = false;
		}
		return resul;
	}

	// metodo abstracto

	/**
	 * Dibuja por pantalla la Figura
	 */
	abstract void dibujar();

	/**
	 * Clase Interna para trabajar con coordenadas X e Y
	 * 
	 */
	
	//TODO Recordar que un fichero (*.java) puede contener más de una clase, pero sólo una puede ser public
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

}
