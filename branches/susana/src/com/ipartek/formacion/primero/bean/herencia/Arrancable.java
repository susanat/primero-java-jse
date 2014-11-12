package com.ipartek.formacion.primero.bean.herencia;

/**
 * Interface para dotar a los objetos del metodo arrancar
 * @author Susana Costoya
 *
 */

public interface Arrancable {
	
	
	/**
	 * Nos indica si el Objeto esta arrancado - tambien podria estar vacia o con CONSTANTES 
	 * @return true si arranca, false en caso contrario
	 */
	boolean arrancar();

}
