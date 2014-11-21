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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.logging.Logger;

public class ManejadorFichero {
    /*
     * protected String filePath; protected String fileName; protected String
     * fileExt; protected File fichero;
     * 
     * public ManejadorFichero(final String pfilePath, final String pfileName,
     * final String pfileExt) { super(); this.filePath = pfilePath;
     * this.fileName = pfileName; this.fileExt = pfileExt; }
     */
    /**
     * función que añade texto a un fichero ya existente
     *
     * @param content
     *            {@code String} el contenido a añadir al fichero
     */
    public static void addTexttoFile(final String content,
	    final String filePath, final String fileName, final String fileExt) {
	File fichero = new File(filePath + fileName + "." + fileExt);
	if (!fichero.exists()) {
	    try {
		fichero.createNewFile();
	    } catch (IOException e) {
		Logger.getLogger(e.getMessage());
		// e.printStackTrace();
	    }
	}
	PrintWriter out = null;
	try {
	    out = new PrintWriter(new BufferedWriter(new FileWriter(
		    fichero.getAbsoluteFile(), true)));
	    out.println("\n" + content);
	} catch (IOException e) {
	    Logger.getLogger(e.getMessage());
	} finally {
	    if (out != null) {
		out.close();
	    }
	}

    }

    /**
     *
     * @param content
     */
    public static void crearArchivoTexto(final String content,
	    final String filePath, final String fileName, final String fileExt) {
	File fichero = new File(filePath + fileName + "." + fileExt);
	FileOutputStream fos = null;
	Writer out = null;
	fichero = new File(filePath + fileName + "." + fileExt);
	if (!fichero.exists()) {
	    try {
		fichero.createNewFile();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	try {
	    fos = new FileOutputStream(fichero);
	    out = new OutputStreamWriter(fos, "UTF8");
	    out.write(content);
	} catch (FileNotFoundException e) {
	    // e.printStackTrace();
	    Logger.getLogger(e.getMessage());
	} catch (UnsupportedEncodingException e) {
	    // e.printStackTrace();
	    Logger.getLogger(e.getMessage());
	} catch (IOException e) {
	    // e.printStackTrace();
	    Logger.getLogger(e.getMessage());
	} finally {
	    try {
		out.close();
	    } catch (IOException e) {
		// e.printStackTrace();
		Logger.getLogger(e.getMessage());
	    }
	}
    }

    /**
     *
     * @return
     */
    public static String leerFichero(final String filePath,
	    final String fileName, final String fileExt) {
	File fichero = null;
	StringBuilder sb = null;
	FileReader fr = null;
	BufferedReader br = null;
	try {
	    fichero = new File(filePath + fileName + "." + fileExt);
	    fr = new FileReader(fichero);
	    br = new BufferedReader(fr);
	    sb = new StringBuilder();
	    String linea = null;

	    while ((linea = br.readLine()) != null) {
		sb.append(linea + ";");
	    }
	} catch (Exception e) {
	    // e.printStackTrace();
	    Logger.getLogger(e.getMessage());
	} finally {
	    try {
		if (null != fr) {
		    fr.close();
		}
	    } catch (IOException e) {
		// e.printStackTrace();
		Logger.getLogger(e.getMessage());
	    }
	}

	return sb.toString();
    }

}
