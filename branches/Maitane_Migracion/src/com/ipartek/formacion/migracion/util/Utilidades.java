package com.ipartek.formacion.migracion.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aeat.valida.Validador;
import com.ipartek.formacion.migracion.Migracion;
import com.ipartek.formacion.migracion.bean.Persona;

/**
 * Clase con metodos staticos para no tener que crear un objeto al usarlos
 *
 * @author Maitane Casado Fernandez
 *
 */

public class Utilidades {

	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Funcion que comprueba si un dni es correcto o no utilizando valnif.jar
	 * proporcionado por la Agencia Tributaria Española.
	 * https://amatellanes.wordpress
	 * .com/2013/07/30/java-validar-dni-nie-o-cif-en-java/
	 *
	 * @param _dni
	 *            {@code String} del dni a validar
	 * @return true si es válido, false en caso contrario
	 */
	public static boolean dniCorrecto(String _dni) {
		boolean rdo = false;

		Validador validador = new Validador();
		int auxi = validador.checkNif(_dni);
		if (auxi > 0) {
			rdo = true;
		}

		return rdo;
	}

	/**
	 * Funcion para comprobar que todos los campos del objetos Persona estan
	 * completos
	 *
	 * @param pers
	 *            objetos de la clase Persona a comprobar
	 * @return true si todos los campos estan completos y false en caso
	 *         contrario
	 */

	public static boolean camposCompletos(Persona pers) {
		boolean completo = false;
		if (pers.getNombre() != null && pers.getApellido() != null
				&& pers.getPoblacion() != null && pers.getEdad() != 0
				&& pers.getEmail() != null && pers.getDni() != null
				&& pers.getCategoria() != null) {
			completo = true;

		}

		return completo;
	}

	public static boolean edadValida(int edad) {// throws PersonaException {
		boolean valida = false;

		if (edad >= Persona.MIN_EDAD && edad <= Persona.MAX_EDAD) {
			valida = true;
		}

		/*
		 * else {
		 *
		 * // lanzar PersonaException throw new
		 * PersonaException(PersonaException.MSG_EDAD_NO_VALIDO,
		 * PersonaException.CODE_EDAD_NO_VALIDO); }
		 */

		return valida;
	}

	/**
	 * Validar un email con expresiones regulares
	 *
	 * @param email
	 *            email a validar
	 * @return true si es valido, false en caso contrario
	 */
	public static boolean validateEmail(String email) {

		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	}

	public static boolean validarCaracteres(Persona pers) {
		boolean valida = false;

		if (UTF8Utils.isUTF8Correct(pers.getNombre())
				&& UTF8Utils.isUTF8Correct(pers.getApellido())
				&& UTF8Utils.isUTF8Correct(pers.getPoblacion())
				&& UTF8Utils.isUTF8Correct(pers.getEmail())
				&& UTF8Utils.isUTF8Correct(pers.getDni())
				&& UTF8Utils.isUTF8Correct(pers.getCategoria())) {
			valida = true;

		}

		return valida;
	}

	public static boolean estaEnLista(ArrayList<Persona> lista, String _dni) {
		boolean esta = false;
		Iterator<Persona> it = lista.iterator();
		while (it.hasNext()) {
			if (_dni.equalsIgnoreCase(it.next().getDni())) {
				esta = true;
				break;
			}
		}

		return esta;
	}

	public static boolean estaEnLista(ArrayList<Persona> lista, Persona pers) {
		boolean esta = false;
		Iterator<Persona> it = lista.iterator();
		if (lista.size() > 0) {
			while (it.hasNext()) {

				if (pers.equals(it.hasNext())) {
					esta = true;
					break;
				}
			}
		}

		return esta;
	}

	public static Persona devuelveElemLista(ArrayList<Persona> lista,
			String _dni) {

		Persona per = new Persona();

		Iterator<Persona> it = lista.iterator();
		while (it.hasNext()) {

			if (_dni.equalsIgnoreCase(it.next().getDni())) {
				per = it.next();
				break;

			}
		}
		return per;
	}

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
	static public boolean create(String nombreFichero,
			ArrayList<Persona> listado) {
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
			for (int i = 0; i < listado.size(); i++) {
				writer.write(pasarPersonaString(listado.get(i)));
			}

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

	public static String[] separarSplit(final String cadena,
			final String separador) {

		String[] elementosCadena = cadena.split(separador);

		return elementosCadena;

	}

	public static String pasarPersonaString(Persona pers) {
		String rdo = null;
		if (pers != null) {
			rdo = pers.getNombre() + pers.getApellido() + pers.getPoblacion()
					+ pers.getEdad() + pers.getEmail() + pers.getDni()
					+ pers.getCategoria();
		}
		return rdo;
	}

	public static ArrayList<Persona> pasarHashMapArrayList() {
		ArrayList<Persona> listaPersona = new ArrayList<Persona>();
		listaPersona = (ArrayList<Persona>) Migracion.personaCorrecta.values();
		;

		return listaPersona;

	}
}
