package com.ipartek.formacion.primero.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Fichero {

	/**
	 * Crea un fichero de texto con codificacion "utf-8"
	 *
	 * @param nombreFichero
	 *            path + nombre + extension, ej: filename.txt
	 * @param contenido
	 *            contenido a escribir en el fichero
	 *
	 * @return true si se crea el fichero, false en caso contrario
	 */
	static public boolean create(String nombreFichero, String contenido) {
		boolean resul = false;
		Writer writer = null;
		FileOutputStream ficheroTexto = null;
		OutputStreamWriter outputStream = null;
		try {
			// Creamos el nombre y extension del fichero
			ficheroTexto = new FileOutputStream(nombreFichero);
			// declaramos un Stream para escribir
			// pasamos como parametros el fichero a escribir y su Charset
			outputStream = new OutputStreamWriter(ficheroTexto, "utf-8");
			// objeto Writer para escribir
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
	 * @param ficheroName
	 *            path y nombre del fichero
	 */
	public static void read(String ficheroName) {
		BufferedReader br = null; // buffer para mejorar la lectura
		FileReader reader = null;
		try {
			// para leer las lineas del fichero
			String sCurrentLine;

			// Crear Stream de lectura
			reader = new FileReader(ficheroName);
			// asociar el buffer al Stream
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

	public static void writeFile(String fichName, ArrayList<String> contenido) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fichName,
					true));
			for (int i = 0; i < contenido.size(); i++) {
				out.write(contenido.get(i));
			}

			out.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Eliminar Fichero
	 *
	 * @param ficheroName
	 *            path y nombre del fichero
	 * @return true si es eliminado, false en caso contrario
	 */
	public static boolean remove(String ficheroName) {
		boolean resul = false;
		try {
			File file = new File(ficheroName);
			resul = file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;

	}

	/**
	 * Metodo para listar por pantalla una carpeta con los ficheros que tiene
	 * dentro
	 *
	 * @param path
	 *            path del directorio a listar
	 */

	public static void listarCarpeta(File directory) {
		// comprobar que exista
		if (directory.exists()) {
			// obtener todos los path hijos de este directorio
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					// es un direcotorio
					if (files[i].isDirectory()) {
						mostrarFichero(files[i]);
						listarCarpeta(files[i]); // llamada recursiva
						// es un fichero
					} else {
						// mostrar por pantalla
						mostrarFichero(files[i]);
					}
				}
			}
		}
	}

	private static void mostrarFichero(File ficheroPintar) {
		if (ficheroPintar.isDirectory()) {
			System.out.println("+" + ficheroPintar.getName());
		} else {
			System.out.println("\t"
					+ ficheroPintar.getName()
					+ " "
					+ ficheroPintar.length()
					+ " bytes "
					+ Fecha.getString(ficheroPintar.lastModified(),
							Idioma.CASTELLANO));

		}
	}

	/**
	 * Elimina un directorio y todo su contenido
	 *
	 * @param directory
	 * @return
	 */
	public static boolean deleteDirectory(File directory) {
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
