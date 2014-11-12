package com.ipartek.formacion.primero.bean.herencia;

/** 
 * Clase abstracta para englobar las caracteristicas comunes de las figuras geometricas
 * @author Fran
 *
 */
public abstract class Figura {
	Punto punto;
	
	public Figura() {
		super();
		setPunto(new Punto());
	}
	
	public Figura(Punto punto) {
		super();
		this.punto = punto;
	}

	public Punto getPunto() {
		return punto;
	}
	
	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	
	//Método implementado
	/**
	 * Funcion que deberia mover, tiene apaño
	 * @param x coordenada x
	 * @param y coordenada y
	 * @return true siempre, esta con apaño
	 */
	public boolean mover(Punto punto){
		boolean resul = true;
		return resul;
	}
	
	//Método abstracto
	/**
	 * Funcion que deberia dibujar una figura, declaracion abstracta
	 */
	public abstract void dibujar();
	
	/**
	 * Clase interna para trabajar con coordenadas x e y
	 * @author Fran
	 *
	 */
	protected class Punto {
		int x;
		int y;
		
		protected Punto() {
			this.x = 0;
			this.y = 0;
		}
		
		protected Punto(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}
}
