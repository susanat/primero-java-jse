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
		OutputStreamWriter outputStreamWriter = null;

		try {

			// creamos el nombre y extension del fichero
			ficheroTexto = new FileOutputStream("filename.txt");

			// declaramos un stream para escribir
			// pasamos como parametro el fichero a escribir y su charset
			outputStreamWriter = new OutputStreamWriter(ficheroTexto, "utf-8");

			// objeto writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(outputStreamWriter);

			// esto es lo mismo q lo anterior pero simplificao
			// writer = new BufferedWriter(new OutputStreamWriter(new
			// FileOutputStream("filename.txt"),
			// "utf-8"));
			writer.write("Hello world");
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
