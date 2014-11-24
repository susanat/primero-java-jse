package com.ipartek.formacion.primero.bean;

public class Generico<T> {

	private T atributo;

	/**
	 * @return the atributo
	 */
	public T getAtributo() {
		return atributo;
	}

	/**
	 * @param atributo
	 *            the atributo to set
	 */
	public void setAtributo(final T atributo) {
		this.atributo = atributo;
	}

}
