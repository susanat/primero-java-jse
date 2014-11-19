package com.ipartek.formacion.migracion;

import java.util.HashMap;

public class Migracion {
    public static HashMap<String, Persona> CORRECTOS;
    public static HashMap<String, Persona> ERRONEOS;
    public static HashMap<String, Integer> REPETIDOS_DNI;
    public static HashMap<String, Integer> REPETIDOS_ERRONEOS;
    public static int TOTAL_LINEAS_ESTADISTICAS = 6;
    public static int CANT_SEPARACION = 20;
    public static final String SEPARACION = "-";
    public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static void main(String[] args) {
	CORRECTOS = new HashMap<String, Persona>();
	ERRONEOS = new HashMap<String, Persona>();
	REPETIDOS_DNI = new HashMap<String, Integer>();
	REPETIDOS_ERRONEOS = new HashMap<String, Integer>();

	Fichero.read();

	String contEstadisticas = Fichero.NUM_LINEA + " - Registros leídos\n";
	contEstadisticas += " minutos --- segundos\n";
	for (int i = 0; i < CANT_SEPARACION; i++) {
	    contEstadisticas += "-";
	}
	contEstadisticas += "\n" + CORRECTOS.size() + " - Correctos";
	contEstadisticas += "\n" + ERRONEOS.size() + " - Erroneos";
	contEstadisticas += "\n" + REPETIDOS_DNI.size() + " - Duplicados";

	System.out.println(contEstadisticas);
    }

}
