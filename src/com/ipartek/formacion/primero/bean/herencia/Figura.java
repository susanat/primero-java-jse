package com.ipartek.formacion.primero.bean.herencia;

/**
 *  Clase abstracta pra realizar las tareas en comun de sus hijos
 * @author Kepa
 *
 */

public abstract class Figura {
	
	//Atributos
	
	Punto punto;
	
	//int x;
	//int y;
	//Constructor
	public Figura(Punto punto) {
		super();
		setPunto(punto);
	}

	public Figura() {
		super();
		setPunto(new Punto());
	}
	//Getters and Setters	
	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	//Metodo implementado
	/**
	 * Mueve una figura de su posicion actual a una nueva
	 * @param x posicion w a mover
	 * @param y posicion y a mover
	 * @return true si es movida la figura, false en caso contrario
	 */
	boolean mover(Punto punto){
		boolean resul = true;
		//TODO comparar objeto completo con equals, en lugar de comparar to
		if ((punto.getX() == this.punto.getX()) &&
			(punto.getY() == this.punto.getY())){
		return resul;
		}
	return resul;
	}
	
	//Metodo abstracto
	/**
	 * Dibuja por pantalla la fuigura
	 * 
	 */
	abstract void dibujar();
	public class Punto{
		
		int x;
		int y;
		
		public Punto(){
			this.x=0;
			this.y=0;
		}
		
		public Punto(int x, int y){
			this.x=0;
			this.y=0;
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