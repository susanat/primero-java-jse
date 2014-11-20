package com.ipartek.formacion.primero.practicas.migracion;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FicheroEscritura {
	private Writer writer = null;
	private FileOutputStream ficheroTexto = null;
	private OutputStreamWriter outputStream = null;

	public FicheroEscritura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void abrirFichero(String nombreFichero) throws IOException {
		try {
			// Creamos el nombre y extension del fichero
			this.ficheroTexto = new FileOutputStream(nombreFichero);

			// declaramos un Stream para escribir
			// pasamos como parametros el fichero a escribir y su Charset
			this.outputStream = new OutputStreamWriter(this.ficheroTexto,
					"utf-8");

			// objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			this.writer = new BufferedWriter(this.outputStream);
		} catch (IOException e) {
			System.out.println("Se ha producido un error al crear el fichero");
			throw new IOException();
		}

	}

	public void escribir(String lineaTexto) throws IOException {

		this.writer.write(lineaTexto + "\n");
	}
}
