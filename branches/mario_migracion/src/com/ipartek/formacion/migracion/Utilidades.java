package com.ipartek.formacion.migracion;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase para utilizar ciertas herramientas estaticas y no tener que crear el
 * objeto. Contiene:
 * <ol>
 * <li>SEPARACION {@code String}</li>
 * </ol>
 * 
 * @author Mario Alvaro.
 *
 */
public class Utilidades {
    /**
     * <code>String</code> utilizado para hacer las separaciones.
     */
    public static final String SEPARACION = "----------------\r\n";

    /**
     * Separa un {@code String} dividido con un separador.
     *
     * @param linea
     *            - Línea de {@code String} a separar.
     * @return una <code>Persona</code> con sus atributos.
     */

    public static Persona separarResultado(String linea) {
	StringTokenizer stToken = new StringTokenizer(linea, Fichero.SEPARADOR);
	ArrayList<String> arrayAtributos = new ArrayList<String>();
	while (stToken.hasMoreTokens()) {
	    arrayAtributos.add(stToken.nextToken());
	}
	return Comprobar.comprobarDatos(arrayAtributos);
    }

    /**
     * Se le da un formato a una variable de tipo {@code String} con la
     * información de las líneas repetidas almacenadas por el DNI en
     * <code>REPETIDOS_DNI</code>.
     *
     * @return resul - {@code String} con los DNIs ordenados y separados.
     */
    public static String convertirRepetidos() {
	String resul = "";
	String recogedorString;
	if (Migracion.REPETIDOS_DNI.size() > 0) {
	    resul = Migracion.REPETIDOS_DNI.get(0) + "\r\n";
	    for (int i = 1; i < Migracion.REPETIDOS_DNI.size(); i++) {
		recogedorString = Migracion.REPETIDOS_DNI.get(i);
		if (recogedorString != Migracion.REPETIDOS_DNI.get(i - 1)) {
		    resul += SEPARACION;
		}
		resul += recogedorString + "\r\n";
	    }
	}
	resul += "\r\n\r\n* Las líneas repetidas además tienen un error";
	return resul;
    }

    /**
     * Crea las estadisticas con las que ha terminado la ejecución del programa.
     *
     * @return contenidoEstadisticas - {@code String} con las estadísticas de la
     *         ejecución del programa.
     */

    public static String crearEstadisticas(long tiempo_total) {
	String contenidoEstadisticas = (Fichero.NUM_LINEA)
		+ " - Registros leídos\r\n";

	long resto = tiempo_total % 60000;
	contenidoEstadisticas += (tiempo_total / 60000) + " Minutos - "
		+ (resto / 1000) + "Segundos\r\n";

	contenidoEstadisticas += SEPARACION;

	contenidoEstadisticas += "\r\n" + Migracion.CORRECTOS.size()
		+ " - Correctos";
	contenidoEstadisticas += "\r\n" + Migracion.ERRONEOS.size()
		+ " - Erroneos";
	contenidoEstadisticas += "\r\n" + Migracion.REPETIDOS_DNI.size()
		+ " - Duplicados";

	return contenidoEstadisticas;
    }
}
