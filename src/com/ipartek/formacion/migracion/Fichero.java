package com.ipartek.formacion.migracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Clase <code>Fichero</code> para abrir, borrar y cerrar los ficheros que se le
 * pasen. Contiene:
 ** <ol>
 * <li>SEPARADOR {@code String}</li>
 * <li>LONGITUD_TOTAL {@code int}</li>
 * <li>NUM_LINEA {@code int}</li>
 * <li>FALTA_ATRIBUTO {@code boolean}</li>
 * <li>MENSAJE {@code String}</li>
 * </ol>
 *
 * @author Mario Alvaro
 *
 */
public class Fichero {

    public static final String SEPARADOR = ",";
    public static final int LONGITUD_TOTAL = 7;
    public static int NUM_LINEA = 0;
    public static boolean FALTA_ATRIBUTO = false;
    public static String MENSAJE = null;

    /**
     * Dada la ruta donde esta el fichero, lo borra.
     *
     * @param ficheroName
     *            - La ruta y el nombre del archivo.
     * @return reusul - TRUE si se ha borrado correctamente, FALSE en caso
     *         contrario.
     *
     */
    public static boolean remove(String ficheroName) {
	boolean resul = false;
	try {
	    File fichero = new File(ficheroName);
	    resul = fichero.delete();

	} catch (Exception ex) {
	    ex.printStackTrace();

	}
	return resul;
    }

    /**
     * Dada la ruta donde está el fichero, lo lee línea a línea.
     *
     * @param nombreFichero
     *            - La ruta y el nombre del archivo.
     */
    public static void read(String nombreFichero) {

	BufferedReader br = null; // buffer para mejorar la lectura
	FileReader reader = null;
	try {

	    String sCurrentLine; // Para leer las lineas del fichero

	    // Crear un Stream de lectura
	    reader = new FileReader(nombreFichero);
	    // Asociar el buffer al Stream
	    br = new BufferedReader(reader);
	    Persona persona;
	    // Bucle para leer linea a linea
	    while ((sCurrentLine = br.readLine()) != null) {
		NUM_LINEA++;
		System.out.println(NUM_LINEA);
		persona = Utilidades.separarResultado(sCurrentLine);
		Comprobar.comprobarYEscribir(persona, sCurrentLine);
		MENSAJE = null;

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
     * Dada la ruta del fichero y el contenido, escribe en un fichero externo
     * dicho contenido.
     *
     * @param nombreFichero
     *            - La ruta y el nombre del archivo.
     * @param contenido
     *            - contenido a escribir.
     * @return resul - TRUE si ha escrito correctamente, FALSE en caso
     *         contrario.
     */
    public static boolean escribirMensaje(String nombreFichero, String contenido) {
	boolean resul = false;

	Writer writer = null;
	FileOutputStream ficheroTexto = null;
	OutputStreamWriter outputStream = null;
	try {
	    File file = new File(nombreFichero);
	    if (!file.exists()) {
		if (file.createNewFile()) {
		    System.out.println("El fichero " + nombreFichero
			    + " se ha creado correctamente");
		} else {
		    System.out.println("No ha podido ser creado el fichero");
		}
	    }

	    // Creamos el nombre y extension del fichero.
	    // El TRUE es para que escriba al final del fichero
	    ficheroTexto = new FileOutputStream(file, true);

	    // Declaramos un Stream para escribir
	    // pasamos como parametros el fichero a escribir y su Charset
	    outputStream = new OutputStreamWriter(ficheroTexto, "utf-8");

	    // Objeto Writer para escribir
	    // mejoramos el rendimiento con un buffer
	    writer = new BufferedWriter(outputStream);

	    // escribir en el fichero a traves del writer
	    writer.write(contenido + "\r\n");
	    resul = true;

	} catch (IOException ex) {
	    ex.printStackTrace();

	} finally {
	    try {
		writer.close();

	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	}

	return resul;
    }

}
