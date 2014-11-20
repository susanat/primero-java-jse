package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura implements Redimensionable {

	// Atributos
	private int longitud;
		
	// Constructores
	public Linea(Punto punto) {
		super(punto);
		setLongitud(LONG_MIN);
	}

	public Linea(Punto punto, int longitud){
		super(punto);
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
	/**
	 * Dibuja una linea de '=' con la longitud de la Linea  
	 */
	@Override
	void dibujar() {
		for (int i = 0; i < getLongitud() ; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

}
