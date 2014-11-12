package com.ipartek.formacion.proyectoclase.pojo.herencia;

import java.awt.Point;
/**
 * 
 * @author Urko Villanueva
 *
 */
public class Linea extends Figura {

	private int longitud;
	
	public static final int LONG_MIN = 1;
	public static final int LONG_MAX = 10;
	/**
	 * 
	 * @param p
	 */
	public Linea(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public Linea(Point p, int longitud) {
		super(p);
		setLongitud(longitud);
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		for(int i = 0; i < getLongitud(); i++){
			System.out.print("=");
		}
		System.out.println("");
	}

}
