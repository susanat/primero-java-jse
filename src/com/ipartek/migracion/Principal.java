package com.ipartek.migracion;

import com.ipartek.migracion.bean.Fichero;
import com.ipartek.migracion.bean.Persona;

public class Principal {
	// Constantes
	private static final String ERROR_EDAD = "EDAD";
	private static final String ERROR_EMAIL = "EMAIL";
	private static final String ERROR_DNI = "DNI";
	private static final String ERROR_UTF8 = "UTF8";

	/**
	 * Separador de campos del fichero de entrada.
	 */
	private static final String separador = ",";

	public static void main(String[] args) {
		// Variable que guarda el registro tal cual es leido.
		String registro;
		// Variable que guarda los campos tras hacer la separación
		String[] desgloseReg;
		// Variable que contendrá el objeto persona del registro leido.
		Persona persona = null;

		Fichero fic = new Fichero();
		// Abrir fichero "personas.txt"
		fic.open("personas.txt");
		// Recorrer cada registro
		while ((registro = fic.readReg()) != null) {
			// Desglosar el registro
			desgloseReg = registro.split(separador);
			persona = new Persona(desgloseReg[0], desgloseReg[1],
					desgloseReg[2], Integer.parseInt(desgloseReg[3]),
					desgloseReg[4], desgloseReg[5], desgloseReg[6]);

		}
	}

}
