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
	 * @param nombreFich
	 *            path+nombre+erxtension, ej: filename.txt
	 * @param contenido
	 *            contenido a escribir el en fichero
	 * @return true si se crea el fichero, false em caso contrario
	 */

	static boolean create(String nombreFichero, String contenido) {

		boolean rdo = false;

		Writer writer = null;
		FileOutputStream ficheroTexto = null;
		OutputStreamWriter outPutStream = null;

		try {
			// creamos el nombre y extension del fichero
			ficheroTexto = new FileOutputStream("filename.txt");

			// declaramos un Stream para escribir
			// pasamos como parametros el fichero a escribir y su Charset
			outPutStream = new OutputStreamWriter(ficheroTexto, "utf-8");

			// objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(outPutStream);

			// escribir en el fichero a traves del writer
			writer.write(contenido);
			rdo = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return rdo;

	}

	// metodo para eliminar un fichero
	public static boolean remove(String ficheroName) {
		boolean rdo = false;
		try {

			File file = new File(ficheroName);

			rdo = file.delete();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rdo;
	}

}
