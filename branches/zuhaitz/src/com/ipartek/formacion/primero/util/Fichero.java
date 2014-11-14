package com.ipartek.formacion.primero.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Fichero {

	/**
	 * Crea un fichero de texto con codificación UTF-8
	 *
	 * @param nombreFichero
	 *            path + nombre + extensión, ej: filename.txt
	 * @param contenido
	 *            contenido a escribir en el fichero
	 * @return true si se crea el fichero, false en caso contrario
	 */
	public static boolean create(String fileName, String content) {
		boolean res = false;
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileName), "utf-8"));
			writer.write(content);
			res = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return res;
	}

	public static boolean remove(String fileName) {
		boolean res = false;
		try {
			File file = new File(fileName);
			res = file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
