package com.ipartek.formacion.primero.bean;

/**
 * Clase para representar un {@link Libro} la cual se compone de los siguientes atributos:
 * <ul>
 * 	<li>{@code int} <b>paginas</b> Numero de paginas </li>
 *  <li>{@code String} <b>titulo</b> Titulo </li>
 * <ul> 
 * 
 * @author ur00
 * @since  v1.0
 */
public class Libro {

	//atributos
	/**
	 * {@code int} Numero de paginas del {@code Libro}
	 */
	private int paginas;
	
	/**
	 * {@code String} Titulo del {@code Libro}
	 */
	private String titulo;
	
	/**
	 * Numero de paginas que tiene por defecto un libro
	 */
	public static final int NUM_PAGINAS_POR_DEFECTO = 0;
	
	/**
	 * Titulo que tiene por defecto un libro
	 */
	public static final String TITULO_POR_DEFECTO ="Sin definir";
	
	//constructor vacio
	/**
	 * Constructor vacio para {@code Libro}.
	 * Parametros iniciales de los atributos
	 * <ul>
	 * 	<li>paginas = 0</li>
	 *  <li>titulo  = "Sin definir"</li>
	 * </ul>
	 */
	public Libro() {
		super();
		setPaginas(NUM_PAGINAS_POR_DEFECTO);
		setTitulo(TITULO_POR_DEFECTO);
	}
	
	//construcor con parametros
	
	public Libro(int paginas, String titulo) {
		super();
		setPaginas(paginas);
		setTitulo(titulo);
	}

		
	
	//gettter y setters
	
	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		if (paginas<=NUM_PAGINAS_POR_DEFECTO){
			this.paginas = NUM_PAGINAS_POR_DEFECTO;
		}else{
			this.paginas = paginas;
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		
		if ( titulo.isEmpty()){	
			this.titulo = TITULO_POR_DEFECTO;
		}else{
			this.titulo = titulo;
		}	
	}
	
	
	
	//metodos
	@Override
	public String toString() {
		return "Libro [paginas=" + paginas + ", titulo=" + titulo + "]";
	}

	

	
}
