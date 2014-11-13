package com.ipartek.formacion.proyectoclase.pojo.herencia;

import java.awt.Point;

/**
 * Es una clase que aglutina los diferentes tipos de poligonos
 * 
 * @author Urko Villanueva
 *
 */
public abstract class Figura {
	/**
 *
 */
	private Punto p;

	public Figura() {
		setP(new Punto());
	}

	/**
	 * 
	 * @param p
	 *            {@code Point}
	 */
	public Figura(Punto p) {
		super();
		this.p = p;
	}

	/**
	 * @return p {@code Point}
	 */
	public Punto getP() {
		return p;
	}

	/**
	 * @param p
	 */
	public void setP(Punto p) {
		this.p = p;
	}

	// metodo implementado
	/**
	 * Mueve una figura de la posición actual a la nueva
	 * 
	 * @param p
	 *            {@code Point} posicion de destino
	 * @return exito {@code Boolean} si se ha realizado con exito
	 */
	public boolean mover(Point p) {
		boolean exito = false;

		if (!p.equals(getP())) {
			exito = true;
			System.out.println(" Movido el objeto a la posicion [" + p.getX()
					+ "," + p.getY() + "]");
		}
		return exito;
	}

	/**
	 *
	 */
	public abstract void dibujar();

	/**
	 *
	 * @author Urko Villanueva
	 *
	 */
	public class Punto {
		private int x;
		private int y;

		/**
		 *
		 */
		public Punto() {
			this.x = 0;
			this.y = 0;
		}

		public Punto(int x, int y) {
			this.x = x;
			this.y = y;
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

		@Override
		public boolean equals(Object point) {
			if (point instanceof Punto) {
				if (((Punto) point).getX() == this.x
						&& ((Punto) point).getY() == this.y) {
					return true;
				}
			}
			return false;
		}

	}
}
