/**
 *
 */
package com.ipartek.formacion.primero.bean.herencia;

/**
 * @author Maitane Casado Fernandez
 *
 */
public class Churro implements Ordenable {

	// Atributos
	float calorias;

	// Constructoras
	public Churro() {
		super();
	}

	public Churro(int calorias) {
		super();
		this.calorias = calorias;
	}

	// Getter

	public float getCalorias() {
		return calorias;
	}

	// Metodo sobreescrito de la Interface Ordenable

	@Override
	public float getValor() {

		return this.getCalorias();
	}

}
