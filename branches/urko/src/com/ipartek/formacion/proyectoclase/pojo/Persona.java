package com.ipartek.formacion.proyectoclase.pojo;

import java.util.Calendar;


public class Persona {
	protected String nombre;
	protected String p_apellido;
	protected String s_apellido;
	protected String dni;
	protected String poblacion;
	protected Calendar f_nacimiento;
	protected String telefono;
	protected Character sexo;
	protected Boolean trabajando;
	protected Integer n_hermanos;
	protected Libro libro;
	
	public static final Integer MIN_HERMANOS = 0;
	
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
		setNombre("");
		setP_apellido("");
		setS_apellido ("");
		setDni("");
		setPoblacion("");
		setF_nacimiento(Calendar.getInstance());
		setTelefono("");
		setSexo('v');
		setTrabajando(false);
		setN_hermanos(MIN_HERMANOS);
		setLibro(new Libro());
		
	}
	
	public Persona(String nombre, String p_apellido, String s_apellido,
			String dni, String telefono) {
		super();
		this.nombre = nombre;
		this.p_apellido = p_apellido;
		this.s_apellido = s_apellido;
		this.dni = dni;
		this.telefono = telefono;
	}

	public Persona(String nombre, String p_apellido, String s_apellido,
			String dni, String poblacion, Calendar f_nacimiento,
			String telefono, Character sexo, Boolean trabajando,
			Integer n_hermanos, Libro libro) {
		super();
		setNombre(nombre);
		setP_apellido(p_apellido);
		setS_apellido (s_apellido);
		setDni(dni);
		setPoblacion(poblacion);
		setF_nacimiento(f_nacimiento);
		setTelefono(telefono);
		setSexo(sexo);
		setTrabajando(trabajando);
		setN_hermanos(n_hermanos);
		setLibro(libro);
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
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

	public Integer getN_hermanos() {
		return n_hermanos;
	}

	public void setN_hermanos(Integer n_hermanos) {
		if(n_hermanos>=MIN_HERMANOS)
		this.n_hermanos = n_hermanos;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
}
