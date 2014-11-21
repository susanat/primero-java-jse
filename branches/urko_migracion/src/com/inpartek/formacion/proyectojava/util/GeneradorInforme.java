package com.inpartek.formacion.proyectojava.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inpartek.formacion.proyectojava.exception.PersonaException;
import com.inpartek.formacion.proyectojava.pojo.Estadistica;
import com.inpartek.formacion.proyectojava.pojo.Persona;

/**
 * Es la clase que se encarga de la lectura y de la escritura
 * 
 * @author Urko Villanueva
 *
 */
public final class GeneradorInforme {
    private final static String P_PATTERN = ";";
    private final static String A_PATTERN = ",";

    private final static int NOMBRE_POS = 0;
    private final static int APELLIDO_POS = 1;
    private final static int POBLACION_POS = 2;
    private final static int EDAD_POS = 3;
    private final static int EMAIL_POS = 4;
    private final static int DNI_POS = 5;
    private final static int CATEGORIA_POS = 6;
    private final static int N_CAMPOS = 7;
    private final static String FILE_PATH = new File("").getAbsolutePath()
	    + System.getProperty("file.separator") + "files"
	    + System.getProperty("file.separator");
    private final static String NOMBRE_FICHERO_DATOS = "personas";
    private final static String EXTENSION_FICHERO = "txt";
    private final static String NOMBRE_FICHERO_ERROR = "personas-error";
    private final static String NOMBRE_FICHERO_DUPLICADO = "personas-repetidas";
    private final static String NOMBRE_FICHERO_VALIDO = "personas-correctas";
    private final static String NOMBRE_FICHERO_ESTADISTICAS = "estadisticas";

    private static Estadistica estadistica;
    private static HashMap<String, Persona> datosPersonas;
    private static HashMap<String, Integer> datosRepetidos;
    private static HashMap<String, Persona> datosErroneos;
    private static HashMap<String, Persona> datosCortos;
    private static List<String> errores;

    private GeneradorInforme() {
    }

    private static void init() {
	datosPersonas = new HashMap<String, Persona>();
	datosCortos = new HashMap<String, Persona>();
	errores = new ArrayList<String>();
	datosErroneos = new HashMap<String, Persona>();
	datosRepetidos = new HashMap<String, Integer>();
	estadistica = new Estadistica();
	estadistica.setTiempo(System.currentTimeMillis());
    }

    public static void generarMigracion() throws NumberFormatException,
	    PersonaException {
	init();
	cargarDatos();
	generarDatos();

    }

    private static void cargarDatos() throws NumberFormatException,
	    PersonaException {

	String[] lista = null;

	Persona p = null;
	String contenido = ManejadorFichero.leerFichero(FILE_PATH,
		NOMBRE_FICHERO_DATOS, EXTENSION_FICHERO);

	lista = toLine(contenido);
	for (String s : lista) {
	    p = toPersona(s);
	    if (p != null) {
		if (!isRepeated(p)) {
		    if (p.isTodo()) {
			datosPersonas.put(p.getDni(), p);
		    } else {
			datosCortos.put(p.getDni(), p);
		    }
		} else {
		    int cont = 1;
		    if (datosRepetidos.get(p) != null) {
			cont = datosRepetidos.get(p);
			cont++;
		    }

		    datosRepetidos.put(p.getDni(), cont);

		}
	    }
	}
	estadistica = new Estadistica(lista.length, datosPersonas.size(),
		datosCortos.size() + datosErroneos.size() + errores.size(),
		datosRepetidos.size());
    }

    private static void gArchivoDatosFaltan() {
	final String ENCABEZADO = "PERSONAS DE LAS QUE FALTAN DATOS:";
	Persona value = null;

	ManejadorFichero.addTexttoFile(ENCABEZADO, FILE_PATH,
		NOMBRE_FICHERO_ERROR, EXTENSION_FICHERO);
	for (Map.Entry<String, Persona> entry : datosCortos.entrySet()) {
	    value = entry.getValue();
	    ManejadorFichero.addTexttoFile(value.toFileString(), FILE_PATH,
		    NOMBRE_FICHERO_ERROR, EXTENSION_FICHERO);
	}
    }

    private static void gArchivoDatosInvalido() {
	final String ENCABEZADO = "PERSONAS DE LAS QUE TIENEN LOS DATOS MAL ESCRITOS:";
	Persona value = null;

	ManejadorFichero.addTexttoFile(ENCABEZADO, FILE_PATH,
		NOMBRE_FICHERO_ERROR, EXTENSION_FICHERO);

	for (Map.Entry<String, Persona> entry : datosErroneos.entrySet()) {
	    value = entry.getValue();
	    ManejadorFichero.addTexttoFile(value.toFileString(), FILE_PATH,
		    NOMBRE_FICHERO_ERROR, EXTENSION_FICHERO);
	}

    }

    private static void gArchivoDniInvalido() {
	final String ENCABEZADO = "PERSONAS CON DNI MAL INTRODUCIDO (POSICIÓN O TAMAÑO INCORRECTO):";

	ManejadorFichero.addTexttoFile(ENCABEZADO, FILE_PATH,
		NOMBRE_FICHERO_ERROR, EXTENSION_FICHERO);

	for (String s : errores) {
	    ManejadorFichero.addTexttoFile(s, FILE_PATH, NOMBRE_FICHERO_ERROR,
		    EXTENSION_FICHERO);
	}

    }

    private static void gDatosArchivoCorrecto() {
	Persona value = null;

	for (Map.Entry<String, Persona> entry : datosPersonas.entrySet()) {
	    value = entry.getValue();
	    ManejadorFichero.addTexttoFile(value.toFileString(), FILE_PATH,
		    NOMBRE_FICHERO_VALIDO, EXTENSION_FICHERO);
	}

    }

    private static void gDatosArchivoDuplicado() {

	String key = null;
	Integer value = null;
	Persona p = null;

	for (Map.Entry<String, Integer> entry : datosRepetidos.entrySet()) {
	    key = entry.getKey();
	    value = entry.getValue();
	    p = datosPersonas.get(key);
	    ManejadorFichero.addTexttoFile(p.toFileString() + "\t\t\t\t\t\t"
		    + value, FILE_PATH, NOMBRE_FICHERO_DUPLICADO,
		    EXTENSION_FICHERO);
	}

    }

    private static void gDatosArchivoError() {
	// datos_erroneos;

	gArchivoDniInvalido();
	gArchivoDatosFaltan();
	gArchivoDatosInvalido();
    }

    private static void gDatosArchivoEstadistica() {
	long timeEnd = System.nanoTime();
	long difference = (long) ((timeEnd - estadistica.getTiempo()) / 1e6);
	estadistica.setTiempo(difference);
	ManejadorFichero.addTexttoFile(
		"Registros leidos" + "\t" + estadistica.getRegLeido(),
		FILE_PATH, NOMBRE_FICHERO_ESTADISTICAS, EXTENSION_FICHERO);
	ManejadorFichero.addTexttoFile(
		"Minutos Segundos" + "\t" + estadistica.calculateTime(),
		FILE_PATH, NOMBRE_FICHERO_ESTADISTICAS, EXTENSION_FICHERO);
	ManejadorFichero.addTexttoFile(
		"Correctos" + "\t" + estadistica.getRegCorrecto(), FILE_PATH,
		NOMBRE_FICHERO_ESTADISTICAS, EXTENSION_FICHERO);
	ManejadorFichero.addTexttoFile(
		"Erroneos" + "\t" + estadistica.getRegIncorrecto(), FILE_PATH,
		NOMBRE_FICHERO_ESTADISTICAS, EXTENSION_FICHERO);
	ManejadorFichero.addTexttoFile(
		"Duplicados" + "\t" + estadistica.getRegduplicado(), FILE_PATH,
		NOMBRE_FICHERO_ESTADISTICAS, EXTENSION_FICHERO);
    }

    private static void gEncabezadoArchivoCorrecto() {
	final String ENCABEZADO = "PERSONAS";

	ManejadorFichero.crearArchivoTexto(ENCABEZADO, FILE_PATH,
		NOMBRE_FICHERO_VALIDO, EXTENSION_FICHERO);
	ManejadorFichero.addTexttoFile("", FILE_PATH, NOMBRE_FICHERO_VALIDO,
		EXTENSION_FICHERO);
    }

    private static void gEncabezadoArchivoDuplicado() {
	final String ENCABEZADO = "PERSONA\t\t\t\t\t\t\tN VECES";

	ManejadorFichero.crearArchivoTexto(ENCABEZADO, FILE_PATH,
		NOMBRE_FICHERO_DUPLICADO, EXTENSION_FICHERO);
	ManejadorFichero.addTexttoFile("", FILE_PATH, NOMBRE_FICHERO_DUPLICADO,
		EXTENSION_FICHERO);
    }

    private static void gEncabezadoArchivoError() {
	final String ENCABEZADO = "PERSONAS CON ERRORES EN SUS ARCHIVOS";
	ManejadorFichero.crearArchivoTexto(ENCABEZADO, FILE_PATH,
		NOMBRE_FICHERO_ERROR, EXTENSION_FICHERO);
	ManejadorFichero.addTexttoFile("", FILE_PATH, NOMBRE_FICHERO_ERROR,
		EXTENSION_FICHERO);
    }

    private static void gEncabezadoArchivoEstadisticas() {
	final String ENCABEZADO = "ESTADISTICAS";
	ManejadorFichero.crearArchivoTexto(ENCABEZADO, FILE_PATH,
		NOMBRE_FICHERO_ESTADISTICAS, EXTENSION_FICHERO);
	ManejadorFichero.addTexttoFile("", FILE_PATH,
		NOMBRE_FICHERO_ESTADISTICAS, EXTENSION_FICHERO);
    }

    private static void generarDatos() {
	gEncabezadoArchivoError();
	gDatosArchivoError();
	gEncabezadoArchivoCorrecto();
	gDatosArchivoCorrecto();
	gEncabezadoArchivoDuplicado();
	gDatosArchivoDuplicado();
	gEncabezadoArchivoEstadisticas();
	gDatosArchivoEstadistica();
    }

    private static boolean isRepeated(final Persona p) {
	boolean repeated = false;
	if (datosPersonas.containsKey(p.getDni())
		|| datosErroneos.containsKey(p.getDni())) {
	    repeated = true;
	}
	return repeated;
    }

    private static String[] toLine(final String pline) {
	String[] list = null;
	list = pline.split(P_PATTERN);

	return list;
    }

    private static Persona toPersona(final String text) throws PersonaException {

	Persona persona = null;
	String[] list = null;
	list = text.split(A_PATTERN);

	if (UtilValidacion.validarDNI(list[DNI_POS])) {
	    if (list.length == N_CAMPOS) {
		persona = validarDatos(list);
	    } else {
		persona = new Persona(list[DNI_POS]);
	    }
	} else {
	    errores.add(text);
	}

	return persona;
    }

    private static Persona validarDatos(final String[] list)
	    throws NumberFormatException, PersonaException {
	Persona p = new Persona(list[DNI_POS]);
	p.setTodo(true);
	p.setNombre(list[NOMBRE_POS]);
	p.setApellido(list[APELLIDO_POS]);
	p.setPoblacion(list[POBLACION_POS]);
	p.setCategoria(list[CATEGORIA_POS]);
	if (UtilValidacion.edadIsValid(list[EDAD_POS])) {
	    p.setEdad(Integer.parseInt(list[EDAD_POS]));
	} else {
	    p.setTodo(false);
	}
	if (UtilValidacion.validarEmail(list[EMAIL_POS])) {
	    p.setEmail(list[EMAIL_POS]);
	} else {
	    p.setTodo(false);
	}
	return p;
    }
}
