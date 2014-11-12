package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase Abstracta para realizar las tareas en común de sus hijos
 * 
 * @author Mario Alvaro
 *
 */
public abstract class Figura {
	
	// atributos
	// int x;
	// int y;
	public static final int ORIGEN_X = 0 ; 
	public static final int ORIGEN_Y = 0 ; 
	
	Punto punto;
	
	
	// constructor
	public Figura() {
		super();
		punto = new Punto();
	}
	public Figura(Punto punto) {
		super();
		setPunto(punto);
	}
	
	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	// metodo implementado
	/**
	 * Mueve una <code>Figura</code> de su posicion actual a la nueva
	 * 
	 * @param x
	 *            posicion x a mover
	 * @param y
	 *            posicion y a mover
	 *            
	 * @return true si es movida la <code>Figura</code>, false en caso contrario
	 */
	boolean mover(int x, int y) {
		// TODO comparar objeto completo con equals, en vez de comparar los
		// atributos
		boolean resul = false;
		if ((punto.getX() == this.punto.x) && (punto.getY() == this.punto.y)) {
			resul = true;
		}
		return resul;
	}

	// metodo abstracto

	/**
	 * Dibuja por pantalla la <code>Figura</code>
	 */
	abstract void dibujar();

	/**
	 * Clase interna para trabajar con coordenadas X e Y
	 * 
	 * @author Mario Alvaro
	 *
	 */
	protected class Punto {
		int x;
		int y;

		protected Punto() {
			this.x = ORIGEN_X;
			this.y = ORIGEN_Y;
		}

		protected Punto(int x, int y) {
			setX(x);
			setY(y);
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
