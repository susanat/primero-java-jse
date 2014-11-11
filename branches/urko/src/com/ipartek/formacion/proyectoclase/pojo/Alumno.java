package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Calendar;
import java.util.HashMap;


public class Alumno extends Persona{

	private HashMap<String,Integer> calificaciones;

	public Alumno() {
		super();
	}
	
	public Alumno(String nombre, String p_apellido, String s_apellido,
			String dni, String telefono) {
		super(nombre, p_apellido, s_apellido, dni, telefono);
		// TODO Auto-generated constructor stub
	}

	public Alumno(String nombre, String p_apellido, String s_apellido,
			String dni, String poblacion, Calendar f_nacimiento,
			String telefono, char sexo, Boolean trabajando, Integer n_hermanos,Libro libro,HashMap<String,Integer>calificaciones) {
		super(nombre,p_apellido,s_apellido,dni,poblacion,f_nacimiento,telefono,sexo,trabajando,
				n_hermanos,libro);
		setCalificaciones(calificaciones);
	}
	public HashMap<String, Integer> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(HashMap<String, Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}	
}
