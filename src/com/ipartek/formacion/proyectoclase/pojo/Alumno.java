package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Calendar;
import java.util.HashMap;


public class Alumno {
	private String nombre;
	private String p_apellido;
	private String s_apellido;
	private String dni;
	private String poblacion;
	private Calendar f_nacimiento;
	private String telefono;
	private char sexo;
	private Boolean trabajando;
	private Integer n_hermanos;
	private Libro libro;
	private HashMap<String,Integer> calificaciones;

	public Alumno() {
		super();
		this.nombre 		= "";
		this.p_apellido 	= "";
		this.s_apellido 	= "";
		this.dni 			= "";
		this.poblacion 		= "";
		this.f_nacimiento 	= Calendar.getInstance();
		this.telefono 		= "";
		this.sexo 			= ' ';
		this.trabajando 	= false;
		this.n_hermanos 	= 0;
		this.libro			= new Libro();
	}
	public Alumno(String nombre, String p_apellido, String s_apellido,
			String dni, String poblacion, Calendar f_nacimiento,
			String telefono, char sexo, Boolean trabajando, Integer n_hermanos,Libro libro) {
		super();
		this.nombre 		= nombre;
		this.p_apellido 	= p_apellido;
		this.s_apellido 	= s_apellido;
		this.dni 			= dni;
		this.poblacion 		= poblacion;
		this.f_nacimiento	= f_nacimiento;
		this.telefono 		= telefono;
		this.sexo 			= sexo;
		this.trabajando 	= trabajando;
		this.n_hermanos 	= n_hermanos;
		this.libro			= libro;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", p_apellido=" + p_apellido
				+ ", s_apellido=" + s_apellido + ", dni=" + dni
				+ ", poblacion=" + poblacion + ", f_nacimiento=" + f_nacimiento.toString()
				+ ", telefono=" + telefono + ", sexo=" + sexo + ", trabajando="
				+ trabajando + ", n_hermanos<=" + n_hermanos + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getP_apellido() {
		return p_apellido;
	}
	public void setP_apellido(String p_apellido) {
		this.p_apellido = p_apellido;
	}
	public String getS_apellido() {
		return s_apellido;
	}
	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
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
	public Calendar getF_nacimiento() {
		return f_nacimiento;
	}
	public void setF_nacimiento(Calendar f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Boolean getTrabajando() {
		return trabajando;
	}
	public void setTrabajando(Boolean trabajando) {
		this.trabajando = trabajando;
	}
	public Integer getN_hermanos() {
		return n_hermanos;
	}
	public void setN_(Integer n_hermanos) {
		this.n_hermanos = n_hermanos;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setN_hermanos(Integer n_hermanos) {
		this.n_hermanos = n_hermanos;
	}

	
	
	
	
	
	
	
	
}
