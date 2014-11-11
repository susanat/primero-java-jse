package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Calendar;
import java.util.HashMap;


public class Alumno {

	private HashMap<String,Integer> calificaciones;

	public Alumno() {
		super();
	}
	public Alumno(String nombre, String p_apellido, String s_apellido,
			String dni, String poblacion, Calendar f_nacimiento,
			String telefono, char sexo, Boolean trabajando, Integer n_hermanos,Libro libro) {
		super();

	}
	public HashMap<String, Integer> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(HashMap<String, Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}	
}
