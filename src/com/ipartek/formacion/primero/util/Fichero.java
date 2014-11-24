package com.ipartek.formacion.primero.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fichero {

    /**
     * Crea un fichero de texto con codificacion UTF-8
     *
     * @param nombreFichero
     *            path + nombre del fichero + extension, ej: ./filename.txt
     * @param contenido
     *            contenido a escribir en el fichero
     * @return true si se crea el fichero false en caso contrario
     */

    public static boolean create(String nombreFichero, String contenido) {
	boolean resul = false;
	Writer writer = null;
	FileOutputStream fichero = null;
	OutputStreamWriter outputStream = null;
	BufferedWriter buffer = null;

	try {
	    // Creamos el nombrey extension del fichero
	    fichero = new FileOutputStream(nombreFichero);

	    // declaramos un stream para escribir. Pasamos como parametros el
	    // fichero a escribir y el charset
	    outputStream = new OutputStreamWriter(fichero, "utf-8");

	    // Creamos un bufer intermedio (opcional) para mejorar el
	    // rendimiento
	    buffer = new BufferedWriter(outputStream);

	    // Asignamos el bufer al writer
	    writer = buffer;

	    // Escribimos lo que queramos en el fichero
	    writer.write(contenido);
	    return true;
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
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

    /**
     *
     * @param nombreFichero
     * @param numeroVeces
     * @return
     */
    public static boolean WritetoFile(String nombreFichero, int numeroVeces) {
	boolean resul = false;
	Writer writer = null;
	FileOutputStream fichero = null;
	OutputStreamWriter outputStream = null;
	BufferedWriter buffer = null;
	String contentToWrite = null;

	try {
	    // Creamos el nombrey extension del fichero
	    fichero = new FileOutputStream(nombreFichero);

	    // declaramos un stream para escribir. Pasamos como parametros el
	    // fichero a escribir y el charset
	    outputStream = new OutputStreamWriter(fichero, "utf-8");

	    // Creamos un bufer intermedio (opcional) para mejorar el
	    // rendimiento
	    buffer = new BufferedWriter(outputStream);

	    // Asignamos el bufer al writer

	    writer = buffer;

	    // Creamos lo que vamos a escribir en el fichero
	    for (int i = 0; i < numeroVeces; i++) {
		contentToWrite = contentToWrite + "linea " + i + "\n";
	    }
	    // Escribimos lo que queramos en el fichero

	    writer.write(contentToWrite);

	    return true;
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
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

    /**
     *
     * @param nombreFichero
     * @param numeroVeces
     * @return
     */
    public static boolean WritetoFileStringBuilder(String nombreFichero,
	    int numeroVeces) {
	boolean resul = false;
	Writer writer = null;
	FileOutputStream fichero = null;
	OutputStreamWriter outputStream = null;
	BufferedWriter buffer = null;
	StringBuilder sb = new StringBuilder();

	try {
	    // Creamos el nombrey extension del fichero
	    fichero = new FileOutputStream(nombreFichero);

	    // declaramos un stream para escribir. Pasamos como parametros el
	    // fichero a escribir y el charset
	    outputStream = new OutputStreamWriter(fichero, "utf-8");

	    // Creamos un bufer intermedio (opcional) para mejorar el
	    // rendimiento
	    buffer = new BufferedWriter(outputStream);

	    // Asignamos el bufer al writer

	    writer = buffer;

	    // Creamos lo que vamos a escribir en el fichero
	    for (int i = 0; i < numeroVeces; i++) {
		sb.append("linea " + i + "\n");
	    }
	    // Escribimos lo que queramos en el fichero

	    writer.write(sb.toString());

	    return true;
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
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

	try {

	    String sCurrentLine; // Variable que contiene las lineas del fichero
	    reader = new FileReader(nombreFichero);// Stream de lectura

	    br = new BufferedReader(reader); // Asociamos el buffer al string

	    while ((sCurrentLine = br.readLine()) != null) { // Leemos el
		// fichero linea
		// a linea hasta
		// que lleguemos
		// al final y
		// sea null
		System.out.println(sCurrentLine);
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (br != null) {
		    br.close();
		}
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}

    }

    /**
     * Eliminar fichero
     *
     * @param nombreFichero
     *            path + nombre del fichero
     * @return true si se ha eliminado correctamente, false en caso contrario.
     */
    public static boolean remove(String nombreFichero) {
	boolean resul = false;

	try {
	    File file = new File(nombreFichero);
	    resul = file.delete();
	} catch (Exception ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	}
	return resul;
    }

    /**
     *
     * @param path
     */
    public static void dibujarCarpetas(String path) {

	File root = new File(path);
	File[] list = root.listFiles();
	// Objeto SimpleDateFormat para formatear la fecha como nostros queramos
	SimpleDateFormat formato = new SimpleDateFormat("dd/M/yyyy hh:mm");

	if (list == null)
	    return;

	for (File f : list) {
	    if (f.isDirectory()) {
		System.out.println("+" + f.getName());
		// funcion recursiva
		// Si es directorio tenemos que mirar si hay mas cosas dentro
		dibujarCarpetas(f.getAbsolutePath());

	    } else {
		System.out.println("\t-" + f.getName() + " "
			+ ((f.length() / 1024) / 1024) + " "
			+ formato.format(new Date(f.lastModified())));
	    }
	}
    }
}
