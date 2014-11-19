package com.ipartek.migracion.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	private FileReader file;
	private BufferedReader br;

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
	 * Abrir el fichero.
	 * 
	 * @param fichero
	 *            nombre del fichero.
	 */
	public void open(final String fichero) {
		try {
			file = new FileReader(fichero);
			br = new BufferedReader(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (br != null) {
				br.close();
			}
			if (file != null) {
				file.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Leer un registro del fichero.
	 * 
	 * @return {@code String} registro leido.
	 */
	public String readReg() {
		String sCurrentLine = "";
		try {
			sCurrentLine = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sCurrentLine;
	}
}
