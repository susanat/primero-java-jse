package com.ipartek.formacion.migracion.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.ipartek.formacion.migracion.bean.Cadenas;

public class LeerFicheroTexto {

	public static int leerFichero() {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int cont = 0;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// leerlo
			archivo = new File("C:/Desarrollo/java/workspace/personas.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			Cadenas c = new Cadenas();
			// int cont = 0;
			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				c.trocearCadenas(linea);
				// System.out.println(linea);
				cont++;
			}
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
		return cont;

	}
}
