package com.ipartek.formacion.primero.bean.herencia;

/**
 * Interfaz para dotar a los objetos del metodo arrancar
 * @author Joseba Carrión Blanco
 *
 */

public interface Arrancable {
	

	/**
	 * Nos indica si el objeto esta arrancado
	 * @return true si arranca; false en caso contrario
	 */
	boolean arrancar();
}
