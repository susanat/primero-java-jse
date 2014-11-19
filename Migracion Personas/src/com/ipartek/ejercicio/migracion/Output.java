package com.ipartek.ejercicio.migracion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.object.Persona;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsConstantes;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFechas;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFicheros;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsNumeros;

/**
 * 
 * @author baskito
 *
 */
public class Output {
    
    /**
     * Create file with correct lines.
     * 
     * @param agrupedLinesByFirstError agrupedLinesByFirstError map with lines group by error
     * @throws IOException Exceptions for files
     */
    public static void createCorrectFile(final HashMap<eErrorCause, List<String>> agrupedLinesByFirstError) throws IOException
    {
	String file = ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, Constantes.NAME_FILE_CORRECTAS);
	
	//obtengo las correctas
	List<String> lstCorrectas = agrupedLinesByFirstError.get(eErrorCause.NONE);
	
	ClsUtilsFicheros.writeSmallTextFile(lstCorrectas, file, Constantes.CHARSET_OUTPUT);
	
	
    }
    
    /**
     * Create file with stadistics.
     * 
     * @param objAction Object with all process of checked
     * @throws IOException Exceptions for files
     */
    public static void createStadisticFile(final Actions objAction) throws IOException{
	String file = ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, Constantes.NAME_FILE_ESTADISTICAS);

	List<String> aLines = new ArrayList<String>();
	
	int lineasCorrectas = objAction.getNumberOfLinesByFirstError(eErrorCause.NONE);
	int lineasInCorrectas = objAction.getCountLinesWithErrors();

	aLines.add("Lineas Totales: " + objAction.getCountLines());
	aLines.add("Lineas Correctas: " + lineasCorrectas);
	aLines.add("Lineas con algún fallo: " + lineasInCorrectas);  	    
	aLines.add("Total analizado: " + (lineasCorrectas + lineasInCorrectas));  	    

	int error_max_fields = objAction.getNumberOfLinesByFirstError(eErrorCause.MAX_FIELDS);
	int error_min_fields = objAction.getNumberOfLinesByFirstError(eErrorCause.MIN_FIELDS);  	    		
	int error_utf8 = objAction.getNumberOfLinesByFirstError(eErrorCause.UTF8);
	int error_email = objAction.getNumberOfLinesByFirstError(eErrorCause.EMAIL);
	int error_dni = objAction.getNumberOfLinesByFirstError(eErrorCause.DNI);
	int error_edad = objAction.getNumberOfLinesByFirstError(eErrorCause.EDAD);
	aLines.add(" - Campos de mas: " + error_max_fields);
	aLines.add(" - Campos de menos: " + error_min_fields);
	aLines.add(" - Texto no validos: " + error_utf8);
	aLines.add(" - EMAIL no valido: " + error_email);
	aLines.add(" - DNI no valido: " + error_dni);
	aLines.add(" - Edad no valida: " + error_edad);
	//aLines.add(" - total: " + 
	//	(error_max_fields + error_min_fields + error_utf8 + error_email + error_dni + error_edad )
	//	);
	aLines.add("Tiempo de proceso: " + objAction.getTimeLapsedMiliseconds() + " milisegundos");
	aLines.add("Tiempo de proceso: " + ClsUtilsFechas.millisecondsToHourMinute(ClsUtilsNumeros.safeLongToInt(objAction.getTimeLapsedMiliseconds())));


	ClsUtilsFicheros.writeSmallTextFile(aLines, file, Constantes.CHARSET_OUTPUT);
    }
    
    /**
     * Create file with lines with error.
     * @param agrupedLinesByFirstError map with lines group by error
     * @throws IOException Exceptions for files
     */
    public static void createErrorsFile(final HashMap<eErrorCause, List<String>> agrupedLinesByFirstError) throws IOException{
	String file = ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, Constantes.NAME_FILE_ERRONEAS);

	List<String> aLines = new ArrayList<String>();

	HashMap<eErrorCause, List<String>> map = new HashMap<eErrorCause, List<String>>(agrupedLinesByFirstError);

	//removemos las correctas:
	map.remove(eErrorCause.NONE);
	List<String> lstErrors = new ArrayList<String>();

	for (Entry<eErrorCause, List<String>> lst : map.entrySet()){	    	    
	    for(String linea : lst.getValue()){
		aLines.add(lst.getKey().toString() +  " => " + linea);

	    }
	}

	ClsUtilsFicheros.writeSmallTextFile(aLines, file, Constantes.CHARSET_OUTPUT);
    }
    
    
    /**
     * Create file with duplicated lines (Duplicate DNI).
     * 
     * @param lstPersona list with objects type Persona
     * @throws IOException Exceptions for files
     */
    public static void createDuplicatedFile(final List<Persona> lstPersona ) throws IOException{
	String file = ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, Constantes.NAME_FILE_REPETIDAS);

	List<String> lstDuplicated = new ArrayList<String>();

	//agrupo por DNI
	HashMap<String, List<Persona>> map = new HashMap<String, List<Persona>>();
	for (Persona persona : lstPersona) {
	    String key = persona.getDni();
	    if (map.get(key) == null) {
		map.put(key, new ArrayList<Persona>());
	    }
	    map.get(key).add(persona);
	}

	String text = "";
	
	for (Entry<String, List<Persona>> lst : map.entrySet())
	{
	    //compruebo si tiene más de un elementos en la lista
	    if(lst.getValue().size() > 1){
		//está duplicado
		for(Persona persona: lst.getValue()){ 
		    text += persona.toString() + ClsUtilsConstantes.SALTO_DE_LINEA;
		    
		    lstDuplicated.add(text);
		}		
	    }
	    
	    text = "";
	}
	
	ClsUtilsFicheros.writeSmallTextFile(lstDuplicated, file, Constantes.CHARSET_OUTPUT);
	
    }

}
