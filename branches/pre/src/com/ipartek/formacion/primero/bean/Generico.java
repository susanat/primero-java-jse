package com.ipartek.formacion.primero.bean;

/**
 * Clase de Tipo Generica
 *
 * @author Ander Uraga Real
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
