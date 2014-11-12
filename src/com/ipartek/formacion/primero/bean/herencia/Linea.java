package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura implements Redimensionable {

	private int longitud;

	public Linea(Punto punto) {
		super(punto);
		setLongitud(LONG_MIN);
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int logitud) {
		this.longitud = logitud;
	}

	@Override
	void dibujar() {
		for (int i = 0; i < getLongitud(); i++) {
			System.out.println("=");
		}
		System.out.println();
	}

}
