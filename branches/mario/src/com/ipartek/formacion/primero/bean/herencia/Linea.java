package com.ipartek.formacion.primero.bean.herencia;

import com.impartek.formacion.primero.interfaces.Redimensionable;

public class Linea extends Figura implements Redimensionable {
	
	private int longitud;
	
	public Linea() {
		super();
		setLongitud(LONG_MIN);
	}
	
	public Linea(int x, int y, int longitud) {
		super();
		punto.setX(x);
		punto.setY(y);
		setLongitud(longitud);
	}


	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	

	@Override
	void dibujar() {
		for (int i = 0; i < getLongitud(); i++) {
			System.out.println("=");
		}
	
	}
}
