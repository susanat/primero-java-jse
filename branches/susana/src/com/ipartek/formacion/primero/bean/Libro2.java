package com.ipartek.formacion.primero.bean;

public class Libro2 {

	// Atributos

	private int paginas;
	private String titulo;
	
	// Constructores

	// vacio
	public Libro2() {
		super();
		this.paginas = 0;
		this.titulo = "Sin definir";
	}

	// con parametros

	public Libro2(int paginas, String titulo) {
		super();
		this.paginas = paginas;
		this.titulo = titulo;
	}

	// Getters y setters

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if ("".equalsIgnoreCase(titulo)) {
			this.titulo = "Sin determinar";
		}else {
			this.titulo = titulo;
		}
	}

	// Métodos

	@Override
	public String toString() {
		return "Libro [paginas=" + paginas + ", titulo=" + titulo + "]";
	}

}
