package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura {

	public static final int LONG_MIN = 1 ; 
	public static final int LONG_MAX = 10 ; 
	
	private int longitud;
	
	public Linea(int x, int y) {
		super(x, y);
		setLongitud(LONG_MIN);
		
	}

	
	public Linea(int x, int y, int longitud) {
		super(x, y);
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
