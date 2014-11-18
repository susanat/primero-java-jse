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

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("filename.txt"), "utf-8"));
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
