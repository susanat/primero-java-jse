package com.ipartek.formacion.migracion;

/**
 * Clase para guaradar las rutas de los ficheros de salida y de entrada.
 * Contiene:
 *
 * <ol>
 * <li>NOM_FICHERO_ESTADISTICAS {@code String}</li>
 * <li>NOM_FICHERO_REPETIDOS {@code String}</li>
 * <li>NOM_FICHERO_CORRECTO {@code String}</li>
 * <li>NOM_FICHERO_ERRONEO {@code String}</li>
 * <li>NOM_FICHERO_ENTRADA {@code String}</li>
 * </ol>
 *
 * @author Mario Alvaro
 *
 */
public class Rutas {

    public static final String NOM_FICHERO_ESTADISTICAS = "Ficheros/Salida/estadisticas.txt";
    public static final String NOM_FICHERO_REPETIDOS = "Ficheros/Salida/repetidos.txt";
    public static final String NOM_FICHERO_CORRECTO = "Ficheros/Salida/personas_correcto.txt";
    public static final String NOM_FICHERO_ERRONEO = "Ficheros/Salida/personas_error.txt";
    public static final String NOM_FICHERO_ENTRADA = "Ficheros/Entrada/personas.txt";
}
