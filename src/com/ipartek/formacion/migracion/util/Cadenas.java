package com.ipartek.formacion.migracion.util;

import com.ipartek.formacion.migracion.bean.Persona;
import com.ipartek.formacion.migracion.excepciones.PersonaException;

public class Cadenas {

	static String separador = ",";

	/*
	 * public static void main(String[] args) throws NumberFormatException,
	 * PersonaException {
	 *
	 * String lineaPersona =
	 * "Ted,Upton,Sant Andreu De La Barca,8,tedfupton@mailinator.com,12277015Y,TRABAJADOR"
	 * ; trocearCadenas(lineaPersona); }
	 */

	/**
	 * Recoge cada linea del fichero personas.txt y los separa en campos que
	 * guarda en un objeto persona para comprobar si estan correctos *
	 *
	 * @param lineaPersona
	 *            {@code string} con la linea del fichero de texto
	 * @throws PersonaException
	 *             lanza una excepcion si los datos no son correctos
	 */
	public static void trocearCadenas(String lineaPersona)
			throws PersonaException {

		Persona p = new Persona();
		try {

			String[] arrayPersona = lineaPersona.split(separador);
			p.setNombre(arrayPersona[0]);
			p.setApellido1(arrayPersona[1]);
			p.setPoblacion(arrayPersona[2]);
			p.setEdad(Integer.parseInt(arrayPersona[3]));
			p.setMail(arrayPersona[4]);
			p.setDni(arrayPersona[5]);
			p.setCategoria(arrayPersona[6]);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}
}
