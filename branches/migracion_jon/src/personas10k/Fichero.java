package personas10k;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import personas10k.utils.Utilidades;

public class Fichero {

	static int registros_leidos = 0;
	static int registros_correctos = 0;
	static int registros_erroneos = 0;
	static int registros_duplicados = 0;

	public Fichero() {

	}

	public static void main(String[] args) {
		read("personas.txt");
	}

	public static void read(String fichero) {
		long start = System.currentTimeMillis();

		BufferedReader br = null;
		FileReader fr = null;

		HashMap<String, Persona> hmsp = new HashMap<String, Persona>();

		// para almacenar las salidas correctas
		Writer personasCorrectasWriter = null;
		FileOutputStream personasCorrectasFOS = null;
		OutputStreamWriter personasCorrectasOSW = null;

		// para almacenar los errores
		Writer personasErrorWriter = null;
		FileOutputStream personasErrorFOS = null;
		OutputStreamWriter personasErrorOSW = null;

		// para almacenar las estadisticas
		Writer personasEstadWriter = null;
		FileOutputStream personasEstadFOS = null;
		OutputStreamWriter personasEstadOSW = null;

		// para almacenar los duplicados
		Writer personasDupliWriter = null;
		FileOutputStream personasDupliFOS = null;
		OutputStreamWriter personasDupliOSW = null;

		try {
			String currentLine;
			int lineaCont = 1;

			fr = new FileReader(fichero);
			br = new BufferedReader(fr);

			personasCorrectasFOS = new FileOutputStream(
					"personas_correctas.txt");
			personasCorrectasOSW = new OutputStreamWriter(personasCorrectasFOS);
			personasCorrectasWriter = new BufferedWriter(personasCorrectasOSW);

			personasErrorFOS = new FileOutputStream("personas_error.txt");
			personasErrorOSW = new OutputStreamWriter(personasErrorFOS, "utf-8");
			personasErrorWriter = new BufferedWriter(personasErrorOSW);

			personasEstadFOS = new FileOutputStream("personas_estadisticas.txt");
			personasEstadOSW = new OutputStreamWriter(personasEstadFOS, "utf-8");
			personasEstadWriter = new BufferedWriter(personasEstadOSW);

			personasDupliFOS = new FileOutputStream("personas_duplicados.txt");
			personasDupliOSW = new OutputStreamWriter(personasDupliFOS, "utf-8");
			personasDupliWriter = new BufferedWriter(personasDupliOSW);

			// personasErrorWriter.write(contenido);

			// personas_estadisticas
			// personas_correctas
			// personas_error
			// personas_repetidas

			// Bucle para leer linea a linea
			while ((currentLine = br.readLine()) != null) {
				registros_leidos++;
				String[] persona = currentLine.split(",");

				if (persona.length != 7) {
					// error al leer persona
					personasErrorWriter.write("LINEA " + lineaCont
							+ "-NUMERO DE CAMPOS INVALIDO-" + currentLine
							+ '\n');
					registros_erroneos++;
					lineaCont++;
				} else {

					//

					String nombre = persona[0];
					String apellido = persona[1];
					String direccion = persona[2];

					int edad;
					// comprobamos si la edad es valida
					if (!Utilidades.validEdad(persona[3])) {
						// edad erronea
						personasErrorWriter.write("LINEA " + lineaCont
								+ "-EDAD ERRONEA-" + currentLine + '\n');
						registros_erroneos++;
						lineaCont++;
						continue;
					} else {
						edad = Integer.parseInt(persona[3]);
					}
					String email = persona[4];

					// comprobamos si el dni es valido
					String dni = persona[5];

					if (!Utilidades.validDNI(dni)) {
						// dni erroneo
						personasErrorWriter.write("LINEA " + lineaCont
								+ "-DNI ERRONEO-" + currentLine + '\n');

						registros_erroneos++;
						lineaCont++;
						continue;
					}

					String categoria = persona[6];

					// persona leida correctamente
					Persona p = new Persona(nombre, apellido, direccion, edad,
							email, dni, categoria);

					if (hmsp.containsKey(dni)) {
						// la persona esta duplicada
						// System.out.println("PERSONA DUPLICADA");
						personasDupliWriter.write("LINEA " + lineaCont
								+ "-PERSONA DUPLICADA " + dni + "-"
								+ currentLine + '\n');
						registros_duplicados++;
						lineaCont++;
						continue;
					} else {
						hmsp.put(dni, p);
						personasCorrectasWriter.write(currentLine + '\n');
						registros_correctos++;

					}

				}

				lineaCont++;

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			try {
				personasErrorWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				personasCorrectasWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				personasDupliWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try {

			personasEstadWriter.write("REGISTROS LEIDOS: " + registros_leidos
					+ "\n");
			personasEstadWriter.write("REGISTROS CORRECTOS:"
					+ registros_correctos + "\n");
			personasEstadWriter.write("REGISTROS ERRONEOS:"
					+ registros_erroneos + "\n");
			personasEstadWriter.write("REGISTROS DUPLICADOS:"
					+ registros_duplicados + "\n");

			long end = System.currentTimeMillis();

			Float transcurrido = new Float((end - start) / 1000.0);
			personasEstadWriter.write("TIEMPO TRANSCURRIDO:"
					+ transcurrido.toString() + " s\n");
			personasEstadWriter.close();
		} catch (IOException e) {

		}
	}
}
