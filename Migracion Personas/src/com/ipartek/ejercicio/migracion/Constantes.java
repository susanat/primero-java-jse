package com.ipartek.ejercicio.migracion;

import java.util.HashMap;

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
	
    public static final String STR_SEPARATOR = ",";
	
    public static final int NUM_EXPECTED_FIELDS = 7;
    
    public static final int MIN_EDAD = 18;
    public static final int MAX_EDAD = 99;
      
	    
    public static final HashMap<Integer, String> mapCamposPos;
    static
    {
	mapCamposPos = new HashMap<Integer, String>();
	mapCamposPos.put(1, "setNombre");
	mapCamposPos.put(2, "setApellido1");
	mapCamposPos.put(3, "setPoblacion");
	mapCamposPos.put(4, "setEdad");
	mapCamposPos.put(5, "setEmail");
	mapCamposPos.put(6, "setDni");
	mapCamposPos.put(7, "setCargo");
    }
	
}
