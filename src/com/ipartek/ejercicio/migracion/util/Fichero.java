package com.ipartek.ejercicio.migracion.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ipartek.ejercicio.migracion.Constantes;
import com.ipartek.ejercicio.migracion.Persona;

public class Fichero {

    public static final int ESCRIBIR_EN_CORRECTO = 1;
    public static final int ESCRIBIR_EN_ERROR = 0;
    public static final int NO_ESCRIBIR = -1;

    /**
     * Leer fichero linea por linea y mostrarlo por pantalla
     *
     * @param nombreFichero
     *            path + nombre del fichero
     */
    public static void read(String nombreFichero) {
	BufferedReader br = null; // Buffer para mejorar la lectura, es
	// opcional, mnejora el rendimiento
	FileReader reader = null;
	List<String> lista = new ArrayList<String>();

	// Variables para calcular estadisticas
	int registrosLeidos = 0;
	int numCorrectos = 0;
	int numErrores = 0;
	Date fechaInicio = new Date();

	try {

	    String sCurrentLine; // Variable que contiene las lineas del fichero
	    reader = new FileReader(nombreFichero);// Stream de lectura

	    br = new BufferedReader(reader); // Asociamos el buffer al string

	    while ((sCurrentLine = br.readLine()) != null) {

		int escribir = NO_ESCRIBIR;

		// Vamos controlando el numero de registros leidos para nuestras
		// estadisticas
		registrosLeidos = registrosLeidos + 1;

		// Separamos los valores y los guardamos en una lista
		lista = separarValores(sCurrentLine);

		// Comprobamos que la lista tenga el numero de atributos
		// correctos
		if (lista.size() != 7) {
		    // Numero de atributos incorrecto, directamente a error

		    WritetoFileStringBuilder(Constantes.FICHERO_ERROR, lista);
		    escribir = NO_ESCRIBIR;
		    numErrores = numErrores + 1;

		} else {
		    // Numero de atributos correcto. Construimos una persona
		    // para ver si ciertos atributos (edad, dni y mail) son
		    // validos mediante los setters invocados por su constructor
		    try {
			Persona p1 = new Persona(lista.get(0), lista.get(1),
				lista.get(2), Integer.parseInt(lista.get(3)),
				lista.get(4), lista.get(5), lista.get(6));
			// Si llegamos aqui es que la persona es correcta la
			// marcamos como correcta
			escribir = ESCRIBIR_EN_CORRECTO;
			numCorrectos = numCorrectos + 1;
		    } catch (Exception ex) {
			System.out.println(ex.getMessage());
			// Es una linea erronea, debe ir al fichero de error

			// obtenemos el mensaje de error de la excepcion lanzada
			lista = new ArrayList<String>(lista);
			lista.add(ex.getMessage());
			escribir = ESCRIBIR_EN_ERROR;
			numErrores = numErrores + 1;
		    }

		}
		// Escribimos las lineas a los ficheros correspondientes
		if (escribir == ESCRIBIR_EN_CORRECTO) {
		    // la linea es correcta, escribimos a personas-correctas.txt
		    WritetoFileStringBuilder(Constantes.FICHERO_CORRECTO, lista);
		    escribir = NO_ESCRIBIR;
		} else if (escribir == ESCRIBIR_EN_ERROR) {
		    // La linea es incorrecta, escribimos a
		    // personas-incorrectas.txt
		    WritetoFileStringBuilder(Constantes.FICHERO_ERROR, lista);
		    escribir = NO_ESCRIBIR;
		}
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (br != null) {
		    br.close();
		    Date dateFinal = new Date();
		    // Escribimos en el fichero de estadisticas

		    writeStatistics(Constantes.FICHERO_ESTADISTICAS,
			    registrosLeidos, numCorrectos, numErrores,
			    fechaInicio, dateFinal);

		}
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}

    }

    /**
     * Funcion que separa los valores de cada linea del fichero que estan entre
     * comas y crea una Lista con los valores
     *
     * @param linea
     * @return List
     */
    public static List<String> separarValores(String linea) {
	List<String> valoresPersona = new ArrayList<String>();
	valoresPersona = Arrays.asList(linea.split(","));
	return valoresPersona;
    }

    /**
     * Funcion que crea un fichero vacio
     *
     * @param nombreFichero
     * @return un boolean que indica si la creacion del fichero fue exitoso o no
     */
    public static boolean crearFichero(String nombreFichero) {
	boolean creadoCorrecto = false;
	FileOutputStream fichero = null;
	try {
	    fichero = new FileOutputStream(nombreFichero);
	    creadoCorrecto = true;
	    fichero.close();
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	    creadoCorrecto = false;

	}

	return creadoCorrecto;
    }

    public static boolean WritetoFileStringBuilder(String nombreFichero,
	    List lista) {
	boolean resul = false;
	Writer writer = null;
	FileOutputStream fichero = null;
	OutputStreamWriter outputStream = null;
	BufferedWriter buffer = null;
	StringBuilder sb = new StringBuilder();

	try {
	    // Creamos el nombrey extension del fichero
	    fichero = new FileOutputStream(nombreFichero, true);

	    // declaramos un stream para escribir. Pasamos como parametros el
	    // fichero a escribir y el charset
	    outputStream = new OutputStreamWriter(fichero, "utf-8");

	    // Creamos un bufer intermedio (opcional) para mejorar el
	    // rendimiento
	    buffer = new BufferedWriter(outputStream);

	    // Asignamos el bufer al writer

	    writer = buffer;

	    // Creamos lo que vamos a escribir en el fichero
	    // sb.append
	    for (int i = 0; i < lista.size(); i++) {
		sb.append(lista.get(i) + " ");
	    }
	    sb.append("\n");

	    // Escribimos lo que queramos en el fichero

	    writer.write(sb.toString());

	    resul = true;
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	    resul = false;
	} finally {
	    try {
		writer.close();
		buffer.close();
	    } catch (Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	    }
	}
	return resul;

    }

    public static boolean writeStatistics(String nombreFichero,
	    int registrosLeidos, int numCorrectos, int numErrores,
	    Date dateInicio, Date dateFinal) {
	boolean resul = false;
	Writer writer = null;
	FileOutputStream fichero = null;
	OutputStreamWriter outputStream = null;
	BufferedWriter buffer = null;
	StringBuilder sb = new StringBuilder();

	Date duracion = new Date(dateFinal.getTime() - dateInicio.getTime());
	DateFormat formato = new SimpleDateFormat("mm:ss");

	try {
	    // Creamos el nombrey extension del fichero
	    fichero = new FileOutputStream(nombreFichero, true);

	    // declaramos un stream para escribir. Pasamos como parametros el
	    // fichero a escribir y el charset
	    outputStream = new OutputStreamWriter(fichero, "utf-8");

	    // Creamos un bufer intermedio (opcional) para mejorar el
	    // rendimiento
	    buffer = new BufferedWriter(outputStream);

	    // Asignamos el bufer al writer

	    writer = buffer;

	    // Creamos lo que vamos a escribir en el fichero
	    // sb.append

	    sb.append("Numero de registros leídos: " + registrosLeidos + "\n");
	    sb.append("Duracion del proceso: " + formato.format(duracion)
		    + "\n");
	    sb.append("Correctos: " + numCorrectos + "\n");
	    sb.append("Errores: " + numErrores + "\n");

	    // Escribimos lo que queramos en el fichero

	    writer.write(sb.toString());

	    resul = true;
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	    resul = false;
	} finally {
	    try {
		writer.close();
		buffer.close();
	    } catch (Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	    }
	}
	return resul;

    }
}
