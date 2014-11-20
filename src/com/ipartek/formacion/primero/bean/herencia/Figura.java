package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase Abstracta para realizar las tareas en comun de sus hijos
 * @author Jose A. Perez
 *
 */
public abstract class Figura {

	// Atributos
	Punto punto;
	
	
	// Constructor
	public Figura(){
		super();
		this.punto = new Punto();
		
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

	// metodo implementado
	/**
	 * mueve una Figura de su posicion actual a la nueva
	 * @param x posicion x a mover
	 * @param y posicion y a mover
	 * @return true si es movida la Figura, false eoc
	 */
	public boolean mover (Punto punto){
		boolean resul = true;
		// TODO comparar objeto completo con equals, en vez de compara cada uno de sus atributos
		if ((punto.getX() == this.punto.getX()) && (punto.getY() == this.punto.getY())){
			resul=false;
		}
		return resul;
	}
	
	// metodo abstracto
	/**
	 * Dibuja por pantalla la Figura
	 */
	abstract void dibujar();
	
	
	
	
	/**
	 * Clase interna para trabajar con coordenadas x e y
	 * @author Jose A. Perez
	 *
	 */
	protected class Punto{
		// Atributos
		int x;
		int y;
		
		// Constructor
		protected Punto(){
			super();
			this.x=0;
			this.y=0;
		}
		
		protected Punto(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		protected int getX() {
			return x;
		}

		protected void setX(int x) {
			this.x = x;
		}

		protected int getY() {
			return y;
		}

		protected void setY(int y) {
			this.y = y;
		}
	}
}


