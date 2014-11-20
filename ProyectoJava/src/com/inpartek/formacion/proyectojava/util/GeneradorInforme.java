package com.inpartek.formacion.proyectojava.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inpartek.formacion.proyectojava.exception.PersonaException;
import com.inpartek.formacion.proyectojava.pojo.Persona;

public class GeneradorInforme extends ManejadorFichero {
	private final static String P_PATTERN = ";";
	private final static String A_PATTERN = ",";

	private final static int NOMBRE_POS = 0;
	private final static int APELLIDO_POS = 1;
	private final static int POBLACION_POS = 2;
	private final static int EDAD_POS = 3;
	private final static int EMAIL_POS = 4;
	private final static int DNI_POS = 5;
	private final static int CATEGORIA_POS = 6;
	private final static int N_CAMPOS = 7;
	private final static String NOMBRE_FICHERO_ERROR = "personas-error";
	private final static String NOMBRE_FICHERO_DUPLICADO = "personas-repetidas";
	private final static String NOMBRE_FICHERO_VALIDO = "personas-correctas";
	String[] lista;
	HashMap<String, Persona> datosPersonas;
	HashMap<String, Integer> datosRepetidos;
	HashMap<String, Persona> datosErroneos;
	HashMap<String, Persona> datosCortos;
	List<String> errores;

	// TODO Sacar las validaciones a clase util
	public GeneradorInforme(final String _filePath, final String _fileName,
			final String _fileExt) {
		super(_filePath, _fileName, _fileExt);
		datosPersonas = new HashMap<String, Persona>();
		datosCortos = new HashMap<String, Persona>();
		errores = new ArrayList<String>();
		datosErroneos = new HashMap<String, Persona>();
		datosRepetidos = new HashMap<String, Integer>();
		lista = null;
	}

	public void cargarDatos() throws NumberFormatException, PersonaException {
		Persona p = null;
		String contenido = leerFichero();

		lista = toLine(contenido);
		for (String s : lista) {
			p = toPersona(s);
			if (p != null) {
				if (!isRepeated(p)) {
					if (p.isTodo()) {
						datosPersonas.put(p.getDni(), p);
					} else {
						datosCortos.put(p.getDni(), p);
					}
				} else {
					int cont = 0;
					if (datosRepetidos.get(p) != null) {
						cont = datosRepetidos.get(p);
						cont++;
					}

					datosRepetidos.put(p.getDni(), cont);

				}
			}
		}

	}

	private void gArchivoDatosFaltan() {
		final String ENCABEZADO = "PERSONAS DE LAS QUE FALTAN DATOS:";
		Persona value = null;

		this.fileName = NOMBRE_FICHERO_ERROR;
		addTexttoFile(ENCABEZADO + "\n");
		for (Map.Entry<String, Persona> entry : datosCortos.entrySet()) {
			value = entry.getValue();
			addTexttoFile(value.toFileString());
		}
	}

	private void gArchivoDatosInvalido() {
		// TODO Auto-generated method stub
		final String ENCABEZADO = "PERSONAS DE LAS QUE TIENEN LOS DATOS MAL ESCRITOS:";
		Persona value = null;

		this.fileName = NOMBRE_FICHERO_ERROR;
		addTexttoFile(ENCABEZADO + "\n");
		for (Map.Entry<String, Persona> entry : datosErroneos.entrySet()) {
			value = entry.getValue();
			addTexttoFile(value.toFileString());
		}

	}

	private void gArchivoDniInvalido() {
		final String ENCABEZADO = "PERSONAS CON DNI MAL INTRODUCIDO (POSICIÓN O TAMAÑO INCORRECTO):";
		this.fileName = NOMBRE_FICHERO_ERROR;
		addTexttoFile(ENCABEZADO + "\n");
		for (String s : errores) {
			addTexttoFile(s);
		}

	}

	private void gDatosArchivoCorrecto() {

		Persona value = null;
		this.fileName = NOMBRE_FICHERO_VALIDO;

		for (Map.Entry<String, Persona> entry : datosPersonas.entrySet()) {
			value = entry.getValue();
			addTexttoFile(value.toFileString());
		}

	}

	private void gDatosArchivoDuplicado() {

		String key = null;
		Integer value = null;
		Persona p = null;
		this.fileName = NOMBRE_FICHERO_DUPLICADO;

		for (Map.Entry<String, Integer> entry : datosRepetidos.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			p = datosPersonas.get(key);
			addTexttoFile(p.toFileString() + "\t\t\t\t\t\t" + value);
		}

	}

	private void gDatosArchivoError() {
		// datos_erroneos;

		gArchivoDniInvalido();
		gArchivoDatosFaltan();
		gArchivoDatosInvalido();
	}

	private void gEncabezadoArchivoCorrecto() {
		final String ENCABEZADO = "PERSONAS";
		this.fileName = NOMBRE_FICHERO_VALIDO;
		crearArchivoTexto(ENCABEZADO + "\n");
	}

	private void gEncabezadoArchivoDuplicado() {
		final String ENCABEZADO = "PERSONA\t\t\t\t\t\t\tN VECES";
		this.fileName = NOMBRE_FICHERO_DUPLICADO;
		crearArchivoTexto(ENCABEZADO + "\n");
	}

	private void gEncabezadoArchivoError() {
		final String ENCABEZADO = "PERSONAS CON ERRORES EN SUS ARCHIVOS";
		this.fileName = NOMBRE_FICHERO_ERROR;
		crearArchivoTexto(ENCABEZADO + "\n");
	}

	public void generarDatos() {
		/*
		 * System.out.println("c" + datos_cortos.size() + "-e" +
		 * datos_erroneos.size() + "-p" + datos_personas.size() + "-r" +
		 * datos_repetidos.size());
		 */
		gEncabezadoArchivoError();
		gDatosArchivoError();
		gEncabezadoArchivoCorrecto();
		gDatosArchivoCorrecto();
		gEncabezadoArchivoDuplicado();
		gDatosArchivoDuplicado();
	}

	private boolean isRepeated(final Persona p) {

		if (datosPersonas.containsKey(p.getDni())
				|| datosErroneos.containsKey(p.getDni())) {

			return true;
		} else {

			return false;
		}
	}

	private String[] toLine(final String _line) {
		String[] list = null;
		list = _line.split(P_PATTERN);

		return list;
	}

	private Persona toPersona(final String text) throws PersonaException {

		Persona persona = null;
		String[] list = null;
		list = text.split(A_PATTERN);

		if (UtilValidacion.validarDNI(list[DNI_POS])) {
			if (list.length == N_CAMPOS) {
				persona = validarDatos(list);
			} else {
				persona = new Persona(list[DNI_POS]);
			}
		} else {
			errores.add(text);
		}

		return persona;
	}

	private Persona validarDatos(final String[] list)
			throws NumberFormatException, PersonaException {
		Persona p = new Persona(list[DNI_POS]);
		p.setTodo(true);
		p.setNombre(list[NOMBRE_POS]);
		p.setApellido(list[APELLIDO_POS]);
		p.setPoblacion(list[POBLACION_POS]);
		p.setCategoria(list[CATEGORIA_POS]);
		if (UtilValidacion.isNumber(list[EDAD_POS])) {
			p.setEdad(Integer.parseInt(list[EDAD_POS]));
		} else {
			p.setTodo(false);
		}
		if (UtilValidacion.validarEmail(list[EMAIL_POS])) {
			p.setEmail(list[EMAIL_POS]);
		} else {
			p.setTodo(false);
		}
		return p;
	}
}
