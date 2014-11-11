package com.ipartek.formacion.primero.bean;

import java.util.ArrayList;

import com.ipartek.formacion.primero.util.Utilidades;

public class Persona {

	static final char SEXO_VARON = 'v';
	static final char SEXO_MUJER = 'm';
	static final char SEXO_OTROS = 'o';
	
	static final int MAYOR_EDAD = 18;
	
	static final String SIN_DETERMINAR = "Sin Determinar";
	
	//Atributos

	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String dni;
	private String poblacion;
	private boolean mayoredad = false;
	private String telefono;
	private char sexo = 'o';
	private Libro libro;
	private ArrayList<Libro> Libros;
	
	
	//Constructores
	
		//Constructor vacio
	
			public Persona() {
				super();
			}
	
		//Constructor con varios parametros (en este caso 3)
	
			public Persona(String nombre, String apellido1, String apellido2) {
				super();
				//Llamamos a los setters para poder tener un control sobre lo que se introduce
				setNombre(nombre);
				setApellido1(apellido1);
				setApellido2(apellido2);
				
			}
			
	
	//Getters


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if("".equals(nombre) || nombre == null){
			this.nombre = SIN_DETERMINAR;
		}else{
			this.nombre = nombre;
		}
		
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		if("".equals(apellido1) || apellido1 == null ){
			this.apellido1 = SIN_DETERMINAR;
		}else{
			this.apellido1 = apellido1;
		}
		
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		if("".equals(apellido2) || apellido2 == null){
			this.apellido2 = SIN_DETERMINAR;
		}else{
			this.apellido2 = apellido2;
		}
		
	}

	public int getEdad() {
		return edad;
	}
	
	public ArrayList<Libro> getLibros(){
		return Libros;
	}
	
	//Setters

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if(Utilidades.comprobarDni(dni)){
			//El dni es correcto
			this.dni = dni;
		}else{
			//El dni es incorrecto
			this.dni = SIN_DETERMINAR;
		}
		
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		if("".equals(poblacion) || poblacion == null){
			this.poblacion = SIN_DETERMINAR;
		}else{
			this.poblacion = poblacion;
		}
		
	}

	public boolean isMayoredad() {
		return mayoredad;
	}

	public void setMayoredad(boolean mayoredad) {
		this.mayoredad = mayoredad;
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
		if(sexo != SEXO_VARON && sexo != SEXO_MUJER && sexo != SEXO_OTROS){
			this.sexo = SEXO_OTROS;
		}
		this.sexo = sexo;
	}

	
	
	
	
	
	//Metodos
	
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + ", dni="
				+ dni + ", poblacion=" + poblacion + ", mayoredad=" + mayoredad
				+ ", telefono=" + telefono + ", sexo=" + sexo + "]";
	}
	
}
