package com.ipartek.formacion.primero.practicas.migracion;

import java.util.ArrayList;

import com.ipartek.formacion.primero.excepciones.PersonaException;

/**
 * Clase que contiene una lista de Personas
 *
 * @author Jose A. Perez
 *
 */
public class ListaPersonaError {
	// Atributos
	private ArrayList<PersonaError> vPersona;
	private boolean admiteRepetidos;

	// Constructor
	/**
	 * Creacion de una lista de PersonasError
	 *
	 * @param admiteRepetidos
	 *            {@code boolean} indica si la lista admite elementos repetidos
	 *            o no
	 */
	public ListaPersonaError(boolean admiteRepetidos) {
		super();

	}

	// Otras
	/**
	 * Agnade una Persona a la lista
	 *
	 * @param persona
	 *            {@code PersonaError}
	 * @return boolean
	 *         <ul>
	 *         <li>Si admite reptidos anade la PersonaError aunque se encuentre
	 *         en la lista y devuelve True</li>
	 *         <li>Si no admite repetidos y encuentra la PersonaError, no la
	 *         anade y devuelve un False</li>
	 *         <li>Si no admite repetidos y no encuentra la PersonaError, la
	 *         anade y devuelve un True</li>
	 *         </ul>
	 */
	public boolean anadirPersona(PersonaError persona) {
		boolean bAnadido = false;
		// Si no valen valores repetidos
		// comprueba que no se encuentre en la lista
		// eoc no la anade y devuelve un false
		if (!this.admiteRepetidos) {
			if (!this.vPersona.contains(persona)) {
				this.vPersona.add(persona);
				bAnadido = true;
			}
		} else {
			this.vPersona.add(persona);
			bAnadido = true;
		}
		return bAnadido;
	}

	/**
	 * Extrae de la lista la persona con el dni indicado
	 *
	 * @param dni
	 * @return Persona que contiene ese dni en la lista
	 */
	public PersonaError devolverPersona(String dni) {
		PersonaError persona = null;
		// Creamos una Persona y le asignamos el dni
		PersonaError personaDni = new PersonaError("", new Persona());
		try {
			personaDni.getPersona().setDni(dni);
			// Busca una persona con ese dni
			int nPosicion = this.vPersona.indexOf(personaDni);
			persona = this.vPersona.get(nPosicion);
		} catch (PersonaException e) {
			System.out.println("Se ha producido un error");
		} finally {
			return persona;
		}
	}

}
