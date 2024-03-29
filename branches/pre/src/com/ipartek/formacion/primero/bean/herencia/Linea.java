package com.ipartek.formacion.primero.bean.herencia;


public class Linea extends Figura implements Redimensionable {

	private int longitud;
		
	public Linea(Punto punto) {
		super(punto);	
		setLongitud( LONG_MIN );
	}
 
	
	
	public Linea(Punto punto, int longitud) {
		super(punto);
		setLongitud( longitud );
	}




	public int getLongitud() {
		return longitud;
	}


	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	
	@Override
	void dibujar() {
		for (int i = 0; i < getLongitud() ; i++) {
			System.out.print("=");
		}
		System.out.println();
	}	
	

}
