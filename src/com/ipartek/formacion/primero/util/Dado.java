package com.ipartek.formacion.primero.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dado {

	public static final String[] ALUMNOS_TIRADA = new String[] { "Susana",
			"Zuahitz", "Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario",
			"Aritz", "Fran", "Maitane", "Jose" };

	public static String lineaSeparador = "---------------------------------------";
	public static String cabeceraTabla = "Participantes  		      |Tiradas";

	public static HashMap<Integer, Integer> tabla = new HashMap<Integer, Integer>();
	static DecimalFormat formateador = new DecimalFormat("###,###.##");

	static public void tirar() {
		int aleatorio = getTirada();
		System.out.println(ALUMNOS_TIRADA[aleatorio]);
	}

	static public int getTirada() {
		return (int) (Math.random() * ALUMNOS_TIRADA.length);
	}

	public static void main(String[] args) {
		estadisticas(1000000);
		pintarHashMap(1000000);

	}

	/**
	 * Muestra por pantalla una tabla con todos los participantes y el numero de
	 * veces que han salido en los tiros
	 *
	 *
	 * ej:
	 *
	 * -------------------------------------------- Participantes |Tiradas
	 * -------------------------------------------- Susana 12 Zuhaitz 98 Fran
	 * 1.112 etc etc -------------------------------------------- 12
	 * participantes 2.345 --------------------------------------------
	 *
	 * @param numTiradas
	 *            Numero de veces a tirar el dado
	 */

	public static void estadisticas(int numTiradas) {

		int clave = -1;
		int valor = 0;
		inicializarHashMap();
		for (int i = 0; i < numTiradas; i++) {

			clave = getTirada();
			valor = tabla.get(clave);
			valor++;
			tabla.put(clave, valor);

		}

	}

	public static void pintarHashMap(int numTiradas) {
		System.out.println(lineaSeparador);
		System.out.println(cabeceraTabla);
		System.out.println(lineaSeparador);

		Iterator it = tabla.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(ALUMNOS_TIRADA[(Integer) e.getKey()]
					+ "                         "
					+ formateador.format(e.getValue()));
		}

		System.out.println(lineaSeparador);
		System.out.println(tabla.size() + " participantes" + "             "
				+ formateador.format(numTiradas));
		System.out.println(lineaSeparador);
	}

	public static void inicializarHashMap() {
		for (int i = 0; i < ALUMNOS_TIRADA.length; i++) {
			tabla.put(i, 0);

		}
	}
}
