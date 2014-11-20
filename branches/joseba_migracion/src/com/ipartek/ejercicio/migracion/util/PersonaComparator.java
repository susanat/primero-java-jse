package com.ipartek.ejercicio.migracion.util;

import java.util.Comparator;
/**
 * Clase comparator para comparar dos objetos de la clase persona por su DNI
 */
import com.ipartek.ejercicio.migracion.Persona;

public class PersonaComparator implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
	return o1.getDni().compareTo(o2.getDni());

    }

}
