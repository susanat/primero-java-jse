package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.proyectoclase.excepciones.PersonaException;

/**
 *
 * @author Urko Villanueva
 *
 */
public class Alumno extends Persona {
    /**
 *
 */
    private Map<String, Integer> calificaciones;

    /**
     *
     * @throws PersonaException
     */
    public Alumno() throws PersonaException {
	super();
    }

    public Alumno(final String nombre, final String papellido,
	    final String sapellido, final String dni, final String telefono) {
	super(nombre, papellido, sapellido, dni, telefono);

    }

    public Alumno(final String pnombre, final String ppapellido,
	    final String psapellido, final String dni, final String ppoblacion,
	    final Calendar pfnacimiento, final String ptelefono,
	    final char psexo, final Boolean ptrabajando,
	    final Integer pnhermanos, final Libro plibro,
	    final HashMap<String, Integer> pcalificaciones)
	    throws PersonaException {
	super(pnombre, ppapellido, psapellido, dni, ppoblacion, pfnacimiento,
		ptelefono, psexo, ptrabajando, pnhermanos, plibro);
	setCalificaciones(pcalificaciones);
    }

    public Map<String, Integer> getCalificaciones() {
	return calificaciones;
    }

    public void setCalificaciones(final HashMap<String, Integer> pcalificaciones) {
	this.calificaciones = pcalificaciones;
    }
}
