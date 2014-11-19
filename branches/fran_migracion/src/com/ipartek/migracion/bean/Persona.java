package com.ipartek.migracion.bean;

/**
 * Persona.
 * <ol>
 * <li>nombre {@code String}</li>
 * <li>apellido {@code String}</li>
 * <li>poblacion {@code String}</li>
 * <li>edad {@code int}</li>
 * <li>email {@code String}</li>
 * <li>dni {@code String}</li>
 * <li>categoria {@code String}</li>
 * </ol>
 * 
 * 
 * @author Fran
 *
 */
public class Persona {
	// Constantes
	public static final String ERROR_EDAD = "EDAD";
	public static final String ERROR_EMAIL = "EMAIL";
	public static final String ERROR_DNI = "DNI";
	public static final String ERROR_UTF8 = "UTF8";

	// Atributos
	private String nombre;
	private String apellido;
	private String poblacion;
	private int edad;
	private String email;
	private String dni;
	private String categoria;

	/*
	 * Constructor con todos los atributos.
	 */
	public Persona(final String pNombre, final String pApellido,
			final String pPoblacion, final int pEdad, final String pEmail,
			final String pDni, final String pCategoria) {
		super();
		setNombre(pNombre);
		setApellido(pApellido);
		setPoblacion(pPoblacion);
		setEdad(pEdad);
		setEmail(pEmail);
		setDni(pDni);
		setCategoria(pCategoria);
	}

	/**
	 * Get del atributo nombre.
	 * 
	 * @return {@code String} nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Set del atributo nombre.
	 * 
	 * @param pNombre
	 *            {@code String} nombre.
	 */
	public void setNombre(final String pNombre) {
		this.nombre = pNombre;
	}

	/**
	 * Get del atributo apellido.
	 * 
	 * @return {@code String} apellido.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Set del atributo apellido.
	 * 
	 * @param pNombre
	 *            {@code String} apellido.
	 */
	public void setApellido(final String pApellido) {
		this.apellido = pApellido;
	}

	/**
	 * Get del atributo poblacion.
	 * 
	 * @return {@code String} poblacion.
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Set del atributo poblacion.
	 * 
	 * @param pNombre
	 *            {@code String} poblacion.
	 */
	public void setPoblacion(final String pPoblacion) {
		this.poblacion = pPoblacion;
	}

	/**
	 * Get del atributo edad.
	 * 
	 * @return {@code int} edad.
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Set del atributo edad.
	 * 
	 * @param pEdad
	 *            {@code int} edad.
	 */
	public void setEdad(final int pEdad) {
		this.edad = pEdad;
	}

	/**
	 * Get del atributo email.
	 * 
	 * @return {@code String} email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set del atributo email.
	 * 
	 * @param pEdad
	 *            {@code String} email.
	 */
	public void setEmail(final String pEmail) {
		this.email = pEmail;
	}

	/**
	 * Get del atributo dni.
	 * 
	 * @return {@code String} dni.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Set del atributo dni.
	 * 
	 * @param pEdad
	 *            {@code String} dni.
	 */
	public void setDni(final String pDni) {
		this.dni = pDni;
	}

	/**
	 * Get del atributo categoria.
	 * 
	 * @return {@code String} categoria.
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Set del atributo categoria.
	 * 
	 * @param pEdad
	 *            {@code String} categoria.
	 */
	public void setCategoria(final String pCategoria) {
		this.categoria = pCategoria;
	}

}
