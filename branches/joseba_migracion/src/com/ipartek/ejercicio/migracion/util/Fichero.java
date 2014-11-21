package com.ipartek.ejercicio.migracion.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ipartek.ejercicio.migracion.Constantes;
import com.ipartek.ejercicio.migracion.Persona;
import com.ipartek.ejercicio.migracion.excepciones.PersonaException;

public class Fichero {

    public static final int ESCRIBIR_EN_CORRECTO = 1;
    public static final int ESCRIBIR_EN_ERROR = 0;
    public static final int NO_ESCRIBIR = -1;

    /**
     * Leer fichero linea por linea y realiza un proceso de selección para
     * determinar que lineas son correctas y cuales erroneas
     *
     * @param nombreFichero
     *            : un {@code String} con el nombre (ruta incluida) del fichero
     *            a leer
     *
     */
    public static void read(String nombreFichero) {
	BufferedReader br = null; // Buffer para mejorar la lectura, es
	// opcional, mejora el rendimiento
	FileReader reader = null;
	List<String> lista = new ArrayList<String>();
	ArrayList<Persona> listaDePersonas = new ArrayList<Persona>();
	// Variables para calcular estadisticas
	int registrosLeidos = 0;
	int numCorrectos = 0;
	int numErrores = 0;
	int numRepetidos = 0;
	Date fechaInicio = new Date();

	try {

	    String sCurrentLine; // Variable que contiene las lineas del fichero
	    reader = new FileReader(nombreFichero);// Stream de lectura

	    br = new BufferedReader(reader); // Asociamos el buffer al string

	    while ((sCurrentLine = br.readLine()) != null) {

		int escribir = NO_ESCRIBIR;

		// Vamos controlando el numero de registros leidos para nuestras
		// estadisticas
		registrosLeidos = registrosLeidos + 1;

		// Separamos los valores y los guardamos en una lista
		lista = separarValores(sCurrentLine);

		// Comprobamos que la lista tenga el numero de atributos
		// correctos
		if (lista.size() != 7) {
		    // Numero de atributos incorrecto, directamente a error

		    WritetoFileStringBuilder(Constantes.FICHERO_ERROR, lista);
		    escribir = NO_ESCRIBIR;
		    numErrores = numErrores + 1;

		} else {
		    // Numero de atributos correcto. Construimos una persona
		    // para ver si ciertos atributos (edad, dni y mail) son
		    // validos (ademas de la codificacion) mediante los setters
		    // invocados por su constructor

		    try {
			Persona p1 = new Persona(lista.get(0), lista.get(1),
				lista.get(2), Integer.parseInt(lista.get(3)),
				lista.get(4), lista.get(5), lista.get(6));
			// Si llegamos aqui es que la persona es correcta la
			// marcamos como correcta
			escribir = ESCRIBIR_EN_CORRECTO;

			numCorrectos = numCorrectos + 1;
		    } catch (Exception ex) {
			System.out.println(ex.getMessage());
			// Es una linea erronea, debe ir al fichero de error
			lista = new ArrayList<String>(lista);
			// obtenemos el mensaje de error de la excepcion lanzada
			lista.add(ex.getMessage());
			escribir = ESCRIBIR_EN_ERROR;

			numErrores = numErrores + 1;
		    }

		    // construimos la persona sin comprobar que los valores sean
		    // correctos
		    listaDePersonas.add(new Persona(lista.get(0), lista.get(1),
			    lista.get(2), Integer.parseInt(lista.get(3)), lista
				    .get(4), lista.get(5), lista.get(6), true));

		}
		// Escribimos las lineas a los ficheros correspondientes
		if (escribir == ESCRIBIR_EN_CORRECTO) {
		    // la linea es correcta, escribimos a personas-correctas.txt
		    WritetoFileStringBuilder(Constantes.FICHERO_CORRECTO, lista);
		    escribir = NO_ESCRIBIR;
		} else if (escribir == ESCRIBIR_EN_ERROR) {
		    // La linea es incorrecta, escribimos a
		    // personas-incorrectas.txt
		    WritetoFileStringBuilder(Constantes.FICHERO_ERROR, lista);
		    escribir = NO_ESCRIBIR;
		}
	    }
	    // comprobamos las personas que tengan DNI Repetido y guardamos la
	    // lista de repetidos en una variable
	    numRepetidos = checkRepetidos(listaDePersonas);

	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (br != null) {
		    br.close();
		    // Generamos el momento en el que hemos terminado el proceso
		    // (a excepcion de escribir en el fichero de estadisticas)
		    Date dateFinal = new Date();
		    // Escribimos en el fichero de estadisticas

		    writeStatistics(Constantes.FICHERO_ESTADISTICAS,
			    registrosLeidos, numCorrectos, numErrores,
			    numRepetidos, fechaInicio, dateFinal);

		}
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}

    }

    /**
     * Funcion que separa los valores de cada linea del fichero que estan entre
     * comas y crea una Lista con los valores
     *
     * @param linea
     *            : un {@code String} con la linea a separar
     * @return un {@code List} con los valores ya separados
     */
    public static List<String> separarValores(String linea) {
	List<String> valoresPersona = new ArrayList<String>();
	valoresPersona = Arrays.asList(linea.split(","));
	return valoresPersona;
    }

    /**
     * Funcion que crea un fichero vacio
     *
     * @param nombreFichero
     *            : un {@code String} con el nombre del fichero a crear
     * @return un {@code boolean} que indica si la creacion del fichero fue
     *         exitosa o no
     */
    public static boolean crearFichero(String nombreFichero) {
	boolean creadoCorrecto = false;
	FileOutputStream fichero = null;
	try {
	    fichero = new FileOutputStream(nombreFichero);
	    creadoCorrecto = true;
	    fichero.close();
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	    creadoCorrecto = false;

	}

	return creadoCorrecto;
    }

    /**
     * Funcion que escribe a los ficheros de correctos y erroneos
     *
     * @param nombreFichero
     *            : un {@code String} con el nombre de fichero (ruta incluida)
     *            en el que queremos escribir
     * @param lista
     *            : un {@code List} con los que queremos escribir en el fichero
     * @return un {@code boolean} que indica si la escritura al fichero se
     *         realizó correctamente
     */
    public static boolean WritetoFileStringBuilder(String nombreFichero,
	    List lista) {
	boolean resul = false;
	Writer writer = null;
	FileOutputStream fichero = null;
	OutputStreamWriter outputStream = null;
	BufferedWriter buffer = null;
	StringBuilder sb = new StringBuilder();

	try {
	    // Creamos el nombrey extension del fichero
	    fichero = new FileOutputStream(nombreFichero, true);

	    // declaramos un stream para escribir. Pasamos como parametros el
	    // fichero a escribir y el charset
	    outputStream = new OutputStreamWriter(fichero, "utf-8");

	    // Creamos un bufer intermedio (opcional) para mejorar el
	    // rendimiento
	    buffer = new BufferedWriter(outputStream);

	    // Asignamos el bufer al writer

	    writer = buffer;

	    // Creamos lo que vamos a escribir en el fichero
	    // sb.append
	    for (int i = 0; i < lista.size(); i++) {
		sb.append(lista.get(i) + " ");
	    }
	    sb.append("\n");

	    // Escribimos lo que queramos en el fichero

	    writer.write(sb.toString());

	    resul = true;
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	    resul = false;
	} finally {
	    try {
		writer.close();
		buffer.close();
	    } catch (Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	    }
	}
	return resul;

    }

    /**
     * Funcion que escribe al fichero de estadisticas
     *
     * @param nombreFichero
     *            : un {@code String} con el nombre del fichero (ruta incluida)
     *            en el que vamos a escribir
     * @param registrosLeidos
     *            : un {@code int} con el numero total de registros leidos
     * @param numCorrectos
     *            : un {@code int} con el numero de registros correctos
     * @param numErrores
     *            : un {@code int} con el numero de registros incorrectos
     * @param numRepetidos
     *            : un {@code int} con el numero de registros repetidos
     * @param dateInicio
     *            : un {@code Date} con el momento en el que se inicio todo el
     *            proceso
     * @param dateFinal
     *            : un {@code Date} con el momento en el que se finalizo el
     *            proceso
     * @return un {@code boolean} que indica si el proceso de escritura en el
     *         fichero se realizo correctamente
     */
    public static boolean writeStatistics(String nombreFichero,
	    int registrosLeidos, int numCorrectos, int numErrores,
	    int numRepetidos, Date dateInicio, Date dateFinal) {
	boolean resul = false;
	Writer writer = null;
	FileOutputStream fichero = null;
	OutputStreamWriter outputStream = null;
	BufferedWriter buffer = null;
	StringBuilder sb = new StringBuilder();

	Date duracion = new Date(dateFinal.getTime() - dateInicio.getTime());
	DateFormat formato = new SimpleDateFormat("mm:ss");

	try {
	    // Creamos el nombrey extension del fichero
	    fichero = new FileOutputStream(nombreFichero, true);

	    // declaramos un stream para escribir. Pasamos como parametros el
	    // fichero a escribir y el charset
	    outputStream = new OutputStreamWriter(fichero, "utf-8");

	    // Creamos un bufer intermedio (opcional) para mejorar el
	    // rendimiento
	    buffer = new BufferedWriter(outputStream);

	    // Asignamos el bufer al writer

	    writer = buffer;

	    // Creamos lo que vamos a escribir en el fichero
	    // sb.append

	    sb.append("Numero de registros leidos: " + registrosLeidos + "\n");
	    sb.append("Duracion del proceso: " + formato.format(duracion)
		    + "\n");
	    sb.append("Correctos: " + numCorrectos + "\n");
	    sb.append("Errores: " + numErrores + "\n");
	    sb.append("Repetidos: " + numRepetidos + "\n");

	    // Escribimos lo que queramos en el fichero

	    writer.write(sb.toString());

	    resul = true;
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	    resul = false;
	} finally {
	    try {
		writer.close();
		buffer.close();
	    } catch (Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	    }
	}
	return resul;

    }

    /**
     * Funcion que escribe al fichero de repetidos
     *
     * @param nombreFichero
     *            un {@code String} con el nombre del fichero (ruta incluida) al
     *            que vamos a escribir
     * @param listaRepetidos
     *            : un {@code List} con todos los repetidos
     * @return
     */

    public static boolean writetoRepetidoFileStringBuilder(
	    String nombreFichero, List<Persona> listaRepetidos) {
	boolean resul = false;
	Writer writer = null;
	FileOutputStream fichero = null;
	OutputStreamWriter outputStream = null;
	BufferedWriter buffer = null;
	StringBuilder sb = new StringBuilder();

	try {
	    // Creamos el nombrey extension del fichero
	    fichero = new FileOutputStream(nombreFichero, true);

	    // declaramos un stream para escribir. Pasamos como parametros el
	    // fichero a escribir y el charset
	    outputStream = new OutputStreamWriter(fichero, "utf-8");

	    // Creamos un bufer intermedio (opcional) para mejorar el
	    // rendimiento
	    buffer = new BufferedWriter(outputStream);

	    // Asignamos el bufer al writer

	    writer = buffer;

	    // Creamos lo que vamos a escribir en el fichero
	    // sb.append
	    for (int i = 0; i < listaRepetidos.size(); i++) {
		sb.append(listaRepetidos.get(i).getNombre() + " "
			+ listaRepetidos.get(i).getApellido() + " "
			+ listaRepetidos.get(i).getPoblacion() + " "
			+ listaRepetidos.get(i).getEdad() + " "
			+ listaRepetidos.get(i).getMail() + " "
			+ listaRepetidos.get(i).getDni() + " "
			+ listaRepetidos.get(i).getCategoria() + "\n");
		if (i % 2 != 0) {
		    sb.append("-------------------------------------------------------------------------------------------\n");
		}
	    }

	    // Escribimos lo que queramos en el fichero

	    writer.write(sb.toString());

	    resul = true;
	} catch (IOException ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	    resul = false;
	} finally {
	    try {
		writer.close();
		buffer.close();
	    } catch (Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	    }
	}
	return resul;

    }

    /**
     * Funcion que obtiene las personas duplicadas mirando su DNI
     *
     * @param listaPersonas
     *            : un {@code ArrayList} con todas las personas
     * @return un {@code List} con los duplicados
     */
    public static int checkRepetidos(ArrayList<Persona> listaPersonas) {
	List<Persona> duplicates = new ArrayList<Persona>();
	Set<Persona> personaSet = new TreeSet<Persona>(new PersonaComparator());
	Persona p1;
	for (Persona p : listaPersonas) {
	    if (!personaSet.add(p)) {// intentamos añadir la persona a nuestro
		// TreeSet, si falla es
		// que ya hay una persona con ese dni

		// Comprobamos si, ademas de repetida, es erronea para ponerle
		// un asterisco
		p = checkDuplicadoErroneo(p);

		// La añadimos a nuestra lista de repetidas
		duplicates.add(getPrimerDuplicado(listaPersonas, p.getDni()));
		duplicates.add(p);
	    }
	}
	writetoRepetidoFileStringBuilder(Constantes.FICHERO_REPETIDOS,
		duplicates);
	return (duplicates.size());

    }

    /**
     * Funcion que comprueba si la persona, además de repetida es erronea
     *
     * @param p
     *            la {@code Persona} repetida que vamos a comprobar
     * @return la {@code Persona} repetida con un asterisco al final para
     *         indicar que es erronea
     */
    public static Persona checkDuplicadoErroneo(Persona p) {
	Persona p1;
	try {
	    p1 = new Persona(p.getNombre(), p.getApellido(), p.getPoblacion(),
		    p.getEdad(), p.getMail(), p.getDni(), p.getCategoria());
	} catch (PersonaException e) {
	    p.setCategoriaNoCheck(p.getCategoria() + " *");
	}
	return p;
    }

    /**
     * Funcion que nos obtiene la pareja del duplicado encontrado con la funcion
     * checkRepetidos
     *
     * @param listaPersonas
     *            {@code ArrayList} un ArrayList con todas las personas
     * @param dni
     *            {@code String}: el dni que ya sabemos que esta duplicado
     * @return un objeto de la clase {@code Persona} con la pareja duplicada
     */
    public static Persona getPrimerDuplicado(ArrayList<Persona> listaPersonas,
	    String dni) {
	Persona p1 = null;
	boolean flag = false;
	for (int i = 0; i < listaPersonas.size(); i++) {
	    if (listaPersonas.get(i).getDni().equals(dni) && !flag) {
		p1 = listaPersonas.get(i);
		flag = true;
	    }
	}
	return p1;

    }

}
