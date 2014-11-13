/**
 * 
 */
package com.ipartek.formacion.primero.bean.herencia;

/**
 * Clase de churros
 * 
 * @author Fran
 *
 */
public class Churro implements Ordenable {
	private float calorias;

	public Churro(float calorias) {
		super();
		setCalorias(calorias);
	}

	public float getCalorias() {
		return calorias;
	}

	public void setCalorias(float calorias) {
		this.calorias = calorias;
	}

	/*
	 * @see com.ipartek.formacion.primero.bean.herencia.Ordenable#getPeso()
	 */
	@Override
	public float getPeso() {
		float resul = getCalorias();
		return resul;
	}
}
