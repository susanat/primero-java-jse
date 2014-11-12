package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura implements Redimensionable {

	// Atributos
	private int longitud;

	// constructores

	public Linea(Punto punto) {
		super(punto);
		setLongitud(LON_MIN);
	}

	public Linea(Punto punto, int longitud) {
		super(punto);
		setLongitud(longitud);
	}

	// getter yu setter
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	@Override
	void dibujar() {
		for (int i = 0; i < getLongitud(); i++) {
			System.out.print("=");
		}
		System.out.println();

	}

}
