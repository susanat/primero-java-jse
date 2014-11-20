package com.inpartek.formacion.proyectojava;

import com.inpartek.formacion.proyectojava.exception.PersonaException;
import com.inpartek.formacion.proyectojava.util.GeneradorInforme;

public class Main {

	public static void main(final String[] args) throws NumberFormatException,
			PersonaException {
		GeneradorInforme ejercicio = new GeneradorInforme("d:/", "personas",
				"txt");
		ejercicio.cargarDatos();

		ejercicio.generarDatos();
	}
}
