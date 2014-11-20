package com.inpartek.formacion.proyectojava.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	String[] lista;
	HashMap<String, Persona> personas;
	HashMap<String, Persona> datos_erroneos;
	HashMap<Persona, Integer> datos_repetidos;
	List<String> errores;

	// TODO Sacar las validaciones a clase util
	public GeneradorInforme(final String _filePath, final String _fileName,
			final String _fileExt) {
		super(_filePath, _fileName, _fileExt);
		personas = new HashMap<String, Persona>();
		errores = new ArrayList<String>();
		datos_erroneos = new HashMap<String, Persona>();
		datos_repetidos = new HashMap<Persona, Integer>();
		lista = null;
	}

	public void cargarDatos() throws NumberFormatException, PersonaException {
		Persona p = null;
		String contenido = leerFichero();

		lista = toLine(contenido);
		for (String s : lista) {
			p = toPersona(s);
			if (p != null) {
				if (isRepeted(p)) {
					if (p.isTodo()) {
						personas.put(p.getDni(), p);
					} else {
						datos_erroneos.put(p.getDni(), p);
					}
				} else {
					int cont = 0;
					if (datos_repetidos.get(p) != null) {
						cont = datos_repetidos.get(p);
						cont++;
					}

					datos_repetidos.put(p, cont);
				}
			}
		}
	}

	private boolean isRepeted(final Persona p) {

		if (personas.containsKey(p.getDni())
				|| datos_erroneos.containsKey(p.getDni())) {
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
		p.setNombre(list[NOMBRE_POS]);
		p.setApellido(list[APELLIDO_POS]);
		p.setPoblacion(list[POBLACION_POS]);
		if (UtilValidacion.IsNumber(list[EDAD_POS])) {
			p.setEdad(Integer.parseInt(list[EDAD_POS]));
		} else {
			p.setTodo(false);
		}
		if (UtilValidacion.validarEmail(list[EMAIL_POS])) {
			p.setEmail(list[EMAIL_POS]);
		} else {
			p.setTodo(false);
		}
		p.setCategoria(list[CATEGORIA_POS]);
		return p;
	}
}
