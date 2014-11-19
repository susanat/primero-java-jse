package com.ipartek.formacion.migracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Fichero {
    public static final String NOM_FICHERO_CORRECTO = "personas_correcto.txt";
    public static final String NOM_FICHERO_ERRONEO = "personas_error.txt";
    public static final String NOM_FICHERO_ENTRADA = "personas.txt";

    public static final String SEPARADOR = ",";
    public static final int LONGITUD_TOTAL = 7;
    static int NUM_LINEA = 0;

    public static boolean escribirMensaje(String nombreFichero, String contenido) {
	boolean resul = false;

	Writer writer = null;
	FileOutputStream ficheroTexto = null;
	OutputStreamWriter outputStream = null;
	try {
	    File file = new File("Ficheros/Salida/" + nombreFichero);
	    if (!file.exists()) {
		if (file.createNewFile()) {
		    System.out.println("El fichero " + nombreFichero
			    + " se ha creado correctamente");
		} else {
		    System.out.println("No ha podido ser creado el fichero");
		}
	    }

	    // Creamos el nombre y extension del fichero.
	    // El TRUE es para que escriba al final del fichero
	    ficheroTexto = new FileOutputStream(file, true);

	    // Declaramos un Stream para escribir
	    // pasamos como parametros el fichero a escribir y su Charset
	    outputStream = new OutputStreamWriter(ficheroTexto, "utf-8");

	    // Objeto Writer para escribir
	    // mejoramos el rendimiento con un buffer
	    writer = new BufferedWriter(outputStream);

	    // escribir en el fichero a traves del writer
	    writer.write(contenido + "\r\n");
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

    public static void read() {

	BufferedReader br = null; // buffer para mejorar la lectura
	FileReader reader = null;
	try {

	    String sCurrentLine; // Para leer las lineas del fichero

	    // Crear un Stream de lectura
	    reader = new FileReader("Ficheros/Entrada/" + NOM_FICHERO_ENTRADA);
	    // Asociar el buffer al Stream
	    br = new BufferedReader(reader);
	    String mensaje = "";
	    // Bucle para leer linea a linea
	    while ((sCurrentLine = br.readLine()) != null) {
		mensaje = separarResultado(sCurrentLine);

		if (mensaje == null) {
		    escribirMensaje(NOM_FICHERO_CORRECTO, sCurrentLine);
		} else {
		    escribirMensaje(NOM_FICHERO_ERRONEO, mensaje + NUM_LINEA);
		}
		System.out.println(NUM_LINEA);
		NUM_LINEA++;

	    }

	} catch (IOException e) {

	    e.printStackTrace();

	} finally {

	    try {

		if (br != null) {
		    br.close();
		}

	    } catch (IOException ex) {

		ex.printStackTrace();

	    }

	}
    }

    /**
     * Separa un {@code String} dividido con un separador
     *
     * @param linea
     *            - Línea de {@code String} a separar
     * @return una <code>Persona</code> con sus atributos
     */

    public static String separarResultado(String linea) {
	StringTokenizer stToken = new StringTokenizer(linea, SEPARADOR);
	ArrayList<String> arrayAtributos = new ArrayList<String>();
	while (stToken.hasMoreTokens()) {
	    arrayAtributos.add(stToken.nextToken());
	}
	return comprobarDatos(arrayAtributos);
    }

    /**
     * Crea un objeto <code>Persona</code>
     *
     * @param arrayAtributos
     * @return
     */
    public static String comprobarDatos(ArrayList<String> arrayAtributos) {
	String mensaje = null;
	if (arrayAtributos.size() == LONGITUD_TOTAL) {
	    Persona persona = new Persona(arrayAtributos.get(0),
		    arrayAtributos.get(1), arrayAtributos.get(2),
		    Integer.parseInt(arrayAtributos.get(3)),
		    arrayAtributos.get(4), arrayAtributos.get(5),
		    arrayAtributos.get(6));

	    mensaje = comprobarErroneo(persona);

	    String dni = persona.getDni();
	    comprobarRepetido(dni);

	} else {
	    mensaje = "Faltan datos - Linea";
	}

	return mensaje;

    }

    public static String comprobarErroneo(Persona persona) {
	String mensaje = null;
	if (persona.comprobarEdad()) {
	    if (persona.comprobarDni()) {
		if (persona.comprobarEmail()) {
		    if (persona.comprobarCaracteresExtraños()) {
			mensaje = "UTF8 - Linea ";
		    }

		} else {
		    mensaje = "Email - Linea ";
		}

	    } else {
		mensaje = "Dni - Linea ";
	    }

	} else {
	    mensaje = "Edad - Linea ";
	}

	if (mensaje != null) {
	    Migracion.ERRONEOS.put(persona.getDni(), persona);
	}
	return mensaje;
    }

    public static void comprobarRepetido(String dni) {
	if (Migracion.ERRONEOS.get(dni) != null
		|| Migracion.CORRECTOS.get(dni) != null) {
	    if (Migracion.REPETIDOS_DNI.get(dni) != null) {
		Migracion.REPETIDOS_DNI.put(dni,
			Migracion.REPETIDOS_DNI.get(dni) + 1);

	    }
	}

    }
}
