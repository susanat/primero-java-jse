package com.ipartek.formacion.proyectoclase.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ManejadorFichero {

	private String filePath;
	private String fileName;
	private String fileExt;
	private File fichero;

	public ManejadorFichero() {
		super();
		this.filePath = System.getProperty("java.io.tmpdir");
		this.fileName = "helloWord";
		this.fileExt = ".txt";
	}

	public ManejadorFichero(String filePath, String fileName, String fileExt) {
		super();
		this.filePath = filePath;
		this.fileName = fileExt;
	}

	public void crearArchivoTexto(String content) {
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

	private void crearFichero() {
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean borrarFichero() {
		boolean exito = false;
		try {
			fichero = new File(filePath + fileName + fileExt);
			exito = fichero.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exito;
	}
}
