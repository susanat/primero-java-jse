package com.ipartek.formacion.proyectoclase.pojo;

public class Libro {
	//atributos
	private String cod_libro;
	private String isbn;
	private String autor;
	private String titulo;
	private Integer n_paginas;

	
	//contructores
	public Libro(){//vacio
		super();
		this.cod_libro	=	"0";
		this.isbn		=	"0";
		this.titulo		=	"sin definir";
		this.autor		=	new String("");
		this.n_paginas	=	new Integer(0);
		
	}
	public Libro(String cod_libro,String titulo ,String isbn, String autor, Integer n_paginas) {//parametros
		super();
		this.cod_libro = cod_libro;
		this.isbn = isbn;
		this.titulo	= titulo;
		this.autor = autor;
		this.n_paginas = n_paginas;
	}

	
	
	//metodos
	
	@Override
	public String toString() {
		return "Libro [cod_libro=" + cod_libro + ", isbn=" + isbn + ", autor="
				+ autor + ", n_paginas=" + n_paginas + "]";
	}
	
	//getters setters
	public String getIsbn() {
		
		return isbn;
	}
	public void setIsbn(String isbn) {
		if(!"".equalsIgnoreCase(isbn)){
			this.isbn = isbn;
		}
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		if(!"".equalsIgnoreCase(autor)){
			this.autor = autor;
		}
	}
	public Integer getN_paginas() {
		return n_paginas;
	}
	public void setN_paginas(Integer n_paginas) {
		if(n_paginas>0){
			this.n_paginas = n_paginas;
		}
	}
	public String getCod_libro() {
		return cod_libro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	};
	
}
