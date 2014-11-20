package com.ipartek.formacion.migracion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * La clase <code>Migracion</code> es la encargada de ejecutar la aplicación,
 * ordenadar los repetidos y crear las estadisticas de la ejecución. Contiene:
 * <ol>
 * <li>CORRECTOS {@code HashMap<String, Persona>}</li>
 * <li>ERRONEOS {@code HashMap<String, Persona>}</li>
 * <li>REPETIDOS_DNI {@code  ArrayList<String>}</li>
 * </ol>
 *
 * @author Mario Alvaro
 *
 */
public class Migracion {
    // atributos

    public static HashMap<String, Persona> CORRECTOS;
    public static HashMap<String, Persona> ERRONEOS;
    public static ArrayList<String> REPETIDOS_DNI;

    /**
     * Método main para ejecutar el programa
     *
     * @param args
     */
    public static void main(String[] args) {
	// Inicializamos los HashMap donde se guardar las lineas correctas,
	// erroneas y repetidas
	CORRECTOS = new HashMap<String, Persona>();
	ERRONEOS = new HashMap<String, Persona>();
	REPETIDOS_DNI = new ArrayList<String>();

	// Si hubiera algun archivo llamado de esa manera, se borran los
	// ficheros ya creados
	Fichero.remove(Rutas.NOM_FICHERO_CORRECTO);
	Fichero.remove(Rutas.NOM_FICHERO_ERRONEO);
	Fichero.remove(Rutas.NOM_FICHERO_REPETIDOS);
	Fichero.remove(Rutas.NOM_FICHERO_ESTADISTICAS);

	// Guardamos el tiempo de ejecucion. Para ello guardamos en milisegundo
	// el tiempo de comienzo
	long time_start, time_end, total_time;
	time_start = System.currentTimeMillis();

	// Ejecutamos la lectura del fichero de entrada (dado por el cliente)
	Fichero.read(Rutas.NOM_FICHERO_ENTRADA);

	// Una vez reorganizado los datos, ordenamos los repetidos
	Collections.sort(REPETIDOS_DNI);
	String contenidoMensaje = Utilidades.convertirRepetidos();
	Fichero.escribirMensaje(Rutas.NOM_FICHERO_REPETIDOS, contenidoMensaje);

	// Finaliza el tiempo de ejecución y se calcula el tiempo total
	time_end = System.currentTimeMillis();
	total_time = time_end - time_start;

	// Creamos las estadisticas y su fichero
	contenidoMensaje = Utilidades.crearEstadisticas(total_time);
	Fichero.escribirMensaje(Rutas.NOM_FICHERO_ESTADISTICAS,
		contenidoMensaje);

    }

}
