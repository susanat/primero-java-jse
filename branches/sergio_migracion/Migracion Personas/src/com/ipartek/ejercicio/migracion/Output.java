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
    public static void createCorrectFile(final HashMap<eErrorCause, List<String>> lstFirstError) throws IOException {
	final String file = ClsUtilsFicheros.combinarRutas
		(Constantes.PATH_OUTPUT, Constantes.NAME_FILE_CORRECTAS);
	
	//obtengo las correctas
	List<String> lstCorrectas = lstFirstError.get(eErrorCause.NONE);
	
	ClsUtilsFicheros.writeSmallTextFile(lstCorrectas, file, Constantes.CHARSET_OUTPUT);
	
	
    }
    
    /**
     * Create file with stadistics.
     * 
     * @param objAction Object with all process of checked
     * @throws IOException Exceptions for files
     */
    public static void createStadisticFile(final Actions objAction) throws IOException {
	final String file = ClsUtilsFicheros.combinarRutas
		(Constantes.PATH_OUTPUT, Constantes.NAME_FILE_ESTADISTICAS);

	List<String> aLines = new ArrayList<String>();
	
	int lineasCorrectas = objAction.getNumberOfLinesByFirstError(eErrorCause.NONE);
	int lineasInCorrectas = objAction.getCountLinesWithErrors();

	aLines.add("Lineas Totales: " + objAction.getCountLines());
	aLines.add("Lineas Correctas: " + lineasCorrectas);
	aLines.add("Lineas con algún fallo: " + lineasInCorrectas);  	    
	aLines.add("Total analizado: " + (lineasCorrectas + lineasInCorrectas));  	    

	int errorMaxFields = objAction.getNumberOfLinesByFirstError(eErrorCause.MAX_FIELDS);
	int errorMinFields = objAction.getNumberOfLinesByFirstError(eErrorCause.MIN_FIELDS);  	    		
	int errorUtf8 = objAction.getNumberOfLinesByFirstError(eErrorCause.UTF8);
	int errorEmail = objAction.getNumberOfLinesByFirstError(eErrorCause.EMAIL);
	int errorDni = objAction.getNumberOfLinesByFirstError(eErrorCause.DNI);
	int errorEdad = objAction.getNumberOfLinesByFirstError(eErrorCause.EDAD);
	
	aLines.add(" - Campos de mas: " + errorMaxFields);
	aLines.add(" - Campos de menos: " + errorMinFields);
	aLines.add(" - Texto no validos: " + errorUtf8);
	aLines.add(" - EMAIL no valido: " + errorEmail);
	aLines.add(" - DNI no valido: " + errorDni);
	aLines.add(" - Edad no valida: " + errorEdad);
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
    public static void createErrorsFile(final HashMap<eErrorCause, List<String>> agrupedLinesByFirstError) throws IOException {
	
	final String file = ClsUtilsFicheros.combinarRutas
		(Constantes.PATH_OUTPUT, Constantes.NAME_FILE_ERRONEAS);

	final List<String> aLines = new ArrayList<String>();

	HashMap<eErrorCause, List<String>> map = new HashMap<eErrorCause, List<String>>(agrupedLinesByFirstError);

	//eliminamos las correctas:
	map.remove(eErrorCause.NONE);	

	for (Entry<eErrorCause, List<String>> lst : map.entrySet()) {	    	    
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
	
	//recorro encontrando duplicados
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
