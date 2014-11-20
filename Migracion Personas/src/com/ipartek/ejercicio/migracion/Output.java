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
public final class Output {
    
    /**
     * Empty constructor.
     */
    private Output() {
	
    }
    
    /**
     * Create file with correct lines.
     * 
     * @param objAction Object type action
     * @throws IOException Exceptions for files
     */
    public static void createCorrectFile(
	    final Actions objAction) 
	    throws IOException {
	
	//preparo el fichero
	final String file = 
		ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, 
			Constantes.NAME_FILE_CORRECTAS);

	List<String> aLines = new ArrayList<String>();
	
	//obtengo las correctas
	if (objAction.getAgrupedLinesByFirstError() != null) {
	    aLines = objAction.getAgrupedLinesByFirstError().get(eErrorCause.NONE);
	}
	
	//Nos aseguramos que no sea null
	if (aLines == null) {
	    aLines = new ArrayList<String>();
	}
	
	//ClsUtilsFicheros.writeSmallTextFile(lstCorrectas, 
	//	file, Constantes.CHARSET_OUTPUT);
	
	write(file, aLines);
	
	
    }
    
    /**
     * Create file with stadistics.
     * 
     * @param objAction Object with all process of checked
     * @throws IOException Exceptions for files
     */
    public static void createStadisticFile(final Actions objAction) 
	    throws IOException {
	final String file = ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, 
		Constantes.NAME_FILE_ESTADISTICAS);

	List<String> aLines = new ArrayList<String>();
	
	int lineasCorrectas = 
		objAction.getNumberOfLinesByFirstError(eErrorCause.NONE);
	
	int lineasInCorrectas = objAction.getCountLinesWithErrors();

	aLines.add("Lineas Totales: " + objAction.getCountLines());
	aLines.add("Lineas Correctas: " + lineasCorrectas);
	aLines.add("Lineas con algún fallo: " + lineasInCorrectas);  	    
	aLines.add("Total analizado: " 
		+ (lineasCorrectas + lineasInCorrectas));  	    

	int errorMaxFields = objAction.getNumberOfLinesByFirstError(
		eErrorCause.MAX_FIELDS);
	int errorMinFields = objAction.getNumberOfLinesByFirstError(
		eErrorCause.MIN_FIELDS);  	    		
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
	
	
	
	int duplicados = 0;
	if (objAction.getGroupDuplicated() != null) {
	    duplicados = objAction.getGroupDuplicated().size();
	}
	
	
	aLines.add("Número de duplicados: " + duplicados);
	
	
	aLines.add("Tiempo de proceso: " 
		+ objAction.getTimeLapsedMiliseconds() 
		+ " milisegundos");
	
	aLines.add("Tiempo de proceso: " 
		+ ClsUtilsFechas.millisecondsToHourMinute(
			ClsUtilsNumeros.safeLongToInt(
				objAction.getTimeLapsedMiliseconds())));


	//ClsUtilsFicheros.writeSmallTextFile(aLines, 
	//	file, Constantes.CHARSET_OUTPUT);
	write(file, aLines);
    }
    
    /**
     * Create file with lines with error.
     * @param agrupedLinesByFirstError map with lines group by error
     * @throws IOException Exceptions for files
     */
    public static void createErrorsFile(final HashMap<eErrorCause, 
	    List<String>> agrupedLinesByFirstError) 
	    throws IOException {
	
	final String file = ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, 
		Constantes.NAME_FILE_ERRONEAS);

	List<String> aLines = new ArrayList<String>();

	HashMap<eErrorCause, List<String>> map = 
		new HashMap<eErrorCause, List<String>>(agrupedLinesByFirstError);

	//eliminamos las correctas:
	map.remove(eErrorCause.NONE);	

	for (Entry<eErrorCause, List<String>> lst : map.entrySet()) {	    	    
	    for (String linea : lst.getValue()) {
		aLines.add( UtilsPrograma.enumToString(lst.getKey()) +  " => " + linea);

	    }
	}


	//ClsUtilsFicheros.writeSmallTextFile(aLines, file, 
	//	Constantes.CHARSET_OUTPUT);
	write(file, aLines);
    }
    
    
    /**
     * Create file with duplicated lines (Duplicate DNI).
     * 
     * @param objAction object with action
     * @throws IOException Exceptions for files
     */
    public static void createDuplicatedFile(final Actions objAction) 
	    throws IOException {
	String file = ClsUtilsFicheros.combinarRutas(Constantes.PATH_OUTPUT, 
		Constantes.NAME_FILE_REPETIDAS);

	List<String> aLines = new ArrayList<String>();

	if (objAction.getGroupDuplicated() != null) {
	    for (Entry<String, List<Persona>> dniDuplicated  
		    : objAction.getGroupDuplicated().entrySet()) {
	    
		for (Persona persona : dniDuplicated.getValue()) {
		    aLines.add(persona.toString());
		}
	    }    
	}
	
	
	write(file, aLines);
	
	
	
    }
    
    private static void write(String file, List<String> aLines) throws IOException{
	ClsUtilsFicheros.writeFile1(file, aLines);
    }

}
