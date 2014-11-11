package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Calendar;

/**
 * 
 * @author Urko Villanueva
 *
 */
public class Persona {

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
	protected Calendar fnacimiento;
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
	protected Libro libro;
	/**
	 * 
	 */
	public static final Integer MIN_HERMANOS = 0;
	
	/**
	 * 
	 */
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
		setNombre("");
		setPapellido("");
		setSapellido("");
		setDni("");
		setPoblacion("");
		setFnacimiento(Calendar.getInstance());
		setTelefono("");
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
	public Persona(final String nombre, final String papellido, final String sapellido,
			final String dni, final String telefono) {
		super();
		this.nombre = nombre;
		this.papellido = papellido;
		this.sapellido = sapellido;
		this.dni = dni;
		this.telefono = telefono;
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
	 */
	public Persona(String nombre, String papellido, String sapellido,
			String dni, String poblacion, Calendar f_nacimiento,
			String telefono, Character sexo, Boolean trabajando,
			Integer nhermanos, Libro libro) {
		super();
		setNombre(nombre);
		setPapellido(papellido);
		setSapellido(sapellido);
		setDni(dni);
		setPoblacion(poblacion);
		setFnacimiento(f_nacimiento);
		setTelefono(telefono);
		setSexo(sexo);
		setTrabajando(trabajando);
		setNhermanos(nhermanos);
		setLibro(libro);
	}
/**
 * setSexo permite cambiar el genero de la persona
 * @param sexo {@code Character} sexo los valores validos son V o H
 */
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPapellido() {
		return papellido;
	}

	public void setPapellido(String p_apellido) {
		this.papellido = p_apellido;
	}

	public String getSapellido() {
		return sapellido;
	}

	public void setSapellido(String sapellido) {
		this.sapellido = sapellido;
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

	public Calendar getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(Calendar fnacimiento) {
		this.fnacimiento = fnacimiento;
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
	
}
