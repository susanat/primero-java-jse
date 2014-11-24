package com.ipartek.formacion.sergio.utils;

import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Clase para el tratamiento de logs
 * 
 * @author Sergio Rubio Nieto
 *
 * Inicial: 22/11/2014
 *
 */
public class C_LOG {
    
    
    public static final String LOG_PROPERTIES_PATH = ClsUtilsConstantes.PATH_PROJECT;
    public static final String LOG_PROPERTIES_NAME = "\\log4j.properties";
    public static final String LOG_PROPERTIES_FILE = LOG_PROPERTIES_PATH + LOG_PROPERTIES_NAME;
    
    /**
     * El path del proyecto. (en Constantes, aquí para pruebas)
     */
    public static final String PATH_PROJECT = System.getProperty("user.dir");
    
    /**
     * Salto de lÃ­nea genÃ©rico independiente del S.O. 
     * (uso de System.getProperty).
     * (en Constantes, aquí para pruebas)
     */
    public static final String SALTO_DE_LINEA = 
	    System.getProperty("line.separator");
    
    private static Logger LOG = null;
    
    /**
     * Constructor de la clase estática
     */
    static {
        
        LOG = Logger.getLogger(C_LOG.class);			
	
	
	//añadimos el nombre del fichero fichero
	System.setProperty("my.log", PATH_PROJECT + "\\migracion.log");
	
	System.out.println(System.getProperty("my.log"));
	
	PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
	
	LOG.info("Inicio LOG: " + new Date());
	
	
    }
    
    public static void SetLOG(String message, Level level ){	
	if (level == Level.DEBUG) {
	    if (LOG.isDebugEnabled()){
		LOG.log(level, message);
	    }
	}else{
	    LOG.log(level, message);
	}
    }
    
    public static void SetLOG(String message, Exception ex){	
		
	
	message += ClsUtilsConstantes.SALTO_DE_LINEA;		    
	message += "Mensaje: " + ex.getMessage().toString();
	message += ClsUtilsConstantes.SALTO_DE_LINEA;
	message += "StackTrace: " + ex;
	
	
	LOG.error(message);
	
	
    }
    
    public static void showFail(String mensaje, Exception ex, boolean showPanel){
	
	C_LOG.SetLOG(mensaje, ex);
	if (showPanel) {
	    try {
		showNoModalAlert(mensaje, "Migración");
	    } catch (InterruptedException e) {
		//do nothing
	    }
	}	
    }
    
    public static void showFail(Exception ex, boolean showPanel){
	showFail(ex.getMessage(), ex, showPanel);
	
    }
    
    private static Thread showNoModalAlert(final String message, final String title) throws InterruptedException{
	Thread t = new Thread(new Runnable(){
	        public void run(){
	            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	        }
	    });
	    t.start();
	    t.join();
	    
	    return t;
    }
    

}
