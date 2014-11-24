package com.ipartek.formacion.primero.bean;

/**
 * Clase de tipo generica por eso <T>
 * 
 * @author Susana Costoya
 *
 * @param <T>
 *            Clase Generica
 */
public class Generico<T> {

    private T atributo;

    // constructor
    public Generico() {
	super();
    }

    // Getter and setters
    public T getAtributo() {
	return atributo;
    }

    public void setAtributo(T atributo) {
	this.atributo = atributo;
    }

}
