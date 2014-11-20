package com.ipartek.formacion.migracion.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.ipartek.formacion.migracion.util.Cadenas;

public class LeerFicheroTexto {

	public static void main(String[] args) {

		leerFichero();
	}

	/**
	 * Lee el fichero personas.txt para obtener sus datos
	 *
	 */
	public static void leerFichero() {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int cont = 0;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// leerlo
			archivo = new File("personas.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// int cont = 0;
			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				Cadenas.trocearCadenas(linea);
				/*
				 * if (bien) {
				 * CrearFicheroTexto.fichero("Personas-correctas.txt", linea); }
				 * else if (edad < 18) {
				 * CrearFicheroTexto.fichero("Personas-error.txt", linea); }
				 * else if (dniduplicado) {
				 * CrearFicheroTexto.fichero("Personas-duplicadas.txt", linea);
				 * }
				 */
				CrearFicheroTexto.duplicados("estadisticas.txt", linea);
				cont++;
			}
			String numReg = Integer.toString(cont);
			CrearFicheroTexto.estadisticas("estadisticas.txt", numReg);
			System.out.println(cont);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
