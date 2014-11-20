package com.ipartek.formacion.primero.practicas.migracion;

/**
 * Clase que contiene la persona y el error que se ha producido al crearla
 * 
 * @author Jose A. Perez
 *
 */
public class PersonaError implements Comparable<PersonaError> {
	private String error;
	private Persona persona;

	/**
	 * Constructor de un ErrorPersona
	 *
	 * @param error
	 *            {@code String} error que se ha producido al crear esa persona
	 * @param persona
	 *            {@code Persona} Persona
	 */
	public PersonaError(String error, Persona persona) {
		super();
		this.error = error;
		this.persona = persona;
	}

	// Getters y Setters
	// No se permite modificar los datos una vez creado la ErrorPersona
	public String getError() {
		return error;
	}

	public Persona getPersona() {
		return persona;
	}

	@Override
	public int compareTo(PersonaError pError) {
		if (this.getPersona().getDni().equals(pError.getPersona().getDni())) {
			return 0;
		} else {
			return 1;
		}

	}
}
