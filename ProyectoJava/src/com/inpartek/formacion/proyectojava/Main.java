package com.inpartek.formacion.proyectojava;

import com.inpartek.formacion.proyectojava.exception.PersonaException;
import com.inpartek.formacion.proyectojava.util.GeneradorInforme;

public class Main {
    /***
     * Es donde empieza el hilo de ejecución del programa
     *
     * @param args
     *            {@code String} es la cadena de caracteres que carga todo
     *            programa
     * @throws NumberFormatException
     * @throws PersonaException
     * @see PersonaException
     */
    public static void main(final String[] args) throws NumberFormatException,
	    PersonaException {
	final GeneradorInforme ejercicio = new GeneradorInforme("d:/",
		"personas", "txt");
	ejercicio.cargarDatos();

	ejercicio.generarDatos();
    }
}
