package com.ipartek.formacion.migracion;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aeat.valida.Validador;

/**
 * Clase para hacer diferentes comprobaciones. Contiene:
 * <ol>
 * <li>DNI_RELLENO {@code int}</li>
 * <li>CANTIDAD_ATRIBUTOS {@code int}</li>
 * <li>PATTERN_EMAIL {@code String}</li>
 * </ol>
 *
 * @author Mario Alvaro
 *
 */
public class Comprobar {
    /**
     * Atributo para rellenar DNIs cuando la cantidad de atributos de una linea
     * son erroneos.
     */
    public static int DNI_RELLENO = 0;
    /**
     * Atributos máximos al comprobar los caracteres especiales. Hace mencion a
     * los atributos <code>nombre</code>, <code>apellido</code>,
     * <code>poblacion</code> y <code>categoria</code> del Objeto
     * <code>Persona</code>.
     */
    private static final int CANTIDAD_ATRIBUTOS = 4;

    /**
     * Patrón para confirmar email.
     */
    public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Crea un objeto <code>Persona</code> y comprueba si hay datos erroneos.
     *
     * @param arrayAtributos
     *            - <code>ArrayList</code> que contiene los datos recibidos del
     *            fichero.
     * @return persona - <code>Persona</code> con los atributos recibidos.
     */
    public static Persona comprobarDatos(ArrayList<String> arrayAtributos) {
	Persona persona = null;
	if (arrayAtributos.size() == Fichero.LONGITUD_TOTAL) {
	    persona = new Persona(arrayAtributos.get(0), arrayAtributos.get(1),
		    arrayAtributos.get(2), Integer.parseInt(arrayAtributos
			    .get(3)), arrayAtributos.get(4),
		    arrayAtributos.get(5), arrayAtributos.get(6));

	    comprobarErroneo(persona);

	} else {
	    Fichero.MENSAJE = "Faltan datos - Linea";
	    Fichero.FALTA_ATRIBUTO = true;
	}

	return persona;

    }

    /**
     * Compueba la instancia del tipo <code>Persona</code> para ver si hay algún
     * error de Edad, DNI, eMail, o caracteres extraños.
     *
     * @param persona
     *            - Objeto tipo <code>Persona</code>.
     */
    public static void comprobarErroneo(Persona persona) {

	if (comprobarEdad(persona.getEdad())) {
	    if (comprobarDni(persona.getDni())) {
		if (comprobarEmail(persona.getEmail())) {
		    if (comprobarCaracteresExtraños(persona)) {
			Fichero.MENSAJE = "UTF8 - Linea ";
		    }

		} else {
		    Fichero.MENSAJE = "Email - Linea ";
		}

	    } else {
		Fichero.MENSAJE = "Dni - Linea ";
	    }

	} else {
	    Fichero.MENSAJE = "Edad - Linea ";
	}

    }

    /**
     * Comprueba si el objeto de tipo <code>Persona</code> está repetido.
     *
     * @param persona
     *            - objeto de tipo <code>Persona</code> a comprobar.
     * @return repetido - TRUE si está repedito, FALSE en caso contrario.
     */
    public static boolean comprobarRepetidos(Persona persona) {
	String dni = persona.getDni();
	boolean repetido = false;
	if (Fichero.MENSAJE != null) {
	    if (Migracion.ERRONEOS.get(dni) != null) {
		dni += "*";
		Migracion.REPETIDOS_DNI.add(dni);
		repetido = true;
	    } else {
		Migracion.ERRONEOS.put(persona.getDni(), persona);
	    }

	} else {
	    if (Migracion.CORRECTOS.get(dni) != null) {
		Migracion.REPETIDOS_DNI.add(dni);
		repetido = true;
	    } else {
		Migracion.CORRECTOS.put(persona.getDni(), persona);
	    }
	}
	return repetido;
    }

    /**
     * Comprueba si la edad está comprendida entre 18 y 99 años.
     *
     * @param edad
     *            - {@code int} con la edad.
     * @return correcto - TRUE si está comprendido entre 18 y 99, FALSE en caso
     *         contrario.
     */
    public static boolean comprobarEdad(int edad) {
	boolean correcto = false;
	if (edad >= 18 || edad <= 99) {
	    correcto = true;
	}
	return correcto;
    }

    /**
     * Comprueba y valida si el DNI es correcto.
     *
     * @param dni
     *            - {@code String} con el DNI.
     * @return comprobado - TRUE si es correcto, False en caso contrario.
     */
    public static boolean comprobarDni(String dni) {
	boolean comprobado = false;
	Validador validador = new Validador();
	int e = validador.checkNif(dni);

	if (e > 0) {
	    comprobado = true;
	}
	return comprobado;

    }

    /**
     * Comprueba que el email está correcto contra el patrón
     * <code>PATTERN_EMAIL</code>.
     *
     * @param email
     *            - {@code String} con el nombre del email.
     * @return {@code boolean} TRUE si encaja en el patrón, FALSE en caso
     *         contrario.
     */

    public static boolean comprobarEmail(String email) {
	// Compilar la expresión regular dada en un patron.
	Pattern pattern = Pattern.compile(PATTERN_EMAIL);

	// Compueba el email dado contra el patron
	Matcher matcher = pattern.matcher(email);
	return matcher.matches();
    }

    /**
     * Comprueba si los atributos <code>nombre</code>, <code>apellido</code>,
     * <code>poblacion</code> y <code>categoria</code> de la clase
     * <code>Persona</code> no tenga simbolos ni caracteres especiales.
     *
     * @param persona
     *            - Objeto tipo <code>Persona</code>.
     * @return fallo - TRUE si hay algún simbolo, FALSE en caso contrario.
     */
    public static boolean comprobarCaracteresExtraños(Persona persona) {
	int indice = 0;
	boolean fallo = false;

	Pattern pattern = Pattern.compile("[^A-Za-záéíóúÁÉÍÓÚñÑ ]");
	Matcher encaja;
	String[] atr = new String[] { persona.getNombre(),
		persona.getApellido(), persona.getPoblacion(),
		persona.getCategoria() };

	while (fallo == false && indice < CANTIDAD_ATRIBUTOS) {
	    encaja = pattern.matcher(atr[indice]);
	    // Mira si el string encaja con el patron que
	    if (encaja.find()) {
		fallo = true;
	    }
	    indice++;
	}
	return fallo;
    }

    /**
     * Comprueba si falta algun atributo en la línea o si hay algún mensaje de
     * error, para escribir en el fichero correspondiente.
     *
     * @param persona
     *            - Objeto tipo <code>Persona</code>.
     * @param linea
     *            - El contenido de la linea recogida del fichero.
     */
    public static void comprobarYEscribir(Persona persona, String linea) {
	if (Fichero.FALTA_ATRIBUTO) {
	    Migracion.ERRONEOS.put("" + DNI_RELLENO, persona);
	    DNI_RELLENO++;
	    Fichero.FALTA_ATRIBUTO = false;
	    Fichero.escribirMensaje(Rutas.NOM_FICHERO_ERRONEO, Fichero.MENSAJE
		    + Fichero.NUM_LINEA);

	} else if (Fichero.MENSAJE == null) {
	    if (!Comprobar.comprobarRepetidos(persona)) {
		Fichero.escribirMensaje(Rutas.NOM_FICHERO_CORRECTO, linea);
	    }

	} else {
	    Comprobar.comprobarRepetidos(persona);
	    Fichero.escribirMensaje(Rutas.NOM_FICHERO_ERRONEO, Fichero.MENSAJE
		    + Fichero.NUM_LINEA);
	}
    }

}
