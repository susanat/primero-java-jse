package com.ipartek.formacion.proyectoclase.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ManejadorFichero {

	private static String filePath;
	private static String fileName;
	private static String fileExt;
	private static File fichero;

	public ManejadorFichero() {
		super();
		ManejadorFichero.filePath = System.getProperty("java.io.tmpdir");
		ManejadorFichero.fileName = "helloWord";
		ManejadorFichero.fileExt = ".txt";
	}

	public ManejadorFichero(String filePath, String fileName, String fileExt) {
		super();
		ManejadorFichero.filePath = filePath;
		ManejadorFichero.fileName = fileExt;
	}

	public static void crearArchivoTexto(String content) {
		File fichero = new File(filePath + fileName + fileExt);
		FileOutputStream fos = null;
		Writer out = null;
		try {
			fos = new FileOutputStream(fichero);
			out = new OutputStreamWriter(fos, "UTF8");
			out.write(content);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void escribirFicheroTexto(String content) {
		fichero = new File(filePath + fileName + fileExt);

		crearFichero();
		FileWriter fw = null;
		try {
			fw = new FileWriter(fichero.getAbsoluteFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(filePath);
	}

	private static void crearFichero() {
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean borrarFichero() {
		boolean exito = false;
		try {
			fichero = new File(filePath + fileName + fileExt);
			if (!fichero.exists()) {
				exito = fichero.delete();
			} else {
				exito = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exito;
	}

	@SuppressWarnings("finally")
	public static String leerFichero() {
		StringBuilder sb = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			fichero = new File(filePath + fileName + fileExt);
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			sb = new StringBuilder();
			while ((linea = br.readLine()) != null) {
				sb.append(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return sb.toString();
	}
}
