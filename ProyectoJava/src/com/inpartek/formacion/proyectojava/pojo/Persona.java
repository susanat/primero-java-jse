package com.inpartek.formacion.proyectojava.pojo;

import com.inpartek.formacion.proyectojava.exception.PersonaException;
import com.inpartek.formacion.proyectojava.util.UtilValidacion;

public class Persona {

	private String nombre;
	private String apellido;
	private String poblacion;
	private int edad;
	private String email;
	private String dni;
	private String categoria;
	private boolean todo;

	public final static int EDAD_MAX = 99;
	public final static int EDAD_MIN = 0;
	public final static int TEXTO_LONG_MIN = 2;

	public Persona(final String _dni) {
		super();
		this.dni = _dni;
		this.todo = false;
	}

	public Persona(final String _nombre, final String _apellido,
			final String _poblacion, final int _edad, final String _email,
			final String _dni, final String _categoria) throws PersonaException {
		super();
		this.nombre = _nombre;
		this.apellido = _apellido;
		this.poblacion = _poblacion;
		setEdad(_edad);
		this.email = _email;
		this.dni = _dni;
		this.categoria = _categoria;
		this.todo = false;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getDni() {
		return dni;
	}

	public int getEdad() {
		return edad;
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public boolean isTodo() {
		return todo;
	}

	public void setApellido(final String _apellido) throws PersonaException {
		if (_apellido != null && _apellido.length() >= Persona.TEXTO_LONG_MIN) {
			this.apellido = _apellido;
		} else {
			this.todo = false;
			throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
					PersonaException.COD_LONG_TEXTO_NO_VALIDA);
		}
	}

	public void setCategoria(final String _categoria) throws PersonaException {
		if (_categoria != null && _categoria.length() >= Persona.TEXTO_LONG_MIN) {
			this.categoria = _categoria;
		} else {
			this.todo = false;
			throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
					PersonaException.COD_LONG_TEXTO_NO_VALIDA);
		}

	}

	public void setDni(final String _dni) throws PersonaException {
		if (UtilValidacion.validarDNI(_dni)) {
			this.dni = _dni;
		} else {
			this.todo = false;
			throw new PersonaException(PersonaException.MSG_DNI_NO_VALIDO,
					PersonaException.COD_DNI_NO_VALIDO);
		}
	}

	public void setEdad(final int _edad) throws PersonaException {
		if (_edad > EDAD_MIN && _edad <= EDAD_MAX) {
			this.edad = _edad;
		} else {
			this.todo = false;
			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
					PersonaException.COD_EDAD_NO_VALIDA);
		}
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setNombre(final String _nombre) throws PersonaException {
		if (_nombre != null && _nombre.length() >= Persona.TEXTO_LONG_MIN) {
			this.nombre = _nombre;
		} else {
			this.todo = false;
			throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
					PersonaException.COD_LONG_TEXTO_NO_VALIDA);
		}
	}

	public void setPoblacion(final String _poblacion) throws PersonaException {
		if (_poblacion != null && _poblacion.length() >= Persona.TEXTO_LONG_MIN) {
			this.poblacion = _poblacion;
		} else {
			this.todo = false;
			throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
					PersonaException.COD_LONG_TEXTO_NO_VALIDA);
		}
	}

	public void setTodo(final boolean _todo) {
		this.todo = _todo;
	}

	public String toFileString() {

		return this.dni + " " + this.nombre + " " + this.apellido + " "
				+ this.edad + " " + this.email + " " + this.poblacion + " "
				+ this.categoria;
	}
}
