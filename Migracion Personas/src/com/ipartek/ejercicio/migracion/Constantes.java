package com.ipartek.ejercicio.migracion;

import com.ipartek.ejercicio.migracion.utils.ClsUtilsFicheros;

public class Constantes {
		

    public enum eErrorCause{
	NONE,
	EDAD,
	EMAIL,
	DNI,
	UTF8,
	MAX_FIELDS,
	MIN_FIELDS
    }
    
    public static final String PATH_PROJECT = System.getProperty("user.dir");
    
    
    public static final String PATH_SOURCE = ClsUtilsFicheros.combinarRutas(PATH_PROJECT, "source");
    public static final String NAME_FILE_SOURCE = "personas.txt";
    
    
    public static final String NAME_FILE_ESTADISTICAS = "estadisticas.txt";
    public static final String NAME_FILE_CORRECTAS = "personas_correctas.txt";
    public static final String NAME_FILE_ERRONEAS = "personas_error.txt";
    public static final String NAME_FILE_REPETIDAS = "personas_repetidas.txt";
	
    public static final String STR_SEPARATOR = "";
	
    public static final int NUM_EXPECTED_FIELDS = 7;
	
}
