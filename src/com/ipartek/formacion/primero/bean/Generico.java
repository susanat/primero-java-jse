package com.ipartek.formacion.primero.bean;

/**
 * Clase de tipo generico
 *
 * @author Joseba Carrión Blanco
 *
 * @param <T>
 *            Clase generica
 */
public class Generico<T> {

    // Atributos

    private T atributo;

    // Constructores

    public Generico() {
	super();

    }

    // Getters and setters

    public T getAtributo() {
	return atributo;
    }

    public void setAtributo(T atributo) {
	this.atributo = atributo;
    }

}
