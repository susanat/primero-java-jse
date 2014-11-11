package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura {

	// Atributos
	private int longitud;
	
	// Constantes
	public static final int LONG_MIN = 1;
	public static final int LONG_MAX = 10;
	
	
	// Constructores
	public Linea(int x, int y) {
		super(x, y);
		setLongitud(LONG_MIN);
	}

	public Linea(int x, int y, int longitud){
		super(x, y);
		setLongitud(longitud);
	}
	
	// Getters y Setters
	public int getLongitud() {
		return longitud;
	}


	public void setLongitud(int longitud) {
		if (longitud>LONG_MAX){
			this.longitud = LONG_MAX;
		}else{
			if (longitud>LONG_MIN){
				this.longitud = longitud;
			}
		}
	}

	// Metodos
	@Override
	void dibujar() {
		// Se implementa el metodo Dibujar	
	}

}
