package com.ipartek.formacion.migracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import sun.font.CreatedFontTracker;

import com.ipartek.formacion.migracion.bean.Persona;
import com.ipartek.formacion.migracion.excepciones.PersonaException;
import com.ipartek.formacion.migracion.util.Utilidades;

/**
 * Clase para llevar a cabo la migracion de datos desde el fichero origen
 * persona.txt a los fichero de salida personas-correctas.txt,
 * personas-error.txt, personas-repetidas.txt y estadisticas.txt
 *
 * @author Maitane Casado Fernandez
 *
 */
public class Migracion {

	// Atributos

	static final String ASTERISCO = "* ";
	static final String NOM_FICH_CORR = "doc\\personas-correctas.txt ";
	static final String NOM_FICH_REPE = "doc\\persona-repetida.txt ";
	static final String NOM_FICH_ERROR = "doc\\persona-error.txt ";
	static final String NOM_FICH_LECTURA = "doc\\personas.txt";
	public static String lineaSeparador = "_________________________";
	public static String lineaSeparadorPunteado = "---------------------------------------";
	static final String NOM_FICH_ESTADISTICAS = "doc\\estadisticas.txt";
	public static HashMap<String, Persona> personaCorrecta = new HashMap<String, Persona>();
	public static ArrayList<Persona> personaError = new ArrayList<Persona>();
	public static ArrayList<Persona> personaRepetida = new ArrayList<Persona>();
	/**
	 * {@code ArrayList<String>} que almacena los DNI de los objetos Persona
	 * correctos que estan repetidos.
	 */
	public static ArrayList<String> listaBorrado = new ArrayList<String>();
	static int contLineasLeidas = 0;
	static ArrayList<String> listaErroneos = new ArrayList<String>();
	static long segundos = 0;
	static long minutos = 0;

	// Metodos estaticos

	public static void read(String ficheroName) throws PersonaException {
		BufferedReader br = null; // buffer para mejorar la lectura
		FileReader reader = null;
		try {
			// para leer las lineas del fichero
			String sCurrentLine;

			// Crear Stream de lectura
			reader = new FileReader(ficheroName);
			// asociar el buffer al Stream
			br = new BufferedReader(reader);

			String[] elemFich = null;
			Persona pers = null;
			// Bucle para leer linea a linea
			while ((sCurrentLine = br.readLine()) != null) {
				try {
					System.out.println(contLineasLeidas + " Linea ["
							+ sCurrentLine + "]");

					// pasar la linea a un objeto Persona que esta separado por
					// comas ','
					elemFich = Utilidades.separarSplit(sCurrentLine, ",");
					// comprobar si estan todos los elementos
					if (elemFich.length == 7) {
						pers = new Persona(elemFich[0], elemFich[1],
								elemFich[2], Integer.parseInt(elemFich[3]),
								elemFich[4], elemFich[5], elemFich[6]);

						// esCorrecto

						isCorrect(pers);
					} else {
						// TODO error falta campos
						// tratarError(pers);
						listaErroneos.add(sCurrentLine);
						System.out
						.println(" **** Linea [" + sCurrentLine + "]");
						System.out.println("faltan campos!!!!!!!");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(" **** Linea [" + sCurrentLine + "]");
				} finally {
					contLineasLeidas++;
				}

			}

			// comprobar duplicados en error y correcto
			System.out.println("acabado");
			System.out.println(" **** Lineas  " + contLineasLeidas);
			comprobarDuplicados();
			eliminarListaBorrado();

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

	/*
	 * public static void write(String ficheroName) { FileWriter fichero = null;
	 * PrintWriter pw = null; try { fichero = new FileWriter(ficheroName); pw =
	 * new PrintWriter(fichero);
	 */
	/*
	 * for (int i = 0; i < 10; i++) pw.println("Linea " + i);
	 */
	// TODO escribir personaError, personaRepetida, personaCorrecta y
	// estadisticas
	/*
	 * } catch (Exception e) { e.printStackTrace(); } finally { try { //
	 * Nuevamente aprovechamos el finally para // asegurarnos que se cierra el
	 * fichero. if (null != fichero) fichero.close(); } catch (Exception e2) {
	 * e2.printStackTrace(); } } }
	 */

	/**
	 * Funcion que comprueba si el objeto Persona es correcto y lo trata en
	 * funcion de ello
	 *
	 * @param pers
	 *            Objeto de la clase Persona a tratar
	 *
	 * @throws PersonaException
	 */

	public static void isCorrect(Persona pers) {// throws PersonaException {

		if (!Utilidades.camposCompletos(pers)) {
			tratarError(pers, "Faltan campos");
		} else if (!Utilidades.dniCorrecto(pers.getDni())) {
			tratarError(pers, "DNI invalido");
		} else if (!Utilidades.edadValida(pers.getEdad())) {
			tratarError(pers, "Edad no valida");
		} else if (!Utilidades.validateEmail(pers.getEmail())) {
			tratarError(pers, "Email no valido");
		} else if (!Utilidades.validarCaracteres(pers)) {
			tratarError(pers, "Caracteres no validos");
		} else if (personaCorrecta.containsKey(pers.getDni())) {
			// se añade el obejto Persona que estaba en correctos y la persona
			// pasada como paramtero a personaRepetida.
			personaRepetida.add(personaCorrecta.get(pers.getDni()));
			personaRepetida.add(pers);
			// se guarda el DNI repetido en listaBorrado para su posterior
			// borrado de personaCorrecta
			listaBorrado.add(personaCorrecta.get(pers.getDni()).getDni());

		} else {
			personaCorrecta.put(pers.getDni(), pers);
		}

	}

	/**
	 * Funcion que comprueba si hay duplicados en la personaError. Si no hay,
	 * simplemente añadira el nuevo objeto Persona. Si exiten duplicados,
	 * añadirá el nuevo a personaError y personaRepetida(en este ultimo con '*'
	 * delante). Si el que estaba en personaError no se encuentra en
	 * personaRepetida, tambien lo añadira con '*' delante.
	 *
	 * @param pers
	 *            objeto de la clase Persona a tratar
	 * @throws PersonaException
	 */

	public static void tratarError(Persona pers, String tipoError) {// throws
		// PersonaException
		// {
		Persona perError = pers;
		perError.setNombre(tipoError + "  " + perError.getNombre());

		if (Utilidades.estaEnLista(personaError, pers.getDni())) {

			personaError.add(perError);
			pers.setNombre(ASTERISCO + pers.getNombre());
			personaRepetida.add(pers);
			Persona persAuxiliar = (Utilidades.devuelveElemLista(personaError,
					pers.getDni()));
			if (!Utilidades.estaEnLista(personaRepetida, persAuxiliar)) {

				persAuxiliar.setNombre(ASTERISCO + persAuxiliar.getNombre());

				personaRepetida.add(persAuxiliar);
			}
		} else {
			personaError.add(perError);
		}

	}

	/**
	 * Funcion que comprueba si exiten duplicados entre personaError y
	 * personaCorrecta
	 *
	 * @throws PersonaException
	 */
	public static void comprobarDuplicados() throws PersonaException {
		Persona pers = new Persona();
		for (int i = 0; i < personaError.size(); i++) {
			// comprueba si hay un objeto con el mismo DNI tanto en personaError
			// como en personaCorrecta
			if (personaCorrecta.containsKey(personaError.get(i).getDni())) {

				// se añade a personaRepetida el objeto de personaCorrecta
				personaRepetida.add(personaCorrecta.get((personaError.get(i)
						.getDni())));
				// se añade a personaRepetida el objeto de personaError con '*'
				// delante
				pers = personaError.get(i);
				pers.setNombre(ASTERISCO + pers.getNombre());
				personaRepetida.add(pers);
				// eliminar de personaCorrecta
				personaCorrecta.remove(personaError.get(i).getDni());

			}

		}

	}

	/**
	 * Funcion que borra los elementos de personaCorrecta que tengan la clave
	 * almacenada en listaBorrar. Se borra depues de comprobar todo el fichero
	 */

	public static void eliminarListaBorrado() {
		for (int i = 0; i < listaBorrado.size(); i++) {
			if (personaCorrecta.containsKey(listaBorrado.get(i))) {
				personaCorrecta.remove(listaBorrado.get(i));
			}

		}
	}

	public static boolean crearEstadisticas(String nomFich) {

		boolean resul = false;
		Writer writer = null;
		FileOutputStream ficheroTexto = null;
		OutputStreamWriter outputStream = null;
		try {
			// Creamos el nombre y extension del fichero
			ficheroTexto = new FileOutputStream(nomFich);
			// declaramos un Stream para escribir
			// pasamos como parametros el fichero a escribir y su Charset
			outputStream = new OutputStreamWriter(ficheroTexto, "utf-8");
			// objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(outputStream);

			// escribir en el fichero a traves del writer

			writer.write("ESTADISTICAS \r\n");
			writer.write(lineaSeparador + "\r\n");
			writer.write(contLineasLeidas + " Registros leidos \r\n");
			writer.write(minutos + " Minutos " + segundos + " Segundos \r\n");
			writer.write(lineaSeparadorPunteado + "\r\n");
			writer.write(personaCorrecta.size() + " Correctos \r\n");
			writer.write(personaError.size() + " Errores \r\n");
			writer.write(personaRepetida.size() + " Duplicados \r\n");

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

	// Metodo main
	public static void main(String[] args) throws PersonaException {

		long start = System.currentTimeMillis();

		read(NOM_FICH_LECTURA);

		ArrayList<Persona> persCorr = Utilidades.pasarHashMapArrayList();
		Utilidades.create(NOM_FICH_CORR, persCorr);// TODO
		// listaErroneos
		Utilidades.create(NOM_FICH_ERROR, personaError);
		Utilidades.create(NOM_FICH_REPE, personaRepetida);
		// https://es.answers.yahoo.com/question/index?qid=20120323172702AAi5TA6
		// http://programador1.blogspot.com.es/2010/12/java-como-calcular-el-tiempo-de.html

		// calcular tiempo transcurrido
		long end = System.currentTimeMillis();
		long res = end - start;
		minutos = res / (60 * 1000) % 60;
		segundos = res / 1000 % 60;
		// http://java-white-box.blogspot.com.es/2013/07/java-code-como-calcular-el-tiempo-que.html
		crearEstadisticas(NOM_FICH_ESTADISTICAS);

	}
}
