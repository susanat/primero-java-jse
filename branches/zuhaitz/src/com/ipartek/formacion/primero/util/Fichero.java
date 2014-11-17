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
	 * Crea un fichero de texto con codificación UTF-8
	 *
	 * @param fileName
	 *            path + nombre + extensión, ej: filename.txt
	 * @param content
	 *            contenido a escribir en el fichero
	 * @return true si se crea el fichero, false en caso contrario
	 */
	public static boolean createFile(String fileName, String content) {
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

	/**
	 * Elimina el fichero
	 *
	 * @param fileName
	 *            path + nombre + extensión, ej: filename.txt
	 * @return true si se ha eliminado
	 */
	public static boolean removeFile(String fileName) {
		boolean res = false;
		try {
			File file = new File(fileName);
			res = file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Lee el fichero y lo muestra por consola
	 *
	 * @param fileName
	 *            path + nombre + extensión, ej: filename.txt
	 */
	public static void readFile(String fileName) {
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
