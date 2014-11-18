package com.ipartek.formacion.proyectoclase.pojo;

public class Libro {
	// atributos
	private String codlibro;
	private String isbn;
	private String autor;
	private String titulo;
	private Integer npaginas;

	// contructores
	public Libro() {// vacio
		super();
		this.codlibro = "0";
		this.isbn = "0";
		this.titulo = "sin definir";
		this.autor = new String("");
		this.npaginas = new Integer(0);

	}

	public Libro(String codlibro, String titulo, String isbn, String autor,
			Integer npaginas) {// parametros
		super();
		this.codlibro = codlibro;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.npaginas = npaginas;
	}

	// metodos

	@Override
	public String toString() {
		return "Libro [cod_libro=" + codlibro + ", isbn=" + isbn + ", autor="
				+ autor + ", npaginas=" + npaginas + "]";
	}

	// getters setters
	public String getIsbn() {

		return isbn;
	}

	public void setIsbn(String isbn) {
		if (!"".equalsIgnoreCase(isbn)) {
			this.isbn = isbn;
		}
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (!"".equalsIgnoreCase(autor)) {
			this.autor = autor;
		}
	}

	public Integer getNpaginas() {
		return npaginas;
	}

	public void setNpaginas(Integer npaginas) {
		if (npaginas > 0) {
			this.npaginas = npaginas;
		}
	}

	public String getCodlibro() {
		return codlibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	};

}
