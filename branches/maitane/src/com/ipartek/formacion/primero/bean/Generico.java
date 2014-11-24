package com.ipartek.formacion.primero.bean;

/**
 * Clase de tipo generica
 * 
 * @author Maitane Casado Fernandez
 *
 * @param <T>
 *            Clase Generica
 */

public class Generico<T> {

	private T atributo;

	public Generico() {
		super();
	}

	public T getAtributo() {
		return atributo;
	}

	public void setAtributo(T atributo) {
		this.atributo = atributo;
	}

}
