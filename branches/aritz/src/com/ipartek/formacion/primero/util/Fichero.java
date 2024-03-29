package com.ipartek.formacion.primero.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Fichero {

	/**
	 * Crea un fichero de texto con codificacion "utf-8"
	 *
	 * @param nombreFichero
	 *            path + nombreFichero + extension, ej: filename.txt
	 * @param contenido
	 *            contenido a escribir en el fichero
	 * @return true si se crea el fichero, false en caso contrario
	 */
	static boolean create(String nombreFichero, String contenido) {

		boolean resul = false;

		Writer writer = null;
		FileOutputStream ficheroTexto = null;
		OutputStreamWriter outputStreamWriter = null;

		try {

			// creamos el nombre y extension del fichero
			ficheroTexto = new FileOutputStream(nombreFichero);

			// declaramos un stream para escribir
			// pasamos como parametro el fichero a escribir y su charset
			outputStreamWriter = new OutputStreamWriter(ficheroTexto, "utf-8");

			// objeto writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(outputStreamWriter);

			// esto es lo mismo q lo anterior pero simplificao
			// writer = new BufferedWriter(new OutputStreamWriter(new
			// FileOutputStream("filename.txt"),
			// "utf-8"));
			writer.write("Hello world");
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

	public static boolean remove(String ficheroNameTest1) {

		boolean resul = false;

		try {

			File file = new File(ficheroNameTest1);

			resul = file.delete();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return resul;
	}

}
