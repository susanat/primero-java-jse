package com.ipartek.formacion.migracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.ipartek.formacion.migracion.bean.Persona;
import com.ipartek.formacion.migracion.excepciones.PersonaException;
import com.ipartek.formacion.migracion.util.Utilidades;

public class Migracion {

	// Atributos

	public static HashMap<String, Persona> personaCorrecta = new HashMap<String, Persona>();
	public static ArrayList<Persona> personaError = new ArrayList<Persona>();
	public static ArrayList<Persona> personaRepetida = new ArrayList<Persona>();
	/**
	 * {@code ArrayList<String>} que almacena los DNI de los objetos Persona
	 * correctos que estan repetidos.
	 */
	public static ArrayList<String> listaBorrado = new ArrayList<String>();

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
				// TODO pasar la linea a un objeto Persona. esta separado por
				// comas ','
				// TODO esCorrecto

				// TODO comprobar duplicados en error y correcto

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

	public static void write(String ficheroName) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ficheroName);
			pw = new PrintWriter(fichero);

			/*
			 * for (int i = 0; i < 10; i++) pw.println("Linea " + i);
			 */
			// TODO escribir personaError, personaRepetida, personaCorrecta y
			// estadisticas

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Funcion que comprueba si el objeto Persona es correcto y lo trata en
	 * funcion de ello
	 *
	 * @param pers
	 *            Objeto de la clase Persona a tratar
	 *
	 * @throws PersonaException
	 */

	public static void isCorrect(Persona pers) throws PersonaException {

		if (!Utilidades.camposCompletos(pers)) {
			tratarError(pers);
		} else if (!Utilidades.dniCorrecto(pers.getDni())) {
			tratarError(pers);
		} else if (!Utilidades.edadValida(pers.getEdad())) {
			tratarError(pers);
		} else if (!Utilidades.validateEmail(pers.getEmail())) {
			tratarError(pers);
		} else if (!Utilidades.validarCaracteres(pers)) {
			tratarError(pers);
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

	public static void tratarError(Persona pers) throws PersonaException {

		if (Utilidades.estaEnLista(personaError, pers.getDni())) {

			personaError.add(pers);
			pers.setNombre("* " + pers.getNombre());
			personaRepetida.add(pers);
			Persona persAuxiliar = (Utilidades.devuelveElemLista(personaError,
					pers.getDni()));
			if (!Utilidades.estaEnLista(personaRepetida, persAuxiliar)) {

				persAuxiliar.setNombre("* " + persAuxiliar.getNombre());

				personaRepetida.add(persAuxiliar);
			}
		} else {
			personaError.add(pers);
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
				pers.setNombre("* " + pers.getNombre());
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

	// Metodo main
	public static void main(String[] args) {
		read("personas.txt"); // TODO añadir el fichero de texto a la carpeta
		// doc y comprobar que la ruta sea correcta

	}

}
