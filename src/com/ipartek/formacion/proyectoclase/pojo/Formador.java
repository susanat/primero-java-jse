package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Calendar;

import com.ipartek.formacion.proyectoclase.excepciones.PersonaException;

/**
 *
 * @author Urko Villanueva
 *
 */
public class Formador extends Persona {
	/**
	 *
	 */
	private Double sueldo;
	/**
	 *
	 */
	public static final Double SUELDO_MINIMO = 756.00;

	/**
	 * @throws PersonaException
	 * @throws LongitudTextoException
	 *
	 */
	public Formador() throws PersonaException {
		// TODO Auto-generated constructor stub
		super();
		setSueldo(SUELDO_MINIMO);

	}

	public Formador(String nombre, String papellido, String sapellido,
			String dni, String telefono, Double sueldo) {
		super(nombre, papellido, sapellido, dni, telefono);
		// TODO Auto-generated constructor stub
		setSueldo(sueldo);
	}

	public Formador(String nombre, String papellido, String sapellido,
			String dni, String poblacion, Calendar fnacimiento,
			String telefono, char sexo, Boolean trabajando, Integer nhermanos,
			Libro libro, Double sueldo) throws PersonaException {
		super(nombre, papellido, sapellido, dni, poblacion, fnacimiento,
				telefono, sexo, trabajando, nhermanos, libro);
		setSueldo(sueldo);

	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		if (sueldo >= Formador.SUELDO_MINIMO)
			this.sueldo = sueldo;
	}

}
