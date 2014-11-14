package com.ipartek.formacion.primero.streams;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CrearFicheroTexto {

	public CrearFicheroTexto() {

	}

	public static void main(String[] args) {

		Writer writer = null;
		FileOutputStream ficheroTexto = null;
		OutputStreamWriter outputStream = null;

		try {
			// Creamos el nombre y extensión del fichero
			ficheroTexto = new FileOutputStream("HelloWorld.txt");

			// Declaramos un Stream para escribir
			// Pasamos como parámetros el fichero a escribir y su charset
			outputStream = new OutputStreamWriter(ficheroTexto, "utf-8");

			// Objeto Writer para escribir
			// Mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(outputStream);

			// Escribir en el fichero a través del writer
			writer.write("Hello World");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
