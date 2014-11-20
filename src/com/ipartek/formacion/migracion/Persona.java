package com.ipartek.formacion.migracion;

/**
 * Clase para reprensentar una Persona, se compone de:
 * <ol>
 * <li>nombre {@code String}</li>
 * <li>apellido {@code String}</li>
 * <li>poblacion {@code String}</li>
 * <li>edad {@code int}</li>
 * <li>dni {@code String}</li>
 * <li>email {@code String}</li>
 * <li>categoria {@code String}</li>
 * </ol>
 *
 *
 * @author Mario Alvaro
 *
 */
public class Persona {

    // Atributos
    private String nombre;
    private String apellido;
    private String poblacion;
    private int edad;
    private String dni;
    private String email;
    private String categoria;

    // constructor
    public Persona() {
	super();
    }

    public Persona(String nombre, String apellido, String poblacion, int edad,
	    String email, String dni, String categoria) {
	super();
	setNombre(nombre);
	setApellido(apellido);
	setPoblacion(poblacion);
	setEdad(edad);
	setDni(dni);
	setEmail(email);
	setCategoria(categoria);
    }

    // getter y setter

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getPoblacion() {
	return poblacion;
    }

    public void setPoblacion(String poblacion) {
	this.poblacion = poblacion;
    }

    public int getEdad() {
	return edad;
    }

    public void setEdad(int edad) {
	this.edad = edad;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getDni() {
	return dni;
    }

    public void setDni(String dni) {
	this.dni = dni;
    }

    public String getCategoria() {
	return categoria;
    }

    public void setCategoria(String categoria) {
	this.categoria = categoria;
    }

}
