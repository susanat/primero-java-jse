package com.ipartek.formacion.proyectoclase.pojo.herencia;

import java.awt.Point;

/**
 * Es una clase que aglutina los diferentes tipos de poligonos
 * @author Urko Villanueva
 *
 */
public abstract class Figura {
/**
 * 
 */
	private Point p;
/**
 * 
 * @param p {@code Point} 
 */
	public Figura(Point p) {
		super();
		this.p = p;
	}
/**
 * @return p {@code Point}
 */
	public Point getP() {
		return p;
	}
/**
 * @param p
 */
	public void setP(Point p) {
		this.p = p;
	}
	//metodo implementado
	/**
	 * Mueve una figura de la posición actual a la nueva
	 * @param p {@code Point} posicion de destino
	 * @return exito {@code Boolean} si se ha realizado con exito
	 */
	public boolean mover(Point p) {
		boolean exito = false;
		if (!p.equals(getP())) {
			exito = true;
			System.out.println(" Movido el objeto a la posicion ["
			 + p.getX() + "," + p.getY() + "]");
		}
		return exito;
	}
	/**
	 * 
	 */
	public abstract void dibujar();
}
