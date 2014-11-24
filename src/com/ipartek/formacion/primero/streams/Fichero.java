package com.ipartek.formacion.primero.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.ipartek.formacion.primero.util.Fecha;
import com.ipartek.formacion.primero.util.Idioma;

/**
 * Clase para trabajar con ficheros
 * 
 * @author Fran
 *
 */
public class Fichero {

	/**
	 * Crear un fichero
	 * 
	 * @param fichero
	 *            nombre del fichero
	 * @param contenido
	 *            es lo que se graba en el fichero
	 * @return true si se a creado correctamente, false en cc
	 */
	public boolean create(String fichero, String contenido) {
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
	 * Borrar un fichero
	 * 
	 * @param fichero
	 *            nombre del fichero a borrar
	 * @return true si se ha borrado correctamente, false en cc
	 */
	public boolean delete(String fichero) {
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
	 * Leer un fichero y mostrar el contenido por pantalla
	 * 
	 * @param fichero
	 *            nombre del fichero
	 */
	public void read(String fichero) {
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

	/**
	 * Dibuja la estructura de carpetas y archivos a partir de una ruta dada.
	 * 
	 * @param path
	 *            Ruta de la estructura de carpetas.
	 */
	public void dibujarCarpetas(String path, String sep) {
		String separador = "  " + sep;
		File archivo = new File(path);
		if (archivo.isDirectory()) {
			System.out.println(separador + "+" + archivo.getName());
			String[] subArchivos = archivo.list();
			for (int i = 0; i < subArchivos.length; i++) {
				dibujarCarpetas(path + "/" + subArchivos[i], "|" + separador);
			}
		} else {
			System.out
			.println(separador
							+ "-"
							+ archivo.getName()
					+ " "
					+ archivo.length()
							+ " Bytes"
					+ " "
					+ Fecha.getString(archivo.lastModified(),
							Idioma.CASTELLANO));
		}
	}

	/**
	 * Elimina un directorio y todo su contenido
	 * 
	 * @param directory
	 * @return
	 */
	public boolean deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
		return (directory.delete());
	}
}
