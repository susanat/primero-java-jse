package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase Abstracta para realizar las tareas en comun de sus hijos
 * @author Joseba Carrión Blanco
 *
 */

public abstract class Figura {
	
	//Atributos
	Punto punto;
	//private int x;
	//private int y;
	
	//Constructor
	
	public Figura(int x, int y) {
		super();
		setPunto(new Punto(x, y));
	}
	
	
	
	public Figura(Punto punto) {
		super();
		setPunto(punto);
	}
	
	



	//Getters y Setters
	
	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	
	
	
	
	
	//Metodo implementado
	
	
	

	/**
	 * Mueve una figura de su posicion actual a la nueva
	 * @param punto un objeto de la clase Punto que contiene las coordenadas a las que vamos a mover la figura
	 * @return
	 */
	boolean mover(Punto punto){
		boolean resul = false;
		//TODO Comparar objeto completo con equals en vez de comparar los atributos uno por uno
		if(punto.getX() == this.punto.getX() && punto.getY() == this.punto.getY()){
			//No se va a mover
			resul = false;
		}else{
			//Se va a mover
			resul = true;
		}	
		
		return resul;
	}
	
	
	//Metodo abstracto
	
	/**
	 * Dibuja por pantalla la figura
	 */
	abstract void dibujar();
	
	/**
	 * Clase interna para usar las coordenadas x e y
	 * @author Joseba Carrión Blanco
	 *
	 */
	
	protected class Punto{
		
		private int x;
		private int y;
		
		//Constructores
		protected Punto(){
			this.x = 0;
			this.y = 0;
		}
		
		protected Punto(int x, int y){
			this.x = x;
			this.y = y;
		}

		//Getters y Setters
		
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
