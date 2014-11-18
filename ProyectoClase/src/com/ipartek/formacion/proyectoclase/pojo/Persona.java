package com.ipartek.formacion.proyectoclase.pojo;

import java.text.Collator;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import com.ipartek.formacion.proyectoclase.excepciones.PersonaException;

/**
 *
 * @author Urko Villanueva
 *
 */
public class Persona implements Comparable<Persona> {

	/**
	 *
	 */
	protected String nombre;
	/**
	 *
	 */
	protected String papellido;
	/**
	 *
	 */
	protected String sapellido;
	/**
	 *
	 */
	protected String dni;
	/**
	 *
	 */
	protected String poblacion;
	/**
	 *
	 */
	protected Date fnacimiento;
	/**
	 *
	 */
	protected String telefono;
	/**
	 *
	 */
	protected Character sexo;
	/**
	 *
	 */
	protected Boolean trabajando;
	/**
	 *
	 */
	protected Integer nhermanos;
	/**
	 *
	 */
	protected Boolean mayorEdad;
	/**
	 *
	 */
	protected Libro libro;
	/**
	 *
	 */
	public static final Integer MIN_HERMANOS = 0;
	public static final Integer MAYOR_EDAD = 18;
	public static final Integer MAX_EDAD = 99;
	public static final Integer MIN_EDAD = 18;
	public static final int TEXTO_LONG_MIN = 2;

	/**
	 * @throws PersonaException
	 * @throws LongitudTextoException
	 *
	 */
	public Persona() throws PersonaException {
		super();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, c.get(Calendar.YEAR) - MIN_EDAD);

		setNombre("   ");
		setPapellido("   ");
		setSapellido("  ");
		setDni("  ");
		setPoblacion("  ");
		setFnacimiento(c);
		setTelefono("  ");
		setSexo('v');
		setTrabajando(false);
		setNhermanos(MIN_HERMANOS);
		setLibro(new Libro());
	}

	/**
	 * @param nombre
	 * @param papellido
	 * @param sapellido
	 * @param dni
	 * @param telefono
	 */
	public Persona(final String nombre, final String papellido,
			final String sapellido, final String dni, final String telefono) {
		super();
		this.nombre = nombre;
		this.papellido = papellido;
		this.sapellido = sapellido;
		this.dni = dni;
		this.telefono = telefono;
	}

	public Persona(String nombre, Calendar fNacimiento) throws PersonaException {
		this.nombre = nombre;
		setFnacimiento(fNacimiento);
	}

	/**
	 * @param nombre
	 * @param papellido
	 * @param sapellido
	 * @param dni
	 * @param poblacion
	 * @param f_nacimiento
	 * @param telefono
	 * @param sexo
	 * @param trabajando
	 * @param nhermanos
	 * @param libro
	 * @throws PersonaException
	 * @throws LongitudTextoException
	 */
	public Persona(String nombre, String papellido, String sapellido,
			String dni, String poblacion, Calendar fnacimiento,
			String telefono, Character sexo, Boolean trabajando,
			Integer nhermanos, Libro libro) throws PersonaException {
		super();
		setNombre(nombre);
		setPapellido(papellido);
		setSapellido(sapellido);
		setDni(dni);
		setPoblacion(poblacion);
		setFnacimiento(fnacimiento);
		setTelefono(telefono);
		setSexo(sexo);
		setTrabajando(trabajando);
		setNhermanos(nhermanos);
		setLibro(libro);
	}

	/**
	 * setSexo permite cambiar el genero de la persona
	 *
	 * @param sexo
	 *            {@code Character} sexo los valores validos son V o H
	 */
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws PersonaException {
		if (nombre != null && nombre.length() >= TEXTO_LONG_MIN) {
			this.nombre = nombre;
		} else {
			throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
					PersonaException.COD_LONG_TEXTO_NO_VALIDA);
		}

	}

	public String getPapellido() {
		return papellido;
	}

	public void setPapellido(String papellido) throws PersonaException {
		if (papellido != null && papellido.length() >= TEXTO_LONG_MIN) {
			this.papellido = papellido;
		} else {
			throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
					PersonaException.COD_LONG_TEXTO_NO_VALIDA);
		}
		this.papellido = papellido;
	}

	public String getSapellido() {
		return sapellido;
	}

	public void setSapellido(String sapellido) throws PersonaException {
		if (papellido != null && sapellido.length() >= TEXTO_LONG_MIN) {
			this.sapellido = sapellido;
		} else {
			throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
					PersonaException.COD_LONG_TEXTO_NO_VALIDA);
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public Date getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(Calendar fnacimiento) throws PersonaException {
		Calendar c = Calendar.getInstance();

		if (fnacimiento.get(Calendar.YEAR) + MIN_EDAD <= c.get(Calendar.YEAR)
				&& fnacimiento.get(Calendar.YEAR) + MAX_EDAD >= c
						.get(Calendar.YEAR)) {

			this.fnacimiento = fnacimiento.getTime();

			if (fnacimiento.get(Calendar.YEAR) + MAYOR_EDAD <= c
					.get(Calendar.YEAR)) {
				this.setMayorEdad(true);
			} else {
				this.setMayorEdad(false);

			}

		} else {

			throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
					PersonaException.COD_EDAD_NO_VALIDA);

		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Boolean getTrabajando() {
		return trabajando;
	}

	public void setTrabajando(Boolean trabajando) {
		this.trabajando = trabajando;
	}

	public Integer getNhermanos() {
		return nhermanos;
	}

	public void setNhermanos(Integer nhermanos) {
		if (nhermanos >= MIN_HERMANOS) {
			this.nhermanos = nhermanos;
		}
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Boolean getMayorEdad() {
		return mayorEdad;
	}

	private void setMayorEdad(Boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
	}

	@Override
	public int compareTo(Persona o) {
		Locale locale = new Locale("es", "ES");

		Collator collator = Collator.getInstance(locale);
		// TODO Auto-generated method stub
		collator.setStrength(Collator.PRIMARY);
		return collator.compare(this.nombre, o.getNombre());
	}

	public static class ComparatorPersonaEdad implements Comparator<Persona> {

		@Override
		public int compare(Persona o1, Persona o2) {
			// TODO Auto-generated method stub

			return o1.getFnacimiento().compareTo(o2.getFnacimiento());
		}
	}

	public static class ComparadorNombres implements Comparator<Persona> {

		@Override
		public int compare(Persona o1, Persona o2) {
			// TODO Auto-generated method stub
			Locale locale = new Locale("es", "ES");

			Collator collator = Collator.getInstance(locale);

			collator.setStrength(Collator.PRIMARY);
			return collator.compare(o1.getNombre(), o2.getNombre());
		}
	}

}
