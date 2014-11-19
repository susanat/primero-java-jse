package com.ipartek.formacion.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MigracionAlumnos {

    public static void main(final String[] args) {

	/**
	 * comprobamos si existe el fichero
	 */
	if (!(new File("data/personas2.txt")).exists()) {
	    System.out.println("No he encontrado personas2.txt");
	    return;
	}

	/**
	 * lo mostramos por pantalla, para comprobar que funciona la lectura
	 */
	try {

	    // para poder abrir el archivo y leerlo
	    final BufferedReader ficheroAlumno = new BufferedReader(
		    new FileReader(new File("data/personas2.txt")));

	    String linea = null;
	    // creo un array con los campos de cada lineao
	    String[] camposLinea = null;
	    while ((linea = ficheroAlumno.readLine()) != null) {
		System.out.println(linea);
		camposLinea = linea.split(",");

		if (isNumeric(camposLinea[5])) {
		    System.out.println("Si es un numero");
		} else {
		    System.out.println("No es un mumero");
		}
		// System.out.println(camposLinea[3]);
	    }

	    // Cierro el archivo
	    ficheroAlumno.close();

	    /**
	     * Le indicamos que nos muestre una exception sino encuentra el
	     * archivo
	     */
	} catch (final IOException errorDeFichero) {
	    System.out.println("Ha habido problemas con el archivo: "
		    + errorDeFichero.getMessage());
	}

	/**
	 * Separamos el archivo personas2.txt por campos
	 * 
	 */
    }

    private static boolean isNumeric(final String dato) {
	boolean resul = false;
	try {
	    Integer.parseInt(dato);
	    resul = true;
	} catch (final NumberFormatException nfe) {

	}
	return resul;
    }

}
