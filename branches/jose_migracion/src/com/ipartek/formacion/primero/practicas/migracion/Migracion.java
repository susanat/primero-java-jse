package com.ipartek.formacion.primero.practicas.migracion;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.ipartek.formacion.primero.excepciones.PersonaException;

public class Migracion {

	// informacion de los ficheros
	private static final String NOMBRE_FICHERO_DATOS = "C:\\DESARROLLO\\Java\\personas2.txt";
	private static final String NOMBRE_FICHERO_ESTADISTICAS = "";
	private static final String NOMBRE_FICHERO_CORRECTOS = "";
	private static final String NOMBRE_FICHERO_ERRONEOS = "";
	private static final String NOMBRE_FICHERO_REPETIDOS = "";

	// informacion de los datos
	private static final int NUMERO_DATOS = 7;
	private static final int IND_NOMBRE = 0;
	private static final int IND_APELLIDO = 1;
	private static final int IND_POBLACION = 2;
	private static final int IND_EDAD = 3;
	private static final int IND_EMAIL = 4;
	private static final int IND_DNI = 5;
	private static final int IND_CATEGORIA = 6;

	public static void main(String[] args) {
		// Leer el fichero con los datos
		FicheroLectura fDatos = new FicheroLectura();
		try {
			fDatos.abrirFichero(NOMBRE_FICHERO_DATOS);
			System.out.println("Leer fichero");

			// Leer las lineas del fichero
			String lineaDatos;
			// Leer la primera linea
			String primeraLinea = fDatos.leer();
			System.out.println(primeraLinea);
			Persona p = new Persona();

			tratarDatos(primeraLinea, p);

			// Creamos la Estadistica
			Estadistica estadistica = new Estadistica();
			// Inicializamos la Estadistica
			estadistica.inicializar();

		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + NOMBRE_FICHERO_DATOS
					+ " no existe");
		} catch (IOException e) {
			System.out.println("Se ha producido un error al leer el fichero");
		}
	}

	/**
	 * A partir de una linea de texto y una Persona actualiza la Persona con los
	 * datos de la linea de texto
	 *
	 * @param lineaDatos
	 *            {@code String} linea del fichero de texto a tratar
	 * @param p
	 *            {@code Persona} Persona donde se guarda los datos de la linea
	 * @return indice del ultimo error producido al crear el objeto Si es "" no
	 *         se ha producido ningun error
	 */
	private static String tratarDatos(String lineaDatos, Persona p) {
		String[] vDatos = new String[NUMERO_DATOS];
		vDatos = lineaDatos.split(",");

		String indError = "";
		int indCampo = IND_NOMBRE;
		anadirDato(p, indCampo, vDatos, indError);

		indCampo = IND_APELLIDO;
		anadirDato(p, indCampo, vDatos, indError);

		indCampo = IND_POBLACION;
		anadirDato(p, indCampo, vDatos, indError);

		indCampo = IND_EDAD;
		anadirDato(p, indCampo, vDatos, indError);

		indCampo = IND_EMAIL;
		anadirDato(p, indCampo, vDatos, indError);

		indCampo = IND_DNI;
		anadirDato(p, indCampo, vDatos, indError);

		indCampo = IND_CATEGORIA;
		anadirDato(p, indCampo, vDatos, indError);

		return indError;
	}

	/**
	 * A partir del array de datos y de su indice anade el valor en la propiedad
	 * correspondiente de la Persona
	 *
	 * @param p
	 *            {@code Persona} Persona donde guardar los datos
	 * @param indice
	 *            {@code int} indice del array de String
	 * @param vDatos
	 *            {@code String []} array con los datos
	 * @param indError
	 *            {@code String} indice del campo que ha producido el error
	 * @return indice actualizado
	 */
	private static int anadirDato(Persona p, int indice, String[] vDatos,
			String indError) {
		try {
			switch (indice) {
			case IND_NOMBRE:
				p.setNombre(vDatos[IND_NOMBRE]);
				break;
			case IND_APELLIDO:
				p.setApellido(vDatos[IND_APELLIDO]);
				break;
			case IND_POBLACION:
				p.setPoblacion(vDatos[IND_POBLACION]);
				break;
			case IND_EDAD:
				p.setEdad(vDatos[IND_EDAD]);
				break;
			case IND_EMAIL:
				p.setEmail(vDatos[IND_EMAIL]);
				break;
			case IND_DNI:
				p.setDni(vDatos[IND_DNI]);
				break;
			case IND_CATEGORIA:
				p.setCategoria(vDatos[IND_CATEGORIA]);
			}
		}

		catch (PersonaException e) {
			indError = String.valueOf(indice);
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			indError = String.valueOf(indice);
			System.out.println(e.getMessage());
		}

		finally {
			return indice++;
		}

	}
}
