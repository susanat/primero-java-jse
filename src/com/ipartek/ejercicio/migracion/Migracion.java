package com.ipartek.ejercicio.migracion;

import com.ipartek.ejercicio.migracion.util.Fichero;

public class Migracion {

    public static void main(String[] args) {
	// Creamos los 4 ficheros de output vacios
	Fichero.crearFichero(Constantes.FICHERO_ESTADISTICAS);
	Fichero.crearFichero(Constantes.FICHERO_CORRECTO);
	Fichero.crearFichero(Constantes.FICHERO_ERROR);
	Fichero.crearFichero(Constantes.FICHERO_REPETIDOS);

	// Leemos el fichero de input
	Fichero.read(Constantes.FICHERO_INPUT);

    }
}
