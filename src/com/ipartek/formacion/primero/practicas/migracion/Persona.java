package com.ipartek.formacion.primero.practicas.migracion;

import com.ipartek.formacion.primero.excepciones.PersonaException;

/**
 * Clase que representa a una persona. Se compondra de la siguiente informacion
 * <ul>
 * <li>Nombre {@code String} nombre de la persona (Obligatorio)</li>
 * <li>Apellido {@code String} apellido de la persona (Obligatorio)</li>
 * <li>Poblacion {@code String} poblacion de la persona (Obligatorio)</li>
 * <li>Edad {@code String} edad de la persona (debe estar comprendido entre 18 y
 * 99)</li>
 * <li>Email {@code String} e-mail de la persona (Obligatorio, formato
 * xxxx@xxx.xxx)</li>
 * <li>DNI {@code String} dni de la persona (Obligatorio, formato nnnnnnnnX)</li>
 * <li>Categoria {@code Categoria} categoria de la persona</li>
 * </ul>
 *
 * @author Jose A. Perez
 *
 */
public class Persona {
	// Constantes
	/**
	 * Indica la edad minima que puede tener una persona
	 */
	public static final int MIN_EDAD = 18;
	/**
	 * Indica la edad maxima que puede tener una persona
	 */
	public static final int MAX_EDAD = 99;

	// Formato de los texto
	private static final String TXT_FORMAT = "[A-Z][a-zA-Z]+";
	// Formato de validacion de un email
	private static final String EMAIL_FORMAT = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	// Formato de validacion de un DNI
	private static final String DNI_FORMAT = "\\d{8}[A-Z]";
	// Listado de la letras para validar un DNI
	private static final String DNI_LETRA = "TRWAGMYFPDXBNJZSQVHLCKE";
	// Numero de numeros de un DNI
	private static final int DNI_LONGITUD_NUMEROS = 8;

	// Atributos
	private String nombre;
	private String apellido;
	private String poblacion;
	private String edad;
	private String email;
	private String dni;
	private String categoria;

	// Constructores
	/**
	 * Constructor por defecto
	 */
	public Persona() {
		super();
	}

	/**
	 * Crea un objeto Persona con los datos indicados Si se produce un error
	 * lanzara la excepcion
	 *
	 * @param nombre
	 * @param apellido
	 * @param poblacion
	 * @param edad
	 * @param email
	 * @param dni
	 * @param categoria
	 * @throws Exception
	 *             excepcion lanzada sobre el tipo de error producido
	 */
	/*
	 * public Persona(String nombre, String apellido, String poblacion, String
	 * edad, String email, String dni, String categoria) throws Exception,
	 * PersonaException { super(); this.nombre = nombre; this.apellido =
	 * apellido; this.poblacion = poblacion; this.edad = edad; this.email =
	 * email; this.dni = dni; this.categoria = categoria; }
	 */

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el valor del nombre a la Persona
	 *
	 * @param nombre
	 * @throws Exception
	 *             error producido durante la asignacion
	 */
	public void setNombre(String nombre) throws PersonaException {
		// Comprobamos que el nombre no sea NULL
		if (nombre != null) {
			if (!nombre.isEmpty()) {
				this.nombre = nombre;
				if (!nombre.matches(TXT_FORMAT)) {
					throw new PersonaException(
							PersonaException.MSG_FORMATO_TEXTO_INCORRECTO);
				}
			} else {
				throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
			}
		} else {
			throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
		}
	}

	public String getApellido() {
		return apellido;
	}

	/**
	 * Asigna el valor de el apellido a una persona
	 *
	 * @param apellido
	 * @throws Exception
	 *             error producido durante la asignacion
	 */
	public void setApellido(String apellido) throws PersonaException {
		// Comprobamos que el apellido no sea NULL
		if (apellido != null) {
			if (!apellido.isEmpty()) {
				this.apellido = apellido;
				if (!apellido.matches(TXT_FORMAT)) {
					throw new PersonaException(
							PersonaException.MSG_FORMATO_TEXTO_INCORRECTO);
				}
			} else {
				throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
			}
		} else {
			throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
		}
	}

	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Asigna el valor de la poblacion a una Persona
	 *
	 * @param poblacion
	 * @throws Exception
	 *             error producido durante la asignacion
	 */
	public void setPoblacion(String poblacion) throws PersonaException {
		// Comprobamos que la poblacion no se NULL
		if (poblacion != null) {
			if (!poblacion.isEmpty()) {
				this.poblacion = poblacion;
				if (!poblacion.matches(TXT_FORMAT)) {
					throw new PersonaException(
							PersonaException.MSG_FORMATO_TEXTO_INCORRECTO);
				}
			} else {
				throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
			}
		} else {
			throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
		}

	}

	public String getEdad() {
		return edad;
	}

	/**
	 * Asigna el valor de la edad a una Persona
	 *
	 * @param edad
	 * @throws Exception
	 *             error producido durante la asignacion Si la edad no esta
	 *             comprendida entre 18 y 99 lanzara una excepcion pero guardara
	 *             el valor
	 */
	public void setEdad(String edad) throws PersonaException,
			NumberFormatException {
		// Si no es null anadimos la edad de la persona
		if (edad != null) {
			try {
				// AUNQUE NO ESTE COMPRENDIDA ENTRE 18 Y 99
				this.edad = edad;
				int numEdad = Integer.valueOf(edad).intValue();
				// Si no esta la edad comprendida entre 18 y 99 lanzamos
				// exception
				if (MAX_EDAD < numEdad || numEdad < MIN_EDAD) {
					throw new PersonaException(
							PersonaException.MSG_EDAD_NO_VALIDA,
							PersonaException.COD_EDAD_NO_VALIDA);
				}
			} catch (PersonaException e) {
				throw e;
			} catch (NumberFormatException e) {
				throw new NumberFormatException();
			}
		} else {
			throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
		}
	}

	public String getEmail() {
		return email;
	}

	// TODO: comprobacion validacion de email
	/**
	 * Asigna el valor de un email a una Persona
	 *
	 * @param email
	 * @throws Exception
	 *             error producido durante la asignacion Si el formato es
	 *             incorrecto lanzara una excepcion pero guardara el valor
	 */
	public void setEmail(String email) throws PersonaException {
		// Comprobar que el email no sea NULL
		if (email != null) {
			if (!email.isEmpty()) {
				// Guardo el dato
				this.email = email;
				// Comprueba que el formato sea correcto
				if (!email.matches(EMAIL_FORMAT)) {
					throw new PersonaException(
							PersonaException.MSG_FORMATO_EMAIL_INCORRECTO);
				}
			} else {
				throw new PersonaException(
						PersonaException.MSG_FORMATO_EMAIL_INCORRECTO);
			}
		} else {
			throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
		}
	}

	public String getDni() {
		return dni;
	}

	/**
	 * Asignara el valor del DNI a una Persona
	 *
	 * @param dni
	 * @throws Exception
	 *             error producido durante la asignacion Si el error es por
	 *             formato o por la letra del DNI, lanzara la excepcion pero
	 *             guardara el valor
	 */
	public void setDni(String dni) throws NumberFormatException,
			PersonaException {
		if (dni != null) {
			this.dni = dni;
			// Validar si el formato del DNI es correcto
			dni = dni.toUpperCase();
			if (!dni.matches(DNI_FORMAT)) {
				throw new PersonaException(
						PersonaException.MSG_FORMATO_DNI_INCORRECTO);
			} else {
				// Validar si la letra del DNI es correcta
				try {
					if (!correctaLetraDni(dni)) {
						throw new PersonaException(
								PersonaException.MSG_LETRA_DNI_INCORRECTA);
					}
				} catch (PersonaException e) {
					throw e;
				} catch (NumberFormatException e) {
					throw e;
				}
			}
		} else {
			throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
		}
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) throws PersonaException {
		if (categoria != null) {
			if (!categoria.isEmpty()) {
				this.categoria = categoria;
				if (!poblacion.matches(TXT_FORMAT)) {
					throw new PersonaException(
							PersonaException.MSG_FORMATO_TEXTO_INCORRECTO);
				}

			} else {
				throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
			}
		} else {
			throw new PersonaException(PersonaException.MSG_DATO_INCOMPLETO);
		}

	}

	// Otros
	/**
	 * Devuelve una cadena de texto con todos sus valores concatenados por ','
	 * nombre, apellido, poblacion, edad, email, dni, categoria
	 */
	@Override
	public String toString() {
		return nombre + ", " + apellido + ", " + poblacion + ", " + edad + ", "
				+ email + ", " + dni + ", " + categoria;
	}

	// Funcion privada para calcular la letra de un DNI a partir de su numero
	private boolean correctaLetraDni(String dni) throws NumberFormatException {
		try {
			int numDni = Integer
					.valueOf(dni.substring(0, DNI_LONGITUD_NUMEROS));
			char letraDni = dni.charAt(DNI_LONGITUD_NUMEROS);
			char letraValidaDni = DNI_LETRA.charAt(numDni % 23);
			return letraDni == letraValidaDni;
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
	}

}
