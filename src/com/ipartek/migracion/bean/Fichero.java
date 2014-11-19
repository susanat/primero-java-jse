package com.ipartek.migracion.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Tratamiento de fichero.
 * 
 * @author Fran
 *
 */
public class Fichero {

	/**
	 * Crear un fichero.
	 * 
	 * @param fichero
	 *            nombre del fichero.
	 * @param contenido
	 *            contenido a escribir en el fichero.
	 * @return true si se a creado correctamente, false en cc.
	 */
	public boolean create(final String fichero, final String contenido) {
		boolean isCreated = false;
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fichero), "utf-8"));
			writer.write(contenido);
			isCreated = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return isCreated;
	}

	/**
	 * Borrar un fichero.
	 * 
	 * @param fichero
	 *            nombre del fichero a borrar.
	 * @return true si se ha borrado correctamente, false en cc.
	 */
	public boolean delete(final String fichero) {
		boolean isDelete = false;
		try {
			File file = new File(fichero);
			isDelete = file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDelete;
	}

	/**
	 * Leer un fichero y mostrar el contenido por pantalla.
	 * 
	 * @param fichero
	 *            nombre del fichero.
	 */
	public void read(final String fichero) {
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fichero));
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
}
