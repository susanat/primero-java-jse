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
		FileOutputStream fichero = null;
		OutputStreamWriter outputStream = null;
		BufferedWriter buffer = null;

		try {
			// Creamos el nombrey extension del fichero
			fichero = new FileOutputStream("holamundo.txt");

			// declaramos un stream para escribir. Pasamos como parametros el
			// fichero a escribir y el charset
			outputStream = new OutputStreamWriter(fichero, "utf-8");

			// Creamos un bufer intermedio (opcional) para mejorar el
			// rendimiento
			buffer = new BufferedWriter(outputStream);

			// Asignamos el bufer al writer
			writer = buffer;

			// Escribimos lo que queramos en el fichero
			writer.write("Hello World!");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}

	}
}
