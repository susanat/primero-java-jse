package com.ipartek.formacion.migracion.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import com.ipartek.formacion.migracion.bean.Persona;
import com.ipartek.formacion.migracion.exception.PersonaException;

/**
 * Clase para gestionar los ficheros.
 *
 * @author Curso
 *
 */
public final class Fichero {

	/************************** CONSTANTES **************************/
	/**
	 * Path de los ficheros.
	 */
	private static final String PATH = "data/";

	/************************ CONSTRUCTORES ************************/
	/**
	 * Constructor privado para que la clase Fichero no se puda instanciar.
	 */
	private Fichero() {
	}

	/*************************** MÉTODOS ***************************/
	/**
	 * Lee el fichero.
	 *
	 * @param fileName
	 *            path + nombre + extensión, ej: filename.txt
	 */
	public static void migracionPersonas(final String fileName) {
		BufferedReader br = null;
		HashMap<Integer, String> hmPersonas = new HashMap<Integer, String>();
		final int count = 0;

		try {
			String sCurrentLine = null;
			br = new BufferedReader(new FileReader(PATH + fileName));

			/*
			 * Lee el fichero y comprueba los datos en cada línea: Si tiene el
			 * número de campos incorrecto llama al método personasError() que
			 * la añade al fichero personas_errores.txt. Si la persona está
			 * repetida se llama a el método personasRepetidas() que la añade a
			 * los ficheros personas_repetidas.txt y personas_errores.txt.
			 */
			// while ((sCurrentLine = br.readLine()) != null) {
			try {
				while ((sCurrentLine = br.readLine()) != null) {
					Persona.comprobarDatosPersona(sCurrentLine);
				}
			} catch (final PersonaException e) {
				personasError(PersonaException.COD_PERSONA_LENGTH + " => "
						+ sCurrentLine);
				e.printStackTrace();
			} catch (final Exception e) {
				e.printStackTrace();
			}

			/*
			 * try { Persona.comprobarEdadPersona(sCurrentLine); } catch (final
			 * PersonaException e) {
			 * personasError(PersonaException.COD_EDAD_PERSONA + sCurrentLine);
			 * System.out.println(e.getCodigo() + " => " + e.getMessage());
			 * e.printStackTrace(); }
			 * 
			 * if (hmPersonas.containsValue(sCurrentLine)) {
			 * personasRepetidas(sCurrentLine); } else { hmPersonas.put(count,
			 * sCurrentLine); count++; }
			 */

			// }//while
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				hmPersonas = null;
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método para crear un fichero.
	 *
	 * @param fileName
	 *            path + nombre + extensión, ej: filename.txt
	 * @param content
	 *            Contenido del fichero
	 * @return true si el fichero se ha creado
	 */
	public static boolean crearFichero(final String fileName,
			final String content) {
		boolean res = true;
		Writer out = null;

		try {
			// out = new BufferedWriter(new OutputStreamWriter(
			// new FileOutputStream(fileName), "utf-8"));
			out = new BufferedWriter(new FileWriter(PATH + fileName, true));
			out.write(content);
			res = true;
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * La Persona repetida la mete en un fichero de personas repetidas
	 * (personas_repetidas.txt).
	 *
	 * @param datosPersona
	 *            Datos de la Persona
	 */
	private static void personasRepetidas(final String datosPersona) {
		crearFichero("personas_repetidas.txt",
				datosPersona + System.getProperty("line.separator"));
	}

	/**
	 *
	 * La Persona con errores la mete en un fichero de errores
	 * (personas_errores.txt).
	 *
	 * @param datosPersona
	 *            Datos de la Persona
	 */
	private static void personasError(final String datosPersona) {
		crearFichero("personas_errores.txt",
				datosPersona + System.getProperty("line.separator"));

	}
}
