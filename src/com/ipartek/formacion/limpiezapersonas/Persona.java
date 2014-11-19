package com.ipartek.formacion.limpiezapersonas;

public class Persona {
    // Atributos
    private String nombre;
    private String apellido1;
    private int edad;
    private String dni;
    private String poblacion;
    private String categoria;

    // constructor
    public Persona(String nombre, String apellido1, int edad, String dni,
	    String poblacion, String categoria) {
	super();
	this.nombre = nombre;
	this.apellido1 = apellido1;
	this.edad = edad;
	this.dni = dni;
	this.poblacion = poblacion;
	this.categoria = categoria;
    }

    // getter y setter

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido1() {
	return apellido1;
    }

    public void setApellido1(String apellido1) {
	this.apellido1 = apellido1;
    }

    public int getEdad() {
	return edad;
    }

    public void setEdad(int edad) {
	this.edad = edad;
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

    public String getCategoria() {
	return categoria;
    }

    public void setCategoria(String categoria) {
	this.categoria = categoria;
    }

}
