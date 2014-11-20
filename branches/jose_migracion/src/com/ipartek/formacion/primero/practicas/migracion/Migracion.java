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
			String linea;
			String errorDato;

			// Inicializamos la lista de los PersonaError
			ListaPersonaError vCorrectos = new ListaPersonaError(false);
			ListaPersonaError vErroneos = new ListaPersonaError(true);
			ListaPersonaError vRepetidos = new ListaPersonaError(true);

			// Creamos la Estadistica
			Estadistica estadistica = new Estadistica();
			// Inicializamos la Estadistica
			estadistica.inicializar();

			while ((linea = fDatos.leer()) != null) {
				System.out.println(linea);

				// Nos creamos una Persona
				Persona p = new Persona();
				// Le asignamos los valores
				errorDato = tratarDatos(linea, p);
				// Creamos un PersonaError
				PersonaError pError = new PersonaError(errorDato, p);

				// Aumentamos en uno el numero de registros leidos
				estadistica.aumentarRegistrosLeidos();

				// Si NO se ha producido un error durante la creacion
				if (errorDato.isEmpty()) {
					// Se anade la persona a la lista de las correctas
					// Si acaso ya esta no lo anadira y devolvera un false
					boolean bAnadido = vCorrectos.anadirPersona(pError);

					if (bAnadido) {
						// Debemos comprobar que esa persona no esta en la lista
						// de los Erroneos
						PersonaError pExiste = vErroneos.devolverPersona(pError
								.getPersona().getDni());

						if (pExiste != null) {
							// Si la persona no esta en la lista de los Erroneos
							// se anade a los correctos
							vCorrectos.anadirPersona(pError);
							estadistica.aumentarRegistrosCorrectos();
						} else {
							// Si la persona esta en la lista de los Erroneos
							// se anade en los repetidos el que es erroneo
							vRepetidos.anadirPersona(pExiste);
							// aumentamos el numero de duplicados
							estadistica.aumentarRegistrosDuplicados();

							// No se anade el que hemos creado por que lo
							// haremos al final del proceso
							// TODO: hacerlo!!!!!!
						}

					} else {
						// Si ya esta la persona
						// se añade a la lista de los duplicados
						vRepetidos.anadirPersona(pError);
						// aumentamos en uno las personas duplicadas
						estadistica.aumentarRegistrosDuplicados();
					}

				} else {
					// Si se ha producido error durante la creacion
					vErroneos.anadirPersona(pError);
					// aumentamos en uno las personas con error
					estadistica.aumentarRegistrosErroneos();
				}

			}

			estadistica.finalizar();
			System.out.println("Leidos: " + estadistica.getRegistrosLeidos());
			System.out.println("Correctos: "
					+ estadistica.getRegistrosCorrectos());
			System.out.println("Erroneos: "
					+ estadistica.getRegistrosErroneos());
			System.out.println("Duplicados: "
					+ estadistica.getRegistrosDuplicados());

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
