package com.ipartek.formacion.primero.util;

import java.util.HashMap;

public class Dado {
	static final int TIRADAS = 1000;
	HashMap<String, Integer> mapEstadisticas;
	static final String LINEAS_SEPARACION = "---------------------------------------- ";
	static final int SEPARACION_MAX = 40;

	public static final String[] ALUMNOS_TIRADA = new String[] { "Susana",
		"Zuahitz", "Kepa", "Urko", "Jon", "Sergio", "Joseba", "Mario",
		"Aritz", "Fran", "Maitane", "Jose" };

	static public void tirar() {
		int aleatorio = getTirada();
		System.out.println(ALUMNOS_TIRADA[aleatorio]);
	}

	static public int getTirada() {
		return (int) (Math.random() * ALUMNOS_TIRADA.length);
	}

	/**
	 * Muestra por pantalla una tabla con todos los participantes y el numero de
	 * veces que han salido elegidos
	 *
	 * ej:
	 * 		---------------------------------------
	 * 		Participante		|			Tiradas
	 * 	    ---------------------------------------
	 * 		Susana								12
	 * 		Zuhaitz								98
	 * 		Fran							 1.112
	 * 		etc								   etc
	 * 		---------------------------------------
	 * 		13 participantes				 2.345
	 * 		---------------------------------------
	 *
	 * @param numTiradas
	 *            - numero de veces a tirar el Dado
	 */
	public static void estadisticas(int numTiradas) {

		HashMap<String, Integer> mapEstadis = new HashMap<String, Integer>();
		mapEstadis = calcularEstadisticas(mapEstadis);
		System.out.println("Estadisticas: ");
		System.out.println(LINEAS_SEPARACION);
		System.out.println("Participante        |            Tiradas ");
		System.out.println(LINEAS_SEPARACION);
		String nombre;

		for (int i = 0; i < mapEstadis.size(); i++) {
			nombre = ALUMNOS_TIRADA[i];
			System.out.format("%1s", nombre);
			System.out.format("%" + (SEPARACION_MAX - nombre.length()) + "s\n", mapEstadis.get(nombre));
		}
		System.out.println(LINEAS_SEPARACION);
		System.out.format("%1s%4s%24s \n", mapEstadis.size(), " participantes", TIRADAS );
		System.out.println(LINEAS_SEPARACION);

	}

	/**
	 * Calcula las estadisticas y se guardan en un {@code HashMap}
	 * @param mapEstadisticas - mapa vacío para las estadisticas
	 * @return mapEstadisticas - el mismo mapa con las estadisticas completadas
	 */
	public static HashMap<String, Integer> calcularEstadisticas(HashMap<String, Integer> mapEstadisticas){

		String alumno;
		for (int i = 0; i < TIRADAS; i++) {
			alumno = ALUMNOS_TIRADA[getTirada()];
			if (mapEstadisticas.get(alumno) != null){
				mapEstadisticas.put(alumno, mapEstadisticas.get(alumno)+1) ;
			}else{
				mapEstadisticas.put(alumno, 1) ;
			}
		}
		return mapEstadisticas;
	}

	public static void main(String[] args) {
		//tirar();
		estadisticas(1);
	}

}
