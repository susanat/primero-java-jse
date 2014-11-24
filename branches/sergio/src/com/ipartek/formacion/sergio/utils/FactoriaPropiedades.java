package com.ipartek.formacion.sergio.utils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * Factoria que construye los objetos Properties que encapsulan las
 * propiedades de la aplicaci�n. Los ficheros de propiedades
 * deben estar en el classpath.
 * @version 1.0
 * @created 02-sep-2009
 */
public final class FactoriaPropiedades {

    /**
     * HashMap que almacena las instancias creadas.
     */
    private static HashMap hmInstancias;

    /**
     * Logger.
     */
    //private static Log oLog = LogFactory.getLog(FactoriaPropiedades.class);

    /**
     * Constante que almacena la extensi�n de los ficheros .properties.
     */
    private final static String EXTENSIONPROPERTIES = ".properties";

    /**
     * Obtiene las propiedades contenidas en un fichero de propiedades.
     * @param sNombreArchivo Nombre del fichero sin el .properties
     * @return Objeto Properties.
     */
    public static Properties getProps(final String sNombreArchivo) {
        Properties oProp = null;

        // Comprueba si la factoria est� inicializada.
        if (hmInstancias == null) {
            inicializar();
        }

        // Comprueba si existe una instancia para ese fichero de propiedades
        // y si no la crea.
        oProp = (Properties) hmInstancias.get(sNombreArchivo);
        if (oProp == null) {
            oProp = crearProp(sNombreArchivo);
            hmInstancias.put(sNombreArchivo, oProp);
        }

        return oProp;
    }

    /**
     * Inicializa la factor�a.
     */
    private static void inicializar() {
        hmInstancias = new HashMap();

        
        //if (oLog.isDebugEnabled()) {
        //    oLog.debug("Factor�a de propiedades inicializada");
        //}
    }

    /**
     * Obtiene el objeto Properties que mapea las propiedades del fichero.
     * @param sNombreFichero Nombre del fichero de propiedades
     * @return Objeto Properties.
     */
    private static Properties crearProp(final String sNombreFichero) {
        Properties oProp = null;
        InputStream isStream = null;

        // Obtiene la URL del fichero de propiedades.
        URL uURL = CargadorRecursos.getRecurso(sNombreFichero
                   + EXTENSIONPROPERTIES);

        try {
            // Carga el fichero de propiedades
            isStream = uURL.openStream();
            oProp = new Properties();
            oProp.load(isStream);

            //if (oLog.isDebugEnabled()) {
            //    oLog.debug("Fichero de propiedades cargado");
            //}
        } catch (Exception eEx) {
            //if (oLog.isFatalEnabled()) {
            //    oLog.fatal("Error cargando el fichero de propiedades", eEx);
            //}
        } finally {
            try {
                if (isStream != null) {
                    isStream.close();
                }
            } catch (IOException eEx) {
                //if (oLog.isErrorEnabled()) {
                //    oLog.error("Error cerrando el fichero de propiedades", eEx);
                //}
            }

        }
        return oProp;

    }

    /**
     * Fuerza a que la factor�a recargue todos los ficheros de propiedades.
     */
    public static void reset() {
        inicializar();
    }

    /**
     * Constructor definido como privado para que no se instancie la clase.
     */
    private FactoriaPropiedades() {
    }
}
