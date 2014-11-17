package com.ipartek.formacion.primero.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Fichero {

	/**
	 * Crea un fichero de texto con codificacion "utf-8"
	 *
	 * @param nombreFichero
	 *            - path + nombre + extension --> ej:filename.text
	 *
	 * @param contenido
	 *            - contenido a escribir en el fichero
	 *
	 * @return TRUE si se crea el fichero, FALSE en caso contrario
	 */

	public static boolean create(String nombreFichero, String contenido) {
		boolean resul = false;

		Writer writer = null;
		FileOutputStream ficheroTexto = null;
		OutputStreamWriter outputStream = null;
		try {
			// Creamos el nombre y extension del fichero
			ficheroTexto = new FileOutputStream(nombreFichero);

			// Declaramos un Stream para escribir
			// pasamos como parametros el fichero a escribir y su Charset
			outputStream = new OutputStreamWriter(ficheroTexto, "utf-8");

			// Objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(outputStream);

			// escribir en el fichero a traves del writer
			writer.write(contenido);
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

	/**
	 * Lee el fichero y lo muestra por pantalla
	 *
	 * @param ficherName
	 *            path y nombre del fichero
	 */
	public static void read(String ficherName) {

		BufferedReader br = null; // buffer para mejorar la lectura
		FileReader reader = null;
		try {

			String sCurrentLine; // Para leer las lineas del fichero

			// Crear un Stream de lectura
			reader = new FileReader(ficherName);
			// Asociar el buffer al Stream
			br = new BufferedReader(reader);

			// Bucle para leer linea a linea
			while ((sCurrentLine = br.readLine()) != null) {
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
	 * @param ficheroName
	 *            - path y nombre del fichero
	 *
	 * @return true si es eliminado, false en caso contrario
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

}
