package com.ipartek.formacion.proyectoclase.pojo.herencia;

import java.awt.Point;

public class Cuadrado extends Figura implements IRedimensionable {
	/**
	 * 
	 */
	private Integer lado;
	/**
	 * 
	 * @param p
	 */
	public Cuadrado(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param p
	 * @param lado
	 */
	public Cuadrado(Point p, Integer lado) {
		super(p);
		this.lado = lado;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getLado() {
		return lado;
	}
	/**
	 * 
	 * @param lado
	 */
	public void setLado(Integer lado) {
		this.lado = lado;
	}
	/**
	 * 
	 */
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		lVertical();
		lHorizontal();
	}
	/**
	 * 
	 */
	private void lVertical() {
		
	}
	/**
	 * 
	 */
	private void lHorizontal() {
		
	}

}
