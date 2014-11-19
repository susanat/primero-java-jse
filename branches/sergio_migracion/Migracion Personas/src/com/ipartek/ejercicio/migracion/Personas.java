package com.ipartek.ejercicio.migracion;

import com.ipartek.ejercicio.migracion.Constantes.eErrorCause;

public class Personas {

    private String nombre;
    private String apellido1;
    private String poblacion;
    private int edad;
    private String email;
    private String dni;
    private String cargo;
    
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

    public String getCargo() {
	return cargo;
    }

    public void setCargo(String cargo) {
	this.cargo = cargo;
    }

    public Personas(String nombre, String apellido1, String poblacion,
	    int edad, String email, String dni, String cargo) {
	super();
	this.setNombre(nombre);
	this.setApellido1(apellido1);
	this.setPoblacion(poblacion);
	this.setEdad(edad);
	this.setEmail(email);
	this.setDni(dni);
	this.setCargo(cargo);
    }

    @Override
    public String toString() {
	return "Personas [nombre=" + nombre + ", apellido1=" + apellido1
		+ ", poblacion=" + poblacion + ", edad=" + edad + ", email="
		+ email + ", dni=" + dni + ", cargo=" + cargo + "]";
    }

}
