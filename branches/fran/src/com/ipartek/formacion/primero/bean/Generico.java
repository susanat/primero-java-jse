package com.ipartek.formacion.primero.bean;

/**
 * Clase con genéricos.
 * 
 * @author Fran
 *
 * @param <T>
 *            Clase genérica.
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
