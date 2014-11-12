package com.ipartek.formacion.primero.bean.herencia;

public class Linea extends Figura implements Redimensionable {

	private int longitud;
	
	
public Linea(Punto punto) {
		super(punto);
	}



public Linea(Punto punto, int longitud) {
	super(punto);
	this.longitud = longitud;
}

	@Override
	void dibujar() {
		// TODO Auto-generated method stub
		for(int i=0;i<getLongitud();i++){
			
			System.out.print('=');
		}
		System.out.println();
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	

}
