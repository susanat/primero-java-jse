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
	 * Crea un fichero de texto con codificación UTF-8.
	 *
	 * @param fileName
	 *            path + nombre + extensión, ej: filename.txt
	 * @param content
	 *            contenido a escribir en el fichero
	 * @return true si se crea el fichero, false en caso contrario
	 */
	public static boolean createFile(final String fileName, final String content) {
		boolean res = false;
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
			writer.write(content);
			res = true;
		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (final Exception ex) {
				ex.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * Elimina el fichero.
	 *
	 * @param fileName
	 *            path + nombre + extensión, ej: filename.txt
	 * @return true si se ha eliminado
	 */
	public static boolean removeFile(final String fileName) {
		boolean res = false;
		try {
			final File file = new File(fileName);
			res = file.delete();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Lee el fichero y lo muestra por consola.
	 *
	 * @param fileName
	 *            path + nombre + extensión, ej: filename.txt
	 */
	public static void readFile(final String fileName) {
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Muestra el árbol de ficheros del path pasado como parámetro
	 *
	 * @param path
	 *            Path
	 * @throws IOException
	 */
	public static void pathTree(final File file) throws IOException {
		final File root = new File(file.getAbsolutePath());
		final File[] aFiles = root.listFiles();

		if (aFiles == null) {
			System.out.println("La ruta especificada está vacía.");
		} else {
			for (final File f : aFiles) {
				if (!f.isDirectory()) {
					System.out.println("\t- " + f.getName() + "\t" + f.length() + " bytes \t"
							+ Fecha.getString(f.lastModified(), Idioma.CASTELLANO));
				} else {
					System.out.println(" + " + f.getName());
					pathTree(f);
				}
			}
		}
	}

	public static void delete(final File root) {
		if (root.isDirectory()) {
			if (root.list().length == 0) {
				root.delete();
			} else {
				final String files[] = root.list();
				for (final String temp : files) {
					final File fileDelete = new File(root, temp);
					delete(fileDelete);
				}

				if (root.list().length == 0) {
					root.delete();
				}
			}
		} else {
			root.delete();
		}
	}

}
