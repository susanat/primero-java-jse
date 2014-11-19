package com.ipartek.formacion.migracion.bean;

import java.util.StringTokenizer;

import com.ipartek.formacion.migracion.excepciones.PersonaException;

public class Cadenas {

	// String lineaPersona;
	String separador = ",";

	public void trocearCadenas(String lineaPersona)
			throws NumberFormatException, PersonaException {

		Persona p = new Persona();
		// StrinTokenIzer
		StringTokenizer st = new StringTokenizer(lineaPersona, separador);
		int cont = 0;

		String token = st.nextToken();

		while (st.hasMoreTokens()) {
			p.setNombre(token);
			p.setApellido1(token);
			p.setPoblacion(token);
			p.setEdad(Integer.parseInt(token));
			p.setMail(token);
			p.setDni(token);
			p.setCategoria(token);

			cont++;
		}

		// split
		/*
		 * String[] arrayPersona = lineaPersona.split(separador);
		 * assertEquals(personaNombre, arrayPersona[0]);
		 * assertEquals(personaApellido1, arrayPersona[1]);
		 * assertEquals(personaApellido2, arrayPersona[2]);
		 * assertEquals(personaEdad, arrayPersona[3]);
		 *
		 * // subString
		 *
		 * int inicio = 0; int fin = personaNombre.length();
		 *
		 * assertEquals(personaNombre, lineaPersona.substring(inicio, fin));
		 *
		 * inicio = fin + 1; fin += personaApellido1.length() + 1;
		 * assertEquals(personaApellido1, lineaPersona.substring(inicio, fin));
		 *
		 * inicio = fin + 1; fin += personaApellido2.length() + 1;
		 * assertEquals(personaApellido2, lineaPersona.substring(inicio, fin));
		 *
		 * inicio = fin + 1; fin += personaEdad.length() + 1;
		 * assertEquals(personaEdad, lineaPersona.substring(inicio, fin));
		 *
		 * assertEquals(9, lineaPersona.indexOf(separador, 8));
		 */
	}
}
