package com.ipartek.formacion.primero.bean;

/**
 * Clase para representar un {@link Libro} la cual se compone de los siguientes
 * atributos:
 * <ul>
 * <li>{@code int} <b>paginas</b> Numero de paginas</li>
 * <li>{@code String} <b>titulo</b> Titulo</li>
 * <ul>
 *
 * @author ur00
 * @since v1.0
 */
public class Libro {

	// atributos
	/**
	 * {@code int} Numero de paginas del {@code Libro}
	 */
	private int paginas;

	/**
	 * {@code String} Titulo del {@code Libro}
	 */
	private String titulo;

	// constructor vacio
	/**
	 * Constructor vacio para {@code Libro}. Parametros iniciales de los
	 * atributos
	 * <ul>
	 * <li>paginas = 0</li>
	 * <li>titulo = "Sin definir"</li>
	 * </ul>
	 */
	public Libro() {
		super();
		this.paginas = 0;
		this.titulo = "Sin definir";
	}

	// construcor con parametros

	public Libro(int _paginas, String _titulo) {
		super();
		this.paginas = _paginas;
		this.titulo = _titulo;
	}

	// gettter y setters

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(final int _paginas) {
		this.paginas = _paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String _titulo) {

		if ("".equalsIgnoreCase(_titulo)) {
			this.titulo = "Sin Determinar";
		} else {
			this.titulo = _titulo;
		}
	}

	// metodos
	@Override
	public String toString() {
		return "Libro [paginas=" + paginas + ", titulo=" + titulo + "]";
	}

}
