package com.ipartek.ejercicio.migracion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;
import com.ipartek.ejercicio.migracion.utils.ClsUtilsFicheros;

public class Actions
{

    /**
     * Save each line of file
     */
    private List<String> strFile = null;
    
    /**
     * Agrupa las lineas por tiepo de error, una línea solo aparecerá una vez
     * y solo con el primer tipo de error encontrado. 
     */
    private HashMap<eErrorCause, List<String>> agrupedLinesByFirstError = null;
    
    
    /**
     * Agrupa las lineas por tipo de error, pero estas líneas pueden aparecer
     * en más de un error
     */
    private HashMap<eErrorCause, List<String>> agrupedLinesByAllError = null;
    
    
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
    public List<String> getAgrupedLinesByFirstError(final eErrorCause errorCause){
	
	if(agrupedLinesByFirstError != null){
	    return agrupedLinesByFirstError.get(errorCause);
	}
	
	return null;
    }
    
    /**
     * Get number of lines with determinate error cause
     * @param errorCause
     * @return
     */
    public Integer getNumberOfLinesByFirstError(final eErrorCause errorCause){
	
	if(agrupedLinesByFirstError != null){
	    return agrupedLinesByFirstError.get(errorCause).size();
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
	    //Check each line for errors, if not, next line
	    if (isCorrectLine(line)){
		createObject(line);
	    }	    
	}	
    }
    
    /**
     * 
     * @param line
     * @return first false if not is correct, tru if yes.
     */
    private boolean isCorrectLine(final String line){
	
	eErrorCause errorCause = null;   
	   
	//check max fields or min fields
	errorCause = Validations.isValidNumberFields(line, Constantes.NUM_EXPECTED_FIELDS); 
	if(null != errorCause){
	    //es incorrecta
	    //guardamos en los dos maps
	    saveInAllErrorCause(errorCause, line);
	    saveInFirstErrorCause(errorCause, line);
	    	    
	    return false;
	}else{
	    //es correcta	    
	    return true;
	}
    }
    
    
    /**
     * 
     * 
     * @param line
     * @return first error cause
     */
    private eErrorCause createObject(final String line){
	String[] splitLine = line.split(Constantes.STR_SEPARATOR);
	
	/*
	String nombre;
	String apellido1;
	String poblacion;
	String edad;
	String email;
	String dni;
	String cargo;
	*/

	//http://www.mkyong.com/java/how-to-use-reflection-to-call-java-method-at-runtime/
	//String parameter
	Class[] paramString = new Class[1];	
	paramString[0] = String.class;
	
	//creamos el objeto
	Class cls = null;
	Object obj = null;
	Method method = null;
	String functionName = null;
	String parameter = "";
	
	try {	    
	    cls = Class.forName("com.ipartek.ejercicio.migracion.object.Personas");
	    obj = cls.newInstance();
	    for(int i = 0; i < Constantes.NUM_EXPECTED_FIELDS; i++)
	    {
		//functon name
		functionName = Constantes.mapCamposPos.get(i + 1);
		parameter = splitLine[i];
		
		//call the printItString method, pass a String param 
		method = cls.getDeclaredMethod(functionName, paramString);
		method.invoke(obj, parameter);
		
		
		
		
		
		
	    }
	    
	    //no paramater
	    Class noparams[] = {};
	    
	    //System.out.println(obj.toString());
	    method = cls.getDeclaredMethod("getErrors", noparams);
	    LinkedList<eErrorCause>  errors = (LinkedList<eErrorCause>) method.invoke(obj);
	    if(errors != null){
		System.out.println(line);
	    }
	    
	    
	     
	    
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (InstantiationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	
	
	
	return null;
    }
      
    private void saveInFirstErrorCause(eErrorCause error, String line) {
	if (agrupedLinesByFirstError == null)
	    agrupedLinesByFirstError = new HashMap<eErrorCause, List<String>>();
	
	// Keep it first error cause
	eErrorCause key = error;
	if (agrupedLinesByFirstError.get(key) == null) {
	    agrupedLinesByFirstError.put(key, new ArrayList<String>());
	}
	agrupedLinesByFirstError.get(key).add(line);
    }

    private void saveInAllErrorCause(eErrorCause error, String line) {
	if (agrupedLinesByAllError == null)
	    agrupedLinesByAllError = new HashMap<eErrorCause, List<String>>();
	
	
	
	eErrorCause key = error;
	if (agrupedLinesByAllError.get(key) == null) {
	    agrupedLinesByAllError.put(key, new ArrayList<String>());
	}
	agrupedLinesByAllError.get(key).add(line);
    }
    

    public static void main(String[] args) {
  	Actions objAction = new Actions();
  	
  	//System.out.println(ClsUtilsFicheros.combinarRutas(Constantes.PATH_SOURCE,Constantes.NAME_FILE_SOURCE));
  	
  	
  	
  	try {
  	    objAction.readFile(ClsUtilsFicheros.combinarRutas(Constantes.PATH_SOURCE,Constantes.NAME_FILE_SOURCE));
  	    objAction.startProcess();
  	} catch (Exception e) {
  	    // TODO Auto-generated catch block
  	    e.printStackTrace();
  	}
  	
  		
  	
      }
    

}
