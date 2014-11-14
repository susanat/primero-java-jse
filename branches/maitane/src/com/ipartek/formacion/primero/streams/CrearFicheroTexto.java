package com.ipartek.formacion.primero.streams;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Clase para crear un fichero escrito
 *
 * @author Maitane Casado Fernandez
 *
 */
public class CrearFicheroTexto {

	public CrearFicheroTexto() {

	}

	public static void main(String[] args) {

		Writer writer = null;
		FileOutputStream ficheroTexto = null;
		OutputStreamWriter outPutStream = null;

		try {
			// creamos el nombre y extension del fichero
			ficheroTexto = new FileOutputStream("filename.txt");

			// declaramos un Stream para escribir
			// pasamos como parametros el fichero a escribir y su Charset
			outPutStream = new OutputStreamWriter(ficheroTexto, "utf-8");

			// objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(outPutStream);

			// escribir en el fichero a traves del writer
			writer.write("Hello World");

		} catch (IOException ex) {
			// report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}
		}

	}
}
