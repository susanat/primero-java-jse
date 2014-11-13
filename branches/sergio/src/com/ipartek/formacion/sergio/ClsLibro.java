package com.ipartek.formacion.sergio;

public class ClsLibro{
	
	private String titulo;
	private String descripcion;
	private int paginas;
		
	public ClsLibro(String titulo, String descripcion, int paginas) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.paginas = paginas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	
	
	
}



