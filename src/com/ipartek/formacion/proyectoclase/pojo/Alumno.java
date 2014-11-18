package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.proyectoclase.excepciones.PersonaException;

/**
 *
 * @author Urko Villanueva
 *
 */
public class Alumno extends Persona {
	/**
 *
 */
	private Map<String, Integer> calificaciones;

	/**
	 *
	 * @throws PersonaException
	 */
	public Alumno() throws PersonaException {
		super();
	}

	public Alumno(String nombre, String papellido, String sapellido,
			String dni, String telefono) {
		super(nombre, papellido, sapellido, dni, telefono);

	}

	public Alumno(final String nombre, final String p_apellido,
			final String s_apellido, final String dni, final String poblacion,
			final Calendar f_nacimiento, String telefono, char sexo,
			Boolean trabajando, Integer n_hermanos, Libro libro,
			HashMap<String, Integer> calificaciones) throws PersonaException {
		super(nombre, p_apellido, s_apellido, dni, poblacion, f_nacimiento,
				telefono, sexo, trabajando, n_hermanos, libro);
		setCalificaciones(calificaciones);
	}

	public Map<String, Integer> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(HashMap<String, Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}
}
