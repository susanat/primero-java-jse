package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura {

	private int longitud;
	
	public static final int LONG_MIN = 1;
	public static final int LONG_MAX = 10;
	
	public Linea(Punto pto) {
		super(pto);	
		setLongitud(LONG_MIN);
	}
 
	
	
	public Linea(Punto pto, int longitud) {
		super(pto);
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
