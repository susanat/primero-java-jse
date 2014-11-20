package com.ipartek.formacion.migracion.streams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CrearFicheroTexto {

	public CrearFicheroTexto() {

	}

	// public static void main(String[] args) {
	/**
	 * Creamos un fichero donde guardamos las lineas de las personas que se
	 * pasan por parametros
	 *
	 * @param nombreFichero
	 *            {@code string} que contiene el nombre del fichero donde se va
	 *            a guardar la linea
	 * @param linea
	 *            {@code string} que contiene la linea con los datos de la
	 *            persona
	 */

	public static void fichero(String nombreFichero, String linea) {

		Writer writer = null;
		// FileOutputStream ficheroTexto = null;
		// OutputStreamWriter outputStream = null;
		// File archivo = new File(nombreFichero);

		try {
			// Creamos el nombre y extension del fichero
			// ficheroTexto = new FileOutputStream(nombreFichero);

			// declaramos un Stream para escribir
			// pasamos como parametros el fichero a escribir y su Charset
			// outputStream = new OutputStreamWriter(ficheroTexto, "utf-8");

			// objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(new FileWriter(nombreFichero, true));
			// if (archivo.exists()) {

			// escribir en el fichero a traves del writer
			writer.append(linea);
			// writer.write(linea);
			// }

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void duplicados(String nombreFichero, String linea) {

		Writer writer = null;

		try {

			// objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(new FileWriter(nombreFichero, true));

			// escribir en el fichero a traves del writer
			writer.append(linea);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void estadisticas(String nombreFichero, String linea) {

		Writer writer = null;

		try {

			// objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(new FileWriter(nombreFichero, true));

			// escribir en el fichero a traves del writer
			writer.append(linea);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
