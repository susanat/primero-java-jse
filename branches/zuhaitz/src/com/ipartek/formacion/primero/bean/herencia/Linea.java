package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura implements Redimensionable {

	// Atributos
	private int longitud;

	// Constructores
	public Linea(Punto punto) {
		super(punto);
		setLongitud(LONG_MIN);
	}

	public Linea(Punto punto, int longitud) {
		super(punto);
		setLongitud(longitud);
	}

	// Getters & Setters
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	// Métodos
	@Override
	public void dibujar() {
		String str = "";
		for (int i = 0; i < getLongitud(); i++) {
			str = str + "-";
		}
		System.out.println(str);
	}

}
