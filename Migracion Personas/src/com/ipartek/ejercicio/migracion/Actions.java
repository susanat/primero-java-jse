package com.ipartek.ejercicio.migracion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsConstantes;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFicheros;

public class Actions
{

    /**
     * Save each line of file
     */
    private List<String> strFile = null;    
    private HashMap<eErrorCause, List<String>> agrupedLinesByError = null;
    
    
    /**
     * Get the size of lines in file
     * @return Integer number of lines or null if not yet read;
     */
    public Integer getCountLines(){
	if(strFile != null){
	    return strFile.size();
	}else{
	    return null;
	}
    }
    
    /**
     * Get List of lines with determinate error cause
     * @param errorCause
     * @return
     */
    public List<String> getListOfLinesByError(final eErrorCause errorCause){
	
	if(agrupedLinesByError != null){
	    return agrupedLinesByError.get(errorCause);
	}
	
	return null;
    }
    
    /**
     * Get number of lines with determinate error cause
     * @param errorCause
     * @return
     */
    public Integer getNumberOfLinesByError(final eErrorCause errorCause){
	
	if(agrupedLinesByError != null){
	    return agrupedLinesByError.get(errorCause).size();
	}
	
	return null;
    }
    
    
    /**
     * Read indicated file and save into list
     * @throws Exception 
     * 
     */
    public void readFile(final String filePath) throws Exception
    {
	
	try {
	    strFile = ClsUtilsFicheros.readFile(filePath);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    throw e;
	}
	
    }
    
       
    
    /**
     * Start process to read list file.
     */
    public void startProcess()
    {
	//for each line	
	for (String line : strFile) {
	    
	    //System.out.println(line + ClsUtilsConstantes.SALTO_DE_LINEA);
	    
	    //Check each line for errors
	    eErrorCause eCause = checkLine(line);	    
	    
	    //Keep it 
	    eErrorCause key = eCause;
	    if (agrupedLinesByError.get(key) == null) {
		agrupedLinesByError.put(key, new ArrayList<String>());
	    }
	    agrupedLinesByError.get(key).add(line);	    
	    
	}
	
	
    }
    
    
    private eErrorCause checkLine(final String line){
	
	eErrorCause errorCause = null;   
	   
	//check max fields or min fields
	errorCause = Validations.checkNumberFields(line, Constantes.NUM_EXPECTED_FIELDS); 
	if(null != errorCause){
	    return errorCause;
	}
	    
	//correct split: create object    
	    
	    
	
	
	return eErrorCause.NONE;
    }
    
    
    public static void main(String[] args) {
	Actions objAction = new Actions();
	
	System.out.println(ClsUtilsFicheros.combinarRutas(Constantes.PATH_SOURCE,Constantes.NAME_FILE_SOURCE));
	
	
	
	try {
	    objAction.readFile(ClsUtilsFicheros.combinarRutas(Constantes.PATH_SOURCE,Constantes.NAME_FILE_SOURCE));
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	objAction.startProcess();	
	
    }
    
    
    
    
    
    

}
