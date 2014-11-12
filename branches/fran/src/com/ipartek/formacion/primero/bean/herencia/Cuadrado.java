package com.ipartek.formacion.primero.bean.herencia;

public class Cuadrado extends Figura implements Redimensionable{
	private int cara;
	
	
	public int getCara() {
		return cara;
	}

	public void setCara(int cara) {
		this.cara = cara;
	}

	public Cuadrado(Punto p, int cara) {
		super(p);
		setCara(cara);
	}

	public Cuadrado(int cara) {
		super();
		this.cara = cara;
	}

	@Override
	public void dibujar() {
		//Deberia ir el codigo de dibujar un cuadrado pero esta el de linea
		for (int i = 0; i < cara; i++) {
			System.out.print('=');
		}
		System.out.println();
	}


}
