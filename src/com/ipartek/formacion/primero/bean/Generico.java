package com.ipartek.formacion.primero.bean;

/**
 * Clase genérica
 * 
 * @author Sergio Rubio Nieto
 *
 * @param <T> Clase genérica
 */
public class Generico<T> {
    
    private T atributo = null;
    
    public Generico(){
	
    }

    public T getAtributo() {
        return atributo;
    }

    public void setAtributo(T atributo) {
        this.atributo = atributo;
    }
    
    

}
