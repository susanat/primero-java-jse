package com.ipartek.formacion.primero.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.ipartek.formacion.sergio.utils.ClsUtilsConstantes;

public class Fichero {

	/**
	 * Crea un fichero de texto con codificacion "utf-8"
	 *
	 * @param nombreFichero
	 *            path + nombre + extension, ej: filename.txt
	 * @param contenido
	 *            contenido a escribir en el fichero
	 *
	 * @return true si se crea el fichero, false en caso contrario
	 */
	static public boolean create(String nombreFichero, String contenido) {
		boolean resul = false;
		Writer writer = null;
		FileOutputStream ficheroTexto = null;
		OutputStreamWriter outputStream = null;
		try {
			// Creamos el nombre y extension del fichero
			ficheroTexto = new FileOutputStream(nombreFichero);
			// declaramos un Stream para escribir
			// pasamos como parametros el fichero a escribir y su Charset
			outputStream = new OutputStreamWriter(ficheroTexto, "utf-8");
			// objeto Writer para escribir
			// mejoramos el rendimiento con un buffer
			writer = new BufferedWriter(outputStream);
			// escribir en el fichero a traves del writer
			writer.write(contenido);
			resul = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return resul;
	}

	/**
	 * Eliminar fichero
	 * @param ficheroName Path y nombre del fichero
	 * @return True si es eliminado, false en caso contrario
	 */
	public static boolean remove(String ficheroName) {
		boolean resul = false;
		try {
			File file = new File(ficheroName);
			resul = file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	
	
	/**
	 * Lee y retorna el texto del fichero indicado
	 * @param filepath Path y nombre del fichero
	 * @return texto del fichero
	 * @throws IOException 
	 */
	public static String readStringBuilder(String filepath) throws IOException{
		BufferedReader br = null;
				
        String curline; //leer las lineas del fichero
        StringBuilder text = new StringBuilder(); 

        try {
        	//buffer para mejorar la lectura
            br = new BufferedReader(new FileReader(filepath));
            while ((curline = br.readLine()) != null) {

                //System.out.println(curline);
            	text.append(curline + ClsUtilsConstantes.SALTO_DE_LINEA);
            }
            br.close();
            return text.toString();

        } catch (IOException e) {

            e.printStackTrace();
            throw e;

        }finally{
        	try{
        		if (br != null) br.close();
        		text = null;
        	}catch(IOException ex){
        		ex.printStackTrace();
        		throw ex;
        	}
        }
        
       // return null;
       

	}
	
	/**
	 * Lee y retorna el texto del fichero indicado
	 * @param filepath Path y nombre del fichero
	 * @return texto del fichero
	 * @throws IOException 
	 */
	public static String readString(String filepath) throws IOException{
		BufferedReader br = null;
				
        String curline; //leer las lineas del fichero
        String text = ""; 

        try {
        	//buffer para mejorar la lectura
            br = new BufferedReader(new FileReader(filepath));
            while ((curline = br.readLine()) != null) {

                //System.out.println(curline);
            	text +=curline + ClsUtilsConstantes.SALTO_DE_LINEA;
            }
            br.close();
            return text.toString();

        } catch (IOException e) {

            e.printStackTrace();
            throw e;

        }finally{
        	try{
        		if (br != null) br.close();
        		text = null;
        	}catch(IOException ex){
        		ex.printStackTrace();
        		throw ex;
        	}
        }
        
       // return null;
       

	}
	
	
	
	public static void main(String[] args) {
		
		try {
			System.out.println(Fichero.readStringBuilder("C:\\Users\\curso\\Documents\\MainActivity.java"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
