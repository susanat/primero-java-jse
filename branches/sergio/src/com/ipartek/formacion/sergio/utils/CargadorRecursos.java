package com.ipartek.formacion.sergio.utils;

import java.net.URL;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * Clase que se encarga de buscar y cargar los archivos de
 * recursos localizados en el classpath.
 * @version 1.0
 * @created 02-sep-2009
 */
public class CargadorRecursos {

    /**
     * Logger.
     */
    //private static Log oLog = LogFactory.getLog(CargadorRecursos.class);

    /**
     * Obtiene la URL del fichero.
     * @param sNombreFichero Nombre del fichero.
     * @return la URL del fichero.
     */
    private static URL getFileURL(final String sNombreFichero) {
        // Usa el classLoader para obtener la url del fichero.
        URL uURL = getClassLoader().getResource(sNombreFichero);

        if (uURL == null) {
            //if (oLog.isFatalEnabled()) {
            //    oLog.fatal("El fichero " + sNombreFichero + " no existe");
            //}
        }

        //if (oLog.isDebugEnabled()) {
        //    oLog.debug("La URL del fichero es: " + uURL);
        //}

        return uURL;
    }

    /**
     * Obtiene el ClassLoader asociado al thread.
     * @return el ClassLoader.
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * Obtiene la URL asociada a un recurso localizado en el classpath.
     * @param sNombre Ruta del recurso dentro del classpath.
     * @return la URL del recurso.
     */
    public static URL getRecurso(final String sNombre) {
        URL oUrl = getFileURL(sNombre);
        //if (oLog.isDebugEnabled()) {
        //    oLog.debug("El fichero "
        //    + sNombre + " se ha obtenido correctamente.");
        //}
        return oUrl;
    }

}