package com.ipartek.formacion.primero.bean.herencia;

/**
 * Interfaz para dotar a los objetos del metodo arrancar
 *
 * @author Ander Uraga Real
 *
 */
public interface Arrancable {

	static final int VAR = 0;

	/**
	 * Nos indica si el Objeto esta arrancado
	 *
	 * @return true si arranca; false en caso contrario
	 */
	boolean arrancar();
}
