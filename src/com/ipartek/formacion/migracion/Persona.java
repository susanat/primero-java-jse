package com.ipartek.formacion.migracion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aeat.valida.Validador;

public class Persona {
    private static final int CANTIDAD_ATRIBUTOS = 4;

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

    // metodos

    public boolean comprobarEdad() {
	boolean correcto = false;
	if (this.edad >= 18 || this.edad <= 99) {
	    correcto = true;
	}
	return correcto;
    }

    public boolean comprobarDni() {
	boolean comprobado = false;
	Validador validador = new Validador();
	int e = validador.checkNif(this.dni);

	if (e > 0) {
	    comprobado = true;
	}
	return comprobado;

    }

    public boolean comprobarEmail() {
	// Compilar la expresión regular dada en un patron.
	Pattern pattern = Pattern.compile(Migracion.PATTERN_EMAIL);

	// Compueba el email dado contra el patron
	Matcher matcher = pattern.matcher(this.email);
	return matcher.matches();
    }

    public boolean comprobarCaracteresExtraños() {
	int indice = 0;
	boolean fallo = false;

	Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");
	Matcher encaja;
	String[] atr = new String[] { this.nombre, this.apellido,
		this.poblacion, this.categoria };

	while (fallo == false && indice < CANTIDAD_ATRIBUTOS) {
	    encaja = pattern.matcher(atr[indice]);
	    // Mira si el string encaja con el patron que
	    if (encaja.find()) {
		fallo = true;
	    }
	    indice++;
	}
	return fallo;
    }

}
