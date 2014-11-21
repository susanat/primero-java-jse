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
	this.autor = "";
	this.npaginas = 0;

    }

    public Libro(final String pcodlibro, final String ptitulo,
	    final String pisbn, final String pautor, final Integer pnpaginas) {// parametros
	super();
	this.codlibro = pcodlibro;
	this.isbn = pisbn;
	this.titulo = ptitulo;
	this.autor = pautor;
	this.npaginas = pnpaginas;
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

    public void setIsbn(final String isbn) {
	if (!"".equalsIgnoreCase(isbn)) {
	    this.isbn = isbn;
	}
    }

    public String getAutor() {
	return autor;
    }

    public void setAutor(final String pautor) {
	if (!"".equalsIgnoreCase(pautor)) {
	    this.autor = pautor;
	}
    }

    public Integer getNpaginas() {
	return npaginas;
    }

    public void setNpaginas(final Integer npaginas) {
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

    public void setTitulo(final String titulo) {
	this.titulo = titulo;
    };

}
