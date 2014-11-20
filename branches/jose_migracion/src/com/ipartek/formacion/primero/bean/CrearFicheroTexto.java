package com.ipartek.formacion.primero.bean;

import com.ipartek.formacion.primero.util.Fichero;

public class CrearFicheroTexto {

	public static void main(String[] args) {
		/*
		 * Writer writer = null; FileOutputStream ficheroTexto = null;
		 * OutputStreamWriter outputStream = null;
		 * 
		 * try { // Creamos el nombre y extension del fichero ficheroTexto = new
		 * FileOutputStream("filename.txt");
		 * 
		 * // declaramos un Stream para escribir // pasamos como parametros el
		 * fichero a escribir y su Charset outputStream = new
		 * OutputStreamWriter(ficheroTexto, "utf-8");
		 * 
		 * // objeto Writer para escribir // mejoramos el rendimiento con un
		 * buffer writer = new BufferedWriter(outputStream);
		 * 
		 * // escribir en el fichero a traves del writer
		 * writer.write("Something"); }
		 * 
		 * catch (IOException ex) { // report }
		 * 
		 * finally { try { writer.close(); }
		 * 
		 * catch (Exception ex) { } }
		 */

		Fichero.create("filename.txt", "Hola Mundo");
	}

}
