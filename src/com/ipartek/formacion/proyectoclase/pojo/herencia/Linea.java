package com.ipartek.formacion.proyectoclase.pojo.herencia;

import java.awt.Point;
/**
 * 
 * @author Urko Villanueva
 *
 */
public class Linea extends Figura implements IRedimensionable{

	private int longitud;
	/**
	 * 
	 * @param p
	 */
	public Linea(Punto p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public Linea(Punto p, int longitud) {
		super(p);
		setLongitud(IRedimensionable.LONG_MIN);
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
