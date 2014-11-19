package com.ipartek.formacion.primero.practicas.migracion;

import java.util.ArrayList;

/**
 * Clase que contiene una lista de Personas
 *
 * @author Jose A. Perez
 *
 */
public class ListaPersona {
	// Atributos
	private ArrayList<Persona> vPersona;

	// Constructor
	public ListaPersona() {
		super();
	}

	// Otras
	/**
	 * Agnade una Persona a la lista
	 *
	 * @param persona
	 * @param valenRepetidos
	 *            Si es True anade la persona aunque se encuentre en la lista Si
	 *            es False no anade una persona y devolvera un False para
	 *            indicar que no la ha anadido
	 */
	public boolean anadirPersona(Persona persona, boolean valenRepetidos) {
		boolean bAnadido = false;
		// Si no valen valores repetidos
		// comprueba que no se encuentre en la lista
		// eoc no la anade y devuelve un false
		if (!valenRepetidos) {
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
	public Persona extraerPersona(String dni) {
		Persona persona = null;
		// Creamos una Persona y le asignamos el dni
		Persona personaDni = new Persona();
		try {
			personaDni.setDni(dni);
			// Busca una persona con ese dni
			int nPosicion = this.vPersona.indexOf(personaDni);
		} catch (Exception e) {

		} finally {
			return persona;
		}
	}

}
