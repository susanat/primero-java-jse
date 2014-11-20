package com.inpartek.formacion.proyectojava.util;

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

	protected String filePath;
	protected String fileName;
	protected String fileExt;
	protected File fichero;

	public ManejadorFichero(final String _filePath, final String _fileName,
			final String _fileExt) {
		super();
		this.filePath = _filePath;
		this.fileName = _fileName;
		this.fileExt = _fileExt;
	}

	public void addTexttoFile(final String cotent) {
		FileWriter fileWritter = null;
		BufferedWriter bufferWritter = null;
		fichero = new File(filePath + fileName + "." + fileExt);

		// if file doesnt exists, then create it
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// true = append file

		try {
			fileWritter = new FileWriter(fichero.getName(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bufferWritter = new BufferedWriter(fileWritter);

		try {
			bufferWritter.write(cotent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufferWritter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 *
	 * @param content
	 */
	public void crearArchivoTexto(final String content) {
		fichero = new File(filePath + fileName + "." + fileExt);
		FileOutputStream fos = null;
		Writer out = null;
		try {
			fos = new FileOutputStream(fichero);
			out = new OutputStreamWriter(fos, "UTF8");
			out.write(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *
	 * @return
	 */
	public String leerFichero() {
		StringBuilder sb = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			fichero = new File(filePath + fileName + "." + fileExt);
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			sb = new StringBuilder();
			String linea = null;

			// Lectura del fichero
			while ((linea = br.readLine()) != null) {
				sb.append(linea + ";");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

}
