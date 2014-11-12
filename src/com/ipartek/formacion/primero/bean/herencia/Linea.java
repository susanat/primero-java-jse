package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura implements Redimensionable {

	// Atributos

	private int longitud;

	// Constructores

	public Linea(int x, int y) {
		super(x, y);
		this.setLongitud(LONG_MIN);

	}

	public Linea(int x, int y, int longitud) {
		super(x, y);
		this.setLongitud(longitud);
	}

	// Getters y setters

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	@Override
	void dibujar() {
		for (int i = 0; i < this.getLongitud(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}

}
