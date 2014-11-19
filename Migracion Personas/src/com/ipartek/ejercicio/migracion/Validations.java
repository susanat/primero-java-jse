package com.ipartek.ejercicio.migracion;

import java.util.List;

import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;

public class Validations {

    
    /**
     * Check if number of fields is expected
     * @param line
     * @return
     */
    public static eErrorCause checkNumberFields(final String line, int numberFields){
	
	eErrorCause errorCause = null;
	
	String[] splited = line.split(Constantes.STR_SEPARATOR);
	
	if(splited.length < numberFields){
	    errorCause = eErrorCause.MIN_FIELDS;
	}else if(splited.length > numberFields){
	    errorCause = eErrorCause.MAX_FIELDS;
	}
	
	return errorCause;
    }
    
    /**
     * Check duplicated lines (objects)
     */
    public static List<String> checkDuplicated(){
	//condiciones:
	//Omitir: lista de números de campos max o menos
	//Omitir: dni incorrecto
	
	
	
	
	
    }
}
