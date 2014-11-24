package com.ipartek.formacion.primero.bean;

/**
 * Clase de tipo Generica
 *
 * @author Mario Alvaro
 *
 * @param <T>
 *            Clase Generica
 */
public class Generico<T> {

    private T atributo;

    // Constructor
    public Generico() {
	super();
    }

    // Getters y setters
    public T getAtributo() {
	return atributo;
    }

    public void setAtributo(T atributo) {
	this.atributo = atributo;
    }

}
