package com.ipartek.formacion.primero.practicas.migracion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicheroLectura {
	private BufferedReader br = null;
	private FileReader reader = null;

	public FicheroLectura() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Abre un fichero de tipo lectura
	 *
	 * @param nombreFichero
	 */
	public void abrirFichero(String nombreFichero) throws FileNotFoundException {
		try {
			// crear Stream de lectura
			this.reader = new FileReader(nombreFichero);
			// asociar el buffer al Stream
			this.br = new BufferedReader(this.reader);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
			throw new FileNotFoundException();
		}
	}

	/**
	 * Lee el fichero y devuelve la primera linea
	 *
	 * @param ficheroName
	 *            path y nombre del fichero
	 * @throws IOException
	 */
	public String leer() throws IOException {
		// para leer las lineas del fichero
		String sCurrentLine = "";
		try {
			sCurrentLine = this.br.readLine();
		} catch (IOException e) {
			System.out.println("Se ha producido un error al leer el fichero");
			throw new IOException();
		} finally {
			return sCurrentLine;
		}
	}
}
